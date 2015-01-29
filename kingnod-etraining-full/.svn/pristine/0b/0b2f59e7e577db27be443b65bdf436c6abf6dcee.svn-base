package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Anchor;

import com.opensymphony.xwork2.util.ValueStack;

public class MorePanel extends Anchor{
	
	final public static  String OPEN_TEMPLATE = "morePanel";
	final public static String TEMPLATE = "morePanel-close";
	
	protected String labelKey;

	protected String label;
	
	protected String morelabelKey;
	
	protected String morelabel;
	
	 protected String moreAction = "###";
	  
	  
	  public String getMoreAction() {
		return moreAction;
	}

	public void setMoreAction(String moreAction) {
		this.moreAction = moreAction;
	}
	

	public MorePanel(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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
    addParameter("morelabelKey", morelabelKey);  
    addParameter("morelabel", morelabel); 
    addParameter("moreAction", moreAction);
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
	public String getMorelabelKey() {
		return morelabelKey;
	}
	public void setMorelabelKey(String morelabelKey) {
		this.morelabelKey = morelabelKey;
	}
	public String getMorelabel() {
		return morelabel;
	}
	public void setMorelabel(String morelabel) {
		this.morelabel = morelabel;
	}
	
	

}
