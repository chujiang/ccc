package com.kingnod.etraining.common.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.common.entity.Authority;
import com.kingnod.etraining.common.entity.AuthorityRef;
import com.kingnod.etraining.common.entity.DefinedAuthority;
import com.kingnod.etraining.common.entity.DefinedFunction;
import com.kingnod.etraining.common.entity.DefinedRoleFunction;
import com.kingnod.etraining.common.entity.DefinedUltimate;
import com.kingnod.etraining.organization.entity.Function;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.common.entity.RoleAuthority;
import com.kingnod.etraining.common.service.AuthorityService;
import com.kingnod.etraining.common.service.RoleService;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results({
		@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "authority", "namespace", "/cmn", "roleId", "${roleId}", "siteId", "${siteId}" }),
		@Result(name = "roleList", type = "redirectAction", params = {"actionName", "role", "namespace", "/cmn", "siteId", "${siteId}" }) })
		
public class AuthorityAction extends FilterableEntityAction<Authority, Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Long roleId = 0L; // 角色ID
	private RoleAuthority roleAuthority = null;
	private DefinedUltimate definedUltimate = null;
	private Long siteId;

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-03-07 15:30")
	private AuthorityService authorityService;

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-03-07 15:30")
	private RoleService roleService;

	
	@com.kingnod.core.annotation.Generated("2012-03-07 15:30")
	public String filterDefines() {
		return "cmn.authorityFilterItems";
	}

	/**
	 * 根据角色Id查询当前角色所有权限
	 * @return String
	 */
	public String getRoleAuthorityById() {
		buildAuthority();
		return EntityAction.RELOAD;
	}
	

	/**
	 * 根据角色Id查询当前角色所有权限
	 * @return String
	 */
	@Override
	public String execute() throws Exception {
		buildAuthority();
		return super.execute();
	}
	

	/**
	 * 构造数据
	 */
	public void buildAuthority() {
		List<AuthorityRef> listAuthorityRef = authorityService.getAuthorityID(roleId);// 获取当前角色所拥有的权限
		
		definedUltimate = new DefinedUltimate();// 终极对象
		Role role = roleService.getRole(roleId);// 获取当前角色对象
		definedUltimate.setRoleId(role.getId());
		definedUltimate.setRoleName(role.getName());

		List<DefinedRoleFunction> listDefinedRoleFunction = new ArrayList<DefinedRoleFunction>();
		List<Function> listStair = authorityService.findFunctionStair("");// 获取一级菜单
		for (Function funStair : listStair) {
			DefinedRoleFunction definedRoleFunction = new DefinedRoleFunction();// 组合一级菜单对象
			definedRoleFunction.setFunctionId(funStair.getId());
			definedRoleFunction.setFunctionName(funStair.getName());

			List<DefinedFunction> listDefinedFunction = new ArrayList<DefinedFunction>();
			List<Function> secondaryList = authorityService.findFunctionSecondary(funStair.getId());//获取二级菜单
			for (Function funSecondary : secondaryList) {
				DefinedFunction definedFunction = new DefinedFunction();
				definedFunction.setId(funSecondary.getId());
				definedFunction.setName(funSecondary.getName());

				List<DefinedAuthority> listDefinedAuthority = new ArrayList<DefinedAuthority>();
				List<Authority> listAuthority = authorityService.findFunctionAuthority(funSecondary.getId());//获取二级菜单的所有权限
				for (Authority authority : listAuthority) {
					DefinedAuthority definedAuthority = new DefinedAuthority();
					definedAuthority.setId(authority.getId());
					definedAuthority.setName(authority.getName());

					for (AuthorityRef authorityList : listAuthorityRef) {
						if (authorityList.getId().longValue() == authority.getId().longValue()) {
							definedAuthority.setIsRoleAuthority("true");// 设置当前角色有的权限
							break;
						}
					}
					listDefinedAuthority.add(definedAuthority);
				}
				definedFunction.setList(listDefinedAuthority);

				listDefinedFunction.add(definedFunction);
			}
			definedRoleFunction.setList(listDefinedFunction);

			listDefinedRoleFunction.add(definedRoleFunction);
		}
		definedUltimate.setList(listDefinedRoleFunction);
	}

	
	/**
	 * 保存用户授权信息
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String applicationAuthority() throws Exception {
		List<Long> aId = new ArrayList<Long>();
		HttpServletRequest request = ServletActionContext.getRequest();// 获取request对象
		String[] ids = request.getParameter("ids").split(",");
		for (String str : ids) {
			Long aid = parseLong(str);
			if (aid != null) {
				aId.add(aid);
			}
		}
		String roleId = request.getParameter("roleId");
		Long roleIds = parseLong(roleId);
		if (roleIds != null) {
			authorityService.applicationAuthority(roleIds, aId);
		}
		return EntityAction.RELOAD;
	}
	

	/**
	 * 返回角色主界面
	 * 
	 * @return String
	 */
	public String getBack() {
		return "roleList";
	}

	
	/**
	 * 将字符串强转成Long类型
	 * 
	 * @param str
	 * @return Long
	 */
	public Long parseLong(String str) {
		try {
			if (StringUtils.isNotEmpty(str)) {
				return Long.parseLong(str);
			}
		} catch (Exception e) {

		}
		return null;
	}
	

	public DefinedUltimate getDefinedUltimate() {
		return definedUltimate;
	}

	public void setDefinedUltimate(DefinedUltimate definedUltimate) {
		this.definedUltimate = definedUltimate;
	}

	public RoleAuthority getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(RoleAuthority roleAuthority) {
		this.roleAuthority = roleAuthority;
	}

	@com.kingnod.core.annotation.Generated("2012-03-07 15:30")
	protected Object getEntityService() {
		return this.authorityService;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
}