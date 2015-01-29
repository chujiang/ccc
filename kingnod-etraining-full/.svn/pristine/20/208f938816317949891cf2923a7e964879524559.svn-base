package com.kingnod.etraining.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Logic;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.dao.ActivityFolderDAO;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.service.ActivityFolderService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.course.dao.CourseInfoDAO;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.exam.dao.QuestionDAO;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.dao.UserGroupDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.report.dao.ReportFolderDAO;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.kingnod.etraining.report.service.ReportFolderService;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.kingnod.etraining.security.PermisssionService;

@org.springframework.stereotype.Service
public class TreeServiceImpl implements TreeService {
	
	@Autowired
	protected SiteService siteService;
	
	@Autowired
	protected OrganizationService organizationService;
	
	@Autowired
	protected UserDAO userDAO;
	
	@Autowired
	protected UserGroupDAO userGroupDAO;
	
	@Autowired
    protected ResourceFolderService resourceFolderService;
	
	@Autowired
    protected ResourceFolderDAO resourceFolderDAO;
	
	@Autowired
    protected CourseInfoDAO courseInfoDAO;
	
	@Autowired
    protected QuestionDAO questionDAO;
	
	@Autowired
    protected ActivityFolderDAO activityFolderDAO;
	
	@Autowired
    protected ActivityFolderService activityFolderService;
	
	@Autowired
	protected PermisssionService permissionService;
	
	@Autowired
	protected ReportFolderService reportFolderService;
	
	@Autowired
	protected ReportFolderDAO reportFolderDAO;
	
	public List<Organization> getOrganizationViewChilds(Long organizationId, ObjectType... types){
		if(null == organizationId){
			List<Organization> organizations = organizationService.findTopLevelOrganization(types);
			return organizations;
		}else{
			return organizationService.findChildsOrganization(organizationId, types);
		}
	}
	
	public List<Organization> getOrganizationViewChilds(Long organizationId, String foldeNameKeyword, ObjectType... types){
		return organizationService.findAllReadByCriteria(organizationId, foldeNameKeyword, types);
	}
	
	public List<ResourceFolder> getResourceViewChilds(Long folderId, String foldeNameKeyword, ObjectType... types){
		return resourceFolderService.findAllReadByCriteria(folderId, foldeNameKeyword, types);
	}
	
	public List<ResourceFolder> getResourceViewChilds(Long id, ObjectType... types){
		if(null == id){
			List<ResourceFolder> resourceFolders = resourceFolderService.findTopLevelResourceFolder(types);
			return resourceFolders;
		}else{
			return resourceFolderService.findChildsResourceFolder(id, types);
		}
	}
	
	public List<ActivityFolder> getActivityViewChilds(Long folderId, String foldeNameKeyword, ObjectType... types){
		return activityFolderService.findAllReadByCriteria(folderId, foldeNameKeyword, types);
	}
	
	public List<ActivityFolder> getActivityViewChilds(Long id, ObjectType... types){
		if(null == id){
			List<ActivityFolder> actvityFolders = activityFolderService.findTopLevelResourceFolder(types);
			return actvityFolders;
		}else{
			return activityFolderService.findChildsResourceFolder(id, types);
		}
	}
	
	/*public List getResourceViewChilds(ObjectType type, Long id){
		List result = new ArrayList();
		if(null == type){
			return getChildsSiteBySiteId(null);
		}else if(ObjectType.O_OS.equals(type)){
			result.addAll(getChildsSiteBySiteId(id));
			result.addAll(getChildsResourceFolder(id, null, ObjectType.R__F));
		}else if(ObjectType.R_FF == type){
			result.addAll(getChildsResourceFolder(null, id, ObjectType.R__F));
		}else if(null != type){
			String matchType = type.name().substring(0, type.name().length() - 1);
			matchType = matchType + "_";
			result.addAll(getChildsResourceFolder(null, id, ObjectType.valueOf(matchType)));
		}else{
			result.addAll(getChildsResourceFolder(null, id, null));
		}
		return result;
	}*/
	
