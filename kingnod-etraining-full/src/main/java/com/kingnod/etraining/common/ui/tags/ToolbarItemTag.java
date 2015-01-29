package com.kingnod.etraining.common.ui.tags;

import javax.servlet.jsp.JspException;

import org.apache.struts2.components.UrlProvider;
import org.apache.struts2.components.UrlRenderer;

import com.kingnod.etraining.common.ui.components.Button;
import com.kingnod.etraining.common.ui.util.HtmlBuilder;
import com.kingnod.etraining.common.ui.util.TagUtils;
/**
 * 工具栏按钮标签
 * @author Sam
 *
 */
public class ToolbarItemTag extends HtmlTag {

	private static final long serialVersionUID = 8002974648271191611L;
	
	protected String type;
	
	@Override
	public int doStartTag() throws JspException {
	  if (!TagUtils.parentIsToolbarTag(getParent()))
      throw new JspException("The <k:toolbarItem/> must in the <k:toolbar/> within,eg: <k:toolbar> <k:toolbarItem /> </k:toolbar>");
	  return EVAL_BODY_BUFFERED;
	}
	
	public int doEndTag() throws JspException {
		if (!TagUtils.parentIsToolbarTag(getParent()))
			throw new JspException("The <k:toolbarItem/> must in the <k:toolbar/> within,eg: <k:toolbar> <k:toolbarItem /> </k:toolbar>");
//		ToolbarTag toolbar = (ToolbarTag)getParent();
		GridTag gridTag = (GridTag) findAncestorWithClass(this,GridTag.class);
		gridTag.addButton(buildItem());
		return EVAL_PAGE;
	}

	protected Object buildItem() {
		HtmlBuilder html = new HtmlBuilder().button();
		setAttribute(html);
		html.close();
		html.append(TagUtils.getMessage(titleKey, title));
		return html.buttonEnd();
	}
	
	public void release() {
		type = null;
		super.release();
	}

}
