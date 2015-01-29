package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Anchor;

import com.opensymphony.xwork2.util.ValueStack;

public class RoundedPanel extends Anchor {

	private static final long serialVersionUID = -4854923048213359085L;

	final public static String OPEN_TEMPLATE = "roundedPanel";
	final public static String TEMPLATE = "roundedPanel-close";

	protected String labelKey;

	protected String label;
	
	public RoundedPanel(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

}
