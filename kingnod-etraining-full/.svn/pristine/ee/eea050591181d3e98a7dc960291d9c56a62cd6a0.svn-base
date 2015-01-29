package com.kingnod.etraining.activity.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.dao.EnrollExamWorkerDAO;
import com.kingnod.etraining.activity.entity.EnrollExamWorker;
import com.kingnod.etraining.activity.service.EnrollExamWorkerService;
import com.kingnod.etraining.organization.dao.UserDAO;

@org.springframework.stereotype.Service
public class EnrollExamWorkerServiceImpl implements EnrollExamWorkerService {

    @Autowired
    protected EnrollExamWorkerDAO enrollExamWorkerDAO;
    @Autowired
    protected UserDAO userDAO;


    public EnrollExamWorker getEnrollExamWorker(Long id) {
        return enrollExamWorkerDAO.get(id);
    }

    public int saveEnrollExamWorker(EnrollExamWorker enrollExamWorker) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)enrollExamWorker;
        if(null != idEntity.getId() && null != enrollExamWorkerDAO.get(idEntity.getId())){
            count = enrollExamWorkerDAO.update(enrollExamWorker);
        }else{
            count = enrollExamWorkerDAO.insert(enrollExamWorker);
        }
        return count;
    }

    public int deleteEnrollExamWorker(EnrollExamWorker enrollExamWorker) {
        return enrollExamWorkerDAO.delete(enrollExamWorker);
    }

    public int deleteEnrollExamWorkerByIds(Long[] ids) {
        return enrollExamWorkerDAO.deleteById(ids);
    }

    public PagingResult<EnrollExamWorker> findEnrollExamWorker(Criteria criteria) {
        return enrollExamWorkerDAO.findPagingResult(criteria);
    }

    /**
     * 根据考试活动ID获取试题列表信息
     */
    public PagingResult<EnrollExamWorker> findByExaminationId(Criteria criteria) {
    	PagingResult<EnrollExamWorker> pagingResult = enrollExamWorkerDAO.findByExaminationId(criteria);	//考试活动中所有题目列表信息
    	List<EnrollExamWorker> result = pagingResult.getResult();
    	if(ListUtils.isNotEmpty(result)) {	//重组list，设置阅卷员、审核员信息
    		for(EnrollExamWorker worker : result) {
    			
    			CriteriaBuilder cbMarker = Cnd.builder(EnrollExamWorker.class);
    			cbMarker.andEQ("activityId", worker.getExaminationId());
    			cbMarker.andEQ("questionId", worker.getQuestionId());
    			cbMarker.andLike("workType", "M");
    			List<EnrollExamWorker> markerList = enrollExamWorkerDAO.findByCriteria(cbMarker.buildCriteria());	//阅卷员列表
    			String markers = "";	//阅卷人姓名
    			String markerIds = "";	//阅卷人ID
    			for(EnrollExamWorker tmpWorker : markerList) {
    				markers = markers + ", " + userDAO.get(tmpWorker.getUserId()).getFullName();
    				markerIds = markerIds + ", " + tmpWorker.getUserId();
    			}
    			if(StringUtils.isNotEmpty(markers)) {
    				worker.setMarkers(markers.substring(1));
    				worker.setMarkerIds(markerIds.substring(1));
    			}

    			CriteriaBuilder cbAuditor = Cnd.builder(EnrollExamWorker.class);
    			cbAuditor.andEQ("activityId", worker.getExaminationId());
    			cbAuditor.andEQ("questionId", worker.getQuestionId());
    			cbAuditor.andLike("workType", "A");
    			List<EnrollExamWorker> auditorList = enrollExamWorkerDAO.findByCriteria(cbAuditor.buildCriteria());	//审核员列表
    			String auditors = "";	//审核人姓名
    			String auditorIds = "";	//审核人ID
    			for(EnrollExamWorker tmpWorker : auditorList) {
    				auditors = auditors + ", " + userDAO.get(tmpWorker.getUserId()).getFullName();
    				auditorIds = auditorIds + ", " + tmpWorker.getUserId();
    			}
    			if(StringUtils.isNotEmpty(auditors)) {
    				worker.setAuditors(auditors.substring(1));
    				worker.setAuditorIds(auditorIds.substring(1));
    			}
    			
    		}
    	}
        return pagingResult;
    }

	public void saveEnrollExamWorker(Long activityId, String workType, List<Long> userIds, List<Long> questionIds) {
		for (Long questionId : questionIds) {
			Criteria criteria = Cnd.builder(EnrollExamWorker.class).andEQ("activityId", activityId).andLike("workType", workType).andEQ("questionId", questionId).buildCriteria();
			enrollExamWorkerDAO.deleteByCriteria(criteria);
			for (Long userId : userIds) {
				EnrollExamWorker worker = new EnrollExamWorker();
				worker.setActivityId(activityId);
				worker.setUserId(userId);
				worker.setWorkType(workType);
				worker.setQuestionId(questionId);
				enrollExamWorkerDAO.insert(worker);
			}
		}
	}
	
	
	/**
	 * 根据活动ID，获取（监考员、阅卷员、审核员）ID集合
	 */
	public String getIdsByActivityId(String activityId, String workType) {
		String ids = "";
		List<EnrollExamWorker> workers = enrollExamWorkerDAO.findByCriteria(Cnd.builder(EnrollExamWorker.class).andEQ("activityId", activityId).andLike("workType", workType).buildCriteria());
		for(EnrollExamWorker worker : workers) {
			ids += worker.getUserId() + ",";
		}
		if(!StringUtils.isEmpty(ids)) {
			ids = StringUtils.substring(ids, 0, ids.length()-1);
		}
		return ids;
	}

}