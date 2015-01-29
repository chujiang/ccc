package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.EnrollButtonTagBean;
import com.kingnod.etraining.common.ui.components.PlayerButtonTagBean;
import com.opensymphony.xwork2.util.ValueStack;

public class EnrollButtonTag extends BaseUITag{

	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	 // 活动id
  protected String acivityId;
  
  // 注册状态
  protected String enrollStatus;
  
  // 注册模式
  protected String enrollMode;
  
  // 是否允许注销
  protected String allowLogout;
	

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		// TODO Auto-generated method stub
		return new EnrollButtonTagBean(stack, req, res);
	}
	
	protected void populateParams() {
	    super.populateParams();
	    EnrollButtonTagBean file = ((EnrollButtonTagBean) component);
	    file.setKey(key);
	    file.setId(getId());
	    file.setEnrollStatus(getEnrollStatus());
	    file.setEnrollMode(getEnrollMode());
	    file.setAcivityId(getAcivityId());
	    file.setAllowLogout(getAllowLogout());
	}

	public void setKey(String key) {
		this.key = key;
	}



  public String getAcivityId() {
    return acivityId;
  }

  public void setAcivityId(String acivityId) {
    this.acivityId = acivityId;
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

  public String getEnrollStatus() {
    return enrollStatus;
  }

  public void setEnrollStatus(String enrollStatus) {
    this.enrollStatus = enrollStatus;
  }


  
	
	
}