	/*public List getActivityViewChilds(ObjectType type, Long id){
		List result = new ArrayList();
		if(null == type){
			return getChildsSiteBySiteId(null);
		}else if(ObjectType.O_OS == type){
			result.addAll(getChildsSiteBySiteId(id));
			result.addAll(getChilsActivityFolder(id, null, ObjectType.A__F));
		}else if(ObjectType.A_FF == type){
			result.addAll(getChilsActivityFolder(null, id, ObjectType.A__F));
		}else if(null != type){
			String matchType = type.name().substring(0, type.name().length() - 1);
			matchType = matchType + "_";
			result.addAll(getChilsActivityFolder(null, id, ObjectType.valueOf(matchType)));
		}else{
			result.addAll(getChilsActivityFolder(null, id, ObjectType.A__F));
		}
		return result;
	}*/

	public List getChildsSiteBySiteId(Long siteId) {
		if(null == siteId){
			return siteService.findTopLevelSite();
		}else{
			return siteService.findChildsSite(siteId);
		}
	}

	/*public List getChildsOrganization(Long siteId, Long organizationId) {
		if(null == organizationId){
			return organizationService.findTopLevelOrganization(null);
		}else{
			return organizationService.findChildsOrganization(siteId, organizationId);
		}
		CriteriaBuilder organizationCb = Cnd.builder(Organization.class);
		if(null != siteId){
			organizationCb.andEQ("siteId", siteId);
		}
		if(null != organizationId){
			organizationCb.andEQ("parentId", organizationId);
		}else{
			organizationCb.andIsNull("parentId");
		}
		Criteria criteria = organizationCb.buildCriteria();
		permissionService.addPermissionParams(criteria, ObjectType.O_OO);
		return organizationDAO.findByCriteria(criteria);
	}*/

	public List getChildsUser(Long organizationId) {
		CriteriaBuilder userCb = Cnd.builder(User.class);
		userCb.andEQ("organizationId", organizationId);
		return userDAO.findByCriteria(userCb.buildCriteria());
	}

	public List getChildsUserGroup(Long siteId) {
		CriteriaBuilder userGroupCb = Cnd.builder(UserGroup.class);
		userGroupCb.andEQ("siteId", siteId);
		return userGroupDAO.findByCriteria(userGroupCb.buildCriteria());
	}
	
	/*public List getChildsResourceFolder(Long siteId, Long folderId, ObjectType... types) {
		CriteriaBuilder folderCb = Cnd.builder(ResourceFolder.class);
		if(null != siteId){
			folderCb.andEQ("siteId", siteId);
		}
		if(null != folderId){
			folderCb.andEQ("parentId", folderId);
		}else{
			folderCb.andIsNull("parentId");
		}
		
		//添加类型过滤条件
		if(null != types && types.length > 0){
			CriteriaBuilder folderTypeCb = Cnd.builder(ResourceFolder.class);
			for(ObjectType objtype:types){
				if(objtype.name().charAt(2) == '_'){
					String entityType = objtype.name();
					entityType = objtype.name().substring(0, 2);
					entityType = entityType + "%";
					entityType = entityType + objtype.name().substring(3, objtype.name().length());
					folderTypeCb.add(Cnd.like(Logic.OR,"type", entityType));
				}else if(objtype.name().endsWith("_")){
					String entityType = objtype.name();
					entityType = entityType.substring(0, entityType.length() - 1);
					entityType = entityType + "%";
					folderTypeCb.add(Cnd.like(Logic.OR,"type", entityType));
				}else{
					folderTypeCb.orEQ("type", objtype.name());
				}
			}
			folderCb.andGroup(folderTypeCb);
		}
		
		Criteria criteria = folderCb.buildCriteria();
		
		//添加权限过滤条件
		permissionService.addPermissionParams(criteria, types);
		return resourceFolderDAO.findByCriteria(criteria);
	}*/
	
