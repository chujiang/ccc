package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.PeriodTagBean;
import com.opensymphony.xwork2.util.ValueStack;

public class PeriodTag extends BaseUITag{

	protected String key;
	
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		// TODO Auto-generated method stub
		return new PeriodTagBean(stack, req, res);
	}

	protected void populateParams() {
	    super.populateParams();
	    PeriodTagBean file = ((PeriodTagBean) component);
	    file.setKey(key);
	}

	public void setKey(String key) {
		this.key = key;
	}
}
