
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.TextField;
import com.kingnod.etraining.common.ui.components.UserPicker;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Administrator
 */
public class UserPickerTag extends BaseUITag {

  protected String maxlength;
  protected String readonly;
  protected String size;
  protected String testTag;
  private static final long serialVersionUID = -4854923048213359085L;
  
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new UserPicker(stack, req, res);
  }
  
  protected void populateParams() {
    super.populateParams();
    
    UserPicker userPicker = ((UserPicker) component);
    userPicker.setMaxlength(maxlength);
    userPicker.setReadonly("true");
    userPicker.setSize(size);
    userPicker.setTestTag(testTag);
  }

	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTestTag() {
		return testTag;
	}

	public void setTestTag(String testTag) {
		this.testTag = testTag;
	}
    
}
