/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.JsParameterRef;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 * 
 *  js中引用系统参数
 */
public class JsParameterRefTag extends BaseUITag {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	protected String var = "$msg";
	protected String value;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new JsParameterRef(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();
		JsParameterRef jsParameterRef = ((JsParameterRef) component);
		jsParameterRef.setVar(var);
		jsParameterRef.setValue(value);
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
