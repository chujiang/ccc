package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

public class Reset extends BaseUIBean {
  final public static String TEMPLATE = "reset";

  protected String action;
  protected String method;
  protected String align;
  protected String type;
  protected String nameValue;

  public Reset(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  public String getDefaultOpenTemplate() {
    return "empty";
  }

  protected String getDefaultTemplate() {
    return Reset.TEMPLATE;
  }

  public void evaluateParams() {
    if ((key == null) && (value == null)) {
      value = "Reset";
    }
    if (((key != null)) && (value == null)) {
      this.value = "%{getText('" + key + "')}";
    }
    super.evaluateParams();
  }

  public void evaluateExtraParams() {
    super.evaluateExtraParams();
    if (action != null) {
      addParameter("action", findString(action));
    }
    if (method != null) {
      addParameter("method", findString(method));
    }
    if (align != null) {
      addParameter("align", findString(align));
    }
    if (type != null) {
      addParameter("type", findString(type));
    }
    if (nameValue != null) {
      addParameter("nameValue", findString(nameValue));
    }
  }

  protected boolean supportsImageType() {
    return false;
  }

  public void setLabel(String label) {
    super.setLabel(label);
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getAlign() {
    return align;
  }

  public void setAlign(String align) {
    this.align = align;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getNameValue() {
    return nameValue;
  }

  public void setNameValue(String nameValue) {
    this.nameValue = nameValue;
  }
}
