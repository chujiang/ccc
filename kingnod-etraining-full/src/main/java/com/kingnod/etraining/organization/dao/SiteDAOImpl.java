package com.kingnod.etraining.organization.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.etraining.activity.dao.ActivityFolderDAO;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.dao.BulletinDAO;
import com.kingnod.etraining.common.entity.Bulletin;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
public class SiteDAOImpl extends MybatisEntityDAO<Site, Long> implements SiteDAO {
	
	@Autowired
	protected ActivityFolderDAO activityFolderDAO;
	@Autowired
	protected OrganizationDAO organizationDAO;
	@Autowired
	protected ResourceFolderDAO resourceFolderDAO;
	@Autowired
	protected UserDAO userDAO;
	@Autowired
	protected BulletinDAO bulletinDAO;
	@Autowired
	protected UserGroupDAO userGroupDAO;
	
	
	@Override
	protected void beforeInsert(Site entity) {
		Site parentEntity = get(entity.getParentId());
		int levelNumber = null == parentEntity ? 0 : parentEntity.getLevelNumber();
		entity.setLevelNumber(levelNumber + 1);
	}
	
	@Override
	protected void beforeDelete(Long... ids) {
			for(Serializable id:ids){
				int count = 0;
				// 站点
				CriteriaBuilder cb = Cnd.builder(Site.class);
				cb.andEQ("parentId", id);
				int siteCount = countByCriteria(cb.buildCriteria());
				// 活动
				cb = Cnd.builder(ActivityFolder.class);
				cb.andEQ("siteId", id).andNotEQ("type", ObjectType.A_OS);
				int actCount = activityFolderDAO.countByCriteria(cb.buildCriteria());
				// 资源
				cb = Cnd.builder(ResourceFolder.class);
				cb.andEQ("siteId", id).andNotEQ("type", ObjectType.R_OS).andNotEQ("name", "课程体系管理");
				int resCount = resourceFolderDAO.countByCriteria(cb.buildCriteria());
				if(resCount==0){
					cb = Cnd.builder(ResourceFolder.class);
					cb.andEQ("siteId", id).andEQ("type", ObjectType.R_SF).andEQ("name", "课程体系管理");
					resourceFolderDAO.deleteByCriteria(cb.buildCriteria());
				}
				// 组织
				cb = Cnd.builder(Organization.class);
				cb.andEQ("siteId", id).andNotEQ("type", ObjectType.O_OS);
				int orgCount = organizationDAO.countByCriteria(cb.buildCriteria());
				//用户
				cb = Cnd.builder(User.class);
				cb.andEQ("siteId", id);
				int userCount = userDAO.countByCriteria(cb.buildCriteria());
				//用户组
				cb = Cnd.builder(UserGroup.class);
				cb.andEQ("siteId", id);
				int userGroupCount = userGroupDAO.countByCriteria(cb.buildCriteria());
				//公告
				cb = Cnd.builder(Bulletin.class);
				cb.andEQ("objectId", id).andEQ("objectType", ObjectType.O_OS);
				int bulletinCount = bulletinDAO.countByCriteria(cb.buildCriteria());
				count = siteCount + actCount + resCount + orgCount+userCount+userGroupCount+bulletinCount;
				if (count > 0) {
					throw Exceptions.createAppException("cmn002002");
				}
			}
	}
	
	public List<Site> findTopLevelByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findTopLevelByCriteria"),criteria);
	}

}