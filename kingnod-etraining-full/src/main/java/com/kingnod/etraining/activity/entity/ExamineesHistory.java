package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.etraining.exam.entity.Paper;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.xwork.StringUtils;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "userId", type = java.lang.Long.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "USER_ID"), 
  @SelectColumnMapping(property = "atyPaperId", type = java.lang.Long.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "ATY_PAPER_ID"), 
  @SelectColumnMapping(property = "examinationId", type = java.lang.Long.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "EXAMINATION_ID"), 
  @SelectColumnMapping(property = "generated", type = java.lang.Boolean.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "GENERATED"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "auswertungStatus", type = java.lang.String.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "AUSWERTUNG_STATUS"), 
  @SelectColumnMapping(property = "startTime", type = java.util.Date.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "START_TIME"), 
  @SelectColumnMapping(property = "endTime", type = java.util.Date.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "END_TIME"), 
  @SelectColumnMapping(property = "answerTimeLength", type = java.lang.Double.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "ANSWER_TIME_LENGTH"), 
  @SelectColumnMapping(property = "surplusTime", type = java.lang.Integer.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "SURPLUS_TIME"), 
  @SelectColumnMapping(property = "times", type = java.lang.Integer.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "TIMES"), 
  @SelectColumnMapping(property = "score", type = java.lang.Float.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "SCORE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "totalscore", type = java.lang.Float.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "TOTALSCORE"),
  @SelectColumnMapping(property = "deliveryExamType", type = java.lang.String.class, table = "ATY_EXAMINEES_HISTORY", tableAlias = "A", column = "DELIVERY_EXAM_TYPE"),
  @SelectColumnMapping(property = "fullName", type = java.lang.String.class, table = "", tableAlias = "", column = "fullName"),
  @SelectColumnMapping(property = "loginName", type = java.lang.String.class, table = "", tableAlias = "", column = "loginName"),
  @SelectColumnMapping(property = "paperTotalScore", type = java.lang.String.class, table = "", tableAlias = "", column = "paperTotalScore"),
  @SelectColumnMapping(property = "totalScoreStr", type = java.lang.String.class, table = "", tableAlias = "", column = "finalScore"),
  @SelectColumnMapping(property = "examTime", type = java.lang.String.class, table = "", tableAlias = "", column = "examTime")
})

    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
public class ExamineesHistory implements IdEntity<Long>, RecordStatus<Long>, Serializable {
	private static final long serialVersionUID=6244871275614526915L;
	private String type;
	private String examDate;
	private String examTime;			//第N次考试
	private String totalScoreStr=StringUtils.EMPTY;
	
    private String examName;			//考试活动名称
    private String reexamTimes;			//允许考试总次数
    private String paperName;			//试卷名称
    private String fullName;			//学员姓名
    private String loginName;			//学员帐号
    private String paperTotalScore;		//试卷总分
    private String totalScore;			//试卷总分
    private String scoringType;			//计分方式
    private Float maxScore;				//最高得分
    private Float avgScore;				//平均得分
    private Float lastScort;			//最后一次考试得分
    private Float finalScore;			//根据计分方式，最终得分
    
    private Integer auswertungQues;//辅助字段，存储当前考试记录可阅卷的题数
    private String historyStatus = "Y";//辅助字段，存储当前考试记录状态：阅卷(Y)或审核(S)
    private String answerTimeLengthStr = "0";////辅助字段，考试时长
    
	/**
	 * 交卷方式
	 */
	private String deliveryExamType;
	
	/**
	 * 阅卷状态：I -未阅卷，A-阅卷中，S-阅卷完成，默认为I
	 */
	private String auswertungStatus;
	
