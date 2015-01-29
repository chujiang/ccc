package com.kingnod.etraining.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Logic;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.dao.ActivityFolderDAO;
import com.kingnod.etraining.activity.dao.ActivityFolderHierarchyDAO;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.entity.ActivityFolderHierarchy;
import com.kingnod.etraining.activity.service.ActivityFolderService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.security.PermisssionService;

@org.springframework.stereotype.Service
public class ActivityFolderServiceImpl implements ActivityFolderService {

	@Autowired
	protected ActivityFolderDAO activityFolderDAO;

	@Autowired
	protected ActivityFolderHierarchyDAO activityFolderHierarchyDAO;

	@Autowired
	protected SiteDAO siteDao;

	@Autowired
	protected SiteService siteService;

	@Autowired
	private PermisssionService permisssionService;

	public ActivityFolder getActivityFolder(Long id) {
		return activityFolderDAO.get(id);
	}

	public int saveActivityFolder(ActivityFolder activityFolder) {
		int count = 0;
		int nameCount = 0;
		CriteriaBuilder countCb = Cnd.builder(ActivityFolder.class);
		countCb.andEQ("type", activityFolder.getType());
		countCb.andEQ("PARENT_ID", activityFolder.getParentId());
		IdEntity<Long> idEntity = (IdEntity) activityFolder;
		if (null != idEntity.getId() && null != activityFolderDAO.get(idEntity.getId())) {
			countCb.andNotEQ("id", activityFolder.getId());
			countCb.andEQ("name", activityFolder.getName());
			nameCount = activityFolderDAO.countByCriteria(countCb.buildCriteria());
			if (nameCount > 0) {
				throw Exceptions.createAppException("aty001005");
			} else {
				CriteriaBuilder resParentCb = Cnd.builder(ActivityFolder.class);
				resParentCb.andEQ("type", activityFolder.getType()).andEQ("site_id", activityFolder.getSiteId());
				int i = activityFolderDAO.countByCriteria(resParentCb.buildCriteria());
				ActivityFolder activityModule = activityFolderDAO.get(idEntity.getId());
				if (i > 0) {
					if (activityModule.getType().equals(activityFolder.getType())) {
						count = activityFolderDAO.update(activityFolder);
					} else {
						throw Exceptions.createAppException("res003002");
					}

				} else {
					count = activityFolderDAO.update(activityFolder);
				}
			}
		} else {
			countCb.andEQ("name", activityFolder.getName());
			nameCount = activityFolderDAO.countByCriteria(countCb.buildCriteria());
			if (nameCount > 0) {
				throw Exceptions.createAppException("aty001005");
			} else {
				if (activityFolder.getType().name().startsWith("A_") && activityFolder.getType().name().endsWith("M")) {
					CriteriaBuilder resParentCb = Cnd.builder(ActivityFolder.class);
					resParentCb.andEQ("type", activityFolder.getType()).andEQ("site_id", activityFolder.getSiteId());
					int i = activityFolderDAO.countByCriteria(resParentCb.buildCriteria());
					if (i > 0) {
						throw Exceptions.createAppException("res003002");
					} else {
						activityFolder.setFolderCount(0L);
						activityFolder.setObjectCount(0L);
						count = activityFolderDAO.insert(activityFolder);
						// permisssionService.saveReadAthority(new
						// EntityObject(activityFolder.getId().intValue(),
						// activityFolder.getType()), "U", userDetails.getId());
					}
				} else {
					activityFolder.setFolderCount(0L);
					activityFolder.setObjectCount(0L);
					count = activityFolderDAO.insert(activityFolder);
					// permisssionService.saveReadAthority(new
					// EntityObject(activityFolder.getId().intValue(),
					// activityFolder.getType()), "U", userDetails.getId());
				}
			}
		}
		return count;
	}

	public int deleteActivityFolder(ActivityFolder activityFolder) {
		// permisssionService.removeReadAthority(new
		// EntityObject(activityFolder.getId().intValue(),
		// activityFolder.getType()));
		return activityFolderDAO.delete(activityFolder);
	}

	public int deleteActivityFolderByIds(Long[] ids) {
		int cnt = 0;
		for (int i = 0; i < ids.length; i++) {
			cnt += activityFolderDAO.deleteById(ids[i]);
		}
		return cnt;
	}

	public PagingResult<ActivityFolder> findActivityFolder(Criteria criteria) {
		return activityFolderDAO.findPagingResult(criteria);
	}

	public List<ActivityFolder> findTopLevelResourceFolder(ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ActivityFolder.class);

		Criteria criteria = criteriaBuilder.buildCriteria();

