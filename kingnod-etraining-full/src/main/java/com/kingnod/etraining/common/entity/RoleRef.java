package com.kingnod.etraining.common.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "SYS_ROLE_REF", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "ownerId", type = java.lang.Long.class, table = "SYS_ROLE_REF", tableAlias = "A", column = "OWNER_ID"), 
  @SelectColumnMapping(property = "roleId", type = java.lang.Long.class, table = "SYS_ROLE_REF", tableAlias = "A", column = "ROLE_ID"), 
  @SelectColumnMapping(property = "ownerType", type = java.lang.String.class, table = "SYS_ROLE_REF", tableAlias = "A", column = "OWNER_TYPE")
})

    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
public class RoleRef {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.SYS_ROLE_REF.ID
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    private Long id;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.SYS_ROLE_REF.OWNER_ID
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    private Long ownerId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.SYS_ROLE_REF.ROLE_ID
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    private Long roleId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.SYS_ROLE_REF.OWNER_TYPE
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    private String ownerType;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.SYS_ROLE_REF.ID
     *
     * @返回  ETRAINING.SYS_ROLE_REF.ID
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.SYS_ROLE_REF.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.SYS_ROLE_REF.OWNER_ID
     *
     * @返回  ETRAINING.SYS_ROLE_REF.OWNER_ID
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.SYS_ROLE_REF.OWNER_ID
     *
     * @param ownerId null
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.SYS_ROLE_REF.ROLE_ID
     *
     * @返回  ETRAINING.SYS_ROLE_REF.ROLE_ID
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public Long getRoleId() {
        return roleId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.SYS_ROLE_REF.ROLE_ID
     *
     * @param roleId null
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.SYS_ROLE_REF.OWNER_TYPE
     *
     * @返回  ETRAINING.SYS_ROLE_REF.OWNER_TYPE
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public String getOwnerType() {
        return ownerType;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.SYS_ROLE_REF.OWNER_TYPE
     *
     * @param ownerType null
     *
     * @mbggenerated 2012-03-16 09:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType == null ? null : ownerType.trim();
    }
}