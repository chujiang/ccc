package com.kingnod.etraining.common.ui.components;

import java.io.Writer;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.security.PermisssionService;
import com.kingnod.etraining.security.entity.EntityAuthority;
import com.kingnod.etraining.security.entity.Owner;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.util.ValueStack;

public class HasPermission extends org.apache.struts2.components.GenericUIBean {

	private String entityType;
	
	private String entityId;
	
	private String perm;
	
	private boolean hasPerm;

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

	public void setPerm(String perm) {
		this.perm = perm;
	}
	
	public HasPermission(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
	}
	
    public boolean start(Writer writer) {
    	
    	Long id = null;
    	try {
    		id = Long.valueOf(entityId);
    	} catch(Exception e) {
    		id = (Long) findValue(entityId, Long.class);
    	}
    	
    	Long permValue = null;
    	
    	try {
    		permValue = Long.valueOf(perm);
    	} catch(Exception e) {
    		permValue = (Long) findValue(perm, Long.class);
    	}
    	
    	PermisssionService permService = SpringUtils.getBean(PermisssionService.class);
    	UserAccount user = SecurityUtils.getCurrentUser();
    	EntityAuthority entityAuth = new EntityAuthority();
    	entityAuth.setEntityType(entityType);
    	entityAuth.setAuthorityValue(new BigDecimal(permValue));
    	
    	Owner owner = new Owner();
    	owner.setOwnerId((int)user.getId().longValue());
    	owner.setOwnerType(Owner.USER);
    	
    	hasPerm = permService.hasPermission(owner, entityAuth, ObjectType.valueOf(entityType), id);
//        stack.getContext().put(ANSWER, answer);
        return hasPerm;
    }

    public boolean end(Writer writer, String body) {
//        stack.getContext().put(ANSWER, answer);
        return super.end(writer, body);
    }
}
