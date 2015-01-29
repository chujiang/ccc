package com.kingnod.etraining.common.ui.tags;

import javax.servlet.jsp.JspException;

import com.kingnod.core.util.io.IOUtils;
import com.kingnod.etraining.common.ui.util.TagUtils;

/**
 * 表格工具按钮栏
 * 
 * @author Sam
 *
 */
public class ToolbarTag extends HtmlTag {
 
	private static final long serialVersionUID = -4315218688378943914L;
	 
	public int doStartTag() throws JspException {
		if ( !TagUtils.parentIsGridTag(getParent()) )
			throw new JspException("The <k:toolbar/> must in the <k:grid/> within,eg: <k:grid> <k:toolbar /> </k:grid>");
		return EVAL_BODY_BUFFERED;
	}
	
	public int doEndTag() throws JspException {
	  GridTag gridTag = (GridTag) findAncestorWithClass(this,GridTag.class);
	  if (bodyContent != null) {
      String content = IOUtils.reader2String(bodyContent.getReader());
      gridTag.addButton(content);
    }
	  if (bodyContent != null) {
      bodyContent.clearBody();
	  }
	  return SKIP_BODY;
	}
	
 
	
}
