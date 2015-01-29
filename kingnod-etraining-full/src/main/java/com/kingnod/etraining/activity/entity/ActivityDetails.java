package com.kingnod.etraining.activity.entity;

import java.util.Date;

import net.sf.json.JSONObject;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ObjectType;

@SelectColumnMappings({
  @SelectColumnMapping(property = "activityId", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "ACTIVITY_ID"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "folderId", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "FOLDER_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "grade", type = java.lang.Integer.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "GRADE"), 
  @SelectColumnMapping(property = "releaseStauts", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "RELEASE_STAUTS"),
  @SelectColumnMapping(property = "releaseDate", type = java.util.Date.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "RELEASE_DATE"), 
  @SelectColumnMapping(property = "completeNumber", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "COMPLETE_NUMBER"), 
  @SelectColumnMapping(property = "onlineNumber", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "ONLINE_NUMBER"), 
  @SelectColumnMapping(property = "objectDetails", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "OBJECT_DETAILS"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "UPDATE_DATE"),
  @SelectColumnMapping(property = "pNumber", type = java.lang.Integer.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "B_P_NUMBER"),
  @SelectColumnMapping(property = "attachmentId", type = java.lang.String.class, table = "CRS_COURSE_INFO", tableAlias = "A", column = "E_ATTACHMENT_ID"),
  @SelectColumnMapping(property = "userStatus", type = java.lang.String.class, table = "CRS_COURSE_INFO", tableAlias = "A", column = "F_STATUS"),
  @SelectColumnMapping(property = "enrollStatus", type = java.lang.String.class, table = "CRS_COURSE_INFO", tableAlias = "A", column = "E_STATUS"),
  @SelectColumnMapping(property = "enrollMode", type = java.lang.String.class, table = "CRS_COURSE_INFO", tableAlias = "A", column = "ENROLL_MODE"),
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "CRS_DESCRIPTION", tableAlias = "A", column = "C_DESCRIPTION")
})

    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
public class ActivityDetails implements Activity {
	


	/**
	 * 
	 */
	private int pNumber = 0;
	
	private String enrollMode;
	
	
  //是否在有效时间内
  private boolean  isInValidateDate;
  
  //是否允许注销   还没在@SelectColumnMappings加上，后边补上
  private String allowLogout;
  
  
	
	public boolean isInValidateDate() {
    return isInValidateDate;
  }

  public void setInValidateDate(boolean isInValidateDate) {
    this.isInValidateDate = isInValidateDate;
  }

  public String getAllowLogout() {
    return allowLogout;
  }

  public void setAllowLogout(String allowLogout) {
    this.allowLogout = allowLogout;
  }

  public String getEnrollMode() {
		return enrollMode;
	}

	public void setEnrollMode(String enrollMode) {
		this.enrollMode = enrollMode;
	}

	private Long siteId;
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private Long userId;
	
	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getEnrollStatus() {
		return enrollStatus;
	}

	public void setEnrollStatus(String enrollStatus) {
		this.enrollStatus = enrollStatus;
	}

	private String userStatus;
	
	private String enrollStatus;
	
	private String description;
	
