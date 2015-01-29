package com.kingnod.etraining.course.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "typeName", type = java.lang.String.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "TYPE_NAME"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "CRS_COURSE_TYPE", tableAlias = "A", column = "UPDATE_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
public class CourseType implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * 课程类型ID<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.ID
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private Long id;

    /**
     * 课程类型名称<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.TYPE_NAME
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private String typeName;

    /**
     * 课程描述信息<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.DESCRIPTION
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private String description;

    /**
     * 课程类型状态<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.RECORD_STATUS
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private String recordStatus;

    /**
     * 更新次数<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private Long updateCount;

    /**
     * 创建人<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.CREATOR_ID
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private Long creatorId;

    /**
     * 创建时间<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.CREATE_DATE
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private Date createDate;

    /**
     * 更新人<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.UPDATER_ID
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private Long updaterId;

    /**
     * 更新时间<br/>
     * 对应数据库字段 ETRAINING.CRS_COURSE_TYPE.UPDATE_DATE
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    private Date updateDate;


    /**
     * 返回: 课程类型ID<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.ID
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.ID
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public Long getId() {
        return id;
    }

    /**
     *  设置: 课程类型ID<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.ID
     *
     * @param id 课程类型ID
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 课程类型名称<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.TYPE_NAME
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.TYPE_NAME
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public String getTypeName() {
        return typeName;
    }

    /**
     *  设置: 课程类型名称<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.TYPE_NAME
     *
     * @param typeName 课程类型名称
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 返回: 课程描述信息<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.DESCRIPTION
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.DESCRIPTION
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 课程描述信息<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.DESCRIPTION
     *
     * @param description 课程描述信息
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 课程类型状态<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.RECORD_STATUS
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.RECORD_STATUS
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: 课程类型状态<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.RECORD_STATUS
     *
     * @param recordStatus 课程类型状态
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: 更新次数<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.UPDATE_COUNT
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: 更新次数<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.UPDATE_COUNT
     *
     * @param updateCount 更新次数
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: 创建人<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.CREATOR_ID
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.CREATOR_ID
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: 创建人<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.CREATOR_ID
     *
     * @param creatorId 创建人
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: 创建时间<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.CREATE_DATE
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.CREATE_DATE
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: 创建时间<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.CREATE_DATE
     *
     * @param createDate 创建时间
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: 更新人<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.UPDATER_ID
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.UPDATER_ID
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: 更新人<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.UPDATER_ID
     *
     * @param updaterId 更新人
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: 更新时间<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.UPDATE_DATE
     *
     * @返回  ETRAINING.CRS_COURSE_TYPE.UPDATE_DATE
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: 更新时间<br>
     * 对应数据库字段: ETRAINING.CRS_COURSE_TYPE.UPDATE_DATE
     *
     * @param updateDate 更新时间
     *
     * @mbggenerated 2012-02-07 10:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:38")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}