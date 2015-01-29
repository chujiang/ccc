package com.kingnod.etraining.exam.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "examPaperId", type = java.lang.Long.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "EXAM_PAPER_ID"), 
  @SelectColumnMapping(property = "groupSeq", type = java.lang.Short.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "GROUP_SEQ"), 
  @SelectColumnMapping(property = "questionType", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "QUESTION_TYPE"), 
  @SelectColumnMapping(property = "readingType", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "READING_TYPE"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "score", type = java.lang.Integer.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "SCORE"), 
  @SelectColumnMapping(property = "questionNumber", type = java.lang.Integer.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "QUESTION_NUMBER"), 
  @SelectColumnMapping(property = "generatorPaperPattern", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "GENERATOR_PAPER_PATTERN"), 
  @SelectColumnMapping(property = "extractingQuestionWay", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "EXTRACTING_QUESTION_WAY"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "EXM_TEST_GROUP", tableAlias = "A", column = "DESCRIPTION")
})

    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
	public class TestGroup implements IdEntity<Long>, RecordStatus<Long>, Serializable {
	private static final long serialVersionUID=-6038943790648190292L;
	private String upOrDown;
	private Short newGroupSeq;
	private Double totalScore;
	private String scoreStr;
	private String totalScoreStr;
	@SuppressWarnings("unused") private Double surplusScore;
	private boolean isComplete;
	private List<Question> listQuestion=new ArrayList<Question>();
	private List<ExamineeQuestion> listExamQuestion=new ArrayList<ExamineeQuestion>();
	private Integer alreadyAddQuestionNumber;
	private String content;
	private List<Question> questionList=new ArrayList<Question>();

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Long id;

    /**
     * 测试区名称<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.NAME
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private String name;

    /**
     * 试卷ID<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Long examPaperId;

    /**
     * 测试区顺序<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.GROUP_SEQ
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Short groupSeq;

    /**
     * 试题类型， R:单选题， C：多选题， T：填空题， A：简答题， B: 判断题<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.QUESTION_TYPE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private String questionType;

    /**
     * 阅卷方式<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.READING_TYPE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private String readingType;

    /**
     * 测试区状态， P：未发布， R：已发布<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.STATUS
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private String status;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.RECORD_STATUS
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.UPDATE_COUNT
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.CREATOR_ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.CREATE_DATE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.UPDATER_ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.UPDATE_DATE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Date updateDate;

    /**
     * 分数<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.SCORE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Integer score;

    /**
     * 试题数<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.QUESTION_NUMBER
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private Integer questionNumber;

    /**
     * 组卷方式<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.GENERATOR_PAPER_PATTERN
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private String generatorPaperPattern;

    /**
     * 抽题方式，M：手工抽题， S(static): 静态抽题，D(dynamic): 动态抽题<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.EXTRACTING_QUESTION_WAY
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private String extractingQuestionWay;

    /**
     * 描述<br/>
     * 对应数据库字段 ETRAINING_0508.EXM_TEST_GROUP.DESCRIPTION
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private String description;

    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    private List<QuestionTestGroup> questionTestGroups;

public List<Question> getQuestionList(){
  return questionList;
}
public void setQuestionList(List<Question> questionList){
  this.questionList=questionList;
}
public String getUpOrDown(){
  return upOrDown;
}
public void setUpOrDown(String upOrDown){
  this.upOrDown=upOrDown;
}
public Short getNewGroupSeq(){
  return newGroupSeq;
}
public void setNewGroupSeq(Short newGroupSeq){
  this.newGroupSeq=newGroupSeq;
}
public Double getSurplusScore(){
  return score - totalScore;
}
public void setSurplusScore(Double surplusScore){
  this.surplusScore=surplusScore;
}
public Double getTotalScore(){
  return totalScore;
}
public void setTotalScore(Double totalScore){
  this.totalScore=totalScore;
}
public boolean isComplete(){
  return isComplete;
}
public void setComplete(boolean isComplete){
  this.isComplete=isComplete;
}
public List<Question> getListQuestion(){
  return listQuestion;
}
public void setListQuestion(List<Question> listQuestion){
  this.listQuestion=listQuestion;
}
public List<ExamineeQuestion> getListExamQuestion(){
  return listExamQuestion;
}
public void setListExamQuestion(List<ExamineeQuestion> listExamQuestion){
  this.listExamQuestion=listExamQuestion;
}
public Integer getAlreadyAddQuestionNumber(){
  return alreadyAddQuestionNumber;
}
public void setAlreadyAddQuestionNumber(Integer alreadyAddQuestionNumber){
  this.alreadyAddQuestionNumber=alreadyAddQuestionNumber;
}
public String getContent(){
  return content;
}
public void setContent(String content){
  this.content=content;
}
public String getScoreStr(){
  return scoreStr;
}
public void setScoreStr(String scoreStr){
  this.scoreStr=scoreStr;
}
public String getTotalScoreStr(){
  return totalScoreStr;
}
public void setTotalScoreStr(String totalScoreStr){
  this.totalScoreStr=totalScoreStr;
}

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.ID
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 测试区名称<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.NAME
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.NAME
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public String getName() {
        return name;
    }

    /**
     *  设置: 测试区名称<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.NAME
     *
     * @param name 测试区名称
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 试卷ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.EXAM_PAPER_ID
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.EXAM_PAPER_ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Long getExamPaperId() {
        return examPaperId;
    }

    /**
     *  设置: 试卷ID<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.EXAM_PAPER_ID
     *
     * @param examPaperId 试卷ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setExamPaperId(Long examPaperId) {
        this.examPaperId = examPaperId;
    }

    /**
     * 返回: 测试区顺序<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.GROUP_SEQ
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.GROUP_SEQ
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Short getGroupSeq() {
        return groupSeq;
    }

    /**
     *  设置: 测试区顺序<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.GROUP_SEQ
     *
     * @param groupSeq 测试区顺序
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setGroupSeq(Short groupSeq) {
        this.groupSeq = groupSeq;
    }

    /**
     * 返回: 试题类型， R:单选题， C：多选题， T：填空题， A：简答题， B: 判断题<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.QUESTION_TYPE
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.QUESTION_TYPE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public String getQuestionType() {
        return questionType;
    }

    /**
     *  设置: 试题类型， R:单选题， C：多选题， T：填空题， A：简答题， B: 判断题<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.QUESTION_TYPE
     *
     * @param questionType 试题类型， R:单选题， C：多选题， T：填空题， A：简答题， B: 判断题
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    /**
     * 返回: 阅卷方式<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.READING_TYPE
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.READING_TYPE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public String getReadingType() {
        return readingType;
    }

    /**
     *  设置: 阅卷方式<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.READING_TYPE
     *
     * @param readingType 阅卷方式
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setReadingType(String readingType) {
        this.readingType = readingType == null ? null : readingType.trim();
    }

    /**
     * 返回: 测试区状态， P：未发布， R：已发布<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.STATUS
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.STATUS
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: 测试区状态， P：未发布， R：已发布<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.STATUS
     *
     * @param status 测试区状态， P：未发布， R：已发布
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.RECORD_STATUS
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.RECORD_STATUS
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.UPDATE_COUNT
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.UPDATE_COUNT
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.CREATOR_ID
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.CREATOR_ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.CREATE_DATE
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.CREATE_DATE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.UPDATER_ID
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.UPDATER_ID
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.UPDATE_DATE
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.UPDATE_DATE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 分数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.SCORE
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.SCORE
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Integer getScore() {
        return score;
    }

    /**
     *  设置: 分数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.SCORE
     *
     * @param score 分数
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 返回: 试题数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.QUESTION_NUMBER
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.QUESTION_NUMBER
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public Integer getQuestionNumber() {
        return questionNumber;
    }

    /**
     *  设置: 试题数<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.QUESTION_NUMBER
     *
     * @param questionNumber 试题数
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    /**
     * 返回: 组卷方式<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.GENERATOR_PAPER_PATTERN
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.GENERATOR_PAPER_PATTERN
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public String getGeneratorPaperPattern() {
        return generatorPaperPattern;
    }

    /**
     *  设置: 组卷方式<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.GENERATOR_PAPER_PATTERN
     *
     * @param generatorPaperPattern 组卷方式
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setGeneratorPaperPattern(String generatorPaperPattern) {
        this.generatorPaperPattern = generatorPaperPattern == null ? null : generatorPaperPattern.trim();
    }

    /**
     * 返回: 抽题方式，M：手工抽题， S(static): 静态抽题，D(dynamic): 动态抽题<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.EXTRACTING_QUESTION_WAY
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.EXTRACTING_QUESTION_WAY
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public String getExtractingQuestionWay() {
        return extractingQuestionWay;
    }

    /**
     *  设置: 抽题方式，M：手工抽题， S(static): 静态抽题，D(dynamic): 动态抽题<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.EXTRACTING_QUESTION_WAY
     *
     * @param extractingQuestionWay 抽题方式，M：手工抽题， S(static): 静态抽题，D(dynamic): 动态抽题
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setExtractingQuestionWay(String extractingQuestionWay) {
        this.extractingQuestionWay = extractingQuestionWay == null ? null : extractingQuestionWay.trim();
    }

    /**
     * 返回: 描述<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.DESCRIPTION
     *
     * @返回  ETRAINING_0508.EXM_TEST_GROUP.DESCRIPTION
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 描述<br>
     * 对应数据库字段: ETRAINING_0508.EXM_TEST_GROUP.DESCRIPTION
     *
     * @param description 描述
     *
     * @mbggenerated 2012-06-11 11:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public List<QuestionTestGroup> getQuestionTestGroups() {
        return questionTestGroups;
    }

    
    @com.kingnod.core.annotation.Generated("2012-06-11 11:35")
    public void setQuestionTestGroups(List<QuestionTestGroup> questionTestGroups) {
        this.questionTestGroups = questionTestGroups;
    }
}