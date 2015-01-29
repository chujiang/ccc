package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_TIMING_TASK", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "flagType", type = java.lang.String.class, table = "ATY_TIMING_TASK", tableAlias = "A", column = "FLAG_TYPE"), 
  @SelectColumnMapping(property = "flagId", type = java.lang.Long.class, table = "ATY_TIMING_TASK", tableAlias = "A", column = "FLAG_ID"), 
  @SelectColumnMapping(property = "startTime", type = java.sql.Time.class, table = "ATY_TIMING_TASK", tableAlias = "A", column = "START_TIME"), 
  @SelectColumnMapping(property = "endTime", type = java.sql.Time.class, table = "ATY_TIMING_TASK", tableAlias = "A", column = "END_TIME")
})

    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
public class TimingTask implements IdEntity {

    /**
     * ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TIMING_TASK.ID
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    private Long id;

    /**
     * 标记：如：E：FLAG_ID表示在线学习开放时间，S：FLAG_ID表示资源预订时间<br/>
     * 对应数据库字段 ETRAINING.ATY_TIMING_TASK.FLAG_TYPE
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    private String flagType;

    /**
     * 活动ID或资源ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TIMING_TASK.FLAG_ID
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    private Long flagId;

    /**
     * 开始时间<br/>
     * 对应数据库字段 ETRAINING.ATY_TIMING_TASK.START_TIME
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    private Time startTime;

    /**
     * 结束时间<br/>
     * 对应数据库字段 ETRAINING.ATY_TIMING_TASK.END_TIME
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    private Time endTime;


    /**
     * 返回: ID<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.ID
     *
     * @返回  ETRAINING.ATY_TIMING_TASK.ID
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public Long getId() {
        return id;
    }

    /**
     *  设置: ID<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.ID
     *
     * @param id ID
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 标记：如：E：FLAG_ID表示在线学习开放时间，S：FLAG_ID表示资源预订时间<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.FLAG_TYPE
     *
     * @返回  ETRAINING.ATY_TIMING_TASK.FLAG_TYPE
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public String getFlagType() {
        return flagType;
    }

    /**
     *  设置: 标记：如：E：FLAG_ID表示在线学习开放时间，S：FLAG_ID表示资源预订时间<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.FLAG_TYPE
     *
     * @param flagType 标记：如：E：FLAG_ID表示在线学习开放时间，S：FLAG_ID表示资源预订时间
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public void setFlagType(String flagType) {
        this.flagType = flagType == null ? null : flagType.trim();
    }

    /**
     * 返回: 活动ID或资源ID<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.FLAG_ID
     *
     * @返回  ETRAINING.ATY_TIMING_TASK.FLAG_ID
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public Long getFlagId() {
        return flagId;
    }

    /**
     *  设置: 活动ID或资源ID<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.FLAG_ID
     *
     * @param flagId 活动ID或资源ID
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public void setFlagId(Long flagId) {
        this.flagId = flagId;
    }

    /**
     * 返回: 开始时间<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.START_TIME
     *
     * @返回  ETRAINING.ATY_TIMING_TASK.START_TIME
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public Time getStartTime() {
        return startTime;
    }

    /**
     *  设置: 开始时间<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.START_TIME
     *
     * @param startTime 开始时间
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * 返回: 结束时间<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.END_TIME
     *
     * @返回  ETRAINING.ATY_TIMING_TASK.END_TIME
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public Time getEndTime() {
        return endTime;
    }

    /**
     *  设置: 结束时间<br>
     * 对应数据库字段: ETRAINING.ATY_TIMING_TASK.END_TIME
     *
     * @param endTime 结束时间
     *
     * @mbggenerated 2012-03-14 19:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

	public void setId(Serializable arg0) {
		// TODO Auto-generated method stub
		
	}
}