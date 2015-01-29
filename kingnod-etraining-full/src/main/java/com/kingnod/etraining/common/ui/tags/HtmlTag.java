package com.kingnod.etraining.common.ui.tags;
 
import org.apache.struts2.views.jsp.StrutsBodyTagSupport;

import com.kingnod.etraining.common.ui.util.HtmlBuilder;
import com.kingnod.etraining.common.ui.util.TagUtils;
/**
 * HTMLTag ,封装HTML的相同的属性
 * @author Sam
 *
 */
public abstract class HtmlTag extends StrutsBodyTagSupport{
	private static final long serialVersionUID = -7927037723330608287L;
	
	protected String cssClass;
	protected String cssStyle;
	protected String title;
	protected String titleKey;
	
	protected String onclick;
    protected String ondblclick;
    protected String onmousedown;
    protected String onmouseup;
    protected String onmouseover;
    protected String onmousemove;
    protected String onmouseout;
    protected String onfocus;
    protected String onblur;
    protected String onkeypress;
    protected String onkeydown;
    protected String onkeyup;
    protected String onselect;
    protected String onchange;
    protected String accesskey;
    protected String id;
    protected String name;
    protected String width;
    protected String align;
    
    protected String border;
    protected String cellPadding = "0";
    protected String cellSpacing = "0";
    
    public String getBorder() {
		return border;
	}


	public void setBorder(String border) {
		this.border = border;
	}


	public String getCellPadding() {
		return cellPadding;
	}


	public void setCellPadding(String cellPadding) {
		this.cellPadding = cellPadding;
	}


	public String getCellSpacing() {
		return cellSpacing;
	}


	public void setCellSpacing(String cellSpacing) {
		this.cellSpacing = cellSpacing;
	}

	/**
     * 鼠标称至某一行的样式，即记录行获集的样式
     */
    protected String mouseOutClass;
    /**
     * 
     */
	protected String mouseInClass;
	protected String mouseOutStyle;
	protected String mouseInStyle;
    

	

	protected void setAttribute(HtmlBuilder html,Object...attrs ) {
    	html.id(getId())
    		.border(border)
    		.cellpadding(cellPadding)
    		.cellspacing(cellSpacing)
    		.style(cssStyle)
    		.styleClass(getCssClass())
    		.onclick(onclick)
    		.onchange(onchange)
    		.onkeypress(onkeypress)
    		.onmouseover(onmouseover)
    		.onmouseout(onmouseout)
    		.width(width)
    		.attrs(attrs);
    }
	
	
	public void release() {
		cssClass = null;
		cssStyle = null;
		title = null;
		titleKey = null;
		border = null;
		cellPadding = null;
		cellPadding = null;
		
		
		onclick = null;
	    ondblclick = null;
	    onmousedown = null;
	    onmouseup = null;
	    onmouseover = null;
	    onmousemove = null;
	    onmouseout = null;
	    onfocus = null;
	    onblur = null;
	    onkeypress = null;
	    onkeydown = null;
	    onkeyup = null;
	    onselect = null;
	    onchange = null;
	    accesskey = null;
	    id = null;
	    name = null;
	}
	
	public String getMouseOutClass() {
		return mouseOutClass;
	}

	public void setMouseOutClass(String mouseOutClass) {
		this.mouseOutClass = mouseOutClass;
	}

	public String getMouseInClass() {
		return mouseInClass;
	}

	public void setMouseInClass(String mouseInClass) {
		this.mouseInClass = mouseInClass;
	}

	public String getMouseOutStyle() {
		return mouseOutStyle;
	}

	public void setMouseOutStyle(String mouseOutStyle) {
		this.mouseOutStyle = mouseOutStyle;
	}

	public String getMouseInStyle() {
		return mouseInStyle;
	}

	public void setMouseInStyle(String mouseInStyle) {
		this.mouseInStyle = mouseInStyle;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = TagUtils.addCssClass(this.cssClass, cssClass);
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		return ondblclick;
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnmousedown() {
		return onmousedown;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmouseup() {
		return onmouseup;
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	public String getOnmouseover() {
		return onmouseover;
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmousemove() {
		return onmousemove;
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return onmouseout;
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnfocus() {
		return onfocus;
	}

	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	public String getOnblur() {
		return onblur;
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnkeypress() {
		return onkeypress;
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeydown() {
		return onkeydown;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeyup() {
		return onkeyup;
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnselect() {
		return onselect;
	}

	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getAccesskey() {
		return accesskey;
	}

	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}
    
    

}
