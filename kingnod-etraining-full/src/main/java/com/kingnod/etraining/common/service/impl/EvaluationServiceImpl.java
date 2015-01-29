package com.kingnod.etraining.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.activity.entity.EvaluationAuthority;
import com.kingnod.etraining.activity.service.EnrollLearnerService;
import com.kingnod.etraining.common.dao.EvaluationDAO;
import com.kingnod.etraining.common.dao.TypeDAO;
import com.kingnod.etraining.common.entity.Evaluation;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.service.EvaluationService;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Service
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	protected EvaluationDAO evaluationDAO;
	@Autowired
	protected TypeDAO typeDAO;
	@Autowired
	protected EnrollLearnerService enrollLearnerService;

	public Evaluation getEvaluation(Long id) {
		return evaluationDAO.get(id);
	}

	public int saveEvaluation(Evaluation evaluation) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) evaluation;
		if (null != idEntity.getId() && null != evaluationDAO.get(idEntity.getId())) {
			count = evaluationDAO.update(evaluation);
		} else {
			count = evaluationDAO.insert(evaluation);
		}
		return count;
	}

	public int deleteEvaluation(Evaluation evaluation) {
		return evaluationDAO.delete(evaluation);
	}

	public int deleteEvaluationByIds(Long[] ids) {
		return evaluationDAO.deleteById(ids);
	}

	public PagingResult<Evaluation> findEvaluation(Criteria criteria) {
		return evaluationDAO.findPagingResult(criteria);
	}

	public List<Type> findEvaluationTypes(Type type) {
		UserAccount userAccount = this.getUserAccount();
		CriteriaBuilder typeBuilder = Cnd.builder(Type.class);
		//Criteria criteria = typeBuilder.andEQ("parentId", CourseConstant.EVALUATION_TYPE_PARENT).buildCriteria();
		Criteria criteria = typeBuilder.andEQ("objectType", type.getObjectType()).andEQ("root", false).buildCriteria();
		criteria.addParam("visibleInherited", true).addParam("siteId", userAccount.getSiteId());
		return typeDAO.findPagingResult(criteria).getResult();
	}
	
	/**
	 * 判断是强制还是自愿，还是审批。
	 *in参数 activityId 活动id  
 	 *in参数 userId 用户id
	 *in参数 f注册类型
	 *out参数 isObligatory 是否是相应的注册类型
	 *out参数 isStatus 是否已注册
	 * return boolean
	 */
	public EvaluationAuthority getEvaluationAuthority(Long activityId, String activityType) {
		UserAccount userAccount = this.getUserAccount();
		EnrollLearner enrollLearner = null;
		CriteriaBuilder builder = Cnd.builder(EnrollLearner.class);
		builder.andEQ("activityId", activityId).andEQ("activityType", activityType).andEQ("userId", userAccount.getId() == null ? -1L : userAccount.getId());
		List<EnrollLearner> findEnrollLearner = enrollLearnerService.findEnrollLearner(builder.buildCriteria()).getResult();
		if(!ListUtils.isEmpty(findEnrollLearner)) {
			enrollLearner = findEnrollLearner.get(0);
		}
		EvaluationAuthority evalAuthority = new EvaluationAuthority();
		if(null != enrollLearner){
		      evalAuthority.setLook(true);
		      evalAuthority.setObligatory(enrollLearner.getEnrollMode().equals(ActivityConstant.ENROLL_MOLEL_F));
		      evalAuthority.setStatus(enrollLearner.getStauts().equals(ActivityConstant.ENROLL_STATUS_R));
		}
		return evalAuthority;
	}
	
	// 处理 得到userId
	protected UserAccount getUserAccount() {
		return (UserAccount)SecurityUtils.getCurrentUser();
	}

	public List<Evaluation> getEvaluations(Long activityId, Pager<Evaluation> pager) {
		CriteriaBuilder ceBuilder = Cnd.builder(Evaluation.class);
		ceBuilder.andEQ("activityId", activityId).orderBy("id", Order.DESC);
		pager.setTotalCount(findEvaluation(ceBuilder.buildCriteria()).getResult().size());
		Criteria criteria = ceBuilder.buildCriteria().limit(new Long(pager.getFirst()),new Long(pager.getLast()));
		return findEvaluation(criteria).getResult();
	}
}