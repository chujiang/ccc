package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AnchorTag;

import com.kingnod.core.util.UUIDUtils;
import com.kingnod.etraining.common.ui.components.Tree;
import com.opensymphony.xwork2.util.ValueStack;

public class TreeTag extends AnchorTag {

	private static final long serialVersionUID = -6503701873654126103L;

	protected String text = "";
	protected String textKey = "";
	protected boolean async = true;
	protected String edit = "false";
	protected String drag = "false";
	protected String beforeDrag = "";
	protected String beforeDrop = "";
	protected String initCompletedScript = "";
	protected String onAsyncSuccess;
	protected String autoParam;
	protected boolean showRenameBtn = false;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new Tree(stack, req, res);
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		Tree tag = (Tree) component;
		tag.setText(text);
		tag.setTextKey(textKey);
		tag.setAsync(async);
		tag.setEdit(edit);
		tag.setDrag(drag);
		tag.setBeforeDrag(beforeDrag);
		tag.setBeforeDrop(beforeDrop);
		tag.setInitCompletedScript(initCompletedScript);
		tag.setOnAsyncSuccess(onAsyncSuccess);
		tag.setAutoParam(autoParam);
		tag.setShowRenameBtn(this.showRenameBtn);
		if (StringUtils.isEmpty(id)) {
			tag.setId(UUIDUtils.getUUID());
		}
	}

	public String getText() {
		return text;
	}

	public String getTextKey() {
		return textKey;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTextKey(String textKey) {
		this.textKey = textKey;
	}

	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String enable) {
		this.edit = enable;
	}

	public String getInitCompletedScript() {
		return initCompletedScript;
	}

	public void setInitCompletedScript(String initCompletedScript) {
		this.initCompletedScript = initCompletedScript;
	}

	public String getOnAsyncSuccess() {
		return onAsyncSuccess;
	}

	public void setOnAsyncSuccess(String onAsyncSuccess) {
		this.onAsyncSuccess = onAsyncSuccess;
	}

	public String getAutoParam() {
		return autoParam;
	}

	public void setAutoParam(String autoParam) {
		this.autoParam = autoParam;
	}

	/**
	 * @return the showRenameBtn
	 */
	public boolean isShowRenameBtn() {
		return showRenameBtn;
	}

	/**
	 * @param showRenameBtn the showRenameBtn to set
	 */
	public void setShowRenameBtn(boolean showRenameBtn) {
		this.showRenameBtn = showRenameBtn;
	}

	public String getDrag() {
		return drag;
	}

	public void setDrag(String drag) {
		this.drag = drag;
	}

	public String getBeforeDrag() {
		return beforeDrag;
	}

	public void setBeforeDrag(String beforeDrag) {
		this.beforeDrag = beforeDrag;
	}

	public String getBeforeDrop() {
		return beforeDrop;
	}

	public void setBeforeDrop(String beforeDrop) {
		this.beforeDrop = beforeDrop;
	}
}
