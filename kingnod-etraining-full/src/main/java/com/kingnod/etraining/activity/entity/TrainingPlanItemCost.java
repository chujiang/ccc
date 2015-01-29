package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "trainingPlanItemId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "TRAINING_PLAN_ITEM_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "type", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "price", type = java.lang.Float.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "PRICE"), 
  @SelectColumnMapping(property = "amount", type = java.lang.Integer.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "AMOUNT"), 
  @SelectColumnMapping(property = "total", type = java.lang.Float.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "TOTAL"), 
  @SelectColumnMapping(property = "remark", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "REMARK"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ATY_TRAINING_PLAN_ITEM_COST", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "trainingPlanItemName", type = java.lang.String.class, table = "ATY_TRAINING_PLAN_ITEM", tableAlias = "B", column = "NAME")
})

    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
public class TrainingPlanItemCost implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Long id;

    /**
     * 培训计划项目ID， ATY_TRAINING_PLAN_ITEM表的ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TRAINING_PLAN_ITEM_ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Long trainingPlanItemId;

    /**
     * 费用名称<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.NAME
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private String name;

    /**
     * 费用类别, CMN_TYPE的ID<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TYPE
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Long type;

    /**
     * 单价<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.PRICE
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Float price;

    /**
     * 数量<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.AMOUNT
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Integer amount;

    /**
     * 总额<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TOTAL
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Float total;

    /**
     * 备注<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.REMARK
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private String remark;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.RECORD_STATUS
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.CREATOR_ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.CREATE_DATE
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATER_ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATE_DATE
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private Date updateDate;

    /**
     * 培训计划项目<br/>
     * 对应数据库字段 ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.NAME
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    private String trainingPlanItemName;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 培训计划项目ID， ATY_TRAINING_PLAN_ITEM表的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TRAINING_PLAN_ITEM_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TRAINING_PLAN_ITEM_ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Long getTrainingPlanItemId() {
        return trainingPlanItemId;
    }

    /**
     *  设置: 培训计划项目ID， ATY_TRAINING_PLAN_ITEM表的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TRAINING_PLAN_ITEM_ID
     *
     * @param trainingPlanItemId 培训计划项目ID， ATY_TRAINING_PLAN_ITEM表的ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setTrainingPlanItemId(Long trainingPlanItemId) {
        this.trainingPlanItemId = trainingPlanItemId;
    }

    /**
     * 返回: 费用名称<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.NAME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.NAME
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public String getName() {
        return name;
    }

    /**
     *  设置: 费用名称<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.NAME
     *
     * @param name 费用名称
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 费用类别, CMN_TYPE的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TYPE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TYPE
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Long getType() {
        return type;
    }

    /**
     *  设置: 费用类别, CMN_TYPE的ID<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TYPE
     *
     * @param type 费用类别, CMN_TYPE的ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setType(Long type) {
        this.type = type;
    }

    /**
     * 返回: 单价<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.PRICE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.PRICE
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Float getPrice() {
        return price;
    }

    /**
     *  设置: 单价<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.PRICE
     *
     * @param price 单价
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * 返回: 数量<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.AMOUNT
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.AMOUNT
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Integer getAmount() {
        return amount;
    }

    /**
     *  设置: 数量<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.AMOUNT
     *
     * @param amount 数量
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 返回: 总额<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TOTAL
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TOTAL
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Float getTotal() {
        return total;
    }

    /**
     *  设置: 总额<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.TOTAL
     *
     * @param total 总额
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setTotal(Float total) {
        this.total = total;
    }

    /**
     * 返回: 备注<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.REMARK
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.REMARK
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public String getRemark() {
        return remark;
    }

    /**
     *  设置: 备注<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.REMARK
     *
     * @param remark 备注
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.RECORD_STATUS
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.RECORD_STATUS
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATE_COUNT
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATE_COUNT
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.CREATOR_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.CREATOR_ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.CREATE_DATE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.CREATE_DATE
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATER_ID
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATER_ID
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATE_DATE
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATE_DATE
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 培训计划项目<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.NAME
     *
     * @返回  ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.NAME
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public String getTrainingPlanItemName() {
        return trainingPlanItemName;
    }

    /**
     *  设置: 培训计划项目<br>
     * 对应数据库字段: ETRAINING.ATY_TRAINING_PLAN_ITEM_COST.NAME
     *
     * @param trainingPlanItemName 培训计划项目
     *
     * @mbggenerated 2012-02-08 22:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-02-08 22:14")
    public void setTrainingPlanItemName(String trainingPlanItemName) {
        this.trainingPlanItemName = trainingPlanItemName == null ? null : trainingPlanItemName.trim();
    }
}