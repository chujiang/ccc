package com.kingnod.etraining.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.workflow.entity.UserEntity;

/**
 * 自定义用户
 * 
 * @author binfeng
 * 
 */
public class UserManager extends
		org.activiti.engine.impl.persistence.entity.UserManager {

	protected UserDAO userDAO;

	public User createNewUser(String userId) {
		// return new UserEntity(userId);
		return (User) userDAO.get(Long.valueOf(userId));
	}

	public void insertUser(com.kingnod.etraining.organization.entity.User user) {
		// getDbSqlSession().insert((PersistentObject) user);
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) user;
		if (null != idEntity.getId() && null != userDAO.get(idEntity.getId())) {
			count = userDAO.update(user);
		} else {
			count = userDAO.insert(user);
		}

	}

	public void updateUser(
			com.kingnod.etraining.organization.entity.User updatedUser) {
		// UserEntity persistentUser = findUserById(updatedUser.getId());
		// persistentUser.update((UserEntity) updatedUser);
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) updatedUser;
		if (null != idEntity.getId() && null != userDAO.get(idEntity.getId())) {
			count = userDAO.update(updatedUser);
		} else {
			count = userDAO.insert(updatedUser);
		}
	}

	public UserEntity findUserById(String userId) {
		com.kingnod.etraining.organization.entity.User user = new com.kingnod.etraining.organization.entity.User();
		UserEntity entity = new UserEntity(String.valueOf(user.getId()));
		entity.setFirstName(user.getFullName());
		entity.setLastName(user.getLoginName());
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		return entity;
	}

	@SuppressWarnings("unchecked")
	public void deleteUser(String userId) {
//		UserEntity user = findUserById(userId);
//		if (user != null) {
//			if (user.getPictureByteArrayId() != null) {
//				getDbSqlSession().delete(ByteArrayEntity.class,
//						user.getPictureByteArrayId());
//			}
//			List<IdentityInfoEntity> identityInfos = getDbSqlSession()
//					.selectList("selectIdentityInfoByUserId", userId);
//			for (IdentityInfoEntity identityInfo : identityInfos) {
//				getIdentityInfoManager().deleteIdentityInfo(identityInfo);
//			}
//			getDbSqlSession().delete("deleteMembershipsByUserId", userId);
//			getDbSqlSession().delete("deleteUser", userId);
//		}
		userDAO.deleteById(Long.valueOf(userId));
	}

	@SuppressWarnings({ "unchecked", "null" })
	public List<User> findUserByQueryCriteria(Object query, Page page) {
		List<User> actUserList = null;
		List<com.kingnod.etraining.organization.entity.User> userList=userDAO.findAll();
		for (int i=0;i<userList.size();i++) {
			actUserList.get(i).setId(String.valueOf(userList.get(i).getId()));
			actUserList.get(i).setFirstName(userList.get(i).getFullName());
			actUserList.get(i).setLastName(userList.get(i).getLoginName());
			actUserList.get(i).setEmail(userList.get(i).getEmail());
		}
		return actUserList;

	}

	public long findUserCountByQueryCriteria(Object query) {
		
//		return (Long) getDbSqlSession().selectOne(
//				"selectUserCountByQueryCriteria", query);
		return userDAO.countByCriteria((Criteria) query);
	}

	@SuppressWarnings("unchecked")
	public List<Group> findGroupsByUser(String userId) {
		return getDbSqlSession().selectList("selectGroupsByUserId", userId);
	}

	public UserQuery createNewUserQuery() {
		return new UserQueryImpl(Context.getProcessEngineConfiguration()
				.getCommandExecutorTxRequired());
	}

	public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId,
			String key) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("userId", userId);
		parameters.put("key", key);
		return (IdentityInfoEntity) getDbSqlSession().selectOne(
				"selectIdentityInfoByUserIdAndKey", parameters);
	}

	@SuppressWarnings("unchecked")
	public List<String> findUserInfoKeysByUserIdAndType(String userId,
			String type) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("userId", userId);
		parameters.put("type", type);
		return (List) getDbSqlSession().getSqlSession().selectList(
				"selectIdentityInfoKeysByUserIdAndType", parameters);
	}

	public Boolean checkPassword(String userId, String password) {
		User user = findUserById(userId);
		if ((user != null) && (password != null)
				&& (password.equals(user.getPassword()))) {
			return true;
		}
		return false;
	}
}
