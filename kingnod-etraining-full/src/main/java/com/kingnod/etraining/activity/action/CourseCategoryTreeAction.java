package com.kingnod.etraining.activity.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/res")

@Results({
	@Result(name = "search", type = "redirectAction", location = "/WEB-INF/content/html/ipanel.jsp",params = { "actionName", "tree", "types", "${resTreeId }","siteId","${siteId}" })
	})
public class CourseCategoryTreeAction extends ActionSupport {
	
	private static final long serialVersionUID = 4242612202520616657L;
	@Autowired
	private ResourceFolderService resourceFolderService;
	
	private Long id;
	private ObjectType nodeType;
	private String filterTypes;
	private String keyword;
	private boolean async;
	private Long siteId;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ObjectType getNodeType() {
		return nodeType;
	}

	public void setNodeType(ObjectType nodeType) {
		this.nodeType = nodeType;
	}
	

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String execute() throws Exception {
		Struts2Utils.getRequest().setAttribute("treeType", "resource_tree");
		PagingResult<ResourceFolder> childs = null;
				//通过siteId获得推荐课程的性息
		if(null == this.id){
				Long id = this.siteId;
				CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
				cb.andEQ("siteId", this.siteId).andEQ("type", ObjectType.R_SF).andEQ("name", SpringUtils.getMessage("crs.CategoryCourse", null));
				childs = resourceFolderService.findResourceFolder(cb.buildCriteria());
		}else{
			CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
			cb.andEQ("parentId", this.id).andEQ("type", ObjectType.R_SF);
			childs = resourceFolderService.findResourceFolder(cb.buildCriteria());
		}
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.viewCourseCategoryProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}
	
	public String search(){
		
		//List childs = treeService.getResourceViewChilds(id, keyword, ObjectType.R_OS, ObjectType.R_SF, ObjectType.R_SF);
		async = false;
		return "search";
	}
	
	public String getFilterTypes() {
		return filterTypes;
	}

	public void setFilterTypes(String filterTypes) {
		this.filterTypes = filterTypes;
	}

	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
}
