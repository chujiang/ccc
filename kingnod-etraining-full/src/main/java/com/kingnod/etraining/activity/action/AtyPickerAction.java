package com.kingnod.etraining.activity.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.opensymphony.xwork2.ActionSupport;


//@ParentPackage("json-default")
@Namespace("/aty")
/*@Results({
@Result(type = "json", name = "success", params = {
			"root",
			"result",
			"question-list",
			"\\[\\d+\\]\\.id, \\[\\d+\\]\\.pId, \\[\\d+\\]\\.name, \\[\\d+\\]\\.isParent,\\[\\d+\\]\\.src, \\[\\d+\\]\\.open, "
					+ "\\[\\d+\\]\\.icon, \\[\\d+\\]\\.iconOpen, \\[\\d+\\]\\.iconClose, \\[\\d+\\]\\.iconSkin, \\[\\d+\\]\\.font, \\[\\d+\\]\\.nodeType,"
					+ "\\[\\d+\\]\\.openMode, \\[\\d+\\]\\.target"}),
})*/
public class AtyPickerAction extends ActionSupport {

	private static final long serialVersionUID = 4242612202520616657L;

	@Autowired
	private TreeService treeService;
	
	private Long id = 0L;
	private ObjectType nodeType;
	private String filterTypes;

	
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


	public String questions() throws Exception {
		//result = questionService.getQuestionFolderList(id, nodeType);

		if(StringUtils.isEmpty(filterTypes)){
			filterTypes = "";
		}
		List<?> childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_QF, ObjectType.R_QB);
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.basicSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.basicResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}

	/**
	 * @return the filterTypes
	 */
	public String getFilterTypes() {
		return filterTypes;
	}

	/**
	 * @param filterTypes the filterTypes to set
	 */
	public void setFilterTypes(String filterTypes) {
		this.filterTypes = filterTypes;
	}
	
}
