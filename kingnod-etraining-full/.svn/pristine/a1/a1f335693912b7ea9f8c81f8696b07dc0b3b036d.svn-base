/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.kingnod.etraining.common.ui.components.Form;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * form 标签组件
 * 
 * @author liuxiaobin
 * @author Sam
 */
public class FormTag extends AbstractClosingTag {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4342168904113537466L;

	protected String action;
	protected String target;
	protected String enctype;
	protected String method;
	protected String namespace;
	protected String validate;
	protected String validMsgTarget = "side";
	protected String onsubmit;
	protected String onreset;
	protected String portletMode;
	protected String windowState;
	protected String acceptcharset;
	protected String focusElement;
	protected String editable;
	protected String autoParamsName;//用逗号割开的字符串， 控制哪些请求参数会自动添加到form的hidden和添加到button和link的url

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new Form(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();
		Form form = ((Form) component);
		form.setAction(action);
		form.setTarget(target);
		form.setEnctype(enctype);
		form.setMethod(method);
		form.setNamespace(namespace);
		form.setValidate(validate);
		form.setValidMsgTarget(validMsgTarget);
		form.setOnsubmit(onsubmit);
		form.setPortletMode(portletMode);
		form.setWindowState(windowState);
		form.setAcceptcharset(acceptcharset);
		form.setFocusElement(focusElement);
		form.setAutoParamsName(autoParamsName);
	}

	public int doStartTag() throws JspException {
		pageContext.setAttribute("editable", editable);
		return super.doStartTag();
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setEnctype(String enctype) {
		this.enctype = enctype;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public void setOnsubmit(String onsubmit) {
		this.onsubmit = onsubmit;
	}

	public void setOnreset(String onreset) {
		this.onreset = onreset;
	}

	public void setPortletMode(String portletMode) {
		this.portletMode = portletMode;
	}

	public void setWindowState(String windowState) {
		this.windowState = windowState;
	}

	public void setAcceptcharset(String acceptcharset) {
		this.acceptcharset = acceptcharset;
	}

	public void setFocusElement(String focusElement) {
		this.focusElement = focusElement;
	}

	public String getValidMsgTarget() {
		return validMsgTarget;
	}

	public void setValidMsgTarget(String validMsgTarget) {
		this.validMsgTarget = validMsgTarget;
	}

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getAutoParamsName() {
		return autoParamsName;
	}

	public void setAutoParamsName(String autoParamsName) {
		this.autoParamsName = autoParamsName;
	}

}
