/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.TextArea;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 多行文本框的Tag
 * @author liuxiaobin
 */
public class TextAreaTag extends BaseUITag{

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  protected String cols;
  protected String readonly;
  protected String rows;
  protected String wrap;
  protected Object value;
  protected String textlimit;
  
  
  
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new TextArea(stack, req, res);
  }
  
  protected void populateParams() {
    super.populateParams();
    TextArea textArea = ((TextArea) component);
    textArea.setCols(cols);
    textArea.setReadonly(readonly);
    textArea.setRows(rows);
    textArea.setWrap(wrap);
}

  public void setCols(String cols) {
    this.cols = cols;
  }
  
  public void setReadonly(String readonly) {
      this.readonly = readonly;
  }
  
  public void setRows(String rows) {
      this.rows = rows;
  }
  
  public void setWrap(String wrap) {
      this.wrap = wrap;
  }

  public Object getValue() {
	  return value;
  }

  public void setValue(Object value) {
	  this.value = value;
  }

  public String getTextlimit() {
	  return textlimit;
  }

  public void setTextlimit(String textlimit) {
	  this.textlimit = textlimit;
  }
}
