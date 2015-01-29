package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.etraining.common.ObjectType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "folderId", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "A", column = "FOLDER_ID"), 
  @SelectColumnMapping(property = "courseId", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "A", column = "COURSE_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_ELEARNING", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "trainer", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "A", column = "TRAINER"), 
  @SelectColumnMapping(property = "lessons", type = java.lang.Integer.class, table = "ATY_ELEARNING", tableAlias = "A", column = "LESSONS"), 
  @SelectColumnMapping(property = "credit", type = java.lang.Integer.class, table = "ATY_ELEARNING", tableAlias = "A", column = "CREDIT"), 
  @SelectColumnMapping(property = "finishTime", type = java.util.Date.class, table = "ATY_ELEARNING", tableAlias = "A", column = "FINISH_TIME"), 
  @SelectColumnMapping(property = "startEnrollTime", type = java.util.Date.class, table = "ATY_ELEARNING", tableAlias = "A", column = "START_ENROLL_TIME"), 
  @SelectColumnMapping(property = "endEnrollTime", type = java.util.Date.class, table = "ATY_ELEARNING", tableAlias = "A", column = "END_ENROLL_TIME"), 
  @SelectColumnMapping(property = "minEnrollNumber", type = java.lang.Integer.class, table = "ATY_ELEARNING", tableAlias = "A", column = "MIN_ENROLL_NUMBER"), 
  @SelectColumnMapping(property = "maxEnrollNumber", type = java.lang.Integer.class, table = "ATY_ELEARNING", tableAlias = "A", column = "MAX_ENROLL_NUMBER"), 
  @SelectColumnMapping(property = "enabledWaiting", type = java.lang.String.class, table = "ATY_ELEARNING", tableAlias = "A", column = "ENABLED_WAITING"), 
  @SelectColumnMapping(property = "allowLogout", type = java.lang.String.class, table = "ATY_ELEARNING", tableAlias = "A", column = "ALLOW_LOGOUT"), 
  @SelectColumnMapping(property = "courseTypeId", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "A", column = "COURSE_TYPE_ID"), 
  @SelectColumnMapping(property = "releaseStauts", type = java.lang.String.class, table = "ATY_ELEARNING", tableAlias = "A", column = "RELEASE_STAUTS"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_ELEARNING", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_ELEARNING", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_ELEARNING", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "releaseDate", type = java.util.Date.class, table = "ATY_ELEARNING", tableAlias = "A", column = "RELEASE_DATE"), 
  @SelectColumnMapping(property = "trainerName", type = java.lang.String.class, table = "RES_TRAINER", tableAlias = "B", column = "NAME"), 
  @SelectColumnMapping(property = "courseName", type = java.lang.String.class, table = "CRS_COURSE_INFO", tableAlias = "D", column = "COURSE_TITLE"), 
  @SelectColumnMapping(property = "folderName", type = java.lang.String.class, table = "ATY_FOLDER", tableAlias = "C", column = "NAME")
})

    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
public class Elearning implements Activity, IdEntity<Long>, RecordStatus<Long>, Serializable {
private Period periods;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Long id;

