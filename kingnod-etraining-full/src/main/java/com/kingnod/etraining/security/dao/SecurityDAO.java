package com.kingnod.etraining.security.dao;

import java.util.Collection;

import com.kingnod.etraining.common.entity.Authority;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.security.entity.UrlAuthority;

/**
 * 实全服务数据访问类
 * @author Sam
 *
 */
public interface SecurityDAO {
	/**
	 * 根据站点名称查找某个用户
	 * @param siteName 站点名称
	 * @param username 用户名称
	 * @param isAdminLogin 是否管理员界面登录
	 * @return
	 */
	User findUserByUsername(String siteName,String username,boolean isAdminLogin);
	
	/**
	 * 查找某个用户所属的用户组
	 * @param user 用户信息
	 * @return
	 */
	Collection<UserGroup> findGroupByUser(User user);
	
	/**
	 * 查找某个用户拥有的角色
	 * @param user 用户信息
	 * @return
	 */
	Collection<Role> findRoleByUser(User user);
	
	/**
	 * 取得所有受控资源信息
	 * @return
	 */
	Collection<UrlAuthority> findAllUrlAuthority();
	
	/**
	 * 查找某个用户所拥有的权限
	 * @param user 用户信息
	 * @return
	 */
	Collection<Authority> findUrlAuthorityByUser(User user);
}
