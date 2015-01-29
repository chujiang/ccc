package com.kingnod.etraining.activity.entity;

import java.io.Serializable;
import java.util.Date;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.util.DateUtils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.exam.entity.Paper;

@SelectColumnMappings({
		@SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ID"),
		@SelectColumnMapping(property = "folderId", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "FOLDER_ID"),
		@SelectColumnMapping(property = "atyPaperId", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ATY_PAPER_ID"),
		@SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "NAME"),
		@SelectColumnMapping(property = "openTime", type = java.util.Date.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "OPEN_TIME"),
		@SelectColumnMapping(property = "closeTime", type = java.util.Date.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "CLOSE_TIME"),
		@SelectColumnMapping(property = "scoringType", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "SCORING_TYPE"),
		@SelectColumnMapping(property = "atyTime", type = java.lang.Integer.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ATY_TIME"),
		@SelectColumnMapping(property = "enabledChech", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ENABLED_CHECH"),
		@SelectColumnMapping(property = "answerOrder", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ANSWER_ORDER"),
		@SelectColumnMapping(property = "displayScore", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "DISPLAY_SCORE"),
		@SelectColumnMapping(property = "displayOrder", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "DISPLAY_ORDER"),
		@SelectColumnMapping(property = "answerDisplayOrder", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ANSWER_DISPLAY_ORDER"),
		@SelectColumnMapping(property = "displayAnswer", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "DISPLAY_ANSWER"),
		@SelectColumnMapping(property = "displayObjectiveScore", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "DISPLAY_OBJECTIVE_SCORE"),
		@SelectColumnMapping(property = "displayQuestionNumber", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "DISPLAY_QUESTION_NUMBER"),
		@SelectColumnMapping(property = "enabledCutScreen", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ENABLED_CUT_SCREEN"),
		@SelectColumnMapping(property = "cutScreenTimes", type = java.lang.Short.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "CUT_SCREEN_TIMES"),
		@SelectColumnMapping(property = "atyRestraint", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ATY_RESTRAINT"),
		@SelectColumnMapping(property = "atyRestraintTimes", type = java.lang.Integer.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ATY_RESTRAINT_TIMES"),
		@SelectColumnMapping(property = "reexamTimeInterval", type = java.lang.Integer.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "REEXAM_TIME_INTERVAL"),
		@SelectColumnMapping(property = "reexamTimes", type = java.lang.Integer.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "REEXAM_TIMES"),
		@SelectColumnMapping(property = "requiredAnswerCount", type = java.lang.Integer.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "REQUIRED_ANSWER_COUNT"),
		@SelectColumnMapping(property = "enabledFeedback", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ENABLED_FEEDBACK"),
		@SelectColumnMapping(property = "restrictIp", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "RESTRICT_IP"),
		@SelectColumnMapping(property = "savingIp", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "SAVING_IP"),
		@SelectColumnMapping(property = "warningTime", type = java.lang.Integer.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "WARNING_TIME"),
		@SelectColumnMapping(property = "warningText", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "WARNING_TEXT"),
		@SelectColumnMapping(property = "remarks", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "REMARKS"),
		@SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "RECORD_STATUS"),
		@SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "UPDATE_COUNT"),
		@SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "CREATOR_ID"),
		@SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "CREATE_DATE"),
		@SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "UPDATER_ID"),
		@SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "UPDATE_DATE"),
	    @SelectColumnMapping(property = "publishStatus", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "PUBLISH_STATUS"), 
	    @SelectColumnMapping(property = "advanceTime", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "ADVANCE_TIME"), 
	    @SelectColumnMapping(property = "overdueTime", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "OVERDUE_TIME"), 
	    @SelectColumnMapping(property = "markingCheck", type = java.lang.String.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "MARKING_CHECK"),
	    @SelectColumnMapping(property = "passScore", type = java.lang.Float.class, table = "ATY_EXAMINATION", tableAlias = "A", column = "PASS_SCORE"), 
		@SelectColumnMapping(property = "paperName", type = java.lang.String.class, table = "EXM_EXAM_PAPER", tableAlias = "B", column = "NAME") })
@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
public class Examination implements Activity, IdEntity<Long>, RecordStatus<Long>, Serializable {
	private static final long serialVersionUID = 6825244209034776090L;
	private Integer examSurplusNumber; // 剩余考试次数
	private String status; // 辅助字段，状态 
	private Integer times; // 当前考试次数
	
	//存储yyyy-MM-dd日期格式，
	private String formatDate;
	private String formatTime;
	
	private Integer totalScore = 0;//辅助字段 ，试卷总分数
	private String scoreTypescore = "0";//辅助字段 ，根据计分方式之后取得的考试成绩
	
	//参加考试按钮是否可以点击
	private boolean canExam = false;
	
	private Period periods;
	
	private boolean openStatus = false;//当前考试是否在开放时间内的状态，没到开放时间，参加考试按钮不可用
	
	private Long advanceTime = 0L;
	
	private Long overdueTime = 0L;
	
	private Long paperTotalScore;
	private Integer examedTimes;
	private Float finalScore;
	private String finalScoreStr;
	
	public Long getAdvanceTime() {
		return advanceTime;
	}

	public void setAdvanceTime(Long advanceTime) {
		this.advanceTime = advanceTime;
	}

	public Long getOverdueTime() {
		return overdueTime;
	}

	public void setOverdueTime(Long overdueTime) {
		this.overdueTime = overdueTime;
	}

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Long id;

	/**
	 * 资源文件夹ID<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.FOLDER_ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Long folderId;

	/**
	 * 试卷ID<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ATY_PAPER_ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Long atyPaperId;

	/**
	 * 考试名称<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.NAME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String name;

	/**
	 * 开考时间<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.OPEN_TIME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Date openTime;

	/**
	 * 结束时间<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.CLOSE_TIME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Date closeTime;

	/**
	 * 计分方式， H:最高得分， L：最后得分，A：平均得分<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.SCORING_TYPE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String scoringType;

	/**
	 * 考试时长，单位为分钟<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ATY_TIME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Integer atyTime;

	/**
	 * 是否审核， Y：是， N：否<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ENABLED_CHECH
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String enabledChech;

	/**
	 * 答题次序, N: 正常次序， R：不限制次序<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ANSWER_ORDER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String answerOrder;

	/**
	 * 显示成绩，N：不显示成绩，Y：显示成绩， A：显示所有人成绩<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.DISPLAY_SCORE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String displayScore;

	/**
	 * 试题显示次序，F：固定显示， R：随机显示<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.DISPLAY_ORDER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String displayOrder;

	/**
	 * 答案选项显示次序， F：固定显示， R：随机显示<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ANSWER_DISPLAY_ORDER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String answerDisplayOrder;

	/**
	 * 是否显示答案， Y：是， N：否<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.DISPLAY_ANSWER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String displayAnswer;

	/**
	 * 显示客观题分数， Y：是， N：否<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.DISPLAY_OBJECTIVE_SCORE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String displayObjectiveScore;

	/**
	 * 每页显示题目数量<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.DISPLAY_QUESTION_NUMBER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String displayQuestionNumber;

	/**
	 * 防止切屏， Y：是， N：否<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ENABLED_CUT_SCREEN
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String enabledCutScreen;

	/**
	 * 切屏次数<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.CUT_SCREEN_TIMES
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Short cutScreenTimes;

	/**
	 * 考试限制, N：无，D：每天， W：每周， M：每月<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ATY_RESTRAINT
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String atyRestraint;

	/**
	 * 考试限制次数<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ATY_RESTRAINT_TIMES
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Integer atyRestraintTimes;

	/**
	 * 重考间隔时间， 单位为分钟<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.REEXAM_TIME_INTERVAL
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Integer reexamTimeInterval;

	/**
	 * 重考次数<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.REEXAM_TIMES
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Integer reexamTimes;

	/**
	 * 必答题数<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.REQUIRED_ANSWER_COUNT
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Integer requiredAnswerCount;

	/**
	 * 启用答题反馈， Y：是， N：否<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.ENABLED_FEEDBACK
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String enabledFeedback;

	/**
	 * 是否限制IP， Y：是， N：否<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.RESTRICT_IP
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String restrictIp;

	/**
	 * 是否记录IP， Y：是， N：否<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.SAVING_IP
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String savingIp;

	/**
	 * 结束前时间提醒<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.WARNING_TIME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Integer warningTime;

	/**
	 * 提醒内容<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.WARNING_TEXT
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String warningText;

	/**
	 * 考试说明<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.REMARKS
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String remarks;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.RECORD_STATUS
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String recordStatus;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.UPDATE_COUNT
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Long updateCount;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.CREATOR_ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Long creatorId;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.CREATE_DATE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Date createDate;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.UPDATER_ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Long updaterId;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.UPDATE_DATE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Date updateDate;

    /**
     * 考试发布状态， P：未发布， C: 审核中， R：已发布<br/>
     * 对应数据库字段 ETRAINING_0409.ATY_EXAMINATION.PUBLISH_STATUS
     *
     * @mbggenerated 2012-04-18 16:28
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 16:34")
    private String publishStatus;

    /**
     * 审核阅卷:Y是N否<br/>
     * 对应数据库字段 ETRAINING_0508.ATY_EXAMINATION.MARKING_CHECK
     *
     * @mbggenerated 2012-05-16 17:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-16 17:18")
    private String markingCheck;
    
	/**
	 * 试卷名称<br/>
	 * 对应数据库字段 ETRAINING.ATY_EXAMINATION.NAME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private String paperName;

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	private Paper paper;

    /**
     * 及格分数<br/>
     * 对应数据库字段 ETRAINING_0508.ATY_EXAMINATION.PASS_SCORE
     *
     * @mbggenerated 2012-05-18 10:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 10:24")
    private Float passScore;


	public String getNewStartTime() {
		if (null == openTime)
			return null;
		return DateUtils.format(openTime, "yyyy-MM-dd HH:mm:ss");
	}

	public Long getActivityId() {
		return id;
	}

	public ObjectType getActivityType() {
		return ObjectType.A_XN;
	}

	public Class getActivityClass() {
		return Examination.class;
	}

	public Activity getActivityObject() {
		return this;
	}

	public Integer getExamSurplusNumber() {
		return examSurplusNumber;
	}

	public void setExamSurplusNumber(Integer examSurplusNumber) {
		this.examSurplusNumber = examSurplusNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ID
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Long getId() {
		return id;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ID
	 * 
	 * @param id
	 *            null
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 返回: 资源文件夹ID<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.FOLDER_ID
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.FOLDER_ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Long getFolderId() {
		return folderId;
	}

	/**
	 * 设置: 资源文件夹ID<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.FOLDER_ID
	 * 
	 * @param folderId
	 *            资源文件夹ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	/**
	 * 返回: 试卷ID<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ATY_PAPER_ID
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ATY_PAPER_ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Long getAtyPaperId() {
		return atyPaperId;
	}

	/**
	 * 设置: 试卷ID<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ATY_PAPER_ID
	 * 
	 * @param atyPaperId
	 *            试卷ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setAtyPaperId(Long atyPaperId) {
		this.atyPaperId = atyPaperId;
	}

	/**
	 * 返回: 考试名称<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.NAME
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.NAME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getName() {
		return name;
	}

	/**
	 * 设置: 考试名称<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.NAME
	 * 
	 * @param name
	 *            考试名称
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 返回: 开考时间<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.OPEN_TIME
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.OPEN_TIME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Date getOpenTime() {
		return openTime;
	}

	/**
	 * 设置: 开考时间<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.OPEN_TIME
	 * 
	 * @param openTime
	 *            开考时间
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	/**
	 * 返回: 结束时间<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.CLOSE_TIME
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.CLOSE_TIME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Date getCloseTime() {
		return closeTime;
	}

	/**
	 * 设置: 结束时间<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.CLOSE_TIME
	 * 
	 * @param closeTime
	 *            结束时间
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	/**
	 * 返回: 计分方式， H:最高得分， L：最后得分，A：平均得分<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.SCORING_TYPE
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.SCORING_TYPE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getScoringType() {
		return scoringType;
	}

	/**
	 * 设置: 计分方式， H:最高得分， L：最后得分，A：平均得分<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.SCORING_TYPE
	 * 
	 * @param scoringType
	 *            计分方式， H:最高得分， L：最后得分，A：平均得分
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setScoringType(String scoringType) {
		this.scoringType = scoringType == null ? null : scoringType.trim();
	}

	/**
	 * 返回: 考试时长，单位为分钟<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ATY_TIME
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ATY_TIME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Integer getAtyTime() {
		return atyTime;
	}

	/**
	 * 设置: 考试时长，单位为分钟<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ATY_TIME
	 * 
	 * @param atyTime
	 *            考试时长，单位为分钟
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setAtyTime(Integer atyTime) {
		this.atyTime = atyTime;
	}

	/**
	 * 返回: 是否审核， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ENABLED_CHECH
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ENABLED_CHECH
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getEnabledChech() {
		return enabledChech;
	}

	/**
	 * 设置: 是否审核， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ENABLED_CHECH
	 * 
	 * @param enabledChech
	 *            是否审核， Y：是， N：否
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setEnabledChech(String enabledChech) {
		this.enabledChech = enabledChech == null ? null : enabledChech.trim();
	}

	/**
	 * 返回: 答题次序, N: 正常次序， R：不限制次序<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ANSWER_ORDER
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ANSWER_ORDER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getAnswerOrder() {
		return answerOrder;
	}

	/**
	 * 设置: 答题次序, N: 正常次序， R：不限制次序<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ANSWER_ORDER
	 * 
	 * @param answerOrder
	 *            答题次序, N: 正常次序， R：不限制次序
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setAnswerOrder(String answerOrder) {
		this.answerOrder = answerOrder == null ? null : answerOrder.trim();
	}

	/**
	 * 返回: 显示成绩，N：不显示成绩，Y：显示成绩， A：显示所有人成绩<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_SCORE
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.DISPLAY_SCORE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getDisplayScore() {
		return displayScore;
	}

	/**
	 * 设置: 显示成绩，N：不显示成绩，Y：显示成绩， A：显示所有人成绩<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_SCORE
	 * 
	 * @param displayScore
	 *            显示成绩，N：不显示成绩，Y：显示成绩， A：显示所有人成绩
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setDisplayScore(String displayScore) {
		this.displayScore = displayScore == null ? null : displayScore.trim();
	}

	/**
	 * 返回: 试题显示次序，F：固定显示， R：随机显示<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_ORDER
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.DISPLAY_ORDER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * 设置: 试题显示次序，F：固定显示， R：随机显示<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_ORDER
	 * 
	 * @param displayOrder
	 *            试题显示次序，F：固定显示， R：随机显示
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder == null ? null : displayOrder.trim();
	}

	/**
	 * 返回: 答案选项显示次序， F：固定显示， R：随机显示<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ANSWER_DISPLAY_ORDER
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ANSWER_DISPLAY_ORDER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getAnswerDisplayOrder() {
		return answerDisplayOrder;
	}

	/**
	 * 设置: 答案选项显示次序， F：固定显示， R：随机显示<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ANSWER_DISPLAY_ORDER
	 * 
	 * @param answerDisplayOrder
	 *            答案选项显示次序， F：固定显示， R：随机显示
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setAnswerDisplayOrder(String answerDisplayOrder) {
		this.answerDisplayOrder = answerDisplayOrder == null ? null
				: answerDisplayOrder.trim();
	}

	/**
	 * 返回: 是否显示答案， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_ANSWER
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.DISPLAY_ANSWER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getDisplayAnswer() {
		return displayAnswer;
	}

	/**
	 * 设置: 是否显示答案， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_ANSWER
	 * 
	 * @param displayAnswer
	 *            是否显示答案， Y：是， N：否
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setDisplayAnswer(String displayAnswer) {
		this.displayAnswer = displayAnswer == null ? null : displayAnswer
				.trim();
	}

	/**
	 * 返回: 显示客观题分数， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_OBJECTIVE_SCORE
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.DISPLAY_OBJECTIVE_SCORE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getDisplayObjectiveScore() {
		return displayObjectiveScore;
	}

	/**
	 * 设置: 显示客观题分数， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_OBJECTIVE_SCORE
	 * 
	 * @param displayObjectiveScore
	 *            显示客观题分数， Y：是， N：否
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setDisplayObjectiveScore(String displayObjectiveScore) {
		this.displayObjectiveScore = displayObjectiveScore == null ? null
				: displayObjectiveScore.trim();
	}

	/**
	 * 返回: 每页显示题目数量<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_QUESTION_NUMBER
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.DISPLAY_QUESTION_NUMBER
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getDisplayQuestionNumber() {
		return displayQuestionNumber;
	}

	/**
	 * 设置: 每页显示题目数量<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.DISPLAY_QUESTION_NUMBER
	 * 
	 * @param displayQuestionNumber
	 *            每页显示题目数量
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setDisplayQuestionNumber(String displayQuestionNumber) {
		this.displayQuestionNumber = displayQuestionNumber == null ? null
				: displayQuestionNumber.trim();
	}

	/**
	 * 返回: 防止切屏， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ENABLED_CUT_SCREEN
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ENABLED_CUT_SCREEN
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getEnabledCutScreen() {
		return enabledCutScreen;
	}

	/**
	 * 设置: 防止切屏， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ENABLED_CUT_SCREEN
	 * 
	 * @param enabledCutScreen
	 *            防止切屏， Y：是， N：否
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setEnabledCutScreen(String enabledCutScreen) {
		this.enabledCutScreen = enabledCutScreen == null ? null
				: enabledCutScreen.trim();
	}

	/**
	 * 返回: 切屏次数<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.CUT_SCREEN_TIMES
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.CUT_SCREEN_TIMES
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Short getCutScreenTimes() {
		return cutScreenTimes;
	}

	/**
	 * 设置: 切屏次数<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.CUT_SCREEN_TIMES
	 * 
	 * @param cutScreenTimes
	 *            切屏次数
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setCutScreenTimes(Short cutScreenTimes) {
		this.cutScreenTimes = cutScreenTimes;
	}

	/**
	 * 返回: 考试限制, N：无，D：每天， W：每周， M：每月<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ATY_RESTRAINT
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ATY_RESTRAINT
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getAtyRestraint() {
		return atyRestraint;
	}

	/**
	 * 设置: 考试限制, N：无，D：每天， W：每周， M：每月<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ATY_RESTRAINT
	 * 
	 * @param atyRestraint
	 *            考试限制, N：无，D：每天， W：每周， M：每月
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setAtyRestraint(String atyRestraint) {
		this.atyRestraint = atyRestraint == null ? null : atyRestraint.trim();
	}

	/**
	 * 返回: 考试限制次数<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ATY_RESTRAINT_TIMES
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ATY_RESTRAINT_TIMES
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Integer getAtyRestraintTimes() {
		return atyRestraintTimes;
	}

	/**
	 * 设置: 考试限制次数<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ATY_RESTRAINT_TIMES
	 * 
	 * @param atyRestraintTimes
	 *            考试限制次数
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setAtyRestraintTimes(Integer atyRestraintTimes) {
		this.atyRestraintTimes = atyRestraintTimes;
	}

	/**
	 * 返回: 重考间隔时间， 单位为分钟<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.REEXAM_TIME_INTERVAL
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.REEXAM_TIME_INTERVAL
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Integer getReexamTimeInterval() {
		return reexamTimeInterval;
	}

	/**
	 * 设置: 重考间隔时间， 单位为分钟<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.REEXAM_TIME_INTERVAL
	 * 
	 * @param reexamTimeInterval
	 *            重考间隔时间， 单位为分钟
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setReexamTimeInterval(Integer reexamTimeInterval) {
		this.reexamTimeInterval = reexamTimeInterval;
	}

	/**
	 * 返回: 重考次数<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.REEXAM_TIMES
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.REEXAM_TIMES
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Integer getReexamTimes() {
		return reexamTimes;
	}

	/**
	 * 设置: 重考次数<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.REEXAM_TIMES
	 * 
	 * @param reexamTimes
	 *            重考次数
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setReexamTimes(Integer reexamTimes) {
		this.reexamTimes = reexamTimes;
	}

	/**
	 * 返回: 必答题数<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.REQUIRED_ANSWER_COUNT
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.REQUIRED_ANSWER_COUNT
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Integer getRequiredAnswerCount() {
		return requiredAnswerCount;
	}

	/**
	 * 设置: 必答题数<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.REQUIRED_ANSWER_COUNT
	 * 
	 * @param requiredAnswerCount
	 *            必答题数
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setRequiredAnswerCount(Integer requiredAnswerCount) {
		this.requiredAnswerCount = requiredAnswerCount;
	}

	/**
	 * 返回: 启用答题反馈， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ENABLED_FEEDBACK
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.ENABLED_FEEDBACK
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getEnabledFeedback() {
		return enabledFeedback;
	}

	/**
	 * 设置: 启用答题反馈， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.ENABLED_FEEDBACK
	 * 
	 * @param enabledFeedback
	 *            启用答题反馈， Y：是， N：否
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setEnabledFeedback(String enabledFeedback) {
		this.enabledFeedback = enabledFeedback == null ? null : enabledFeedback
				.trim();
	}

	/**
	 * 返回: 是否限制IP， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.RESTRICT_IP
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.RESTRICT_IP
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getRestrictIp() {
		return restrictIp;
	}

	/**
	 * 设置: 是否限制IP， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.RESTRICT_IP
	 * 
	 * @param restrictIp
	 *            是否限制IP， Y：是， N：否
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setRestrictIp(String restrictIp) {
		this.restrictIp = restrictIp == null ? null : restrictIp.trim();
	}

	/**
	 * 返回: 是否记录IP， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.SAVING_IP
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.SAVING_IP
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getSavingIp() {
		return savingIp;
	}

	/**
	 * 设置: 是否记录IP， Y：是， N：否<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.SAVING_IP
	 * 
	 * @param savingIp
	 *            是否记录IP， Y：是， N：否
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setSavingIp(String savingIp) {
		this.savingIp = savingIp == null ? null : savingIp.trim();
	}

	/**
	 * 返回: 结束前时间提醒<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.WARNING_TIME
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.WARNING_TIME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Integer getWarningTime() {
		return warningTime;
	}

	/**
	 * 设置: 结束前时间提醒<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.WARNING_TIME
	 * 
	 * @param warningTime
	 *            结束前时间提醒
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setWarningTime(Integer warningTime) {
		this.warningTime = warningTime;
	}

	/**
	 * 返回: 提醒内容<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.WARNING_TEXT
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.WARNING_TEXT
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getWarningText() {
		return warningText;
	}

	/**
	 * 设置: 提醒内容<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.WARNING_TEXT
	 * 
	 * @param warningText
	 *            提醒内容
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setWarningText(String warningText) {
		this.warningText = warningText == null ? null : warningText.trim();
	}

	/**
	 * 返回: 考试说明<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.REMARKS
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.REMARKS
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 设置: 考试说明<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.REMARKS
	 * 
	 * @param remarks
	 *            考试说明
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.RECORD_STATUS
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.RECORD_STATUS
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.RECORD_STATUS
	 * 
	 * @param recordStatus
	 *            null
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus == null ? null : recordStatus.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.UPDATE_COUNT
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.UPDATE_COUNT
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Long getUpdateCount() {
		return updateCount;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.UPDATE_COUNT
	 * 
	 * @param updateCount
	 *            null
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setUpdateCount(Long updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.CREATOR_ID
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.CREATOR_ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.CREATOR_ID
	 * 
	 * @param creatorId
	 *            null
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.CREATE_DATE
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.CREATE_DATE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.CREATE_DATE
	 * 
	 * @param createDate
	 *            null
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.UPDATER_ID
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.UPDATER_ID
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Long getUpdaterId() {
		return updaterId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.UPDATER_ID
	 * 
	 * @param updaterId
	 *            null
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setUpdaterId(Long updaterId) {
		this.updaterId = updaterId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.UPDATE_DATE
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.UPDATE_DATE
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.UPDATE_DATE
	 * 
	 * @param updateDate
	 *            null
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

    /**
     * 返回: 考试发布状态， P：未发布， C: 审核中， R：已发布<br>
     * 对应数据库字段: ETRAINING_0409.ATY_EXAMINATION.PUBLISH_STATUS
     *
     * @返回  ETRAINING_0409.ATY_EXAMINATION.PUBLISH_STATUS
     *
     * @mbggenerated 2012-04-18 16:28
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 16:34")
    public String getPublishStatus() {
        return publishStatus;
    }

    /**
     *  设置: 考试发布状态， P：未发布， C: 审核中， R：已发布<br>
     * 对应数据库字段: ETRAINING_0409.ATY_EXAMINATION.PUBLISH_STATUS
     *
     * @param publishStatus 考试发布状态， P：未发布， C: 审核中， R：已发布
     *
     * @mbggenerated 2012-04-18 16:28
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-18 16:34")
    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus == null ? null : publishStatus.trim();
    }
    
    /**
     * 返回: 审核阅卷:Y是N否<br>
     * 对应数据库字段: ETRAINING_0508.ATY_EXAMINATION.MARKING_CHECK
     *
     * @返回  ETRAINING_0508.ATY_EXAMINATION.MARKING_CHECK
     *
     * @mbggenerated 2012-05-16 17:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-16 17:18")
    public String getMarkingCheck() {
        return markingCheck;
    }

    /**
     *  设置: 审核阅卷:Y是N否<br>
     * 对应数据库字段: ETRAINING_0508.ATY_EXAMINATION.MARKING_CHECK
     *
     * @param markingCheck 审核阅卷:Y是N否
     *
     * @mbggenerated 2012-05-16 17:38
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-16 17:18")
    public void setMarkingCheck(String markingCheck) {
        this.markingCheck = markingCheck == null ? null : markingCheck.trim();
    }

	/**
	 * 返回: 试卷名称<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.NAME
	 * 
	 * @返回 ETRAINING.ATY_EXAMINATION.NAME
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String getPaperName() {
		return paperName;
	}

	/**
	 * 设置: 试卷名称<br>
	 * 对应数据库字段: ETRAINING.ATY_EXAMINATION.NAME
	 * 
	 * @param paperName
	 *            试卷名称
	 * 
	 * @mbggenerated 2012-04-10 16:50
	 */

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setPaperName(String paperName) {
		this.paperName = paperName == null ? null : paperName.trim();
	}
	


    /**
     * 返回: 及格分数<br>
     * 对应数据库字段: ETRAINING_0508.ATY_EXAMINATION.PASS_SCORE
     *
     * @返回  ETRAINING_0508.ATY_EXAMINATION.PASS_SCORE
     *
     * @mbggenerated 2012-05-18 10:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 10:24")
    public Float getPassScore() {
        return passScore;
    }

    /**
     *  设置: 及格分数<br>
     * 对应数据库字段: ETRAINING_0508.ATY_EXAMINATION.PASS_SCORE
     *
     * @param passScore 及格分数
     *
     * @mbggenerated 2012-05-18 10:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-18 10:24")
    public void setPassScore(Float passScore) {
        this.passScore = passScore;
    }

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public Paper getPaper() {
		return paper;
	}

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Period getPeriods() {
		return periods;
	}

	public void setPeriods(Period periods) {
		this.periods = periods;
	}

	public boolean isOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(boolean openStatus) {
		this.openStatus = openStatus;
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public String getFormatTime() {
		return formatTime;
	}

	public void setFormatTime(String formatTime) {
		this.formatTime = formatTime;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public boolean getCanExam() {
		return canExam;
	}

	public void setCanExam(boolean canExam) {
		this.canExam = canExam;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public String getScoreTypescore() {
		return scoreTypescore;
	}

	public void setScoreTypescore(String scoreTypescore) {
		this.scoreTypescore = scoreTypescore;
	}

	public Long getPaperTotalScore() {
		return paperTotalScore;
	}

	public void setPaperTotalScore(Long paperTotalScore) {
		this.paperTotalScore = paperTotalScore;
	}

	public Integer getExamedTimes() {
		return examedTimes;
	}

	public void setExamedTimes(Integer examedTimes) {
		this.examedTimes = examedTimes;
	}

	public Float getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(Float finalScore) {
		this.finalScore = finalScore;
	}

	public String getFinalScoreStr() {
		return finalScoreStr;
	}

	public void setFinalScoreStr(String finalScoreStr) {
		this.finalScoreStr = finalScoreStr;
	}
}