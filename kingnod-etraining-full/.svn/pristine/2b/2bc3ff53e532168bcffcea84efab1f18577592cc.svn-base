package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AnchorTag;

import com.kingnod.etraining.common.ui.components.CurrentCourses;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class CurrentCoursesTag extends AnchorTag{
	
	private static final long serialVersionUID = -4854923048213359085L;
	  
	  protected String labelKey="";
	  protected String label="";
	  
	  
	  public int doEndTag()throws JspException {
	    return super.doEndTag();
	  }

	  @Override
	  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
	    return new CurrentCourses(stack,req,res);
	  }
	  
	  protected void populateParams() {
		 CurrentCourses currentCourses = ((CurrentCourses) component);
		 currentCourses.setLabelKey(labelKey);
		 currentCourses.setLabel(TagUtils.getMessage(labelKey, label));
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
