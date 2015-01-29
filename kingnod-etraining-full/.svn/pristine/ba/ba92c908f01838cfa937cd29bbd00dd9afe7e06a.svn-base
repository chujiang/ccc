
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.ObjectPicker;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Administrator
 */
public class ObjectPickerTag extends BaseUITag {

  protected String maxlength;
  protected String readonly;
  protected String size;
  protected String testTag;
  protected String action;
  protected String namespace;
  protected String method;
  protected String includeParams;
  protected String nameValue;
  protected String url ;
  //小马后添加
  protected String width ;
  protected String height ;
  protected String pointValue ;
  protected String Parameter ;
  protected String isfunction ;
  protected String mutiSelect ;
  protected String titleKey ;
  protected String showValue;
  protected String dataType ;
  protected String idKey ;
  protected String showType ;
  
	//end
  protected boolean async = false;
  private static final long serialVersionUID = -4854923048213359085L;
  
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new ObjectPicker(stack, req, res);
  }
  
  protected void populateParams() {
    super.populateParams();
    
    ObjectPicker objectPicker = ((ObjectPicker) component);
    objectPicker.setMaxlength(maxlength);
    objectPicker.setReadonly("true");
    objectPicker.setSize(size);
    objectPicker.setTestTag(testTag);
    objectPicker.setNamespace(namespace);
    objectPicker.setAction(action);
    objectPicker.setMethod(method);
    objectPicker.setNameValue(nameValue);
    objectPicker.setAsync(async);
    objectPicker.setHeight(height);
    objectPicker.setWidth(width);
    objectPicker.setIsfunction(isfunction);
    objectPicker.setPointValue(pointValue);
    objectPicker.setMutiSelect(mutiSelect);
    objectPicker.setShowValue(showValue);
    objectPicker.setDataType(dataType);
    objectPicker.setIdKey(idKey);
    objectPicker.setShowType(showType);
  }

	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTestTag() {
		return testTag;
	}

	public void setTestTag(String testTag) {
		this.testTag = testTag;
	}

	public String getAction() {
		return action;
	}

	public String getNamespace() {
		return namespace;
	}

	public String getMethod() {
		return method;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the includeParams
	 */
	public String getIncludeParams() {
		return includeParams;
	}

	/**
	 * @param includeParams the includeParams to set
	 */
	public void setIncludeParams(String includeParams) {
		this.includeParams = includeParams;
	}

	/**
	 * @return the nameValue
	 */
	public String getNameValue() {
		return nameValue;
	}

	/**
	 * @param nameValue the nameValue to set
	 */
	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}

	/**
	 * @return the async
	 */
	public boolean isAsync() {
		return async;
	}

	/**
	 * @param async the async to set
	 */
	public void setAsync(boolean async) {
		this.async = async;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPointValue() {
		return pointValue;
	}

	public void setPointValue(String pointValue) {
		this.pointValue = pointValue;
	}

	public String getParameter() {
		return Parameter;
	}

	public void setParameter(String parameter) {
		Parameter = parameter;
	}

	public String getIsfunction() {
		return isfunction;
	}

	public void setIsfunction(String isfunction) {
		this.isfunction = isfunction;
	}


	public String getMutiSelect() {
		return mutiSelect;
	}

	public void setMutiSelect(String mutiSelect) {
		this.mutiSelect = mutiSelect;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	public String getShowValue() {
		return showValue;
	}

	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getIdKey() {
		return idKey;
	}

	public void setIdKey(String idKey) {
		this.idKey = idKey;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}
	
}
