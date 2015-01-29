
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.Checkbox;
import com.kingnod.etraining.common.ui.components.Radio;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Administrator
 */
public class RadioTag extends BaseUITag {

    private static final long serialVersionUID = -350752809266337636L;

    protected String fieldValue;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Radio(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();
        Radio radio = ((Radio) component);
        radio.setFieldValue(fieldValue);
    }

    public void setFieldValue(String aValue) {
        this.fieldValue = aValue;
    }
}
