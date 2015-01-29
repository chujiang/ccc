package com.kingnod.etraining.report.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import java.math.BigDecimal;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "examId", type = java.lang.Long.class, table = "", tableAlias = "A", column = "EXAM_ID"), 
  @SelectColumnMapping(property = "examName", type = java.lang.String.class, table = "", tableAlias = "A", column = "EXAM_NAME"), 
  @SelectColumnMapping(property = "examType", type = java.lang.String.class, table = "", tableAlias = "A", column = "EXAM_TYPE"), 
  @SelectColumnMapping(property = "userId", type = java.lang.Long.class, table = "", tableAlias = "A", column = "USER_ID"), 
  @SelectColumnMapping(property = "loginName", type = java.lang.String.class, table = "", tableAlias = "A", column = "LOGIN_NAME"), 
  @SelectColumnMapping(property = "fullName", type = java.lang.String.class, table = "", tableAlias = "A", column = "FULL_NAME"), 
  @SelectColumnMapping(property = "orgName", type = java.lang.String.class, table = "", tableAlias = "A", column = "ORG_NAME"), 
  @SelectColumnMapping(property = "userGroup", type = java.lang.String.class, table = "", tableAlias = "A", column = "USER_GROUP"), 
  @SelectColumnMapping(property = "examScore", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "EXAM_SCORE"), 
  @SelectColumnMapping(property = "examStatus", type = java.lang.String.class, table = "", tableAlias = "A", column = "EXAM_STATUS"), 
  @SelectColumnMapping(property = "examTime", type = java.lang.Integer.class, table = "", tableAlias = "A", column = "EXAM_TIME"), 
  @SelectColumnMapping(property = "reexamTimes", type = java.lang.Integer.class, table = "", tableAlias = "A", column = "REEXAM_TIMES"), 
  @SelectColumnMapping(property = "answerTimeLength", type = java.lang.Integer.class, table = "", tableAlias = "A", column = "ANSWER_TIME_LENGTH"), 
  @SelectColumnMapping(property = "finishDate", type = java.util.Date.class, table = "", tableAlias = "A", column = "FINISH_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
public class UserExaminationReport {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ID
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private Long id;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_ID
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private Long examId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_NAME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private String examName;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_TYPE
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private String examType;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.USER_ID
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private Long userId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.LOGIN_NAME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private String loginName;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.FULL_NAME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private String fullName;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ORG_NAME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private String orgName;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.USER_GROUP
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private String userGroup;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_SCORE
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private BigDecimal examScore;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_STATUS
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private String examStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_TIME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private Integer examTime;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.REEXAM_TIMES
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private Integer reexamTimes;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ANSWER_TIME_LENGTH
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private String answerTimeLength;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.FINISH_DATE
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    private Date finishDate;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ID
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ID
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_ID
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_ID
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public Long getExamId() {
        return examId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_ID
     *
     * @param examId null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setExamId(Long examId) {
        this.examId = examId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_NAME
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_NAME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public String getExamName() {
        return examName;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_NAME
     *
     * @param examName null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_TYPE
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_TYPE
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public String getExamType() {
        return examType;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_TYPE
     *
     * @param examType null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setExamType(String examType) {
        this.examType = examType == null ? null : examType.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.USER_ID
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.USER_ID
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public Long getUserId() {
        return userId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.USER_ID
     *
     * @param userId null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.LOGIN_NAME
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.LOGIN_NAME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public String getLoginName() {
        return loginName;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.LOGIN_NAME
     *
     * @param loginName null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.FULL_NAME
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.FULL_NAME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public String getFullName() {
        return fullName;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.FULL_NAME
     *
     * @param fullName null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ORG_NAME
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ORG_NAME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public String getOrgName() {
        return orgName;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ORG_NAME
     *
     * @param orgName null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.USER_GROUP
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.USER_GROUP
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public String getUserGroup() {
        return userGroup;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.USER_GROUP
     *
     * @param userGroup null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup == null ? null : userGroup.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_SCORE
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_SCORE
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public BigDecimal getExamScore() {
        return examScore;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_SCORE
     *
     * @param examScore null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setExamScore(BigDecimal examScore) {
        this.examScore = examScore;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_STATUS
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_STATUS
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public String getExamStatus() {
        return examStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_STATUS
     *
     * @param examStatus null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus == null ? null : examStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_TIME
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_TIME
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public Integer getExamTime() {
        return examTime;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.EXAM_TIME
     *
     * @param examTime null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.REEXAM_TIMES
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.REEXAM_TIMES
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public Integer getReexamTimes() {
        return reexamTimes;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.REEXAM_TIMES
     *
     * @param reexamTimes null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setReexamTimes(Integer reexamTimes) {
        this.reexamTimes = reexamTimes;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ANSWER_TIME_LENGTH
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ANSWER_TIME_LENGTH
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public String getAnswerTimeLength() {
        return answerTimeLength;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.ANSWER_TIME_LENGTH
     *
     * @param answerTimeLength null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setAnswerTimeLength(String answerTimeLength) {
        this.answerTimeLength = answerTimeLength;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.FINISH_DATE
     *
     * @返回  ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.FINISH_DATE
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.RPT_USER_EXAMINATION_REPORT.FINISH_DATE
     *
     * @param finishDate null
     *
     * @mbggenerated 2012-05-22 14:10
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}