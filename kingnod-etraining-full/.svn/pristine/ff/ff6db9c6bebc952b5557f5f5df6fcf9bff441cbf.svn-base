
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.Reset;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 联动下拉框组件，扩展自struts2的UI组件，一个UI组件由一个标签类、UIBean、freemarker模板三部分组成
 * 标签类用于接收用户的参数，UIBean是给freemarker提供参数，至于freemarker模板则是组件的HTML渲染器
 * 
 * @author Administrator
 * 
 */
public class ResetTag extends BaseUITag {

    private static final long serialVersionUID = 4742704832277392108L;

    protected String action;
    protected String method;
    protected String align;
    protected String type;
    protected String nameValue;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Reset(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Reset reset = ((Reset) component);
        reset.setAction(action);
        reset.setMethod(method);
        reset.setAlign(align);
        reset.setType(type);
        reset.setNameValue(nameValue);
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

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
      this.value = value;
    }
    
    public void setNameValue(String nameValue) {
      this.nameValue = nameValue;
    }
}
