package com.kingnod.etraining.common.ui.components;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Anchor;
import org.apache.struts2.components.ComponentUrlProvider;
import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.core.util.SpringUtils;
import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "tree", tldTagClass = "com.kingnod.etraining.common.ui.tags.TreeTag", description = "这个标签用于创建一个tree")
public class Tree extends Anchor {

	public static final String OPEN_TEMPLATE = "tree";
	public static final String TEMPLATE = "tree-close";
	public static final String COMPONENT_NAME = Tree.class.getName();
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

	public Tree(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		super(stack, req, res);
		urlProvider = new ComponentUrlProvider(this, null);
		urlProvider.setHttpServletRequest(request);
		urlProvider.setHttpServletResponse(response);
	}

	@Override
	public void evaluateParams() {
		this.urlProvider.setEscapeAmp(false);
		super.evaluateParams();
		if (StringUtils.isEmpty(this.textKey)) {
			addParameter("text", this.text);
		} else {
			addParameter("text", SpringUtils.getMessage(this.textKey));
		}
		addParameter("async", String.valueOf(async));
		addParameter("initCompletedScript", String.valueOf(initCompletedScript));
		addParameter("enableEdit", "true".equals(edit) || "true".equals(drag)?true:false);
		addParameter("edit", findValue(edit, Boolean.class));
		addParameter("onAsyncSuccess", onAsyncSuccess);
		addParameter("showRenameBtn", String.valueOf(showRenameBtn));
		if(StringUtils.isEmpty(this.autoParam)){
			addParameter("autoParam", "\"id\",\"nodeType\"");
		}else{
			addParameter("autoParam", autoParam);
		}
		if(null != this.urlParameters){
			String otherParam = "";
			Iterator iter = this.urlParameters.entrySet().iterator(); 
			while (iter.hasNext()) { 
			    Map.Entry entry = (Map.Entry) iter.next(); 
			    Object key = entry.getKey();
			    Object val = entry.getValue();
			    otherParam = otherParam + "\"" + key + "\"," + "\"" + val + "\",";
			}
			if(otherParam.length() > 0){
				otherParam = otherParam.substring(0, otherParam.length() - 1);
			}
			addParameter("otherParam", otherParam);
		}
		if(!async){
			String href = (String)this.parameters.get("href");
			if(href.indexOf('?') != -1){
				href = href.substring(0, href.indexOf('?'));
			}
			addParameter("href", href);
			addParameter("paramsJsonObj", JSONObject.fromObject(this.urlParameters).toString());
		}
		if(!StringUtils.isEmpty(beforeDrag)){
			addParameter("beforeDrag", beforeDrag);
		}
		if(!StringUtils.isEmpty(beforeDrop)){
			addParameter("beforeDrop", beforeDrop);
		}
		
	}

	public String getDefaultOpenTemplate() {
		return OPEN_TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public String getTemplateDir() {
		return "com/kingnod/etraining/common/ui/views";
	}

	public String getTheme() {
		return "kingnod";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTextKey() {
		return textKey;
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

	public void setEdit(String edit) {
		this.edit = edit;
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

	public boolean isShowRenameBtn() {
		return showRenameBtn;
	}

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
