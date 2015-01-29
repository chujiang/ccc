/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.dict.DataDictItem;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 */
public abstract class DictSupportBean extends BaseUIBean{

  protected String list;
  protected String listKey;
  protected String listValue;
  protected List<DataDictItem> items;
  protected String value;
  
  public DictSupportBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  public void evaluateExtraParams() {
    super.evaluateExtraParams();
    if (list != null) {
      addParam("list", findString(list));
    }
    if (listKey != null) {
      addParameter("listKey", findString(listKey));
    }
    if (listValue != null) {
      addParameter("listValue", findString(listValue));
    }
    if (items != null && items.size()>0) {
      addParameter("items", items);
    }
    if (value != null) {
      addParameter("value", value);
    }
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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
