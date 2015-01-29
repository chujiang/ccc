
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ui.components.TextField;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Administrator
 */
public class TextFieldTag extends BaseUITag {

  protected String maxlength;
  protected String readonly;
  protected String size;
  protected String testTag;
  protected Object value;
  protected String password;
  private static final long serialVersionUID = -4854923048213359085L;
  
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new TextField(stack, req, res);
  }
  
  protected void populateParams() {
    super.populateParams();
    
    TextField textField = ((TextField) component);
    textField.setMaxlength(maxlength);
    textField.setReadonly(readonly);
    textField.setSize(size);
    textField.setTestTag(testTag);
    textField.setPassword(StringUtils.isTrue(password));
  }

	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
