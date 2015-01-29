/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author huanghaibin
 */
public class Radio extends BaseUIBean {
    final public static String TEMPLATE = "radio";

    protected String fieldValue;

    public Radio(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    @Override
    public void evaluateExtraParams() {
    	super.evaluateExtraParams();
        if (fieldValue != null) {
            addParameter("fieldValue", findString(fieldValue));
        } else {
            addParameter("fieldValue", "true");
        }
        if(null == value){
        	addParameter("value", super.findValue(name));
        }
    }

    protected Class getValueClassType() {
        return Boolean.class; // for checkboxes, everything needs to end up as a Boolean
    }

    @StrutsTagAttribute(description="The actual HTML value attribute of the checkbox.", defaultValue="true")
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

}
