/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.dict.DataDictItem;
import com.kingnod.core.util.reflect.BeanUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 */
public class RadioList extends DictSupportBean {
  
  final public static String TEMPLATE = "radiolist";
  
  public RadioList(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }
  
  @Override
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		if(!StringUtils.isEmpty(list)){
			if(null != this.findValue(list) && this.findValue(list) instanceof List){
				List result = (List)this.findValue(list);
				List<DataDictItem> items = new ArrayList<DataDictItem>();
				for(Object obj:result){
					Object id = BeanUtils.getAnyProperty(obj, this.listKey);
					Object value = BeanUtils.getAnyProperty(obj, this.listValue);
					items.add(new DataDictItem(String.valueOf(value), String.valueOf(id)));
				}
				addParam("items", items);
			}
		}
		if(null != this.value){
			addParam("nameValue", this.value);
		}
	}
  
  
  @Override
  protected String getDefaultTemplate() {
    return TEMPLATE;
  }
  
}
