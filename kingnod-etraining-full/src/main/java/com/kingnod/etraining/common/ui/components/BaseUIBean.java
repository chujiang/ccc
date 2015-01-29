package com.kingnod.etraining.common.ui.components;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.kingnod.core.util.ObjectUtils;
import com.kingnod.core.util.StringUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 扩展struts2的UIBean，设置一个默认的模板目录和主题
 * 
 * @author Sam
 * 
 */
public abstract class BaseUIBean extends UIBean {

	/**
	 * 定义一组验证器，具体的实现应由javascript来实现
	 */
	private String validator;

	/**
	 * 定义验证失败时，显示的消息，如果没有定义的话，错误消息就由具体的验证器的定义来提示
	 */
	private String valimsg;

	/**
	 * 验证失败消息key，定义此key，可以从struts的国际化资源文件中根据key取消息
	 */
	private String valimsgKey;

	/**
	 * 是否允许为空
	 */
	private String notnull;

	/**
	 * 是否允许编辑，如果不可以编辑，则只渲染字段值，而不渲染组件
	 */
	protected String editable;

	/**
	 * 是否被Layout标签包围
	 */
	protected String isLayout;
	
	/**
	 * 当不可编辑时，要显示的文本，因为有些组件是要经过计算才知道这个文本值的，如select、checkboxList等.
	 */
	private String viewText;

	/**
	 * 组件在JSP定义的位置
	 */
	protected Integer layoutPosition = 0;

	/**
	 * 组件是否在JSP最后一个定义
	 */
	protected String isLayoutLast;

	/**
	 * 组件跨的列数
	 */
	protected String colspan;

	/**
	 * Layout的列
	 */
	protected String layoutCols;

	protected String title;

	protected String label;

	protected String labelKey;

	public BaseUIBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	public String getDefaultOpenTemplate() {
		return null;
	}

	/**
	 * 设置模板默认路径
	 */
	public String getTemplateDir() {
		return "com/kingnod/etraining/common/ui/views";
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		Layout layout = (Layout) findAncestor(Layout.class);
		String labelWidth = layoutCols==null ? "":layout.getLabelWidth();
		
		addParam("validator", validator);
		addParam("valimsg", valimsg);
		addParam("notnull", notnull);
		addParam("viewText", viewText);
		addParam("componentName", getDefaultTemplate());
		addParam("layoutPosition", layoutPosition);
		addParam("isLayoutLast", isLayoutLast);
		addParam("title", StringUtils.nvl(title, ""));
		addParam("label", StringUtils.nvl(label, ""));
		addParam("labelKey", StringUtils.nvl(labelKey, ""));
		addParam("isLayout", StringUtils.nvl(isLayout, ""));
		addParam("labelWidth", StringUtils.nvl(labelWidth, ""));
		// 表格显示几列
		int layoutcols = transitionInt(layoutCols);
		//int layoutcols = 1;
//		if (layoutCols instanceof String) {
//			layoutcols = Integer.parseInt(layoutCols);
//		}
		addParam("layoutCols", layoutcols);

		int layoutCols = transitionInt(colspan);//jsp界面设置所占的列数
//		int aa = 1;
//		if(StringUtils.isNotEmpty(colspan)){
//			aa = Integer.parseInt(colspan);
//		}
		
		int calculateCols = calculateColspan(colspan, layoutcols);//计算之后的跨列数

		if (editable != null) {
			addParameter("editable", findValue(editable, Boolean.class));
		}
		
		List<LayoutResult> list = LayoutUtil.list;
		// 第一次进来时，清空数据
		if (layoutPosition != null && layoutPosition == 1) {
			list.clear();
			if(layoutCols > 1 && layoutCols <= layoutcols){
				addParameter("colspan", calculateCols);
			}
		}else if(layoutPosition != null && layoutPosition > 1){
			 //LayoutResult result = list.get(list.size()>0 ? list.size()-1 : 0);
			 LayoutResult result = getLayoutResult(list);
			 if(result != null && result.isEnd()){
				 if(layoutCols > 1 && layoutCols <= layoutcols){
						addParameter("colspan", calculateCols);
					}
			 }else{
				 if(layoutCols > 1 && layoutCols <= result.getLeavinCols()){
					 addParameter("colspan", calculateCols);
				 }
			 }
		}
		
		//表格显示列数： layoutcols 2
		//所占列数        ：cols 2
		
		boolean isStartTr = false;
		boolean isEndTr = false;
		
		// 判断是否要换行，结束换行
		if (layoutPosition != null) {
			if (layoutcols == 1) {// 只有一列时，一直换行
				isStartTr = true;
				isEndTr = true;
			} else {
				if(list.size() == 0){//第一行数据第一个数据
					LayoutResult lr = new LayoutResult();
					isStartTr = true;
					if(layoutcols == layoutCols){
						lr.setEnd(true);
						lr.setLeavinCols(0);
					}else if(layoutCols > layoutcols){
						lr.setLeavinCols(layoutcols - 1);
					}else{
						lr.setLeavinCols(layoutcols - layoutCols);
					}
					list.add(lr);
				}else{
					LayoutResult lr = list.get(list.size()-1);
					if(lr.isEnd()){//上一个已经结束了
						LayoutResult lr2 = new LayoutResult();
						isStartTr = true;
						if(layoutcols == layoutCols){
							lr2.setEnd(true);
							lr2.setLeavinCols(0);
						}else if(layoutCols > layoutcols){
							lr2.setLeavinCols(layoutcols - 1);
						}else{
							lr2.setLeavinCols(layoutcols - layoutCols);
						}
						list.add(lr2);
					}else{
						if(lr.getLeavinCols() == layoutCols || lr.getLeavinCols() == 1){
							lr.setEnd(true);
							lr.setLeavinCols(0);
						}else if(layoutCols > lr.getLeavinCols()){//当前标签设置的跨列数 > 剩余列数，忽略跨列数
							lr.setLeavinCols(lr.getLeavinCols() - 1);
						}else{
							lr.setLeavinCols(lr.getLeavinCols() - layoutCols);
						}
					}
				}
				LayoutResult result = getLayoutResult(list);
				isEndTr = result != null ?  result.isEnd() : false;
			}
		} else {
			isStartTr = false;
			isEndTr = false;
		}

		if ("true".equals(isLayoutLast)) {// 当前控件是layout标签中的最后一个，结束换行
			isEndTr = true;
		}
		
		addParam("isStartTr", isStartTr);
		
		addParam("isEndTr", isEndTr);
		
		addParam("isLayoutStart", layoutcols > 0 ? true : false);// 判断是否存在layout标签
		
		if(isStartTr){
			if(null == this.request.getAttribute("rowClass")){
				this.request.setAttribute("rowClass", "");
			}
			if("".equals(this.request.getAttribute("rowClass"))){
				this.request.setAttribute("rowClass", "bdbox_lis");
			}else{
				this.request.setAttribute("rowClass", "");
			}
			addParam("rowClass", this.request.getAttribute("rowClass"));
		}

	}
	
