package com.kingnod.etraining.organization.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.action.ObjectPickerAction;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.service.UserService;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@org.springframework.stereotype.Controller
@Namespace("/org")
public class UserPickerAction extends ObjectPickerAction {

	private static final long serialVersionUID = 2020058299430642234L;
	
	@Autowired
	UserService userService;
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
				childs = treeService.getOrganizationTreeViewChilds(id, keyword.trim(),ObjectType.O_OO.toString(), ObjectType.O_OS, ObjectType.O_OO, ObjectType.O_OO);
			}else{
				childs = treeService.getOrganizationViewChilds(id, ObjectType.O_OS, ObjectType.O_OO, ObjectType.O_OO);
			}
			
		}else{
			childs = treeService.getOrganizationViewChilds(id, ObjectType.O_OS, ObjectType.O_OO, ObjectType.O_OO);
		}
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.basicSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(Organization.class, TreeViewUtils.basicOrganizationProcessor);
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.basicResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String list() throws Exception {
		CriteriaBuilder cb = Cnd.builder(User.class);
		cb.andEQ("organization_Id", id);
		if(null != extparams && !"".equals(extparams)){
			List userIds = ListUtils.of(StringUtils.split(extparams,","));
			if(!ListUtils.isEmpty(userIds)){
				cb.andNotIn("id", ListUtils.of(StringUtils.split(extparams,",")));	//剔除互斥的用户
			}
		}
		PagingResult<User> result = userService.findUser(cb.buildCriteria());
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(User.class, TreeViewUtils.basicUserProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String name() throws Exception {
	    long objids[] = this.getObjId();
	    if(objids == null) {
	    	return "jsonResult";
		}
		CriteriaBuilder cb = Cnd.builder(User.class);
	
		for(long objid: objids){
			cb.orEQ("id",objid );
		}
		PagingResult<User> result = userService.findUser(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(User.class, TreeViewUtils.basicUserProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
}
