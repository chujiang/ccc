
package com.kingnod.etraining.common.ui.tags;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.core.dict.DataDict;
import com.kingnod.core.dict.DataDictItem;
import com.kingnod.core.util.ArrayUtils;
import com.kingnod.core.util.ObjectUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.reflect.BeanUtils;
import com.kingnod.core.util.reflect.ClassWrapper;
import com.kingnod.etraining.common.ui.components.CheckboxList;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * CheckboxList 组件
 * 
 * @author Liu
 * 
 */
public class CheckboxListTag extends BaseUITag {

    private static final long serialVersionUID = 4023034029558150010L;
    
    /**
     * 指定要使用哪个预设置的数据字典，定义格式为:字典名称.数据字典名称，如dict.dept
     */
    protected String dictName;
    
    /**
     * 传给数据字典的参数
     */
    protected String dictParams;
    /**
     * 指定从各个域中取得将要进行渲染的数据,也可以直接是基于jstl的表达式语言定义的list
     */
    protected Object list;
    
    /**
     * 对应要渲染的< option >中的text
     */
    protected String listKey;
    
    /**
     * 对应要渲染的< option >中的value
     */
    protected String listValue;
    
    /**
     * 直接定义一个值
     */
    //protected Object value;
    
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new CheckboxList(stack, req, res);
    }

    protected void populateParams() {

        super.populateParams();
        
        CheckboxList cbList = ((CheckboxList) component);
        cbList.setDictName(dictName);
        cbList.setItems(populateItems());
        cbList.setSelectedValues(calculateSelectedValues());
        
    }
    

    protected List<DataDictItem> populateItems() {

        List<DataDictItem> items = ListUtils.newList();
        if (StringUtils.isNotEmpty(dictName)) {
        	DataDict dataDict  = TagUtils.getDataDict(dictName, dictParams, (HttpServletRequest) pageContext.getRequest());
        	items = dataDict.getItems();
        } else if (list != null) {
            if (list instanceof String) {
                Object listValues = pageContext.findAttribute(list.toString());
                if (list == null) {
                    listValues = pageContext.getRequest().getAttribute(list.toString());
                }
                list = listValues;
            }
            this.listKey = StringUtils.nvl(this.listKey, "name");
            this.listValue = StringUtils.nvl(this.listValue, "value");
            if (list instanceof List) {
                Iterator iter = ((List) list).iterator();
                while (iter.hasNext()) {
                    Object item = iter.next();
                    if (item instanceof DataDictItem) {
                        items.add((DataDictItem) item);
                    } else {
                        DataDictItem itemD = new DataDictItem();
                        if (item instanceof Map) {
                            itemD.setName(ObjectUtils.toString(((Map) item).get(this.listValue), ""));
                            itemD.setValue(ObjectUtils.toString(((Map) item).get(this.listKey), ""));
                        } else {
                            itemD.setName(ObjectUtils.toString(BeanUtils.getAnyProperty(item,
                                    this.listValue), ""));
                            itemD.setValue(ObjectUtils.toString(BeanUtils.getAnyProperty(item, this.listKey), ""));
                        }
                        items.add(itemD);
                    }
                }
            }
        }
        // 确定传给freemarker模板不允许空值
        for (DataDictItem di : items) {
            if (di != null) {
                if (di.getName() == null)
                    di.setName("");
                if (di.getValue() == null)
                    di.setValue("");
                if (di.getGroup() == null)
                    di.setGroup("");
            }
        }
        return items;
    }
    
    @SuppressWarnings("unchecked")
	protected Map<String, String> calculateSelectedValues() {

        String[] match = {};
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Object bean = null;
        if (StringUtils.contains(name, ".")) {
            String beanName = StringUtils.substringBefore(name, ".");
            bean = request.getAttribute(beanName);
            if (bean == null) {
                bean = getStack().findValue(beanName);
            }
        }
        
        if (bean != null) {
            try {
                match = BeanUtils.getArrayProperty(bean, StringUtils.substringAfterLast(name, "."));
                if(null != match && match.length > 0){
                	match[0] = StringUtils.remove(match[0], ' ');
                	match = StringUtils.splitIgnoreBlank(match[0], ",");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            
        } else {
            match = pageContext.getRequest().getParameterValues(name);
        }
        
        if (match == null) {
            if (value != null) {
                if (value instanceof String) {
                    match = StringUtils.split(value.toString(), ',');
                }/* else if (value instanceof List) {
                    match = (String[]) ListUtils.toArray((List) value);                    
                }*/ else if (ClassWrapper.wrap(value).isPrimitiveNumber()) {
                	match = ArrayUtils.of(value.toString());
                }
            } 
            if (match == null)
                match = new String[0];
        }
        Map<String, String> values = MapUtils.newMap();
        for (String s : match) {
            values.put(s, s);
        }

        return values;
        
    }

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
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

	public String getDictParams() {
		return dictParams;
	}

	public void setDictParams(String dictParams) {
		this.dictParams = dictParams;
	}

	/*public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}*/
    
}
