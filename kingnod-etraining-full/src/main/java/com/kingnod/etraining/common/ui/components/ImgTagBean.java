package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnod.etraining.activity.entity.Period;
import com.opensymphony.xwork2.util.ValueStack;

public class ImgTagBean extends BaseUIBean {
	
	final public static String TEMPLATE = "Img";
	private String height;
	public void setHeight(String height) {
		this.height = height;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	private String width;
	private String src;
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public ImgTagBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	protected String getDefaultTemplate() {
		// TODO Auto-generated method stub
		return TEMPLATE;
	}
	
	@Override
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		
		String src = (String)this.findValue(this.name);
		addParameter("src", src);
		
		if (height != null) {
	        addParameter("height",  findString(height));
	    }

	    if (width != null) {
	        addParameter("width", findString(width));
	    }
	}

}
