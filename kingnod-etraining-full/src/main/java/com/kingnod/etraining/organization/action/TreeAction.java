package com.kingnod.etraining.organization.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/org")
public class TreeAction extends ActionSupport {

	private static final long serialVersionUID = 4242612202520616657L;
	
	@Autowired
	private TreeService treeService;
	@Autowired
	private OrganizationService organizationSerice;
	
	private Long id;
	private ObjectType nodeType;
	private String filterTypes;
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
		
		Struts2Utils.getRequest().setAttribute("treeType", "organization_tree");
		List<Organization> childs = null;
		if(null!=keyword){
			if(!"".equals(keyword.trim())){
				childs = treeService.getOrganizationViewChilds(id, keyword.trim(), ObjectType.O_OS, ObjectType.O_OO);
			}else{
				childs = treeService.getOrganizationViewChilds(id, ObjectType.O_OS, ObjectType.O_OO);
			}
		}else{
			childs = treeService.getOrganizationViewChilds(id, ObjectType.O_OS, ObjectType.O_OO);
		}
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.viewSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(Organization.class, TreeViewUtils.viewOrganizationProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	public String move() throws Exception {
		organizationSerice.moveOrganization(id, targetId, moveType);
		return "jsonResult";
	}

	public String getFilterTypes() {
		return filterTypes;
	}

	public void setFilterTypes(String filterTypes) {
		this.filterTypes = filterTypes;
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
