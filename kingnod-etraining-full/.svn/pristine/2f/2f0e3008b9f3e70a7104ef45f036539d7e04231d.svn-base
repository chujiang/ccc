package com.kingnod.etraining.common.ui.tags;

import com.kingnod.core.util.ObjectUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.ui.util.HtmlBuilder;
import com.kingnod.etraining.common.ui.util.TagUtils;

/**
 * ID选择列,用于管理页面的ID选择列
 * 
 * @author Sam
 * 
 */
public class SelectorColumnTag extends ColumnTag {

	private static final long serialVersionUID = 7600269388930545188L;

	protected String value;

	{
		setHeaderClass("selectorHeader");
		setCssClass("selectorColumn");
		setCssStyle("padding:0");
	}

	protected Object calcColumnHeaderContent() {
		String t = TagUtils.getMessage(titleKey, title);
		HtmlBuilder selector = createSelector()
				.onclick("kui.checkall('" + name + "',this);").title(t).end();
		return selector.toString();
	}

	protected Object calcCellContent() {
		type = StringUtils.nvl(type, "checkbox");
		if (type.trim().matches("radio|checkbox"))
			return getSelectorComponent();
		return "";
	}

	protected HtmlBuilder createSelector() {
		return new HtmlBuilder().input().type(type).style("margin:auto auto;");
	}

	protected Object getSelectorComponent() {
		HtmlBuilder selModel = createSelector().name(name)
				.value(null!=value?value:ObjectUtils.toString(getColumPropertyValue())).end();
		return selModel;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
