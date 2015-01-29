package com.kingnod.etraining.common.ui.tags;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import com.kingnod.core.pager.Pager;
import com.kingnod.core.util.ObjectUtils;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.io.IOUtils;
import com.kingnod.core.util.reflect.BeanUtils;
import com.kingnod.etraining.common.service.SysParameterService;
import com.kingnod.etraining.common.ui.util.CellValueCalculator;
import com.kingnod.etraining.common.ui.util.HtmlBuilder;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.kingnod.etraining.security.entity.UserAccount;

/**
 * 表格列标签组件
 * 
 * @author Sam
 * 
 */
public class ColumnTag extends HtmlTag {

	private static final long serialVersionUID = -4025912292065572181L;

	/**
	 * 字段名称，对应要输出的POJO的属性
	 */
	protected String name;

	/**
	 * 表格列标题
	 */
	protected String title;

	/**
	 * 列标题消息Key
	 */
	protected String titleKey;

	/**
	 * 数据类型
	 */
	protected String type;

	/**
	 * 数据格式
	 */
	protected String format;

	/**
	 * 是否要支持排序
	 */
	protected String sortable;

	/**
	 * 此列的排序字段，排序不一定要是显示的字段
	 */
	protected String sortfield;

	/**
	 * 是否支持可编辑
	 */
	protected String editable;

	/**
	 * 关联的数据字典的值
	 */
	protected String dictName;

	/**
	 * 传给数据字典的参数
	 */
	protected String dictParams;

	/**
	 * 表头样式表
	 */
	protected String headerStyle;

	/**
	 * 可见长度
	 */
	protected String contentLimit;
	
	/**
	 * 如果单元格的值为空时，使用此指定的值作显示，支持直接从资源文件里面取某个消息key
	 * 取消息的格式为:@yourMessageKey
	 */
	protected String nullText;

	/**
	 * 表头样式表class
	 */
	protected String headerClass = "columnHeader";

	protected RowTag rowTag;

	public int doStartTag() throws JspException {
		if (!TagUtils.hasRowTagWrapped(this))
			throw new JspException(
					"The &lt;k:column/&gt; must in the &lt;k:row/&gt; within,eg: &lt;k:row&gt; &lt;k:column /&gt; &lt;/k:row&gt;");
		if ("date".equals(type) && null == format) {
			this.format = SysParameterUtils
					.getString(SysParameterService.SYS_DATETIME_FORMAT);
		}
		rowTag = (RowTag) this.findAncestorWithClass(this, RowTag.class);
		return EVAL_BODY_BUFFERED;
	}

	public int doEndTag() throws JspException {
		try {
			GridTag gridTag = rowTag.gridTag;

			// 如果当前迭代的记录为空,输出表头
			Object currRow = rowTag.getCurrentRow();
			if (currRow == null) {
				gridTag.addColumnHeader(buildColumnHeader());
			} else {
				rowTag.addCell(buildCell());
			}

			if (bodyContent != null) {
				bodyContent.clearBody();
			}
		} catch (Exception e) {
			throw new JspException("ColumnTag.doEndTag() Problem: "
					+ e.getMessage(), e);
		}

		return SKIP_BODY;
	}

	/**
	 * 构建单元格的值
	 * 
	 * @return
	 */
	protected Object buildCell() {
		HtmlBuilder td = new HtmlBuilder().td(3);
		setAttribute(td);
		td.close();
		// update by maxudong 开始控制字段长度
		td.append(buildTdDivStart());

		td.append(calcCellContent());

		// update by maxudong  控制结束
		td.append(buildTdDivEnd());

		td.tdEnd();
		return td.toString();
	}

	/**
	 * 构建单元显示字符数量 ,contentLimit 为auto时调用
	 * @author maxudong
	 * @return
	 */
	protected String buildTdDivStart() {
		if (!StringUtils.isEmpty(contentLimit) && "auto".equals(contentLimit)) {
			String divStart = "<div style='width:"
					+ super.width
					+ "; white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>";
			return divStart;
		}
		return "";
	}

	/**
	 * 构建单元显示字符数量 end
	 * @author maxudong
	 * @return
	 */
	protected String buildTdDivEnd() {
		if (!StringUtils.isEmpty(contentLimit) && "auto".equals(contentLimit)) {
			String divEnd = "</div>";
			return divEnd;
		}
		return "";
	}

	/**
	 * 构建表头
	 * 
	 * @return
	 */
	protected Object buildColumnHeader() {
		// 如果是需要排序的列的话，需要加一个<a>
		Boolean isSortColumn = StringUtils.isTrue(sortable);
		if (isSortColumn)
			setHeaderClass("sortColumnHeader");

		HtmlBuilder th = new HtmlBuilder().th(3);
		if(!StringUtils.isEmpty(contentLimit)){
			//update by maxudong 判断contentLimit特殊值时处理
			if(!"other".equals(contentLimit) && !"auto".equals(contentLimit))
			 contentLimit = String.valueOf((int)((((UserAccount)SecurityUtils.getCurrentUser()).getClientScreenWidth()/(float)1024)*Integer.valueOf(contentLimit)));
		}
		th.attrs("sortable", sortable, "name", name, "class", getHeaderClass(),
				"style", headerStyle, "width", getWidth(), "nowrap", "nowrap", "contentLimit", contentLimit, "align", SysParameterUtils.getString("sys.grid_title_align"));
		th.close().div().close();
		if (isSortColumn)
			th.a()
					.href(String.format(
							"javascript:void(kui.grid.switchSort('%s','%s'));",
							rowTag.gridTag.getId(),
							StringUtils.nvl(sortfield, name))).close();
		th.append(calcColumnHeaderContent());
		th.append(calcSortInfo());
		if (isSortColumn)
			th.aEnd();
		th.divEnd().thEnd();
		return th;
	}

