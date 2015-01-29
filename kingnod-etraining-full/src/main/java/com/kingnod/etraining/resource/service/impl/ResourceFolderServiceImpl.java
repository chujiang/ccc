package com.kingnod.etraining.resource.service.impl;

import java.util.ArrayList;
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
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.OrganizationHierarchy;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;
import com.kingnod.etraining.resource.dao.ResourceFolderHierarchyDAO;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.entity.ResourceFolderHierarchy;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.kingnod.etraining.security.PermisssionService;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Service
public class ResourceFolderServiceImpl implements ResourceFolderService {

	@Autowired
	protected ResourceFolderDAO resourceFolderDAO;

	@Autowired
	protected ResourceFolderHierarchyDAO resourceFolderHierarchyDAO;

	@Autowired
	protected SiteService siteService;

	@Autowired
	protected SiteDAO siteDAO;

	@Autowired
	private PermisssionService permisssionService;

	public ResourceFolder getResourceFolder(Long id) {
		return resourceFolderDAO.get(id);
	}

	public int saveResourceFolder(ResourceFolder resourceFolder) {
		UserAccount userDetails = SecurityUtils.getCurrentUser();
		int count = 0;
		int nameCount = 0;
		CriteriaBuilder countCb = Cnd.builder(ResourceFolder.class);
		countCb.andEQ("type", resourceFolder.getType());
		countCb.andEQ("PARENT_ID", resourceFolder.getParentId());
		IdEntity<Long> idEntity = (IdEntity) resourceFolder;
		if (null != idEntity.getId() && null != resourceFolderDAO.get(idEntity.getId())) {
			countCb.andNotEQ("id", resourceFolder.getId());
			countCb.andEQ("name", resourceFolder.getName());
			nameCount = resourceFolderDAO.countByCriteria(countCb.buildCriteria());
			if (nameCount > 0) {
				throw Exceptions.createAppException("res003004");
			} else {
				CriteriaBuilder resParentCb = Cnd.builder(ResourceFolder.class);
				resParentCb.andEQ("type", resourceFolder.getType()).andEQ("site_id", resourceFolder.getSiteId());
				int i = resourceFolderDAO.countByCriteria(resParentCb.buildCriteria());
				ResourceFolder resourceModule = resourceFolderDAO.get(idEntity.getId());
				if (i > 0) {
					if (resourceModule.getType().equals(resourceFolder.getType())) {
						count = resourceFolderDAO.update(resourceFolder);
					} else {
						throw Exceptions.createAppException("res003002");
					}
				} else {
					count = resourceFolderDAO.update(resourceFolder);
				}
			}
		} else {
			countCb.andEQ("name", resourceFolder.getName());
			nameCount = resourceFolderDAO.countByCriteria(countCb.buildCriteria());
			if (nameCount > 0) {
				throw Exceptions.createAppException("res003004");
			} else {
				if (resourceFolder.getType().name().startsWith("R_") && resourceFolder.getType().name().endsWith("M")) {
					CriteriaBuilder resParentCb = Cnd.builder(ResourceFolder.class);
					resParentCb.andEQ("type", resourceFolder.getType()).andEQ("site_id", resourceFolder.getSiteId());
					int i = resourceFolderDAO.countByCriteria(resParentCb.buildCriteria());
					if (i > 0) {
						throw Exceptions.createAppException("res003002");
					} else {
						resourceFolder.setFolderCount(0L);
						resourceFolder.setObjectCount(0L);
						count = resourceFolderDAO.insert(resourceFolder);
						// insertResourceFolderHierarchy(resourceFolder);
						// permisssionService.saveReadAthority(new
						// EntityObject(resourceFolder.getId().intValue(),
						// resourceFolder.getType()), "U", userDetails.getId());
					}
				} else {
					resourceFolder.setFolderCount(0L);
					resourceFolder.setObjectCount(0L);
					count = resourceFolderDAO.insert(resourceFolder);
					// insertResourceFolderHierarchy(resourceFolder);
					/*
					 * permisssionService.saveReadAthority( new
					 * EntityObject(resourceFolder.getId().intValue(),
					 * resourceFolder.getType()), "U", userDetails.getId());
					 */
				}
			}
		}
		return count;
	}

	public int deleteResourceFolder(ResourceFolder resourceFolder) {
		// permisssionService.removeReadAthority(new
		// EntityObject(resourceFolder.getId().intValue(),
		// resourceFolder.getType()));
		int result = resourceFolderDAO.delete(resourceFolder);
		return result;
	}

