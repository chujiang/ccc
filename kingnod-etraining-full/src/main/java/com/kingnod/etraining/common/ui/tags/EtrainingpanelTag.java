package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AnchorTag;

import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ui.components.Etrainingpanel;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class EtrainingpanelTag extends AnchorTag {
	private static final long serialVersionUID = -4854923048213359085L;

	protected String labelKey;

	protected String label;

	protected String cssStyle;

	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new Etrainingpanel(stack, req, res);
	}

	protected void populateParams() {
		Etrainingpanel etrainingpanel = ((Etrainingpanel) component);
		etrainingpanel.setLabelKey(labelKey);
		etrainingpanel.setLabel(TagUtils.getMessage(labelKey, label));
		if (StringUtils.isNotBlank(cssStyle)) {
			etrainingpanel.setCssClass(cssStyle);
		}
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

}
