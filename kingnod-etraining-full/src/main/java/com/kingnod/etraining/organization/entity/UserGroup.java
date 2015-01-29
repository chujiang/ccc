package com.kingnod.etraining.organization.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "siteId", type = java.lang.Long.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "SITE_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ORG_USER_GROUP", tableAlias = "A", column = "UPDATE_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
public class UserGroup implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private Long id;

    /**
     * 站点ID<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.SITE_ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private Long siteId;

    /**
     * 用户组名称<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.NAME
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private String name;

    /**
     * 用户组描述<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.DESCRIPTION
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private String description;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.RECORD_STATUS
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.CREATOR_ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.CREATE_DATE
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.UPDATER_ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER_GROUP.UPDATE_DATE
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private Date updateDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.ID
     *
     * @返回  ETRAINING.ORG_USER_GROUP.ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 站点ID<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.SITE_ID
     *
     * @返回  ETRAINING.ORG_USER_GROUP.SITE_ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public Long getSiteId() {
        return siteId;
    }

    /**
     *  设置: 站点ID<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.SITE_ID
     *
     * @param siteId 站点ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * 返回: 用户组名称<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.NAME
     *
     * @返回  ETRAINING.ORG_USER_GROUP.NAME
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public String getName() {
        return name;
    }

    /**
     *  设置: 用户组名称<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.NAME
     *
     * @param name 用户组名称
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 用户组描述<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.DESCRIPTION
     *
     * @返回  ETRAINING.ORG_USER_GROUP.DESCRIPTION
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 用户组描述<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.DESCRIPTION
     *
     * @param description 用户组描述
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.RECORD_STATUS
     *
     * @返回  ETRAINING.ORG_USER_GROUP.RECORD_STATUS
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.UPDATE_COUNT
     *
     * @返回  ETRAINING.ORG_USER_GROUP.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.CREATOR_ID
     *
     * @返回  ETRAINING.ORG_USER_GROUP.CREATOR_ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.CREATE_DATE
     *
     * @返回  ETRAINING.ORG_USER_GROUP.CREATE_DATE
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.UPDATER_ID
     *
     * @返回  ETRAINING.ORG_USER_GROUP.UPDATER_ID
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.UPDATE_DATE
     *
     * @返回  ETRAINING.ORG_USER_GROUP.UPDATE_DATE
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER_GROUP.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-02-08 16:49
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}