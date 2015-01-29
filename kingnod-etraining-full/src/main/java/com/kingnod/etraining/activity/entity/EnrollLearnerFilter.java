package com.kingnod.etraining.activity.entity;

import java.io.Serializable;
import java.util.Date;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.etraining.common.ObjectType;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "activityId", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "ACTIVITY_ID"), 
  @SelectColumnMapping(property = "groupNumber", type = java.lang.Integer.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "GROUP_NUMBER"), 
  @SelectColumnMapping(property = "groupName", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "GROUP_NAME"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "filterName", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "FILTER_NAME"), 
  @SelectColumnMapping(property = "filterOperator", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "FILTER_OPERATOR"), 
  @SelectColumnMapping(property = "filterValue", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "FILTER_VALUE"), 
  @SelectColumnMapping(property = "enrollMode", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "ENROLL_MODE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "UPDATE_DATE"),
  @SelectColumnMapping(property = "activityType", type = com.kingnod.etraining.common.ObjectType.class, table = "ATY_ENROLL_LEARNER_FILTER", tableAlias = "A", column = "ACTIVITY_TYPE") 
})

    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
public class EnrollLearnerFilter implements IdEntity<Long>, RecordStatus<Long>, Serializable {

	
    private ObjectType activityType;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private Long id;

    /**
     * 活动ID<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.ACTIVITY_ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private Long activityId;

    /**
     * 条件区标记<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.GROUP_NUMBER
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private Integer groupNumber;

    /**
     * 条件区名称<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.GROUP_NAME
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private String groupName;

    /**
     * 条件类型：S：站点， O:组织， U：用户, G：用户组， R：角色， P：用户属性<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.TYPE
     *
     */
    
    private ObjectType type;

    /**
     * 条件名<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_NAME
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private String filterName;

    /**
     * 条件过滤操作符<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_OPERATOR
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private String filterOperator;

    /**
     * 条件过滤的值<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_VALUE
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private String filterValue;

    /**
     * 登记方式， S：自愿， F：强制， C：审核<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.ENROLL_MODE
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private String enrollMode;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.RECORD_STATUS
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.CREATOR_ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.CREATE_DATE
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATER_ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATE_DATE
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    private Date updateDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 活动ID<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.ACTIVITY_ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.ACTIVITY_ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public Long getActivityId() {
        return activityId;
    }

    /**
     *  设置: 活动ID<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.ACTIVITY_ID
     *
     * @param activityId 活动ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 返回: 条件区标记<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.GROUP_NUMBER
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.GROUP_NUMBER
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public Integer getGroupNumber() {
        return groupNumber;
    }

    /**
     *  设置: 条件区标记<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.GROUP_NUMBER
     *
     * @param groupNumber 条件区标记
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    /**
     * 返回: 条件区名称<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.GROUP_NAME
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.GROUP_NAME
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public String getGroupName() {
        return groupName;
    }

    /**
     *  设置: 条件区名称<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.GROUP_NAME
     *
     * @param groupName 条件区名称
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 返回: 条件类型：S：站点， O:组织， U：用户, G：用户组， R：角色， P：用户属性<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.TYPE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.TYPE
     *
     */
    
    public ObjectType getType() {
        return type;
    }

    /**
     *  设置: 条件类型：S：站点， O:组织， U：用户, G：用户组， R：角色， P：用户属性<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.TYPE
     *
     * @param type 条件类型：S：站点， O:组织， U：用户, G：用户组， R：角色， P：用户属性
     *
     */
    
    public void setType(ObjectType type) {
        this.type = type;
    }

    /**
     * 返回: 条件名<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_NAME
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_NAME
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public String getFilterName() {
        return filterName;
    }

    /**
     *  设置: 条件名<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_NAME
     *
     * @param filterName 条件名
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setFilterName(String filterName) {
        this.filterName = filterName == null ? null : filterName.trim();
    }

    /**
     * 返回: 条件过滤操作符<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_OPERATOR
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_OPERATOR
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public String getFilterOperator() {
        return filterOperator;
    }

    /**
     *  设置: 条件过滤操作符<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_OPERATOR
     *
     * @param filterOperator 条件过滤操作符
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setFilterOperator(String filterOperator) {
        this.filterOperator = filterOperator == null ? null : filterOperator.trim();
    }

    /**
     * 返回: 条件过滤的值<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_VALUE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_VALUE
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public String getFilterValue() {
        return filterValue;
    }

    /**
     *  设置: 条件过滤的值<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.FILTER_VALUE
     *
     * @param filterValue 条件过滤的值
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue == null ? null : filterValue.trim();
    }

    /**
     * 返回: 登记方式， S：自愿， F：强制， C：审核<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.ENROLL_MODE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.ENROLL_MODE
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public String getEnrollMode() {
        return enrollMode;
    }

    /**
     *  设置: 登记方式， S：自愿， F：强制， C：审核<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.ENROLL_MODE
     *
     * @param enrollMode 登记方式， S：自愿， F：强制， C：审核
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setEnrollMode(String enrollMode) {
        this.enrollMode = enrollMode == null ? null : enrollMode.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.RECORD_STATUS
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.CREATOR_ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.CREATE_DATE
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATER_ID
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATE_DATE
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER_FILTER.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-08 10:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public ObjectType getActivityType() {
		return activityType;
	}

	public void setActivityType(ObjectType activityType) {
		this.activityType = activityType;
	}
    
    
}