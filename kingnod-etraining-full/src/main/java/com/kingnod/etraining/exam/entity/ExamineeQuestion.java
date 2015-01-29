package com.kingnod.etraining.exam.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.organization.entity.User;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "examPaperId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "EXAM_PAPER_ID"), 
  @SelectColumnMapping(property = "userId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "USER_ID"), 
  @SelectColumnMapping(property = "questionId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "QUESTION_ID"), 
  @SelectColumnMapping(property = "questionSeq", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "QUESTION_SEQ"), 
  @SelectColumnMapping(property = "degree", type = java.lang.Short.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "DEGREE"), 
  @SelectColumnMapping(property = "deservedScore", type = java.math.BigDecimal.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "DESERVED_SCORE"), 
  @SelectColumnMapping(property = "examineeAnswer", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "EXAMINEE_ANSWER"), 
  @SelectColumnMapping(property = "examineeAnswer1", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "EXAMINEE_ANSWER1"), 
  @SelectColumnMapping(property = "examineeAnswer2", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "EXAMINEE_ANSWER2"), 
  @SelectColumnMapping(property = "examineeAnswer3", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "EXAMINEE_ANSWER3"), 
  @SelectColumnMapping(property = "examineeAnswer4", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "EXAMINEE_ANSWER4"), 
  @SelectColumnMapping(property = "reviewed", type = java.lang.Boolean.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "REVIEWED"), 
  @SelectColumnMapping(property = "examNumber", type = java.lang.Integer.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "EXAM_NUMBER"), 
  @SelectColumnMapping(property = "score", type = java.lang.Float.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "SCORE"), 
  @SelectColumnMapping(property = "correctAnswers", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "CORRECT_ANSWERS"), 
  @SelectColumnMapping(property = "viewPerson", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "VIEW_PERSON"), 
  @SelectColumnMapping(property = "viewScore", type = java.math.BigDecimal.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "VIEW_SCORE"), 
  @SelectColumnMapping(property = "approvePerson", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "APPROVE_PERSON"), 
  @SelectColumnMapping(property = "approveIdeas", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "APPROVE_IDEAS"), 
  @SelectColumnMapping(property = "checkPerson", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "CHECK_PERSON"), 
  @SelectColumnMapping(property = "checkIdeas", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "CHECK_IDEAS"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "examinationId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "EXAMINATION_ID"), 
  @SelectColumnMapping(property = "parentId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "PARENT_ID"), 
  @SelectColumnMapping(property = "ruleId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "RULE_ID"), 
  @SelectColumnMapping(property = "approveScore", type = java.math.BigDecimal.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "APPROVE_SCORE"), 
  @SelectColumnMapping(property = "questionType", type = java.lang.String.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "QUESTION_TYPE"),
  @SelectColumnMapping(property = "testGroupId", type = java.lang.Long.class, table = "EXM_EXAMINEE_QUESTION", tableAlias = "A", column = "TEST_GROUP_ID")
})

@com.kingnod.core.annotation.Generated("2012-05-28 16:31")
public class ExamineeQuestion implements IdEntity<Long>, RecordStatus<Long>, Serializable {
	private static final long serialVersionUID=3088246946633640058L;
	private Integer hasAnswerNumber;
	private Integer totalNumber;
	private Integer reviewedNumber;
	private String viewPersonName;//辅助字段，
	private String approvePersonName;//辅助字段
	private boolean approveStatus = false;//辅助字段，判断是否需要审核，用来模块显示中，只有审核之后才能重新给分
	private String type;
	private Integer sequence=0;
	private List<String> examAnswer = new ArrayList<String>(); // 考生答案集
	
    public List<String> getExamAnswer() {
		return examAnswer;
	}
	public void setExamAnswer(List<String> examAnswer) {
		this.examAnswer = examAnswer;
	}
	public boolean isApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(boolean approveStatus) {
		this.approveStatus = approveStatus;
	}
	/**
     * 分数ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long id;

    /**
     * 试卷ID， EXM_EXAM_PAPER表的ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long examPaperId;

    /**
     * 考生ID， ORG_USER表的ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.USER_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long userId;

    /**
     * 试题ID， EXM_QUESTION表的ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long questionId;

    /**
     * 试题顺序<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_SEQ
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long questionSeq;

    /**
     * 试题难度<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.DEGREE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Short degree;

    /**
     * 试题应得分数， 保留一位小数<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.DESERVED_SCORE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private BigDecimal deservedScore;

    /**
     * 答案<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String examineeAnswer;

    /**
     * 答案1<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER1
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String examineeAnswer1;

    /**
     * 答案2<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER2
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String examineeAnswer2;

    /**
     * 答案3<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER3
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String examineeAnswer3;

    /**
     * 答案4<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER4
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String examineeAnswer4;

    /**
     * 复查标识符<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.REVIEWED
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Boolean reviewed;

    /**
     * 考试次数<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAM_NUMBER
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Integer examNumber;

    /**
     * 试题分数<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.SCORE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Float score;

    /**
     * 正确答案ID集<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.CORRECT_ANSWERS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String correctAnswers;

    /**
     * 阅卷人， ORG_USER表的ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.VIEW_PERSON
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long viewPerson;

    /**
     * 阅卷得分<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.VIEW_SCORE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private BigDecimal viewScore;

    /**
     * 审核人， ORG_USER表的ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_PERSON
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long approvePerson;

    /**
     * 审核人意见<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_IDEAS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String approveIdeas;

    /**
     * 复核人， ORG_USER表的ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.CHECK_PERSON
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long checkPerson;

    /**
     * 复核人意见<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.CHECK_IDEAS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String checkIdeas;

    /**
     * 阅卷状态<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.STATUS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String status;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.RECORD_STATUS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.CREATOR_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.CREATE_DATE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATER_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATE_DATE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Date updateDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINATION_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long examinationId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.PARENT_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long parentId;

    /**
     * 动态组卷规则ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.RULE_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long ruleId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_SCORE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private BigDecimal approveScore;

    /**
     * 试题类型<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_TYPE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private String questionType;
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Long testGroupId;

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Examination examination;

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private User user;

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Question question;

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private List<QuestionAnswer> questionAnswers;

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    private Paper paper;

	public Integer getSequence(){
	  return sequence;
	}
	public void setSequence(Integer sequence){
	  this.sequence=sequence;
	}
	public Integer getHasAnswerNumber(){
	  return hasAnswerNumber;
	}
	public void setHasAnswerNumber(Integer hasAnswerNumber){
	  this.hasAnswerNumber=hasAnswerNumber;
	}
	public Integer getTotalNumber(){
	  return totalNumber;
	}
	public void setTotalNumber(Integer totalNumber){
	  this.totalNumber=totalNumber;
	}
	public Integer getReviewedNumber(){
	  return reviewedNumber;
	}
	public void setReviewedNumber(Integer reviewedNumber){
	  this.reviewedNumber=reviewedNumber;
	}
	public String getViewPersonName(){
	  return viewPersonName;
	}
	public void setViewPersonName(String viewPersonName){
	  this.viewPersonName=viewPersonName;
	}
	public String getApprovePersonName(){
	  return approvePersonName;
	}
	public void setApprovePersonName(String approvePersonName){
	  this.approvePersonName=approvePersonName;
	}
	public String getType(){
	  return type;
	}
	public void setType(String type){
	  this.type=type;
	}

    /**
     * 返回: 分数ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getId() {
        return id;
    }

    /**
     *  设置: 分数ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.ID
     *
     * @param id 分数ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 试卷ID， EXM_EXAM_PAPER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAM_PAPER_ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getExamPaperId() {
        return examPaperId;
    }

    /**
     *  设置: 试卷ID， EXM_EXAM_PAPER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAM_PAPER_ID
     *
     * @param examPaperId 试卷ID， EXM_EXAM_PAPER表的ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExamPaperId(Long examPaperId) {
        this.examPaperId = examPaperId;
    }

    /**
     * 返回: 考生ID， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.USER_ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.USER_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getUserId() {
        return userId;
    }

    /**
     *  设置: 考生ID， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.USER_ID
     *
     * @param userId 考生ID， ORG_USER表的ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 返回: 试题ID， EXM_QUESTION表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getQuestionId() {
        return questionId;
    }

    /**
     *  设置: 试题ID， EXM_QUESTION表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_ID
     *
     * @param questionId 试题ID， EXM_QUESTION表的ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 返回: 试题顺序<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_SEQ
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_SEQ
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getQuestionSeq() {
        return questionSeq;
    }

    /**
     *  设置: 试题顺序<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_SEQ
     *
     * @param questionSeq 试题顺序
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setQuestionSeq(Long questionSeq) {
        this.questionSeq = questionSeq;
    }

    /**
     * 返回: 试题难度<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.DEGREE
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.DEGREE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Short getDegree() {
        return degree;
    }

    /**
     *  设置: 试题难度<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.DEGREE
     *
     * @param degree 试题难度
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setDegree(Short degree) {
        this.degree = degree;
    }

    /**
     * 返回: 试题应得分数， 保留一位小数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.DESERVED_SCORE
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.DESERVED_SCORE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public BigDecimal getDeservedScore() {
        return deservedScore;
    }

    /**
     *  设置: 试题应得分数， 保留一位小数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.DESERVED_SCORE
     *
     * @param deservedScore 试题应得分数， 保留一位小数
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setDeservedScore(BigDecimal deservedScore) {
        this.deservedScore = deservedScore;
    }

    /**
     * 返回: 答案<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getExamineeAnswer() {
        return examineeAnswer;
    }

    /**
     *  设置: 答案<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER
     *
     * @param examineeAnswer 答案
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExamineeAnswer(String examineeAnswer) {
    	if(null != examineeAnswer) {
			// 将考生答案以 ","进行分割，并setter 到list集合中  
			// 分割的情况只适合  多选题
			String[] corretAnswers = examineeAnswer.split(",");
			for (String answer : corretAnswers) {
				examAnswer.add(answer);
			}
		}
        this.examineeAnswer = examineeAnswer == null ? null : examineeAnswer.trim();
    }

    /**
     * 返回: 答案1<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER1
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER1
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getExamineeAnswer1() {
        return examineeAnswer1;
    }

    /**
     *  设置: 答案1<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER1
     *
     * @param examineeAnswer1 答案1
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExamineeAnswer1(String examineeAnswer1) {
    	examAnswer.add(examineeAnswer1);
        this.examineeAnswer1 = examineeAnswer1 == null ? null : examineeAnswer1.trim();
    }

    /**
     * 返回: 答案2<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER2
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER2
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getExamineeAnswer2() {
        return examineeAnswer2;
    }

    /**
     *  设置: 答案2<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER2
     *
     * @param examineeAnswer2 答案2
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExamineeAnswer2(String examineeAnswer2) {
    	examAnswer.add(examineeAnswer2);
        this.examineeAnswer2 = examineeAnswer2 == null ? null : examineeAnswer2.trim();
    }

    /**
     * 返回: 答案3<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER3
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER3
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getExamineeAnswer3() {
        return examineeAnswer3;
    }

    /**
     *  设置: 答案3<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER3
     *
     * @param examineeAnswer3 答案3
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExamineeAnswer3(String examineeAnswer3) {
    	examAnswer.add(examineeAnswer3);
        this.examineeAnswer3 = examineeAnswer3 == null ? null : examineeAnswer3.trim();
    }

    /**
     * 返回: 答案4<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER4
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER4
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getExamineeAnswer4() {
        return examineeAnswer4;
    }

    /**
     *  设置: 答案4<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINEE_ANSWER4
     *
     * @param examineeAnswer4 答案4
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExamineeAnswer4(String examineeAnswer4) {
    	examAnswer.add(examineeAnswer4);
        this.examineeAnswer4 = examineeAnswer4 == null ? null : examineeAnswer4.trim();
    }

    /**
     * 返回: 复查标识符<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.REVIEWED
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.REVIEWED
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Boolean getReviewed() {
        return reviewed;
    }

    /**
     *  设置: 复查标识符<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.REVIEWED
     *
     * @param reviewed 复查标识符
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setReviewed(Boolean reviewed) {
        this.reviewed = reviewed;
    }

    /**
     * 返回: 考试次数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAM_NUMBER
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAM_NUMBER
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Integer getExamNumber() {
        return examNumber;
    }

    /**
     *  设置: 考试次数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAM_NUMBER
     *
     * @param examNumber 考试次数
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExamNumber(Integer examNumber) {
        this.examNumber = examNumber;
    }

    /**
     * 返回: 试题分数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.SCORE
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.SCORE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Float getScore() {
        return score;
    }

    /**
     *  设置: 试题分数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.SCORE
     *
     * @param score 试题分数
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 返回: 正确答案ID集<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CORRECT_ANSWERS
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.CORRECT_ANSWERS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getCorrectAnswers() {
        return correctAnswers;
    }

    /**
     *  设置: 正确答案ID集<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CORRECT_ANSWERS
     *
     * @param correctAnswers 正确答案ID集
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setCorrectAnswers(String correctAnswers) {
        this.correctAnswers = correctAnswers == null ? null : correctAnswers.trim();
    }

    /**
     * 返回: 阅卷人， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.VIEW_PERSON
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.VIEW_PERSON
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getViewPerson() {
        return viewPerson;
    }

    /**
     *  设置: 阅卷人， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.VIEW_PERSON
     *
     * @param viewPerson 阅卷人， ORG_USER表的ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setViewPerson(Long viewPerson) {
        this.viewPerson = viewPerson;
    }

    /**
     * 返回: 阅卷得分<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.VIEW_SCORE
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.VIEW_SCORE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public BigDecimal getViewScore() {
        return viewScore;
    }

    /**
     *  设置: 阅卷得分<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.VIEW_SCORE
     *
     * @param viewScore 阅卷得分
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setViewScore(BigDecimal viewScore) {
        this.viewScore = viewScore;
    }

    /**
     * 返回: 审核人， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_PERSON
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_PERSON
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getApprovePerson() {
        return approvePerson;
    }

    /**
     *  设置: 审核人， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_PERSON
     *
     * @param approvePerson 审核人， ORG_USER表的ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setApprovePerson(Long approvePerson) {
        this.approvePerson = approvePerson;
    }

    /**
     * 返回: 审核人意见<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_IDEAS
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_IDEAS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getApproveIdeas() {
        return approveIdeas;
    }

    /**
     *  设置: 审核人意见<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_IDEAS
     *
     * @param approveIdeas 审核人意见
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setApproveIdeas(String approveIdeas) {
        this.approveIdeas = approveIdeas == null ? null : approveIdeas.trim();
    }

    /**
     * 返回: 复核人， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CHECK_PERSON
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.CHECK_PERSON
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getCheckPerson() {
        return checkPerson;
    }

    /**
     *  设置: 复核人， ORG_USER表的ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CHECK_PERSON
     *
     * @param checkPerson 复核人， ORG_USER表的ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setCheckPerson(Long checkPerson) {
        this.checkPerson = checkPerson;
    }

    /**
     * 返回: 复核人意见<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CHECK_IDEAS
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.CHECK_IDEAS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getCheckIdeas() {
        return checkIdeas;
    }

    /**
     *  设置: 复核人意见<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CHECK_IDEAS
     *
     * @param checkIdeas 复核人意见
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setCheckIdeas(String checkIdeas) {
        this.checkIdeas = checkIdeas == null ? null : checkIdeas.trim();
    }

    /**
     * 返回: 阅卷状态<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.STATUS
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.STATUS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: 阅卷状态<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.STATUS
     *
     * @param status 阅卷状态
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.RECORD_STATUS
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.RECORD_STATUS
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATE_COUNT
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CREATOR_ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.CREATOR_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CREATE_DATE
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.CREATE_DATE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATER_ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATER_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATE_DATE
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATE_DATE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINATION_ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINATION_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getExaminationId() {
        return examinationId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.EXAMINATION_ID
     *
     * @param examinationId null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExaminationId(Long examinationId) {
        this.examinationId = examinationId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.PARENT_ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.PARENT_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getParentId() {
        return parentId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.PARENT_ID
     *
     * @param parentId null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 返回: 动态组卷规则ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.RULE_ID
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.RULE_ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Long getRuleId() {
        return ruleId;
    }

    /**
     *  设置: 动态组卷规则ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.RULE_ID
     *
     * @param ruleId 动态组卷规则ID
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_SCORE
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_SCORE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public BigDecimal getApproveScore() {
        return approveScore;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.APPROVE_SCORE
     *
     * @param approveScore null
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setApproveScore(BigDecimal approveScore) {
        this.approveScore = approveScore;
    }

    /**
     * 返回: 试题类型<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_TYPE
     *
     * @返回  ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_TYPE
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public String getQuestionType() {
        return questionType;
    }

    /**
     *  设置: 试题类型<br>
     * 对应数据库字段: ETRAINING_0508.EXM_EXAMINEE_QUESTION.QUESTION_TYPE
     *
     * @param questionType 试题类型
     *
     * @mbggenerated 2012-05-28 16:57
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Examination getExamination() {
        return examination;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public User getUser() {
        return user;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setUser(User user) {
        this.user = user;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Question getQuestion() {
        return question;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setQuestion(Question question) {
        this.question = question;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public List<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public Paper getPaper() {
        return paper;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-28 16:31")
    public void setPaper(Paper paper) {
        this.paper = paper;
    }
	public Long getTestGroupId() {
		return testGroupId;
	}
	public void setTestGroupId(Long testGroupId) {
		this.testGroupId = testGroupId;
	}
}