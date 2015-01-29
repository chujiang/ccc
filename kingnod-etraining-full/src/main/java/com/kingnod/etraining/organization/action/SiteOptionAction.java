package com.kingnod.etraining.organization.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.ExtendedActionSupport;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.service.AuthorityService;
import com.kingnod.etraining.organization.entity.Function;
import com.kingnod.etraining.organization.entity.FunctionObj;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.service.FunctionService;
import com.kingnod.etraining.organization.service.OrganizationService;

/**
 * 站点导航Action.
 * 
 * @author Huanghb
 */

@org.springframework.stereotype.Controller
@org.apache.struts2.convention.annotation.Namespace("/org")
public class SiteOptionAction extends ExtendedActionSupport {

	private static final long serialVersionUID = 1L;
	private Long siteId;
	private Long organizationId;
	private List<FunctionObj> listFo = new ArrayList<FunctionObj>();

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-06 16:47")
	private FunctionService functionService;

	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private OrganizationService organizationService;

	@Override
	public String execute() throws Exception {
		List<Function> listStair = authorityService.findFunctionStair("SYS_MENU");// 获取一级菜单
		for (Function functionStair : listStair) {
			FunctionObj functionObj = new FunctionObj();
			functionObj.setId(functionStair.getId());
			functionObj.setName(functionStair.getName());
			functionObj.setUri(functionStair.getUri());

			List<Function> listSecondary = authorityService
					.findFunctionSecondary(functionStair.getId());// 获取二级菜单
			functionObj.setList(listSecondary);
			listFo.add(functionObj);
		}
		return super.execute();
	}

	public List<FunctionObj> getListFo() {
		return listFo;
	}

	public void setListFo(List<FunctionObj> listFo) {
		this.listFo = listFo;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	public FunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionServiceImpl(FunctionService functionService) {
		this.functionService = functionService;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
}
