package com.kingnod.etraining.exam.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "examPaperId", type = java.lang.Long.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "EXAM_PAPER_ID"), 
  @SelectColumnMapping(property = "testGroupId", type = java.lang.Long.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "TEST_GROUP_ID"), 
  @SelectColumnMapping(property = "questionId", type = java.lang.Long.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "QUESTION_ID"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "degree", type = java.lang.Short.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "DEGREE"), 
  @SelectColumnMapping(property = "score", type = java.lang.Float.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "SCORE"), 
  @SelectColumnMapping(property = "sequence", type = java.lang.Integer.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "SEQUENCE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "EXM_QUESTION_TEST_GROUP", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "questionContent", type = java.lang.String.class, table = "EXM_QUESTION", tableAlias = "B", column = "CONTENT")
})

    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
public class QuestionTestGroup implements IdEntity<Long>, RecordStatus<Long>, Serializable {
	private static final long serialVersionUID=7237704341193043327L;
	private String upOrDown;
	private Integer newGroupSeq;
	private String scoreStr; // 试题分数  String类型 

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Long id;

    /**
     * 试卷ID， EXM_EXAM_PAPER表的ID<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Long examPaperId;

    /**
     * 测试区ID, EXM_TEST_GROUP表的ID<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.TEST_GROUP_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Long testGroupId;

    /**
     * 试题ID，EXM_QUESTION表的ID<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.QUESTION_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Long questionId;

    /**
     * 试题类型<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.TYPE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private String type;

    /**
     * 试题难度<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.DEGREE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Short degree;

    /**
     * 试题分数<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.SCORE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Float score;

    /**
     * 试题序号<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.SEQUENCE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Integer sequence;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.RECORD_STATUS
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.CREATOR_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.CREATE_DATE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATER_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATE_DATE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Date updateDate;

    /**
     * 课程名<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_TEST_GROUP.CONTENT
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private String questionContent;

    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    private Question question;

public String getUpOrDown(){
  return upOrDown;
}
public void setUpOrDown(String upOrDown){
  this.upOrDown=upOrDown;
}
public Integer getNewGroupSeq(){
  return newGroupSeq;
}
public void setNewGroupSeq(Integer newGroupSeq){
  this.newGroupSeq=newGroupSeq;
}

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.ID
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 试卷ID， EXM_EXAM_PAPER表的ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.EXAM_PAPER_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Long getExamPaperId() {
        return examPaperId;
    }

    /**
     *  设置: 试卷ID， EXM_EXAM_PAPER表的ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.EXAM_PAPER_ID
     *
     * @param examPaperId 试卷ID， EXM_EXAM_PAPER表的ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setExamPaperId(Long examPaperId) {
        this.examPaperId = examPaperId;
    }

    /**
     * 返回: 测试区ID, EXM_TEST_GROUP表的ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.TEST_GROUP_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.TEST_GROUP_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Long getTestGroupId() {
        return testGroupId;
    }

    /**
     *  设置: 测试区ID, EXM_TEST_GROUP表的ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.TEST_GROUP_ID
     *
     * @param testGroupId 测试区ID, EXM_TEST_GROUP表的ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setTestGroupId(Long testGroupId) {
        this.testGroupId = testGroupId;
    }

    /**
     * 返回: 试题ID，EXM_QUESTION表的ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.QUESTION_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.QUESTION_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Long getQuestionId() {
        return questionId;
    }

    /**
     *  设置: 试题ID，EXM_QUESTION表的ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.QUESTION_ID
     *
     * @param questionId 试题ID，EXM_QUESTION表的ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 返回: 试题类型<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.TYPE
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.TYPE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public String getType() {
        return type;
    }

    /**
     *  设置: 试题类型<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.TYPE
     *
     * @param type 试题类型
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 返回: 试题难度<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.DEGREE
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.DEGREE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Short getDegree() {
        return degree;
    }

    /**
     *  设置: 试题难度<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.DEGREE
     *
     * @param degree 试题难度
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setDegree(Short degree) {
        this.degree = degree;
    }

    /**
     * 返回: 试题分数<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.SCORE
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.SCORE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Float getScore() {
        return score;
    }

    /**
     *  设置: 试题分数<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.SCORE
     *
     * @param score 试题分数
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 返回: 试题序号<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.SEQUENCE
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.SEQUENCE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Integer getSequence() {
        return sequence;
    }

    /**
     *  设置: 试题序号<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.SEQUENCE
     *
     * @param sequence 试题序号
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.RECORD_STATUS
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.RECORD_STATUS
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATE_COUNT
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.CREATOR_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.CREATOR_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.CREATE_DATE
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.CREATE_DATE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATER_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATER_ID
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATE_DATE
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATE_DATE
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 课程名<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.CONTENT
     *
     * @返回  ETRAINING.EXM_QUESTION_TEST_GROUP.CONTENT
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     *  设置: 课程名<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_TEST_GROUP.CONTENT
     *
     * @param questionContent 课程名
     *
     * @mbggenerated 2012-03-26 11:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public Question getQuestion() {
        return question;
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-26 11:16")
    public void setQuestion(Question question) {
        this.question = question;
    }
	public String getScoreStr() {
		return scoreStr;
	}
	public void setScoreStr(String scoreStr) {
		this.scoreStr = scoreStr;
	}
}