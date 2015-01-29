package com.kingnod.etraining.activity.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.service.ActivityFolderService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "activity-folder", "namespace", "/aty", "parentId", "${parentId}", "siteId", "${siteId}", "parentType", "${parentType}"})
}
)

@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
@ErrorMapping(method="save")
public class ActivityFolderAction extends FilterableEntityAction<ActivityFolder, Long> {
	private String parentType;
    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-09 19:16")
    private ActivityFolderService activityFolderService;


    
    @com.kingnod.core.annotation.Generated("2012-02-09 19:16")
    public String filterDefines() {
        return "aty.activityFolderFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-09 19:16")
    protected Object getEntityService() {
        return this.activityFolderService;
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
    
    
    @Override
    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
    	super.afterPreparedCriteriaBuilder(cb);
    	if(null != entity.getParentId()){
    		cb.andGroup(Cnd.builder().andEQ("parentId", entity.getParentId()));
    	}else{
    		cb.andGroup(Cnd.builder().andIsNull("parentId").andEQ("siteId", this.entity.getSiteId()));
    	}
    }

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

}