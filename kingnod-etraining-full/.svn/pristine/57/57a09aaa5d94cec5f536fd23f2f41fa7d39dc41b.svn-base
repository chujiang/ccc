package com.kingnod.etraining.organization.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.organization.entity.User;

@com.kingnod.core.annotation.Generated("2012-02-02 11:40")
public interface UserDAO extends EntityDAO<User, Long> {
	List<Long> findUserIdsByCriteria(Criteria criteria);
	
	/**
	 * 查询满足用户组条件设置的新进来的用户
	 * @param criteria
	 * @return
	 */
	List<Long> findNewUserIdsByCriteria(Criteria criteria);
	
	/**
	 * 查询不满足用户组条件的将被剔除的用户
	 * @param criteria
	 * @return
	 */
	List<Long> findRemovedUserIdsByCriteria(Criteria criteria);
	
	/**
	 * 查询满足 学员用户 组条件设置的新进来的用户
	 * @param criteria
	 * @return
	 */
	List<Long> findNewEnrollIdsByCriteria(Criteria criteria);
	
	/**
	 * 查询不满足 学员 用户组条件的将被剔除的用户
	 * @param criteria
	 * @return
	 */
	List<Long> findRemovedEnrollIdsByCriteria(Criteria criteria);
	
	/**
	 * 查询所有有读取权限的用户
	 * @param criteria
	 * @return
	 */
	public List<User> findAllReadByCriteria(Criteria criteria);
	
	
	/**
	 * 搜索用户组改变中未发送通知的人
	 * @param criteria
	 * @return
	 */
	public List<User> findNoSendNoticeUserByCriteria(Criteria criteria) ;
	
	
	/**
	 * 搜索学员组改变中未发送通知的人
	 * @param criteria
	 * @return
	 */
	public List<User> findNoSendNoticeEnrollByCriteria(Criteria criteria) ;
	
	
	/**
	 * 根据站点ID，获取要导出的用户列表
	 * @param siteId
	 * @return
	 */
	public List<User> getUsersForExport(Long siteId);
	
}