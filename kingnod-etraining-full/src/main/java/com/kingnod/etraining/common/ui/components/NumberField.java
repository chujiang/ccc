package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

public class NumberField extends TextField {

	final public static String TEMPLATE = "number";

	public NumberField(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
	}
	
	  protected String getDefaultTemplate() {
	      return TEMPLATE;
	  }

}
