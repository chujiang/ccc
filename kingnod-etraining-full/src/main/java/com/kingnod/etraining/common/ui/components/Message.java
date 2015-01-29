/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin message标签，引用国际化字段
 */
public class Message extends BaseUIBean {

  final public static String TEMPLATE = "message";

  protected String key;

  public Message(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  protected String getDefaultTemplate() {
    return TEMPLATE;
  }

  @Override
  public void evaluateExtraParams() {
    super.evaluateExtraParams();
    if (key != null) {
      addParameter("key", TagUtils.getValue(key));
    }
  }

  public void setKey(String key) {
    this.key = key;
  }
}
