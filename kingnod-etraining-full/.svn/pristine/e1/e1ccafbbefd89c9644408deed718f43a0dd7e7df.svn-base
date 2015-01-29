/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.kingnod.etraining.common.ui.components.Layout;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 *
 */
public class LayoutTag extends AbstractUITag{
  
  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = -7245403785801526916L;
  
  protected Integer positions = 0;
  
  /**
   * 组件在JSP定义的位置
   */
  protected Integer layoutPosition = 0;
  
  /**
   * 组件是否在JSP最后一个定义
   */
  protected Boolean isLayoutLast;
  
  /**
   * Layout的列
   */
  protected String layoutCols;
  
  /**
   * Layout页签显示对应国际化文件的值
   */
  protected String labelKey="";

  
  /**
   * Layout页签显示值
   */
  protected String label="";
  
  
  /**
   * Label宽度
   */
  protected String labelWidth="30%";

  
  public int doEndTag()throws JspException {
    positions = 0;
    return super.doEndTag();
  }

  @Override
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new Layout(stack,req,res);
  }
  
  protected void populateParams() {
    Layout layout = ((Layout) component);
    layout.setLayoutCols(layoutCols);
    layout.setIsLayoutLast(isLayoutLast);
    layout.setPositions(positions);
    layout.setLayoutPosition(layoutPosition);
    layout.setLabelKey(labelKey);
    layout.setLabel(TagUtils.getMessage(labelKey, label));
    layout.setLabelWidth(labelWidth);
    
    SectionTag sectionTag = (SectionTag)findAncestorWithClass(this,SectionTag.class);
    PanelTag panelTag = (PanelTag)findAncestorWithClass(this,PanelTag.class);
    if (sectionTag != null || panelTag != null)
    	layout.setOfSection(true);
    
  }

  public void setPositions(Integer positions) {
    this.positions = positions;
  }

  public void setLayoutPosition(Integer layoutPosition) {
    this.layoutPosition = layoutPosition;
  }

  public void setIsLayoutLast(Boolean isLayoutLast) {
    this.isLayoutLast = isLayoutLast;
  }

  public void setLayoutCols(String layoutCols) {
    this.layoutCols = layoutCols;
  }

	public String getLabelKey() {
		return labelKey;
	}
	
	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(String labelWidth) {
		this.labelWidth = labelWidth;
	}

}
