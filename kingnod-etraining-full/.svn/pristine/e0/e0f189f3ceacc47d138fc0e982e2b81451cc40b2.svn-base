package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "panel", tldTagClass = "com.kingnod.etraining.common.ui.tags.PanelTag", description = "表单页面_面板", allowDynamicAttributes = true)
public class Panel extends ClosingUIBean {

  public static final String OPEN_TEMPLATE = "panel";
  public static final String TEMPLATE = "panel-close";
  public static final String COMPONENT_NAME = Panel.class.getName();

  protected String label = "";
  protected String panelCols = "";

  public Panel(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  public void evaluateParams() {
    super.evaluateParams();
    addParameter("label", this.label);
    addParameter("panelCols", this.panelCols);
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPanelCols() {
		return panelCols;
	}

	public void setPanelCols(String panelCols) {
		this.panelCols = panelCols;
	}

}
