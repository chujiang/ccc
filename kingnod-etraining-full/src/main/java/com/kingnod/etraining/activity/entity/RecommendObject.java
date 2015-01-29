package com.kingnod.etraining.activity.entity;

import java.util.Date;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "flagId", type = java.lang.Long.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "FLAG_ID"), 
  @SelectColumnMapping(property = "flagType", type = java.lang.String.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "FLAG_TYPE"), 
  @SelectColumnMapping(property = "siteId", type = java.lang.Long.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "SITE_ID"), 
  @SelectColumnMapping(property = "userId", type = java.lang.Long.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "USER_ID"),
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_RECOMMEND_OBJECT", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "activity", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "B", column = "NAME")
})

    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
public class RecommendObject implements IdEntity<Long>, RecordStatus<Long>, Serializable {

	
	
	private Period periods;
    public Period getPeriods() {
		return periods;
	}

	public void setPeriods(Period periods) {
		this.periods = periods;
	}
	
    /**
     * ID<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long id;

    /**
     * 推荐对象ID<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.FLAG_ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long flagId;

    /**
     * 推荐对象类型<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.FLAG_TYPE
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private String flagType;

    /**
     * 站点ID<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.SITE_ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long siteId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.RECORD_STATUS
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.CREATOR_ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.CREATE_DATE
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATER_ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATE_DATE
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Date updateDate;

    /**
     * 活动名称<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_RECOMMEND_OBJECT.NAME
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private String activity;


    /**
     * 返回: ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.ID
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getId() {
        return id;
    }

    /**
     *  设置: ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.ID
     *
     * @param id ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 推荐对象ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.FLAG_ID
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.FLAG_ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getFlagId() {
        return flagId;
    }

    /**
     *  设置: 推荐对象ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.FLAG_ID
     *
     * @param flagId 推荐对象ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setFlagId(Long flagId) {
        this.flagId = flagId;
    }

    /**
     * 返回: 推荐对象类型<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.FLAG_TYPE
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.FLAG_TYPE
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public String getFlagType() {
        return flagType;
    }

    /**
     *  设置: 推荐对象类型<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.FLAG_TYPE
     *
     * @param flagType 推荐对象类型
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setFlagType(String flagType) {
        this.flagType = flagType == null ? null : flagType.trim();
    }

    /**
     * 返回: 站点ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.SITE_ID
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.SITE_ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getSiteId() {
        return siteId;
    }

    /**
     *  设置: 站点ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.SITE_ID
     *
     * @param siteId 站点ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.RECORD_STATUS
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.RECORD_STATUS
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATE_COUNT
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.CREATOR_ID
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.CREATOR_ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.CREATE_DATE
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.CREATE_DATE
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATER_ID
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATER_ID
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATE_DATE
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATE_DATE
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 活动名称<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.NAME
     *
     * @返回  ETRAINING_0426.ATY_RECOMMEND_OBJECT.NAME
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public String getActivity() {
        return activity;
    }

    /**
     *  设置: 活动名称<br>
     * 对应数据库字段: ETRAINING_0426.ATY_RECOMMEND_OBJECT.NAME
     *
     * @param activity 活动名称
     *
     * @mbggenerated 2012-05-09 10:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }
}