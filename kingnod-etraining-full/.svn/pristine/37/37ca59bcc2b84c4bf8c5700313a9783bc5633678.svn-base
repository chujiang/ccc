package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AnchorTag;

import com.kingnod.etraining.common.ui.components.Link;
import com.kingnod.etraining.common.ui.components.Links;
import com.kingnod.etraining.common.ui.components.NavigationMenu;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class NavigationMenuTag extends AnchorTag {

  private static final long serialVersionUID = -6503701873654126103L;
  
  protected String openMode = "self";
  protected String text = "";
  protected String textKey = "";
  protected boolean textPlan = false;
  protected String windowFeature = "";
  protected String interceptorScript = "";
  protected String dictName;
  protected String dictParams;
  protected String dictValue;
  protected String dialogCloseScript;
  
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new NavigationMenu(stack, req, res);
  }
  
  @Override
  protected void populateParams() {
    super.populateParams();
    NavigationMenu tag = (NavigationMenu) component;
    tag.setOpenMode(openMode);
    tag.setText(calcLinkText());
    tag.setTextKey(textKey);
    tag.setTextPlan(textPlan);
    tag.setWindowFeature(windowFeature);
    tag.setInterceptorScript(interceptorScript);
    tag.setDialogCloseScript(dialogCloseScript);
    LinksTag linksTag = (LinksTag)this.findAncestorWithClass(this, LinksTag.class);
    if(null != linksTag){
      Links links = (Links)linksTag.getComponent();
      if(null != links){
        tag.setLinksChildren(true);
      }
    }
  }
  
  private String calcLinkText() {
	  if (StringUtils.isNotBlank(text))
		  return text;
	  if (StringUtils.isNotBlank(dictName)) {
		  return TagUtils.getDataDictItemName(dictName, dictParams, dictValue, (HttpServletRequest)pageContext.getRequest());
	  }
	  return "";
  }
  
  public String getOpenMode() {
    return openMode;
  }

  public String getText() {
    return text;
  }

  public String getTextKey() {
    return textKey;
  }

  public String getWindowFeature() {
    return windowFeature;
  }

  public String getInterceptorScript() {
    return interceptorScript;
  }

  public void setOpenMode(String openMode) {
    this.openMode = openMode;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setTextKey(String textKey) {
    this.textKey = textKey;
  }

  public void setWindowFeature(String windowFeature) {
    this.windowFeature = windowFeature;
  }

  public void setInterceptorScript(String interceptorScript) {
    this.interceptorScript = interceptorScript;
  }

public String getDictName() {
	return dictName;
}

public void setDictName(String dictName) {
	this.dictName = dictName;
}

public String getDictParams() {
	return dictParams;
}

public void setDictParams(String dictParams) {
	this.dictParams = dictParams;
}

public String getDictValue() {
	return dictValue;
}

public void setDictValue(String dictValue) {
	this.dictValue = dictValue;
}

public String getDialogCloseScript() {
	return dialogCloseScript;
}

public void setDialogCloseScript(String dialogCloseScript) {
	this.dialogCloseScript = dialogCloseScript;
}

public boolean isTextPlan() {
	return textPlan;
}

public void setTextPlan(boolean textPlan) {
	this.textPlan = textPlan;
}

  
}
