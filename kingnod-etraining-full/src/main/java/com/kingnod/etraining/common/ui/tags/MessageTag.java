/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.Message;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 */
public class MessageTag extends BaseUITag{

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = -2154950640215144864L;

  protected String key;
  
  @Override
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new Message(stack,req,res);
  }
  
  protected void populateParams() {
    super.populateParams();
    Message file = ((Message) component);
    file.setKey(key);
  }

  public void setKey(String key) {
    this.key = key;
  }
}
