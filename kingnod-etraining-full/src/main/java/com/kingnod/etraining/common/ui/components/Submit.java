package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.FormButton;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class Submit extends FormButton {

    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(Submit.class);
    final public static String OPEN_TEMPLATE = "submit";
    final public static String TEMPLATE = "submit-close";
    
    protected String src;
    protected String value;
    protected String nameValue;

    public Submit(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
      return OPEN_TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }
   
    public String getTemplateDir() {
      return "com/kingnod/etraining/common/ui/views";
    }
    
    public void evaluateParams() {
      if ((key == null) && (value == null)) {
          value = "Submit";
      }

      if (((key != null)) && (value == null)) {
          this.value = "%{getText('"+key +"')}";
      }
      super.evaluateParams();
    }
    
    /**
     * 设置默认主题为kingnod
     */
    public String getTheme() {
        return "kingnod";
    }
    
    public void evaluateExtraParams() {
      super.evaluateExtraParams();
      if (src != null){
        addParameter("src", findString(src));
      }
      if (value != null){
        addParameter("value", findString(value));
      }
      if (nameValue != null){
        addParameter("nameValue", findString(nameValue));
      }
    }

    @Override
    protected boolean supportsImageType() {
      return true;
    }

    public void setValue(String value) {
      this.value = value;
    }
    
    public void setSrc(String src) {
      this.src = src;
    }
    
    public void setNameValue(String nameValue) {
      this.nameValue = nameValue;
    }
}

