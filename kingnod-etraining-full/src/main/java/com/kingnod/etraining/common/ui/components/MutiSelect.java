package com.kingnod.etraining.common.ui.components;

import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.components.ComponentUrlProvider;
import org.apache.struts2.components.ExtraParameterProvider;
import org.apache.struts2.components.UrlProvider;
import org.apache.struts2.components.UrlRenderer;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class MutiSelect extends BaseUIBean {
	
	private static final Logger LOG = LoggerFactory.getLogger(MutiSelect.class);
	/**
	 * The name of the default template for the TextFieldTag
	 */
	final public static String TEMPLATE = "muti-select";
	String openTemplate;

	protected UrlProvider urlProvider;
	protected UrlRenderer urlRenderer;
	protected String action;
	protected String namespace;
	protected String method;
	protected String maxlength;
	protected String readonly;
	protected String size;
	protected String testTag;
	protected Map urlParameters = new LinkedHashMap();
	protected boolean processingTagBody = false;

	public MutiSelect(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
		urlProvider = new ComponentUrlProvider(this, null);
		urlProvider.setHttpServletRequest(request);
		urlProvider.setHttpServletResponse(response);
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		
		Map params = urlProvider.getParameters();
		//获取请求的url
		this.urlProvider.setNamespace(namespace);
		this.urlProvider.setAction(action);
		this.urlProvider.setMethod(method);
		StringWriter sw = new StringWriter();
		urlRenderer.beforeRenderUrl(urlProvider);
		urlProvider.setEscapeAmp(false);
		urlRenderer.renderUrl(sw, urlProvider);
		String builtHref = sw.toString();
		addParameter("jsondata", JSONObject.fromObject(urlParameters));
		if (StringUtils.isNotEmpty(builtHref))
			addParameter("href", ensureAttributeSafelyNotEscaped(builtHref));
		
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

		addParameter("paramsJsonObj", JSONObject.fromObject(this.urlProvider.getParameters()).toString());
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

	public void setAction(String action) {
		this.action = action;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public void setMethod(String method) {
		this.method = method;
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

	@StrutsTagAttribute(description = "The includeParams attribute may have the value 'none', 'get' or 'all'", defaultValue = "none")
	public void setIncludeParams(String includeParams) {
		urlProvider.setIncludeParams(includeParams);
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
}
