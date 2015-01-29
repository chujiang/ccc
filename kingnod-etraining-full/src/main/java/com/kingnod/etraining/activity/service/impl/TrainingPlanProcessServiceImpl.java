package com.kingnod.etraining.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.TrainingPlanDAO;
import com.kingnod.etraining.activity.dao.TrainingPlanItemDAO;
import com.kingnod.etraining.activity.dao.TrainingPlanProcessDAO;
import com.kingnod.etraining.activity.entity.TrainingPlan;
import com.kingnod.etraining.activity.entity.TrainingPlanItem;
import com.kingnod.etraining.activity.entity.TrainingPlanProcess;
import com.kingnod.etraining.activity.service.TrainingPlanProcessService;

@org.springframework.stereotype.Service
public class TrainingPlanProcessServiceImpl implements
		TrainingPlanProcessService {

	@Autowired
	protected TrainingPlanProcessDAO trainingPlanProcessDAO;

	@Autowired
	protected TrainingPlanItemDAO trainingPlanItemDAO;

	@Autowired
	protected TrainingPlanDAO trainingPlanDAO;

	public TrainingPlanProcess getTrainingPlanProcess(Long id) {
		return trainingPlanProcessDAO.get(id);
	}

	public int saveTrainingPlanProcess(TrainingPlanProcess trainingPlanProcess) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) trainingPlanProcess;
		if (null != idEntity.getId()
				&& null != trainingPlanProcessDAO.get(idEntity.getId())) {
			count = trainingPlanProcessDAO.update(trainingPlanProcess);
		} else {
			count = trainingPlanProcessDAO.insert(trainingPlanProcess);
		}
		return count;
	}

	public int deleteTrainingPlanProcess(TrainingPlanProcess trainingPlanProcess) {
		return trainingPlanProcessDAO.delete(trainingPlanProcess);
	}

	public int deleteTrainingPlanProcessByIds(Long[] ids) {
		return trainingPlanProcessDAO.deleteById(ids);
	}

	public PagingResult<TrainingPlanProcess> findTrainingPlanProcess(
			Criteria criteria) {
		return trainingPlanProcessDAO.findPagingResult(criteria);
	}

	public String initTrainingPlanProcess(Long ids) {
		TrainingPlan trainingPlan = trainingPlanDAO.get(ids);
		if ("N".equals(trainingPlan.getProcessStatus())) {
			CriteriaBuilder processCb = Cnd.builder(TrainingPlanProcess.class);
			processCb.andEQ("trainingPlanId",ids ).andEQ("recordStatus",
					RecordStatus.ACTIVE);
			int i = trainingPlanProcessDAO.countByCriteria(processCb
					.buildCriteria());
			if (i == 0) {
				TrainingPlanProcess trainingPlanProcess = new TrainingPlanProcess();
				List<TrainingPlanItem> itemList = trainingPlanItemDAO.findAll();
				for (TrainingPlanItem trainingPlanItem : itemList) {
					trainingPlanProcess.setTrainingPlanId(trainingPlanItem
							.getTrainingPlanId());
					trainingPlanProcess.setTrainingPlanItemId(trainingPlanItem
							.getId());
					trainingPlanProcess.setName(trainingPlanItem.getName());
					trainingPlanProcess.setObject(trainingPlanItem.getObject());
					trainingPlanProcess.setResponser(trainingPlanItem
							.getResponser());
					trainingPlanProcess.setLearnerNumber(trainingPlanItem
							.getLearnerNumber());
					trainingPlanProcess.setOutline(trainingPlanItem
							.getOutline());
					trainingPlanProcess.setLessons(trainingPlanItem
							.getLessons());
					trainingPlanProcess.setPredictCost(trainingPlanItem
							.getPredictCost());
					trainingPlanProcess.setTime(trainingPlanItem.getTime());
					trainingPlanProcess.setStatus(trainingPlanItem.getStatus());
					trainingPlanProcess.setRemark(trainingPlanItem.getRemark());
					trainingPlanProcess.setType(trainingPlanItem.getType());
					trainingPlanProcessDAO.insert(trainingPlanProcess);
				}
			}
		}
		return null;
	}
}
