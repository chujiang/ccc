package com.kingnod.etraining.report.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/rpt")
@Results({ @Result(name = "search", type = "redirectAction", location = "/WEB-INF/content/html/ipanel.jsp",params = { "actionName", "tree", "types", "${resTreeId }" })})
public class TreeAction extends ActionSupport{
	private static final long serialVersionUID = 4242612202520616657L;
	@Autowired
	private TreeService treeService;
	
	private Long id;
	private ObjectType nodeType;
	private String filterTypes;
	private String keyword;
	private boolean async;

	
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
		List childs;
		if(null!=keyword){
			if(!"".equals(keyword.trim())){
				childs = treeService.getReportFolderViewChids(id, keyword.trim(), ObjectType.P_OS, ObjectType.P__F, ObjectType.P_FF);
			}else{
				childs = treeService.getReportFolderViewChids(id, ObjectType.P_OS, ObjectType.P__F, ObjectType.P_FF);
			}
			
//			async = false;
		}else{
			childs = treeService.getReportFolderViewChids(id, ObjectType.P_OS, ObjectType.P__F, ObjectType.P_FF);
			async = true;
		}
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.viewSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(ReportFolder.class, TreeViewUtils.viewRptFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}
	
	public String search(){
		List childs = treeService.getReportFolderViewChids(id, keyword, ObjectType.P_OS, ObjectType.P__F, ObjectType.P_FF);
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
}
