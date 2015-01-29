package com.kingnod.etraining.workflow.entity;

import java.util.HashMap;
import java.util.Map;

public class GroupEntity extends org.activiti.engine.impl.persistence.entity.GroupEntity{
	private static final long serialVersionUID = 1L;

	  protected String id;
	  protected int revision;
	  protected String name;
	  protected String type;
	  
	  public GroupEntity() {
	  }
	  
	  public GroupEntity(String id) {
	    this.id = id;
	  }
	  
	  public void update(GroupEntity group) {
	    this.name = group.getName();
	    this.type = group.getType();
	  }
	  
	  public Object getPersistentState() {
	    Map<String, Object> persistentState = new HashMap<String, Object>();
	    persistentState.put("name", name);
	    persistentState.put("type", type);
	    return persistentState;
	  }
	  
	  public int getRevisionNext() {
	    return revision+1;
	  }

	  public String getId() {
	    return id;
	  }
	  public void setId(String id) {
	    this.id = id;
	  }
	  public String getName() {
	    return name;
	  }
	  public void setName(String name) {
	    this.name = name;
	  }
	  public String getType() {
	    return type;
	  }
	  public void setType(String type) {
	    this.type = type;
	  }
	  public int getRevision() {
	    return revision;
	  }
	  public void setRevision(int revision) {
	    this.revision = revision;
	  }

}
