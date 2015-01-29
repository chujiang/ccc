package com.kingnod.etraining.common.dao;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.common.entity.RoleRef;


    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
public interface RoleRefDAO extends EntityDAO<RoleRef, Long> {
	public void delRoleByUser(Long ownerId);
}