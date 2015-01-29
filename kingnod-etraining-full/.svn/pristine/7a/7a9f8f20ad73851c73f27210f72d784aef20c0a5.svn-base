/**
 * 
 */
package com.kingnod.etraining.common.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;

@SelectColumnMappings({
	  @SelectColumnMapping(property = "ownerId", type = java.lang.Long.class, table = "SYS_AUTHORITY_REF", tableAlias = "A", column = "OWNER_ID"), 
	  @SelectColumnMapping(property = "ownerType", type = java.lang.String.class, table = "SYS_AUTHORITY_REF", tableAlias = "A", column = "OWNER_TYPE"), 
	  @SelectColumnMapping(property = "authorityId", type = java.lang.Long.class, table = "SYS_AUTHORITY_REF", tableAlias = "A", column = "AUTHORITY_ID")
	})
	
/**
 * @author liuxiaobin
 * 角色权限引用表
 */
public class RoleAuthorityRef {
	private Long ownerId;
	private String ownerType;
	private Long authorityId;
	
	public RoleAuthorityRef(){}
	
	public RoleAuthorityRef(Long ownerId, String ownerType, Long authorityId) {
		super();
		this.ownerId = ownerId;
		this.ownerType = ownerType;
		this.authorityId = authorityId;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public Long getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}
}