	/**
	 * 计算排序的条件
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected Object calcSortInfo() {
		Pager p = rowTag.gridTag.getPager();
		String sortfieldName = StringUtils.nvl(sortfield, name);
		if (p != null
				&& StringUtils.equalsIgnoreCase(p.getOrderBy(), sortfieldName)
				&& StringUtils.isTrue(sortable)) {
			HtmlBuilder sortImg = new HtmlBuilder().img();
			Boolean isDown = StringUtils.equalsIgnoreCase("desc", p.getOrder());
			sortImg.src(getSortImg(isDown));
			return sortImg.end().toString();
		}
		return "";
	}

	/**
	 * 获取排序的图标
	 * 
	 * @param isDown
	 * @return
	 */
	protected String getSortImg(boolean isDown) {
		String imgPath = ((HttpServletRequest) pageContext.getRequest())
				.getContextPath() + rowTag.gridTag.imgPath;
		if (isDown) {
			return imgPath + "desc.gif";
		}
		return imgPath + "asc.gif";
	}

	/**
	 * 计算列头的显示内容
	 * 
	 * @return
	 */
	protected Object calcColumnHeaderContent() {
		String empty = "left".equals(SysParameterUtils.getString("sys.grid_title_align"))?"&nbsp;":"";
		return empty + TagUtils.getMessage(titleKey, title);
	}

	/**
	 * 计算单元格内容
	 * 
	 * @return
	 */
	protected Object calcCellContent() {
		return calcCellValue();
	}

	/**
	 * 计算单元格的值
	 * 
	 * @return
	 */
	protected Object calcCellValue() {
		if (getBodyContent() != null) {
			return readBodyContent();
		}
		Object value = getColumPropertyValue();
		if (value == null && StringUtils.isNotBlank(nullText)) {
			return calcNullText();
		}
		if (StringUtils.isNotBlank(dictName)) {
			value = getValueFromDict(ObjectUtils.toString(value));
		}
		return new CellValueCalculator(type, format, value).calculateValue();
	}
	
	protected String calcNullText() {
		if (nullText.matches("\\s*[@].*")) {
			String key = StringUtils.substringAfter(nullText, "@").trim();
			return TagUtils.getMessage(key, "");
		}
		return null;
	}

	/**
	 * 获取当前列的原生值，没有经过处理的值
	 * 
	 * @return
	 */
	protected Object getColumPropertyValue() {
		Object currRow = rowTag.getCurrentRow();
		if (currRow instanceof Map) {
			return ((Map) currRow).get(name);
		}
		return BeanUtils.getAnyProperty(currRow, name);
	}

	/**
	 * 从数据字典服务中取得对应的值
	 * 
	 * @return
	 */
	protected Object getValueFromDict(String value) {
		if (StringUtils.isNotBlank(dictName)) {
			return TagUtils.getDataDictItemName(dictName, dictParams, value,
					(HttpServletRequest) pageContext.getRequest());
		}
		return null;
	}

	/**
	 * 读取标签内容
	 * 
	 * @return
	 */
	private String readBodyContent() {
		if (bodyContent != null) {
			return IOUtils.reader2String(bodyContent.getReader());
		}
		return null;
	}

	public void release() {

		name = null;
		title = null;
		titleKey = null;
		type = null;
		format = null;
		sortable = null;
		editable = null;
		dictName = null;
		rowTag = null;

		super.release();

	}

	/**
	 * 添加其他属性
	 * 
	 * @param html
	 */
	public void setOtherAttribute(HtmlBuilder html) {

		if (!StringUtils.isEmpty(contentLimit)) {

			html.attr("contentLimit", contentLimit);

		}
	}

	// ----------------------------------------------setter and
	// getter--------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getSortable() {
		return sortable;
	}

	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	public String getDictName() {
		return dictName;
	}

	public String getDictParams() {
		return dictParams;
	}

	public void setDictParams(String dictParams) {
		this.dictParams = dictParams;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getHeaderStyle() {
		return headerStyle;
	}

	public void setHeaderStyle(String headerStyle) {
		this.headerStyle = headerStyle;
	}

	public String getHeaderClass() {
		return headerClass;
	}

	public void setHeaderClass(String headerClass) {
		this.headerClass = TagUtils.addCssClass(this.headerClass, headerClass);
	}

	public String getSortfield() {
		return sortfield;
	}

	public void setSortfield(String sortfield) {
		this.sortfield = sortfield;
	}

	public String getContentLimit() {
		return contentLimit;
	}

	public void setContentLimit(String contentLimit) {
		if(!StringUtils.isEmpty(contentLimit) && "sys".equals(contentLimit) ){
			contentLimit  = SysParameterUtils.getString(SysParameterService.LIST_COLUMN_CONTENT_LIMIT);
		}
		this.contentLimit = contentLimit;
	}

	public String getNullText() {
		return nullText;
	}

	public void setNullText(String nullText) {
		this.nullText = nullText;
	}


}
