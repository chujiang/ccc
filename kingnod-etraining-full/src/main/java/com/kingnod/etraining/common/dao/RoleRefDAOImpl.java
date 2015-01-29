package com.kingnod.etraining.common.dao;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.common.entity.RoleRef;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
public class RoleRefDAOImpl extends MybatisEntityDAO<RoleRef, Long> implements RoleRefDAO {

	/**
	 * 删除当前用户下所有的角色
	 * @param ownerId
	 */
	public void delRoleByUser(Long ownerId){
		getSqlSession().delete("delRoleByUser",ownerId);
	}
}