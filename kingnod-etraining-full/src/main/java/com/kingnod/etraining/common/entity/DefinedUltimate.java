/**
 * 
 */
package com.kingnod.etraining.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaobin
 *	终极对象(包含所有一级菜单对象)
 */
public class DefinedUltimate{
	private Long roleId;
	private String roleName;
	private List<DefinedRoleFunction> list = new ArrayList<DefinedRoleFunction>();
	
	public DefinedUltimate(){}
	
	public DefinedUltimate(Long roleId, String roleName, List<DefinedRoleFunction> list) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.list = list;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<DefinedRoleFunction> getList() {
		return list;
	}
	public void setList(List<DefinedRoleFunction> list) {
		this.list = list;
	}
}
