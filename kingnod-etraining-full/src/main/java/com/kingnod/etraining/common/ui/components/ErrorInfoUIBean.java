package com.kingnod.etraining.common.ui.components;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.exception.ErrorInfo;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.web.EL;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 错误信息显示UIBean
 * @author Sam
 *
 */
public class ErrorInfoUIBean extends BaseUIBean {
	
	/**
	 * 错误显示方式：alert-使用alert对话进行显示错误信息、html-直接输出html
	 */
	private String showType;
	
	/**
	 * showType为html时，要将错误消息显示在哪个位置，通常是某个html element的id
	 * 如果没有指定此值时，将根据htmlTemplate直接输出错误消息
	 */
	private String at;
	
	/**
	 * showType为html时，指定要在某个html element的左边还是右边，还是被包含
	 * left-左边
	 * right-右边
	 * of-被包含
	 */
	private String showPosition = "right";
	
	/**
	 * showType为html时，显示错误消息的html模板，程序会根据此模板渲染错误消息
	 * 定义如下：
	 * <pre>
	 * <div>${errorCode}</div><div>${errorMesage}</div><div>${errorDetail}</div>
	 * </pre>
	 */
	private String htmlTemplate; 
	
	/**
	 * showType为html时，错误消息所在的html element的样式class
	 */
	private String errorClass = "error";
	
	/**
	 * showType为html时，错误消息所在的html element的style
	 */
	private String errorStyle;
	
	/**
	 * 错误信息对象
	 */
	private ErrorInfo errorInfo;
	
	

	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		if (StringUtils.equalsIgnoreCase(showType, "alert")) {
			addParam("showType",1);
		} else if (StringUtils.equalsIgnoreCase(showType, "html") && StringUtils.isNotEmpty(at)) {
			addParam("showType",2);
		} else {
			addParam("showType",3);
		}
		if (StringUtils.isNotBlank(htmlTemplate)) {
			addParam("hasTemplate",true);
		}
		addParam("showPosition",showPosition);
		addParam("errorClass",errorClass);
		addParam("errorStyle",errorStyle);
		addParam("errorInfo",getErrorInfo());
		addParam("at",at);
		
	}

	public ErrorInfoUIBean(ValueStack stack, HttpServletRequest request,HttpServletResponse response) {
		super(stack, request, response);		
	}
	
	public String getErrorInfo() { 
		if (errorInfo == null)
			return null;
		if (StringUtils.isNotBlank(htmlTemplate)) {
			Map m = MapUtils.mapByAarray("errorCode",errorInfo.getCode(),
										 "errorMessage",errorInfo.getMessage(),
										 "errorDetails",errorInfo.getDetail());
			return new EL(m,"%","%").executeExpression(htmlTemplate);
		} 
		return errorInfo.getMessage();
	}

	@Override
	protected String getDefaultTemplate() { 
		return "errorInfo";
	}
	
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getShowPosition() {
		return showPosition;
	}

	public void setShowPosition(String showPosition) {
		this.showPosition = showPosition;
	}

	public String getHtmlTemplate() {
		return htmlTemplate;
	}

	public void setHtmlTemplate(String htmlTemplate) {
		this.htmlTemplate = htmlTemplate;
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

	public void setAt(String at) {
		this.at = at;
		this.showType = "html";
	}

	public String getAt() {
		return at;
	}

}
