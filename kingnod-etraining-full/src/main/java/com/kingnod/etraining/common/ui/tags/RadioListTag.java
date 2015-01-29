/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.RadioList;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 单选按钮
 * @author liuxiaobin
 */
public class RadioListTag extends DictSupportTag{

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  @Override
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new RadioList(stack,req,res);
  }
  
  @Override
  protected void populateParams() {
    super.populateParams();
     
    RadioList radio = (RadioList)component;
    radio.setList(list);
    radio.setListKey(listKey);
    radio.setListValue(listValue);
    radio.setItems(items);
    radio.setValue(value);
  }
}
