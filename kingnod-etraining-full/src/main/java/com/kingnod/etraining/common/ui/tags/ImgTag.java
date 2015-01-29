package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.ImgTagBean;
import com.opensymphony.xwork2.util.ValueStack;

public class ImgTag extends BaseUITag{

	protected String key;
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	protected String width;
	protected String height;
	
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		// TODO Auto-generated method stub
		return new ImgTagBean(stack, req, res);
	}
	
	protected void populateParams() {
	    super.populateParams();
	    ImgTagBean file = ((ImgTagBean) component);
	    file.setKey(key);
	    file.setWidth(getWidth());
	    file.setHeight(getHeight());
	}

	public void setKey(String key) {
		this.key = key;
	}

}
