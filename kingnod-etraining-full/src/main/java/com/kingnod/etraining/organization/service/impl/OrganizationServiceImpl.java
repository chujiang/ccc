package com.kingnod.etraining.organization.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.dao.MenuDAO;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.kingnod.etraining.organization.dao.OrganizationDAO;
import com.kingnod.etraining.organization.dao.OrganizationHierarchyDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.OrganizationHierarchy;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.security.PermisssionService;

@org.springframework.stereotype.Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	protected OrganizationDAO organizationDAO;
	
	@Autowired
	protected OrganizationHierarchyDAO orgHierarchyDAO;

	@Autowired
	protected MenuDAO menuDAO;

	@Autowired
	private PermisssionService permisssionService;
	
	@Autowired
	protected SiteService siteService;

	public Organization getOrganization(Long id) {
		return organizationDAO.get(id);
	}

	public int saveOrganization(Organization organization) {
		return saveOrganization(organization, false);
	}
	
	public int saveOrganization(Organization organization, boolean isImport) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) organization;
		if (null != idEntity.getId() && null != organizationDAO.get(idEntity.getId())) {	//id不为空时，执行修改，否则为新增
			int nameCnt = organizationDAO.countByCriteria(Cnd
					.builder(Organization.class)
					.andEQ("PARENT_ID", organization.getParentId())
					.andEQ("siteId", organization.getSiteId())
					.andNotEQ("id", organization.getId())
					.andEQ("NAME", organization.getName())
					.buildCriteria());
			int shortNameCnt = organizationDAO.countByCriteria(Cnd
					.builder(Organization.class)
					.andEQ("PARENT_ID", organization.getParentId())
					.andEQ("siteId", organization.getSiteId())
					.andNotEQ("id", organization.getId())
					.andEQ("shortName", organization.getShortName())
					.buildCriteria());
			if(isImport) {
				if (nameCnt > 0) {
					return -1;
				}
				if (shortNameCnt > 0) {
					return -2;
				}
			} else {
				if (nameCnt > 0) {											//组织名称重复
					throw Exceptions.createAppException("res003004");
				} else if (shortNameCnt > 0) {								//组织编码重复
					throw Exceptions.createAppException("org001013");
				}
			}
			count = organizationDAO.update(organization);			//正常修改

		} else {
			int nameCnt = organizationDAO.countByCriteria(Cnd
					.builder(Organization.class)
					.andEQ("PARENT_ID", organization.getParentId())
					.andEQ("siteId", organization.getSiteId())
					.andEQ("NAME", organization.getName())
					.buildCriteria());
			int shortNameCnt = organizationDAO.countByCriteria(Cnd
					.builder(Organization.class)
					.andEQ("PARENT_ID", organization.getParentId())
					.andEQ("siteId", organization.getSiteId())
					.andEQ("shortName", organization.getShortName())
					.buildCriteria());
			if(isImport) {
				if (nameCnt > 0) {
					return -1;
				}
				if (shortNameCnt > 0) {
					return -2;
				}
			} else {
				if (nameCnt > 0) {
					throw Exceptions.createAppException("res003004");		//组织名称重复
				} else if (shortNameCnt > 0) {
					throw Exceptions.createAppException("org001013");		//组织编码重复
				}
			}
			organization.setType(ObjectType.O_OO);
			count = organizationDAO.insert(organization);			//正常新增
			
		}
		return count;
	}
	
	public int deleteOrganization(Organization organization) {
		int result = organizationDAO.delete(organization);
		return result;
	}

	public int deleteOrganizationByIds(Long[] ids) {
		int cnt = 0;
		for (int i = 0; i < ids.length; i++) {
			cnt += organizationDAO.deleteById(ids[i]);
		}

		return cnt;
	}

	public PagingResult<Organization> findOrganization(Criteria criteria) {
		return organizationDAO.findPagingResult(criteria);
	}

	public List<Organization> findTopLevelOrganization(ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(Organization.class);

		Criteria criteria = criteriaBuilder.buildCriteria();

		permisssionService.addPermissionParams(criteria, types);


		return organizationDAO.findTopLevelByCriteria(criteria);
	}
	
	public List<Organization> findAllReadByCriteria(Long organizationId, String foldeNameKeyword, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(Organization.class);
		
		if(!StringUtils.isEmpty(foldeNameKeyword)){
			foldeNameKeyword=TagUtils.filterString(foldeNameKeyword);
			criteriaBuilder.addParam("foldeNameKeyword", "%" + foldeNameKeyword + "%");
		}
		criteriaBuilder.orderBy("name", Order.ASC);
		criteriaBuilder.andEQ("recordStatus", RecordStatus.ACTIVE);
		Criteria criteria = criteriaBuilder.buildCriteria();
		if(null != organizationId){
			criteria.addParam("organizationId", organizationId);
		}
		criteria.addParam("columnName", "Y.ORGANIZATION_ID");
		criteria.addParam("hierarchyTableName", "ORG_ORGANIZATION_HIERARCHY");
		
		permisssionService.addPermissionParams(criteria, types);

		return organizationDAO.findAllReadByCriteria(criteria);
	}


	public List<Organization> findChildsOrganization(Long organizationId, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(Organization.class);
		
		criteriaBuilder.andEQ("parentId", organizationId);
		
		CriteriaBuilder folderTypeCb = Cnd.builder(Organization.class);
		for (ObjectType objtype : types) {
			folderTypeCb.orEQ("type", objtype.name());
		}
		criteriaBuilder.andGroup(folderTypeCb);

		return organizationDAO.findByCriteria(criteriaBuilder.buildCriteria());
	}

	public List<Organization> findAllObjectPickerByCriteria(Long organizationId, String foldeNameKeyword, String treeType, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(Organization.class);
		
		if(!StringUtils.isEmpty(foldeNameKeyword)){
			foldeNameKeyword=TagUtils.filterString(foldeNameKeyword);
			criteriaBuilder.addParam("foldeNameKeyword", "%" + foldeNameKeyword + "%");
			criteriaBuilder.addParam("treeType",  treeType);
		}
		criteriaBuilder.orderBy("name", Order.ASC);
		criteriaBuilder.andEQ("recordStatus", RecordStatus.ACTIVE);
		Criteria criteria = criteriaBuilder.buildCriteria();
		if(null != organizationId){
			criteria.addParam("organizationId", organizationId);
		}
		criteria.addParam("columnName", "Y.ORGANIZATION_ID");
		criteria.addParam("hierarchyTableName", "ORG_ORGANIZATION_HIERARCHY");
		
		permisssionService.addPermissionParams(criteria, types);

		return organizationDAO.findAllObjectPickerByCriteria(criteria);
	}
	
	//根据父组织id查询所有子组织id
	public List<Long> finAllChildsOrgById(Long organizationId) {
    List<Long> list = new ArrayList<Long>();
    
    CriteriaBuilder ctgCb = Cnd.builder(Organization.class);
    ctgCb.andEQ("B.hierarchy_id", organizationId);
    List<Organization> reslist = organizationDAO.finAllChildsOrgById(ctgCb.buildCriteria());
    for(Organization resF:reslist){
     list.add(resF.getId());
    }
    
    return list;
	}
	
	//重置组织的层级数据
	public void resetOrganizationHierarchy(Organization organization){
		//查询源节点所有的子节点
		//删除源节点所有的子节点的层级数据
		CriteriaBuilder orgHierCb = Cnd.builder(OrganizationHierarchy.class);
		orgHierCb.andEQ("organizationId", organization.getId());
		int count = orgHierarchyDAO.deleteByCriteria(orgHierCb.buildCriteria());
		//删除之后重新维护层级数据
		organizationDAO.insertOrganizationHierarchy(organization);
	}

	public void moveOrganization(Long sourceId, Long targetId, String moveType) {
		Organization srcNode = this.getOrganization(sourceId);
		Organization srcParentNode = this.getOrganization(srcNode.getParentId());
		Organization targetNode = this.getOrganization(targetId);
		
		srcNode.setParentId(targetId);
		srcNode.setSiteId(targetNode.getSiteId());
		
		this.saveOrganization(srcNode);
		
		//更新目标节点的子节点数
		CriteriaBuilder cb = Cnd.builder(Organization.class);
		cb.andEQ("id", targetNode.getId());
		organizationDAO.updateFolderCount(cb.buildCriteria().addParam("updateObj", "self"));
		
		//更新目标节点的子节点数
		cb = Cnd.builder(Organization.class);
		cb.andEQ("id", srcParentNode.getId());
		organizationDAO.updateFolderCount(cb.buildCriteria().addParam("updateObj", "self"));
		
		//查询源节点所有的子节点
		cb = Cnd.builder(OrganizationHierarchy.class);
		cb.andEQ("hierarchyId", sourceId).andEQ("recordStatus", RecordStatus.ACTIVE);
		List<OrganizationHierarchy> orgHierarchyList = orgHierarchyDAO.findByCriteria(cb.buildCriteria());
		//删除源节点所有的子节点的层级数据
		for(OrganizationHierarchy orgHierarchy:orgHierarchyList){
			cb = Cnd.builder(OrganizationHierarchy.class);
			cb.andEQ("organizationId", orgHierarchy.getOrganizationId());
			orgHierarchyDAO.deleteByCriteria(cb.buildCriteria());
		}
		//删除之后重新维护层级数据
		for(OrganizationHierarchy orgHierarchy:orgHierarchyList){
			Organization organization = this.getOrganization(orgHierarchy.getOrganizationId());
			organizationDAO.insertOrganizationHierarchy(organization);
		}
	}

	public void resetOrganizationCount(Long organizationId) {
		organizationDAO.resetOrganizationCount(organizationId);
	}

	public List<Organization> getOrganizationsForExport(Long siteId) {
		return organizationDAO.getOrganizationsForExport(siteId);
	}
	
}
