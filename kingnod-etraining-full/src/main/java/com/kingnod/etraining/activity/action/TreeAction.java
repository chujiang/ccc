package com.kingnod.etraining.activity.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.service.ActivityFolderService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Site;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/aty")
public class TreeAction extends ActionSupport {

	private static final long serialVersionUID = 4242612202520616657L;
	
	@Autowired
	private TreeService treeService;
	@Autowired
	private ActivityFolderService activityFolderService;
	
	private Long id;
	private ObjectType nodeType;
	
	private String keyword;
	
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
		Struts2Utils.getRequest().setAttribute("treeType", "activity_tree");
		List<?> childs=null;
		//List childs = treeService.getActivityViewChilds(id, "管理", ObjectType.A_OS, ObjectType.A_EF);
		if(null!=keyword){
			if(!"".equals(keyword.trim())){
				childs = treeService.getActivityViewChilds(id, keyword.trim(), ObjectType.A_OS, ObjectType.A_EF);
			}else{
				childs = treeService.getActivityViewChilds(id, ObjectType.A_OS, ObjectType.A__F);
			}
			
		}else{
			childs = treeService.getActivityViewChilds(id, ObjectType.A_OS, ObjectType.A__F);
		}
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.viewSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(ActivityFolder.class, TreeViewUtils.viewAtyFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	public String folder() throws Exception {
		Long siteId = null;
		Long parentId = null;
		if(null == nodeType){
			siteId = 0L;
		}else if("S".equals(nodeType)){
			siteId = Long.valueOf(id);
		}else{
			parentId = Long.valueOf(id);
		}
		//result = activityFolderService.getTreeNodeList(siteId, parentId, nodeType);
		return "folder";
	}
	
	public String move() throws Exception {
		activityFolderService.moveActivityFolder(id, targetId, moveType);
		return "jsonResult";
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
