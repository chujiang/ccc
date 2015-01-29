package com.kingnod.etraining.common.ui.tags;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.kingnod.core.dict.DataDict;
import com.kingnod.core.dict.DataDictItem;
import com.kingnod.core.dict.util.DictUtils;
import com.kingnod.core.util.web.HttpParameter;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ui.util.TagUtils;

public abstract class DictSupportTag extends BaseUITag {

	private static final long serialVersionUID = 6093152949751251691L;
	protected String dictName;
	protected String dictParams;
	protected String list;
	protected String listKey;
	protected String listValue;
	protected List<DataDictItem> items;

	protected void populateParams() {
		super.populateParams();
		initDataDict();
	}

	protected void initDataDict() {
		if (StringUtils.isNotBlank(dictName)) {			
			DataDict dict = TagUtils.getDataDict(dictName, dictParams, (HttpServletRequest) pageContext.getRequest());
			if (dict != null) {
				Struts2Utils.getValueStack().set("dataDict", dict.getItems());
				list = "dataDict";
				listKey = "value";
				listValue = "name";
				items = dict.getItems();
			}
		}
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getListKey() {
		return listKey;
	}

	public void setListKey(String listKey) {
		this.listKey = listKey;
	}

	public String getListValue() {
		return listValue;
	}

	public void setListValue(String listValue) {
		this.listValue = listValue;
	}

	public List<DataDictItem> getItems() {
		return items;
	}

	public void setItems(List<DataDictItem> items) {
		this.items = items;
	}

	public String getDictParams() {
		return dictParams;
	}

	public void setDictParams(String dictParams) {
		this.dictParams = dictParams;
	}
}
