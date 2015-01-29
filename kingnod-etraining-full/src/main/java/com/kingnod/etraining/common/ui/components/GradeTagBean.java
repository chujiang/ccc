package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

public class GradeTagBean extends BaseUIBean {
	
	final public static String TEMPLATE = "Grade";
	
	protected int grade = 0;
	
	private String stcheader;
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GradeTagBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getDefaultTemplate() {
		// TODO Auto-generated method stub
		return TEMPLATE;
	}

	@Override
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		stcheader = request.getContextPath();
		
		String src = (String)this.findValue(this.name);
		addParameter("grade", grade);
		addParameter("srcHeader", stcheader);
		addParameter("id", id);
		
	}

}
