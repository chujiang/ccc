package com.kingnod.etraining.activity.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.TrainingPlanItemCost;
import com.kingnod.etraining.activity.service.TrainingPlanItemCostService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = {
		"actionName", "training-plan-item-cost", "namespace", "/aty", "trainingPlanItemId", "${trainingPlanItemId}" }) })
@com.kingnod.core.annotation.Generated("2012-02-08 21:54")
public class TrainingPlanItemCostAction extends
		FilterableEntityAction<TrainingPlanItemCost, Long> {

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-08 21:54")
	private TrainingPlanItemCostService trainingPlanItemCostService;
	private Long trainingPlanItemId;
	
	private String folderId;
	
	private String dictType;

	public Long getTrainingPlanItemId() {
		return trainingPlanItemId;
	}

	public void setTrainingPlanItemId(Long trainingPlanItemId) {
		this.trainingPlanItemId = trainingPlanItemId;
	}
	

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	@com.kingnod.core.annotation.Generated("2012-02-08 21:54")
	public String filterDefines() {
		return "aty.trainingPlanItemCostFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-08 21:54")
	protected Object getEntityService() {
		return this.trainingPlanItemCostService;
	}
	
	@Override
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		cb.andEQ("trainingPlanItemId", trainingPlanItemId).andEQ("recordStatus", RecordStatus.ACTIVE);
	}
}