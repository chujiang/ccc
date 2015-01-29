package com.kingnod.etraining.resource.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "resource-folder", "namespace", "/res", "parentId", "${parentId}", "siteId", "${siteId}", "parentType", "${parentType}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-09 16:17")
@ErrorMapping(method="save")
public class ResourceFolderAction extends FilterableEntityAction<ResourceFolder, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-09 16:17")
    private ResourceFolderService resourceFolderService;
    //private Long folderId;
   private String parentType;
    
    /*public Long getFolderId() {
		return folderId;
	}


	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}*/
   
   @Override
   public String save() throws Exception {
	super.save();
	request.setAttribute("operationFlag", true);
	return INPUT;
}

    
    @com.kingnod.core.annotation.Generated("2012-02-09 16:17")
    public String filterDefines() {
        return "res.resourceFolderFilterItems";
    }
    
    @Override
    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
    	super.afterPreparedCriteriaBuilder(cb);
    	if(null != entity.getParentId()){
    		cb.andGroup(Cnd.builder().andEQ("parentId", entity.getParentId()));
    	}else{
    		cb.andGroup(Cnd.builder().andIsNull("parentId").andEQ("siteId", this.entity.getSiteId()));
    	}
    }
    
    @com.kingnod.core.annotation.Generated("2012-02-09 16:17")
    protected Object getEntityService() {
        return this.resourceFolderService;
    }


	public String getParentType() {
		return parentType;
	}


	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	
	  @Override
	    public String delete() throws Exception {
	    	super.delete();
	    	return "jsonResult";
	    }

}