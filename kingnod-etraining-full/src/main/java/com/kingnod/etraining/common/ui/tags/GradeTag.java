package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.GradeTagBean;
import com.opensymphony.xwork2.util.ValueStack;

public class GradeTag extends BaseUITag{

	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	protected int grade;
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		// TODO Auto-generated method stub
		return new GradeTagBean(stack, req, res);
	}
	
	protected void populateParams() {
	    super.populateParams();
	    GradeTagBean file = ((GradeTagBean) component);
	    file.setKey(key);
	    file.setId(getId());
	    file.setGrade(getGrade());
	}

	public void setKey(String key) {
		this.key = key;
	}

}
