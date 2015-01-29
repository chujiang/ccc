package com.kingnod.etraining.course.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "userId", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "USER_ID"), 
  @SelectColumnMapping(property = "courseId", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "COURSE_ID"), 
  @SelectColumnMapping(property = "scoId", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "SCO_ID"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "completedDate", type = java.util.Date.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "COMPLETED_DATE"), 
  @SelectColumnMapping(property = "completedTotalTime", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "COMPLETED_TOTAL_TIME"), 
  @SelectColumnMapping(property = "prerequisites", type = java.lang.String.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "PREREQUISITES"), 
  @SelectColumnMapping(property = "exitMode", type = java.lang.String.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "EXIT_MODE"), 
  @SelectColumnMapping(property = "entryStatus", type = java.lang.String.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "ENTRY_STATUS"), 
  @SelectColumnMapping(property = "score", type = java.math.BigDecimal.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "SCORE"), 
  @SelectColumnMapping(property = "scoreMax", type = java.math.BigDecimal.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "SCORE_MAX"), 
  @SelectColumnMapping(property = "scoreMin", type = java.math.BigDecimal.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "SCORE_MIN"), 
  @SelectColumnMapping(property = "credit", type = java.lang.String.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "CREDIT"), 
  @SelectColumnMapping(property = "totalTime", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "TOTAL_TIME"), 
  @SelectColumnMapping(property = "lessonLocation", type = java.lang.String.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "LESSON_LOCATION"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "CRS_SCO_PERFORMANCE", tableAlias = "A", column = "UPDATE_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
public class SCOPerformance implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * ID<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long id;

    /**
     * 用户ID<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.USER_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long userId;

    /**
     * 课程ID<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.COURSE_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long courseId;

    /**
     * SCOID<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.SCO_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long scoId;

    /**
     * SCO学习状态<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.STATUS
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private String status;

    /**
     * SCO完成时间<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.COMPLETED_DATE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Date completedDate;

    /**
     * SCO完成时长<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.COMPLETED_TOTAL_TIME
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long completedTotalTime;

    /**
     * 保留<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.PREREQUISITES
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private String prerequisites;

    /**
     * 停止状态<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.EXIT_MODE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private String exitMode;

    /**
     * 进入状态<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.ENTRY_STATUS
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private String entryStatus;

    /**
     * 成绩<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.SCORE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private BigDecimal score;

    /**
     * 保留<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.SCORE_MAX
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private BigDecimal scoreMax;

    /**
     * 保留<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.SCORE_MIN
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private BigDecimal scoreMin;

    /**
     * 是否得分<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.CREDIT
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private String credit;

    /**
     * 学习总时长<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.TOTAL_TIME
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long totalTime;

    /**
     * 课程位置<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.LESSON_LOCATION
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private String lessonLocation;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.RECORD_STATUS
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.CREATOR_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.CREATE_DATE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.UPDATER_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.CRS_SCO_PERFORMANCE.UPDATE_DATE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    private Date updateDate;


    /**
     * 返回: ID<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.ID
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getId() {
        return id;
    }

    /**
     *  设置: ID<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.ID
     *
     * @param id ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 用户ID<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.USER_ID
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.USER_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getUserId() {
        return userId;
    }

    /**
     *  设置: 用户ID<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.USER_ID
     *
     * @param userId 用户ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 返回: 课程ID<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.COURSE_ID
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.COURSE_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getCourseId() {
        return courseId;
    }

    /**
     *  设置: 课程ID<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.COURSE_ID
     *
     * @param courseId 课程ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * 返回: SCOID<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.SCO_ID
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.SCO_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getScoId() {
        return scoId;
    }

    /**
     *  设置: SCOID<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.SCO_ID
     *
     * @param scoId SCOID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setScoId(Long scoId) {
        this.scoId = scoId;
    }

    /**
     * 返回: SCO学习状态<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.STATUS
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.STATUS
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: SCO学习状态<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.STATUS
     *
     * @param status SCO学习状态
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: SCO完成时间<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.COMPLETED_DATE
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.COMPLETED_DATE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Date getCompletedDate() {
        return completedDate;
    }

    /**
     *  设置: SCO完成时间<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.COMPLETED_DATE
     *
     * @param completedDate SCO完成时间
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    /**
     * 返回: SCO完成时长<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.COMPLETED_TOTAL_TIME
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.COMPLETED_TOTAL_TIME
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getCompletedTotalTime() {
        return completedTotalTime;
    }

    /**
     *  设置: SCO完成时长<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.COMPLETED_TOTAL_TIME
     *
     * @param completedTotalTime SCO完成时长
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setCompletedTotalTime(Long completedTotalTime) {
        this.completedTotalTime = completedTotalTime;
    }

    /**
     * 返回: 保留<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.PREREQUISITES
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.PREREQUISITES
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public String getPrerequisites() {
        return prerequisites;
    }

    /**
     *  设置: 保留<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.PREREQUISITES
     *
     * @param prerequisites 保留
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites == null ? null : prerequisites.trim();
    }

    /**
     * 返回: 停止状态<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.EXIT_MODE
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.EXIT_MODE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public String getExitMode() {
        return exitMode;
    }

    /**
     *  设置: 停止状态<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.EXIT_MODE
     *
     * @param exitMode 停止状态
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setExitMode(String exitMode) {
        this.exitMode = exitMode == null ? null : exitMode.trim();
    }

    /**
     * 返回: 进入状态<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.ENTRY_STATUS
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.ENTRY_STATUS
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public String getEntryStatus() {
        return entryStatus;
    }

    /**
     *  设置: 进入状态<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.ENTRY_STATUS
     *
     * @param entryStatus 进入状态
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setEntryStatus(String entryStatus) {
        this.entryStatus = entryStatus == null ? null : entryStatus.trim();
    }

    /**
     * 返回: 成绩<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.SCORE
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.SCORE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public BigDecimal getScore() {
        return score;
    }

    /**
     *  设置: 成绩<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.SCORE
     *
     * @param score 成绩
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    /**
     * 返回: 保留<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.SCORE_MAX
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.SCORE_MAX
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public BigDecimal getScoreMax() {
        return scoreMax;
    }

    /**
     *  设置: 保留<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.SCORE_MAX
     *
     * @param scoreMax 保留
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setScoreMax(BigDecimal scoreMax) {
        this.scoreMax = scoreMax;
    }

    /**
     * 返回: 保留<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.SCORE_MIN
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.SCORE_MIN
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public BigDecimal getScoreMin() {
        return scoreMin;
    }

    /**
     *  设置: 保留<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.SCORE_MIN
     *
     * @param scoreMin 保留
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setScoreMin(BigDecimal scoreMin) {
        this.scoreMin = scoreMin;
    }

    /**
     * 返回: 是否得分<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.CREDIT
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.CREDIT
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public String getCredit() {
        return credit;
    }

    /**
     *  设置: 是否得分<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.CREDIT
     *
     * @param credit 是否得分
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    /**
     * 返回: 学习总时长<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.TOTAL_TIME
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.TOTAL_TIME
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getTotalTime() {
        return totalTime;
    }

    /**
     *  设置: 学习总时长<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.TOTAL_TIME
     *
     * @param totalTime 学习总时长
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * 返回: 课程位置<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.LESSON_LOCATION
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.LESSON_LOCATION
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public String getLessonLocation() {
        return lessonLocation;
    }

    /**
     *  设置: 课程位置<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.LESSON_LOCATION
     *
     * @param lessonLocation 课程位置
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setLessonLocation(String lessonLocation) {
        this.lessonLocation = lessonLocation == null ? null : lessonLocation.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.RECORD_STATUS
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.RECORD_STATUS
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.UPDATE_COUNT
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.CREATOR_ID
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.CREATOR_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.CREATE_DATE
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.CREATE_DATE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.UPDATER_ID
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.UPDATER_ID
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.UPDATE_DATE
     *
     * @返回  ETRAINING.CRS_SCO_PERFORMANCE.UPDATE_DATE
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.CRS_SCO_PERFORMANCE.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-23 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-23 14:48")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}