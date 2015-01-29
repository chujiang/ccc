package com.kingnod.etraining.activity.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.service.ActivityFolderService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "activity-module", "namespace", "/aty", "siteId", "${siteId}"})
}
)
public class ActivityModuleAction extends FilterableEntityAction<ActivityFolder, Long> {

	private static final long serialVersionUID = 1L;
	
	 @Autowired
	 private ActivityFolderService activityFolderService;

	public String filterDefines() {
		return "aty.activityFolderFilterItems";
	}

	@Override
	protected Object getEntityService() {
		 return this.activityFolderService;
	}
	
	  @Override
	    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
	    	super.afterPreparedCriteriaBuilder(cb);
	    	cb.andGroup(Cnd.builder().andLike("type", "A_%M").andEQ("site_id", entity.getSiteId()));
	    }
	  
	  @Override
	   public String save() throws Exception {
	   	String result = super.save();
	   	return result;
	   }

}
