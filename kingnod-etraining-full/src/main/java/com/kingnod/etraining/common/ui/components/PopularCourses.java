package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.util.StringUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class PopularCourses extends BaseUIBean {
	final public static String TEMPLATE = "popularCourses";

	protected String imgSrc;

	protected String titles;

	protected String subTitle;

	protected int stars;

	protected String text;

	public PopularCourses(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		if (StringUtils.isNotBlank(imgSrc)) {
			addParameter("imgSrc", this.imgSrc);
		}
		if (StringUtils.isNotBlank(titles)) {
			addParameter("titles", this.titles);
		}
		if (StringUtils.isNotBlank(imgSrc)) {
			addParameter("imgSrc", this.imgSrc);
		}
		if (StringUtils.isNotBlank(subTitle)) {
			addParameter("subTitle", this.subTitle);
		}
		if (StringUtils.isNotBlank(String.valueOf(stars))) {
			addParameter("grade", this.stars);
		}
		if (StringUtils.isNotBlank(text)) {
			addParameter("text", this.text);
		}
		
		addParameter("srcHeader", request.getContextPath());
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public void setText(String text) {
		this.text = text;
	}

}
