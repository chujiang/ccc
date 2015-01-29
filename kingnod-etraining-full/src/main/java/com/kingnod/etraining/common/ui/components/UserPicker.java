package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.dict.DataDict;
import com.kingnod.core.dict.DictFactory;
import com.kingnod.core.dict.DictService;
import com.kingnod.core.dict.util.DictUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.opensymphony.xwork2.util.ValueStack;

public class UserPicker extends BaseUIBean {
	/**
   * The name of the default template for the TextFieldTag
   */
  final public static String TEMPLATE = "userPicker";
  String openTemplate;


  protected String maxlength;
  protected String readonly;
  protected String size;
  protected String testTag;

  public UserPicker(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
      super(stack, request, response);
  }

  protected String getDefaultTemplate() {
      return TEMPLATE;
  }

  public void evaluateExtraParams() {
    super.evaluateExtraParams();
    if (size != null) {
        addParameter("size", findString(size));
    }
    if (maxlength != null) {
        addParameter("maxlength", findString(maxlength));
    }
    if (readonly != null) {
        addParameter("readonly", findValue(readonly, Boolean.class));
    }
    if (testTag != null) {
    	addParameter("length", findValue(testTag, Boolean.class));
    }
    
    String id = StringUtils.EMPTY;
    if (name != null) {
    	if(name.indexOf(".") != -1){
    		name = name.replaceAll("\\.", "_");
    	}
    	id = name;
    	addParameter("id", findString(name));
    }
    String nameValue = (String)this.getParameters().get("nameValue");
    String fullName = "";
    if(null != nameValue){
    	DictFactory dictFactory = SpringUtils.getBean(DictFactory.class);
    	DictService dictService = dictFactory.createDictService();
    	fullName = dictService.getDictItemNameByValue("org", "userFullName", null, nameValue);
    	addParameter("fullName", fullName);
    }
    StringBuffer sb = new StringBuffer();
    sb.append("var result = window.showModalDialog(");
    sb.append("\"" + Struts2Utils.getRequest().getContextPath() + "/org/user-picker.action\",\"用户选择\", \"\");");
    sb.append("$(\"#userPicker_"+id+"\").val(result.split(\";\")[1]);");
    sb.append("$(\"#"+id+"\").val(result.split(\";\")[0]);");
    sb.append("return false;");
    addParameter("selectOnclick", sb.toString());
  }

  public void setMaxlength(String maxlength) {
    this.maxlength = maxlength;
  }

  public void setReadonly(String readonly) {
    this.readonly = readonly;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setTestTag(String testTag) {
    this.testTag = testTag;
  }
}

