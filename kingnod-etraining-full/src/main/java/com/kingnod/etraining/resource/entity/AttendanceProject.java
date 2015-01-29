package com.kingnod.etraining.resource.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "attendanceId", type = java.lang.Long.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "ATTENDANCE_ID"), 
  @SelectColumnMapping(property = "activityProjectId", type = java.lang.Long.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "ACTIVITY_PROJECT_ID"), 
  @SelectColumnMapping(property = "recordTime", type = java.util.Date.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "RECORD_TIME"), 
  @SelectColumnMapping(property = "recorder", type = java.lang.Long.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "RECORDER"), 
  @SelectColumnMapping(property = "projectName", type = java.lang.String.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "PROJECT_NAME"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "location", type = java.lang.String.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "LOCATION"), 
  @SelectColumnMapping(property = "trainingObject", type = java.lang.String.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "TRAINING_OBJECT"), 
  @SelectColumnMapping(property = "trainerId", type = java.lang.Long.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "TRAINER_ID"), 
  @SelectColumnMapping(property = "remark", type = java.lang.String.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "REMARK"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "RES_ATTENDANCE_PROJECT", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "attendanceName", type = java.lang.String.class, table = "RES_ATTENDANCE", tableAlias = "B", column = "NAME"), 
  @SelectColumnMapping(property = "trainerName", type = java.lang.String.class, table = "RES_TRAINER", tableAlias = "C", column = "NAME"), 
  @SelectColumnMapping(property = "userName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "D", column = "FULL_NAME")
})

    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
public class AttendanceProject implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Long id;

    /**
     * 签到表ID<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.ATTENDANCE_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Long attendanceId;

    /**
     * 培训项目ID<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.ACTIVITY_PROJECT_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Long activityProjectId;

    /**
     * 签到时间<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.RECORD_TIME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Date recordTime;

    /**
     * 签到记录的用户ID<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.RECORDER
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Long recorder;

    /**
     * 培训项目名称<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.PROJECT_NAME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String projectName;

    /**
     * 描述<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.DESCRIPTION
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String description;

    /**
     * 培训地址<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.LOCATION
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String location;

    /**
     * 培训对象<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.TRAINING_OBJECT
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String trainingObject;

    /**
     * 讲师ID<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.TRAINER_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Long trainerId;

    /**
     * 备注<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.REMARK
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String remark;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.RECORD_STATUS
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.CREATOR_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.CREATE_DATE
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.UPDATER_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.UPDATE_DATE
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private Date updateDate;

    /**
     * 签到表<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.NAME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String attendanceName;

    /**
     * 讲师<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.NAME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String trainerName;

    /**
     * 用户<br/>
     * 对应数据库字段 ETRAINING.RES_ATTENDANCE_PROJECT.FULL_NAME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    private String userName;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.ID
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 签到表ID<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.ATTENDANCE_ID
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.ATTENDANCE_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Long getAttendanceId() {
        return attendanceId;
    }

    /**
     *  设置: 签到表ID<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.ATTENDANCE_ID
     *
     * @param attendanceId 签到表ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    /**
     * 返回: 培训项目ID<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.ACTIVITY_PROJECT_ID
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.ACTIVITY_PROJECT_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Long getActivityProjectId() {
        return activityProjectId;
    }

    /**
     *  设置: 培训项目ID<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.ACTIVITY_PROJECT_ID
     *
     * @param activityProjectId 培训项目ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setActivityProjectId(Long activityProjectId) {
        this.activityProjectId = activityProjectId;
    }

    /**
     * 返回: 签到时间<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.RECORD_TIME
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.RECORD_TIME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     *  设置: 签到时间<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.RECORD_TIME
     *
     * @param recordTime 签到时间
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * 返回: 签到记录的用户ID<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.RECORDER
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.RECORDER
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Long getRecorder() {
        return recorder;
    }

    /**
     *  设置: 签到记录的用户ID<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.RECORDER
     *
     * @param recorder 签到记录的用户ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setRecorder(Long recorder) {
        this.recorder = recorder;
    }

    /**
     * 返回: 培训项目名称<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.PROJECT_NAME
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.PROJECT_NAME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getProjectName() {
        return projectName;
    }

    /**
     *  设置: 培训项目名称<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.PROJECT_NAME
     *
     * @param projectName 培训项目名称
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 返回: 描述<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.DESCRIPTION
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.DESCRIPTION
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 描述<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.DESCRIPTION
     *
     * @param description 描述
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 培训地址<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.LOCATION
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.LOCATION
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getLocation() {
        return location;
    }

    /**
     *  设置: 培训地址<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.LOCATION
     *
     * @param location 培训地址
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 返回: 培训对象<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.TRAINING_OBJECT
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.TRAINING_OBJECT
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getTrainingObject() {
        return trainingObject;
    }

    /**
     *  设置: 培训对象<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.TRAINING_OBJECT
     *
     * @param trainingObject 培训对象
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setTrainingObject(String trainingObject) {
        this.trainingObject = trainingObject == null ? null : trainingObject.trim();
    }

    /**
     * 返回: 讲师ID<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.TRAINER_ID
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.TRAINER_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Long getTrainerId() {
        return trainerId;
    }

    /**
     *  设置: 讲师ID<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.TRAINER_ID
     *
     * @param trainerId 讲师ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * 返回: 备注<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.REMARK
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.REMARK
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getRemark() {
        return remark;
    }

    /**
     *  设置: 备注<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.REMARK
     *
     * @param remark 备注
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.RECORD_STATUS
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.RECORD_STATUS
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.UPDATE_COUNT
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.CREATOR_ID
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.CREATOR_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.CREATE_DATE
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.CREATE_DATE
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.UPDATER_ID
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.UPDATER_ID
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.UPDATE_DATE
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.UPDATE_DATE
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 签到表<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.NAME
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.NAME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getAttendanceName() {
        return attendanceName;
    }

    /**
     *  设置: 签到表<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.NAME
     *
     * @param attendanceName 签到表
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setAttendanceName(String attendanceName) {
        this.attendanceName = attendanceName == null ? null : attendanceName.trim();
    }

    /**
     * 返回: 讲师<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.NAME
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.NAME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getTrainerName() {
        return trainerName;
    }

    /**
     *  设置: 讲师<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.NAME
     *
     * @param trainerName 讲师
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName == null ? null : trainerName.trim();
    }

    /**
     * 返回: 用户<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.FULL_NAME
     *
     * @返回  ETRAINING.RES_ATTENDANCE_PROJECT.FULL_NAME
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public String getUserName() {
        return userName;
    }

    /**
     *  设置: 用户<br>
     * 对应数据库字段: ETRAINING.RES_ATTENDANCE_PROJECT.FULL_NAME
     *
     * @param userName 用户
     *
     * @mbggenerated 2012-02-21 18:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-21 18:12")
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}