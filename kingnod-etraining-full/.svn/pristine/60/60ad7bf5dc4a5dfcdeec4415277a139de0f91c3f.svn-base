package com.kingnod.etraining.common.ui.components;

import java.io.StringWriter;
import java.io.Writer;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.components.ComponentUrlProvider;
import org.apache.struts2.components.ExtraParameterProvider;
import org.apache.struts2.components.UrlProvider;
import org.apache.struts2.components.UrlRenderer;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.kingnod.core.dict.DictFactory;
import com.kingnod.core.dict.DictService;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class ObjectPicker extends BaseUIBean {

	private static final Logger LOG = LoggerFactory
			.getLogger(ObjectPicker.class);
	/**
	 * The name of the default template for the TextFieldTag
	 */
	final public static String TEMPLATE = "objectPicker";
	String openTemplate;
	protected String href;
	protected UrlProvider urlProvider;
	protected UrlRenderer urlRenderer;
	protected String maxlength;
	protected String readonly;
	protected String size;
	protected String testTag;
	protected String action;
	protected String namespace;
	protected String method;
	protected String nameValue;
	protected String url;
	// 小马后添加
	protected String width;
	protected String height;
	protected String pointValue;
	protected String Parameter;
	protected String isfunction;
	protected String dialogid;
	protected String type;
	protected String mutiSelect;
	protected String titleKey;
	protected String showValue;
	protected String actionPath ;
	protected String dataType ;
	protected String idKey ;
	protected String showType ;

	// end
	protected boolean async = false;

	// these params are passed by the Param tag
	protected Map urlParameters = new LinkedHashMap();

	protected boolean processingTagBody = false;

	public ObjectPicker(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
		urlProvider = new ComponentUrlProvider(this, this.urlParameters);
		urlProvider.setHttpServletRequest(request);
		urlProvider.setHttpServletResponse(response);
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		if (href != null)
			addParameter("href",
					ensureAttributeSafelyNotEscaped(findString(href)));
		else {
			// no href, build it from URL attributes
			StringWriter sw = new StringWriter();
			urlRenderer.beforeRenderUrl(urlProvider);
			urlProvider.setEscapeAmp(false);
			urlRenderer.renderUrl(sw, urlProvider);
			String builtHref = sw.toString();
			if (StringUtils.isNotEmpty(builtHref))
				addParameter("href", ensureAttributeSafelyNotEscaped(builtHref));
		}

		if (size != null) {
			addParameter("size", findString(size));
		}
		if (maxlength != null) {
			addParameter("maxlength", findString(maxlength));
		}
		if (readonly != null) {
			addParameter("readonly", findValue(readonly, Boolean.class));
		}
		if (testTag != null) {
			addParameter("length", findValue(testTag, Boolean.class));
		}
		if (!StringUtils.isEmpty(this.nameValue)) {
			addParameter("objectName", this.nameValue);
		}
		if (!StringUtils.isEmpty(this.showType)) {
			addParameter("showType", this.showType);
		}
		else{
			addParameter("showType", "");
		}
		if (!StringUtils.isEmpty(this.showValue)) {
			addParameter("showValue", this.showValue);
		}
		else{
			addParameter("showValue", "");
		}
		
		
		StringBuffer sb = new StringBuffer();// $.showWindow
		if (StringUtils.isEmpty(height))
			height = "580";
		if (StringUtils.isEmpty(width))
			width = "660";
		if (StringUtils.isEmpty(isfunction))
			isfunction = "false";
		if (StringUtils.isEmpty(pointValue))
			pointValue = this.id;
		if (StringUtils.isEmpty(pointValue))
			pointValue = this.name;
		if (StringUtils.isEmpty(title))
			title = "";
		if (StringUtils.isEmpty(mutiSelect))
			mutiSelect = "false";
		addParameter("mutiSelect", this.mutiSelect);
		
		actionPath = this.parameters.get("href").toString();
		
		sb.append(String
				.format("$.showObjectPicker({url:'%s',title:'%s',width:'%s',height:'%s',pointValue:'%s',isfunction:'%s',type:'%s',mutiSelect:'%s',dataType:'%s',idKey:'%s',_window:%s});",
						actionPath, TagUtils.getMessage(titleKey, title), width,
						height, pointValue, isfunction, type, mutiSelect,dataType,idKey,"window"));
		addParameter("selectOnclick", sb.toString());
	
		actionPath = actionPath.replace(".action", "!name.action");
	
		addParameter("getObjectPickData",String.format("{url:'%s',pointValue:'%s',dataType:'%s',idKey:'%s'}",actionPath, pointValue,dataType,idKey));
	}

	@Inject(StrutsConstants.STRUTS_URL_INCLUDEPARAMS)
	public void setUrlIncludeParams(String urlIncludeParams) {
		urlProvider.setUrlIncludeParams(urlIncludeParams);
	}

	@Inject
	public void setUrlRenderer(UrlRenderer urlRenderer) {
		urlProvider.setUrlRenderer(urlRenderer);
		this.urlRenderer = urlRenderer;
	}

	@Inject(required = false)
	public void setExtraParameterProvider(ExtraParameterProvider provider) {
		urlProvider.setExtraParameterProvider(provider);
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setTestTag(String testTag) {
		this.testTag = testTag;
	}

	public String getAction() {
		return action;
	}

	public String getNamespace() {
		return namespace;
	}

	public String getMethod() {
		return method;
	}

	@StrutsTagAttribute(description = "The action to generate the URL for, if not using value")
	public void setAction(String action) {
		urlProvider.setAction(action);
	}

	@StrutsTagAttribute(description = "The namespace to use")
	public void setNamespace(String namespace) {
		urlProvider.setNamespace(namespace);
	}

	@StrutsTagAttribute(description = "The method of action to use")
	public void setMethod(String method) {
		urlProvider.setMethod(method);
	}

	@Override
	public boolean start(Writer writer) {
		boolean result = super.start(writer);
		this.processingTagBody = true;
		return result;
	}

	/**
	 * Overrides to be able to render body in a template rather than always
	 * before the template
	 */
	public boolean end(Writer writer, String body) {
		this.processingTagBody = false;
		evaluateParams();
		try {
			addParameter("body", body);
			mergeTemplate(writer,
					buildTemplateName(template, getDefaultTemplate()));
		} catch (Exception e) {
			LOG.error("error when rendering", e);
		} finally {
			popComponentStack();
		}

		return false;
	}

	public void addParameter(String key, Object value) {
		/*
		 * the parameters added by this method are used in the template. this
		 * method is also called by Param to add params into ancestestor. This
		 * tag needs to keep both set of parameters separated (You gotta keep
		 * 'em separated!)
		 */
		if (processingTagBody) {
			this.urlParameters.put(key, value);
		} else
			super.addParameter(key, value);
	}

	@Override
	public void addAllParameters(Map params) {
		/*
		 * the parameters added by this method are used in the template. this
		 * method is also called by Param to add params into ancestestor. This
		 * tag needs to keep both set of parameters separated (You gotta keep
		 * 'em separated!)
		 */
		if (processingTagBody) {
			this.urlParameters.putAll(params);
		} else
			super.addAllParameters(params);
	}

	public UrlProvider getUrlProvider() {
		return urlProvider;
	}

	@StrutsTagAttribute(description = "The URL.")
	public void setHref(String href) {
		this.href = href;
	}

	@StrutsTagAttribute(description = "The includeParams attribute may have the value 'none', 'get' or 'all'", defaultValue = "none")
	public void setIncludeParams(String includeParams) {
		urlProvider.setIncludeParams(includeParams);
	}

	/**
	 * @return the nameValue
	 */
	public String getNameValue() {
		return nameValue;
	}

	/**
	 * @param nameValue
	 *            the nameValue to set
	 */
	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}

	/**
	 * @return the async
	 */
	public boolean isAsync() {
		return async;
	}

	/**
	 * @param async
	 *            the async to set
	 */
	public void setAsync(boolean async) {
		this.async = async;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPointValue() {
		return pointValue;
	}

	public void setPointValue(String pointValue) {
		this.pointValue = pointValue;
	}

	public String getParameter() {
		return Parameter;
	}

	public void setParameter(String parameter) {
		Parameter = parameter;
	}

	public String getIsfunction() {
		return isfunction;
	}

	public void setIsfunction(String isfunction) {
		this.isfunction = isfunction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMutiSelect() {
		return mutiSelect;
	}

	public void setMutiSelect(String mutiSelect) {
		this.mutiSelect = mutiSelect;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	public String getShowValue() {
		return showValue;
	}

	public void setShowValue(String showValue) {
		this.showValue = showValue;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getIdKey() {
		return idKey;
	}

	public void setIdKey(String idKey) {
		this.idKey = idKey;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}


}
