package com.kingnod.etraining.resource.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "scoreSheetId", type = java.lang.Long.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "SCORE_SHEET_ID"), 
  @SelectColumnMapping(property = "learnerScoreId", type = java.lang.Long.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "LEARNER_SCORE_ID"), 
  @SelectColumnMapping(property = "learnerScoreColumn", type = java.lang.String.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "LEARNER_SCORE_COLUMN"), 
  @SelectColumnMapping(property = "columnName", type = java.lang.String.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "COLUMN_NAME"), 
  @SelectColumnMapping(property = "remark", type = java.lang.String.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "REMARK"), 
  @SelectColumnMapping(property = "passScore", type = java.lang.String.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "PASS_SCORE"), 
  @SelectColumnMapping(property = "scorePercentage", type = java.lang.String.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "SCORE_PERCENTAGE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "RES_SCORE_RELATION", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "scoreName", type = java.lang.String.class, table = "", tableAlias = "", column = "SCORE_SHEET_NAME")
})

    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
public class ScoreRelation implements IdEntity<Long>, RecordStatus<Long>, Serializable {

	@com.kingnod.core.annotation.Generated("2012-02-27 17:33")
	private String scorePercentage = "0";
	
	@com.kingnod.core.annotation.Generated("2012-02-27 17:33")
	public String getScorePercentage() {
		return scorePercentage;
	}

	@com.kingnod.core.annotation.Generated("2012-02-27 17:33")
	public void setScorePercentage(String scorePercentage) {
		this.scorePercentage = scorePercentage;
	}

	@com.kingnod.core.annotation.Generated("2012-02-27 17:33")
	private Long passScore = 0L;
	
	@com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Long getPassScore() {
		return passScore;
	}

	@com.kingnod.core.annotation.Generated("2012-02-27 17:33")
	public void setPassScore(Long passScore) {
		this.passScore = passScore;
	}

	/**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private Long id;

    /**
     * 成绩表ID<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.SCORE_SHEET_ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private Long scoreSheetId;

    /**
     * 学员成绩表ID<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.LEARNER_SCORE_ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private Long learnerScoreId = new Long(0);

    /**
     * 学员成绩表字段<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.LEARNER_SCORE_COLUMN
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private String learnerScoreColumn;

    /**
     * 成绩名称<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.COLUMN_NAME
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private String columnName;

    /**
     * 描述<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.REMARK
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private String remark;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.RECORD_STATUS
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.CREATOR_ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.CREATE_DATE
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.UPDATER_ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.UPDATE_DATE
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private Date updateDate;

    /**
     * 成绩名<br/>
     * 对应数据库字段 ETRAINING.RES_SCORE_RELATION.NAME
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private String scoreName;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.ID
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 成绩表ID<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.SCORE_SHEET_ID
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.SCORE_SHEET_ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Long getScoreSheetId() {
        return scoreSheetId;
    }

    /**
     *  设置: 成绩表ID<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.SCORE_SHEET_ID
     *
     * @param scoreSheetId 成绩表ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setScoreSheetId(Long scoreSheetId) {
        this.scoreSheetId = scoreSheetId;
    }

    /**
     * 返回: 学员成绩表ID<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.LEARNER_SCORE_ID
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.LEARNER_SCORE_ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Long getLearnerScoreId() {
        return learnerScoreId;
    }

    /**
     *  设置: 学员成绩表ID<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.LEARNER_SCORE_ID
     *
     * @param learnerScoreId 学员成绩表ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setLearnerScoreId(Long learnerScoreId) {
        this.learnerScoreId = learnerScoreId;
    }

    /**
     * 返回: 学员成绩表字段<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.LEARNER_SCORE_COLUMN
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.LEARNER_SCORE_COLUMN
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public String getLearnerScoreColumn() {
        return learnerScoreColumn;
    }

    /**
     *  设置: 学员成绩表字段<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.LEARNER_SCORE_COLUMN
     *
     * @param learnerScoreColumn 学员成绩表字段
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setLearnerScoreColumn(String learnerScoreColumn) {
        this.learnerScoreColumn = learnerScoreColumn == null ? null : learnerScoreColumn.trim();
    }

    /**
     * 返回: 成绩名称<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.COLUMN_NAME
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.COLUMN_NAME
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public String getColumnName() {
        return columnName;
    }

    /**
     *  设置: 成绩名称<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.COLUMN_NAME
     *
     * @param columnName 成绩名称
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * 返回: 描述<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.REMARK
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.REMARK
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public String getRemark() {
        return remark;
    }

    /**
     *  设置: 描述<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.REMARK
     *
     * @param remark 描述
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.RECORD_STATUS
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.RECORD_STATUS
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.UPDATE_COUNT
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.CREATOR_ID
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.CREATOR_ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.CREATE_DATE
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.CREATE_DATE
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.UPDATER_ID
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.UPDATER_ID
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.UPDATE_DATE
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.UPDATE_DATE
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 成绩名<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.NAME
     *
     * @返回  ETRAINING.RES_SCORE_RELATION.NAME
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public String getScoreName() {
        return scoreName;
    }

    /**
     *  设置: 成绩名<br>
     * 对应数据库字段: ETRAINING.RES_SCORE_RELATION.NAME
     *
     * @param scoreName 成绩名
     *
     * @mbggenerated 2012-02-27 17:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public void setScoreName(String scoreName) {
        this.scoreName = scoreName == null ? null : scoreName.trim();
    }
}