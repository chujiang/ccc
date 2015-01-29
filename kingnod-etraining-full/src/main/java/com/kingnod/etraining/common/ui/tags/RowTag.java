package com.kingnod.etraining.common.ui.tags;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;

import com.kingnod.core.pager.Pager;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.ui.util.HtmlBuilder;
import com.kingnod.etraining.common.ui.util.TagUtils;
/**
 * 表格行属性标签
 * 
 * @author Sam
 *
 */
public class RowTag extends HtmlTag {
	private static final long serialVersionUID = -3903165369185338687L;
	
	/**
	 * 迭代输出记录行时的当前迭代记录对象
	 */
	protected Object currentRow;
	
	/**
	 * 迭代记录索引
	 */
	protected Integer currentRowIndex = 0;
	
	/**
	 * 数据记录迭代器
	 */
	protected Iterator iterator;
	
	/**
	 * 当前记录行的单元格值集
	 */
	protected List cells;	
	
	/**
	 * 行交叉样式，设置单双行有不同的背景色
	 */
	protected String crossClass = "odd,even";
	
	/**
	 * 是否使用交替颜色，默认为true
	 */
	protected String isCrossClass = "true";
	
	
	

	protected GridTag gridTag;

	public int doStartTag() throws JspException {
		if ( !TagUtils.parentIsGridTag(getParent()) )
			throw new JspException("The <k:row/> must in the <k:grid/> within,eg: <k:grid> <k:row /> </k:grid>");
		gridTag = (GridTag) getParent();	
		cells = ListUtils.newList();
		iterator = null;
		currentRow = null;
		currentRowIndex = 0;
		return EVAL_BODY_INCLUDE;
	}
	
	public int doAfterBody() throws JspException {
        try {
            if (iterator == null) {
            	Pager page = gridTag.getPager();
                if (page != null && page.getResult() != null)
                	iterator = page.getResult().iterator();
            }
            
            if (ListUtils.isNotEmpty(cells))
       		 	gridTag.addRow(buildRow());

            if (iterator != null && iterator.hasNext()) {  
            	
                currentRow = iterator.next();                
                currentRowIndex++; 
                pageContext.setAttribute(getVar(), currentRow);               
                return EVAL_BODY_AGAIN;
            }
        } catch (Exception e) {
            throw new JspException("TableTag.doAfterBody() Problem: " + e.getMessage(),e);
        }

        return SKIP_BODY;
    }
	
	
	public int doEndTag() throws JspException {
		iterator = null;
		currentRowIndex = 1;
		return EVAL_PAGE;
	}
	
	/**
	 * 获承迭代记录中的JSP变量定义名称
	 * @return
	 */
	public String getVar() {
		String var = gridTag.getVar();
		return StringUtils.nvl(var,"rowObj");
	}
	
	/**
	 * 构建tr记录行
	 * @return
	 */
	protected Object buildRow() {
		
		HtmlBuilder tr = new HtmlBuilder().tr(3);
		
		setAttribute(tr);
		if (StringUtils.isTrue(isCrossClass)) {
			String[] crossClasses = crossClass.split(",");
			if (crossClasses.length == 2) {
				if (this.currentRowIndex %2 == 1) 
					tr.styleClass(TagUtils.addCssClass(this.getCssClass(), crossClasses[0]));
				else
					tr.styleClass(TagUtils.addCssClass(this.getCssClass(), crossClasses[1]));
			}
		}
		
		tr.close();
		if (ListUtils.isNotEmpty(cells)) {
			for (Iterator<?> it = cells.iterator();it.hasNext();) {
				tr.append(it.next().toString());
			}
			cells.clear();
		}
		return tr.trEnd(3);
	}
	
	/**
	 * 添加一个单元格的值
	 * @param cell
	 */
	public void addCell(Object cell) {
		cells.add(cell);
	}
	
	public Object getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(Object currentRow) {
		this.currentRow = currentRow;
	}
	
	public void release() {
		gridTag = null;
		currentRow = null;
		currentRowIndex = null;
		cells = null;
		iterator = null;
		
		super.release();
		 
	}
	
	public String getCrossClass() {
		return crossClass;
	}

	public void setCrossClass(String crossClass) {
		this.crossClass = crossClass;
	}

	public String getIsCrossClass() {
		return isCrossClass;
	}

	public void setIsCrossClass(String isCrossClass) {
		this.isCrossClass = isCrossClass;
	}
	
}
