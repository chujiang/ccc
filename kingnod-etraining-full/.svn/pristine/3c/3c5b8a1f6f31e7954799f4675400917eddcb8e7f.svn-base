package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.MutiSelect;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Administrator
 */
public class MutiSelectTag extends BaseUITag {

	protected String action;
	protected String namespace;
	protected String method;
	protected String maxlength;
	protected String readonly;
	protected String size;
	protected String testTag;
	private static final long serialVersionUID = -4854923048213359085L;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new MutiSelect(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		MutiSelect mutiselect = ((MutiSelect) component);
		mutiselect.setNamespace(namespace);
		mutiselect.setAction(action);
		mutiselect.setMethod(method);
		mutiselect.setMaxlength(maxlength);
		mutiselect.setReadonly("true");
		mutiselect.setSize(size);
		mutiselect.setTestTag(testTag);
	}

	public String getAction() {
		return action;
	}

	public String getNamespace() {
		return namespace;
	}

	public String getMethod() {
		return method;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTestTag() {
		return testTag;
	}

	public void setTestTag(String testTag) {
		this.testTag = testTag;
	}

}