	public LayoutResult getLayoutResult(List<LayoutResult> list) {
		LayoutResult result = null;
		if(list != null && list.size() > 0){
			result = list.get(list.size() - 1);
		}
		return result;
	}
	
	/**
	 * 将字符串强转成int类型
	 * @return int
	 */
	public int transitionInt(String value){
		int data = 1;
		if(StringUtils.isNotEmpty(value)){
			try{
				data = Integer.parseInt(value);
			}catch(Exception e){
				
			}
		}
		return data;
	}
	/**
	 * 计算所占列数
	 * 
	 * @return cols
	 */
	public int calculateColspan(String colspanValue, int layoutcols) {
		int cols = 1;
		try {
			cols = Integer.parseInt(colspanValue);
			cols = cols > 1 && layoutcols > 1 ? cols * 2 - 1 : 1;
		} catch (Exception e) {}
		return cols;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	/**
	 * 添加ftl参数
	 * 
	 * @param name
	 *            参数名
	 * @param value
	 *            参数值
	 */
	public void addParam(String name, Object value) {
		addParam(name, value, null);
	}

	/**
	 * 添加ftl参数,如果参数为空则不传至报表模板
	 * 
	 * @param name
	 *            参数名
	 * @param value
	 *            参数值
	 * @param defaultValue
	 *            默认参数参数值，当指定的参数值为空时，会用此值传至报表模板
	 */
	public void addParam(String name, Object value, Object defaultValue) {
		value = ObjectUtils.nvl(value, defaultValue);
		if (value != null)
			addParameter(name, value);
	}

	public String getValidator() {
		return validator;
	}

	public void setValidator(String validator) {
		this.validator = validator;
	}

	public String getValimsg() {
		return valimsg;
	}

	public void setValimsg(String valimsg) {
		this.valimsg = valimsg;
	}

	public String getValimsgKey() {
		return valimsgKey;
	}

	public void setValimsgKey(String valimsgKey) {
		this.valimsgKey = valimsgKey;
	}

	public void setIsLayout(String isLayout) {
		this.isLayout = isLayout;
	}

	public String getNotnull() {
		return notnull;
	}

	public void setNotnull(String notnull) {
		this.notnull = notnull;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public void setViewText(String viewText) {
		this.viewText = viewText;
	}

	public String getViewText() {
		return viewText;
	}

	public Integer getLayoutPosition() {
		return layoutPosition;
	}

	public void setLayoutPosition(Integer layoutPosition) {
		this.layoutPosition = layoutPosition;
	}

	public String getIsLayoutLast() {
		return isLayoutLast;
	}

	public void setIsLayoutLast(String isLayoutLast) {
		this.isLayoutLast = isLayoutLast;
	}

	public void setLayoutCols(String layoutCols) {
		this.layoutCols = layoutCols;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
	}
}
