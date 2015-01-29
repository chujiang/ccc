package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.util.SysParameterUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class TextField extends BaseUIBean {
	/**
   * The name of the default template for the TextFieldTag
   */
  final public static String TEMPLATE = "text";
  String openTemplate;


  protected String maxlength;
  protected String readonly;
  protected String size;
  protected String testTag;
  protected boolean password;

  public TextField(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
      super(stack, request, response);
  }

  protected String getDefaultTemplate() {
      return TEMPLATE;
  }

  public void evaluateExtraParams() {
    super.evaluateExtraParams();
    if (size != null) {
        addParameter("size", findString(size));
    }else{
    	int paramSize = SysParameterUtils.getInteger("sys.component_default_size");
    	addParameter("size", paramSize>0?String.valueOf(paramSize):"30");
    }
    if (maxlength != null) {
        addParameter("maxlength", findString(maxlength));
    }
    if (readonly != null) {
        addParameter("readonly", findValue(readonly, Boolean.class));
    }
    if (testTag != null) {
    	addParameter("length", findValue(testTag, Boolean.class));
    }
    addParam("password",password);
  }

  public void setMaxlength(String maxlength) {
    this.maxlength = maxlength;
  }

  public void setReadonly(String readonly) {
    this.readonly = readonly;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setTestTag(String testTag) {
    this.testTag = testTag;
  }

	public boolean isPassword() {
		return password;
	}
	
	public void setPassword(boolean password) {
		this.password = password;
	}

}

