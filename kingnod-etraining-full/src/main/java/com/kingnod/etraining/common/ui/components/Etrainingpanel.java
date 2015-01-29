package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.components.Anchor;

import com.opensymphony.xwork2.util.ValueStack;

public class Etrainingpanel extends Anchor {

	final public static String OPEN_TEMPLATE = "etrainingPanel";
	final public static String TEMPLATE = "etrainingPanel-close";

	protected String labelKey;

	protected String label;

	protected String cssStyle;

	public Etrainingpanel(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
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
	
	 public void evaluateExtraParams() {
		    super.evaluateExtraParams();
		    addParameter("labelKey", labelKey);  
		    addParameter("label", label);
		    if(StringUtils.isNotBlank(cssStyle)){
		    	addParameter("cssStyle",cssStyle);
		    }
		    
	 }

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

}
