package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

public class EnrollButtonTagBean extends BaseUIBean {
	
	final public static String TEMPLATE = "EnrollButton";

	
  // 活动id
  protected String acivityId;
  
  // 注册状态
  protected String enrollStatus;
  
  // 注册模式
  protected String enrollMode;
  
  // 是否允许注销
  protected String allowLogout;


  private String stcheader;

  
	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnrollButtonTagBean(ValueStack stack, HttpServletRequest request,
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
		addParameter("enrollStatus", this.enrollStatus);
		addParameter("enrollMode", this.enrollMode);
		addParameter("acivityId", this.acivityId);
		addParameter("allowLogout", this.allowLogout);
		addParameter("srcHeader", stcheader);
		addParameter("id", id);
		
	}

  public String getAcivityId() {
    return acivityId;
  }

  public void setAcivityId(String acivityId) {
    this.acivityId = acivityId;
  }



  public String getEnrollStatus() {
    return enrollStatus;
  }

  public void setEnrollStatus(String enrollStatus) {
    this.enrollStatus = enrollStatus;
  }

  public String getEnrollMode() {
    return enrollMode;
  }

  public void setEnrollMode(String enrollMode) {
    this.enrollMode = enrollMode;
  }

  public String getAllowLogout() {
    return allowLogout;
  }

  public void setAllowLogout(String allowLogout) {
    this.allowLogout = allowLogout;
  }

  

	
	
}
