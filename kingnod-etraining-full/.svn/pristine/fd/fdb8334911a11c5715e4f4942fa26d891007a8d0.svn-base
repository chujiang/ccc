package com.kingnod.etraining.organization.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.dao.ActivityFolderDAO;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.organization.dao.OrganizationDAO;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.dao.SiteHierarchyDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.SiteHierarchy;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.report.dao.ReportFolderDAO;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.security.PermisssionService;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	protected SiteDAO siteDAO;

	@Autowired
	protected OrganizationDAO organizationDAO;

	@Autowired
	protected ResourceFolderDAO resourceFolderDAO;

	@Autowired
	protected ActivityFolderDAO activityFolderDAO;
	
	@Autowired
	protected SiteHierarchyDAO siteHierarchyDAO;
	
	@Autowired
	protected PermisssionService permissionService;
	
	@Autowired
	protected ReportFolderDAO reportFolderDAO;

	public Site getSite(Long id) {
		return siteDAO.get(id);
	}

	public int saveSite(Site site) {
		int count = 0;
		int shortNameCount = 0;
		int nameCount=0;
		IdEntity<Long> idEntity = (IdEntity) site;
		CriteriaBuilder cb = Cnd.builder(Site.class);
		CriteriaBuilder nameCb = Cnd.builder(Site.class);
		cb.andEQ("shortName", site.getShortName());
		nameCb.andEQ("name", site.getName());
		if (null != idEntity.getId() && null != siteDAO.get(idEntity.getId())) {
			cb.andNotEQ("id", site.getId());
			nameCb.andNotEQ("id", site.getId());
			shortNameCount = siteDAO.countByCriteria(cb.buildCriteria());
			nameCount=siteDAO.countByCriteria(nameCb.buildCriteria());
			if(shortNameCount>0){
				throw Exceptions.createAppException("org001004");
			}else if(nameCount>0){
				throw Exceptions.createAppException("org001007");
			}else{
				count = siteDAO.update(site);
				CriteriaBuilder siteResFolderCb = Cnd.builder(ResourceFolder.class);
				siteResFolderCb.andEQ("type", ObjectType.R_OS).andEQ("siteId", site.getId());
				List<ResourceFolder> parentSiteResFolder = resourceFolderDAO.findByCriteria(siteResFolderCb.buildCriteria());
				for (ResourceFolder resourceFolder : parentSiteResFolder) {
					resourceFolder.setName(site.getName());
					resourceFolderDAO.update(resourceFolder);
				}
				CriteriaBuilder siteAtyFolderCb = Cnd.builder(ActivityFolder.class);
				siteAtyFolderCb.andEQ("type", ObjectType.A_OS).andEQ("siteId", site.getId());
				List<ActivityFolder> parentSiteAtyFolder = activityFolderDAO.findByCriteria(siteAtyFolderCb.buildCriteria());
				for (ActivityFolder activityFolder : parentSiteAtyFolder) {
					activityFolder.setName(site.getName());
					activityFolderDAO.update(activityFolder);
				}
				CriteriaBuilder siteOrgFolderCb = Cnd.builder(Organization.class);
				siteOrgFolderCb.andEQ("type", ObjectType.O_OS).andEQ("siteId", site.getId());
				List<Organization> parentSiteOrgFolder = organizationDAO.findByCriteria(siteOrgFolderCb.buildCriteria());
				for (Organization organization : parentSiteOrgFolder) {
					organization.setName(site.getName());
					organizationDAO.update(organization);
				}
			}
			
		} else {
			shortNameCount = siteDAO.countByCriteria(cb.buildCriteria());
			nameCount=siteDAO.countByCriteria(nameCb.buildCriteria());
			if(shortNameCount>0){
				throw Exceptions.createAppException("org001004");
			}else if(nameCount>0){
				throw Exceptions.createAppException("org001007");
			}else{
				count = siteDAO.insert(site);
				
				//
				CriteriaBuilder siteResFolderCb = Cnd.builder(ResourceFolder.class);
				siteResFolderCb.andEQ("type", ObjectType.R_OS).andEQ("siteId", site.getParentId());
				List<ResourceFolder> parentSiteResFolder = resourceFolderDAO.findByCriteria(siteResFolderCb.buildCriteria());
				
				ResourceFolder siteResFolder = new ResourceFolder();
				siteResFolder.setType(ObjectType.R_OS);
				siteResFolder.setSiteId(site.getId());
				siteResFolder.setParentId(parentSiteResFolder.get(0).getId());
				siteResFolder.setName(site.getName());
				resourceFolderDAO.insert(siteResFolder);
				
				//
				CriteriaBuilder siteAtyFolderCb = Cnd.builder(ActivityFolder.class);
				siteAtyFolderCb.andEQ("type", ObjectType.A_OS).andEQ("siteId", site.getParentId());
				List<ActivityFolder> parentSiteAtyFolder = activityFolderDAO.findByCriteria(siteAtyFolderCb.buildCriteria());
				
				ActivityFolder siteAtyFolder = new ActivityFolder();
				siteAtyFolder.setType(ObjectType.A_OS);
				siteAtyFolder.setSiteId(site.getId());
				siteAtyFolder.setParentId(parentSiteAtyFolder.get(0).getId());
				siteAtyFolder.setName(site.getName());
				activityFolderDAO.insert(siteAtyFolder);
				
				//
				CriteriaBuilder siteOrgFolderCb = Cnd.builder(Organization.class);
				siteOrgFolderCb.andEQ("type", ObjectType.O_OS).andEQ("siteId", site.getParentId());
				List<Organization> parentSiteOrgFolder = organizationDAO.findByCriteria(siteOrgFolderCb.buildCriteria());
				
				Organization siteOrg = new Organization();
				siteOrg.setType(ObjectType.O_OS);
				siteOrg.setSiteId(site.getId());
				siteOrg.setParentId(parentSiteOrgFolder.get(0).getId());
				siteOrg.setName(site.getName());
				organizationDAO.insert(siteOrg);
				
//				Organization registeOrg = new Organization();
//				registeOrg.setType(ObjectType.O_OO);
//				registeOrg.setSiteId(site.getId());
//				registeOrg.setParentId(siteOrg.getId());
//				registeOrg.setName(site.getName()+"临时组织");
//				registeOrg.setParentId(siteOrg.getId());
//				organizationDAO.insert(registeOrg);
				
				Site hierarchySite = site;
				int hierLevel = 0;
				while(null != hierarchySite){
					SiteHierarchy siteHier = new SiteHierarchy();
					siteHier.setSiteId(site.getId());
					siteHier.setHierarchyId(hierarchySite.getId());
					siteHier.setHierarchyLevel(hierLevel++);
					siteHierarchyDAO.insert(siteHier);
					if(null != hierarchySite.getParentId()){
						hierarchySite = siteDAO.get(hierarchySite.getParentId());
					}else{
						hierarchySite = null;
					}
				}
				
				//初始化报表试图数据
				CriteriaBuilder siteRptFolderCb = Cnd.builder(ReportFolder.class);
				siteRptFolderCb.andEQ("type", ObjectType.P_OS).andEQ("siteId", site.getParentId());
				List<ReportFolder> parentSiteRptFolder=reportFolderDAO.findByCriteria(siteRptFolderCb.buildCriteria());
				ReportFolder siteRpt=new ReportFolder();
				siteRpt.setType(ObjectType.P_OS);
				siteRpt.setSiteId(site.getId());
				siteRpt.setParentId(parentSiteRptFolder.get(0).getId());
				siteRpt.setName(site.getName());
				siteRpt.setLevelNumber(0);
				siteRpt.setObjectCount(0L);
				siteRpt.setFolderCount(4L);
				reportFolderDAO.insert(siteRpt);
				//报表子节点
//				CriteriaBuilder siteRptFolderChildCb = Cnd.builder(ReportFolder.class);
//				siteRptFolderChildCb.andEQ("type", ObjectType.P_OS).andEQ("siteId", siteRpt.getParentId());
				ReportFolder siteRptChild=new ReportFolder();
				siteRptChild.setType(ObjectType.P_AF);
				siteRptChild.setSiteId(site.getId());
				siteRptChild.setParentId(siteRpt.getId());
				siteRptChild.setFolderCount(0L);
				siteRptChild.setLevelNumber(0);
				siteRptChild.setObjectCount(0L);
				siteRptChild.setName(SpringUtils.getMessage("rpt.reportFolder_user_courseInfo", null));
				
				reportFolderDAO.insert(siteRptChild);
				siteRptChild.setType(ObjectType.P_BF);
				siteRptChild.setSiteId(site.getId());
				siteRptChild.setParentId(siteRpt.getId());
				siteRptChild.setName(SpringUtils.getMessage("rpt.reportFolder_courseInfo", null));
				siteRptChild.setFolderCount(0L);
				siteRptChild.setLevelNumber(0);
				siteRptChild.setObjectCount(0L);
				reportFolderDAO.insert(siteRptChild);
				
				siteRptChild.setType(ObjectType.P_CF);
				siteRptChild.setSiteId(site.getId());
				siteRptChild.setParentId(siteRpt.getId());
				siteRptChild.setName(SpringUtils.getMessage("rpt.reportFolder_user_examination", null));
				siteRptChild.setFolderCount(0L);
				siteRptChild.setLevelNumber(0);
				siteRptChild.setObjectCount(0L);
				reportFolderDAO.insert(siteRptChild);
				
				siteRptChild.setType(ObjectType.P_DF);
				siteRptChild.setSiteId(site.getId());
				siteRptChild.setParentId(siteRpt.getId());
				siteRptChild.setName(SpringUtils.getMessage("rpt.reportFolder_examination", null));
				siteRptChild.setFolderCount(0L);
				siteRptChild.setLevelNumber(0);
				siteRptChild.setObjectCount(0L);
				reportFolderDAO.insert(siteRptChild);
				
				//初始化课程类别数据
				ResourceFolder siteResFolderChild = new ResourceFolder();
				siteResFolderChild.setType(ObjectType.R_SF);
				siteResFolderChild.setSiteId(site.getId());
				siteResFolderChild.setParentId(siteResFolder.getId());
				siteResFolderChild.setName(SpringUtils.getMessage("crs.CategoryCourse", null));
				siteRptChild.setFolderCount(0L);
				resourceFolderDAO.insert(siteResFolderChild);
			}
		}
		return count;
	}

	public int deleteSite(Site site) {
		int result = siteDAO.delete(site);
		CriteriaBuilder siteHierCb = Cnd.builder(SiteHierarchy.class);
		siteHierCb.andEQ("siteId", site.getId());
		siteHierarchyDAO.deleteByCriteria(siteHierCb.buildCriteria());
		return result;
	}

	public int deleteSiteByIds(Long[] ids) {
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += siteDAO.deleteById(ids[i]);
			CriteriaBuilder siteHierCb = Cnd.builder(SiteHierarchy.class);
			siteHierCb.andEQ("siteId", ids[i]);
			siteHierarchyDAO.deleteByCriteria(siteHierCb.buildCriteria());
			
			CriteriaBuilder orgCb = Cnd.builder(Organization.class);
			orgCb.andEQ("siteId", ids[i]).andEQ("type", ObjectType.O_OS);
			organizationDAO.deleteByCriteria(orgCb.buildCriteria());
			
			CriteriaBuilder resCb = Cnd.builder(ResourceFolder.class);
			resCb.andEQ("siteId", ids[i]).andEQ("type", ObjectType.R_OS);
			resourceFolderDAO.deleteByCriteria(resCb.buildCriteria());
			
			CriteriaBuilder actCb = Cnd.builder(ActivityFolder.class);
			actCb.andEQ("siteId", ids[i]).andEQ("type", ObjectType.A_OS);
			activityFolderDAO.deleteByCriteria(actCb.buildCriteria());
			
			CriteriaBuilder rfCb = Cnd.builder(ReportFolder.class);
			rfCb.andEQ("siteId", ids[i]).andEQ("type", ObjectType.P_OS);
			reportFolderDAO.deleteByCriteria(rfCb.buildCriteria());
			
			CriteriaBuilder rfzbfCb = Cnd.builder(ReportFolder.class);
			rfzbfCb.andEQ("siteId", ids[i]).andEQ("type", ObjectType.P_BF);
			reportFolderDAO.deleteByCriteria(rfzbfCb.buildCriteria());
			
			CriteriaBuilder rfzcfCb = Cnd.builder(ReportFolder.class);
			rfzcfCb.andEQ("siteId", ids[i]).andEQ("type", ObjectType.P_CF);
			reportFolderDAO.deleteByCriteria(rfzcfCb.buildCriteria());
			
			CriteriaBuilder rfzdfCb = Cnd.builder(ReportFolder.class);
			rfzdfCb.andEQ("siteId", ids[i]).andEQ("type", ObjectType.P_DF);
			reportFolderDAO.deleteByCriteria(rfzdfCb.buildCriteria());
			
		}
		return count;
	}

	public PagingResult<Site> findSite(Criteria criteria) {
		return siteDAO.findPagingResult(criteria);
	}

	public List<Site> findTopLevelSite() {
		UserAccount userAccount = SecurityUtils.getCurrentUser();
		if(0 == userAccount.getId()){
			return ListUtils.of(siteDAO.get(0L));
		}
		CriteriaBuilder criteriaBuilder = Cnd.builder(Site.class);

		Criteria criteria = criteriaBuilder.buildCriteria();

		permissionService.addPermissionParams(criteria, ObjectType.O_OS);
		
		return siteDAO.findTopLevelByCriteria(criteria);
		
	}
	
	public List<Site> findChildsSite(Long siteId) {
		if(checkSiteReadPermission(siteId)){
			CriteriaBuilder criteriaBuilder = Cnd.builder(Site.class);
			criteriaBuilder.andEQ("parentId", siteId);
			return siteDAO.findByCriteria(criteriaBuilder.buildCriteria());
		}
		return null;
	}

	public boolean checkSiteReadPermission(Long siteId) {
		UserAccount userAccount = SecurityUtils.getCurrentUser();
		if(0 == userAccount.getId()){
			return true;
		}
		List<Site> topLevelEntities = findTopLevelSite();
		List<Long> topLevelIds = new ArrayList<Long>();
		for(Site entity:topLevelEntities){
			topLevelIds.add(entity.getId());
		}
		CriteriaBuilder orgHierarchyCb = Cnd.builder(SiteHierarchy.class);
		orgHierarchyCb.andIn("hierarchyId", topLevelIds).andEQ("siteId", siteId);
		List<SiteHierarchy> result = siteHierarchyDAO.findByCriteria(orgHierarchyCb.buildCriteria());
		if(!result.isEmpty()){
			return true;
		}
		throw Exceptions.createAppException("org001005");
	}
}