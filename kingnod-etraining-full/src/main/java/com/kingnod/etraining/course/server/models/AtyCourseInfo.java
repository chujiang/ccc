package com.kingnod.etraining.course.server.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.kingnod.etraining.activity.entity.ItemInfoPerformance;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.Type;

public class AtyCourseInfo implements Serializable{
 
	private static final long serialVersionUID = 1L;
	protected Long activityId;
	protected Long courseId;
	protected ObjectType type;
	protected String sortName;
	protected String courseName;
	protected String author;
    protected int hour;
    protected int grade;
    protected Long completeNumber;
    protected Long onLineNumber;
    protected String status;
    protected String description;
    protected List<ItemInfoPerformance> items;
    protected int length;
    protected String trainerName;
    protected String courseStatus;
    protected String courseLearnTime;
    protected List<Type> types;
    protected int count;
    protected Long totalTime;
    protected BigDecimal score;
    protected Date completedDate;
    protected String courseImgPath;
    
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Long getCompleteNumber() {
		return completeNumber;
	}
	public void setCompleteNumber(Long completeNumber) {
		this.completeNumber = completeNumber;
	}
	public Long getOnLineNumber() {
		return onLineNumber;
	}
	public void setOnLineNumber(Long onLineNumber) {
		this.onLineNumber = onLineNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<ItemInfoPerformance> getItems() {
		return items;
	}
	public void setItems(List<ItemInfoPerformance> items) {
		this.items = items;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public ObjectType getType() {
		return type;
	}
	public void setType(ObjectType type) {
		this.type = type;
	}
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	public String getCourseLearnTime() {
		return courseLearnTime;
	}
	public void setCourseLearnTime(String courseLearnTime) {
		this.courseLearnTime = courseLearnTime;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public String getCourseImgPath() {
		return courseImgPath;
	}
	public void setCourseImgPath(String courseImgPath) {
		this.courseImgPath = courseImgPath;
	}
    
    
}
