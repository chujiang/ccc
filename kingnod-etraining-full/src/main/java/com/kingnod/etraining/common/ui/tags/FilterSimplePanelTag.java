package com.kingnod.etraining.common.ui.tags;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.core.dict.DataDict;
import com.kingnod.core.dict.DataDictItem;
import com.kingnod.core.dict.util.DictUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.HttpParameter;
import com.kingnod.etraining.common.ui.components.FilterSimplePanel;
import com.opensymphony.xwork2.util.ValueStack;

public class FilterSimplePanelTag extends BaseUITag {
  
	private static final long serialVersionUID = -2707620994256464727L;
private String entityType;
  protected String dictName;
  protected String includeSubFolders;

  @Override
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new FilterSimplePanel(stack, req, res);
  }

  protected void populateParams() {
    super.populateParams();
    FilterSimplePanel filterPanel = ((FilterSimplePanel) component);
    filterPanel.setItems(populateItems());
    try {
		filterPanel.setEntityClass(Class.forName(entityType));
		filterPanel.setIncludeSubFolders(StringUtils.isTrue(includeSubFolders));
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
  }

  protected List<DataDictItem> populateItems() {

    List<DataDictItem> items = ListUtils.newList();
    if (StringUtils.isNotEmpty(dictName)) {
      HttpParameter param = HttpParameter.create((HttpServletRequest) pageContext.getRequest());
      DataDict dataDict  = DictUtils.getDataDictByPath(dictName, param.getAll());
      items = dataDict.getItems();
    }
    return items;
  }
  
  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }
  
  public String getDictName() {
    return dictName;
  }

  public void setDictName(String dictName) {
    this.dictName = dictName;
  }

public String getIncludeSubFolders() {
	return includeSubFolders;
}

public void setIncludeSubFolders(String includeSubFolders) {
	this.includeSubFolders = includeSubFolders;
}
  
  

}
