package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "faceTeachingId", type = java.lang.Long.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "FACE_TEACHING_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "title", type = java.lang.String.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "TITLE"), 
  @SelectColumnMapping(property = "outline", type = java.lang.String.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "OUTLINE"), 
  @SelectColumnMapping(property = "trainer", type = java.lang.String.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "TRAINER"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "total", type = java.math.BigDecimal.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "TOTAL"), 
  @SelectColumnMapping(property = "remark", type = java.lang.String.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "REMARK"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_FACE_TEACHING_ITEM", tableAlias = "A", column = "UPDATE_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
public class FaceTeachingItem implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * 面授培训课程ID<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private Long id;

    /**
     * 面授培训ID<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.FACE_TEACHING_ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private Long faceTeachingId;

    /**
     * 名称<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.NAME
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private String name;

    /**
     * 主题<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.TITLE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private String title;

    /**
     * 内容<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.OUTLINE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private String outline;

    /**
     * 讲师<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.TRAINER
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private String trainer;

    /**
     * 培训方式<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.TYPE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private String type;

    /**
     * 总金额<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.TOTAL
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private BigDecimal total;

    /**
     * 备注<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.REMARK
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private String remark;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.RECORD_STATUS
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.CREATOR_ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.CREATE_DATE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATER_ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATE_DATE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private Date updateDate;


    /**
     * 返回: 面授培训课程ID<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.ID
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public Long getId() {
        return id;
    }

    /**
     *  设置: 面授培训课程ID<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.ID
     *
     * @param id 面授培训课程ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 面授培训ID<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.FACE_TEACHING_ID
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.FACE_TEACHING_ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public Long getFaceTeachingId() {
        return faceTeachingId;
    }

    /**
     *  设置: 面授培训ID<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.FACE_TEACHING_ID
     *
     * @param faceTeachingId 面授培训ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setFaceTeachingId(Long faceTeachingId) {
        this.faceTeachingId = faceTeachingId;
    }

    /**
     * 返回: 名称<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.NAME
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.NAME
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public String getName() {
        return name;
    }

    /**
     *  设置: 名称<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.NAME
     *
     * @param name 名称
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 主题<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.TITLE
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.TITLE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public String getTitle() {
        return title;
    }

    /**
     *  设置: 主题<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.TITLE
     *
     * @param title 主题
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 返回: 内容<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.OUTLINE
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.OUTLINE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public String getOutline() {
        return outline;
    }

    /**
     *  设置: 内容<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.OUTLINE
     *
     * @param outline 内容
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    /**
     * 返回: 讲师<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.TRAINER
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.TRAINER
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public String getTrainer() {
        return trainer;
    }

    /**
     *  设置: 讲师<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.TRAINER
     *
     * @param trainer 讲师
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setTrainer(String trainer) {
        this.trainer = trainer == null ? null : trainer.trim();
    }

    /**
     * 返回: 培训方式<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.TYPE
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.TYPE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public String getType() {
        return type;
    }

    /**
     *  设置: 培训方式<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.TYPE
     *
     * @param type 培训方式
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 返回: 总金额<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.TOTAL
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.TOTAL
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public BigDecimal getTotal() {
        return total;
    }

    /**
     *  设置: 总金额<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.TOTAL
     *
     * @param total 总金额
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * 返回: 备注<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.REMARK
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.REMARK
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public String getRemark() {
        return remark;
    }

    /**
     *  设置: 备注<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.REMARK
     *
     * @param remark 备注
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.RECORD_STATUS
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.CREATOR_ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.CREATE_DATE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATER_ID
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATE_DATE
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_FACE_TEACHING_ITEM.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-03 11:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}