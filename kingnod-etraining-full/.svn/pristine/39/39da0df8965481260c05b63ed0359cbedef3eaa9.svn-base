package com.kingnod.etraining.common.ui.components;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.etraining.activity.entity.EvaluationAuthority;
import com.kingnod.etraining.common.entity.Type;
import com.opensymphony.xwork2.util.ValueStack;


@StrutsTag(name = "evaluations", tldTagClass = "com.kingnod.etraining.common.ui.tags.EvaluationsTag", description = "评论")
public class Evaluations extends BaseUIBean {
	/**
	 * @author PiJingwei
	 */
	final public static String TEMPLATE = "evaluations";
	
	protected Long activityId; // 活动Id
	protected String activityType; // 活动类型
	protected List<Type> types; // 评论类型
	protected EvaluationAuthority evaluationAuthority;
	protected String contextPath; // 工程路径
	
	public Evaluations(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public EvaluationAuthority getEvaluationAuthority() {
		return evaluationAuthority;
	}

	public void setEvaluationAuthority(EvaluationAuthority evaluationAuthority) {
		this.evaluationAuthority = evaluationAuthority;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
}
