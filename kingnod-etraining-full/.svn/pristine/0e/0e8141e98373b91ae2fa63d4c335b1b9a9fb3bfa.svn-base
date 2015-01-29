package com.kingnod.etraining.common.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.Menu;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.SiteService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/cmn")
public class NavigationAction extends ActionSupport {

	private static final long serialVersionUID = 4242612202520616657L;
	
	@Autowired
	private SiteService siteService;
	
	private Long id = 0L;
	private ObjectType objectType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String execute() throws Exception {
		
		Struts2Utils.getRequest().setAttribute("treeType", "organization_tree");
		List<Menu> listMenu = TreeViewUtils.getMenuDAO().getMenu("ORG_COMMON_MENU");
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Menu.class, TreeViewUtils.menuProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", listMenu);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}

	/**
	 * @return the objectType
	 */
	public ObjectType getObjectType() {
		return objectType;
	}

	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}
	
}
