package com.kingnod.etraining.workflow.service;

import java.util.HashMap;
import java.util.Map;

import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.dao.UserGroupDAO;
import com.kingnod.etraining.organization.dao.UserGroupUsersDAO;
import com.kingnod.etraining.organization.entity.UserGroupUsers;


public class MembershipManager extends org.activiti.engine.impl.persistence.entity.MembershipManager {
	
	private UserGroupDAO userGroupDAO;
	private UserDAO userDAO;
	private UserGroupUsersDAO userGroupUsersDAO;
	
	public void createMembership(String userId, String groupId) {
//	    Map<String, Object> parameters = new HashMap<String, Object>();
//	    parameters.put("userId", userId);
//	    parameters.put("groupId", groupId);
//	    getDbSqlSession().getSqlSession().insert("insertMembership", parameters);
		UserGroupUsers userGroupUsers=new UserGroupUsers();
		userGroupUsers.setUserId(Long.valueOf(userId));
		userGroupUsers.setUserGroupId(Long.valueOf(groupId));
		userGroupUsersDAO.insert(userGroupUsers);
	    
	  }

	  public void deleteMembership(String userId, String groupId) {
//	    Map<String, Object> parameters = new HashMap<String, Object>();
//	    parameters.put("userId", userId);
//	    parameters.put("groupId", groupId);
//	    getDbSqlSession().delete("deleteMembership", parameters);
	    UserGroupUsers userGroupUsers=new UserGroupUsers();
		userGroupUsers.setUserId(Long.valueOf(userId));
		userGroupUsers.setUserGroupId(Long.valueOf(groupId));
		userGroupUsersDAO.delete(userGroupUsers);
	  }

}
