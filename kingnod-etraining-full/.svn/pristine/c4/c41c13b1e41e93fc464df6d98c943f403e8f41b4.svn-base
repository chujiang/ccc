package com.kingnod.etraining.activity.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.etraining.common.ObjectType;

@SelectColumnMappings({
	  @SelectColumnMapping(property = "activityId", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "B", column = "ACTIVITY_ID"), 
	  @SelectColumnMapping(property = "userId", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "USER_ID"), 
	  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "B", column = "NAME"), 
	  @SelectColumnMapping(property = "type", type = com.kingnod.etraining.common.ObjectType.class, table = "ATY_ACTIVITY", tableAlias = "B", column = "TYPE"), 
	  @SelectColumnMapping(property = "releaseDate", type = java.util.Date.class, table = "ATY_ACTIVITY", tableAlias = "B", column = "RELEASE_DATE"), 
 	  @SelectColumnMapping(property = "grade", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "B", column = "GRADE"), 
	  @SelectColumnMapping(property = "completeNumber", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "B", column = "COMPLETE_NUMBER"), 
	  @SelectColumnMapping(property = "onLineNumber", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "B", column = "ONLINE_NUMBER"), 
	  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "ATY_USER_ACTIVITY", tableAlias = "C", column = "STATUS"), 
	  @SelectColumnMapping(property = "progress", type = java.lang.String.class, table = "ATY_USER_ACTIVITY", tableAlias = "C", column = "PROGRESS_RATE"), 
	  @SelectColumnMapping(property = "enrollMode", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "ENROLL_MODE"), 
	  @SelectColumnMapping(property = "enrollStatus", type = java.lang.String.class, table = "ATY_ENROLL_LEARNER", tableAlias = "A", column = "STAUTS"),
	  @SelectColumnMapping(property = "totalTime", type = java.lang.Long.class, table = "ATY_USER_ACTIVITY", tableAlias = "C", column = "TOTAL_TIME"), 
	  @SelectColumnMapping(property = "score", type = java.math.BigDecimal.class, table = "ATY_USER_ACTIVITY", tableAlias = "C", column = "SCORE"),
	  @SelectColumnMapping(property = "allowLogout", type = java.lang.String.class, table = "ATY_ELEARNING", tableAlias = "C", column = "ALLOW_LOGOUT"), 
	  @SelectColumnMapping(property = "completedDate", type = java.util.Date.class, table = "ATY_USER_ACTIVITY", tableAlias = "C", column = "COMPLETED_DATE")
	})
public class UserActivitySummary implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Long activityId;
	protected String name;
	protected ObjectType type;
    protected Date releaseDate;
    protected Long grade;
    protected Long completeNumber;
    protected Long onLineNumber;
    protected String status;
    protected String progress;
    protected Date completeDate;
    protected Activity activityObject;
    protected String enrollStatus;
    protected String enrollMode;
    protected boolean isPlay;
    private Long totalTime;
    private BigDecimal score;
    private Date completedDate;
    
    private String learningTime;
    
    
    private String completedDateStr;
    
    //是否在有效时间内
    private boolean  isInValidateDate;
    
  //是否允许注销
    private String allowLogout;
    
	public String getEnrollStatus() {
      return enrollStatus;
    }
    public void setEnrollStatus(String enrollStatus) {
      this.enrollStatus = enrollStatus;
    }
    public String getEnrollMode() {
      return enrollMode;
    }
    public void setEnrollMode(String enrollMode) {
      this.enrollMode = enrollMode;
    }
  public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ObjectType getType() {
		return type;
	}
	public void setType(ObjectType type) {
		this.type = type;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Long getGrade() {
		return grade;
	}
	public void setGrade(Long grade) {
		this.grade = grade;
	}
	public Long getCompleteNumber() {
		return completeNumber;
	}
	public void setCompleteNumber(Long completeNumber) {
		this.completeNumber = completeNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getOnLineNumber() {
		return onLineNumber;
	}
	public void setOnLineNumber(Long onLineNumber) {
		this.onLineNumber = onLineNumber;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	/**
	 * @return the activityObject
	 */
	public Activity getActivityObject() {
		return activityObject;
	}
	/**
	 * @param activityObject the activityObject to set
	 */
	public void setActivityObject(Activity activityObject) {
		this.activityObject = activityObject;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public boolean isPlay() {
		return isPlay;
	}
	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}
	public Long getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Long totalTime) {
		this.totalTime = totalTime;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public Date getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
  public boolean isInValidateDate() {
    return isInValidateDate;
  }
  public void setInValidateDate(boolean isInValidateDate) {
    this.isInValidateDate = isInValidateDate;
  }
  public String getAllowLogout() {
    return allowLogout;
  }
  public void setAllowLogout(String allowLogout) {
    this.allowLogout = allowLogout;
  }
  
public String getCompletedDateStr() {
    return completedDateStr;
  }
  public void setCompletedDateStr(String completedDateStr) {
    this.completedDateStr = completedDateStr;
  }
public String getLearningTime() {
	return learningTime;
}
public void setLearningTime(String learningTime) {
	this.learningTime = learningTime;
}
    

}
