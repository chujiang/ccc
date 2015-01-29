package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AnchorTag;

import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ui.components.MorePanel;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class MorePanelTag extends AnchorTag{
	private static final long serialVersionUID = -4854923048213359085L;
	  
	  protected String labelKey="";
	  protected String label="";
	  protected String morelabelKey;
	  protected String morelabel;
	  protected String moreAction = "###";
	  
	  
	  public String getMoreAction() {
		return moreAction;
	}

	public void setMoreAction(String moreAction) {
		this.moreAction = moreAction;
	}

	public int doEndTag()throws JspException {
	    return super.doEndTag();
	  }

	  @Override
	  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
	    return new MorePanel(stack,req,res);
	  }
	  
	  protected void populateParams() {
		  MorePanel morePanel = ((MorePanel) component);
		  morePanel.setLabelKey(labelKey);
		  morePanel.setLabel(TagUtils.getMessage(labelKey, label));
		  morePanel.setMoreAction(moreAction);
		  if (StringUtils.isNotBlank(morelabelKey)) {
			  morePanel.setLabelKey(morelabelKey);
			  morePanel.setLabel(TagUtils.getMessage(morelabelKey, morelabel));
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
