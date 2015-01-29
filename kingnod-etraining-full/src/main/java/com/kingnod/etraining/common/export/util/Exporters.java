package com.kingnod.etraining.common.export.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import com.kingnod.core.util.Lang;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.io.IOUtils;
import com.kingnod.core.util.web.ServletUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.export.ExcelExporter;
import com.kingnod.etraining.common.export.ExportType;
import com.kingnod.etraining.common.export.jxls.DynamicColumnExporter;
import com.kingnod.etraining.common.export.jxls.JXLSExcelExporter;
import com.kingnod.etraining.common.export.xmlpublish.XmlDataSet;
import com.kingnod.etraining.common.export.xmlpublish.XmlPublishExporter;

/**
 * Excel导出工具
 * @author sam
 *
 */
public abstract class Exporters {
	public static final String TEMPLATE_BASE = "template/";
	
	/**
	 * 创建一个基于模板的EXCEL导出器
	 * @param template 模板路径
	 * @param exportPath 导出路径，可以不设置文件名后缀和文件目录，会自动加上，文件目录则使用系统临时目录
	 * @return
	 */
	public static ExcelExporter createJXLSExporter(String template,String exportPath) {
		template = findTemplatePath(template);
		exportPath = findFile(exportPath).getAbsolutePath();
		ExcelExporter exporter = new JXLSExcelExporter(template,exportPath);		
		return exporter;
	}
	
	/**
	 * 创建一个基于模板的EXCEL导出器，不指定导出路径，会以系统临时目录+模板名做导出路径
	 * 只要适用于有些模块要直接导出到客户端的情况
	 * @param template 模板路径
	 * @return
	 */
	public static ExcelExporter createJXLSExporter(String template) {
		String exportPath = findFile(template).getAbsolutePath();
		template = findTemplatePath(template);		
		ExcelExporter exporter = new JXLSExcelExporter(template,exportPath);		
		return exporter;
	}
	
	/**
	 * 查找某个导出模板的路径 
	 * @param template
	 * @return
	 */
	public static String findTemplatePath(String template) {
		//只要传进来的template包含有'/','\'，就认为是一个已经完整的路径不再处理
		if (StringUtils.containsAny(template, "/","\\") ) {
			return template;
		}
		return findResource(TEMPLATE_BASE+addSuffixName(template));
		
	}
	
	/**
	 * 从ClassPath中查找某个资源
	 * @param resource 资源路径
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String findResource(String resource) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
		return URLDecoder.decode(url.getFile());
	}
	
	/**
	 * 根据一个路径生成一个File对象,
	 * @param path
	 * @return
	 */
	public static File findFile(String path) {
		String dir = findResource("tempdir/");
		File tempdir = new File(dir);
		if (!tempdir.exists()) {
			try {
				tempdir.createNewFile();
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
		
		String fileName = addSuffixName(path);
		if (StringUtils.isNotBlank(dir)) {
			dir = dir.replaceAll("\\\\", "/");
		}
		if (StringUtils.isNotBlank(path)) {
			path = path.replaceAll("\\\\", "/");
		}
		if (StringUtils.containsAny(path, "/")) {
			dir = StringUtils.substringBeforeLast(path, "/");
			fileName = StringUtils.substringAfterLast(path, "/");
		}
		fileName = addSuffixName(fileName);		
		File exportFile = new File(dir,fileName);
		return exportFile;
	}
	
	/**
	 * 添加后缀名
	 * @param fileName
	 * @return
	 */
	public static String addSuffixName(String fileName) {
		if (!StringUtils.matches(".*\\.xls", fileName)) {
			fileName += ".xls";
		}
		return fileName;
	}
	
	/**
	 * 创建一个动态列导出器
	 * @return
	 */
	public static DynamicColumnExporter createDynamicExporter() {
		return DynamicColumnExporter.create();
	}
	
	
	/**
	 * 使用JXLS工具动态列导出器执行导出
	 * @param exportPath 导出的目标路径
	 * @param title 报表标题
	 * @param properties 导出字段设置
	 * @param columns 导出列标题
	 * @param records 导出的记录集
	 * @param downloadable 是否导出到客户端
	 * @throws IOException
	 */ 
	public static void toXLSByJXLS(String exportPath,
							  String title,
							  List<String> properties,
							  List<String> columns,
							  List records,
							  boolean downloadable) throws IOException {
		DynamicColumnExporter exporter = createDynamicExporter();
		exporter.columns(columns).properties(properties).record(records).title(title);
		if (downloadable) {
			exporter.export(Struts2Utils.getResponse(), exportPath);
		} else {
			exporter.export(exportPath);
		}
	}
	
	/**
	 * 使用xmlpublish导出xls，并下载
	 * @param templateName 模板名称
	 * @param properties 实体的属性集
	 * @param dataset 实体集
	 * @param downloadFileName 下载的文件名称
	 * @throws IOException 
	 */
	public static void toXLSByXmlPublisherWithDownload(String templateName,List<String> properties,List dataset,String downloadFileName )  {
		XmlPublishExporter xpExporter = new XmlPublishExporter();
		XmlDataSet xds = XmlDataSet.create();
		if (ListUtils.isNotEmpty(properties))
			xds.add(dataset, ListUtils.toArray(properties)); 
		xpExporter.setXmlDataSet(xds);
		xpExporter.setTemplateDirectory(SysParameterUtils.getString("sys.export_temp_path"));
		xpExporter.setDataOutPath(SysParameterUtils.getString("sys.export_temp_path"));
		xpExporter.setTemplateName(templateName);
		OutputStream os = null;
		try {
			ServletUtils.setDownloadableHeader(Struts2Utils.getResponse(), URLEncoder.encode(downloadFileName,StringUtils.ENCODING_UTF8) +".xls");
			os = Struts2Utils.getResponse().getOutputStream();
			xpExporter.export(Struts2Utils.getResponse().getOutputStream(), ExportType.EXCEL);
			os.flush();
//			xpExporter.export(downloadFileName+".xls", ExportType.EXCEL);
//			ServletUtils.download(Struts2Utils.getResponse(), new File(findResource("template/"),downloadFileName+".xls"), downloadFileName+".xls", true);
		} catch (Exception e) {
			throw Lang.wrapThrow(e,"template is '%s' export to xls by xmlpublisher is error!\n",templateName);
		} finally {
			IOUtils.close(os);
		}
		
	}
}





