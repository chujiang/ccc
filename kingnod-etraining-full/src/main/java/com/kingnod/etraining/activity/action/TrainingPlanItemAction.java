package com.kingnod.etraining.activity.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.TrainingPlan;
import com.kingnod.etraining.activity.entity.TrainingPlanItem;
import com.kingnod.etraining.activity.service.TrainingPlanItemService;
import com.kingnod.etraining.activity.service.TrainingPlanService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = {
		"actionName", "training-plan-item", "namespace", "/aty", "trainingPlanId", "${trainingPlanId}" }) })
@com.kingnod.core.annotation.Generated("2012-02-08 17:20")
public class TrainingPlanItemAction extends
		FilterableEntityAction<TrainingPlanItem, Long> {

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-08 17:20")
	private TrainingPlanItemService trainingPlanItemService;
	
	@Autowired
	private TrainingPlanService trainingPlanService;
	
	private String folderId;
	
	private String dictType;
	
	private Long trainingPlanId;

	public Long getTrainingPlanId() {
		return trainingPlanId;
	}

	public void setTrainingPlanId(Long trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
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

	@com.kingnod.core.annotation.Generated("2012-02-08 17:20")
	public String filterDefines() {
		return "aty.trainingPlanItemFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-08 17:20")
	protected Object getEntityService() {
		return this.trainingPlanItemService;
	}
	
	@Override
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		cb.andEQ("trainingPlanId", trainingPlanId).andEQ("recordStatus", RecordStatus.ACTIVE);
	}

	@Override
	protected void prepareModel() throws Exception {
		super.prepareModel();
		TrainingPlan trainingPlan = trainingPlanService.getTrainingPlan(trainingPlanId);
		entity.setTrainingPlanName(trainingPlan.getName());
	}
}