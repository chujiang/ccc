package com.kingnod.etraining.common.ui.components;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.core.criteria.Column;
import com.kingnod.core.criteria.ColumnMapper;
import com.kingnod.core.criteria.impl.AnnotationColumnMapper;
import com.kingnod.core.dict.DataDictItem;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "filterPanel", tldTagClass = "com.kingnod.etraining.common.ui.tags.DictSelectTag", description = "")
public class FilterSimplePanel extends ClosingUIBean {

	public static final String OPEN_TEMPLATE = "filterSimplePanel";
	public static final String TEMPLATE = "filterSimplePane-close";
  
  protected String dictName;
  
  protected List items;
  
  protected String filterNameValue;
  
  protected String filterNameValueType;

  protected String filterKeywordValue;
  
  protected Map<String, String> typeMap;
  
  protected String columnName;
  
  protected ColumnMapper columnMapper;
  
  protected Class entityClass;
  
  protected boolean includeSubFolders;

	public FilterSimplePanel(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
	
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
	
  @SuppressWarnings("unchecked")
public void evaluateExtraParams() {
    super.evaluateExtraParams();
    String filterName = this.request.getParameter("filterName");
    if(null != filterName && !"".equals(filterName)) {
    	columnMapper = new AnnotationColumnMapper();
    	Class<? extends Object> clazz = columnMapper.getColumn(entityClass, filterName).getType();
    	if(null != clazz) {
    		if(clazz.equals(new Date().getClass())) {
            	addParameter("filterNameValueType", clazz);
            } else 
            	addParameter("filterNameValueType", " ");
    	}
    } else {
    	addParameter("filterNameValueType", " ");
    }
    if( null == filterName || "".equals(filterName) ) {
    	addParameter("filterNameValue", " ");
    } else {
        addParameter("filterNameValue", filterName);
    }
    String[] filterKeys = this.request.getParameterValues("filterKeyword");
    String includeSubFolderVal=this.request.getParameter("includeSubFolderVal");
    if(null != filterKeys && filterKeys.length > 0) {
    	if(filterKeys.length == 2) {
    		addParameter("start",filterKeys[0]);
    		addParameter("end",filterKeys[1]);
    		addParameter("allName","");
    		if(!"".equals(includeSubFolderVal)&&includeSubFolderVal!=null){
    			addParameter("includeSubFolderVal", includeSubFolderVal);
    		}
    	} else {
    		addParameter("allName",filterKeys[0]);
    		addParameter("start","");
    		addParameter("end","");
    		if(!"".equals(includeSubFolderVal)&&includeSubFolderVal!=null){
    			addParameter("includeSubFolderVal", includeSubFolderVal);
    		}
    	}
    } else {
    	addParameter("allName","");
    	addParameter("start","");
		addParameter("end","");
		if(!"".equals(includeSubFolderVal)&&includeSubFolderVal!=null){
			addParameter("includeSubFolderVal", includeSubFolderVal);
		}
		
    }
    addParameter("includeSubFolders", includeSubFolders);
    addParameter("items", items);
    addParameter("date", new Date().getClass());
    addParameter("keywordWidth", (int)((((UserAccount)SecurityUtils.getCurrentUser()).getClientScreenWidth()/(float)1024)*120));
    typeMap = new HashMap<String, String>();
    ColumnMapper columnMapper = new AnnotationColumnMapper();
    for(DataDictItem item:(List<DataDictItem>)items){
    	Column column = columnMapper.getColumn(entityClass, item.getValue());
    	if(null == column || "".equals(column)) {
    		typeMap.put(item.getValue(), "");
    	} else {
    		String type = column.getType().getName();
        	typeMap.put(item.getValue(), type);
    	}
    }
    addParameter("typeMap", typeMap);
  }
  
  public void setItems(List items) {
    this.items = items;
  }
  public List getItems() {
    return items;
  }
  
  public String getDictName() {
    return dictName;
  }

  public void setDictName(String dictName) {
    this.dictName = dictName;
  }
  
  public String getFilterNameValue() {
    return filterNameValue;
  }

  public String getFilterKeywordValue() {
    return filterKeywordValue;
  }
  
  public Map<String, String> getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(Map<String, String> typeMap) {
		this.typeMap = typeMap;
	}
	
	public Class getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getFilterNameValueType() {
		return filterNameValueType;
	}

	public boolean isIncludeSubFolders() {
		return includeSubFolders;
	}

	public void setIncludeSubFolders(boolean includeSubFolders) {
		this.includeSubFolders = includeSubFolders;
	}
	
	


}
