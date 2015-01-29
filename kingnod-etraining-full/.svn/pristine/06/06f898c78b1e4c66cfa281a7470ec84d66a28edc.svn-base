package com.kingnod.etraining.organization.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.organization.entity.User;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-02-02 11:40")
public class UserDAOImpl extends MybatisEntityDAO<User, Long> implements
		UserDAO {
	
	@Autowired
	protected OrganizationDAO organizationDAO;
	
	@Override
	protected void afterInsert(User entity) {
		CriteriaBuilder cb = Cnd.builder(User.class);
		cb.andEQ("id", entity.getId());
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "ORG_USER");
		organizationDAO.updateObjectCount(criteria);
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		CriteriaBuilder cb = Cnd.builder(User.class);
		cb.andIn("id", ListUtils.of(ids));
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "ORG_USER");
		organizationDAO.updateObjectCount(criteria);
	}
	
	public List<Long> findUserIdsByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findUserIdsByCriteria"), criteria);
	}
	
	public List<User> findAllReadByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findAllReadByCriteria"), criteria);
	}
	/**
	 * 查询满足  用户组条件的将被剔除的用户
	 * @author maxudong
	 * @param criteria
	 * @return
	 */
	public List<Long> findNewUserIdsByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findNewUserIdsByCriteria"), criteria);
	}
	 /**
	 * 查询不满足用户 组条件设置的新进来的用户
	 * @author maxudong
	 * @param criteria
	 * @return
	 */
	public List<Long> findRemovedUserIdsByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findRemovedUserIdsByCriteria"), criteria);
	}

	/**
	 * 查询满足 学员用户 组条件设置的新进来的用户
	 * @author maxudong
	 * @param criteria
	 * @return
	 */
	public List<Long> findNewEnrollIdsByCriteria(Criteria criteria){
		return getSqlSession().selectList(sqlId("findNewEnrollIdsByCriteria"), criteria);
	}
	
	/**
	 * 查询不满足 学员 用户组条件的将被剔除的用户
	 * @author maxudong
	 * @param criteria
	 * @return
	 */
	public List<Long> findRemovedEnrollIdsByCriteria(Criteria criteria){
		return getSqlSession().selectList(sqlId("findRemovedEnrollIdsByCriteria"), criteria);
	}
	/**
	 * 搜索用户组改变中未发送通知的人
	 * @param criteria
	 * @return
	 */
	public List<User> findNoSendNoticeUserByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findNoSendNoticeUserByCriteria"), criteria);
	}
	/**
	 * 搜索学员组改变中未发送通知的人
	 * @param criteria
	 * @return
	 */
	public List<User> findNoSendNoticeEnrollByCriteria(Criteria criteria){
		return getSqlSession().selectList(sqlId("findNoSendNoticeEnrollByCriteria"), criteria);
	}
	
	/**
	 * 根据站点ID，获取要导出的用户列表
	 * @param siteId
	 * @return
	 */
	public List<User> getUsersForExport(Long siteId) {
		return getSqlSession().selectList(sqlId("getUsersForExport"), siteId);
	}
	
}