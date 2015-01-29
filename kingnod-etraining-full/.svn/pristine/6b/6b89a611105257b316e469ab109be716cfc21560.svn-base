
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.ui.components.Navigation;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Administrator
 */
public class NavigationTag extends AbstractClosingTag {

	private static final long serialVersionUID = 9165656773785530799L;
	
	protected String objectType;
	protected String objectId;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
	    return new Navigation(stack, req, res);
	  }
	
	  @Override
	  protected void populateParams() {
	    super.populateParams();
	    Navigation tag = (Navigation) component;
	    if(!StringUtils.isEmpty(objectType)){
	    	tag.setObjectType(ObjectType.valueOf(objectType));
	    }
	    if(!StringUtils.isEmpty(objectId)){
	      tag.setObjectId(Long.valueOf(objectId));
	    }
	  }
	
	public String getObjectType() {
		return objectType;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

    
}
