/**
 * 
 */
package com.kingnod.etraining.security;

import com.kingnod.etraining.security.entity.EntityPermission;

/**
 * 数据级权限的Service接口
 * 
 * @author liuxiaobin
 *
 */
public interface PermissionAuthorityService {
	
	public void insertEntityPermission(EntityPermission ep);
	
	public void update(EntityPermission ep);
	
	public void delete(EntityPermission ep);
	
	public EntityPermission get(EntityPermission permission);
}
