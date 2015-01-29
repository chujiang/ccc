/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.Upload;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author chujiang
 */
public class UploadTag extends BaseUITag {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2154950640215144864L;

	/**
	 * 是否多选
	 */
	private boolean multi = false;

	protected String key;
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public boolean isMulti() {
		return multi;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	private String imgMassageKey = "";
	
	public String getImgMassageKey() {
		return imgMassageKey;
	}

	public void setImgMassageKey(String imgMassageKey) {
		this.imgMassageKey = imgMassageKey;
	}
	
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new Upload(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();
		Upload upload = (Upload)component;
		upload.setMulti(multi);
		upload.setImgMassageKey(imgMassageKey);
		upload.setKey(key);
	}

}
