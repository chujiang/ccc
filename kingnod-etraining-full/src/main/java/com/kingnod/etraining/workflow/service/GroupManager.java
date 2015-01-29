package com.kingnod.etraining.workflow.service;

import java.util.List;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.db.PersistentObject;
import org.activiti.engine.impl.Page;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.dao.UserGroupDAO;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.workflow.entity.GroupEntity;

/**
 * 自定义角色
 * @author binfeng
 *
 */
public class GroupManager extends org.activiti.engine.impl.persistence.entity.GroupManager {
	
	private UserGroupDAO userGroupDAO;
	private UserDAO userDAO;
	
	public Group createNewGroup(String groupId) {
		return (Group) userGroupDAO.get(Long.valueOf(groupId));
	  }

	  public void insertGroup(Group group) {
	    getDbSqlSession().insert((PersistentObject) group);
	  }

	  public void updateGroup(Group updatedGroup) {
	    GroupEntity persistentGroup = findGroupById(updatedGroup.getId());
	    persistentGroup.update((GroupEntity) updatedGroup);
	  }


	  public void deleteGroup(String groupId) {
	    getDbSqlSession().delete("deleteMembershipsByGroupId", groupId);
	    getDbSqlSession().delete("deleteGroup", groupId);
	  }

	  public GroupQuery createNewGroupQuery() {
	    return new GroupQueryImpl(Context.getProcessEngineConfiguration().getCommandExecutorTxRequired());
	  }

	  @SuppressWarnings("unchecked")
	  public List<Group> findGroupByQueryCriteria(Object query, Page page) {
		  List<Group> grList=null;
		  List<UserGroup> ugrList=userGroupDAO.findByCriteria((Criteria) query);
		  for(int i=0;i<ugrList.size();i++){
			  grList.get(i).setId(String.valueOf(ugrList.get(i).getId()));
			  grList.get(i).setName(ugrList.get(i).getName());
//			  grList.get(i).setType(String.valueOf(ugrList.get(i).getSiteId()));
			  
		  }
//	    return getDbSqlSession().selectList("selectGroupByQueryCriteria", query);
		  return grList;
	  }
	  
	  public long findGroupCountByQueryCriteria(Object query) {
//	    return (Long) getDbSqlSession().selectOne("selectGroupCountByQueryCriteria", query);
	    return  userGroupDAO.countByCriteria((Criteria) query);
	  }

	  public GroupEntity findGroupById(String groupId) {
		  UserGroup userGroup=new UserGroup();
		  GroupEntity groupEntity=new GroupEntity(String.valueOf(userGroup.getId()));
		  groupEntity.setName(userGroup.getName());
		  
//	    return (GroupEntity) getDbSqlSession().selectOne("selectGroupById", groupId);
		  return groupEntity;
	  }

	  @SuppressWarnings("unchecked")
	  public List<Group> findGroupsByUser(String userId) {
	    return getDbSqlSession().selectList("selectGroupsByUserId", userId);
	  }
	
	

}