		permisssionService.addPermissionParams(criteria, types);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}

		return activityFolderDAO.findTopLevelByCriteria(criteria);
	}

	public List<ActivityFolder> findChildsResourceFolder(Long folderId, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ActivityFolder.class);

		criteriaBuilder.andEQ("parentId", folderId);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}

		return activityFolderDAO.findByCriteria(criteriaBuilder.buildCriteria());
	}

	public List<ActivityFolder> findAllReadByCriteria(Long folderId, String foldeNameKeyword, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ActivityFolder.class);

		if (!StringUtils.isEmpty(foldeNameKeyword)) {
			foldeNameKeyword = TagUtils.filterString(foldeNameKeyword);
			criteriaBuilder.addParam("foldeNameKeyword", "%" + foldeNameKeyword + "%");
		}

		// if(!StringUtils.isEmpty(foldeNameKeyword)){
		// criteriaBuilder.andLike("name", foldeNameKeyword);
		// }
		criteriaBuilder.orderBy("name", Order.ASC);
		criteriaBuilder.andEQ("recordStatus", RecordStatus.ACTIVE);

		Criteria criteria = criteriaBuilder.buildCriteria();

		if (null != folderId) {
			criteria.addParam("folderId", folderId);
		}
		criteria.addParam("columnName", "Y.FOLDER_ID");
		criteria.addParam("hierarchyTableName", "ATY_FOLDER_HIERARCHY");
		permisssionService.addPermissionParams(criteria, types);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}

		return activityFolderDAO.findAllReadByCriteria(criteria);
	}

	private CriteriaBuilder getTypesCriteriaBuilder(ObjectType... types) {
		if (null != types && types.length > 0) {
			CriteriaBuilder folderTypeCb = Cnd.builder(ResourceFolder.class);
			for (ObjectType objtype : types) {
				if (objtype.name().charAt(2) == '_') {
					String entityType = objtype.name();
					entityType = objtype.name().substring(0, 2);
					entityType = entityType + "%";
					entityType = entityType + objtype.name().substring(3, objtype.name().length());
					folderTypeCb.add(Cnd.like(Logic.OR, "type", entityType));
				} else if (objtype.name().endsWith("_")) {
					String entityType = objtype.name();
					entityType = entityType.substring(0, entityType.length() - 1);
					entityType = entityType + "%";
					folderTypeCb.add(Cnd.like(Logic.OR, "type", entityType));
				} else {
					folderTypeCb.orEQ("type", objtype.name());
				}
			}
			return folderTypeCb;
		}
		return null;
	}

	public boolean checkResourceFolderReadPermission(Long folderId) {
		return true;
	}

	public void moveActivityFolder(Long sourceId, Long targetId, String moveType) {
		ActivityFolder srcNode = this.getActivityFolder(sourceId);
		ActivityFolder srcParentNode = this.getActivityFolder(srcNode.getParentId());
		ActivityFolder targetNode = this.getActivityFolder(targetId);
		
		srcNode.setParentId(targetId);
		srcNode.setSiteId(targetNode.getSiteId());
		
		this.saveActivityFolder(srcNode);
		
		//更新目标节点的子节点数
		CriteriaBuilder cb = Cnd.builder(ActivityFolder.class);
		cb.andEQ("id", targetNode.getId());
		activityFolderDAO.updateFolderCount(cb.buildCriteria().addParam("updateObj", "self"));
		
		//更新目标节点的子节点数
		cb = Cnd.builder(ActivityFolder.class);
		cb.andEQ("id", srcParentNode.getId());
		activityFolderDAO.updateFolderCount(cb.buildCriteria().addParam("updateObj", "self"));
		
		//查询源节点所有的子节点
		cb = Cnd.builder(ActivityFolderHierarchy.class);
		cb.andEQ("hierarchyId", sourceId).andEQ("recordStatus", RecordStatus.ACTIVE);
		List<ActivityFolderHierarchy> resHierarchyList = activityFolderHierarchyDAO.findByCriteria(cb.buildCriteria());
		//删除源节点所有的子节点的层级数据
		for(ActivityFolderHierarchy atyFolderHierarchy:resHierarchyList){
			cb = Cnd.builder(ActivityFolderHierarchy.class);
			cb.andEQ("folderId", atyFolderHierarchy.getFolderId());
			activityFolderHierarchyDAO.deleteByCriteria(cb.buildCriteria());
		}
		//删除之后重新维护层级数据
		for(ActivityFolderHierarchy atyFolderHierarchy:resHierarchyList){
			ActivityFolder ActivityFolder = this.getActivityFolder(atyFolderHierarchy.getFolderId());
			activityFolderDAO.insertActivityFolderHierarchy(ActivityFolder);
		}		
	}

}