    public String getAuswertungStatus() {
		return auswertungStatus;
	}
	public void setAuswertungStatus(String auswertungStatus) {
		this.auswertungStatus = auswertungStatus;
	}
	public Integer getAuswertungQues() {
		return auswertungQues;
	}
	public void setAuswertungQues(Integer auswertungQues) {
		this.auswertungQues = auswertungQues;
	}
	/**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Long id;

    /**
     * 考生ID<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.USER_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Long userId;

    /**
     * 试卷ID<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.ATY_PAPER_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Long atyPaperId;

    /**
     * 考试ID<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.EXAMINATION_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Long examinationId;

    /**
     * 是否已经生成试卷<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.GENERATED
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Boolean generated;

    /**
     * 状态，S：考试中，E：考试结束，N：还未开始考试，A：阅卷中，R：阅卷完成<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.STATUS
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private String status;

    /**
     * 考试开始时间<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.START_TIME
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Date startTime;

    /**
     * 考试结束时间<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.END_TIME
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Date endTime;

    /**
     * 答题时长<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.ANSWER_TIME_LENGTH
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Double answerTimeLength;

    /**
     * 考试剩余时间，单位为：毫秒<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.SURPLUS_TIME
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Integer surplusTime;

    /**
     * 考试次数<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.TIMES
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Integer times;

    /**
     * 自动阅卷分数<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.SCORE
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Float score;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.RECORD_STATUS
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.CREATOR_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.CREATE_DATE
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATER_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATE_DATE
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Date updateDate;

    /**
     * 考试总分数<br/>
     * 对应数据库字段 ETRAINING_0426.ATY_EXAMINEES_HISTORY.TOTALSCORE
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Float totalscore;

    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Examination examination;

    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    private Paper paper;

	public String getTotalScoreStr(){
	  return totalScoreStr;
	}
	public void setTotalScoreStr(String totalScoreStr){
	  this.totalScoreStr=totalScoreStr;
	}
	public String getExamDate(){
	  return examDate;
	}
	public void setExamDate(String examDate){
	  this.examDate=examDate;
	}
	public String getExamTime(){
	  return examTime;
	}
	public void setExamTime(String examTime){
	  this.examTime=examTime;
	}
	public String getType(){
	  return type;
	}
	public void setType(String type){
	  this.type=type;
	}

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.ID
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 考生ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.USER_ID
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.USER_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Long getUserId() {
        return userId;
    }

    /**
     *  设置: 考生ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.USER_ID
     *
     * @param userId 考生ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 返回: 试卷ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.ATY_PAPER_ID
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.ATY_PAPER_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Long getAtyPaperId() {
        return atyPaperId;
    }

    /**
     *  设置: 试卷ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.ATY_PAPER_ID
     *
     * @param atyPaperId 试卷ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setAtyPaperId(Long atyPaperId) {
        this.atyPaperId = atyPaperId;
    }

    /**
     * 返回: 考试ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.EXAMINATION_ID
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.EXAMINATION_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Long getExaminationId() {
        return examinationId;
    }

    /**
     *  设置: 考试ID<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.EXAMINATION_ID
     *
     * @param examinationId 考试ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setExaminationId(Long examinationId) {
        this.examinationId = examinationId;
    }

    /**
     * 返回: 是否已经生成试卷<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.GENERATED
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.GENERATED
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Boolean getGenerated() {
        return generated;
    }

    /**
     *  设置: 是否已经生成试卷<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.GENERATED
     *
     * @param generated 是否已经生成试卷
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setGenerated(Boolean generated) {
        this.generated = generated;
    }

    /**
     * 返回: 状态，S：考试中，E：考试结束，N：还未开始考试，A：阅卷中，R：阅卷完成<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.STATUS
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.STATUS
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: 状态，S：考试中，E：考试结束，N：还未开始考试，A：阅卷中，R：阅卷完成<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.STATUS
     *
     * @param status 状态，S：考试中，E：考试结束，N：还未开始考试，A：阅卷中，R：阅卷完成
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: 考试开始时间<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.START_TIME
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.START_TIME
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Date getStartTime() {
        return startTime;
    }

    /**
     *  设置: 考试开始时间<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.START_TIME
     *
     * @param startTime 考试开始时间
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 返回: 考试结束时间<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.END_TIME
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.END_TIME
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Date getEndTime() {
        return endTime;
    }

    /**
     *  设置: 考试结束时间<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.END_TIME
     *
     * @param endTime 考试结束时间
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 返回: 答题时长<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.ANSWER_TIME_LENGTH
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.ANSWER_TIME_LENGTH
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Double getAnswerTimeLength() {
        return answerTimeLength;
    }

    /**
     *  设置: 答题时长<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.ANSWER_TIME_LENGTH
     *
     * @param answerTimeLength 答题时长
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setAnswerTimeLength(Double answerTimeLength) {
        this.answerTimeLength = answerTimeLength;
    }

    /**
     * 返回: 考试剩余时间，单位为：毫秒<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.SURPLUS_TIME
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.SURPLUS_TIME
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Integer getSurplusTime() {
        return surplusTime;
    }

    /**
     *  设置: 考试剩余时间，单位为：毫秒<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.SURPLUS_TIME
     *
     * @param surplusTime 考试剩余时间，单位为：毫秒
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setSurplusTime(Integer surplusTime) {
        this.surplusTime = surplusTime;
    }

    /**
     * 返回: 考试次数<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.TIMES
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.TIMES
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Integer getTimes() {
        return times;
    }

    /**
     *  设置: 考试次数<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.TIMES
     *
     * @param times 考试次数
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setTimes(Integer times) {
        this.times = times;
    }

    /**
     * 返回: 自动阅卷分数<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.SCORE
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.SCORE
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Float getScore() {
        return score;
    }

    /**
     *  设置: 自动阅卷分数<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.SCORE
     *
     * @param score 自动阅卷分数
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.RECORD_STATUS
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.RECORD_STATUS
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATE_COUNT
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.CREATOR_ID
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.CREATOR_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.CREATE_DATE
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.CREATE_DATE
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATER_ID
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATER_ID
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATE_DATE
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATE_DATE
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 考试总分数<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.TOTALSCORE
     *
     * @返回  ETRAINING_0426.ATY_EXAMINEES_HISTORY.TOTALSCORE
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Float getTotalscore() {
        return totalscore;
    }

    /**
     *  设置: 考试总分数<br>
     * 对应数据库字段: ETRAINING_0426.ATY_EXAMINEES_HISTORY.TOTALSCORE
     *
     * @param totalscore 考试总分数
     *
     * @mbggenerated 2012-05-05 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setTotalscore(Float totalscore) {
        this.totalscore = totalscore;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Examination getExamination() {
        return examination;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public Paper getPaper() {
        return paper;
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-05 18:06")
    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    
	public String getFullName() {
		return fullName;
	}
	
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getDeliveryExamType() {
		return deliveryExamType;
	}

	public void setDeliveryExamType(String deliveryExamType) {
		this.deliveryExamType = deliveryExamType;
	}

	public String getHistoryStatus() {
		return historyStatus;
	}

	public void setHistoryStatus(String historyStatus) {
		this.historyStatus = historyStatus;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getPaperTotalScore() {
		return paperTotalScore;
	}

	public void setPaperTotalScore(String paperTotalScore) {
		this.paperTotalScore = paperTotalScore;
	}

	public String getScoringType() {
		return scoringType;
	}

	public void setScoringType(String scoringType) {
		this.scoringType = scoringType;
	}

	public String getReexamTimes() {
		return reexamTimes;
	}

	public void setReexamTimes(String reexamTimes) {
		this.reexamTimes = reexamTimes;
	}

	public Float getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Float maxScore) {
		this.maxScore = maxScore;
	}

	public Float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(Float avgScore) {
		this.avgScore = avgScore;
	}

	public Float getLastScort() {
		return lastScort;
	}

	public void setLastScort(Float lastScort) {
		this.lastScort = lastScort;
	}

	public Float getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(Float finalScore) {
		this.finalScore = finalScore;
	}
	
	public String getAnswerTimeLengthStr() {
		return answerTimeLengthStr;
	}
	
	public void setAnswerTimeLengthStr(String answerTimeLengthStr) {
		this.answerTimeLengthStr = answerTimeLengthStr;
	}
}