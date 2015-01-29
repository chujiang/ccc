package com.kingnod.etraining.security.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.etraining.common.ObjectType;
import java.math.BigDecimal;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "entityId", type = java.lang.Long.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "ENTITY_ID"), 
  @SelectColumnMapping(property = "entityType", type = java.lang.String.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "ENTITY_TYPE"), 
  @SelectColumnMapping(property = "ownerType", type = java.lang.String.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_TYPE"), 
  @SelectColumnMapping(property = "owner0", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_0"), 
  @SelectColumnMapping(property = "userId", type = java.lang.Long.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "USER_ID"), 
  @SelectColumnMapping(property = "owner1", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_1"), 
  @SelectColumnMapping(property = "owner2", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_2"), 
  @SelectColumnMapping(property = "owner3", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_3"), 
  @SelectColumnMapping(property = "owner4", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_4"), 
  @SelectColumnMapping(property = "owner5", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_5"), 
  @SelectColumnMapping(property = "owner6", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_6"), 
  @SelectColumnMapping(property = "owner7", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_7"), 
  @SelectColumnMapping(property = "owner8", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_8"), 
  @SelectColumnMapping(property = "owner9", type = java.lang.Integer.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_9"), 
  @SelectColumnMapping(property = "owner10", type = java.math.BigDecimal.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_10"), 
  @SelectColumnMapping(property = "owner11", type = java.math.BigDecimal.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_11"), 
  @SelectColumnMapping(property = "owner12", type = java.math.BigDecimal.class, table = "SYS_ENTITY_READ_PERMISSION", tableAlias = "A", column = "OWNER_12")
})

    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
public class EntityReadPermission {

	/**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ID
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Long id;
    
	/**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ENTITY_ID
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Long entityId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ENTITY_TYPE
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private ObjectType entityType;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_TYPE
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private String ownerType;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_0
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner0;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.USER_ID
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Long userId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_1
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner1;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_2
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner2;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_3
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner3;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_4
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner4;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_5
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner5;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_6
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner6;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_7
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner7;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_8
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner8;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_9
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private Integer owner9;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_10
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private BigDecimal owner10;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_11
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private BigDecimal owner11;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_12
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    private BigDecimal owner12;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ID
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ID
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Long getId() {
		return id;
	}

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ID
     *
     * @param entityId null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setId(Long id) {
		this.id = id;
	}
    
    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ENTITY_ID
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ENTITY_ID
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Long getEntityId() {
        return entityId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ENTITY_ID
     *
     * @param entityId null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ENTITY_TYPE
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ENTITY_TYPE
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public ObjectType getEntityType() {
        return entityType;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.ENTITY_TYPE
     *
     * @param entityType null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setEntityType(ObjectType entityType) {
        this.entityType = entityType;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_TYPE
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_TYPE
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public String getOwnerType() {
        return ownerType;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_TYPE
     *
     * @param ownerType null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType == null ? null : ownerType.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_0
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_0
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner0() {
        return owner0;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_0
     *
     * @param owner0 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner0(Integer owner0) {
        this.owner0 = owner0;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.USER_ID
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.USER_ID
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Long getUserId() {
        return userId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.USER_ID
     *
     * @param userId null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_1
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_1
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner1() {
        return owner1;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_1
     *
     * @param owner1 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner1(Integer owner1) {
        this.owner1 = owner1;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_2
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_2
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner2() {
        return owner2;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_2
     *
     * @param owner2 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner2(Integer owner2) {
        this.owner2 = owner2;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_3
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_3
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner3() {
        return owner3;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_3
     *
     * @param owner3 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner3(Integer owner3) {
        this.owner3 = owner3;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_4
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_4
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner4() {
        return owner4;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_4
     *
     * @param owner4 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner4(Integer owner4) {
        this.owner4 = owner4;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_5
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_5
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner5() {
        return owner5;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_5
     *
     * @param owner5 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner5(Integer owner5) {
        this.owner5 = owner5;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_6
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_6
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner6() {
        return owner6;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_6
     *
     * @param owner6 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner6(Integer owner6) {
        this.owner6 = owner6;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_7
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_7
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner7() {
        return owner7;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_7
     *
     * @param owner7 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner7(Integer owner7) {
        this.owner7 = owner7;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_8
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_8
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner8() {
        return owner8;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_8
     *
     * @param owner8 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner8(Integer owner8) {
        this.owner8 = owner8;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_9
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_9
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public Integer getOwner9() {
        return owner9;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_9
     *
     * @param owner9 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner9(Integer owner9) {
        this.owner9 = owner9;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_10
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_10
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public BigDecimal getOwner10() {
        return owner10;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_10
     *
     * @param owner10 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner10(BigDecimal owner10) {
        this.owner10 = owner10;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_11
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_11
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public BigDecimal getOwner11() {
        return owner11;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_11
     *
     * @param owner11 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner11(BigDecimal owner11) {
        this.owner11 = owner11;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_12
     *
     * @返回  ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_12
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public BigDecimal getOwner12() {
        return owner12;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_ENTITY_READ_PERMISSION.OWNER_12
     *
     * @param owner12 null
     *
     * @mbggenerated 2012-04-10 19:43
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-10 19:38")
    public void setOwner12(BigDecimal owner12) {
        this.owner12 = owner12;
    }
}