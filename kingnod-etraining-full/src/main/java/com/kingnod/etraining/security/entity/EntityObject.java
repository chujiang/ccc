package com.kingnod.etraining.security.entity;

import com.kingnod.etraining.common.ObjectType;

/**
 * 实体对象实例
 * @author Sam
 *
 */
public class EntityObject {
	private int entityId;
	private ObjectType entityType;
	public EntityObject(){}
	public EntityObject(int entityId, ObjectType entityType) {
		super();
		this.entityId = entityId;
		this.entityType = entityType;
	}
	
	public int getEntityId() {
		return entityId;
	}
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	public ObjectType getEntityType() {
		return entityType;
	}
	public void setEntityType(ObjectType entityType) {
		this.entityType = entityType;
	}
	
}
