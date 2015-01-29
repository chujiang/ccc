package com.kingnod.etraining.course.entity;

import java.io.Serializable;
import java.util.Date;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "type", type = java.lang.Long.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "grade", type = java.lang.Short.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "GRADE"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "courseId", type = java.lang.Long.class, table = "CRS_COURSE_EVALUATION", tableAlias = "A", column = "COURSE_ID"), 
  @SelectColumnMapping(property = "typeName", type = java.lang.String.class, table = "CMN_TYPE", tableAlias = "B", column = "NAME"),
  @SelectColumnMapping(property = "creatorName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "C", column = "FULL_NAME")
})

    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
public class CourseEvaluation implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * 课程评论ID<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Long id;

    /**
     * 课程评论类型<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.TYPE
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Long type;

    /**
     * 等级<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.GRADE
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Short grade;

    /**
     * 评论内容<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.DESCRIPTION
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private String description;

    /**
     * 评论状态<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.RECORD_STATUS
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private String recordStatus;

    /**
     * 更新次数<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Long updateCount;

    /**
     * 创建人<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.CREATOR_ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Long creatorId;

    /**
     * 创建时间<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.CREATE_DATE
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Date createDate;

    /**
     * 更新人<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATER_ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Long updaterId;

    /**
     * 更新时间<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATE_DATE
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Date updateDate;

    /**
     * 被评论的课程<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.COURSE_ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private Long courseId;

    /**
     * 评论类型<br/>
     * 对应数据库字段 ETRAINING_0409.CRS_COURSE_EVALUATION.NAME
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    private String typeName;

    
    private String creatorName;

    /**
     * 返回: 课程评论ID<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.ID
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Long getId() {
        return id;
    }

    /**
     *  设置: 课程评论ID<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.ID
     *
     * @param id 课程评论ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 课程评论类型<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.TYPE
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.TYPE
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Long getType() {
        return type;
    }

    /**
     *  设置: 课程评论类型<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.TYPE
     *
     * @param type 课程评论类型
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 返回: 等级<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.GRADE
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.GRADE
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Short getGrade() {
        return grade;
    }

    /**
     *  设置: 等级<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.GRADE
     *
     * @param grade 等级
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setGrade(Short grade) {
        this.grade = grade;
    }

    /**
     * 返回: 评论内容<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.DESCRIPTION
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.DESCRIPTION
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 评论内容<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.DESCRIPTION
     *
     * @param description 评论内容
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 评论状态<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.RECORD_STATUS
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.RECORD_STATUS
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: 评论状态<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.RECORD_STATUS
     *
     * @param recordStatus 评论状态
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: 更新次数<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATE_COUNT
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: 更新次数<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATE_COUNT
     *
     * @param updateCount 更新次数
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: 创建人<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.CREATOR_ID
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.CREATOR_ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: 创建人<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.CREATOR_ID
     *
     * @param creatorId 创建人
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: 创建时间<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.CREATE_DATE
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.CREATE_DATE
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: 创建时间<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.CREATE_DATE
     *
     * @param createDate 创建时间
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: 更新人<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATER_ID
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATER_ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: 更新人<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATER_ID
     *
     * @param updaterId 更新人
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: 更新时间<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATE_DATE
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATE_DATE
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: 更新时间<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.UPDATE_DATE
     *
     * @param updateDate 更新时间
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 被评论的课程<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.COURSE_ID
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.COURSE_ID
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public Long getCourseId() {
        return courseId;
    }

    /**
     *  设置: 被评论的课程<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.COURSE_ID
     *
     * @param courseId 被评论的课程
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * 返回: 评论类型<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.NAME
     *
     * @返回  ETRAINING_0409.CRS_COURSE_EVALUATION.NAME
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public String getTypeName() {
        return typeName;
    }

    /**
     *  设置: 评论类型<br>
     * 对应数据库字段: ETRAINING_0409.CRS_COURSE_EVALUATION.NAME
     *
     * @param typeName 评论类型
     *
     * @mbggenerated 2012-04-16 17:15
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-16 17:06")
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
    
    
}