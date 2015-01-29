package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.kingnod.core.util.UUIDUtils;
import com.kingnod.etraining.common.ui.components.Panel;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class PanelTag extends AbstractClosingTag {

	private static final long serialVersionUID = 4018245551996059705L;

	protected String label = "";
	protected String labelKey = "";
	protected String panelCols = "";

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new Panel(stack, req, res);
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		Panel panel = (Panel) component;
		panel.setLabel(getLabelValue(label,labelKey));
		if (StringUtils.isEmpty(this.id)) {
			panel.setId(UUIDUtils.getUUID());
		}
	}
	
	/**
	 * 获取LabelKey
	 * @param label
	 * @param labelKey
	 * @return String
	 */
	public String getLabelValue(String label,String labelKey){
		if(StringUtils.isNotEmpty(labelKey)){
			return TagUtils.getValue(labelKey);
		}else if(StringUtils.isNotEmpty(label)){
			return label;
		}
		return StringUtils.EMPTY;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public String getPanelCols() {
		return panelCols;
	}

	public void setPanelCols(String panelCols) {
		this.panelCols = panelCols;
	}

}
