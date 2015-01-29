package com.kingnod.etraining.common.ui.components;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Anchor;
import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "navmenu", tldTagClass = "com.kingnod.etraining.common.ui.tags.NavigationMenuTag", description = "这个标签用于创建一个URL")
public class NavigationMenu extends Anchor {

  public static final String OPEN_TEMPLATE = "nav-menu";
  public static final String TEMPLATE = "nav-menu-close";
  public static final String COMPONENT_NAME = NavigationMenu.class.getName();
  protected String openMode = "self";
  protected String text = "";
  protected String textKey = "";
  protected boolean textPlan = false;
  protected String windowFeature = "";
  protected String interceptorScript = "";
  protected boolean isLinksChildren = false;
  protected String dialogCloseScript;

  public NavigationMenu(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    super(stack, req, res);
  }

  @Override
  public void evaluateParams() {
	this.urlProvider.setEscapeAmp(false);
    super.evaluateParams();
    String href = (String) this.getParameters().get("href");
    if(StringUtils.isEmpty(this.onclick)){
	    String onclick = "";
	    if ("dialog".equals(openMode)) {
	      this.windowFeature = "help=no;center=yes;" + this.windowFeature;
	      onclick = "window.showModalDialog(\"" + href + "\",\"newwindow\" , \"" + this.windowFeature + "\");";
	      if(!StringUtils.isEmpty(this.dialogCloseScript)){
	    	  onclick = onclick + this.dialogCloseScript;
	      }
	      onclick = onclick + "return false;";
	    } else if ("dialogAndReload".equals(openMode)) {
		      this.windowFeature = "toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no"
		          + this.windowFeature;
		      onclick = "window.open(\"" + href + "\",\"newwindow\" , \"" + this.windowFeature + "\");return false;";
		} else if ("popup".equals(openMode)) {
	      this.windowFeature = "toolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=no"
	          + this.windowFeature;
	      onclick = "window.open(\"" + href + "\",\"newwindow\" , \"" + this.windowFeature + "\");return false;";
	    } else if ("submit".equals(openMode)) {
	      onclick = "$(\"form:eq(0)\").attr(\"action\", \"" + href + "\").submit();return false;";
	    } else {
	      onclick = "window.open(\"" + href + "\", \"_self\");return false;";
	    }
	    if (!StringUtils.isEmpty(this.interceptorScript)) {
	      String newonclick = "javascript:var a = function(){if(";
	      newonclick = newonclick + getProperties(interceptorScript);
	      newonclick = newonclick + "){" + onclick + "}else{return false;}}; return a();";
	      addParameter("onclick", newonclick);
	    } else {
	      addParameter("onclick", "javascript:" + onclick);
	    }
    }
    if (StringUtils.isEmpty(this.textKey)) {
      addParameter("text", this.text);
    } else {
      addParameter("text", SpringUtils.getMessage(this.textKey));
    }
    if (isLinksChildren) {
      addParameter("isLinksChildren", this.isLinksChildren);
    }
    addParameter("textPlan", this.textPlan);
  }

  /**
   * 根据key获取国际化文件中的value值
   * 
   * @param interceptorScript
   * @return String
   */
  public String getProperties(String interceptorScript) {
    String proName = StringUtils.EMPTY;
    if (StringUtils.isNotEmpty(interceptorScript)) {
      List<String> list = new ArrayList<String>();
      iterateParm(list, interceptorScript);
      for (String str : list) {
        proName += str;
      }
      proName += interceptorScript.substring(interceptorScript.lastIndexOf("}") + 1);
    }
    return proName;
  }

  /**
   * 递归所有的国际化数据
   * 
   * @param list
   * @param value
   */
  public static void iterateParm(List<String> list, String value) {
    if (StringUtils.isNotEmpty(value)) {
      int start = value.indexOf("@{");
      int end = value.indexOf("}");
      if (start != -1 && end != -1) {
        String keyName = StringUtils.substringBetween(value, "@{", "}");
        String key = StringUtils.EMPTY;
        Object[] valObj = null;
        if (keyName.indexOf("[") != -1 && keyName.indexOf("]") != -1) {
          key = keyName.substring(0, keyName.indexOf("["));
          valObj = keyName.substring(keyName.indexOf("[") + 1, keyName.indexOf("]")).split(",");
        } else {
          key = keyName;
        }
        String proName = TagUtils.getMessage(key, StringUtils.EMPTY, valObj);
        list.add(value.substring(0, start) + proName);
        iterateParm(list, value.substring(end + 1));
      }
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

  public String getWindowFeature() {
    return windowFeature;
  }

  public void setWindowFeature(String windowFeature) {
    this.windowFeature = windowFeature;
  }

  public boolean isLinksChildren() {
    return isLinksChildren;
  }

  public void setLinksChildren(boolean isLinksChildren) {
    this.isLinksChildren = isLinksChildren;
  }

  public String getInterceptorScript() {
    return interceptorScript;
  }

  public void setInterceptorScript(String interceptorScript) {
    this.interceptorScript = interceptorScript;
  }

  public String getOpenMode() {
    return openMode;
  }

  public void setOpenMode(String openMode) {
    this.openMode = openMode;
  }

public String getDialogCloseScript() {
	return dialogCloseScript;
}

public void setDialogCloseScript(String dialogCloseScript) {
	this.dialogCloseScript = dialogCloseScript;
}

/**
 * @return the textPlan
 */
public boolean isTextPlan() {
	return textPlan;
}

/**
 * @param textPlan the textPlan to set
 */
public void setTextPlan(boolean textPlan) {
	this.textPlan = textPlan;
}

}
