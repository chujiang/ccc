package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.util.TextProviderHelper;

import com.opensymphony.xwork2.util.ValueStack;

	public class Label extends BaseUIBean {
    final public static String TEMPLATE = "label";

    protected String forAttr;
    
    public Label(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        if (forAttr != null) {
            addParameter("for", findString(forAttr));
        }

        // try value, then key, then name (this overrides the default behavior in the superclass)
        if (value != null) {
            addParameter("nameValue", findString(value));
        } else if (key != null) {
            Object nameValue = parameters.get("nameValue");
            if (nameValue == null || nameValue.toString().length() == 0) {
                // get the label from a TextProvider (default value is the key)
                String providedLabel = TextProviderHelper.getText(key, key, stack);
                addParameter("nameValue", providedLabel);
            }
        } else if (name != null) {
            String expr = completeExpressionIfAltSyntax(name);
            addParameter("nameValue", findString(expr));
        }
    }

    public void setForAttr(String forAttr) {
      this.forAttr = forAttr;
    }
}

