package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.NumberField;
import com.opensymphony.xwork2.util.ValueStack;

public class NumberFieldTag extends TextFieldTag {

	private static final long serialVersionUID = -4365801098724422902L;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new NumberField(stack, req, res);
	}
	
	@Override
	protected void populateParams() {
		super.populateParams();
	}

}