	public String getDescription() {
		if(StringUtils.isEmpty(description))
		{
			return "";
		}
		else
		{
			return description;
		}
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Long attachmentId; 
	
	public Long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * 
	 */
	private String imgPath = "";
	/**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.ACTIVITY_ID
     *
     * @mbggenerated 2012-03-18 11:50
     */
    private Long activityId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.TYPE
     *
     * @mbggenerated 2012-03-18 11:50
     */
    private ObjectType type;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.FOLDER_ID
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private Long folderId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.NAME
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private String name;
    
    /**
     * 活动星级
     */
    private Integer grade;
    
    private Date releaseDate;
    
    private Long completeNumber;
    
    private Long onlineNumber;
    
    private String releaseStauts;

    public String getReleaseStauts() {
      return releaseStauts;
    }

    public void setReleaseStauts(String releaseStauts) {
      this.releaseStauts = releaseStauts;
    }

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.OBJECT_DETAILS
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private String objectDetails;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.RECORD_STATUS
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.CREATOR_ID
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.CREATE_DATE
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.UPDATER_ID
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_ACTIVITY.UPDATE_DATE
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    private Date updateDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.FOLDER_ID
     *
     * @返回  ETRAINING.ATY_ACTIVITY.FOLDER_ID
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public Long getFolderId() {
        return folderId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.FOLDER_ID
     *
     * @param folderId null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.NAME
     *
     * @返回  ETRAINING.ATY_ACTIVITY.NAME
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public String getName() {
        return name;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.NAME
     *
     * @param name null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.OBJECT_DETAILS
     *
     * @返回  ETRAINING.ATY_ACTIVITY.OBJECT_DETAILS
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public String getObjectDetails() {
        return objectDetails;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.OBJECT_DETAILS
     *
     * @param objectDetails null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setObjectDetails(String objectDetails) {
        this.objectDetails = objectDetails == null ? null : objectDetails.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_ACTIVITY.RECORD_STATUS
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_ACTIVITY.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_ACTIVITY.CREATOR_ID
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_ACTIVITY.CREATE_DATE
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_ACTIVITY.UPDATER_ID
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_ACTIVITY.UPDATE_DATE
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-18 11:07")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.ACTIVITY_ID
     *
     * @返回  ETRAINING.ATY_ACTIVITY.ACTIVITY_ID
     *
     * @mbggenerated 2012-03-18 11:50
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.ACTIVITY_ID
     *
     * @param activityId null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.TYPE
     *
     * @返回  ETRAINING.ATY_ACTIVITY.TYPE
     *
     * @mbggenerated 2012-03-18 11:50
     */
    public ObjectType getType() {
        return type;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_ACTIVITY.TYPE
     *
     * @param type null
     *
     * @mbggenerated 2012-03-18 11:50
     */
    public void setType(ObjectType type) {
        this.type = type;
    }

    public ObjectType getActivityType(){
    	return getType();
    }
	
	public Class getActivityClass() {
		return ActivityDetails.class;
	}
	
	public Activity getActivityObject(){
		if(StringUtils.isEmpty(this.getObjectDetails())){
			return null;
		}
		Class clazz = null;
		if(ObjectType.A_EL.equals(this.getType())){
			clazz = Elearning.class;
		}else if(ObjectType.A_XN.equals(this.getType())){
			clazz = Examination.class;
		}
		JSONObject jsonobj = JSONObject.fromObject(this.getObjectDetails());
		Activity activity = (Activity)JSONObject.toBean(jsonobj, clazz);
		if(null != activity && activity instanceof RecordStatus){
			RecordStatus recordStatus = (RecordStatus)activity;
			recordStatus.setRecordStatus(this.getRecordStatus());
			recordStatus.setCreateDate(this.getCreateDate());
			Long creatorId = this.getCreatorId();
			recordStatus.setCreatorId(creatorId);
			recordStatus.setUpdateDate(this.getUpdateDate());
			recordStatus.setUpdaterId(this.getUpdaterId());
			recordStatus.setUpdateCount(this.getUpdateCount());
		}
		if(null != activity && activity instanceof IdEntity){
			IdEntity idEntity = (IdEntity)activity;
			idEntity.setId(this.activityId);
		}
		return activity;
	}

	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @return the completeNumber
	 */
	public Long getCompleteNumber() {
		return completeNumber;
	}

	/**
	 * @return the onlineNumber
	 */
	public Long getOnlineNumber() {
		return null == onlineNumber?0:onlineNumber;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @param completeNumber the completeNumber to set
	 */
	public void setCompleteNumber(Long completeNumber) {
		this.completeNumber = completeNumber;
	}

	/**
	 * @param onlineNumber the onlineNumber to set
	 */
	public void setOnlineNumber(Long onlineNumber) {
		this.onlineNumber = onlineNumber;
	}
	
	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}