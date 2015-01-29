package com.kingnod.etraining.course.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.action.ObjectPickerAction;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@org.springframework.stereotype.Controller
@Namespace("/crs")
public class CoursePickerAction extends ObjectPickerAction {
	private static final long serialVersionUID = -5104478992357254844L;
	
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String tree() throws Exception {
		List childs =null;
		if(null!=keyword){
			if(StringUtils.isNotEmpty(keyword.trim())){
				childs = treeService.getResourceTreeViewChilds(id, keyword.trim(),ObjectType.R_CF.toString(), ObjectType.R_OS, ObjectType.R_CF, ObjectType.R_CF);
			}else{
				childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_FF, ObjectType.R_CF);
			}
			
		}else{
			childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_FF, ObjectType.R_CF);
		}
		
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.basicSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(Organization.class, TreeViewUtils.basicOrganizationProcessor);
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.basicCategoryProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String list() throws Exception {
		CriteriaBuilder cb = Cnd.builder(CourseInfo.class);
		cb.andEQ("folderId", id);
		cb.andEQ("releaseStatus", CourseConstant.RELEASE_STATUS_R);
		PagingResult<CourseInfo> result = courseInfoService.findCourseInfo(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(CourseInfo.class, TreeViewUtils.basicCourseProcessor);
		
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
			CriteriaBuilder cb = Cnd.builder(CourseInfo.class);
			for(long objid: objids){
				cb.orEQ("id",objid );
			}
			PagingResult<CourseInfo> result = courseInfoService.findCourseInfo(cb.buildCriteria());
			
			JsonConfig jsonconfig = new JsonConfig();
			jsonconfig.registerJsonBeanProcessor(CourseInfo.class, TreeViewUtils.basicCourseProcessor);
			
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
			return "jsonResult";
	}

}