	public int deleteResourceFolderByIds(Long[] ids) {
		int cnt = 0;
		for (int i = 0; i < ids.length; i++) {
			cnt += resourceFolderDAO.deleteById(ids[i]);
		}
		return cnt;
	}

	public PagingResult<ResourceFolder> findResourceFolder(Criteria criteria) {
		return resourceFolderDAO.findPagingResult(criteria);
	}

	public List<ResourceFolder> findTopLevelResourceFolder(ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ResourceFolder.class);

		Criteria criteria = criteriaBuilder.buildCriteria();

		permisssionService.addPermissionParams(criteria, types);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}

		return resourceFolderDAO.findTopLevelByCriteria(criteria);
	}

	public List<ResourceFolder> findAllReadByCriteria(Long folderId, String foldeNameKeyword, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ResourceFolder.class);

		if (!StringUtils.isEmpty(foldeNameKeyword)) {
			foldeNameKeyword=TagUtils.filterString(foldeNameKeyword);
			criteriaBuilder.addParam("foldeNameKeyword", "%" + foldeNameKeyword + "%");
		}
		criteriaBuilder.andEQ("recordStatus", RecordStatus.ACTIVE);
		Criteria criteria = criteriaBuilder.buildCriteria();
		if (null != folderId) {
			criteria.addParam("folderId", folderId);
		}
		criteriaBuilder.orderBy("name", Order.ASC);
		criteria.addParam("columnName", "Y.FOLDER_ID");
		criteria.addParam("hierarchyTableName", "RES_FOLDER_HIERARCHY");
		permisssionService.addPermissionParams(criteria, types);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}

		return resourceFolderDAO.findAllReadByCriteria(criteria);
	}
	
	public List<ResourceFolder> findAllObjectPickerByCriteria(Long folderId, String foldeNameKeyword,String treeType, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ResourceFolder.class);

		if (!StringUtils.isEmpty(foldeNameKeyword)) {
			foldeNameKeyword=TagUtils.filterString(foldeNameKeyword);
			criteriaBuilder.addParam("foldeNameKeyword", "%" + foldeNameKeyword + "%");
			criteriaBuilder.addParam("treeType",  treeType);
		}
		criteriaBuilder.andEQ("recordStatus", RecordStatus.ACTIVE);
		Criteria criteria = criteriaBuilder.buildCriteria();
		if (null != folderId) {
			criteria.addParam("folderId", folderId);
		}
		criteriaBuilder.orderBy("name", Order.ASC);
		criteria.addParam("columnName", "Y.FOLDER_ID");
		criteria.addParam("hierarchyTableName", "RES_FOLDER_HIERARCHY");
		permisssionService.addPermissionParams(criteria, types);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}
		return resourceFolderDAO.findAllObjectPickerByCriteria(criteria);
	}

	public List<ResourceFolder> findChildsResourceFolder(Long folderId, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ResourceFolder.class);

		criteriaBuilder.andEQ("parentId", folderId);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}

		return resourceFolderDAO.findByCriteria(criteriaBuilder.buildCriteria());
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

	public List<TreeNode> getObjectTreeList() {
		List<TreeNode> result = new ArrayList<TreeNode>();

		return result;
	}

	// 查询首页课程分类树
	public List<TreeNode> getHomeCrsCategoryTreeList(Long userId, Long siteId) {
		List<TreeNode> treeList = new ArrayList<TreeNode>();

		CriteriaBuilder ctgCb = Cnd.builder(ResourceFolder.class);
		ctgCb.andEQ("siteId", siteId);
		List<String> list = new ArrayList<String>();
		list.add("" + ObjectType.R_SF + "");
		ctgCb.andIn("type", list);
		List<ResourceFolder> reslist = resourceFolderDAO.findByCriteria(ctgCb.buildCriteria());
		for (ResourceFolder res : reslist) {
			Long resId = res.getId();
			String name = res.getName();
			TreeNode treeNode = new TreeNode(resId + "", name, false);
			treeNode.setParentId(res.getParentId() + "");
			treeNode.setSrc("courseCenter/course-center.action?folderId="+resId);
			treeNode.setOpenMode(CommonConstant.WINDOW_OPEN_MODE_SELF);
			// treeNode.setTarget("LMSSCO");
			treeNode.setClick(true);

			String icon = "";
			if (isRootNode(reslist, res)) {
				icon = "images/CourseCatalog-01.png";
			} else {
				icon = "images/CourseCatalog-02.png";
			}

			treeNode.setIcon(icon);
			treeNode.setOpen(true);
			treeList.add(treeNode);
		}

		return treeList;
	}

	private boolean isRootNode(List<ResourceFolder> reslist, ResourceFolder res) {
		boolean isRoot = false;
		Long parentId = res.getParentId();

		int parentCount = 0;
		for (ResourceFolder resTmp : reslist) {
			Long idTemp = resTmp.getId();
			if (idTemp.equals(parentId)) {
				parentCount = parentCount + 1;
			}
		}

		// 如果没有父节点则就是跟节点
		if (parentCount == 0) {
			isRoot = true;
		}

		return isRoot;
	}

	// 查询课程分类树
	public List<TreeNode> getCrsCategoryTreeList(Long userId, Long siteId) {
		List<TreeNode> treeList = new ArrayList<TreeNode>();

		CriteriaBuilder ctgCb = Cnd.builder(ResourceFolder.class);
		ctgCb.andEQ("siteId", siteId);
		List<String> list = new ArrayList<String>();
		list.add("" + ObjectType.R_SF + "");
		ctgCb.andIn("type", list);
		List<ResourceFolder> reslist = resourceFolderDAO.findByCriteria(ctgCb.buildCriteria());
		for (ResourceFolder res : reslist) {
			Long resId = res.getId();
			String name = res.getName();
			TreeNode treeNode = new TreeNode(resId + "", name, false);
			treeNode.setParentId(res.getParentId() + "");
			treeNode.setSrc("course-list.action?folderId=" + resId);
			treeNode.setOpenMode(CommonConstant.WINDOW_OPEN_MODE_TARGET);
			treeNode.setTarget("crsList");
			treeNode.setClick(true);
			String icon = "";
			if (isRootNode(reslist, res)) {
				icon = "../images/CourseCatalog-01.png";
			} else {
				icon = "../images/CourseCatalog-02.png";
			}
			treeNode.setIcon(icon);
			treeNode.setOpen(true);
			treeList.add(treeNode);
		}

		return treeList;
	}
	
	
