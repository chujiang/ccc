package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "trainingPlanId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "TRAINING_PLAN_ID"), 
  @SelectColumnMapping(property = "trainingPlanItemId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "TRAINING_PLAN_ITEM_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "type", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "object", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "OBJECT"), 
  @SelectColumnMapping(property = "responser", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "RESPONSER"), 
  @SelectColumnMapping(property = "learnerNumber", type = java.lang.Integer.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "LEARNER_NUMBER"), 
  @SelectColumnMapping(property = "outline", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "OUTLINE"), 
  @SelectColumnMapping(property = "lessons", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "LESSONS"), 
  @SelectColumnMapping(property = "predictCost", type = java.math.BigDecimal.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "PREDICT_COST"), 
  @SelectColumnMapping(property = "time", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "TIME"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "remark", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "REMARK"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_TRAINING_PLAN_PROCESS", tableAlias = "A", column = "UPDATE_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
public class TrainingPlanProcess implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Long id;

    /**
     * 培训计划ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.TRAINING_PLAN_ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Long trainingPlanId;

    /**
     * 培训计划ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.TRAINING_PLAN_ITEM_ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Long trainingPlanItemId;

    /**
     * 项目名称<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.NAME
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private String name;

    /**
     * 项目类别, CMN_TYPE的ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.TYPE
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Long type;

    /**
     * 培训对象<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.OBJECT
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private String object;

    /**
     * 培训负责人， ORG_USER表的ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.RESPONSER
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Long responser;

    /**
     * 培训人次<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.LEARNER_NUMBER
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Integer learnerNumber;

    /**
     * 培训纲要<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.OUTLINE
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private String outline;

    /**
     * 培训课时<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.LESSONS
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private String lessons;

    /**
     * 培训预算<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.PREDICT_COST
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private BigDecimal predictCost;

    /**
     * 培训时间<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.TIME
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private String time;

    /**
     * 培训计划项目状态， R：执行中， E：结束<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.STATUS
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private String status;

    /**
     * 备注<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.REMARK
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private String remark;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.RECORD_STATUS
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.CREATOR_ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.CREATE_DATE
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATER_ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATE_DATE
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private Date updateDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 培训计划ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.TRAINING_PLAN_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.TRAINING_PLAN_ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Long getTrainingPlanId() {
        return trainingPlanId;
    }

    /**
     *  设置: 培训计划ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.TRAINING_PLAN_ID
     *
     * @param trainingPlanId 培训计划ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setTrainingPlanId(Long trainingPlanId) {
        this.trainingPlanId = trainingPlanId;
    }

    /**
     * 返回: 培训计划ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.TRAINING_PLAN_ITEM_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.TRAINING_PLAN_ITEM_ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Long getTrainingPlanItemId() {
        return trainingPlanItemId;
    }

    /**
     *  设置: 培训计划ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.TRAINING_PLAN_ITEM_ID
     *
     * @param trainingPlanItemId 培训计划ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setTrainingPlanItemId(Long trainingPlanItemId) {
        this.trainingPlanItemId = trainingPlanItemId;
    }

    /**
     * 返回: 项目名称<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.NAME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.NAME
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String getName() {
        return name;
    }

    /**
     *  设置: 项目名称<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.NAME
     *
     * @param name 项目名称
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 项目类别, CMN_TYPE的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.TYPE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.TYPE
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Long getType() {
        return type;
    }

    /**
     *  设置: 项目类别, CMN_TYPE的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.TYPE
     *
     * @param type 项目类别, CMN_TYPE的ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 返回: 培训对象<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.OBJECT
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.OBJECT
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String getObject() {
        return object;
    }

    /**
     *  设置: 培训对象<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.OBJECT
     *
     * @param object 培训对象
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setObject(String object) {
        this.object = object == null ? null : object.trim();
    }

    /**
     * 返回: 培训负责人， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.RESPONSER
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.RESPONSER
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Long getResponser() {
        return responser;
    }

    /**
     *  设置: 培训负责人， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.RESPONSER
     *
     * @param responser 培训负责人， ORG_USER表的ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setResponser(Long responser) {
        this.responser = responser;
    }

    /**
     * 返回: 培训人次<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.LEARNER_NUMBER
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.LEARNER_NUMBER
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Integer getLearnerNumber() {
        return learnerNumber;
    }

    /**
     *  设置: 培训人次<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.LEARNER_NUMBER
     *
     * @param learnerNumber 培训人次
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setLearnerNumber(Integer learnerNumber) {
        this.learnerNumber = learnerNumber;
    }

    /**
     * 返回: 培训纲要<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.OUTLINE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.OUTLINE
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String getOutline() {
        return outline;
    }

    /**
     *  设置: 培训纲要<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.OUTLINE
     *
     * @param outline 培训纲要
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    /**
     * 返回: 培训课时<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.LESSONS
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.LESSONS
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String getLessons() {
        return lessons;
    }

    /**
     *  设置: 培训课时<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.LESSONS
     *
     * @param lessons 培训课时
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setLessons(String lessons) {
        this.lessons = lessons == null ? null : lessons.trim();
    }

    /**
     * 返回: 培训预算<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.PREDICT_COST
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.PREDICT_COST
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public BigDecimal getPredictCost() {
        return predictCost;
    }

    /**
     *  设置: 培训预算<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.PREDICT_COST
     *
     * @param predictCost 培训预算
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setPredictCost(BigDecimal predictCost) {
        this.predictCost = predictCost;
    }

    /**
     * 返回: 培训时间<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.TIME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.TIME
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String getTime() {
        return time;
    }

    /**
     *  设置: 培训时间<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.TIME
     *
     * @param time 培训时间
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    /**
     * 返回: 培训计划项目状态， R：执行中， E：结束<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.STATUS
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.STATUS
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: 培训计划项目状态， R：执行中， E：结束<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.STATUS
     *
     * @param status 培训计划项目状态， R：执行中， E：结束
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: 备注<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.REMARK
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.REMARK
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String getRemark() {
        return remark;
    }

    /**
     *  设置: 备注<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.REMARK
     *
     * @param remark 备注
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.RECORD_STATUS
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.CREATOR_ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.CREATE_DATE
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATER_ID
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATE_DATE
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_PROCESS.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-02-14 15:40
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}