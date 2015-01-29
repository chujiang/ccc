package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.kingnod.core.util.UUIDUtils;
import com.kingnod.etraining.common.ui.components.Section;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class SectionTag extends AbstractClosingTag {

  private static final long serialVersionUID = 4018245551996059705L;
  
  protected String label = "";
  protected String labelKey = "";
  protected String layoutCols = "";

  @Override
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new Section(stack, req, res);
  }
  

  @Override
  protected void populateParams() {
    super.populateParams();
    Section section = (Section) component;
    section.setLabel(label);
    section.setLabelKey(labelKey);
    section.setLabel(TagUtils.getMessage(labelKey, label));
    
    if(StringUtils.isEmpty(this.id)){
    	section.setId(UUIDUtils.getUUID());
    }
    if(findAncestorWithClass(this, PanelTag.class) != null) {
    	section.setOfPanel(true);
    }
  }



	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}


	public String getLayoutCols() {
		return layoutCols;
	}


	public void setLayoutCols(String layoutCols) {
		this.layoutCols = layoutCols;
	}
  
}
