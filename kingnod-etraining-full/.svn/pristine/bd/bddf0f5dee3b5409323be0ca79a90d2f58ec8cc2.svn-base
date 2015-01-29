package com.kingnod.etraining.course.action;

import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.service.ActivityFolderService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.action.ObjectPickerAction;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;

@org.springframework.stereotype.Controller
@Namespace("/crs")
public class CourseSystemAction extends ObjectPickerAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	ActivityFolderService activityFolderService;
	@Autowired
	ResourceFolderService resourceFolderService;
	
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
				childs = treeService.getResourceTreeViewChilds(id, keyword.trim(),ObjectType.R_SF.toString(), ObjectType.R_OS, ObjectType.R_SF, ObjectType.R_SF);
			}else{
				childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_SF);
			}
			
		}else{
			childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_SF);
		}
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.basicSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.basicResFolderProcessor);

		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);

		return "jsonResult";
	}

	@Override
	public String list() throws Exception {
		List childs = treeService.getResourceViewChilds(id, ObjectType.R_SF);
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(CourseInfo.class, TreeViewUtils.basicCourseProcessor);

		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);

		return "jsonResult";
	}

	@Override
	public String name() throws Exception {
	    long objids[] = this.getObjId();
		if (null == objids || objids.length == 0) {
			return "jsonResult";
		}
		
		CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
		//cb.andIn("id", ListUtils.of(objids));
		for(long objid: objids){
		 	cb.orEQ("id",objid );
		}
		
		PagingResult<ResourceFolder> result = resourceFolderService.findResourceFolder(cb.buildCriteria());

		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ResourceFolder entity = (ResourceFolder) bean;
				JSONObject jsonObj = new JSONObject();
				jsonObj.element("name", entity.getName());
				return jsonObj;
			}
		});

		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);

		return "jsonResult";
	}

}
