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
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.action.ObjectPickerAction;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;


@org.springframework.stereotype.Controller
@Namespace("/org")
public class SitePickerAction extends ObjectPickerAction {

	private static final long serialVersionUID = -7966806512646929960L;
	
	@Autowired
	SiteService siteService;
	
	@Autowired
	OrganizationService organizationService;
	
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String tree() throws Exception {
		//List childs = treeService.getChildsByFilterTypes(null==id?null:id, ObjectType.O_OS, ListUtils.of("O_OS;".split(";")));
		List childs =null;
		if(null!=keyword){
			if(StringUtils.isNotEmpty(keyword.trim())){
				childs = treeService.getOrganizationTreeViewChilds(id, keyword.trim(),ObjectType.O_OS.toString(), ObjectType.O_OS);
			}else{
				childs = treeService.getOrganizationViewChilds(id, ObjectType.O_OS);
			}
			
		}else{
			childs = treeService.getOrganizationViewChilds(id, ObjectType.O_OS);
		}
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Organization.class, TreeViewUtils.basicOrganizationProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String list() throws Exception {
		Organization organization = organizationService.getOrganization(id);
		Site siteSelf = siteService.getSite(organization.getSiteId());
		
		CriteriaBuilder cb = Cnd.builder(UserGroup.class);
		cb.andEQ("PARENT_ID", organization.getSiteId());
		
		PagingResult<Site> result = siteService.findSite(cb.buildCriteria());
		result.getResult().add(0, siteSelf);
		
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(User.class, TreeViewUtils.basicSiteProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String name() throws Exception {
		return null;
	}

}