    /**
     * 活动文件夹ID<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.FOLDER_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Long folderId;

    /**
     * 课程ID<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.COURSE_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Long courseId;

    /**
     * 活动名称<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private String name;

    /**
     * 讲师ID<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.TRAINER
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Long trainer;

    /**
     * 课时<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.LESSONS
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Integer lessons;

    /**
     * 学分<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.CREDIT
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Integer credit;

    /**
     * 目标完成时间<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.FINISH_TIME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Date finishTime;

    /**
     * 报名开始时间<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.START_ENROLL_TIME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Date startEnrollTime;

    /**
     * 报名结束时间<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.END_ENROLL_TIME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Date endEnrollTime;

    /**
     * 最少报名人数<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.MIN_ENROLL_NUMBER
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Integer minEnrollNumber;

    /**
     * 最多报名人数<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.MAX_ENROLL_NUMBER
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Integer maxEnrollNumber;

    /**
     * 启用等待列表<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.ENABLED_WAITING
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private String enabledWaiting;

    /**
     * 允许注销<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.ALLOW_LOGOUT
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private String allowLogout;

    /**
     * 课程类别ID<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.COURSE_TYPE_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Long courseTypeId;

    /**
     * 状态, P：编辑，C：审核中 R：发布<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.RELEASE_STAUTS
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private String releaseStauts;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.RECORD_STATUS
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.CREATOR_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.CREATE_DATE
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.UPDATER_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.UPDATE_DATE
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Date updateDate;

    /**
     * 发布日期<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.RELEASE_DATE
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private Date releaseDate;

    /**
     * 讲师<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private String trainerName;

    /**
     * 课程<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.COURSE_TITLE
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private String courseName;

    /**
     * 文件夹<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    private String folderName;

public ObjectType getActivityType(){
  return ObjectType.A_EL;
}
public Long getActivityId(){
  return id;
}
public Class getActivityClass(){
  return Elearning.class;
}
public Activity getActivityObject(){
  return this;
}
public Period getPeriods(){
  return periods;
}
public void setPeriods(Period periods){
  this.periods=periods;
}

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.ID
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 活动文件夹ID<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.FOLDER_ID
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.FOLDER_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Long getFolderId() {
        return folderId;
    }

    /**
     *  设置: 活动文件夹ID<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.FOLDER_ID
     *
     * @param folderId 活动文件夹ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    /**
     * 返回: 课程ID<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.COURSE_ID
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.COURSE_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Long getCourseId() {
        return courseId;
    }

    /**
     *  设置: 课程ID<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.COURSE_ID
     *
     * @param courseId 课程ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * 返回: 活动名称<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public String getName() {
        return name;
    }

    /**
     *  设置: 活动名称<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @param name 活动名称
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 讲师ID<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.TRAINER
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.TRAINER
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Long getTrainer() {
        return trainer;
    }

    /**
     *  设置: 讲师ID<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.TRAINER
     *
     * @param trainer 讲师ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setTrainer(Long trainer) {
        this.trainer = trainer;
    }

    /**
     * 返回: 课时<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.LESSONS
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.LESSONS
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Integer getLessons() {
        return lessons;
    }

    /**
     *  设置: 课时<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.LESSONS
     *
     * @param lessons 课时
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setLessons(Integer lessons) {
        this.lessons = lessons;
    }

    /**
     * 返回: 学分<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.CREDIT
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.CREDIT
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Integer getCredit() {
        return credit;
    }

    /**
     *  设置: 学分<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.CREDIT
     *
     * @param credit 学分
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    /**
     * 返回: 目标完成时间<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.FINISH_TIME
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.FINISH_TIME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     *  设置: 目标完成时间<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.FINISH_TIME
     *
     * @param finishTime 目标完成时间
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 返回: 报名开始时间<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.START_ENROLL_TIME
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.START_ENROLL_TIME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Date getStartEnrollTime() {
        return startEnrollTime;
    }

    /**
     *  设置: 报名开始时间<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.START_ENROLL_TIME
     *
     * @param startEnrollTime 报名开始时间
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setStartEnrollTime(Date startEnrollTime) {
        this.startEnrollTime = startEnrollTime;
    }

    /**
     * 返回: 报名结束时间<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.END_ENROLL_TIME
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.END_ENROLL_TIME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Date getEndEnrollTime() {
        return endEnrollTime;
    }

    /**
     *  设置: 报名结束时间<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.END_ENROLL_TIME
     *
     * @param endEnrollTime 报名结束时间
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setEndEnrollTime(Date endEnrollTime) {
        this.endEnrollTime = endEnrollTime;
    }

    /**
     * 返回: 最少报名人数<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.MIN_ENROLL_NUMBER
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.MIN_ENROLL_NUMBER
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Integer getMinEnrollNumber() {
        return minEnrollNumber;
    }

    /**
     *  设置: 最少报名人数<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.MIN_ENROLL_NUMBER
     *
     * @param minEnrollNumber 最少报名人数
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setMinEnrollNumber(Integer minEnrollNumber) {
        this.minEnrollNumber = minEnrollNumber;
    }

    /**
     * 返回: 最多报名人数<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.MAX_ENROLL_NUMBER
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.MAX_ENROLL_NUMBER
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Integer getMaxEnrollNumber() {
        return maxEnrollNumber;
    }

    /**
     *  设置: 最多报名人数<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.MAX_ENROLL_NUMBER
     *
     * @param maxEnrollNumber 最多报名人数
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setMaxEnrollNumber(Integer maxEnrollNumber) {
        this.maxEnrollNumber = maxEnrollNumber;
    }

    /**
     * 返回: 启用等待列表<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.ENABLED_WAITING
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.ENABLED_WAITING
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public String getEnabledWaiting() {
        return enabledWaiting;
    }

    /**
     *  设置: 启用等待列表<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.ENABLED_WAITING
     *
     * @param enabledWaiting 启用等待列表
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setEnabledWaiting(String enabledWaiting) {
        this.enabledWaiting = enabledWaiting == null ? null : enabledWaiting.trim();
    }

    /**
     * 返回: 允许注销<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.ALLOW_LOGOUT
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.ALLOW_LOGOUT
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public String getAllowLogout() {
        return allowLogout;
    }

    /**
     *  设置: 允许注销<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.ALLOW_LOGOUT
     *
     * @param allowLogout 允许注销
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setAllowLogout(String allowLogout) {
        this.allowLogout = allowLogout == null ? null : allowLogout.trim();
    }

    /**
     * 返回: 课程类别ID<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.COURSE_TYPE_ID
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.COURSE_TYPE_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Long getCourseTypeId() {
        return courseTypeId;
    }

    /**
     *  设置: 课程类别ID<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.COURSE_TYPE_ID
     *
     * @param courseTypeId 课程类别ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setCourseTypeId(Long courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    /**
     * 返回: 状态, P：编辑，C：审核中 R：发布<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.RELEASE_STAUTS
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.RELEASE_STAUTS
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public String getReleaseStauts() {
        return releaseStauts;
    }

    /**
     *  设置: 状态, P：编辑，C：审核中 R：发布<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.RELEASE_STAUTS
     *
     * @param releaseStauts 状态, P：编辑，C：审核中 R：发布
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setReleaseStauts(String releaseStauts) {
        this.releaseStauts = releaseStauts == null ? null : releaseStauts.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.RECORD_STATUS
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.RECORD_STATUS
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.UPDATE_COUNT
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.CREATOR_ID
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.CREATOR_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.CREATE_DATE
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.CREATE_DATE
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.UPDATER_ID
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.UPDATER_ID
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.UPDATE_DATE
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.UPDATE_DATE
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 发布日期<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.RELEASE_DATE
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.RELEASE_DATE
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     *  设置: 发布日期<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.RELEASE_DATE
     *
     * @param releaseDate 发布日期
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 返回: 讲师<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public String getTrainerName() {
        return trainerName;
    }

    /**
     *  设置: 讲师<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @param trainerName 讲师
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName == null ? null : trainerName.trim();
    }

    /**
     * 返回: 课程<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.COURSE_TITLE
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.COURSE_TITLE
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public String getCourseName() {
        return courseName;
    }

    /**
     *  设置: 课程<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.COURSE_TITLE
     *
     * @param courseName 课程
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * 返回: 文件夹<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @返回  ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public String getFolderName() {
        return folderName;
    }

    /**
     *  设置: 文件夹<br>
     * 对应数据库字段: ETRAINING_0409.ATY_ELEARNING.NAME
     *
     * @param folderName 文件夹
     *
     * @mbggenerated 2012-04-20 16:04
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 16:01")
    public void setFolderName(String folderName) {
        this.folderName = folderName == null ? null : folderName.trim();
    }
}