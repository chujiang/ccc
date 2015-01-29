package com.kingnod.etraining.resource.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/res")
@Results({ @Result(name = "search", type = "redirectAction", location = "/WEB-INF/content/html/ipanel.jsp",params = { "actionName", "tree", "types", "${resTreeId }" })})
public class TreeAction extends ActionSupport {

	private static final long serialVersionUID = 4242612202520616657L;
	@Autowired
	private TreeService treeService;
	@Autowired
	private ResourceFolderService resourceFolerService;
	
	private Long id;
	private ObjectType nodeType;
	private String filterTypes;
	private String keyword;
	private boolean async;
	
	private Long targetId;//节点移动到目标节点的id
	private String moveType;

	
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
		List<ResourceFolder> childs;
		if(null!=keyword){
			if(!"".equals(keyword.trim())){
				childs = treeService.getResourceViewChilds(id, keyword.trim(), ObjectType.R_OS, ObjectType.R__F, ObjectType.R_QB);
			}else{
				childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R__F, ObjectType.R_QB);
			}
			
//			async = false;
		}else{
			childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R__F, ObjectType.R_QB);
			async = true;
		}
		if(!ListUtils.isEmpty(childs)){//去掉课程类别文件夹
			List<ResourceFolder> removedList = new ArrayList<ResourceFolder>();
			for(ResourceFolder resFolder:childs){
				if(ObjectType.R_SF.equals(resFolder.getType())){
					removedList.add(resFolder);
				}
			}
			for(ResourceFolder removeFolder:removedList){
				childs.remove(removeFolder);
			}
		}
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.viewSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.viewResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}
	
	public String search(){
		List childs = treeService.getResourceViewChilds(id, keyword, ObjectType.R_OS, ObjectType.R__F, ObjectType.R_QB);
		async = false;
		return "search";
	}
	
	public String move() throws Exception {
		resourceFolerService.moveResourceFolder(id, targetId, moveType);
		return "jsonResult";
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

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}
}
