/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 */
public class File extends BaseUIBean {
  
  final public static String TEMPLATE = "file";

  protected String accept;
  protected String size;
  
  public File(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }
  
  @Override
  public void evaluateExtraParams() {
    super.evaluateExtraParams();
    if (accept != null) {
      addParameter("accept", findString(accept));
    }
    
    if (size != null) {
      addParameter("size", findString(size));
    }
  }
  
  @Override
  protected String getDefaultTemplate() {
    return TEMPLATE;
  }

  @StrutsTagAttribute(description="set accept", type="String", defaultValue="")
  public void setAccept(String accept) {
    this.accept = accept;
  }

  @StrutsTagAttribute(description="set size", type="String", defaultValue="")
  public void setSize(String size) {
    this.size = size;
  }
}
