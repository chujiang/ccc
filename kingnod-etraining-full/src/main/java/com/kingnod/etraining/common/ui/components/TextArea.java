/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 多行文本框
 * @author liuxiaobin
 */
public class TextArea extends BaseUIBean{
  
  final public static String TEMPLATE = "textarea";

  protected String cols;
  protected String readonly;
  protected String rows;
  protected String wrap;
  protected String textlimit;
  
  public TextArea(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  protected String getDefaultTemplate() {
    return TEMPLATE;
  }

  public void evaluateExtraParams() {
    super.evaluateExtraParams();

    if (readonly != null) {
        addParameter("readonly", findValue(readonly, Boolean.class));
    }

    if (cols != null) {
        addParameter("cols", findString(cols));
    }

    if (rows != null) {
        addParameter("rows", findString(rows));
    }

    if (wrap != null) {
        addParameter("wrap", findString(wrap));
    }
    if(StringUtils.isEmpty(textlimit)){
    	textlimit = "500";
    }
    addParameter("onkeydown", "$k.CheckTextArea(this, "+textlimit+");");
    addParameter("onkeyup", "$k.CheckTextArea(this, "+textlimit+");");
  }

  @StrutsTagAttribute(description="set cols", type="Integer")
  public void setCols(String cols) {
      this.cols = cols;
  }

  @StrutsTagAttribute(description="set", type="Boolean readonly", defaultValue="false")
  public void setReadonly(String readonly) {
      this.readonly = readonly;
  }

  @StrutsTagAttribute(description="set rows", type="Integer")
  public void setRows(String rows) {
      this.rows = rows;
  }

  @StrutsTagAttribute(description="set wrap")
  public void setWrap(String wrap) {
      this.wrap = wrap;
  }

  public String getTextlimit() {
	return textlimit;
  }

  public void setTextlimit(String textlimit) {
	this.textlimit = textlimit;
  }
}
