package com.kingnod.etraining.resource.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.etraining.common.ObjectType;

import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "folderId", type = java.lang.Long.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "FOLDER_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "activityId", type = java.lang.Long.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "ACTIVITY_ID"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "remark", type = java.lang.String.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "REMARK"), 
  @SelectColumnMapping(property = "passScore", type = java.lang.String.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "PASSSCORE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "RES_SCORE_SHEET", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "maxScore", type = java.util.Date.class, table = "", tableAlias = "", column = "MAX_SCORE"), 
  @SelectColumnMapping(property = "minScore", type = java.util.Date.class, table = "", tableAlias = "", column = "MIN_SCORE"), 
  @SelectColumnMapping(property = "avgScore", type = java.util.Date.class, table = "", tableAlias = "", column = "AVG_SCORE"), 
  @SelectColumnMapping(property = "passingRate", type = java.lang.String.class, table = "", tableAlias = "", column = "PASSING_RATE"),
  @SelectColumnMapping(property = "folderName", type = java.lang.String.class, table = "RES_FOLDER", tableAlias = "B", column = "NAME")
})

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
public class ScoreSheet implements IdEntity<Long>, RecordStatus<Long>, Serializable {

	@com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String passScore = "0";
	
	private ObjectType objectType;
	
	
	public ObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}

	@com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public String getPassScore() {
		return passScore;
	}

	@com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public void setPassScore(String passScore) {
		this.passScore = passScore;
	}
	
	@com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	private String passingRate;
	
	@com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public String getPassingRate() {
		return passingRate;
	}
	
	@com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public void setPassingRate(String passingRate) {
		this.passingRate = passingRate + "%";
	}

	@com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String maxScore = "0";
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String minScore = "0";
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String avgScore = "0";
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public String getMaxScore() {
		return maxScore;
	}

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public void setMaxScore(String maxScore) {
		this.maxScore = maxScore;
	}

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public String getMinScore() {
		return minScore;
	}

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public void setMinScore(String minScose) {
		this.minScore = minScose;
	}

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public String getAvgScore() {
		return avgScore;
	}

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	
    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private Long id;

    /**
     * 文件夹ID<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.FOLDER_ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private Long folderId;

    /**
     * 成绩表名称<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.NAME
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String name;

    /**
     * 培训活动ID<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.ACTIVITY_ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private Long activityId;

    /**
     * 成绩表描述<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.DESCRIPTION
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String description;

    /**
     * 备注<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.REMARK
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String remark;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.RECORD_STATUS
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.CREATOR_ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.CREATE_DATE
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.UPDATER_ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.UPDATE_DATE
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private Date updateDate;

    /**
     * 文件夹<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_SHEET.NAME
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private String folderName;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.ID
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 文件夹ID<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.FOLDER_ID
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.FOLDER_ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Long getFolderId() {
        return folderId;
    }

    /**
     *  设置: 文件夹ID<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.FOLDER_ID
     *
     * @param folderId 文件夹ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    /**
     * 返回: 成绩表名称<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.NAME
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.NAME
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public String getName() {
        return name;
    }

    /**
     *  设置: 成绩表名称<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.NAME
     *
     * @param name 成绩表名称
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 培训活动ID<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.ACTIVITY_ID
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.ACTIVITY_ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Long getActivityId() {
        return activityId;
    }

    /**
     *  设置: 培训活动ID<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.ACTIVITY_ID
     *
     * @param activityId 培训活动ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * 返回: 成绩表描述<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.DESCRIPTION
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.DESCRIPTION
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 成绩表描述<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.DESCRIPTION
     *
     * @param description 成绩表描述
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 备注<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.REMARK
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.REMARK
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public String getRemark() {
        return remark;
    }

    /**
     *  设置: 备注<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.REMARK
     *
     * @param remark 备注
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.RECORD_STATUS
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.RECORD_STATUS
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.UPDATE_COUNT
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.CREATOR_ID
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.CREATOR_ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.CREATE_DATE
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.CREATE_DATE
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.UPDATER_ID
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.UPDATER_ID
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.UPDATE_DATE
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.UPDATE_DATE
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 文件夹<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.NAME
     *
     * @返回  ETRAINING.RES_SCORE_SHEET.NAME
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public String getFolderName() {
        return folderName;
    }

    /**
     *  设置: 文件夹<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_SHEET.NAME
     *
     * @param folderName 文件夹
     *
     * @mbggenerated 2012-02-22 15:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public void setFolderName(String folderName) {
        this.folderName = folderName == null ? null : folderName.trim();
    }
}