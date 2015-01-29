/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 */
public class Layout extends ClosingUIBean{
  
  private static final String TEMPLATE = "layout-close";
  
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
  protected String labelKey;

  
  /**
   * Layout页签显示值
   */
  protected String label;
  
  
  /**
   * label宽度
   */
  protected String labelWidth;
  
  /**
   * 是否被包含在Section组件中，是的话则将border设置为0。 
   */
  protected boolean isOfSection;
  
  
  public Layout(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  protected String getDefaultTemplate() {
    return TEMPLATE;
  }
  
  public String getDefaultOpenTemplate() {
    return "layout";
  }
  
  public String getTemplateDir() {
    return "com/kingnod/etraining/common/ui/views";
  }
  
  public String getTheme() {

    return "kingnod";
  }

  public void evaluateExtraParams() {
    super.evaluateExtraParams();
    
    addParameter("positions", positions);
    addParameter("layoutPosition", layoutPosition); 
    addParameter("isLayoutLast", isLayoutLast);
    addParameter("layoutCols", layoutCols);  
    addParameter("labelKey", labelKey);  
    addParameter("label", label);  
    addParameter("labelWidth", labelWidth);  
    addParameter("isOfSection",isOfSection);
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
  
	public String getLayoutCols() {
		return layoutCols;
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

	public boolean isOfSection() {
		return isOfSection;
	}

	public void setOfSection(boolean isOfSection) {
		this.isOfSection = isOfSection;
	}

}
