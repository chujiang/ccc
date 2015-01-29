package com.kingnod.etraining.organization.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "siteId", type = java.lang.Long.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "SITE_ID"), 
  @SelectColumnMapping(property = "hierarchyId", type = java.lang.Long.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "HIERARCHY_ID"), 
  @SelectColumnMapping(property = "hierarchyLevel", type = java.lang.Integer.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "HIERARCHY_LEVEL"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ORG_SITE_HIERARCHY", tableAlias = "A", column = "UPDATE_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
public class SiteHierarchy implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Long id;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.SITE_ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Long siteId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.HIERARCHY_ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Long hierarchyId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.HIERARCHY_LEVEL
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Integer hierarchyLevel;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.RECORD_STATUS
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.CREATOR_ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.CREATE_DATE
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATER_ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATE_DATE
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    private Date updateDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.ID
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.SITE_ID
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.SITE_ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Long getSiteId() {
        return siteId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.SITE_ID
     *
     * @param siteId null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.HIERARCHY_ID
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.HIERARCHY_ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Long getHierarchyId() {
        return hierarchyId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.HIERARCHY_ID
     *
     * @param hierarchyId null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setHierarchyId(Long hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.HIERARCHY_LEVEL
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.HIERARCHY_LEVEL
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Integer getHierarchyLevel() {
        return hierarchyLevel;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.HIERARCHY_LEVEL
     *
     * @param hierarchyLevel null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setHierarchyLevel(Integer hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.RECORD_STATUS
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.RECORD_STATUS
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATE_COUNT
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.CREATOR_ID
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.CREATOR_ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.CREATE_DATE
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.CREATE_DATE
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATER_ID
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATER_ID
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATE_DATE
     *
     * @返回  ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATE_DATE
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ORG_SITE_HIERARCHY.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-04-18 01:13
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 01:55")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}