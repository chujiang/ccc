package com.kingnod.etraining.organization.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "entityName", type = java.lang.String.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "ENTITY_NAME"), 
  @SelectColumnMapping(property = "propertyName", type = java.lang.String.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "PROPERTY_NAME"), 
  @SelectColumnMapping(property = "siteId", type = java.lang.Long.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "SITE_ID"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ORG_USER_PROPERTIES", tableAlias = "A", column = "UPDATE_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
public class UserProperties implements IdEntity<Long>, RecordStatus<Long>, Serializable {

	private static final long serialVersionUID = -7520654955507400217L;
	private String upOrDown; // 移动标识符
	private Integer newGroupSeq;
	/**
     * null<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private Long id;
    
    /**
     * null<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.SEQ
     *
     * @mbggenerated 2012-02-18 18:24
     */
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private Integer seq;

    /**
     * 名称<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.NAME
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private String name;

    /**
     * 实体名称<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.ENTITY_NAME
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private String entityName;

    /**
     * 属性名称<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.PROPERTY_NAME
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private String propertyName;

    /**
     * 站点ID<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.SITE_ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private Long siteId;

    /**
     * 属性描述<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.DESCRIPTION
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private String description;

    /**
     * 属性类型, T: 文本框， S： 下拉框， C：多选框， R：单选框， D：时间选择器， U：用户选择器， A：多行文本框<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.TYPE
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private String type;

    /**
     * null<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.RECORD_STATUS
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.CREATOR_ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.CREATE_DATE
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.UPDATER_ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 KELEARNING.ORG_USER_PROPERTIES.UPDATE_DATE
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private Date updateDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.ID
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 名称<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.NAME
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.NAME
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public String getName() {
        return name;
    }

    /**
     *  设置: 名称<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.NAME
     *
     * @param name 名称
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 实体名称<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.ENTITY_NAME
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.ENTITY_NAME
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public String getEntityName() {
        return entityName;
    }

    /**
     *  设置: 实体名称<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.ENTITY_NAME
     *
     * @param entityName 实体名称
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setEntityName(String entityName) {
        this.entityName = entityName == null ? null : entityName.trim();
    }

    /**
     * 返回: 属性名称<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.PROPERTY_NAME
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.PROPERTY_NAME
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public String getPropertyName() {
        return propertyName;
    }

    /**
     *  设置: 属性名称<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.PROPERTY_NAME
     *
     * @param propertyName 属性名称
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    /**
     * 返回: 站点ID<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.SITE_ID
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.SITE_ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public Long getSiteId() {
        return siteId;
    }

    /**
     *  设置: 站点ID<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.SITE_ID
     *
     * @param siteId 站点ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * 返回: 属性描述<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.DESCRIPTION
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.DESCRIPTION
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 属性描述<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.DESCRIPTION
     *
     * @param description 属性描述
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 属性类型, T: 文本框， S： 下拉框， C：多选框， R：单选框， D：时间选择器， U：用户选择器， A：多行文本框<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.TYPE
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.TYPE
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public String getType() {
        return type;
    }

    /**
     *  设置: 属性类型, T: 文本框， S： 下拉框， C：多选框， R：单选框， D：时间选择器， U：用户选择器， A：多行文本框<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.TYPE
     *
     * @param type 属性类型, T: 文本框， S： 下拉框， C：多选框， R：单选框， D：时间选择器， U：用户选择器， A：多行文本框
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.RECORD_STATUS
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.RECORD_STATUS
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.UPDATE_COUNT
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.CREATOR_ID
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.CREATOR_ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.CREATE_DATE
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.CREATE_DATE
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.UPDATER_ID
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.UPDATER_ID
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.UPDATE_DATE
     *
     * @返回  KELEARNING.ORG_USER_PROPERTIES.UPDATE_DATE
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: KELEARNING.ORG_USER_PROPERTIES.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-02-18 18:24
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getUpOrDown() {
		return upOrDown;
	}

	public void setUpOrDown(String upOrDown) {
		this.upOrDown = upOrDown;
	}

	public Integer getNewGroupSeq() {
		return newGroupSeq;
	}

	public void setNewGroupSeq(Integer newGroupSeq) {
		this.newGroupSeq = newGroupSeq;
	}
}