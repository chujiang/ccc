package com.kingnod.etraining.common.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.common.entity.Authority;
import com.kingnod.etraining.common.entity.AuthorityRef;
import com.kingnod.etraining.common.entity.RoleAuthorityRef;
import com.kingnod.etraining.organization.entity.Function;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-07 15:30")
public class AuthorityDAOImpl extends MybatisEntityDAO<Authority, Long> implements AuthorityDAO {

	/**
	 * 查询当前角色的所有权限
	 */
	public List<AuthorityRef> findAuthorityById(Long id){
		return getSqlSession().selectList("findAuthorityById", id);
	}
	
	/**
	 * 删除当前角色的所有权限
	 * @param id
	 */
	public void deleteAuthorityRefByRoleId(Long id){
		getSqlSession().delete("deleteAuthorityRefByRoleId",id);
	}
	
	/**
	 * 根据Id添加权限引用
	 * @param authorityRef
	 */
	public void insertAuthorityRef(RoleAuthorityRef authorityRef){
		getSqlSession().insert("insertAuthorityRef",authorityRef);
	}
	
	/**
	 * 获取function表中的一级功能菜单
	 * @return List<?>
	 */
	public List<Function> findFunctionStair(Map params){
		return getSqlSession().selectList("findFunctionStair",params);
	}
	
	/**
	 * 获取function表中的二级功能菜单
	 * @return List<?>
	 */
	public List<Function> findFunctionSecondary(Long id){
		return getSqlSession().selectList("findFunctionSecondary",id);
	}
	
	/**
	 * 根据function表中的二级功能菜单，查询该菜单下的权限
	 * @return List<?>
	 */
	public List<Authority> findFunctionAuthority(Long id){
		return getSqlSession().selectList("findFunctionAuthority",id);
	}
}