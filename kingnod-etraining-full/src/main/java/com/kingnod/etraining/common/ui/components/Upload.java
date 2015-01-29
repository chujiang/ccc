/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.common.service.AttachmentService;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author chujiang
 */
public class Upload extends BaseUIBean {

	final public static String TEMPLATE = "upload";

	protected String key;
	
	public void setKey(String key) {
		this.key = key;
	}
	
	private String imgMassageKey = "";
	
	public String getImgMassageKey() {
		return imgMassageKey;
	}

	public void setImgMassageKey(String imgMassageKey) {
		this.imgMassageKey = imgMassageKey;
	}

	private boolean multi = false;

	public Upload(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	@Override
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		addParam("contextPath", this.request.getContextPath());
		addParam("multi", Boolean.toString(multi));
		Long attachmentId = (Long)this.findValue(this.name);
		AttachmentService attachmentService = (AttachmentService)SpringUtils.getBean(AttachmentService.class);
		String url = attachmentService.getAttachmentUrl(attachmentId);
		addParam("attachmentUrl", url);
		addParam("imgMassageKey",getValue(imgMassageKey));
	}
	
	/**
	 * 获取国际化数据
	 * 
	 * @param key
	 * @return String
	 */
	public String getValue(String key) {
		String empty = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(key)) {
			int index = key.indexOf("[");
			int index2 = key.indexOf("]");

			if (index != -1 && index2 != -1) {// 国际化数据带参数
				String tagKey = key.substring(0, index);
				String parameter = key.substring(key.indexOf("[") + 1,
						key.indexOf("]"));
				empty = TagUtils.getMessage(tagKey, empty,
						(Object[]) parameter.split(","));
			} else {
				empty = TagUtils.getMessage(key, empty);// 没有参数
			}
		}
		return empty;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

}
