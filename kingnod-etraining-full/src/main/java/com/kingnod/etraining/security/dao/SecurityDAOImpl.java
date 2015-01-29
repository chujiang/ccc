package com.kingnod.etraining.security.dao;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.Assert;

import com.kingnod.core.dao.MybatisDaoSupport;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.common.entity.Authority;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.security.entity.UrlAuthority;

/**
 * 安全DAO接口实现类
 * @author Sam
 *
 */ 
public class SecurityDAOImpl extends MybatisDaoSupport implements SecurityDAO {
	
	

	public User findUserByUsername(String siteName, String username,boolean isAdminPlatform) {
		Assert.hasText(siteName,"the sitename must not be empty!");
		Assert.hasText(username,"the username must not be empty!");
		Map paramMap = MapUtils.mapByAarray("username",username,"siteName",siteName,"isAdminPlatform",isAdminPlatform);
		User user = (User) getSqlSession().selectOne("Security.findUserByUsername", paramMap);
		return user;
	}

	public Collection<UrlAuthority> findAllUrlAuthority() {
		return ( Collection<UrlAuthority> )getSqlSession().selectList("Security.findAllUrlAuthority");
	}

	public Collection<Authority> findUrlAuthorityByUser(User user) {
		Assert.notNull(user,"the User must not be null!");
		Assert.notNull(user.getId(),"the userId must not be null!");
		Collection<Authority> authList = (Collection<Authority>)getSqlSession().selectList("Security.findAuthorityByUser",user);
		return authList;
	}

	public Collection<UserGroup> findGroupByUser(User user) {
		Assert.notNull(user,"the User must not be null!"); 
		Collection<UserGroup> groups = (Collection<UserGroup>)getSqlSession().selectList("Security.findGroupsByUser",user);
		return groups;
	}

	public Collection<Role> findRoleByUser(User user) {
		Assert.notNull(user,"the User must not be null!");
		Collection<Role> roles = (Collection<Role>)getSqlSession().selectList("Security.findRolesByUser",user);
		return roles;
	}

 

	 

}
