package com.kingnod.etraining.common.ui.tags;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AnchorTag;

import com.kingnod.etraining.common.ui.components.Link;
import com.kingnod.etraining.common.ui.components.Links;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class LinkTag extends AnchorTag {

  private static final long serialVersionUID = -6503701873654126103L;
  
  protected String openMode = "self";
  protected String text = "";
  protected String textKey = "";
  protected String windowFeature = "";
  protected String interceptorScript = "";
  protected String dictName;
  protected String dictParams;
  protected String dictValue;
  protected String dialogCloseScript;
  protected String iconName;
  protected String target;
  protected String disabled;
  
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new Link(stack, req, res);
  }
  
  @Override
  protected void populateParams() {
    super.populateParams();
    Link tag = (Link) component;
    tag.setOpenMode(openMode);
    tag.setText(calcLinkText());
    tag.setTextKey(textKey);
    tag.setWindowFeature(windowFeature);
    tag.setInterceptorScript(interceptorScript);
    tag.setDialogCloseScript(dialogCloseScript);
    tag.setTarget(target);
    tag.setDisabled(disabled);
//    tag.setIconName(iconName);
    LinksTag linksTag = (LinksTag)this.findAncestorWithClass(this, LinksTag.class);
    if(null != linksTag){
      Links links = (Links)linksTag.getComponent();
      if(null != links){
        tag.setLinksChildren(true);
      }
    }
    if (StringUtils.isNotBlank(iconName)) {
    	String iconSrc  = TagUtils.getContextPath(pageContext) + "/images/" + iconName+".gif";
    	tag.setIconSrc(iconSrc);
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

public String getIconName() {
	return iconName;
}

public void setIconName(String iconName) {
	this.iconName = iconName;
}

public String getTarget() {
	return target;
}

public void setTarget(String target) {
	this.target = target;
}

public String getDisabled() {
	return disabled;
}

public void setDisabled(String disabled) {
	this.disabled = disabled;
}
}
