package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.kingnod.core.util.UUIDUtils;
import com.kingnod.etraining.common.ui.components.Links;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class LinksTag extends AbstractClosingTag {

  private static final long serialVersionUID = 4018245551996059705L;
  
  protected String text = "";
  protected String textKey = "";
  protected String width = "";
  protected String iconName;

  @Override
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new Links(stack, req, res);
  }
  
  

  @Override
  protected void populateParams() {
    super.populateParams();
    Links tag = (Links) component;
    tag.setText(text);
    tag.setTextKey(textKey);
    tag.setWidth(width);
    if(StringUtils.isEmpty(this.id)){
      tag.setId(UUIDUtils.getUUID());
    }
    if (StringUtils.isNotBlank(iconName)) {
    	String iconSrc  = TagUtils.getContextPath(pageContext) + "/images/" + iconName+".gif";
    	tag.setIconSrc(iconSrc);
    }
  }
  
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
  
  public String getTextKey() {
    return textKey;
  }

  public void setTextKey(String textKey) {
    this.textKey = textKey;
  }
  
  public String getWidth() {
    return width;
  }

  public void setWidth(String width) {
    this.width = width;
  }
  public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
  
}
