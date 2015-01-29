package com.kingnod.etraining.common.export.xmlpublish;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.xdo.XDOException;
import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;

import org.w3c.dom.Element;

import com.kingnod.core.util.Assert;
import com.kingnod.core.util.Lang;
import com.kingnod.core.util.ObjectUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.io.IOUtils;
import com.kingnod.etraining.common.export.ExportType;
import com.kingnod.etraining.organization.entity.User;

/**
 * 基于oracle xmlpublisher工具，实现可以根据查询出来的实体集导出excel\rtf\pdf等格式数据文件。
 * @author Sam
 *
 */
public class XmlPublishExporter  {
	/**
	 * RTF模板目录
	 */
	private String templateDirectory;
	
	/**
	 * 模板名称
	 */
	private String templateName;
	
	/**
	 * 数据输出路径，传给XmlPublish的数据是根据你原有的数据源或者程序处理后实体集生成一个XML数据文件。
	 * 此目录是存放这些临时数据文件的目录，此目录下面的文件是可以被删除
	 */
	private String dataOutPath;
	
	/**
	 * 导出文件名称 
	 */
	private String exportName;
	
	/**
	 * 要渲染的数据源
	 */
	private XmlDataSet xmlDataSet;
	
	/**
	 * 传给报表模板的参数
	 */
	private Map parameters = MapUtils.newMap(); 
	
	public XmlPublishExporter() {
		xmlDataSet = XmlDataSet.create();  
	}

 
	public void export(OutputStream os, ExportType et) {
		FOProcessor processor = new FOProcessor();
		processor.setData(buildDataReader());
		processor.setTemplate(buildTemplate());		 
		processor.setLocale("UTF-8");
		processor.setOutput(os);
		processor.setOutputFormat(et.getXmlPublishFormatValue()); 
		try {
			processor.generate();
		} catch (XDOException e) { 
			e.printStackTrace();
		}
	}
	
	public void export(String fileName,ExportType et) {
		File file = new File(dataOutPath,fileName);
		try {
			export(IOUtils.fileBufferOut(file),et);
		} catch (FileNotFoundException e) {
			throw Lang.wrapThrow(e,"not found file : %s",file.getAbsoluteFile());
		}
	}
	
	@SuppressWarnings("deprecation")
	private String getDefaultTempateDirectory() {
		URL url = XmlPublishExporter.class.getResource("/template");
		return URLDecoder.decode(url.getFile());
	}
	
	@SuppressWarnings("deprecation")
	private InputStream buildTemplate()  {
		if (!new File(templateDirectory).exists())
			throw Lang.makeThrow("the template directory is not exists! " ); 
 
		String templateFullPath = 
			URLDecoder.decode(new File(templateDirectory,templateName).getAbsolutePath());
//		File rtfTemplateFile = new File(templateFullPath + ".rtf");
		File xslTemplateFile = new File(templateFullPath + ".xsl"); 
		
		//如果xsl不存在或者RTF模板有更新，则重新生成xsl模板
		if (!xslTemplateFile.exists() 
//				|| (xslTemplateFile.exists() && rtfTemplateFile.lastModified() > xslTemplateFile.lastModified() )
				) {
			try {
			RTFProcessor rtfProcessor = new RTFProcessor(getInputStreamFromClassPath(String.format("/template/%s.rtf", templateName))); 
			rtfProcessor.setOutput(templateFullPath + ".xsl");
			rtfProcessor.process();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw Lang.wrapThrow(ex,"building template name's '%s' is error! ",templateFullPath);
			}
		}

		try {
			return IOUtils.fileBufferIn(new File(templateFullPath + ".xsl"));
		} catch (FileNotFoundException e) {
			throw Lang.wrapThrow(e);
		}
		
	}
	
	private InputStream getInputStreamFromClassPath(String path) {
		Assert.hasText(path,"XmlPublishExporter.getInputStreamFromClassPath():the template path is null");
		if ( !path.trim().startsWith("/") ) {
			path = "/"+path;
		}
		return XmlPublishExporter.class.getResourceAsStream(path);
			
	}
	
	private Reader buildDataReader() {
		if (!parameters.isEmpty() ) {
			Element parameterElement = xmlDataSet.createElement("Parameters");
			Set keyset = parameters.keySet();
			for (Iterator keyIter = keyset.iterator();keyIter.hasNext();) {
				String paramName = keyIter.next().toString();
				Object paramValue = parameters.get(paramName);
				Element parameter = xmlDataSet.createElement(paramName);
				parameter.setTextContent(ObjectUtils.toString(paramValue));
				parameterElement.appendChild(parameter);
			}
			xmlDataSet.add(parameterElement);
		}
		return xmlDataSet.toReader();
	}
	
	public String getTemplateDirectory() {
		return templateDirectory;
	}


	public void setTemplateDirectory(String templateDirectory) {
		this.templateDirectory = templateDirectory;
	}


	public String getTemplateName() {
		return templateName;
	}


	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}


	public String getDataOutPath() {
		return dataOutPath;
	}


	public void setDataOutPath(String dataOutPath) {
		this.dataOutPath = dataOutPath;
	}


	public String getExportName() {
		return exportName;
	}


	public void setExportName(String exportName) {
		this.exportName = exportName;
	}


	public XmlDataSet getXmlDataSet() {
		return xmlDataSet;
	}


	public void setXmlDataSet(XmlDataSet xmlDataSet) {
		this.xmlDataSet = xmlDataSet;
	}
	
	 
	public static void main(String[] args) throws   Exception {
		List<User> users = ListUtils.newList();
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setLoginName("user" +i);
			u.setPassword("pwd" + i);
			users.add(u);
		}
		XmlDataSet xmlDataSet = XmlDataSet.create();
		xmlDataSet.add(users);
		XmlPublishExporter xpe = new XmlPublishExporter();
		xpe.setTemplateName("classinfo");
		xpe.setXmlDataSet(xmlDataSet); 
		xpe.export(new FileOutputStream(new File("d:/tt.xls")), ExportType.EXCEL);
//		InputStream is = XmlPublishExporter.class.getResourceAsStream("/template/ssss.xsl");
//		Lang.println(is+"ffff"+XmlPublishExporter.class.getResource("/template/ssss.xsl.xsl"));
//		IOUtils.close(is);
//		Lang.println(XmlPublishExporter.class.getResource("/template/dynamicTemplate.xls").toURI());
	}

 

}
