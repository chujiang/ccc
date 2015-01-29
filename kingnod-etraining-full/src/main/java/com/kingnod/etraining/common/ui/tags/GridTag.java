package com.kingnod.etraining.common.ui.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import com.kingnod.core.pager.Pager;
import com.kingnod.core.util.Lang;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.io.IOUtils;
import com.kingnod.etraining.common.ui.util.HtmlBuilder;
import com.kingnod.etraining.common.ui.util.TagUtils;

import freemarker.template.Template;
/**
 * 表格组件标签
 * 
 * @author Sam
 * 
 */
public class GridTag extends HtmlTag {

	private static final long serialVersionUID = 853939740671459717L;

	/**
	 * 是否需要输入分页工具栏，true需要，false不需要。
	 */
	protected Boolean usePager = true;

	/**
	 * 是否需要排序
	 */
	protected Boolean useSort = true;

	/**
	 * 定义一个jsp el引用名，用于迭代输出表格数据时，可以引用此名称进行自定义渲染，用法如：
	 * 
	 * <pre>
	 * &ltk:column name="username" title="" &gt
	 * ${var.username} , Welcome
	 * &lt/k:column&gt;
	 * </pre>
	 */
	protected String var;

	/**
	 * 分页数据
	 */
	protected Pager pager;
	
	/**
	 * pageNo的请求参数名
	 */
	protected String pageNoName;
	
	/**
	 * sort字段的请求参数名
	 */
	protected String sortName;
	
	/**
	 * grid所在的form名称，可以不设置，默认为document.forms[0];
	 */
	protected String form;
	
	/**
	 * sort值字段的请求参数名
	 */
	protected String sortValueName;
	
	/**
	 * 请求的URL地址 
	 */
	protected String actionUrl;
	
	/**
	 * 设置排序的图标
	 */
	protected String imgPath = "/img/ui/grid/";
	
	/**
	 * 自定义一个分页的模板处理，必须是基于freemarker的模板
	 */
	protected String pagerTemplate = "";
	
	/***
	 * 表格标题图标
	 */
	protected String titleIcon = "";
	
	/**
	 * 表格标题图标style class
	 */
	protected String titleIconClass = "titleIcon";
	
	/**
	 * 分页查询时的请求参数名称，如果没有加则默认为'pager'，对应BaseAction中的pager类，如果一个
	 * 页面有多个表格，在Action中声明了多个Page类的话，可以通过声明requestName将分页提交到不同的
	 * Page对象中.
	 */
	protected String requestName = "pager";
	
	/**
	 * 是否使用自定义初始化，如果是的话则会在输出表格后再加入一个脚本的调用，用来初始化这个表格的设置
	 * 
	 */
	protected String isCostomInit;
	
	


	protected HtmlBuilder htmlTBody ;
	protected HtmlBuilder htmlPagerbar;
	protected List columHeaders;
	protected List buttons;
		
	{
		cssClass="kuiGrid";
	}
	
	

