package com.kingnod.etraining.common.ui.components;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.components.ListUIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name="checkboxlist", tldTagClass="org.apache.struts2.views.jsp.ui.CheckboxListTag", description="Render a list of checkboxes")
	public class CheckboxList extends BaseUIBean {
    final public static String TEMPLATE = "checkboxlist";
    
    /**
     * 指定要使用哪个预设置的数据字典，定义格式为:字典名称.数据字典名称，如dict.dept对应 DictConfig.xml中的 <dictConfig name="">
     * 这里的name对应dict <dynamic name=""/> 这里的name对应dept < / dictConfig>
     */
    protected String dictName;
    
    /**
     * 指定从各个域中取得将要进行渲染的数据
     */
    @SuppressWarnings("unchecked")
    protected List items;

    /**
     * 刷新页面时，客户端提交的选中的值
     */
    protected Map<String, String> selectedValues;

    public CheckboxList(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    public void evaluateExtraParams() {

        super.evaluateExtraParams();
		addParameter("items", items);
		addParameter("dictName", dictName);
		if (!MapUtils.isEmpty(selectedValues)) {
            addParameter("selectedValues", selectedValues);
        }else{
        	if(parameters.containsKey("nameValue") && null != parameters.get("nameValue")){
        		String[] tmpValues = StringUtils.split((String)parameters.get("nameValue"), ',');
        		for(String tmpValue:tmpValues){
        			tmpValue = tmpValue.trim();
        			selectedValues.put(tmpValue, tmpValue);
        		}
        		addParameter("selectedValues", selectedValues);
        	}
        }
        
    }

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public Map<String, String> getSelectedValues() {
		return selectedValues;
	}

	public void setSelectedValues(Map<String, String> selectedValues) {
		this.selectedValues = selectedValues;
	}
    
}