	public List getChildsCourse(Long folderId) {
		CriteriaBuilder cb = Cnd.builder(CourseInfo.class);
		if(null != folderId){
			cb.andEQ("folderId", folderId);
		}else{
			cb.andIsNull("folderId");
		}
		return courseInfoDAO.findByCriteria(cb.buildCriteria());
	}
	
	public List getChildsQuestion(Long folderId) {
		CriteriaBuilder cb = Cnd.builder(Question.class);
		if(null != folderId){
			cb.andEQ("folderId", folderId);
		}else{
			cb.andIsNull("folderId");
		}
		return questionDAO.findByCriteria(cb.buildCriteria());
	}
	
	public List getAllChildsResourceFolder(Long siteId, Long folderId, ObjectType... types) {
		CriteriaBuilder folderCb = Cnd.builder(ResourceFolder.class);
		if(null != types && types.length > 0){
			folderCb.andIn("type", ListUtils.of(types));
		}
		return resourceFolderDAO.findByCriteria(folderCb.buildCriteria());
	}

	public List getChilsActivityFolder(Long siteId, Long folderId, ObjectType... types) {
		CriteriaBuilder folderCb = Cnd.builder(ResourceFolder.class);
		if(null != siteId){
			folderCb.andEQ("siteId", siteId);
		}
		if(null != folderId){
			folderCb.andEQ("parentId", folderId);
		}else{
			folderCb.andIsNull("parentId");
		}
		
		//添加文件夹类型过滤条件
		if(null != types && types.length > 0){
			CriteriaBuilder folderTypeCb = Cnd.builder(ResourceFolder.class);
			for(ObjectType objtype:types){
				if(objtype.name().charAt(2) == '_'){
					String entityType = objtype.name();
					entityType = objtype.name().substring(0, 2);
					entityType = entityType + "%";
					entityType = entityType + objtype.name().substring(3, objtype.name().length());
					folderTypeCb.add(Cnd.like(Logic.OR,"type", entityType));
				}else if(objtype.name().endsWith("_")){
					String entityType = objtype.name();
					entityType = entityType.substring(0, entityType.length() - 1);
					entityType = entityType + "%";
					folderTypeCb.add(Cnd.like(Logic.OR,"type", entityType));
				}else{
					folderTypeCb.orEQ("type", objtype.name());
				}
			}
			folderCb.andGroup(folderTypeCb);
		}
		
		Criteria criteria = folderCb.buildCriteria();
		
		//添加权限过滤条件
		permissionService.addPermissionParams(criteria, types);
		return activityFolderDAO.findByCriteria(criteria);
	}
	
	public List getChildsResourceFolder(Long siteId, Long folderId, ObjectType... types) {
		// 没实现
		return null;
	}

	public List<ReportFolder> getReportFolderViewChids(Long folderId, ObjectType... types) {
		if(null==folderId){
			List<ReportFolder> reportFolderList=reportFolderService.findTopLevelReportFolder(types);
			return reportFolderList;
			}else{
				return reportFolderService.findChildsReportFolder(folderId, types);
			}
		
	}

	public List<ReportFolder> getReportFolderViewChids(Long folderId, String foldeNameKeyword, ObjectType... types) {
		return reportFolderService.findAllReadByCriteria(folderId, foldeNameKeyword, types);
	}

	public List getChilsReportFolder(Long siteId, Long folderId, ObjectType... types) {
		CriteriaBuilder folderCb = Cnd.builder(ResourceFolder.class);
		if(null != types && types.length > 0){
			folderCb.andIn("type", ListUtils.of(types));
		}
		return reportFolderDAO.findByCriteria(folderCb.buildCriteria());
	}

	public List<ResourceFolder> getResourceTreeViewChilds(Long folderId, String foldeNameKeyword, String treeType, ObjectType... types) {
		return resourceFolderService.findAllObjectPickerByCriteria(folderId, foldeNameKeyword, treeType, types);
	}

	public List<Organization> getOrganizationTreeViewChilds(Long organizationId, String foldeNameKeyword, String treeType, ObjectType... types) {
		return organizationService.findAllObjectPickerByCriteria(organizationId, foldeNameKeyword, treeType, types);
	}
	
