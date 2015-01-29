/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.util.SysParameterUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 * 
 *         js中引用系统参数
 */
public class JsParameterRef extends BaseUIBean {

	final public static String TEMPLATE = "JsParameterRef";

	protected String var;
	protected String value;

	public JsParameterRef(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	@Override
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		if (var != null) {
			addParameter("var", findString(var));
		}

		if (value != null) {
			addParameter("mapValr", JSONObject.fromObject(getValue(value))
					.toString());
		}
	}

	public Map<String, String> getValue(String value) {
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(value)) {
			String[] regex = value.split(";");
			for (String key : regex) {
				map.put(key, SysParameterUtils.getString(key));
			}
		}
		return map;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
