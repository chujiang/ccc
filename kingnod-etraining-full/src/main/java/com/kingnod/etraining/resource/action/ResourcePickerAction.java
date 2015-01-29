package com.kingnod.etraining.resource.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;

import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.opensymphony.xwork2.ActionSupport;

@org.springframework.stereotype.Controller
@Namespace("/res")
public class ResourcePickerAction extends ActionSupport {

	private static final long serialVersionUID = -4252932013642666242L;
	
	public String crsCategories(){
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode treeNode = new TreeNode("1", "abcd", true);
		list.add(treeNode);
		treeNode = new TreeNode("2", "abcd", true);
		list.add(treeNode);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", list);
		
		return "jsonResult";
	}

}
