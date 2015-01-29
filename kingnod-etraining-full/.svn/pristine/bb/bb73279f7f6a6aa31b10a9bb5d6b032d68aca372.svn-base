package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Anchor;

import com.opensymphony.xwork2.util.ValueStack;

public class CurrentCourses extends Anchor{
	final public static  String OPEN_TEMPLATE = "currentCourses";
	final public static String TEMPLATE = "currentCourses-close";
	
	  protected String labelKey;

	  
	  protected String label;
	  
	  
	  
	  public CurrentCourses(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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
