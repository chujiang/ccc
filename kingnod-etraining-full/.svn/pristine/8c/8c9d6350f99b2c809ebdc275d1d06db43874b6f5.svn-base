package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name="button", tldTagClass="com.kingnod.etraining.common.ui.tags.ButtonTag", description="这个标签用于创建一个button")
public class Button extends Link {
  
  public static final String OPEN_TEMPLATE = "button";
  public static final String TEMPLATE = "button-close";
  public static final String COMPONENT_NAME = Button.class.getName();
  
  public Button(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    super(stack, req, res);
  }
  
  public String getDefaultOpenTemplate() {
    return OPEN_TEMPLATE;
  }

  protected String getDefaultTemplate() {
    return TEMPLATE;
  }
  
}
