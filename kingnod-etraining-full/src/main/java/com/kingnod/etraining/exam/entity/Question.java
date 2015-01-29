package com.kingnod.etraining.exam.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;

@SelectColumnMappings({
		@SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "EXM_QUESTION", tableAlias = "A", column = "ID"),
		@SelectColumnMapping(property = "folderId", type = java.lang.Long.class, table = "EXM_QUESTION", tableAlias = "A", column = "FOLDER_ID"),
		@SelectColumnMapping(property = "type", type = java.lang.String.class, table = "EXM_QUESTION", tableAlias = "A", column = "TYPE"),
		@SelectColumnMapping(property = "degree", type = java.lang.Short.class, table = "EXM_QUESTION", tableAlias = "A", column = "DEGREE"),
		@SelectColumnMapping(property = "score", type = java.lang.Float.class, table = "EXM_QUESTION", tableAlias = "A", column = "SCORE"),
		@SelectColumnMapping(property = "courseId", type = java.lang.String.class, table = "EXM_QUESTION", tableAlias = "A", column = "COURSE_ID"),
		@SelectColumnMapping(property = "content", type = java.lang.String.class, table = "EXM_QUESTION", tableAlias = "A", column = "CONTENT"),
		@SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "EXM_QUESTION", tableAlias = "A", column = "RECORD_STATUS"),
		@SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "EXM_QUESTION", tableAlias = "A", column = "UPDATE_COUNT"),
		@SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "EXM_QUESTION", tableAlias = "A", column = "CREATOR_ID"),
		@SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "EXM_QUESTION", tableAlias = "A", column = "CREATE_DATE"),
		@SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "EXM_QUESTION", tableAlias = "A", column = "UPDATER_ID"),
		@SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "EXM_QUESTION", tableAlias = "A", column = "UPDATE_DATE"),
		@SelectColumnMapping(property = "knowledgeId", type = java.lang.String.class, table = "EXM_QUESTION", tableAlias = "A", column = "KNOWLEDGE_ID"),
		@SelectColumnMapping(property = "parentId", type = java.lang.Long.class, table = "EXM_QUESTION", tableAlias = "A", column = "PARENT_ID"),
		@SelectColumnMapping(property = "knowledgeName", type = java.lang.String.class, table = "EXM_KNOWLEDGE", tableAlias = "B", column = "NAME"),
		@SelectColumnMapping(property = "courseName", type = java.lang.String.class, table = "CRS_COURSE_INFO", tableAlias = "C", column = "COURSE_TITLE") })
@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
public class Question implements IdEntity<Long>, RecordStatus<Long>, Serializable {
	private static final long serialVersionUID = 7870910964777549555L;
	/**
	 * 自定义
	 */
	private long examPaperId;
	private long testGroupId;
	private String[] questionDegree;
	private String questionFolderId;
	private List<String> examAnswer = new ArrayList<String>(); // 考生答案集
	private List<String> rightAnswer = new ArrayList<String>();
	
	private boolean reviewed;
	private ExamineeQuestion examineeQuestion;
	
	private Integer sequence = 0;//辅助字段,用于给试题排序
	private String scoreStr; // 试题分数  String类型
	private String questionType = "";//辅助字段，标识试题类型，区分无限制类型
	private String examineeAnswer = ""; // 考生答案0
	private String examineeAnswer1 = ""; // 考生答案1
	private String examineeAnswer2 = ""; // 考生答案2
	private String examineeAnswer3 = ""; // 考生答案3
	private String examineeAnswer4 = ""; // 考生答案4
	
