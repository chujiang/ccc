package com.kingnod.etraining.common.service;

import java.util.List;

import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.kingnod.etraining.resource.entity.ResourceFolder;

public interface TreeService {
	
	List<Organization> getOrganizationViewChilds(Long organizationId, ObjectType... types);
	List<Organization> getOrganizationViewChilds(Long organizationId, String foldeNameKeyword, ObjectType... types);
	List<Organization> getOrganizationTreeViewChilds(Long organizationId, String foldeNameKeyword,String treeType, ObjectType... types);
	List<ResourceFolder> getResourceViewChilds(Long folderId, ObjectType... types);
	List<ResourceFolder> getResourceViewChilds(Long folderId, String foldeNameKeyword, ObjectType... types);
	List<ResourceFolder> getResourceTreeViewChilds(Long folderId, String foldeNameKeyword,String treeType, ObjectType... types);
	List<ActivityFolder> getActivityViewChilds(Long folderId, ObjectType... types);
	List<ActivityFolder> getActivityViewChilds(Long folderId, String foldeNameKeyword, ObjectType... types);
	List<ReportFolder> getReportFolderViewChids(Long folderId, ObjectType... types);
	List<ReportFolder> getReportFolderViewChids(Long folderId, String foldeNameKeyword, ObjectType... types);
	
	/**
	 * 查找所有子站点
	 * @param siteId
	 * @return
	 */
	List getChildsSiteBySiteId(Long siteId);
	
	//List getChildsOrganization(Long siteId, Long organizationId);
	
	List getChildsUser(Long organizationId);
	
	List getChildsUserGroup(Long siteId);
	
	List getChildsResourceFolder(Long siteId, Long folderId, ObjectType... types);
	
	List getAllChildsResourceFolder(Long siteId, Long folderId, ObjectType... types);
	
	List getChilsActivityFolder(Long siteId, Long folderId, ObjectType... types);
	
	List getChilsReportFolder(Long siteId, Long folderId, ObjectType... types);
	
	//List getChildsByFilterTypes(Long nodeId, ObjectType nodeType, List<String> filterTypes);
	

}
