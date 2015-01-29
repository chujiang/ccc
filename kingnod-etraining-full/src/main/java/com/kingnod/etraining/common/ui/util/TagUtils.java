package com.kingnod.etraining.common.ui.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.kingnod.core.dict.DataDict;
import com.kingnod.core.dict.DictFactory;
import com.kingnod.core.dict.DictKey;
import com.kingnod.core.dict.DictService;
import com.kingnod.core.dict.util.DictUtils;
import com.kingnod.core.util.Lang;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.web.HttpParameter;
import com.kingnod.etraining.common.ui.tags.GridTag;
import com.kingnod.etraining.common.ui.tags.RowTag;
import com.kingnod.etraining.common.ui.tags.ToolbarTag;
import com.opensymphony.xwork2.util.ValueStack;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * TAG工具类
 * 
 * @author Sam
 * 
 */
public final class TagUtils {
	/**
	 * 从各个请求域或者Struts2值栈中取得某一个值。
	 * 
	 * @param request
	 *            请求
	 * @param nameOrExpression
	 *            值的名称或者ognl表达式
	 * @param valueType
	 *            值的类型
	 * @return
	 */
	public static <E> E findValue(PageContext pageContext,
			String nameOrExpression, Class<E> valueType) {
		E e = (E) getObjectFromContext(pageContext, nameOrExpression);
		if (e == null) {
			ValueStack stack = org.apache.struts2.views.jsp.TagUtils
					.getStack(pageContext);
			e = (E) stack.findValue(nameOrExpression, valueType, false);
		}
		return e;
	}

	/**
	 * 从数据字典服务中取得某个数据字典
	 * 
	 * @param dictName
	 *            数据字典路径，即数据字典所在命名空间+数据字典名称
	 * @param dictParams
	 *            数据字典参数，一个key:value拼成的串，传给数据字典用于给服务接口的参数。
	 * @param request
	 *            客户端请求参数
	 * @return
	 */
	public static DataDict getDataDict(String dictName, String dictParams,
			HttpServletRequest request) {
		HttpParameter parameter = HttpParameter
				.create((HttpServletRequest) request);
		Map params = parameter.getAll();
		if (StringUtils.isNotBlank(dictParams)) {
			params = MapUtils.merge(params, MapUtils.mapByString(dictParams),
					true);
		}
		return DictUtils.getDataDictByPath(dictName, params);
	}

	/**
	 * 取得某个数据字典条目的名称
	 * 
	 * @param dictName
	 *            数据字典路径，即数据字典所在命名空间+数据字典名称
	 * @param dictParams
	 *            数据字典参数，一个key:value拼成的串，传给数据字典用于给服务接口的参数
	 * @param value
	 *            数据字典条目的值，根据此值去取得这个数据字典条目名称
	 * @param request
	 *            客户端请求信息
	 * @return
	 */
	public static String getDataDictItemName(String dictName,
			String dictParams, String value, HttpServletRequest request) {
		DictFactory dictFactory = SpringUtils.getBean(DictFactory.class);
		DictService dictService = dictFactory.createDictService();
		DictKey dictKey = DictUtils.createByFullpath(dictName);
		Map params = MapUtils.merge(HttpParameter.create(request).getAll(),
				MapUtils.mapByString(dictParams), true);
		return dictService.getDictItemNameByValue(dictKey.getNamespace(),
				dictKey.getName(), params, value);
	}

	/**
	 * 返回web应用上下文路径
	 * 
	 * @param p
	 *            页面环境
	 */
	public static String getContextPath(PageContext p) {
		return ((HttpServletRequest) p.getRequest()).getContextPath();
	}

	/**
	 * 获取消息文本
	 * 
	 * @param key
	 *            消息key
	 * @param defaultMsg
	 *            默认消息
	 */
	public static String getMessage(String key, String defaultMsg) {
		return StringUtils.isEmpty(key) ? defaultMsg : SpringUtils
				.getMessage(key);
	}

	/**
	 * 获取文本消息，可以传递多个参数
	 * 
	 * @param key
	 * @param defaultMsg
	 * @param arg
	 * @return
	 */
	public static String getMessage(String key, String defaultMsg,
			Object... arg) {
		if (arg == null || arg.length == 0) {
			getMessage(key, defaultMsg);
		}
		return StringUtils.isEmpty(key) ? defaultMsg : SpringUtils.getMessage(
				key, arg);
	}

	/**
	 * 检测当前的标签的父标签是否是GridTag
	 * 
	 * @param tag
	 *            子标签
	 * @return true表示子标签位于GridTag中，否则反之。
	 */
	public static boolean parentIsGridTag(Object tag) {
		return tag instanceof GridTag;
	}

	/**
	 * 检测当前的标签的父标签是否是RowTag
	 * 
	 * @param tag
	 *            子标签
	 * @return true表示子标签位于RowTag中，否则反之。
	 */
	public static boolean parentIsRowTag(Object tag) {
		return tag instanceof RowTag;
	}

