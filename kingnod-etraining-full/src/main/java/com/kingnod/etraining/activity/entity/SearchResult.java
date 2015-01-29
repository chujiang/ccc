package com.kingnod.etraining.activity.entity;

import java.util.Date;

import net.sf.json.JSONObject;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ObjectType;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "ACTIVITY_ID"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "NAME"),
  @SelectColumnMapping(property = "desc", type = java.lang.Long.class, table = "CRS_COURSE_INFO", tableAlias = "C", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "grade", type = java.lang.Integer.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "GRADE"), 
  @SelectColumnMapping(property = "releaseDate", type = java.util.Date.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "RELEASE_DATE"), 
  @SelectColumnMapping(property = "courseId", type = java.lang.Long.class, table = "ATY_ELEARNING", tableAlias = "B", column = "COURSE_ID"),
  @SelectColumnMapping(property = "atyTime", type = java.lang.Long.class, table = "ATY_EXAMINATION", tableAlias = "B", column = "ATY_TIME"),
  @SelectColumnMapping(property = "imagePath", type = java.lang.Long.class, table = "CRS_COURSE_INFO", tableAlias = "C", column = "IMP_PATH"), 
  @SelectColumnMapping(property = "enrollMode", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "D", column = "ENROLL_MODE"), 
  @SelectColumnMapping(property = "enrollStatus", type = java.lang.Long.class, table = "ATY_ENROLL_LEARNER", tableAlias = "D", column = "STAUTS"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "allowLogout", type = java.lang.Long.class, table = "ATY_PERIOD", tableAlias = "G", column = "ALLOW_LOGOUT "), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_ACTIVITY", tableAlias = "A", column = "UPDATE_DATE")
})

public class SearchResult{
	
    /**
     * id 活动id
     */
    private Long id;


    /**
     * 名称
     */
    private String name;
    
    
    /**
     * 简介
     */
    private String desc;
    
    /**
     * 类型 在线活动 面授课程
     */
    private String type;
    
    
    /**
     * 活动星级
     */
    private Integer grade;
    
    /**
     * 发布时间
     */
    private Date releaseDate;
    
    
    /**
     * 针对在线学习 课程id
     */
    private Long courseId;
    
    private Long atyTime;
    
    
    /**
     * 线活动注册类型 自愿和强制
     */
    private String enrollMode;
    
    /**
     * 线活动注册类型  针对自愿类型 是否注册
     */
    private String enrollStatus;
    
    
    /**
     * 图片地址
     */
    private String imagePath;
    
    
    /**
     * 图片附件id
     */
    private Long attachmentId;
    
    
    //是否在有效时间内
    private boolean  isInValidateDate;
    
  //是否允许注销
    private String allowLogout;
    
    
    
    
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


    public Long getAttachmentId() {
      return attachmentId;
    }


    public void setAttachmentId(Long attachmentId) {
      this.attachmentId = attachmentId;
    }


    public String getDesc() {
      return desc;
    }


    public void setDesc(String desc) {
      this.desc = desc;
    }


    public String getEnrollMode() {
      return enrollMode;
    }


    public void setEnrollMode(String enrollMode) {
      this.enrollMode = enrollMode;
    }




    public String getEnrollStatus() {
      return enrollStatus;
    }


    public void setEnrollStatus(String enrollStatus) {
      this.enrollStatus = enrollStatus;
    }


    public String getImagePath() {
      return imagePath;
    }


    public void setImagePath(String imagePath) {
      this.imagePath = imagePath;
    }



    
    public Long getId() {
      return id;
    }


    public void setId(Long id) {
      this.id = id;
    }


    public String getName() {
      return name;
    }


    public void setName(String name) {
      this.name = name;
    }


    public String getType() {
      return type;
    }


    public void setType(String type) {
      this.type = type;
    }


    public Integer getGrade() {
      return grade;
    }


    public void setGrade(Integer grade) {
      this.grade = grade;
    }


    public Date getReleaseDate() {
      return releaseDate;
    }


    public void setReleaseDate(Date releaseDate) {
      this.releaseDate = releaseDate;
    }


    public Long getCourseId() {
      return courseId;
    }


    public void setCourseId(Long courseId) {
      this.courseId = courseId;
    }


	public Long getAtyTime() {
		return atyTime;
	}


	public void setAtyTime(Long atyTime) {
		this.atyTime = atyTime;
	}

}