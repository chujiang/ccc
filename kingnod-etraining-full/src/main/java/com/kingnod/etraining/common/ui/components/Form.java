/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.components.UrlRenderer;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.ObjectFactory;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.validator.ActionValidatorManager;

/**
 * @author liuxiaobin
 * 
 */
public class Form extends ClosingUIBean {

	public static final String OPEN_TEMPLATE = "form";
	public static final String TEMPLATE = "form-close";

	protected int sequence = 0;

	protected String onsubmit;
	protected String onreset;
	protected String action;
	protected String target;
	protected String enctype;
	protected String method;
	protected String namespace;
	/**
	 * 是否要支持验证
	 */
	protected String validate;
	protected String autoParamsName;//用逗号割开的字符串， 控制哪些请求参数会自动添加到form的hidden和添加到button和link的url
	protected Map<String, String[]> autoParams;

	/**
	 * 验证消息的显示方式，有以下几种方式 side 显示于被验证的输入组件的右边 div 将所有组件的错误消息都显示于此区域中 alert
	 * 使用一个对话框架(非浏览器的原生 alert对话框)的方式来提示所有错误信息
	 */
	protected String validMsgTarget;
	protected String portletMode;
	protected String windowState;
	protected String acceptcharset;
	protected String focusElement;

	protected Configuration configuration;
	protected ObjectFactory objectFactory;
	protected UrlRenderer urlRenderer;
	protected ActionValidatorManager actionValidatorManager;

	public Form(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	protected boolean evaluateNameValue() {
		return false;
	}

	public String getDefaultOpenTemplate() {
		return OPEN_TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}
	
	@Override
	public String getTheme() {
		return "kingnod";
	}

	/**
	 * 设置模板默认路径
	 */
	public String getTemplateDir() {
		return "com/kingnod/etraining/common/ui/views";
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		if (validate != null) {
			addParameter("validate", findValue(validate, Boolean.class));
		}

		if (validMsgTarget != null)
			addParameter("validMsgTarget",
					findValue(validMsgTarget, String.class));

		if (name == null) {
			// make the name the same as the id
			String id = (String) getParameters().get("id");
			if (StringUtils.isNotEmpty(id)) {
				addParameter("name", id);
			}
		}

		if (onsubmit != null) {
			addParameter("onsubmit", findString(onsubmit));
		}

		if (onreset != null) {
			addParameter("onreset", findString(onreset));
		}

		if (target != null) {
			addParameter("target", findString(target));
		}

		if (enctype != null) {
			addParameter("enctype", findString(enctype));
		}

		if (method != null) {
			addParameter("method", findString(method));
		}

		if (action != null) {
			addParameter("action", findString(action));
		}

		if (acceptcharset != null) {
			addParameter("acceptcharset", findString(acceptcharset));
		}

		if (!parameters.containsKey("tagNames")) {
			addParameter("tagNames", new ArrayList<Object>());
		}

		if (focusElement != null) {
			addParameter("focusElement", findString(focusElement));
		}
		
		if(com.kingnod.core.util.StringUtils.isNotEmpty(this.autoParamsName)){
			String[] paramNames = com.kingnod.core.util.StringUtils.split(this.autoParamsName, ",");
			autoParams = new HashMap<String, String[]>();
			for(String paramName:paramNames){
				if(com.kingnod.core.util.StringUtils.isNotEmpty(paramName)){
					String[] paramValue = this.request.getParameterValues(paramName);
					autoParams.put(paramName, paramValue);
				}
			}
			addParameter("autoParams", autoParams);//自动添加hidden字段保存参数
		}
		
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setUrlRenderer(UrlRenderer urlRenderer) {
		this.urlRenderer = urlRenderer;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setActionValidatorManager(
			ActionValidatorManager actionValidatorManager) {
		this.actionValidatorManager = actionValidatorManager;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setOnsubmit(String onsubmit) {
		this.onsubmit = onsubmit;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setOnreset(String onreset) {
		this.onreset = onreset;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setAction(String action) {
		this.action = action;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setTarget(String target) {
		this.target = target;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setEnctype(String enctype) {
		this.enctype = enctype;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setValidate(String validate) {
		this.validate = validate;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setPortletMode(String portletMode) {
		this.portletMode = portletMode;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setWindowState(String windowState) {
		this.windowState = windowState;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setAcceptcharset(String acceptcharset) {
		this.acceptcharset = acceptcharset;
	}

	@StrutsTagAttribute(description = "set size", type = "String", defaultValue = "")
	public void setFocusElement(String focusElement) {
		this.focusElement = focusElement;
	}

	

	public String getValidMsgTarget() {
		return validMsgTarget;
	}

	public void setValidMsgTarget(String validMsgTarget) {
		this.validMsgTarget = validMsgTarget;
	}

	public String getAutoParamsName() {
		return autoParamsName;
	}

	public void setAutoParamsName(String autoParamsName) {
		this.autoParamsName = autoParamsName;
	}

	public Map<String, String[]> getAutoParams() {
		return autoParams;
	}

	public void setAutoParams(Map<String, String[]> autoParams) {
		this.autoParams = autoParams;
	}

}
