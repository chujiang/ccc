package com.kingnod.etraining.common.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.etraining.common.service.Pdf2SwfConverterService;
import com.kingnod.etraining.common.service.SysParameterService;
import com.kingnod.etraining.course.samplerte.server.FtpServer;

@org.springframework.stereotype.Service
/**
 * @author maxudong
 * @2012-06-20
 * 主要完成pdf转换为swf
 *  
 */
public class Pdf2SwfConverterServiceImpl implements Pdf2SwfConverterService {

	protected Logger	logger	= LoggerFactory.getLogger(getClass());

	/**
	 * @param sourcePath
	 *            要转换文件的完整路径 /home/xx/xxx.pdf
	 * @param destPath
	 *            转换后文件存放路径
	 * @param fileName
	 *            转换后文件名称
	 * @param swfToolsPath
	 *            swftools 工具路径，若配置环境变量可为pdf2swf
	 *  @return int          
	 *            0表示成功
	 */
	public int pdf2swf(String sourcePath, String destPath, String fileName, String swfToolsPath) {

		 StringBuffer buf = new StringBuffer();
		 int count=-1;
		// 目标路径不存在则建立目标路径
		File dest = new File(destPath);

		if (!dest.exists()) {
			logger.debug("****目标路径不存在** " + destPath);
			dest.mkdirs();
		}
		// 源文件不存在则返回
		File source = new File(sourcePath);
		if (!source.exists()) {
			logger.debug("***  no file ***********");
			return -1;
		}
		if( !StringUtils.isEmpty(SysParameterUtils.getString(SysParameterService.PDF2SWFTOOLS_PATH))){
			swfToolsPath =  SysParameterUtils.getString(SysParameterService.PDF2SWFTOOLS_PATH);
		}
		// 调用pdf2swf命令进行转换
		buf.append(swfToolsPath).append(" ").append(sourcePath).append(" -o ").append(destPath).append(File.separator).append(fileName);
		System.out.println("["+buf.toString()+"]");
		String comm = buf.toString();
		try{
			Process pro = Runtime.getRuntime().exec(comm);
			// 防止线程堵塞 用两个线程来跑
			final InputStream is1 = pro.getInputStream();
			new Thread(new Runnable() {
				public void run() {
					try {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is1));
						
						while (bufferedReader.readLine() != null);
					}
					catch (IOException e) {
						logger.error("**  pro.getInputStream() 文件转换线程出现IO异常:  "+e.getMessage());
					}
				}
			}).start();
			final InputStream is2 = pro.getErrorStream();
			new Thread(new Runnable() {
				public void run() {
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is2));
					try {
						while (bufferedReader.readLine() != null);
					}
					catch (IOException e) {
						logger.error("** pro.getErrorStream() 文件转换线程出现IO异常 : "+e.getMessage());
					}
				}
			}).start();

			try {
				logger.debug("** pro.waitFor()方法开始执行");
				pro.waitFor();
				logger.debug("** pro.waitFor()方法执行完毕");
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			 count = pro.exitValue();
	     }catch(Exception ex){
	    	 ex.printStackTrace();
	    	 logger.error("** 调用命令文件转换时异常 : "+ ex.getMessage());
	     }
		
		

		logger.debug("***  pdf2swf end************");

		return count;

	}
	/**
	 * @param sourcePath
	 *            要转换文件的完整路径 /home/xx/xxx.pdf
	 * @param destPath
	 *            转换后文件存放路径
	 * @param fileName
	 *            转换后文件名称
	 * @param swfToolsPath
	 *            swftools 工具路径，必须写完整路径，目前有系统参数提供
	 * @param ftpServer
	 *            FtpServer 将文件上传至内容服务器
	 * @param ftpScormPath
	 *             内容服务器目标地址，这里的地址还不是完整的，FtpServer的方法里有拼接地址的方法
	 *            
	 *  @return int          
	 *            0表示成功
	 */
	public int pdf2swf(String sourcePath, String destPath, String fileName, String swfToolsPath,final FtpServer ftpServer,final String ftpScormPath) throws Exception {
		
		 StringBuffer buf = new StringBuffer();
		// 目标路径不存在则建立目标路径
		File dest = new File(destPath);
		
		if (!dest.exists()) {
			logger.debug("****目标路径不存在** " + destPath);
			dest.mkdirs();
		}
		// 源文件不存在则返回
		File source = new File(sourcePath);
		if (!source.exists()) {
			logger.debug("***  no file ***********");
			return -1;
		}
		// 调用pdf2swf命令进行转换获取系统参数
		if( !StringUtils.isEmpty(SysParameterUtils.getString(SysParameterService.PDF2SWFTOOLS_PATH))){
			swfToolsPath =  SysParameterUtils.getString(SysParameterService.PDF2SWFTOOLS_PATH);
		}
		buf.append(swfToolsPath).append(" ").append(sourcePath).append(" -o ").append(destPath).append(File.separator).append(fileName);
		String comm = buf.toString();
		
		// windows 下 样例     comm="D:/applicaltion/SWFTools/pdf2swf.exe d:/import/css.pdf -o d:/import/mxd66.swf"; //有环境变量的下情况下可直接调用  pdf2swf 
		
		// linux  下样例         comm="pdf2swf  home/import/css.pdf -o home/import/mxd66.swf";   //若没配置环境变量情况下请 输入完整路径 /home/xx/xx/pdf2swf 
		
		logger.debug("***  Runtime.getRuntime().exec(comm) ***********" + comm);
		
		
		Process pro = Runtime.getRuntime().exec(comm);
		// 防止线程堵塞 用两个线程来跑
		final InputStream is1 = pro.getInputStream();
		final String destPathAll =destPath +File.separator+ fileName;
		new Thread(new Runnable() {
			public void run() {
				try {
					logger.debug("***  pdf2swf 进入线程开始转换************");
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is1));
					
					while (bufferedReader.readLine() != null);
					logger.debug("***  调用 ftpServer.connectFTPServer()************");
					if(!ftpServer.isConnected()){
						ftpServer.connectFTPServer();
					}
					ftpServer.changeDirectory("/");
					ftpServer.uploadAll(destPathAll, ftpScormPath);
					ftpServer.closeFTPClient();
					logger.debug("**  destPathAll:  "+ destPathAll );
					logger.debug("**  ftpScormPath:  "+ ftpScormPath );
					logger.debug("***  pdf2swf 进入线程转换结束 ************");
				}
				catch (IOException e) {
					logger.error("**  pro.getInputStream() 文件转换线程出现IO异常:  "+e.getMessage());
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		final InputStream is2 = pro.getErrorStream();
		new Thread(new Runnable() {
			public void run() {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is2));
				try {
					while (bufferedReader.readLine() != null){
						logger.error("** pro.getErrorStream() 文件转换线程出现IO异常 : "+bufferedReader.readLine().toString());
					}
						
				}
				catch (IOException e) {
					logger.error("** pro.getErrorStream() 文件转换线程出现IO异常 : "+e.getMessage());
				}
			}
		}).start();
		
		try {
			pro.waitFor();
		}
		catch (InterruptedException e) {
			logger.error("** 执行pro.waitFor()方法时异常 : "+e.getMessage());
		}
		int count = pro.exitValue();
		
		logger.debug("***  pdf2swf end************ "+count);
		
		return count;
		
	}

	/**
	 * 判断当前系统是window 还是linux
	 */
	public boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		logger.debug("** isWindowsOS **: " + isWindowsOS);
		return isWindowsOS;
	}

}
