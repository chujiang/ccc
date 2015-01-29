/**
 * 
 */
package com.kingnod.etraining.security.impl;


import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.etraining.security.PermissionAuthorityService;
import com.kingnod.etraining.security.dao.EntityPermissionDAO;
import com.kingnod.etraining.security.entity.EntityPermission;

/**
 * 数据级权限功能的Service实现
 * 
 * @author liuxiaobin
 *
 */
@org.springframework.stereotype.Service
public class PermissionAuthorityServiceImpl implements PermissionAuthorityService{
	
	@Autowired
    protected EntityPermissionDAO entityPermissionDAO;
	
	public void setEntityPermissionDAO(EntityPermissionDAO entityPermissionDAO) {
		this.entityPermissionDAO = entityPermissionDAO;
	}
	/**
	 * 为某条数据设置一个权限
	 * @param ep
	 */
	public void insertEntityPermission(EntityPermission ep) {
		entityPermissionDAO.insert(ep);
	}

	/**
	 * 更新某条数据权限
	 * @param ep
	 */
	public void update(EntityPermission ep) {
		entityPermissionDAO.update(ep);
	}

	/**
	 * 删除某条数据权限
	 * @param ep
	 */
	public void delete(EntityPermission ep) {
		entityPermissionDAO.delete(ep);
	}

	/**
	 * 获取某条数据权限
	 * @param eo
	 * @param owner
	 * @return EntityPermission
	 */
	public EntityPermission get(EntityPermission permission) {
		return entityPermissionDAO.get(permission);
	}
}
