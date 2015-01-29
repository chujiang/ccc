package com.kingnod.etraining.common.ui.tags;

import com.kingnod.core.pager.Pager;

/**
 * 表格序号列
 * 
 * @author Sam
 *
 */
public class SerialNumberColumnTag extends ColumnTag {
 
	private static final long serialVersionUID = 8165408626501914957L;

	{
		setHeaderClass("serialNumberHeader");
		width = "20px";
		setCssClass("serialNumberData");
	}
	
	protected Object calcCellContent() {
		Pager page = rowTag.gridTag.getPager();
		int start = 0;
		if (rowTag.gridTag.usePager)
			start = (page.getPageNo()-1)*page.getPageSize();
		return rowTag.currentRowIndex + start;
	}
	
	protected Object calcColumnHeaderContent() {
		return "&nbsp;";
	}
	
}
