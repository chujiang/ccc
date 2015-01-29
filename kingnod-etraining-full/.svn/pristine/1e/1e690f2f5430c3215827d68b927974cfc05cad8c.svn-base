package com.kingnod.etraining.organization.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.organization.dao.OrganizationHierarchyDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.OrganizationHierarchy;
import com.kingnod.etraining.organization.service.OrganizationService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "site-option", "namespace", "/org"}),
@Result(name = "home", type = "redirectAction", params = { "actionName", "main.action", "namespace", "/"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
@ErrorMapping(method="save")    
public class OrganizationAction extends FilterableEntityAction<Organization, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
    private OrganizationService organizationService;


    
    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
    public String filterDefines() {
        return "org.organizationFilterItems";
    }
    
    @Override
    public String delete() throws Exception {
    	super.delete();
    	return "jsonResult";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
    protected Object getEntityService() {
        return this.organizationService;
    }
    
    @Override
    public String save() throws Exception {
    	super.save();
    	request.setAttribute("operationFlag", true);
    	return INPUT;
    }
    
    public String reset() throws Exception {
    	CriteriaBuilder cb;
    	cb = Cnd.builder(OrganizationHierarchy.class);
    	OrganizationHierarchyDAO hierarchyDAO = (OrganizationHierarchyDAO)SpringUtils.getBean(OrganizationHierarchyDAO.class);
    	hierarchyDAO.hardDeleteByCriteria(cb.buildCriteria());
    	
    	cb = Cnd.builder(Organization.class);
    	cb.andEQ("recordStatus", RecordStatus.ACTIVE);
    	PagingResult<Organization> result = organizationService.findOrganization(cb.buildCriteria());
    	for(Organization organization:result.getResult()){
    		organizationService.resetOrganizationCount(organization.getId());
    		organizationService.resetOrganizationHierarchy(organization);
    	}
    	this.entity.setSiteId(-1L);
    	return "home";
    }
}