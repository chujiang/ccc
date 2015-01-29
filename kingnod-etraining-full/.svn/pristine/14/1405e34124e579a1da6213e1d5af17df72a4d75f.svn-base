
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.Label;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Administrator
 */
public class LabelTag extends BaseUITag {
    
  protected String forAttr;
  private static final long serialVersionUID = -4854923048213359085L;
  
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new Label(stack, req, res);
  }
  
  protected void populateParams() {
      super.populateParams();
      Label label = ((Label) component);
      label.setForAttr(forAttr);
  }

	public String getForAttr() {
		return forAttr;
	}

	public void setForAttr(String forAttr) {
		this.forAttr = forAttr;
	}
}
