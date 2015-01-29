package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.kingnod.core.exception.ErrorInfo;
import com.kingnod.etraining.common.ui.components.ErrorInfoUIBean;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 错误消息tag,用于显示异常消息
 * @author Sam
 *
 */
public class ErrorInfoTag extends AbstractUITag {

 
	private static final long serialVersionUID = 5360218005888901989L;
	
 
	/**
	 * @see com.kingnod.etraining.common.ui.components.ErrorInfoUIBean#showType
	 */
	protected String showType;
	
	/**
	 * @see com.kingnod.etraining.common.ui.components.ErrorInfoUIBean#at
	 */
	protected String at;
	
	/**
	 * @see com.kingnod.etraining.common.ui.components.ErrorInfoUIBean#errorClass
	 */
	protected String errorClass = "error";
	
	/**
	 * @see com.kingnod.etraining.common.ui.components.ErrorInfoUIBean#errorStyle
	 */
	protected String errorStyle;
	
	/**
	 * @see com.kingnod.etraining.common.ui.components.ErrorInfoUIBean#htmlTemplate
	 */
	protected String htmlTemplate;
	
	/**
	 * @see com.kingnod.etraining.common.ui.components.ErrorInfoUIBean#showPosition
	 */
	protected String showPosition = "right";
	
	/**
	 * 错误消息在request中或者stack中的key
	 */
	protected String errorKey = "errorInfo";
	
	/**
	 * 设置关联的ErrorCode，如果抛出的异常信息的ErrorCode此设定的不配置，则不作任何处理
	 */
	protected String errorCode ;

	

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new ErrorInfoUIBean(stack,req,res);
	}
	
	protected void populateParams() {
		super.populateParams();
		ErrorInfoUIBean error = (ErrorInfoUIBean)component;		
		error.setAt(at);
		error.setHtmlTemplate(htmlTemplate);
		error.setShowPosition(showPosition);
		error.setErrorClass(errorClass);
		error.setErrorStyle(errorStyle);
		error.setShowType(showType);
		error.setErrorInfo(getErrorInfo());
	}

	private ErrorInfo getErrorInfo() {
		ErrorInfo errorInfo = (ErrorInfo) pageContext.getRequest().getAttribute(errorKey);
		if (errorInfo == null) {
			errorInfo = (ErrorInfo) pageContext.getSession().getAttribute(errorKey);
			if (errorInfo != null) {
				setErrorInfo(pageContext,errorKey,errorInfo);
			}
		}
		errorInfo = (ErrorInfo) (errorInfo == null?  getStack().findValue(errorKey):errorInfo);
		
		//如果设置了ErrorCode，则要判断与之匹配的消息进行处理。
		if (StringUtils.isNotBlank(errorCode) && errorInfo != null) {
			String[] eCodes = errorCode.split(",");
			for (String e : eCodes) {
				if (StringUtils.equalsIgnoreCase(e, errorInfo.getCode())) 
					return errorInfo;
			}
			return null;
		}
		return errorInfo;
	}
	
	private /*synchronized*/ static void setErrorInfo(PageContext pageContext,String errorKey,ErrorInfo errorInfo) {
		if (pageContext.getSession().getAttribute(errorKey) != null) {
			pageContext.getSession().removeAttribute(errorKey);
		}
		if (pageContext.getRequest().getAttribute(errorKey) == null) {
			pageContext.getRequest().setAttribute(errorKey,errorInfo);
		}
	}
	
	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
	
	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public String getErrorClass() {
		return errorClass;
	}

	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}

	public String getErrorStyle() {
		return errorStyle;
	}

	public void setErrorStyle(String errorStyle) {
		this.errorStyle = errorStyle;
	}

	public String getHtmlTemplate() {
		return htmlTemplate;
	}

	public void setHtmlTemplate(String htmlTemplate) {
		this.htmlTemplate = htmlTemplate;
	}

	public String getShowPosition() {
		return showPosition;
	}

	public void setShowPosition(String showPosition) {
		this.showPosition = showPosition;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
