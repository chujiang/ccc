package com.kingnod.etraining.workflow.entity;

public class MembershipEntity extends org.activiti.engine.impl.persistence.entity.MembershipEntity{
	
	 private static final long serialVersionUID = 1L;

	  protected UserEntity user;
	  protected GroupEntity group;

	  public Object getPersistentState() {
	    // membership is not updatable
	    return MembershipEntity.class;
	  }
	  public String getId() {
	    // membership doesn't have an id
	    return null;
	  }
	  public void setId(String id) {
	    // membership doesn't have an id
	  }

	  public UserEntity getUser() {
	    return user;
	  }
	  public void setUser(UserEntity user) {
	    this.user = user;
	  }
	  public GroupEntity getGroup() {
	    return group;
	  }
	  public void setGroup(GroupEntity group) {
	    this.group = group;
	  }

}
