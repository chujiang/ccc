package com.kingnod.etraining.common.ui.components;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.opensymphony.xwork2.util.ValueStack;


@StrutsTag(name = "questions", tldTagClass = "com.kingnod.etraining.common.ui.tags.QuestionsTag", description = "根据传过来的question集合遍历出题目与答案")
public class Questions extends BaseUIBean {

	final public static String TEMPLATE = "questions";
	
	protected List<Question> questions = null;
	
	protected String showAnswer;//是否显示考生答案和正确答案

	protected List<TestGroup> testGroupList = null;
	
	public Questions(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		if(questions != null){
			addParam("quesList", questions);
		}
		if(null != name && !"".equals(name)) {
			addParam("attrName", name);
		} else 
			addParam("attrName", "questionList");
		
		if(testGroupList == null){
			testGroupList = new ArrayList<TestGroup>();
		}
		addParam("testGroupList", testGroupList);
		addParam("showAnswer", showAnswer);
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getShowAnswer() {
		return showAnswer;
	}

	public void setShowAnswer(String showAnswer) {
		this.showAnswer = showAnswer;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public List<TestGroup> getTestGroupList() {
		return testGroupList;
	}

	public void setTestGroupList(List<TestGroup> testGroupList) {
		this.testGroupList = testGroupList;
	}
}
