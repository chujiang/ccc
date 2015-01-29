package com.kingnod.etraining.organization.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.action.ObjectPickerAction;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.service.OrganizationService;

@org.springframework.stereotype.Controller
@Namespace("/org")
public class OrganizationPickerAction extends ObjectPickerAction {

	private static final long serialVersionUID = -4366645354828335954L;
	
	@Autowired
	OrganizationService organizationService;

	
	@Override
	public String tree() throws Exception {
		//List childs = treeService.getChildsByFilterTypes(null==id?0L:id, ObjectType.O_OS, ListUtils.of("O_OS;".split(";")));
		List childs = treeService.getOrganizationViewChilds(id, ObjectType.O_OS, ObjectType.O_OO);
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Organization.class, TreeViewUtils.basicOrganizationProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String list() throws Exception {
		CriteriaBuilder cb = Cnd.builder(Organization.class);
		cb.andEQ("parentId", id);
		cb.andEQ("type", ObjectType.O_OO);
		PagingResult<Organization> result = organizationService.findOrganization(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Organization.class, TreeViewUtils.basicOrganizationProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String name() throws Exception {
		return null;
	}

}
