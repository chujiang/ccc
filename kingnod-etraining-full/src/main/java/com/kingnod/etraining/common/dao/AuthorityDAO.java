package com.kingnod.etraining.common.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.common.entity.Authority;
import com.kingnod.etraining.common.entity.AuthorityRef;
import com.kingnod.etraining.common.entity.RoleAuthorityRef;
import com.kingnod.etraining.organization.entity.Function;

/**
 * 系统权限信息DAO
 * @author Liuxiaobing
 * @author Sam
 *
 */
@com.kingnod.core.annotation.Generated("2012-03-07 15:30")
public interface AuthorityDAO extends EntityDAO<Authority, Long> {
	public List<AuthorityRef> findAuthorityById(Long id);

	public void deleteAuthorityRefByRoleId(Long id);

	public void insertAuthorityRef(RoleAuthorityRef authorityRef);

	public List<Function> findFunctionStair(Map params);
	
	public List<Function> findFunctionSecondary(Long id);
	
	public List<Authority> findFunctionAuthority(Long id);
}