	public int doStartTag() throws JspException {
		htmlTBody = new HtmlBuilder();
		htmlPagerbar  = new HtmlBuilder();
		columHeaders = ListUtils.newList();
		buttons  = ListUtils.newList();
		id = TagUtils.generateTableId(pageContext);
		return EVAL_BODY_INCLUDE;
	}	
	
	
	public int doEndTag() throws JspException {
		HtmlBuilder htmlGrid = new HtmlBuilder();
		buildGrid(htmlGrid);
		try { 
			IOUtils.write( htmlGrid.toString(),pageContext.getOut());
			if (StringUtils.isTrue(isCostomInit)) {
				String initScript = String.format("<script>kui.grid.init('%s');</script>",getId() );
				IOUtils.write(initScript,pageContext.getOut());
			}
			htmlGrid = null;
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
	/**
	 * 构建表格HTML
	 * @throws JspException 
	 */
	protected void buildGrid(HtmlBuilder htmlGrid) throws JspException {
		htmlGrid.table(0);setAttribute(htmlGrid);
		htmlGrid.attrs("requestName",requestName,"usePager", usePager,"pageNoName",pageNoName,"sortName",sortName,"sortValueName",sortValueName,"form",form,"actionUrl",actionUrl);
		htmlGrid.attrs(pageToMap());
		htmlGrid.close();
		buildTitle(htmlGrid);
		buildToolbar(htmlGrid);
		buildTHeader(htmlGrid);
		buildTBody(htmlGrid);
		buildTFooter(htmlGrid);
		htmlGrid.tableEnd(0);
		
	}
	
	
	/**
	 * 构建分页工具栏
	 * @param htmlGrid
	 * @throws JspException 
	 */
	protected void buildTFooter(HtmlBuilder htmlGrid) throws JspException { 
		if (usePager) {
		Map root =  pageToMap();
		StringWriter out = new StringWriter();
		Template pagerTemplate = TagUtils.getTemplate(StringUtils.nvl(this.pagerTemplate,"Pagerbar.ftl"));		
		try {
			pagerTemplate.process(root, out);
		} catch (Exception e) { 
			throw Lang.wrapThrow(e,"GridTag.buildTFooter()  is Error!");
		}
		HtmlBuilder tfoot = new HtmlBuilder().tbody(2).styleClass("pagerbar").close().tr(3).close().td(4).colspan(columHeaders.size()+"").close();
		tfoot.append(out.toString());
		tfoot.tdEnd().trEnd(3).tbodyEnd(2);
		htmlGrid.append(tfoot.toString());
		}
		
	}
	/**
	 * 将page对象属性转成map
	 * @return
	 */
	private Map pageToMap() {
		return MapUtils.mapByAarray(
				"page", pager.getPageNo(),
				"pageSize", pager.getPageSize(),
				"totalCount", pager.getTotalCount(),
				"totalPages",pager.getTotalPages(),
				"hasNext",pager.isHasNext(),
				"hasPre",pager.isHasPre(),
				"nextPage",pager.getNextPage(),
				"prePage",pager.getPrePage(),
				"gridId",getId(),
				"sortfield",pager.getOrderBy(),
				"sortvalue",pager.getOrder());
	}

	/**
	 * 构建数据行
	 * @param htmlGrid
	 */
	protected void buildTBody(HtmlBuilder htmlGrid) {
		HtmlBuilder tbody = new HtmlBuilder().tbody(1).styleClass("databody").close();
		tbody.append(htmlTBody).tbodyEnd(1);
		htmlGrid.append(tbody);		
	}

	/**
	 * 构建列表头
	 * @param htmlGrid
	 */
	protected void buildTHeader(HtmlBuilder htmlGrid) {
		HtmlBuilder thead = new HtmlBuilder().thead(1).styleClass("columnHeaders").close().tr(2).close();
		for (Iterator iterator = columHeaders.iterator(); iterator.hasNext();) {
			thead.append(iterator.next().toString());
		}
		thead.trEnd(2).theadEnd(1);		
		htmlGrid.append(thead.toString());
	}

	/**
	 * 构建工具栏
	 * @param htmlGrid
	 */
	protected void buildToolbar(HtmlBuilder htmlGrid) {
		HtmlBuilder thead = new HtmlBuilder().thead(1).styleClass("toolbar").close().tr(2).close().td(3).colspan(columHeaders.size()+"").close();
		for (Iterator iter = buttons.iterator(); iter.hasNext();) {
			thead.append(iter.next().toString());
		}
		thead.tdEnd().trEnd(2).theadEnd(1);
		htmlGrid.append(thead.toString());
		
		
	}
	

	/**
	 * 构建表标题
	 * @param htmlGrid
	 */
	protected void buildTitle(HtmlBuilder htmlGrid) {
		String t = TagUtils.getMessage(titleKey, title);
		if (StringUtils.isNotBlank(t)) {
			HtmlBuilder gridTitle = new HtmlBuilder().tab().caption().styleClass("title").close();
			if (StringUtils.isNotBlank(titleIcon) ) {
				HtmlBuilder titleIconHtml = new HtmlBuilder().img();
				titleIconHtml.src(titleIcon).end();
				gridTitle.append(titleIconHtml);
			} else if (StringUtils.isNotBlank(titleIconClass)) {
				HtmlBuilder titleIconHtml = new HtmlBuilder().span();
				titleIconHtml.styleClass(titleIconClass).close().append("&nbsp;").spanEnd();
				gridTitle.append(titleIconHtml);
			}
			HtmlBuilder titleText = new HtmlBuilder().span();
			titleText.styleClass("titleText").close().append(t).spanEnd();
			
			HtmlBuilder titleRightIcon = new HtmlBuilder().span();
			titleRightIcon.styleClass("titleRight").close().append("&nbsp;").spanEnd();
			gridTitle.append(titleText).append(titleRightIcon).captionEnd();
			htmlGrid.append(gridTitle);
		}
	}

	/**
	 * 添加一个列表头
	 * @param item
	 */
	public void addColumnHeader(Object item) {
		columHeaders.add(item);
	}
	
	/**
	 * 添加一个按钮至工具栏中
	 * @param item
	 */
	public void addButton(Object item) {
		buttons.add(item);
	}
	
	/**
	 * 添加一行记录
	 * @param item
	 */
	public void addRow(Object item) {
		htmlTBody.append(item);
	}
	
	
	/**
	 * 设置表格数据，如果传入的数据为String类型就表示是存在pageContext,request,session等环境中的bean，如果
	 * 是Page类型则认为是已经处理好的分页信息及数据，如果是List类型刚会根据List生成一个Page，不管理之前的数
	 * 据类型是什么，最终都会处理成Page类型给GridTag进行渲染
	 * @param data 表格数据
	 */
	public void setData(Object data) {
		Object o = data;
		if (data instanceof String) {
			o = TagUtils.getObjectFromContext(pageContext, data.toString());			
		}
		if (o instanceof Pager) {
			pager = (Pager)o;
		} else if (o instanceof List) {
			List staticData = ((List)o);
			pager = new Pager();
			pager.setPageNo(1);
			pager.setPageSize(ListUtils.size(staticData));
			pager.setResult(staticData);
			usePager = false;
		} 
			
	}
	
	
	public void release() {		
		pager = null;
		var  = null;
		usePager = null;
		pageNoName = null;
		sortName = null;
		sortValueName = null;
		actionUrl = null;
		buttons = null;
		columHeaders = null;
		htmlPagerbar = null;
		htmlTBody = null;
		super.release();		 
	}
	
	public String getId() {
		return id;
	}
	 
	
	//----------------------------------------------setter and getter--------------------------------

	public Boolean getUsePager() {
		return usePager;
	}

	public void setUsePager(Boolean usePager) {
		this.usePager = usePager;
	}

	public Boolean getUseSort() {
		return useSort;
	}

	public void setUseSort(Boolean useSort) {
		this.useSort = useSort;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	

	public Pager getPager() {
		return pager;
	}


	public String getPageNoName() {
		return pageNoName;
	}

	public void setPageNoName(String pageNoName) {
		this.pageNoName = pageNoName;
	}


	public String getSortName() {
		return sortName;
	}


	public void setSortName(String sortName) {
		this.sortName = sortName;
	}


	public String getSortValueName() {
		return sortValueName;
	}


	public void setSortValueName(String sortValueName) {
		this.sortValueName = sortValueName;
	}


	public String getActionUrl() {
		return actionUrl;
	}


	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public String getPagerTemplate() {
		return pagerTemplate;
	}


	public void setPagerTemplate(String pagerTemplate) {
		this.pagerTemplate = pagerTemplate;
	}


	public String getTitleIcon() {
		return titleIcon;
	}


	public void setTitleIcon(String titleIcon) {
		this.titleIcon = titleIcon;
	}


	public String getTitleIconClass() {
		return titleIconClass;
	}


	public void setTitleIconClass(String titleIconClass) {
		this.titleIconClass = TagUtils.addCssClass(this.titleIconClass, titleIconClass) ;
	}


	public String getForm() {
		return form;
	}


	public void setForm(String form) {
		this.form = form;
	}


	public String getRequestName() {
		return requestName;
	}


	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	
	public String getIsCostomInit() {
		return isCostomInit;
	}


	public void setIsCostomInit(String isCostomInit) {
		this.isCostomInit = isCostomInit;
	}

}
