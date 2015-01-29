package com.kingnod.etraining.common.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.common.service.RoleService;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.SiteService;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "role", "namespace", "/cmn", "siteId", "${siteId}"})
}
)

@com.kingnod.core.annotation.Generated("2012-03-06 15:30")
public class RoleAction extends FilterableEntityAction<Role, Long> {

	private Long siteId = 0L;//站点Id
	
	private List<Long> listSiteId = new ArrayList<Long>();//父节点Id，祖父节点Id
	 
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    private RoleService roleService;
	
	@Autowired
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    private SiteService siteService;
    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    public String filterDefines() {
        return "cmn.roleFilterItems";
    }
    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    protected Object getEntityService() {
        return this.roleService;
    }
    
	@Override
	public String list() throws Exception {
		listSiteId.clear();
		getParentSiteId(siteId);
		
		CriteriaBuilder cb = Cnd.builder(Role.class);
		cb.andEQ("siteId", siteId);
		PagingResult<Role> pagingResult = roleService.findRole(cb.buildCriteria());//获取当前站点Id
		List<Role> listRole = pagingResult.getResult();
		
		for(Long id : listSiteId){
			List<Role> pRole = roleService.findRoleBySiteId(id);//获取父站点的角色
			for (Role role : pRole) {
				role.setName(role.getName() + "(被继承的)");
			}
			listRole.addAll(pRole);
		}
		
		pager.setTotalCount(pagingResult.getTotalRows());
		pager.setResult(pagingResult.getResult());
		request.setAttribute("page", pager);
		return SUCCESS;
	}
	
	/**
	 * 获取父节点Id，祖父节点Id
	 * @param pSiteId
	 */
	public void getParentSiteId(Long pSiteId){
		if(pSiteId != 0){
			Site site = siteService.getSite(pSiteId);
			listSiteId.add(site.getParentId());
			getParentSiteId(site.getParentId());
		}
	}
    
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
}