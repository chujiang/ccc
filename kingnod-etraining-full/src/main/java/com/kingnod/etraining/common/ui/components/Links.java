package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.core.util.SpringUtils;
import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "links", tldTagClass = "com.kingnod.etraining.common.ui.tags.LinksTag", description = "多个link", allowDynamicAttributes = true)
public class Links extends ClosingUIBean {

  public static final String OPEN_TEMPLATE = "links";
  public static final String TEMPLATE = "links-close";
  public static final String COMPONENT_NAME = Links.class.getName();

  protected String text = "";
  protected String textKey = "";
  protected String width = "";
  protected String iconName;
  protected String iconSrc;

  public Links(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  public void evaluateParams() {
    super.evaluateParams();
    if (StringUtils.isEmpty(this.textKey)) {
      addParameter("text", this.text);
    } else {
      addParameter("text", SpringUtils.getMessage(this.textKey));
    }
    addParameter("href", "#");
    //addParameter("cssStyle", "text-decoration: none; width: 50px;");
    if (!StringUtils.isEmpty(this.width)){
      addParameter("width", this.width);
    }
    if(StringUtils.isNotBlank(iconSrc)){
   	 addParameter("iconSrc", this.iconSrc);
   }
  }

  public String getDefaultOpenTemplate() {
    return OPEN_TEMPLATE;
  }

  protected String getDefaultTemplate() {
    return TEMPLATE;
  }

  public String getTemplateDir() {
    return "com/kingnod/etraining/common/ui/views";
  }

  public String getTheme() {
    return "kingnod";
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

	public String getIconSrc() {
		return iconSrc;
	}

	public void setIconSrc(String iconSrc) {
		this.iconSrc = iconSrc;
	}
  
}
