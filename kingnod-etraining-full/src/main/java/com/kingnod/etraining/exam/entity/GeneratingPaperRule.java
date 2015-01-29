package com.kingnod.etraining.exam.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "examPaperId", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "EXAM_PAPER_ID"), 
  @SelectColumnMapping(property = "testGroupId", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "TEST_GROUP_ID"), 
  @SelectColumnMapping(property = "questionType", type = java.lang.String.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "QUESTION_TYPE"), 
  @SelectColumnMapping(property = "quantityQuestion", type = java.lang.Integer.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "QUANTITY_QUESTION"), 
  @SelectColumnMapping(property = "amountQuestion", type = java.lang.Integer.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "AMOUNT_QUESTION"), 
  @SelectColumnMapping(property = "everyQuestionScore", type = java.lang.Float.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "EVERY_QUESTION_SCORE"), 
  @SelectColumnMapping(property = "partCorrectScore", type = java.lang.Float.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "PART_CORRECT_SCORE"), 
  @SelectColumnMapping(property = "wrongScore", type = java.lang.Float.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "WRONG_SCORE"), 
  @SelectColumnMapping(property = "notScore", type = java.lang.Float.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "NOT_SCORE"), 
  @SelectColumnMapping(property = "degree", type = java.lang.Short.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "DEGREE"), 
  @SelectColumnMapping(property = "knowledgeId", type = java.lang.String.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "KNOWLEDGE_ID"), 
  @SelectColumnMapping(property = "courseId", type = java.lang.String.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "COURSE_ID"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "EXM_GENERATING_PAPER_RULE", tableAlias = "A", column = "UPDATE_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
public class GeneratingPaperRule implements IdEntity<Long>, RecordStatus<Long>, Serializable {
	/** 
	 * 自动组卷规则
	 */
	private static final long serialVersionUID=-8587171312254285254L;
	private String everyQuestionScoreStr; // 每题分数String类型

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long id;

    /**
     * 试卷ID<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long examPaperId;

    /**
     * 测试区ID<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.TEST_GROUP_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long testGroupId;

    /**
     * 试题类型<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.QUESTION_TYPE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private String questionType;

    /**
     * 题库的题目总量<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.QUANTITY_QUESTION
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Integer quantityQuestion;

    /**
     * 考核题量<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.AMOUNT_QUESTION
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Integer amountQuestion;

    /**
     * 每题分数<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.EVERY_QUESTION_SCORE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Float everyQuestionScore;

    /**
     * 部分正确得分<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.PART_CORRECT_SCORE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Float partCorrectScore;

    /**
     * 答错得分<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.WRONG_SCORE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Float wrongScore;

    /**
     * 不答得分<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.NOT_SCORE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Float notScore;

    /**
     * 难度系数<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.DEGREE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Short degree;

    /**
     * 知识点ID<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.KNOWLEDGE_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private String knowledgeId;

    /**
     * 课程ID<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.COURSE_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private String courseId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.RECORD_STATUS
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.CREATOR_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.CREATE_DATE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATER_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATE_DATE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    private Date updateDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.ID
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 试卷ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.EXAM_PAPER_ID
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getExamPaperId() {
        return examPaperId;
    }

    /**
     *  设置: 试卷ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.EXAM_PAPER_ID
     *
     * @param examPaperId 试卷ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setExamPaperId(Long examPaperId) {
        this.examPaperId = examPaperId;
    }

    /**
     * 返回: 测试区ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.TEST_GROUP_ID
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.TEST_GROUP_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getTestGroupId() {
        return testGroupId;
    }

    /**
     *  设置: 测试区ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.TEST_GROUP_ID
     *
     * @param testGroupId 测试区ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setTestGroupId(Long testGroupId) {
        this.testGroupId = testGroupId;
    }

    /**
     * 返回: 试题类型<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.QUESTION_TYPE
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.QUESTION_TYPE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public String getQuestionType() {
        return questionType;
    }

    /**
     *  设置: 试题类型<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.QUESTION_TYPE
     *
     * @param questionType 试题类型
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    /**
     * 返回: 题库的题目总量<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.QUANTITY_QUESTION
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.QUANTITY_QUESTION
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Integer getQuantityQuestion() {
        return quantityQuestion;
    }

    /**
     *  设置: 题库的题目总量<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.QUANTITY_QUESTION
     *
     * @param quantityQuestion 题库的题目总量
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setQuantityQuestion(Integer quantityQuestion) {
        this.quantityQuestion = quantityQuestion;
    }

    /**
     * 返回: 考核题量<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.AMOUNT_QUESTION
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.AMOUNT_QUESTION
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Integer getAmountQuestion() {
        return amountQuestion;
    }

    /**
     *  设置: 考核题量<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.AMOUNT_QUESTION
     *
     * @param amountQuestion 考核题量
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setAmountQuestion(Integer amountQuestion) {
        this.amountQuestion = amountQuestion;
    }

    /**
     * 返回: 每题分数<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.EVERY_QUESTION_SCORE
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.EVERY_QUESTION_SCORE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Float getEveryQuestionScore() {
        return everyQuestionScore;
    }

    /**
     *  设置: 每题分数<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.EVERY_QUESTION_SCORE
     *
     * @param everyQuestionScore 每题分数
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setEveryQuestionScore(Float everyQuestionScore) {
        this.everyQuestionScore = everyQuestionScore;
    }

    /**
     * 返回: 部分正确得分<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.PART_CORRECT_SCORE
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.PART_CORRECT_SCORE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Float getPartCorrectScore() {
        return partCorrectScore;
    }

    /**
     *  设置: 部分正确得分<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.PART_CORRECT_SCORE
     *
     * @param partCorrectScore 部分正确得分
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setPartCorrectScore(Float partCorrectScore) {
        this.partCorrectScore = partCorrectScore;
    }

    /**
     * 返回: 答错得分<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.WRONG_SCORE
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.WRONG_SCORE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Float getWrongScore() {
        return wrongScore;
    }

    /**
     *  设置: 答错得分<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.WRONG_SCORE
     *
     * @param wrongScore 答错得分
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setWrongScore(Float wrongScore) {
        this.wrongScore = wrongScore;
    }

    /**
     * 返回: 不答得分<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.NOT_SCORE
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.NOT_SCORE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Float getNotScore() {
        return notScore;
    }

    /**
     *  设置: 不答得分<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.NOT_SCORE
     *
     * @param notScore 不答得分
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setNotScore(Float notScore) {
        this.notScore = notScore;
    }

    /**
     * 返回: 难度系数<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.DEGREE
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.DEGREE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Short getDegree() {
        return degree;
    }

    /**
     *  设置: 难度系数<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.DEGREE
     *
     * @param degree 难度系数
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setDegree(Short degree) {
        this.degree = degree;
    }

    /**
     * 返回: 知识点ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.KNOWLEDGE_ID
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.KNOWLEDGE_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public String getKnowledgeId() {
        return knowledgeId;
    }

    /**
     *  设置: 知识点ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.KNOWLEDGE_ID
     *
     * @param knowledgeId 知识点ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setKnowledgeId(String knowledgeId) {
        this.knowledgeId = knowledgeId == null ? null : knowledgeId.trim();
    }

    /**
     * 返回: 课程ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.COURSE_ID
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.COURSE_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public String getCourseId() {
        return courseId;
    }

    /**
     *  设置: 课程ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.COURSE_ID
     *
     * @param courseId 课程ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.RECORD_STATUS
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.RECORD_STATUS
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATE_COUNT
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.CREATOR_ID
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.CREATOR_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.CREATE_DATE
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.CREATE_DATE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATER_ID
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATER_ID
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATE_DATE
     *
     * @返回  ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATE_DATE
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_GENERATING_PAPER_RULE.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-05-09 10:27
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public String getEveryQuestionScoreStr() {
		return everyQuestionScoreStr;
	}

	public void setEveryQuestionScoreStr(String everyQuestionScoreStr) {
		this.everyQuestionScoreStr = everyQuestionScoreStr;
	}
}