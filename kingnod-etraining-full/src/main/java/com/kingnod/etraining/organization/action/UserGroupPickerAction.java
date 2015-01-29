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
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.UserGroupService;

@org.springframework.stereotype.Controller
@Namespace("/org")
public class UserGroupPickerAction extends ObjectPickerAction {

	private static final long serialVersionUID = 9057043486937175035L;
	
	@Autowired
	UserGroupService userGroupService;
	
	@Autowired
	OrganizationService organizationService;
	
	@Override
	public String tree() throws Exception {
		//List childs = treeService.getChildsByFilterTypes(null==id?0L:id, ObjectType.O_OS, ListUtils.of("O_OS;".split(";")));
		List childs = treeService.getOrganizationViewChilds(id, ObjectType.O_OS);
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Organization.class, TreeViewUtils.basicOrganizationProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String list() throws Exception {
		Organization organization = organizationService.getOrganization(id);
		CriteriaBuilder cb = Cnd.builder(UserGroup.class);
		cb.andEQ("siteId", organization.getSiteId());
		if(null != extparams && !"".equals(extparams))
			cb.andNotEQ("id", extparams);	//不能是自身
		PagingResult<UserGroup> result = userGroupService.findUserGroup(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(User.class, TreeViewUtils.basicUserGroupProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String name() throws Exception {
		return null;
	}

}
