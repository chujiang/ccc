package com.kingnod.etraining.activity.entity;

import java.io.Serializable;
import java.util.Date;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.etraining.common.ObjectType;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "activityId", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "ACTIVITY_ID"), 
  @SelectColumnMapping(property = "userId", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "USER_ID"), 
  @SelectColumnMapping(property = "enrollMode", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "ENROLL_MODE"), 
  @SelectColumnMapping(property = "stauts", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "STAUTS"), 
  @SelectColumnMapping(property = "excluded", type = java.lang.Boolean.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "EXCLUDED"), 
  @SelectColumnMapping(property = "activityType", type = com.kingnod.etraining.common.ObjectType.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "ACTIVITY_TYPE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "UPDATE_DATE"),
  @SelectColumnMapping(property = "loginName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "B", column = "LOGIN_NAME"),
  @SelectColumnMapping(property = "fullName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "B", column = "FULL_NAME"),
  @SelectColumnMapping(property = "siteName", type = java.lang.String.class, table = "ORG_SITE", tableAlias = "C", column = "NAME"),
  @SelectColumnMapping(property = "isNew", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "IS_NEW"),
  @SelectColumnMapping(property = "orgId", type = java.lang.Long.class, table = "ORG_ORGANIZATION", tableAlias = "D", column = "ID"), 
  @SelectColumnMapping(property = "orgName", type = java.lang.String.class, table = "ORG_ORGANIZATION", tableAlias = "D", column = "NAME")
	
})

    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
public class EnrollLearner implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Long id;

    /**
     * 活动ID<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.ACTIVITY_ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Long activityId;

    /**
     * 用户ID<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.USER_ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Long userId;

    /**
     * 登记方式， S：自愿， F：强制， C：审核<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.ENROLL_MODE
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private String enrollMode;

    /**
     * 状态， R：注册， O：注销<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.STAUTS
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private String stauts;

    /**
     * 是否排除<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.EXCLUDED
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Boolean excluded;

    /**
     * 活动类型<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.ACTIVITY_TYPE
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private ObjectType activityType;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.RECORD_STATUS
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.CREATOR_ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.CREATE_DATE
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.UPDATER_ID
     *
     * @mbggenerated 2012-03-30 17:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ENROLL_LEARNER.UPDATE_DATE
     *
     * @mbggenerated 2012-03-30 17:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    private Date updateDate;

    /**
     * 学员姓名<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_ENROLL_LEARNER.FULL_NAME
     *
     * @mbggenerated 2012-05-03 20:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-03 20:11")
    private String fullName;	//用户姓名
    private String loginName;	//用户名
    private String siteName;	//站点名称
    private String isNew;       //通知信息 
    private Long orgid;//组织ID
    private String orgName;//组织名称
    private String childName;//父节点名称

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 活动ID<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.ACTIVITY_ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.ACTIVITY_ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Long getActivityId() {
        return activityId;
    }

    /**
     *  设置: 活动ID<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.ACTIVITY_ID
     *
     * @param activityId 活动ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 返回: 用户ID<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.USER_ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.USER_ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Long getUserId() {
        return userId;
    }

    /**
     *  设置: 用户ID<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.USER_ID
     *
     * @param userId 用户ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 返回: 登记方式， S：自愿， F：强制， C：审核<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.ENROLL_MODE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.ENROLL_MODE
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public String getEnrollMode() {
        return enrollMode;
    }

    /**
     *  设置: 登记方式， S：自愿， F：强制， C：审核<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.ENROLL_MODE
     *
     * @param enrollMode 登记方式， S：自愿， F：强制， C：审核
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setEnrollMode(String enrollMode) {
        this.enrollMode = enrollMode == null ? null : enrollMode.trim();
    }

    /**
     * 返回: 状态， R：注册， O：注销<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.STAUTS
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.STAUTS
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public String getStauts() {
        return stauts;
    }

    /**
     *  设置: 状态， R：注册， O：注销<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.STAUTS
     *
     * @param stauts 状态， R：注册， O：注销
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setStauts(String stauts) {
        this.stauts = stauts == null ? null : stauts.trim();
    }

    /**
     * 返回: 是否排除<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.EXCLUDED
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.EXCLUDED
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Boolean getExcluded() {
        return excluded;
    }

    /**
     *  设置: 是否排除<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.EXCLUDED
     *
     * @param excluded 是否排除
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setExcluded(Boolean excluded) {
        this.excluded = excluded;
    }

    /**
     * 返回: 活动类型<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.ACTIVITY_TYPE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.ACTIVITY_TYPE
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    public ObjectType getActivityType() {
        return activityType;
    }

    /**
     *  设置: 活动类型<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.ACTIVITY_TYPE
     *
     * @param activityType 活动类型
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    public void setActivityType(ObjectType activityType) {
        this.activityType = activityType;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.RECORD_STATUS
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.CREATOR_ID
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.CREATE_DATE
     *
     * @mbggenerated 2012-03-30 17:34
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-30 17:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.UPDATER_ID
     *
     * @mbggenerated 2012-03-30 17:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-30 17:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_ENROLL_LEARNER.UPDATE_DATE
     *
     * @mbggenerated 2012-03-30 17:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ENROLL_LEARNER.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-30 17:35
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-30 17:42")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 学员姓名<br>
     * 对应数据库字段: ETRAINING_0426.ATY_ENROLL_LEARNER.FULL_NAME
     *
     * @返回  ETRAINING_0426.ATY_ENROLL_LEARNER.FULL_NAME
     *
     * @mbggenerated 2012-05-03 20:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-03 20:11")
    public String getFullName() {
        return fullName;
    }

    /**
     *  设置: 学员姓名<br>
     * 对应数据库字段: ETRAINING_0426.ATY_ENROLL_LEARNER.FULL_NAME
     *
     * @param fullName 学员姓名
     *
     * @mbggenerated 2012-05-03 20:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-03 20:11")
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }
    
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}


	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	
	

}