	private Integer auswertungNumber = 0;//辅助字段,标识为阅卷数量
	private Integer lockAsuwertungNumber = 0;//辅助字段,标识为锁定阅卷数量
	private boolean updateType = true; // 是否可以修改试题类型
	private boolean updateCourse = true; // 是否可以修改课程
	private boolean updateKnowledge = true; // 是否可以修改知识点
	private String msg; // 辅助字段   设置提示信息
	private List<QuestionKnowledge> knowledgeList; // 试题相关联的知识点
	private List<QuestionKnowledge> courseList; // 试题相关联的课程
	/**
	 * 试题ID<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Long id;

	/**
	 * 资源文件夹ID<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.FOLDER_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Long folderId;

	/**
	 * 试题类型, R：单选题， C：多选题， T：填空题， A：问答题， B: 判断题，Z：组合题，Y：语音题<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.TYPE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private String type;

	/**
	 * 试题难度<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.DEGREE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Short degree;

	/**
	 * 试题分数<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.SCORE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Float score;

	/**
	 * 对应的教材<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.COURSE_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private String courseId;

	/**
	 * 试题内容<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.CONTENT
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private String content;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.RECORD_STATUS
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private String recordStatus;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.UPDATE_COUNT
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Long updateCount;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.CREATOR_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Long creatorId;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.CREATE_DATE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Date createDate;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.UPDATER_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Long updaterId;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.UPDATE_DATE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Date updateDate;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.KNOWLEDGE_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private String knowledgeId;

	/**
	 * 试题的父级ID<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.PARENT_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private Long parentId;

	/**
	 * 知识点名称<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.KNOWLEDGE_NAME
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private String knowledgeName;

	/**
	 * 课程名<br/>
	 * 对应数据库字段 ETRAINING_0426.EXM_QUESTION.COURSE_TITLE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private String courseName;

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private List<Question> childQuestionList = new ArrayList<Question>();

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private List<QuestionKnowledge> questionKnowledges;

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	private List<QuestionAnswer> questionAnswers = new ArrayList<QuestionAnswer>();

	public long getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(long examPaperId) {
		this.examPaperId = examPaperId;
	}

	public long getTestGroupId() {
		return testGroupId;
	}

	public void setTestGroupId(long testGroupId) {
		this.testGroupId = testGroupId;
	}

	public boolean isReviewed() {
		return reviewed;
	}

	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}

	public String[] getQuestionDegree() {
		return questionDegree;
	}

	public void setQuestionDegree(String[] questionDegree) {
		this.questionDegree = questionDegree;
	}

	public String getQuestionFolderId() {
		return questionFolderId;
	}

	public void setQuestionFolderId(String questionFolderId) {
		this.questionFolderId = questionFolderId;
	}

	public List<String> getExamAnswer() {
		return examAnswer;
	}

	public void setExamAnswer(List<String> examAnswer) {
		this.examAnswer = examAnswer;
	}

	public List<String> getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(List<String> rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	/**
	 * 返回: 试题ID<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.ID
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Long getId() {
		return id;
	}

	/**
	 * 设置: 试题ID<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.ID
	 * 
	 * @param id
	 *            试题ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 返回: 资源文件夹ID<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.FOLDER_ID
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.FOLDER_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Long getFolderId() {
		return folderId;
	}

	/**
	 * 设置: 资源文件夹ID<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.FOLDER_ID
	 * 
	 * @param folderId
	 *            资源文件夹ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	/**
	 * 返回: 试题类型, R：单选题， C：多选题， T：填空题， A：问答题， B: 判断题，Z：组合题，Y：语音题<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.TYPE
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.TYPE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public String getType() {
		return type;
	}

	/**
	 * 设置: 试题类型, R：单选题， C：多选题， T：填空题， A：问答题， B: 判断题，Z：组合题，Y：语音题<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.TYPE
	 * 
	 * @param type
	 *            试题类型, R：单选题， C：多选题， T：填空题， A：问答题， B: 判断题，Z：组合题，Y：语音题
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	/**
	 * 返回: 试题难度<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.DEGREE
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.DEGREE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Short getDegree() {
		return degree;
	}

	/**
	 * 设置: 试题难度<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.DEGREE
	 * 
	 * @param degree
	 *            试题难度
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setDegree(Short degree) {
		this.degree = degree;
	}

	/**
	 * 返回: 试题分数<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.SCORE
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.SCORE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Float getScore() {
		return score;
	}

	/**
	 * 设置: 试题分数<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.SCORE
	 * 
	 * @param score
	 *            试题分数
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setScore(Float score) {
		this.score = score;
	}

	/**
	 * 返回: 对应的教材<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.COURSE_ID
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.COURSE_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public String getCourseId() {
		return courseId;
	}

	/**
	 * 设置: 对应的教材<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.COURSE_ID
	 * 
	 * @param courseId
	 *            对应的教材
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setCourseId(String courseId) {
		this.courseId = courseId == null ? null : courseId.trim();
	}

	/**
	 * 返回: 试题内容<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.CONTENT
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.CONTENT
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public String getContent() {
		return content;
	}

	/**
	 * 设置: 试题内容<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.CONTENT
	 * 
	 * @param content
	 *            试题内容
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.RECORD_STATUS
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.RECORD_STATUS
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.RECORD_STATUS
	 * 
	 * @param recordStatus
	 *            null
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus == null ? null : recordStatus.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.UPDATE_COUNT
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.UPDATE_COUNT
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Long getUpdateCount() {
		return updateCount;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.UPDATE_COUNT
	 * 
	 * @param updateCount
	 *            null
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setUpdateCount(Long updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.CREATOR_ID
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.CREATOR_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.CREATOR_ID
	 * 
	 * @param creatorId
	 *            null
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.CREATE_DATE
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.CREATE_DATE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.CREATE_DATE
	 * 
	 * @param createDate
	 *            null
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.UPDATER_ID
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.UPDATER_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Long getUpdaterId() {
		return updaterId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.UPDATER_ID
	 * 
	 * @param updaterId
	 *            null
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setUpdaterId(Long updaterId) {
		this.updaterId = updaterId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.UPDATE_DATE
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.UPDATE_DATE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.UPDATE_DATE
	 * 
	 * @param updateDate
	 *            null
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.KNOWLEDGE_ID
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.KNOWLEDGE_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public String getKnowledgeId() {
		return knowledgeId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.KNOWLEDGE_ID
	 * 
	 * @param knowledgeId
	 *            null
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setKnowledgeId(String knowledgeId) {
		this.knowledgeId = knowledgeId == null ? null : knowledgeId.trim();
	}

	/**
	 * 返回: 试题的父级ID<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.PARENT_ID
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.PARENT_ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置: 试题的父级ID<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.PARENT_ID
	 * 
	 * @param parentId
	 *            试题的父级ID
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 返回: 知识点名称<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.KNOWLEDGE_NAME
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.KNOWLEDGE_NAME
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public String getKnowledgeName() {
		return knowledgeName;
	}

	/**
	 * 设置: 知识点名称<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.KNOWLEDGE_NAME
	 * 
	 * @param knowledgeName
	 *            知识点名称
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setKnowledgeName(String knowledgeName) {
		this.knowledgeName = knowledgeName == null ? null : knowledgeName
				.trim();
	}

	/**
	 * 返回: 课程名<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.COURSE_TITLE
	 * 
	 * @返回 ETRAINING_0426.EXM_QUESTION.COURSE_TITLE
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public String getCourseName() {
		return courseName;
	}

	/**
	 * 设置: 课程名<br>
	 * 对应数据库字段: ETRAINING_0426.EXM_QUESTION.COURSE_TITLE
	 * 
	 * @param courseName
	 *            课程名
	 * 
	 * @mbggenerated 2012-05-05 11:11
	 */

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setCourseName(String courseName) {
		this.courseName = courseName == null ? null : courseName.trim();
	}

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public List<Question> getChildQuestionList() {
		return childQuestionList;
	}

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setChildQuestionList(List<Question> childQuestionList) {
		this.childQuestionList = childQuestionList;
	}

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public List<QuestionKnowledge> getQuestionKnowledges() {
		return questionKnowledges;
	}

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setQuestionKnowledges(List<QuestionKnowledge> questionKnowledges) {
		this.questionKnowledges = questionKnowledges;
	}

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public List<QuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}

	@com.kingnod.core.annotation.Generated("2012-05-05 11:53")
	public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}

	public ExamineeQuestion getExamineeQuestion() {
		return examineeQuestion;
	}

	public void setExamineeQuestion(ExamineeQuestion examineeQuestion) {
		this.examineeQuestion = examineeQuestion;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getScoreStr() {
		return scoreStr;
	}

	public void setScoreStr(String scoreStr) {
		this.scoreStr = scoreStr;
	}

	public String getExamineeAnswer() {
		return examineeAnswer;
	}

	public void setExamineeAnswer(String examineeAnswer) {
		if(null != examineeAnswer) {
			// 将考生答案以 ","进行分割，并setter 到list集合中  
			// 分割的情况只适合  多选题
			String[] corretAnswers = examineeAnswer.split(",");
			for (String answer : corretAnswers) {
				examAnswer.add(answer);
			}
		}
		this.examineeAnswer = examineeAnswer;
	}

	public String getExamineeAnswer1() {
		return examineeAnswer1;
	}

	public void setExamineeAnswer1(String examineeAnswer1) {
		examAnswer.add(examineeAnswer1);
		this.examineeAnswer1 = examineeAnswer1;
	}

	public String getExamineeAnswer2() {
		return examineeAnswer2;
	}

	public void setExamineeAnswer2(String examineeAnswer2) {
		examAnswer.add(examineeAnswer2);
		this.examineeAnswer2 = examineeAnswer2;
	}

	public String getExamineeAnswer3() {
		return examineeAnswer3;
	}

	public void setExamineeAnswer3(String examineeAnswer3) {
		examAnswer.add(examineeAnswer3);
		this.examineeAnswer3 = examineeAnswer3;
	}

	public String getExamineeAnswer4() {
		return examineeAnswer4;
	}

	public void setExamineeAnswer4(String examineeAnswer4) {
		examAnswer.add(examineeAnswer4);
		this.examineeAnswer4 = examineeAnswer4;
	}
	
	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Integer getAuswertungNumber() {
		return auswertungNumber;
	}

	public void setAuswertungNumber(Integer auswertungNumber) {
		this.auswertungNumber = auswertungNumber;
	}

	public Integer getLockAsuwertungNumber() {
		return lockAsuwertungNumber;
	}

	public void setLockAsuwertungNumber(Integer lockAsuwertungNumber) {
		this.lockAsuwertungNumber = lockAsuwertungNumber;
	}

	public boolean isUpdateType() {
		return updateType;
	}

	public void setUpdateType(boolean updateType) {
		this.updateType = updateType;
	}

	public boolean isUpdateCourse() {
		return updateCourse;
	}

	public void setUpdateCourse(boolean updateCourse) {
		this.updateCourse = updateCourse;
	}

	public boolean isUpdateKnowledge() {
		return updateKnowledge;
	}

	public void setUpdateKnowledge(boolean updateKnowledge) {
		this.updateKnowledge = updateKnowledge;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<QuestionKnowledge> getKnowledgeList() {
		return knowledgeList;
	}

	public void setKnowledgeList(List<QuestionKnowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	public List<QuestionKnowledge> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<QuestionKnowledge> courseList) {
		this.courseList = courseList;
	}
}