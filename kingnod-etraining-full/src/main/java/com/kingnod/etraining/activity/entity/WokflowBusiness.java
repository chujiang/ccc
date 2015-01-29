package com.kingnod.etraining.activity.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ATY_WOKFLOW_BUSINESS", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "workflowId", type = java.lang.String.class, table = "ATY_WOKFLOW_BUSINESS", tableAlias = "A", column = "WORKFLOW_ID"), 
  @SelectColumnMapping(property = "businessType", type = java.lang.String.class, table = "ATY_WOKFLOW_BUSINESS", tableAlias = "A", column = "BUSINESS_TYPE"), 
  @SelectColumnMapping(property = "businessId", type = java.lang.String.class, table = "ATY_WOKFLOW_BUSINESS", tableAlias = "A", column = "BUSINESS_ID")
})

    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
public class WokflowBusiness {

    /**
     * ID<br/>
     * 对应数据库字段 ETRAINING.ATY_WOKFLOW_BUSINESS.ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    private Long id;

    /**
     * 流程实例ID<br/>
     * 对应数据库字段 ETRAINING.ATY_WOKFLOW_BUSINESS.WORKFLOW_ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    private String workflowId;

    /**
     * 业务类型 如：培训计划等<br/>
     * 对应数据库字段 ETRAINING.ATY_WOKFLOW_BUSINESS.BUSINESS_TYPE
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    private String businessType;

    /**
     * 业务ID<br/>
     * 对应数据库字段 ETRAINING.ATY_WOKFLOW_BUSINESS.BUSINESS_ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    private String businessId;


    /**
     * 返回: ID<br>
     * 对应数据库字段: ETRAINING.ATY_WOKFLOW_BUSINESS.ID
     *
     * @返回  ETRAINING.ATY_WOKFLOW_BUSINESS.ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public Long getId() {
        return id;
    }

    /**
     *  设置: ID<br>
     * 对应数据库字段: ETRAINING.ATY_WOKFLOW_BUSINESS.ID
     *
     * @param id ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 流程实例ID<br>
     * 对应数据库字段: ETRAINING.ATY_WOKFLOW_BUSINESS.WORKFLOW_ID
     *
     * @返回  ETRAINING.ATY_WOKFLOW_BUSINESS.WORKFLOW_ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public String getWorkflowId() {
        return workflowId;
    }

    /**
     *  设置: 流程实例ID<br>
     * 对应数据库字段: ETRAINING.ATY_WOKFLOW_BUSINESS.WORKFLOW_ID
     *
     * @param workflowId 流程实例ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId == null ? null : workflowId.trim();
    }

    /**
     * 返回: 业务类型 如：培训计划等<br>
     * 对应数据库字段: ETRAINING.ATY_WOKFLOW_BUSINESS.BUSINESS_TYPE
     *
     * @返回  ETRAINING.ATY_WOKFLOW_BUSINESS.BUSINESS_TYPE
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public String getBusinessType() {
        return businessType;
    }

    /**
     *  设置: 业务类型 如：培训计划等<br>
     * 对应数据库字段: ETRAINING.ATY_WOKFLOW_BUSINESS.BUSINESS_TYPE
     *
     * @param businessType 业务类型 如：培训计划等
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * 返回: 业务ID<br>
     * 对应数据库字段: ETRAINING.ATY_WOKFLOW_BUSINESS.BUSINESS_ID
     *
     * @返回  ETRAINING.ATY_WOKFLOW_BUSINESS.BUSINESS_ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public String getBusinessId() {
        return businessId;
    }

    /**
     *  设置: 业务ID<br>
     * 对应数据库字段: ETRAINING.ATY_WOKFLOW_BUSINESS.BUSINESS_ID
     *
     * @param businessId 业务ID
     *
     * @mbggenerated 2012-03-06 18:03
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }
}