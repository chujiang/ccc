package com.kingnod.etraining.common.ui.tags;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.activity.entity.EvaluationAuthority;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.service.EvaluationService;
import com.kingnod.etraining.common.ui.components.Evaluations;
import com.opensymphony.xwork2.util.ValueStack;

public class EvaluationsTag extends BaseUITag {
	/**
	 * @author PiJingwei
	 */
	private static final long serialVersionUID = -6830609408348768027L;
	
	protected Long activityId; // 活动Id
	protected String activityType; // 活动类型
	protected List<Type> types; // 评论类型
	protected String objectType; // 
	protected String contextPath; // 工程路径
	protected EvaluationAuthority evalAuthority = new EvaluationAuthority();
	protected Type type = new Type();
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new Evaluations(stack, req, res);
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
		EvaluationService evaluationService = SpringUtils.getBean(EvaluationService.class);
		type.setObjectType(objectType);
		types = evaluationService.findEvaluationTypes(type);
		evalAuthority = evaluationService.getEvaluationAuthority(activityId, activityType);
		Evaluations eval = (Evaluations) component;
		eval.setTypes(types);
		eval.setActivityId(activityId);
		eval.setActivityType(activityType);
		eval.setEvaluationAuthority(evalAuthority);
		eval.setContextPath(contextPath);
	}
	
	@Override
	public void release() {
		activityId = null;
		activityType = null;
		super.release();
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

}
