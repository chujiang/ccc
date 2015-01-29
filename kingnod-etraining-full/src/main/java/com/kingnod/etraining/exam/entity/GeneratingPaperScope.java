package com.kingnod.etraining.exam.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "examPaperId", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "EXAM_PAPER_ID"), 
  @SelectColumnMapping(property = "questionFolderId", type = java.lang.String.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "QUESTION_FOLDER_ID"), 
  @SelectColumnMapping(property = "testGroupId", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "TEST_GROUP_ID"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "EXM_GENERATING_PAPER_SCOPE", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "testGroupName", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "C", column = "NAME"), 
  @SelectColumnMapping(property = "questionName", type = java.lang.String.class, table = "RES_FOLDER", tableAlias = "B", column = "NAME")
})

    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
public class GeneratingPaperScope implements IdEntity<Long>, RecordStatus<Long>, Serializable {
/** 
 * 自动组卷范围
 */
private static final long serialVersionUID=-7106213194875631282L;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private Long id;

    /**
     * 试卷ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private Long examPaperId;

    /**
     * 题库ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.QUESTION_FOLDER_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private String questionFolderId;

    /**
     * 测试区ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.TEST_GROUP_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private Long testGroupId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.RECORD_STATUS
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.CREATOR_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.CREATE_DATE
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATER_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATE_DATE
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private Date updateDate;

    /**
     * 题纲名称<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.NAME
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private String testGroupName;

    /**
     * 题库名称<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.NAME
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    private String questionName;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.ID
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 试卷ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.EXAM_PAPER_ID
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public Long getExamPaperId() {
        return examPaperId;
    }

    /**
     *  设置: 试卷ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.EXAM_PAPER_ID
     *
     * @param examPaperId 试卷ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setExamPaperId(Long examPaperId) {
        this.examPaperId = examPaperId;
    }

    /**
     * 返回: 题库ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.QUESTION_FOLDER_ID
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.QUESTION_FOLDER_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public String getQuestionFolderId() {
        return questionFolderId;
    }

    /**
     *  设置: 题库ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.QUESTION_FOLDER_ID
     *
     * @param questionFolderId 题库ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setQuestionFolderId(String questionFolderId) {
        this.questionFolderId = questionFolderId == null ? null : questionFolderId.trim();
    }

    /**
     * 返回: 测试区ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.TEST_GROUP_ID
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.TEST_GROUP_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public Long getTestGroupId() {
        return testGroupId;
    }

    /**
     *  设置: 测试区ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.TEST_GROUP_ID
     *
     * @param testGroupId 测试区ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setTestGroupId(Long testGroupId) {
        this.testGroupId = testGroupId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.RECORD_STATUS
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.RECORD_STATUS
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATE_COUNT
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.CREATOR_ID
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.CREATOR_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.CREATE_DATE
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.CREATE_DATE
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATER_ID
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATER_ID
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATE_DATE
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATE_DATE
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 题纲名称<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.NAME
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.NAME
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public String getTestGroupName() {
        return testGroupName;
    }

    /**
     *  设置: 题纲名称<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.NAME
     *
     * @param testGroupName 题纲名称
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setTestGroupName(String testGroupName) {
        this.testGroupName = testGroupName == null ? null : testGroupName.trim();
    }

    /**
     * 返回: 题库名称<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.NAME
     *
     * @返回  ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.NAME
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public String getQuestionName() {
        return questionName;
    }

    /**
     *  设置: 题库名称<br>
     * 对应数据库字段: ETRAINING_0508.EXM_GENERATING_PAPER_SCOPE.NAME
     *
     * @param questionName 题库名称
     *
     * @mbggenerated 2012-05-18 11:39
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 11:25")
    public void setQuestionName(String questionName) {
        this.questionName = questionName == null ? null : questionName.trim();
    }
}