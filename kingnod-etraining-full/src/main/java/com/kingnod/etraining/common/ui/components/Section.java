package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTag;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "section", tldTagClass = "com.kingnod.etraining.common.ui.tags.SectionTag", description = "表单页面_有分区", allowDynamicAttributes = true)
public class Section extends ClosingUIBean {

  public static final String OPEN_TEMPLATE = "section";
  public static final String TEMPLATE = "section-close";
  public static final String COMPONENT_NAME = Section.class.getName();

  protected String label = "";
  protected String labelKey = "";
  protected String layoutCols = "";
  protected boolean isOfPanel;

  public Section(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  public void evaluateParams() {
    super.evaluateParams();
    addParameter("label", this.label);
    addParameter("labelKey", this.labelKey);
    addParameter("layoutCols", this.layoutCols);
    addParameter("isOfPanel", isOfPanel);
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

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public String getLayoutCols() {
		return layoutCols;
	}

	public void setLayoutCols(String layoutCols) {
		this.layoutCols = layoutCols;
	}

	public boolean isOfPanel() {
		return isOfPanel;
	}

	public void setOfPanel(boolean isOfPanel) {
		this.isOfPanel = isOfPanel;
	}
  
}
