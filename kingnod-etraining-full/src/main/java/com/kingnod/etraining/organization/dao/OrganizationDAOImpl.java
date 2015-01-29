package com.kingnod.etraining.organization.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.dao.BulletinDAO;
import com.kingnod.etraining.common.entity.Bulletin;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.OrganizationHierarchy;
import com.kingnod.etraining.organization.entity.User;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-02-06 17:39")
public class OrganizationDAOImpl extends MybatisEntityDAO<Organization, Long> implements OrganizationDAO {

	@Autowired
	protected OrganizationHierarchyDAO orgHierarchyDAO;

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected BulletinDAO bulletinDAO;

	/**
	 * 维护文件夹， 父文件夹及祖父文件夹的关系
	 * 
	 * @param folder
	 */
	public void insertOrganizationHierarchy(Organization organization) {
		Organization hierarchyOrg = organization;
		int hierLevel = 0;
		while (null != hierarchyOrg) {
			OrganizationHierarchy orgHier = new OrganizationHierarchy();
			orgHier.setOrganizationId(organization.getId());
			orgHier.setHierarchyId(hierarchyOrg.getId());
			orgHier.setHierarchyLevel(hierLevel++);
			orgHierarchyDAO.insert(orgHier);
			if (null != hierarchyOrg.getParentId()) {
				hierarchyOrg = get(hierarchyOrg.getParentId());
			} else {
				hierarchyOrg = null;
			}
		}
	}

	private int deleteOrganizationHierarchy(Long organizationId) {
		CriteriaBuilder orgHierCb = Cnd.builder(OrganizationHierarchy.class);
		orgHierCb.andEQ("organizationId", organizationId);
		return orgHierarchyDAO.deleteByCriteria(orgHierCb.buildCriteria());
	}

	@Override
	protected void beforeInsert(Organization entity) {
		if (null != entity.getParentId()) {
			Organization parentEntity = get(entity.getParentId());
			int levelNumber = null == parentEntity ? 0 : parentEntity.getLevelNumber();
			entity.setLevelNumber(levelNumber + 1);
			entity.setObjectCount(0L);
			entity.setOrganizationCount(0L);
		}
	}

	@Override
	protected void afterInsert(Organization entity) {
		CriteriaBuilder cb = Cnd.builder(Organization.class);
		cb.andEQ("id", entity.getId());
		updateFolderCount(cb.buildCriteria().addParam("updateObj", "parent"));
		insertOrganizationHierarchy(entity);
	}

	@Override
	public void beforeDelete(Long... ids) {
		for (Long id : ids) {
			int count = 0;
			CriteriaBuilder cb = Cnd.builder(Organization.class);
			cb.andEQ("parentId", id);
			CriteriaBuilder usercb = Cnd.builder(User.class);
			usercb.andEQ("organizationId", id);
			CriteriaBuilder bulletincb = Cnd.builder(Bulletin.class);
			bulletincb.andEQ("objectId", id).andEQ("objectType", ObjectType.O_OO);
			int orgCount = countByCriteria(cb.buildCriteria());
			int userCount = userDAO.countByCriteria(usercb.buildCriteria());
			int bulletinCount = bulletinDAO.countByCriteria(bulletincb.buildCriteria());
			count = orgCount + count;
			if(userCount>0){
				throw Exceptions.createAppException("org001011");
			}
			if(bulletinCount>0){
				throw Exceptions.createAppException("org001012");
			}
			if (count > 0) {
				throw Exceptions.createAppException("org001003");
			}
		}
	}

	@Override
	protected void afterDelete(Long... ids) {
		for (Long id : ids) {
			deleteOrganizationHierarchy(id);
		}

		CriteriaBuilder cb = Cnd.builder(Organization.class);
		cb.andIn("id", ListUtils.of(ids));
		updateFolderCount(cb.buildCriteria().addParam("updateObj", "parent"));
	}

	public List<Organization> findTopLevelByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findTopLevelByCriteria"), criteria);
	}

	public List<Organization> findAllReadByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findAllReadByCriteria"), criteria);
	}

	public int updateObjectCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateObjectCount"), criteria);
	}

	public int updateFolderCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateFolderCount"), criteria);
	}

	public List<Organization> findAllObjectPickerByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findAllObjectPickerByCriteria"), criteria);
	}
	
	 /**
   * 根据父组织id查询所有子组织
   */
	public List<Organization> finAllChildsOrgById(Criteria criteria){
	  return getSqlSession().selectList(sqlId("finAllChildsOrgById"), criteria);
   }

	/**
	 * 根据组织id重设下属组织个数
	 */
	public void resetOrganizationCount(Long organizationId) {
		getSqlSession().update(sqlId("resetOrganizationCount"), organizationId);
	}

	/**
	 * 根据站点ID，获取要导出的组织列表
	 */
	public List<Organization> getOrganizationsForExport(Long siteId) {
		return getSqlSession().selectList(sqlId("getOrganizationsForExport"), siteId);
	}

	public List<Organization> findhierarchyByChildId(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findhierarchyByChildId"), criteria);
	}
	
}