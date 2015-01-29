package com.kingnod.etraining.common.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "CMN_EVALUATION", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "activityId", type = java.lang.Long.class, table = "CMN_EVALUATION", tableAlias = "A", column = "ACTIVITY_ID"), 
  @SelectColumnMapping(property = "activityType", type = java.lang.String.class, table = "CMN_EVALUATION", tableAlias = "A", column = "ACTIVITY_TYPE"), 
  @SelectColumnMapping(property = "type", type = java.lang.Long.class, table = "CMN_EVALUATION", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "grade", type = java.lang.Short.class, table = "CMN_EVALUATION", tableAlias = "A", column = "GRADE"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "CMN_EVALUATION", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "CMN_EVALUATION", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "CMN_EVALUATION", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "CMN_EVALUATION", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "CMN_EVALUATION", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "CMN_EVALUATION", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "CMN_EVALUATION", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "typeName", type = java.lang.String.class, table = "CMN_TYPE", tableAlias = "B", column = "NAME"), 
  @SelectColumnMapping(property = "creatorName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "C", column = "FULL_NAME")
})

    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
public class Evaluation implements IdEntity<Long>, RecordStatus<Long>, Serializable {
/** 
 * @author PiJingwei
 */
private static final long serialVersionUID=7519453133056722153L;

    /**
     * 评论ID<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Long id;

    /**
     * 活动ID<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.ACTIVITY_ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Long activityId;

    /**
     * 活动类型<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.ACTIVITY_TYPE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private String activityType;

    /**
     * 评论类型<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.TYPE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Long type;

    /**
     * 星级等级<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.GRADE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Short grade;

    /**
     * 内容<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.DESCRIPTION
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private String description;

    /**
     * 状态<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.RECORD_STATUS
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private String recordStatus;

    /**
     * 更新次数<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.UPDATE_COUNT
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Long updateCount;

    /**
     * 创建人<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.CREATOR_ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Long creatorId;

    /**
     * 创建时间<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.CREATE_DATE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Date createDate;

    /**
     * 更新人<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.UPDATER_ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Long updaterId;

    /**
     * 更新时间<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.UPDATE_DATE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private Date updateDate;

    /**
     * 评论类别类型名称<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.NAME
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private String typeName;

    /**
     * 评论者<br/>
     * 对应数据库字段 ETRAINING_0508.CMN_EVALUATION.FULL_NAME
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    private String creatorName;


    /**
     * 返回: 评论ID<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.ID
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Long getId() {
        return id;
    }

    /**
     *  设置: 评论ID<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.ID
     *
     * @param id 评论ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 活动ID<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.ACTIVITY_ID
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.ACTIVITY_ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Long getActivityId() {
        return activityId;
    }

    /**
     *  设置: 活动ID<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.ACTIVITY_ID
     *
     * @param activityId 活动ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 返回: 活动类型<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.ACTIVITY_TYPE
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.ACTIVITY_TYPE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public String getActivityType() {
        return activityType;
    }

    /**
     *  设置: 活动类型<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.ACTIVITY_TYPE
     *
     * @param activityType 活动类型
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }

    /**
     * 返回: 评论类型<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.TYPE
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.TYPE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Long getType() {
        return type;
    }

    /**
     *  设置: 评论类型<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.TYPE
     *
     * @param type 评论类型
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 返回: 星级等级<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.GRADE
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.GRADE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Short getGrade() {
        return grade;
    }

    /**
     *  设置: 星级等级<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.GRADE
     *
     * @param grade 星级等级
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setGrade(Short grade) {
        this.grade = grade;
    }

    /**
     * 返回: 内容<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.DESCRIPTION
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.DESCRIPTION
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 内容<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.DESCRIPTION
     *
     * @param description 内容
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 状态<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.RECORD_STATUS
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.RECORD_STATUS
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: 状态<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.RECORD_STATUS
     *
     * @param recordStatus 状态
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: 更新次数<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.UPDATE_COUNT
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.UPDATE_COUNT
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: 更新次数<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.UPDATE_COUNT
     *
     * @param updateCount 更新次数
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: 创建人<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.CREATOR_ID
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.CREATOR_ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: 创建人<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.CREATOR_ID
     *
     * @param creatorId 创建人
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: 创建时间<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.CREATE_DATE
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.CREATE_DATE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: 创建时间<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.CREATE_DATE
     *
     * @param createDate 创建时间
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: 更新人<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.UPDATER_ID
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.UPDATER_ID
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: 更新人<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.UPDATER_ID
     *
     * @param updaterId 更新人
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: 更新时间<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.UPDATE_DATE
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.UPDATE_DATE
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: 更新时间<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.UPDATE_DATE
     *
     * @param updateDate 更新时间
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 评论类别类型名称<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.NAME
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.NAME
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public String getTypeName() {
        return typeName;
    }

    /**
     *  设置: 评论类别类型名称<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.NAME
     *
     * @param typeName 评论类别类型名称
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 返回: 评论者<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.FULL_NAME
     *
     * @返回  ETRAINING_0508.CMN_EVALUATION.FULL_NAME
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public String getCreatorName() {
        return creatorName;
    }

    /**
     *  设置: 评论者<br>
     * 对应数据库字段: ETRAINING_0508.CMN_EVALUATION.FULL_NAME
     *
     * @param creatorName 评论者
     *
     * @mbggenerated 2012-06-14 15:29
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-14 15:26")
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }
}