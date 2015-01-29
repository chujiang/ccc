package com.kingnod.etraining.common.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "CMN_TYPE", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "root", type = java.lang.Boolean.class, table = "CMN_TYPE", tableAlias = "A", column = "ROOT"), 
  @SelectColumnMapping(property = "parentId", type = java.lang.Long.class, table = "CMN_TYPE", tableAlias = "A", column = "PARENT_ID"), 
  @SelectColumnMapping(property = "childLevel", type = java.lang.Short.class, table = "CMN_TYPE", tableAlias = "A", column = "CHILD_LEVEL"), 
  @SelectColumnMapping(property = "siteId", type = java.lang.Long.class, table = "CMN_TYPE", tableAlias = "A", column = "SITE_ID"), 
  @SelectColumnMapping(property = "sequence", type = java.lang.Long.class, table = "CMN_TYPE", tableAlias = "A", column = "SEQUENCE"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "CMN_TYPE", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "CMN_TYPE", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "CMN_TYPE", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "objectType", type = java.lang.String.class, table = "CMN_TYPE", tableAlias = "A", column = "OBJECT_TYPE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "CMN_TYPE", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "CMN_TYPE", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "CMN_TYPE", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "CMN_TYPE", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "CMN_TYPE", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "CMN_TYPE", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "inheritAble", type = java.lang.Boolean.class, table = "CMN_TYPE", tableAlias = "A", column = "INHERIT_ABLE")
})

    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
public class Type implements IdEntity<Long>, RecordStatus<Long>, Serializable {
/** 
 * serialVersionUID
 */
private static final long serialVersionUID=1L;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Long id;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.ROOT
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Boolean root;

    /**
     * 父类别ID<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.PARENT_ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Long parentId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.CHILD_LEVEL
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Short childLevel;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.SITE_ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Long siteId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.SEQUENCE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Long sequence;

    /**
     * 类别名称<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.NAME
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private String name;

    /**
     * 类别描述<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.DESCRIPTION
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private String description;

    /**
     * 类别状态<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.STATUS
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private String status;

    /**
     * 对象类别， A： 培训计划类别， B：项目类别,  C：费用类别<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.OBJECT_TYPE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private String objectType;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.RECORD_STATUS
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.CREATOR_ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.CREATE_DATE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.UPDATER_ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.UPDATE_DATE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Date updateDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.CMN_TYPE.INHERIT_ABLE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    private Boolean inheritAble;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.ID
     *
     * @返回  ETRAINING_0409.CMN_TYPE.ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.ROOT
     *
     * @返回  ETRAINING_0409.CMN_TYPE.ROOT
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Boolean getRoot() {
        return root;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.ROOT
     *
     * @param root null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setRoot(Boolean root) {
        this.root = root;
    }

    /**
     * 返回: 父类别ID<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.PARENT_ID
     *
     * @返回  ETRAINING_0409.CMN_TYPE.PARENT_ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Long getParentId() {
        return parentId;
    }

    /**
     *  设置: 父类别ID<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.PARENT_ID
     *
     * @param parentId 父类别ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.CHILD_LEVEL
     *
     * @返回  ETRAINING_0409.CMN_TYPE.CHILD_LEVEL
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Short getChildLevel() {
        return childLevel;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.CHILD_LEVEL
     *
     * @param childLevel null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setChildLevel(Short childLevel) {
        this.childLevel = childLevel;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.SITE_ID
     *
     * @返回  ETRAINING_0409.CMN_TYPE.SITE_ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Long getSiteId() {
        return siteId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.SITE_ID
     *
     * @param siteId null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.SEQUENCE
     *
     * @返回  ETRAINING_0409.CMN_TYPE.SEQUENCE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Long getSequence() {
        return sequence;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.SEQUENCE
     *
     * @param sequence null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    /**
     * 返回: 类别名称<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.NAME
     *
     * @返回  ETRAINING_0409.CMN_TYPE.NAME
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public String getName() {
        return name;
    }

    /**
     *  设置: 类别名称<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.NAME
     *
     * @param name 类别名称
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 类别描述<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.DESCRIPTION
     *
     * @返回  ETRAINING_0409.CMN_TYPE.DESCRIPTION
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 类别描述<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.DESCRIPTION
     *
     * @param description 类别描述
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 类别状态<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.STATUS
     *
     * @返回  ETRAINING_0409.CMN_TYPE.STATUS
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: 类别状态<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.STATUS
     *
     * @param status 类别状态
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: 对象类别， A： 培训计划类别， B：项目类别,  C：费用类别<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.OBJECT_TYPE
     *
     * @返回  ETRAINING_0409.CMN_TYPE.OBJECT_TYPE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public String getObjectType() {
        return objectType;
    }

    /**
     *  设置: 对象类别， A： 培训计划类别， B：项目类别,  C：费用类别<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.OBJECT_TYPE
     *
     * @param objectType 对象类别， A： 培训计划类别， B：项目类别,  C：费用类别
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.RECORD_STATUS
     *
     * @返回  ETRAINING_0409.CMN_TYPE.RECORD_STATUS
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.UPDATE_COUNT
     *
     * @返回  ETRAINING_0409.CMN_TYPE.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.CREATOR_ID
     *
     * @返回  ETRAINING_0409.CMN_TYPE.CREATOR_ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.CREATE_DATE
     *
     * @返回  ETRAINING_0409.CMN_TYPE.CREATE_DATE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.UPDATER_ID
     *
     * @返回  ETRAINING_0409.CMN_TYPE.UPDATER_ID
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.UPDATE_DATE
     *
     * @返回  ETRAINING_0409.CMN_TYPE.UPDATE_DATE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.INHERIT_ABLE
     *
     * @返回  ETRAINING_0409.CMN_TYPE.INHERIT_ABLE
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public Boolean getInheritAble() {
        return inheritAble;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.CMN_TYPE.INHERIT_ABLE
     *
     * @param inheritAble null
     *
     * @mbggenerated 2012-04-18 02:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 02:53")
    public void setInheritAble(Boolean inheritAble) {
        this.inheritAble = inheritAble;
    }
}