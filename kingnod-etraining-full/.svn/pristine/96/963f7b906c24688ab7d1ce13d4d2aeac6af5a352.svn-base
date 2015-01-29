package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.kingnod.etraining.common.ui.components.HasPermission;
import com.opensymphony.xwork2.util.ValueStack;

public class HasPermissionTag extends ComponentTagSupport {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -5181220455146867416L;

	private String entityType;
	
	private String entityId;
	
	private String perm;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new HasPermission(stack, req, res);
	}
	
	protected void populateParams() {
        HasPermission hasPerm = ((HasPermission) getComponent());
        hasPerm.setEntityId(entityId);
        hasPerm.setEntityType(entityType);
        hasPerm.setPerm(perm);
    }

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getPerm() {
		return perm;
	}

	public void setPerm(String action) {
		this.perm = action;
	}
}
