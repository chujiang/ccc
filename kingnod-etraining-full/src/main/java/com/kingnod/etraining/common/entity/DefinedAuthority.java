/**
 * 
 */
package com.kingnod.etraining.common.entity;

/**
 * @author liuxiaobin
 * 二级菜单下的权限对象
 */
public class DefinedAuthority extends Authority{
	/**
	 * 判断该角色是否有当前权限
	 */
	private String isRoleAuthority = "false";

	public DefinedAuthority(){}
	
	public DefinedAuthority(String isRoleAuthority) {
		super();
		this.isRoleAuthority = isRoleAuthority;
	}

	public String getIsRoleAuthority() {
		return isRoleAuthority;
	}

	public void setIsRoleAuthority(String isRoleAuthority) {
		this.isRoleAuthority = isRoleAuthority;
	}
}
