package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_PERIOD", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "periodFlagType", type = java.lang.String.class, table = "ATY_PERIOD", tableAlias = "A", column = "FLAG_TYPE"), 
  @SelectColumnMapping(property = "periodFlagId", type = java.lang.Long.class, table = "ATY_PERIOD", tableAlias = "A", column = "FLAG_ID"), 
  @SelectColumnMapping(property = "periodType", type = java.lang.String.class, table = "ATY_PERIOD", tableAlias = "A", column = "PERIOD_TYPE"), 
  @SelectColumnMapping(property = "startTime", type = java.sql.Time.class, table = "ATY_PERIOD", tableAlias = "A", column = "START_TIME"), 
  @SelectColumnMapping(property = "endTime", type = java.sql.Time.class, table = "ATY_PERIOD", tableAlias = "A", column = "END_TIME"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_PERIOD", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_PERIOD", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_PERIOD", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_PERIOD", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_PERIOD", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_PERIOD", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "availableDays", type = java.lang.String.class, table = "ATY_PERIOD", tableAlias = "A", column = "AVAILABLE_DAYS"), 
  @SelectColumnMapping(property = "startDate", type = java.util.Date.class, table = "ATY_PERIOD", tableAlias = "A", column = "START_DATE"), 
  @SelectColumnMapping(property = "endDate", type = java.util.Date.class, table = "ATY_PERIOD", tableAlias = "A", column = "END_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
public class Period implements IdEntity<Long>, RecordStatus<Long>, Serializable {

	private String startDateShow = "";
    public void setStartDateShow(String startDateShow) {
		this.startDateShow = startDateShow;
	}
    
    public String getStartDateShow(){
    	return (null != startDate?new SimpleDateFormat("yyyy-MM-dd").format(startDate):"");
    }
    
    private String endDateShow = "";
    
    public void setEndDateShow(String endDateShow) {
		this.endDateShow = endDateShow;
	}   
    
    public String getEndDateShow(){
    	return (null !=endDate ? new SimpleDateFormat("yyyy-MM-dd").format(endDate):"");
    }
    
    private String startTimeShow = "";
    public void setStartTimeShow(String startTimeShow) {
		this.startTimeShow = startTimeShow;
	}

	public String getStartTimeShow()
    {
    	return (null != startTime ? new SimpleDateFormat("HH:mm:ss").format(startTime):"");
    }
    
	private String endTimeShow = "";
	
	
    public void setEndTimeShow(String endTimeShow) {
		this.endTimeShow = endTimeShow;
	}

	public String getEndTimeShow()
    {
    	return (null != endTime ? new SimpleDateFormat("HH:mm:ss").format(endTime):"");
    }

	/**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Long id;

    /**
     * 标记：如：E：表示在线学习开放时间，S：表示资源预订时间<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.FLAG_TYPE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private String periodFlagType;

    /**
     * 标记ID，当FLAG_TYPE=E时，FLAG_ID表示在线学习表的ID，当FLAG_TYPE=S时， FLAG_ID表示资源预订表的ID<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.FLAG_ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Long periodFlagId;

    /**
     * 时间类别， D：每天， W: 工作日， N：无限制， S：特定<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.PERIOD_TYPE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private String periodType;

    /**
     * 开始时间<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.START_TIME
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Time startTime;

    /**
     * 结束时间<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.END_TIME
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Time endTime;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.RECORD_STATUS
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.CREATOR_ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.CREATE_DATE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.UPDATER_ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.UPDATE_DATE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Date updateDate;

    /**
     * 时间标记，当PERIOD_TYPE=D时period_time应该为1，2，3，4，5.....31中的一组值，
当PERIOD_TYPE=W时period_time应该为Monday，Tuesday ，Wednesday ，Thursday 
，Friday ，Saturday ，Saturday
当PERIOD_TYPE=N时period_time应该为null，
当PERIOD_TYPE=S时period_time应该为
 <br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.AVAILABLE_DAYS
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private String availableDays="";

    /**
     * 表示活动打开的时间段（如2-12日到2-31日在这个时间段中活动是打开的），默认start_date和end_date都为空表示活动始终打开<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.START_DATE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Date startDate;

    /**
     * 表示活动关闭的时间<br/>
     * 对应数据库字段 ETRAINING.ATY_PERIOD.END_DATE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private Date endDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.ID
     *
     * @返回  ETRAINING.ATY_PERIOD.ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 标记：如：E：表示在线学习开放时间，S：表示资源预订时间<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.FLAG_TYPE
     *
     * @返回  ETRAINING.ATY_PERIOD.FLAG_TYPE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public String getPeriodFlagType() {
        return periodFlagType;
    }

    /**
     *  设置: 标记：如：E：表示在线学习开放时间，S：表示资源预订时间<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.FLAG_TYPE
     *
     * @param flagType 标记：如：E：表示在线学习开放时间，S：表示资源预订时间
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setPeriodFlagType(String periodFlagType) {
        this.periodFlagType = periodFlagType == null ? null : periodFlagType.trim();
    }

    /**
     * 返回: 标记ID，当FLAG_TYPE=E时，FLAG_ID表示在线学习表的ID，当FLAG_TYPE=S时， FLAG_ID表示资源预订表的ID<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.FLAG_ID
     *
     * @返回  ETRAINING.ATY_PERIOD.FLAG_ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Long getPeriodFlagId() {
        return periodFlagId;
    }

    /**
     *  设置: 标记ID，当FLAG_TYPE=E时，FLAG_ID表示在线学习表的ID，当FLAG_TYPE=S时， FLAG_ID表示资源预订表的ID<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.FLAG_ID
     *
     * @param flagId 标记ID，当FLAG_TYPE=E时，FLAG_ID表示在线学习表的ID，当FLAG_TYPE=S时， FLAG_ID表示资源预订表的ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setPeriodFlagId(Long periodFlagId) {
        this.periodFlagId = periodFlagId;
    }

    /**
     * 返回: 时间类别， D：每天， W: 工作日， N：无限制， S：特定<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.PERIOD_TYPE
     *
     * @返回  ETRAINING.ATY_PERIOD.PERIOD_TYPE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public String getPeriodType() {
        return periodType;
    }

    /**
     *  设置: 时间类别， D：每天， W: 工作日， N：无限制， S：特定<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.PERIOD_TYPE
     *
     * @param periodType 时间类别， D：每天， W: 工作日， N：无限制， S：特定
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setPeriodType(String periodType) {
        this.periodType = periodType == null ? null : periodType.trim();
    }

    /**
     * 返回: 开始时间<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.START_TIME
     *
     * @返回  ETRAINING.ATY_PERIOD.START_TIME
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Time getStartTime() {
        return startTime;
    }
    
    

    /**
     *  设置: 开始时间<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.START_TIME
     *
     * @param startTime 开始时间
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * 返回: 结束时间<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.END_TIME
     *
     * @返回  ETRAINING.ATY_PERIOD.END_TIME
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Time getEndTime() {
        return endTime;
    }

    /**
     *  设置: 结束时间<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.END_TIME
     *
     * @param endTime 结束时间
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_PERIOD.RECORD_STATUS
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_PERIOD.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_PERIOD.CREATOR_ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_PERIOD.CREATE_DATE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_PERIOD.UPDATER_ID
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_PERIOD.UPDATE_DATE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 时间标记，当PERIOD_TYPE=D时period_time应该为1，2，3，4，5.....31中的一组值，
当PERIOD_TYPE=W时period_time应该为Monday，Tuesday ，Wednesday ，Thursday 
，Friday ，Saturday ，Saturday
当PERIOD_TYPE=N时period_time应该为null，
当PERIOD_TYPE=S时period_time应该为
 <br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.AVAILABLE_DAYS
     *
     * @返回  ETRAINING.ATY_PERIOD.AVAILABLE_DAYS
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public String getAvailableDays() {
        return availableDays;
    }

    /**
     *  设置: 时间标记，当PERIOD_TYPE=D时period_time应该为1，2，3，4，5.....31中的一组值，
当PERIOD_TYPE=W时period_time应该为Monday，Tuesday ，Wednesday ，Thursday 
，Friday ，Saturday ，Saturday
当PERIOD_TYPE=N时period_time应该为null，
当PERIOD_TYPE=S时period_time应该为
 <br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.AVAILABLE_DAYS
     *
     * @param availableDays 时间标记，当PERIOD_TYPE=D时period_time应该为1，2，3，4，5.....31中的一组值，
当PERIOD_TYPE=W时period_time应该为Monday，Tuesday ，Wednesday ，Thursday 
，Friday ，Saturday ，Saturday
当PERIOD_TYPE=N时period_time应该为null，
当PERIOD_TYPE=S时period_time应该为
 
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }

    /**
     * 返回: 表示活动打开的时间段（如2-12日到2-31日在这个时间段中活动是打开的），默认start_date和end_date都为空表示活动始终打开<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.START_DATE
     *
     * @返回  ETRAINING.ATY_PERIOD.START_DATE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Date getStartDate() {
        return startDate;
    }


    /**
     *  设置: 表示活动打开的时间段（如2-12日到2-31日在这个时间段中活动是打开的），默认start_date和end_date都为空表示活动始终打开<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.START_DATE
     *
     * @param startDate 表示活动打开的时间段（如2-12日到2-31日在这个时间段中活动是打开的），默认start_date和end_date都为空表示活动始终打开
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 返回: 表示活动关闭的时间<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.END_DATE
     *
     * @返回  ETRAINING.ATY_PERIOD.END_DATE
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public Date getEndDate() {
        return endDate;
    }

    /**
     *  设置: 表示活动关闭的时间<br>
     * 对应数据库字段: ETRAINING.ATY_PERIOD.END_DATE
     *
     * @param endDate 表示活动关闭的时间
     *
     * @mbggenerated 2012-03-08 11:31
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}