package com.kingnod.etraining.common.service;

import com.kingnod.etraining.course.samplerte.server.FtpServer;

public interface Pdf2SwfConverterService {
	
	 /**
	 * @author maxudong
	 * @param sourcePath //要转换文件路径
	 * @param destPath //输出路径
	 * @param fileName 文件名称
	 * @param swfToolsPath 
	 * @return int
	 * 主要完成pdf 文件格式转换
	 */
	public  int pdf2swf(String sourcePath ,String destPath ,String fileName ,String swfToolsPath) throws Exception;
	/**
	 * @author maxudong
	 * @param sourcePath //要转换文件路径
	 * @param destPath //输出路径
	 * @param fileName 文件名称
	 * @param swfToolsPath 
	 * @return int
	 * 主要完成pdf 文件格式转换
	 */
	public  int pdf2swf(String sourcePath ,String destPath ,String fileName ,String swfToolsPath,FtpServer ftpServer,String ftpScormPath) throws Exception;
	
	/**
	 * @author maxudong
	 * 主要判断当前系统
	 * @return
	 */
	public boolean isWindowsOS() ;

}