	/**
	 * 检测当前的Tag是否被RowTag包含
	 * 
	 * @param tag
	 *            检测的Tag，一般为columnTag
	 * @return
	 */
	public static boolean hasRowTagWrapped(BodyTagSupport tag) {
		if (tag == null)
			return false;
		RowTag rowTag = (RowTag) tag.findAncestorWithClass(tag, RowTag.class);
		return (rowTag != null);
	}

	/**
	 * 检测当前的标签的父标签是否是ToolbarTag
	 * 
	 * @param tag
	 *            子标签
	 * @return true表示子标签位于ToolbarTag中，否则反之。
	 */
	public static boolean parentIsToolbarTag(Object tag) {
		return tag instanceof ToolbarTag;
	}

	/**
	 * 从各个上下环境(pageContext,request,session,application)文中取得载个对象
	 * 
	 * @param key
	 *            对象的key
	 * @return
	 */
	public static Object getObjectFromContext(PageContext pageContext,
			String key) {
		Object o = pageContext.findAttribute(key);
		if (o != null)
			return o;

		o = pageContext.getRequest().getAttribute(key);
		if (o != null)
			return o;

		o = pageContext.getSession().getAttribute(key);
		if (o != null)
			return o;
		else
			return pageContext.getServletContext().getAttribute(key);
	}

	/**
	 * 获取某个资源FTL模板配置
	 * 
	 * @param templateName
	 *            模板名称
	 * @return ftl模板
	 */
	public static Template getTemplate(String templateName) {
		Configuration cfg = new Configuration();
		try {
//			cfg.setDirectoryForTemplateLoading(TagUtils.getTemplateDir(templateName));
			cfg.setTemplateLoader(new ClassTemplateLoader(TagUtils.class,"/com/kingnod/etraining/common/ui/views/kingnod"));
			Template template = cfg.getTemplate(templateName);
			template.setEncoding("UTF-8"); 
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			return template;
		} catch (IOException e) {
			throw Lang.wrapThrow(e, "Open a template name's '%s' is Error!",
					templateName);
		}
	}

	/**
	 * 获取某个资源目录
	 * 
	 * @return
	 */
	public static File getTemplateDir(String templateName) {
		String dir = "/com/kingnod/etraining/common/ui/views/kingnod";
		if (StringUtils.contains(templateName, "/")) {
			dir = templateName.substring(0, templateName.lastIndexOf("/"));
		}
		URL url = TagUtils.class.getResource(dir);
		return new File(URLDecoder.decode(url.getFile()));
	}

	/**
	 * 为某个组件添加样式表class定义
	 * 
	 * @param cssClass
	 * @param append
	 * @return
	 */
	public static String addCssClass(String cssClass, String append) {
		if (StringUtils.isNotBlank(cssClass) && StringUtils.isNotBlank(append)
				&& StringUtils.contains(cssClass, append))
			return cssClass;
		StringBuilder sb = new StringBuilder(StringUtils.nvl(cssClass));
		if (StringUtils.isEmpty(append))
			return sb.toString();
		return sb.append(" ").append(append).toString();
	}

	/**
	 * 生成表格ID
	 * 
	 * @param pctx
	 * @return
	 */
	public static String generateTableId(PageContext pctx) {
		Integer cnt = (Integer) pctx.getAttribute(GRID_ID_COUNT);
		if (cnt == null) {
			cnt = 0;
			pctx.setAttribute(GRID_ID_COUNT, ++cnt);
		}
		return "KUI_GRID_" + cnt;
	}

	/**
	 * 获取国际化数据，处理带参数的Key
	 * 
	 * @param key
	 * @return String
	 */
	public static String getValue(String key) {
		String empty = "";
		if (StringUtils.isNotEmpty(key)) {
			int index = key.indexOf("[");
			int index2 = key.indexOf("]");
			if (index != -1 && index2 != -1) {// 国际化数据带参数
				String tagKey = key.substring(0, index);
				String parameter = key.substring(key.indexOf("[") + 1,key.indexOf("]"));
				empty = TagUtils.getMessage(tagKey, empty,(Object[]) parameter.split(","));
			} else {
				empty = TagUtils.getMessage(key, empty);// 不带参数
			}
		}
		return empty;
	}

	public static void main(String[] a) {
//		Lang.print(getTemplateDir("/com/kingnod/etraining/common/ui/views/kingnod"));
		Lang.println("  @fdsaf".matches("\\s*[@]\\w*"));
	}

	private static final String GRID_ID_COUNT = "_GRID_ID_COUNT_";
	
	/**
	 * 过滤SQL中的特殊字符，建议挪到core包的StringUtils或MybatisUtils里去。
	 * @param src
	 * @return
	 */
	public static String filterString(String str){
//		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
//		return src.replaceAll(regEx,"");
		if (StringUtils.isEmpty(str)) {
			return str;
		}
		String replaceStr = str.replace("\\", "\\\\");// 此句一定要在最前面
		replaceStr = replaceStr.replace("_", "\\_");
		replaceStr = replaceStr.replace("%", "\\%");
		return replaceStr;
	}
	
	 
}
