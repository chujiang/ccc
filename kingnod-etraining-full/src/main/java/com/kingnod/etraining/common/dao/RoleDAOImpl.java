package com.kingnod.etraining.common.dao;

import java.util.List;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.common.entity.Role;

@org.springframework.stereotype.Repository

@com.kingnod.core.annotation.Generated("2012-03-06 15:30")
public class RoleDAOImpl extends MybatisEntityDAO<Role, Long> implements RoleDAO {

	public List<Role> getRoleByUser(Long userId){
		return getSqlSession().selectList("findRoleByUserId",userId);
	}
}