package com.kingnod.etraining.organization.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ORG_SITE", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "parentId", type = java.lang.Long.class, table = "ORG_SITE", tableAlias = "A", column = "PARENT_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ORG_SITE", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "shortName", type = java.lang.String.class, table = "ORG_SITE", tableAlias = "A", column = "SHORT_NAME"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "ORG_SITE", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ORG_SITE", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ORG_SITE", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ORG_SITE", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ORG_SITE", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ORG_SITE", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ORG_SITE", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "levelNumber", type = java.lang.Integer.class, table = "ORG_SITE", tableAlias = "A", column = "LEVEL_NUMBER"), 
  @SelectColumnMapping(property = "parentName", type = java.lang.String.class, table = "ORG_SITE", tableAlias = "B", column = "NAME")
})

    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
public class Site implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private Long id;

    /**
     * 父站点ID<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.PARENT_ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private Long parentId;

    /**
     * 站点名称<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.NAME
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private String name;

    /**
     * 站点短名称<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.SHORT_NAME
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private String shortName;

    /**
     * 站点描述<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.DESCRIPTION
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private String description;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.RECORD_STATUS
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.CREATOR_ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.CREATE_DATE
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.UPDATER_ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.UPDATE_DATE
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private Date updateDate;

    /**
     * 站点层级<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.LEVEL_NUMBER
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private Integer levelNumber;

    /**
     * 父站点<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE.NAME
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    private String parentName;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.ID
     *
     * @返回  ETRAINING_0409.ORG_SITE.ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 父站点ID<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.PARENT_ID
     *
     * @返回  ETRAINING_0409.ORG_SITE.PARENT_ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public Long getParentId() {
        return parentId;
    }

    /**
     *  设置: 父站点ID<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.PARENT_ID
     *
     * @param parentId 父站点ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 返回: 站点名称<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.NAME
     *
     * @返回  ETRAINING_0409.ORG_SITE.NAME
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public String getName() {
        return name;
    }

    /**
     *  设置: 站点名称<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.NAME
     *
     * @param name 站点名称
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 站点短名称<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.SHORT_NAME
     *
     * @返回  ETRAINING_0409.ORG_SITE.SHORT_NAME
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public String getShortName() {
        return shortName;
    }

    /**
     *  设置: 站点短名称<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.SHORT_NAME
     *
     * @param shortName 站点短名称
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 返回: 站点描述<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.DESCRIPTION
     *
     * @返回  ETRAINING_0409.ORG_SITE.DESCRIPTION
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 站点描述<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.DESCRIPTION
     *
     * @param description 站点描述
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.RECORD_STATUS
     *
     * @返回  ETRAINING_0409.ORG_SITE.RECORD_STATUS
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.UPDATE_COUNT
     *
     * @返回  ETRAINING_0409.ORG_SITE.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.CREATOR_ID
     *
     * @返回  ETRAINING_0409.ORG_SITE.CREATOR_ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.CREATE_DATE
     *
     * @返回  ETRAINING_0409.ORG_SITE.CREATE_DATE
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.UPDATER_ID
     *
     * @返回  ETRAINING_0409.ORG_SITE.UPDATER_ID
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.UPDATE_DATE
     *
     * @返回  ETRAINING_0409.ORG_SITE.UPDATE_DATE
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 站点层级<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.LEVEL_NUMBER
     *
     * @返回  ETRAINING_0409.ORG_SITE.LEVEL_NUMBER
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public Integer getLevelNumber() {
        return levelNumber;
    }

    /**
     *  设置: 站点层级<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.LEVEL_NUMBER
     *
     * @param levelNumber 站点层级
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setLevelNumber(Integer levelNumber) {
        this.levelNumber = levelNumber;
    }

    /**
     * 返回: 父站点<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.NAME
     *
     * @返回  ETRAINING_0409.ORG_SITE.NAME
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public String getParentName() {
        return parentName;
    }

    /**
     *  设置: 父站点<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE.NAME
     *
     * @param parentName 父站点
     *
     * @mbggenerated 2012-04-23 21:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-23 21:07")
    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }
}