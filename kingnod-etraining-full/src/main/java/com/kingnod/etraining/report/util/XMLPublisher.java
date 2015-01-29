package com.kingnod.etraining.report.util;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import oracle.xdo.XDOException;
import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;

import org.apache.commons.beanutils.PropertyUtils;

import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.reflect.ReflectionUtils;

/**
 * 基于xmlpublish的报表导出处理器
 * @author laixiaonian
 * @author Sam
 *
 * @param <E>
 */
public class XMLPublisher<E> {

	public XMLPublisher() {
	}

	public List transList(List<E> listnew, Class entityClass) {
		List list = new ArrayList();
		PropertyDescriptor[] pds = PropertyUtils
				.getPropertyDescriptors(entityClass);

		// 获取列名数组
		String columnNames[] = new String[pds.length];
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor pd = pds[i];
			columnNames[i] = pd.getName();
		}
		list.add(columnNames);

		String columnValues[];

		// 获取值数据
		for (E entity : listnew) {
			columnValues = new String[pds.length];
			for (int i = 0; i < pds.length; i++) {
				PropertyDescriptor pd = pds[i];
				String propertyName = pd.getName();
				if (!"class".equals(propertyName)) {
					columnValues[i] = String.valueOf(ReflectionUtils
							.getFieldValue(entity, propertyName));
				} else {
					columnValues[i] = "";
				}

			}
			list.add(columnValues);
		}

		return list;
	}

	public void executeDisplaKndXLS(String fileName, List<E> dataList,
			Class entityClass, HttpServletResponse response) {
		String tempPath = SysParameterUtils.getString("sys.export_temp_path");
		executeDisplayKnd(tempPath, fileName, "xls", dataList, entityClass,
				response);
	}

	public boolean executeDisplayKnd(String filePath, String fileName,
			String type, List<E> dataList, Class entityClass,
			HttpServletResponse response) {
		dataList = transList(dataList, entityClass);
		boolean isTrue = true;
		try {
			if (dataList != null && dataList.size() > 0) {
				GenerateXMLfile generateXMLfile = new GenerateXMLfile();
				generateXMLfile.CreateXML( getFileName(filePath , fileName + ".xml"),
						dataList);
				buildPublisher(filePath, fileName, type, response);
			} else {
				isTrue = false;
			}
		} catch (Exception ex) {
			isTrue = false;
			ex.printStackTrace(System.out);
		}
		return isTrue;
	}
	
	private String getFileName(String tempDir,String fileName) {
		String path = new File(tempDir,fileName).getAbsolutePath();
		return URLDecoder.decode(path);
	}

	public void buildPublisher(String filePath, String fileName, String type,
			HttpServletResponse response) {
		try {
			XMLPublisher xMLPublisher = new XMLPublisher();
			FOProcessor processor = new FOProcessor();
			RTFProcessor rtfProcessor = new RTFProcessor(filePath + fileName
					+ ".rtf");
			rtfProcessor.setOutput(filePath + fileName + ".xsl");
			rtfProcessor.process();
			processor.setLocale("UTF-8");
			processor.setData(filePath + fileName + ".xml");
			processor.setTemplate(filePath + fileName + ".xsl");

			String fileFullpath = filePath + fileName + ".xls";
			processor.setOutput(fileFullpath);
			processor.setOutputFormat((byte) 4);

			if (type != null && type.equals("xls")) {
				processor.setOutput(filePath + fileName + ".xls");
				processor.setOutputFormat((byte) 4);
			} else if (type != null && type.equals("pdf")) {
				processor.setOutput(filePath + fileName + ".pdf");
				processor.setOutputFormat((byte) 1);
			} else {
				processor.setOutput(filePath + fileName + ".html");
				processor.setOutputFormat((byte) 3);
			}
			processor.generate();

			// 设置ContentType头字段的值为浏览器无法使用某种方式打开或激活某个程序来处理的类型.
			// 可以为application/x-msdownload或者application/octet-stream
			response.setContentType("application/x-msdownload;charset=gb2312");
			// 设置Content-Disposition头的值为"attachment;filename=文件名"
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
			// 从response中获得一个ServletOutputStream
			ServletOutputStream sops = response.getOutputStream();
			// 从服务器上获得一个文件,这里用的是下面的web.xml文件.
			// String s =
			// ServletActionContext.getRequest().getRealPath("WEB-INF\\web.xml");
			File file = new File(fileFullpath);

			InputStream ips = new FileInputStream(file);

			byte[] content = new byte[(int) file.length()];
			ips.read(content);
			// 将文件内容写入到输出流中发送给客户端
			sops.write(content);
			ips.close();
			sops.close();

		} catch (XDOException xe) {
			xe.printStackTrace(System.out);
		} catch (IOException ie) {
			ie.printStackTrace(System.out);
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

	public static void main(String args[]) {
		XMLPublisher xp = new XMLPublisher();
		String sql = "SELECT ROWNUM NUM,ID,FULL_NAME,NICK_NAME FROM ORG_USER";
		// xp.executeDisplay("c:/temp/", "classinfo", "html", sql, null);
	}
}
