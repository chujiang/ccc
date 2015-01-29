package com.kingnod.etraining.common.export.util;

import java.io.File;
import java.net.URL;

import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.common.export.ExcelReader;
import com.kingnod.etraining.common.export.jxls.JXLSExcelReader;

/**
 * Excel导入处理工具类
 * @author Sam
 *
 */
public class ExcelReaders {
	/**
	 * 创建一个excel导入处理器
	 * @param file 导入配置文件
	 * @return
	 */
	public static ExcelReader createJXLSReader(File file) {
		return new JXLSExcelReader(file);
	}
	
	/**
	 * 创建一个excel导入处理器
	 * @param path 指定配置文件所在的classpath或者文件绝对路径
	 * @return
	 */
	public static ExcelReader createJXLSReader(String path) {
		if (!StringUtils.containsAny(path, "/","\\")) {
			path = "templates/imports/" + path;
			path = StringUtils.matches(".*\\.xml\\s*", path)?path:(path+".xml");
		}
		URL url = Thread.currentThread().getContextClassLoader().getResource(path);
		if (url != null) {
			return new JXLSExcelReader(url.getFile());
		}
		return createJXLSReader(new File(path));
	}
	
	 
}
