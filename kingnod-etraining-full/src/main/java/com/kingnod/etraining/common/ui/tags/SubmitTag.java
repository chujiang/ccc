
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.kingnod.etraining.common.ui.components.Submit;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Administrator
 */
public class SubmitTag extends AbstractClosingTag {

    private static final long serialVersionUID = 2179281109958301343L;

    protected String action;
    protected String method;
    protected String align;
    protected String type;
    protected String src;
    protected String value;
    protected String nameValue;
    
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Submit(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Submit submit = ((Submit) component);
        submit.setAction(action);
        submit.setMethod(method);
        submit.setAlign(align);
        submit.setType(type);
        submit.setSrc(src);
        submit.setValue(value);
        submit.setValue(nameValue);
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setValue(String value) {
      this.value = value;
    }
    
    public void setNameValue(String nameValue) {
      this.nameValue = nameValue;
    }
}
