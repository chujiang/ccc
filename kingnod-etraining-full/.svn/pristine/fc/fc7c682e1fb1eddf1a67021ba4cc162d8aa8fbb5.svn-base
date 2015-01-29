package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.PlayerButtonTagBean;
import com.opensymphony.xwork2.util.ValueStack;

public class PlayerButtonTag extends BaseUITag{

	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	 
  // 注册状态
  protected String enrollstatus="R";
  
  // 是否在有效时间内
  protected String isInValidateDate = "false";
  
//活动id
  protected String acivityId;
  
//课程id
  protected String courseId;
	

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		// TODO Auto-generated method stub
		return new PlayerButtonTagBean(stack, req, res);
	}
	
	protected void populateParams() {
	    super.populateParams();
	    PlayerButtonTagBean file = ((PlayerButtonTagBean) component);
	    file.setKey(key);
	    file.setId(getId());
	    file.setEnrollstatus(getEnrollstatus());
	    file.setIsInValidateDate(getIsInValidateDate());
	    file.setAcivityId(getAcivityId());
	    file.setCourseId(getCourseId());
	}

	public void setKey(String key) {
		this.key = key;
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
