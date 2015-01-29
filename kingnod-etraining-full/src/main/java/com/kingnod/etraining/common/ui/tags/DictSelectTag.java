
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
import com.kingnod.etraining.common.ui.components.DictSelect;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 联动下拉框组件，扩展自struts2的UI组件，一个UI组件由一个标签类、UIBean、freemarker模板三部分组成
 * 标签类用于接收用户的参数，UIBean是给freemarker提供参数，至于freemarker模板则是组件的HTML渲染器
 * 
 * @author Sam
 * 
 */
public class DictSelectTag extends BaseUITag {
    
    /**
     * 指定要使用哪个预设置的数据字典，定义格式为:字典名称.数据字典名称，如dict.dept
     */
    protected String dictName;
    
    /**
     * 取某个数据字典时传的参数。数据字典会将此参数传给取数据字典的服务接口对象。
     * 参数定义为：‘参数名：参数值，参数名2：参数值2’，如下：
     * <pre>
     * username:${username},desc:'ffff'
     * </pre>
     */
    protected String dictParams;
    
    /**
     * 当指定此属性为true时，而此控件又是通过其他<select>联动而刷新，也要触发 并联动指定要被刷新的<select>
     */
    protected String chainable;
    
    /**
     * 指定要被刷新的目标控件，可以声明多个并默认用','作分隔符,也可以指定自己的分隔符
     * 
     */
    protected String target;
    
    /**
     * 指定自己的分隔符
     */
    protected String splitChar;
    
    /**
     * 指定是否要增加一个空白<option>
     * 
     * @param empty
     */
    protected String emptyOption;
    
    /**
     * 指定增加的空白< option >要显示的文本
     */
    protected String emptyOptionText;
    
    /**
     * 指定要过滤的参数，在渲染之前要去掉的值
     */
    protected String filterValues;
    
    /**
     * 在联动刷新别的组件之前要调用的javascript函数
     */
    protected String beforeChain;
    
    /**
     * 联动刷新数据时需要的参数，正常情况下应该是
     */
    protected String chainParam;
    
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
     * 是否可多选框
     */
    protected String multiple;
    
    /**
     * 多选的样式
     */
    protected String multipleStyle;
    
    /**
     * 下拉列表的条目数
     */
    protected String size;
    
    /**
     * 直接定义一个值
     */
    protected Object value;
    
    public String getDictName() {

        return dictName;
    }
    
    public void setDictName(String dictName) {

        this.dictName = dictName;
    }
    
    public String getChainable() {

        return chainable;
    }
    
    public void setChainable(String chainable) {

        this.chainable = chainable;
    }
    
    public String getSplitChar() {

        return splitChar;
    }
    
    public void setSplitChar(String splitChar) {

        this.splitChar = splitChar;
    }
    
    public String getEmptyOption() {

        return emptyOption;
    }
    
    public void setEmptyOption(String emptyOption) {

        this.emptyOption = emptyOption;
    }
    
    public String getEmptyOptionText() {

        return emptyOptionText;
    }
    
    public String getTarget() {

        return target;
    }
    
    public void setTarget(String target) {

        this.target = target;
    }
    
    public void setEmptyOptionText(String emptyOptionText) {

        this.emptyOptionText = emptyOptionText;
    }
    
    public String getFilterValues() {

        return filterValues;
    }
    
    public void setFilterValues(String filterValues) {

        this.filterValues = filterValues;
    }
    
    public String getBeforeChain() {

        return beforeChain;
    }
    
    public void setBeforeChain(String beforeChain) {

        this.beforeChain = beforeChain;
    }
    
    public String getChainParam() {

        return chainParam;
    }
    
    public void setChainParam(String chainParam) {

        this.chainParam = chainParam;
    }
    
    public String getMultiple() {

        return multiple;
    }
    
    public void setMultiple(String multiple) {

        this.multiple = multiple;
    }
    
    public String getMultipleStyle() {

        return multipleStyle;
    }
    
    public void setMultipleStyle(String multipleStyle) {

        this.multipleStyle = multipleStyle;
    }
    
    public String getSize() {

        return size;
    }
    
    public void setSize(String size) {

        this.size = size;
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
    
    public Object getValue() {

        return value;
    }
    
    public void setValue(Object value) {

        this.value = value;
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

	private static final long serialVersionUID = -4854923048213359085L;
    
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {

        return new DictSelect(stack, req, res);
    }
    
    protected void populateParams() {

        super.populateParams();
        
        DictSelect select = ((DictSelect) component);
        select.setEmptyOption(emptyOption);
        select.setEmptyOptionText(emptyOptionText);
        select.setSize(size);
        select.setMultiple(multiple);
        select.setMultipleStyle(multipleStyle);
        select.setChainable(chainable);
        select.setTarget(target);
        select.setChainParam(chainParam);
        select.setBeforeChain(beforeChain);
        select.setDictName(dictName);
        select.setItems(populateItems());
        select.setSelectedValues(calculateSelectedValues());
        select.setViewText(calculateSelectedText(select.getItems()));
        
    }
    
    protected String calculateSelectedText(List<DataDictItem> all) {
    	Map<String,String> values = calculateSelectedValues();
    	if (MapUtils.isNotEmpty(values)) {
    		List<String> valueList = ListUtils.newList();
    		Map<String,DataDictItem> allMap = MapUtils.from(all, "value");
    		if(null != allMap){
    			for (String s : values.keySet()) {
    				if(null != allMap.get(s)){
    					valueList.add(allMap.get(s).getName());
    				}
    			}
    		}
    		return StringUtils.join(valueList,",");
    	}
    	return "";
    }
     
    
    protected List<DataDictItem> populateItems() {

        List<DataDictItem> items = ListUtils.newList();
        if (StringUtils.isNotEmpty(dictName)) {
        	DataDict dataDict  = 
        		TagUtils.getDataDict(dictName, dictParams, (HttpServletRequest) pageContext.getRequest());
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
        //根据filterValues过滤不需要的选项
        if (filterValues != null) {
        	List<DataDictItem> filteredList = ListUtils.newList();
        	String[] fValues = filterValues.split(",");
        	Map<String,String> filterMap = MapUtils.newMap();
        	for (String f : fValues)
        		filterMap.put(f, f);
        	for (DataDictItem item : items) {
        		if (filterMap.get(item.getValue()) == null) {
        			filteredList.add(item);
        		}
        	}
        	items = filteredList;
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
                } else if (value instanceof List) {
                    match = (String[]) ListUtils.toArray((List) value);                    
                } else if (ClassWrapper.wrap(value).isPrimitiveNumber()) {
                	match = ArrayUtils.of(value.toString());
                }
            } else if ("true".equalsIgnoreCase(getEmptyOption())) {
                match = new String[] {"" };
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
}
