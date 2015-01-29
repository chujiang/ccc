package com.kingnod.etraining.resource.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "resource-module", "namespace", "/res",  "siteId", "${siteId}"})
}
)
public class ResourceModuleAction extends FilterableEntityAction<ResourceFolder, Long> {

	private static final long serialVersionUID = -2705719604342073650L;
	
	@Autowired
	private ResourceFolderService resourceFolderService;
	
	public String filterDefines() {
		return "res.resourceFolderFilterItems";
	}

	@Override
	protected Object getEntityService() {
		return resourceFolderService;
	}
	
	 @Override
	    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
	    	super.afterPreparedCriteriaBuilder(cb);
	    	cb.andGroup(Cnd.builder().andLike("type", "R_%M").andEQ("site_id", entity.getSiteId()));
	    }
	 
	   @Override
	   public String save() throws Exception {
	   	String result = super.save();
	   	return result;
	   }
}
