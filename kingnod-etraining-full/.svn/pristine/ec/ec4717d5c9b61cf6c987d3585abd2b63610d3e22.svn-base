
package com.kingnod.etraining.common.ui.components;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.struts2.views.annotations.StrutsTag;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "select", tldTagClass = "com.kingnod.etraining.common.ui.tags.DictSelectTag", description = "")
public class DictSelect extends BaseUIBean {
    
    /**
     * 指定要使用哪个预设置的数据字典，定义格式为:字典名称.数据字典名称，如dict.dept对应 DictConfig.xml中的 <dictConfig name="">
     * 这里的name对应dict <dynamic name=""/> 这里的name对应dept < / dictConfig>
     */
    protected String dictName;
    
    /**
     * 当指定此属性为true时，而此控件又是通过其他<select>联动而刷新，也要触发 并联动指定要被刷新的<select>
     */
    protected String chainable;
    
    /**
     * 指定要被刷新的控件，可以声明多个并默认用','作分隔符,也可以指定自己的分隔符
     * 
     */
    protected String target;
    
    /**
     * 指定自己的分隔符
     */
    protected String splitChar;
    
    /**
     * 指定是否要增加一个空白<option>，取值为'true' or 'false'
     * 
     * @param empty
     */
    protected String emptyOption;
    
    /**
     * 指定增加的空白<option>要显示的文本
     */
    protected String emptyOptionText;
    
    /**
     * 指定要过滤的参数
     */
    protected String filterValues;
    
    /**
     * 在联动刷新别的组件之前要调用的javascript函数
     */
    protected String beforeChain;
    
    /**
     * 联动刷新数据时需要提交的参数，也相当于组件的名称或者ID
     */
    protected String chainParam;
    
    /**
     * 指定从各个域中取得将要进行渲染的数据
     */
    @SuppressWarnings("unchecked")
    protected List items;
    
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
    
    protected String value;
    
    /**
     * 刷新页面时，客户端提交的选中的值
     */
    protected Map<String, String> selectedValues;
    
    public DictSelect(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {

        super(stack, request, response);
    }
    
    public void evaluateExtraParams() {

        super.evaluateExtraParams();
        addParameter("items", items);
        
        if (this.multiple != null) {
            addParameter("multiple", multiple);
        }
        
        if (size != null) {
            addParameter("size", size);
        }
        
        if (value != null) {
          addParameter("value", value);
        }
        
        if (dictName != null) {
            addParameter("dictName", dictName);
        }
        
        if (beforeChain != null) {
            addParameter("beforeChain", beforeChain);
        }
        
        if (chainable != null) {
            addParameter("chainable", chainable);
        }
        
        if (multipleStyle != null) {
            addParameter("multipleStyle", multipleStyle);
        }
        
        if (target != null) {
            addParameter("target", target);
        }
        
        if (emptyOption != null) {
            addParameter("emptyOption", emptyOption);
        }
        
        if (emptyOptionText != null) {
            addParameter("emptyOptionText", emptyOptionText);
        }
        
        if (filterValues != null) {
            addParameter("filterValues", filterValues);
        }
        
        if (splitChar != null) {
            addParameter("splitChar", splitChar);
        }
        
        if (!MapUtils.isEmpty(selectedValues)) {
            addParameter("selectedValues", selectedValues);
        }else{
        	if(parameters.containsKey("nameValue") && null != parameters.get("nameValue")){
        		selectedValues.put(parameters.get("nameValue").toString(), parameters.get("nameValue").toString());
        		addParameter("selectedValues", selectedValues);
        	}
        }
        
    }
    
    public String getTarget() {

        return target;
    }
    
    public void setTarget(String target) {

        this.target = target;
    }
    
    public String getListKey() {

        return "name";
    }
    
    public String getListValue() {

        return "value";
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
    
    public void setEmptyOptionText(String emptyOptionText) {

        this.emptyOptionText = emptyOptionText;
    }
    
    @Override
    protected String getDefaultTemplate() {

        return "DictSelect";
    }
    
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
    
    @SuppressWarnings("unchecked")
    public List getItems() {

        return items;
    }
    
    @SuppressWarnings("unchecked")
    public void setItems(List items) {

        this.items = items;
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
    
    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public Map<String, String> getSelectedValues() {

        return selectedValues;
    }
    
    public void setSelectedValues(Map<String, String> selectedValues) {

        this.selectedValues = selectedValues;
    }
}
