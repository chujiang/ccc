package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "processId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "PROCESS_ID"), 
  @SelectColumnMapping(property = "activityType", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "ACTIVITY_TYPE"), 
  @SelectColumnMapping(property = "activityId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "ACTIVITY_ID"), 
  @SelectColumnMapping(property = "activityName", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "ACTIVITY_NAME"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_TRAINING_PLAN_ACTIVITY", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "processName", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "B", column = "NAME")
})

    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
public class TrainingPlanActivity implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private Long id;

    /**
     * 项目执行ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.PROCESS_ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private Long processId;

    /**
     * 活动类型<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_TYPE
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private String activityType;

    /**
     * 活动ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private Long activityId;

    /**
     * 活动名称<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_NAME
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private String activityName;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.RECORD_STATUS
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.CREATOR_ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.CREATE_DATE
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATER_ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATE_DATE
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private Date updateDate;

    /**
     * 项目执行<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.NAME
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private String processName;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 项目执行ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.PROCESS_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.PROCESS_ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public Long getProcessId() {
        return processId;
    }

    /**
     *  设置: 项目执行ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.PROCESS_ID
     *
     * @param processId 项目执行ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    /**
     * 返回: 活动类型<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_TYPE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_TYPE
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public String getActivityType() {
        return activityType;
    }

    /**
     *  设置: 活动类型<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_TYPE
     *
     * @param activityType 活动类型
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }

    /**
     * 返回: 活动ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public Long getActivityId() {
        return activityId;
    }

    /**
     *  设置: 活动ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_ID
     *
     * @param activityId 活动ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 返回: 活动名称<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_NAME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_NAME
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public String getActivityName() {
        return activityName;
    }

    /**
     *  设置: 活动名称<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.ACTIVITY_NAME
     *
     * @param activityName 活动名称
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.RECORD_STATUS
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.CREATOR_ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.CREATE_DATE
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATER_ID
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATE_DATE
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 项目执行<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.NAME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.NAME
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public String getProcessName() {
        return processName;
    }

    /**
     *  设置: 项目执行<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ACTIVITY.NAME
     *
     * @param processName 项目执行
     *
     * @mbggenerated 2012-02-15 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }
}