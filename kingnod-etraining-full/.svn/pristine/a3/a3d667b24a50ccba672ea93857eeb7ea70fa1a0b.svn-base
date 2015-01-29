package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "buttons", tldTagClass = "com.kingnod.etraining.common.ui.tags.ButtonsTag", description = "多个button", allowDynamicAttributes = true)
public class Buttons extends Links {

  public static final String OPEN_TEMPLATE = "buttons";
  public static final String TEMPLATE = "buttons-close";
  public static final String COMPONENT_NAME = Buttons.class.getName();

  public Buttons(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  public String getDefaultOpenTemplate() {
    return OPEN_TEMPLATE;
  }

  protected String getDefaultTemplate() {
    return TEMPLATE;
  }
  
}
