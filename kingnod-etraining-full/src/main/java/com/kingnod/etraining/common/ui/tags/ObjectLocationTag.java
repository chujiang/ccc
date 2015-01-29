package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.kingnod.core.util.Assert;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.ui.components.ObjectLocation;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Title: <br>
 * Description:<br>
 * @author tanxiaodan
 */
public class ObjectLocationTag extends AbstractClosingTag {

	/** serialVersionUID */
	private static final long serialVersionUID = -7799486381360816312L;
	
	protected String objectType;
	
	protected Long objectId;
	
	protected String objectName;

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony.xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new ObjectLocation(stack, req, res);
	}

	
	@Override
	protected void populateParams() {
		/*把对应的参数设定到UI组件对象里，这里是ObjectLocation对象 */
		super.populateParams();
		ObjectLocation tag = (ObjectLocation) component;
		if (!StringUtils.isEmpty(objectType)) {
			tag.setObjectType(ObjectType.valueOf(objectType));
		}
		
		if (null != objectId) {
			tag.setObjectId(objectId);
		}
		
		tag.setObjectName(objectName);
	}
	  
	public String getObjectType() {
		return objectType;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}


	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

}
