package com.kingnod.etraining.organization.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.SiteService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "site-option", "namespace", "/org"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
@ErrorMapping(method="save")
public class SiteAction extends FilterableEntityAction<Site, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    private SiteService siteService;


    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    public String filterDefines() {
        return "org.siteFilterItems";
    }
    
    @Override
    public String save() throws Exception {
    	super.save();
    	request.setAttribute("operationFlag", true);
    	return INPUT;
    }
    @Override
    public String delete() throws Exception {
    	super.delete();
    	return "jsonResult";
    }
    
    public String refresh() throws Exception{
    	return "jsonResult";
    }
    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    protected Object getEntityService() {
        return this.siteService;
    }
}