package com.kingnod.etraining.common.ui.tags;

import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.common.ui.components.BaseUIBean;
import com.kingnod.etraining.common.ui.util.TagUtils;

/**
 * UITag基类，用于封装一些公用的字段信息，如validator,valimsg等。并做统一的处理
 * 
 * @author Sam
 * 
 */
public abstract class BaseUITag extends AbstractUITag {
	/**
	 * 
	 */
	private static final long serialVersionUID = -264550645140413152L;

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
	 * 组件在JSP定义的位置
	 */
	protected Integer layoutPosition;

	/**
	 * 组件是否在JSP最后一个定义
	 */
	protected String isLayoutLast;

	/**
	 * 组件跨的列数
	 */
	protected String colspan;
	
	/**
	 * 是否被Layout标签包围
	 */
	protected String isLayout;
	
	/**
	 * Layout的列
	 */
	protected String layoutCols;

	protected String title;

	protected String label;

	protected String labelKey;

	protected void populateParams() {
		super.populateParams();

		LayoutTag layout = (LayoutTag) this.findAncestorWithClass(this, LayoutTag.class);
		if (null != layout) {

			// 如果是Hidden标签在Layout标签中不占位置
			if (!(component instanceof com.kingnod.etraining.common.ui.components.Hidden)) {
				layoutPosition = layout.positions + 1;
				layoutCols = layout.layoutCols;
				layout.positions++;
			}
		}
		if (component instanceof BaseUIBean) {
			BaseUIBean uibean = ((BaseUIBean) component);
			uibean.setValidator(validator);
			uibean.setValimsg(calcValimsg());
			uibean.setNotnull(notnull);
			uibean.setValimsgKey(valimsgKey);
			
			Object obj = pageContext.getAttribute("editable");
			if (obj != null && editable == null) {
				uibean.setEditable(obj.toString());
			} else {
				uibean.setEditable(editable);
			}

			uibean.setViewText(value);
			uibean.setLayoutCols(layoutCols);
			uibean.setLayoutPosition(layoutPosition);
			uibean.setIsLayoutLast(isLayoutLast);
			uibean.setTitle(title);
			uibean.setLabel(label);
			uibean.setLabelKey(labelKey);
			uibean.setColspan(colspan);
			uibean.setLabel(TagUtils.getMessage(labelKey, label));
			uibean.setIsLayout(isLayout);
		}
	}

	public String calcValimsg() {
		if (StringUtils.isBlank(valimsgKey)) {
			return valimsg;
		}  
		Map<String,String> valimsg = MapUtils.mapByString(valimsgKey);
		if (MapUtils.isNotEmpty(valimsg)) {
			for (Entry<String,String> entry:valimsg.entrySet()) {
				entry.setValue(TagUtils.getMessage(entry.getValue(), ""));
			}
			return StringUtils.substringBetween(JSONObject.fromObject(valimsg).toString(),"{","}");
		}
		return "";
	}
	
	public void setIsLayout(String isLayout) {
		this.isLayout = isLayout;
	}

	public void setLayoutCols(String layoutCols) {
		this.layoutCols = layoutCols;
	}

	public void setValidator(String validator) {
		this.validator = validator;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setValimsg(String valimsg) {
		this.valimsg = valimsg;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public void setValimsgKey(String valimsgKey) {
		this.valimsgKey = valimsgKey;
	}

	public void setNotnull(String notnull) {
		this.notnull = notnull;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public void setIsLayoutLast(String isLayoutLast) {
		this.isLayoutLast = isLayoutLast;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
	}
}
