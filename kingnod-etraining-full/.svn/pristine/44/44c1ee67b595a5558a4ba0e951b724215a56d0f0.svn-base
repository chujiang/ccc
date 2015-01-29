package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.PopularCourses;
import com.opensymphony.xwork2.util.ValueStack;

public class PopularCoursesTag extends BaseUITag {

	protected String imgSrc;

	protected String titles;

	protected String subTitle;

	protected int stars;

	protected String text;

	private static final long serialVersionUID = -4854923048213359085L;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new PopularCourses(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();
		PopularCourses popularCourses = ((PopularCourses) component);
		popularCourses.setImgSrc(imgSrc);
		popularCourses.setTitles(titles);
		popularCourses.setSubTitle(subTitle);
		popularCourses.setStars(stars);
		popularCourses.setText(text);
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
