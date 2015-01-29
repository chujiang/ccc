package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "folderId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "FOLDER_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "type", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "learnerNumber", type = java.lang.Integer.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "LEARNER_NUMBER"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "processStatus", type = java.lang.String.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "PROCESS_STATUS"), 
  @SelectColumnMapping(property = "checker", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "CHECKER"), 
  @SelectColumnMapping(property = "remark", type = java.lang.String.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "REMARK"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "startTime", type = java.util.Date.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "START_TIME"), 
  @SelectColumnMapping(property = "entTime", type = java.util.Date.class, table = "ATY_TRAINING_PLAN", tableAlias = "A", column = "ENT_TIME"), 
  @SelectColumnMapping(property = "typeName", type = java.lang.String.class, table = "CMN_TYPE", tableAlias = "B", column = "NAME"), 
  @SelectColumnMapping(property = "userName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "C", column = "FULL_NAME")
})

    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
public class TrainingPlan implements IdEntity<Long>, RecordStatus<Long>, Serializable {
public static final String STATUS_PENDING="P";
public static final String STATUS_CHECKING="C";
public static final String STATUS_RELEASE="R";

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Long id;

    /**
     * 活动文件夹ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.FOLDER_ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Long folderId;

    /**
     * 培训计划名称<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.NAME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private String name;

    /**
     * 培训计划类别， CMN_TYPE表的ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.TYPE
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Long type;

    /**
     * 培训人数<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.LEARNER_NUMBER
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Integer learnerNumber;

    /**
     * 培训计划描述<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.DESCRIPTION
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private String description;

    /**
     * 培训计划状态, P: 未发布， C：审核中， R：已发布<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.STATUS
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private String status;

    /**
     * 培训计划执行状态, N: 未开始， R：执行中，Y：已结束<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.PROCESS_STATUS
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private String processStatus;

    /**
     * 培训计划审核人员<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.CHECKER
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Long checker;

    /**
     * 备注<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.REMARK
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private String remark;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.RECORD_STATUS
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.CREATOR_ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.CREATE_DATE
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.UPDATER_ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.UPDATE_DATE
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Date updateDate;

    /**
     * 开始时间<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.START_TIME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Date startTime;

    /**
     * 结束时间<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.ENT_TIME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private Date entTime;

    /**
     * 培训计划类别<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.NAME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private String typeName;

    /**
     * 起草人<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN.FULL_NAME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    private String userName;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 活动文件夹ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.FOLDER_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.FOLDER_ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Long getFolderId() {
        return folderId;
    }

    /**
     *  设置: 活动文件夹ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.FOLDER_ID
     *
     * @param folderId 活动文件夹ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    /**
     * 返回: 培训计划名称<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.NAME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.NAME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public String getName() {
        return name;
    }

    /**
     *  设置: 培训计划名称<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.NAME
     *
     * @param name 培训计划名称
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 培训计划类别， CMN_TYPE表的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.TYPE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.TYPE
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Long getType() {
        return type;
    }

    /**
     *  设置: 培训计划类别， CMN_TYPE表的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.TYPE
     *
     * @param type 培训计划类别， CMN_TYPE表的ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 返回: 培训人数<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.LEARNER_NUMBER
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.LEARNER_NUMBER
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Integer getLearnerNumber() {
        return learnerNumber;
    }

    /**
     *  设置: 培训人数<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.LEARNER_NUMBER
     *
     * @param learnerNumber 培训人数
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setLearnerNumber(Integer learnerNumber) {
        this.learnerNumber = learnerNumber;
    }

    /**
     * 返回: 培训计划描述<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.DESCRIPTION
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.DESCRIPTION
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 培训计划描述<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.DESCRIPTION
     *
     * @param description 培训计划描述
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 培训计划状态, P: 未发布， C：审核中， R：已发布<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.STATUS
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.STATUS
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: 培训计划状态, P: 未发布， C：审核中， R：已发布<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.STATUS
     *
     * @param status 培训计划状态, P: 未发布， C：审核中， R：已发布
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: 培训计划执行状态, N: 未开始， R：执行中，Y：已结束<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.PROCESS_STATUS
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.PROCESS_STATUS
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public String getProcessStatus() {
        return processStatus;
    }

    /**
     *  设置: 培训计划执行状态, N: 未开始， R：执行中，Y：已结束<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.PROCESS_STATUS
     *
     * @param processStatus 培训计划执行状态, N: 未开始， R：执行中，Y：已结束
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    /**
     * 返回: 培训计划审核人员<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.CHECKER
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.CHECKER
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Long getChecker() {
        return checker;
    }

    /**
     *  设置: 培训计划审核人员<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.CHECKER
     *
     * @param checker 培训计划审核人员
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setChecker(Long checker) {
        this.checker = checker;
    }

    /**
     * 返回: 备注<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.REMARK
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.REMARK
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public String getRemark() {
        return remark;
    }

    /**
     *  设置: 备注<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.REMARK
     *
     * @param remark 备注
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.RECORD_STATUS
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.CREATOR_ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.CREATE_DATE
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.UPDATER_ID
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.UPDATE_DATE
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 开始时间<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.START_TIME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.START_TIME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Date getStartTime() {
        return startTime;
    }

    /**
     *  设置: 开始时间<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.START_TIME
     *
     * @param startTime 开始时间
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 返回: 结束时间<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.ENT_TIME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.ENT_TIME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public Date getEntTime() {
        return entTime;
    }

    /**
     *  设置: 结束时间<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.ENT_TIME
     *
     * @param entTime 结束时间
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setEntTime(Date entTime) {
        this.entTime = entTime;
    }

    /**
     * 返回: 培训计划类别<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.NAME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.NAME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public String getTypeName() {
        return typeName;
    }

    /**
     *  设置: 培训计划类别<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.NAME
     *
     * @param typeName 培训计划类别
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 返回: 起草人<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.FULL_NAME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN.FULL_NAME
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public String getUserName() {
        return userName;
    }

    /**
     *  设置: 起草人<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN.FULL_NAME
     *
     * @param userName 起草人
     *
     * @mbggenerated 2012-03-20 14:59
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-20 14:01")
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}