/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.JsMsgRef;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 * js中引用国际化字段
 */
public class JsMsgRefTag extends BaseUITag{
  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;
  
  protected String var = "$msg";
  protected String value;

  @Override
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new JsMsgRef(stack,req,res);
  }
  
  protected void populateParams() {
    super.populateParams();
    JsMsgRef jsMsgRef = ((JsMsgRef) component);
    jsMsgRef.setVar(var);
    jsMsgRef.setValue(value);
  }
  
  public void setVar(String var) {
    this.var = var;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