	/*public List getChildsByFilterTypes(Long nodeId, ObjectType nodeType, List<String> filterTypes) {
		List listTree = new ArrayList();
		if (null == nodeType || null == nodeId || nodeId == 0) {
			listTree.addAll(getChildsSiteBySiteId(nodeId));
		} else if (ObjectType.O_OS == nodeType) {
			if(filterTypes.contains(ObjectType.O_OS.name())){
				listTree.addAll(getChildsSiteBySiteId(nodeId));
			}
			if(filterTypes.contains(ObjectType.O_OO.name())){
				listTree.addAll(getChildsOrganization(nodeId, null));
			}
			if(filterTypes.contains(ObjectType.O_OG.name())){
				listTree.addAll(getChildsUserGroup(nodeId));
			}
			if(filterTypes.contains(ObjectType.R_CM.name())){
					listTree.addAll(getChildsResourceFolder(nodeId, null, ObjectType.R_CM));
			}
			if(filterTypes.contains(ObjectType.R_CF.name())){
				listTree.addAll(getChildsResourceFolder(nodeId, null, ObjectType.R_CF));
			}
			if(filterTypes.contains(ObjectType.R_QM.name())){
				listTree.addAll(getChildsResourceFolder(nodeId, null, ObjectType.R_QM));
			}
			if(filterTypes.contains(ObjectType.R_QF.name())){
				listTree.addAll(getChildsResourceFolder(nodeId, null, ObjectType.R_QF));
			}
			if(filterTypes.contains(ObjectType.R_ZM.name())){
				listTree.addAll(getChildsResourceFolder(nodeId, null, ObjectType.R_ZM));
			}
			if(filterTypes.contains(ObjectType.R_PM.name())){
				listTree.addAll(getChildsResourceFolder(nodeId, null, ObjectType.R_PM));
			}
			if(filterTypes.contains(ObjectType.R_PF.name())){
				listTree.addAll(getChildsResourceFolder(nodeId, null, ObjectType.R_PF));
			}
			if(filterTypes.contains(ObjectType.R_ZF.name())){
				listTree.addAll(getChildsResourceFolder(nodeId, null, ObjectType.R_ZF));
			}
		} else if (ObjectType.O_OO == nodeType) {
			if(filterTypes.contains(ObjectType.O_OO.name())){
				listTree.addAll(getChildsOrganization(null, nodeId));
			}
			if(filterTypes.contains(ObjectType.O_OU.name())){
				listTree.addAll(getChildsUser(nodeId));
			}
		} else if (ObjectType.R_CM == nodeType) {
			if(filterTypes.contains(ObjectType.R_CF.name())){
				listTree.addAll(getChildsResourceFolder(null, nodeId, ObjectType.R_CF));
			}
		} else if (ObjectType.R_CF == nodeType) {
			listTree.addAll(getChildsResourceFolder(null, nodeId, ObjectType.R_CF));
			listTree.addAll(getChildsCourse(nodeId));
		}else if(filterTypes.contains(ObjectType.R_QF.name())){
			listTree.addAll(getChildsResourceFolder(null, nodeId, ObjectType.R_QF));
			
		} else if (ObjectType.R_ZM == nodeType) {
			if(filterTypes.contains(ObjectType.R_ZF.name())){
				listTree.addAll(getChildsResourceFolder(null, nodeId, ObjectType.R_ZF));
			}
		} else if (filterTypes.contains(ObjectType.R_ZF.name())){
			listTree.addAll(getChildsResourceFolder(null, nodeId, ObjectType.R_ZF));
		} else if (filterTypes.contains(ObjectType.R_PF.name())){
			listTree.addAll(getChildsResourceFolder(null, nodeId, ObjectType.R_PF));
		}else if (filterTypes.contains(ObjectType.R_SF.name())){
			listTree.addAll(getChildsResourceFolder(null, nodeId, ObjectType.R_SF));
		}


		return listTree;
	}*/
	

}
