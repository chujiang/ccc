package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

public class PlayerButtonTagBean extends BaseUIBean {
	
	final public static String TEMPLATE = "PlayerButton";

	
	// 注册状态
	protected String enrollstatus;
	
	// 是否在有效时间内
	protected String isInValidateDate = "false";
	
//活动id
  protected String acivityId;
  
//课程id
  protected String courseId;
	
	private String stcheader;

	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PlayerButtonTagBean(ValueStack stack, HttpServletRequest request,
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
		addParameter("enrollstatus", this.enrollstatus);
		addParameter("isInValidateDate", this.isInValidateDate);
		addParameter("acivityId", this.acivityId);
		addParameter("courseId", this.courseId);
		addParameter("srcHeader", stcheader);
		addParameter("id", id);
		
	}

  public String getEnrollstatus() {
    return enrollstatus;
  }

  public void setEnrollstatus(String enrollstatus) {
    this.enrollstatus = enrollstatus;
  }

  public String getIsInValidateDate() {
    return isInValidateDate;
  }

  public void setIsInValidateDate(String isInValidateDate) {
    this.isInValidateDate = isInValidateDate;
  }

  public String getAcivityId() {
    return acivityId;
  }

  public void setAcivityId(String acivityId) {
    this.acivityId = acivityId;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }


	
	
}
