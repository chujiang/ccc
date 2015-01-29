package com.kingnod.etraining.activity.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.entity.Activity;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.service.ActivityService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.action.ObjectPickerAction;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@org.springframework.stereotype.Controller
@Namespace("/aty")
public class ActivityPickerAction extends ObjectPickerAction {

	@Autowired
	ActivityService activityService;
	
	@Override
	public String tree() throws Exception {
		// TODO Auto-generated method stub
		
		List childs = treeService.getActivityViewChilds(id, ObjectType.A_OS, ObjectType.A_EF);
				//null==id?0L:id, ObjectType.O_OS, ListUtils.of("O_OS;".split(";")));
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.basicSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(ActivityFolder.class, TreeViewUtils.basicAtyFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}

	@Override
	public String list() throws Exception {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = Cnd.builder(ActivityDetails.class);
		cb.andEQ("folderId", id);
		cb.andEQ("releaseStauts", "R");
		PagingResult<ActivityDetails> result = activityService.findActivity(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ActivityDetails.class, TreeViewUtils.basicActivityDetailsProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}

	@Override
	public String name() throws Exception {
		long objids[] = this.getObjId();
	    if(objids == null) {
	    	return "jsonResult";
		}
		
		CriteriaBuilder cb = Cnd.builder(ActivityDetails.class);
		for(long objid: objids){
			cb.andEQ("activity_id", objid);
		}
		PagingResult<ActivityDetails> result = activityService.findActivity(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ActivityDetails.class, TreeViewUtils.basicActivityDetailsProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}

}