//根据父节点获取所有子节点的id
  public List<Long> findAllChildsCrsCategoryById(Long folderId){
    List<Long> list = new ArrayList<Long>();
    
    CriteriaBuilder ctgCb = Cnd.builder(ResourceFolder.class);
    ctgCb.andEQ("type", "" + ObjectType.R_SF + "");
    ctgCb.andEQ("t.hierarchy_id", folderId);
    List<ResourceFolder> reslist = resourceFolderDAO.findAllChildsCrsCategoryById(ctgCb.buildCriteria());
    for(ResourceFolder resF:reslist){
     list.add(resF.getId());
    }
    
    return list;
  }

  public void moveResourceFolder(Long sourceId, Long targetId, String moveType) {
	  	ResourceFolder srcNode = this.getResourceFolder(sourceId);
	  	ResourceFolder srcParentNode = this.getResourceFolder(srcNode.getParentId());
	  	ResourceFolder targetNode = this.getResourceFolder(targetId);
		
		srcNode.setParentId(targetId);
		srcNode.setSiteId(targetNode.getSiteId());
		
		this.saveResourceFolder(srcNode);
		
		//更新目标节点的子节点数
		CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
		cb.andEQ("id", targetNode.getId());
		resourceFolderDAO.updateFolderCount(cb.buildCriteria().addParam("updateObj", "self"));
		
		//更新目标节点的子节点数
		cb = Cnd.builder(ResourceFolder.class);
		cb.andEQ("id", srcParentNode.getId());
		resourceFolderDAO.updateFolderCount(cb.buildCriteria().addParam("updateObj", "self"));
		
		//查询源节点所有的子节点
		cb = Cnd.builder(ResourceFolderHierarchy.class);
		cb.andEQ("hierarchyId", sourceId).andEQ("recordStatus", RecordStatus.ACTIVE);
		List<ResourceFolderHierarchy> resHierarchyList = resourceFolderHierarchyDAO.findByCriteria(cb.buildCriteria());
		//删除源节点所有的子节点的层级数据
		for(ResourceFolderHierarchy resFolderHierarchy:resHierarchyList){
			cb = Cnd.builder(ResourceFolderHierarchy.class);
			cb.andEQ("folderId", resFolderHierarchy.getFolderId());
			resourceFolderHierarchyDAO.deleteByCriteria(cb.buildCriteria());
		}
		//删除之后重新维护层级数据
		for(ResourceFolderHierarchy resFolderHierarchy:resHierarchyList){
			ResourceFolder resourceFolder = this.getResourceFolder(resFolderHierarchy.getFolderId());
			resourceFolderDAO.insertResourceFolderHierarchy(resourceFolder);
		}
  }

}