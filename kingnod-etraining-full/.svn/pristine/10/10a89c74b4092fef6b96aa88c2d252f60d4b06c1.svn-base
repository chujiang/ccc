package com.kingnod.etraining.common.service;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.sun.net.httpserver.HttpContext;

public class SwfToolsServiceTest {

	@Test
	public void testSwfTools() throws Exception {
     
		String sourcePath = "d:/import/css.pdf";
		String destPath = "d:/import/";
		String fileName = "mxd.swf";
		String swfTools ="D:/applicaltion/SWFTools/pdf2swf.exe "; //这里如果配置环境变量的话应该会简写
		// 目标路径不存在则建立目标路径
		File dest = new File(destPath);
		if (!dest.exists()) {
			dest.mkdirs();
		}
		// 源文件不存在则返回
		File source = new File(sourcePath);
		if (!source.exists()) {
			System.out.println("no file");
		}
		// 调用pdf2swf命令进行转换
		String cd = swfTools + sourcePath + " -o " + destPath + fileName;
		System.out.println(cd);
		Process pro = Runtime.getRuntime().exec(cd);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		while (bufferedReader.readLine() != null){
			System.out.println("bufferedReader.readLine() : "+bufferedReader.readLine());
		};
		try {
			pro.waitFor();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		int i = pro.exitValue();
		if(i>=0){
			System.out.println("恭喜你成功了 嘎嘎**********");
		}

	}

	@Test
	public void testPdf2SwfThread() throws Exception{
		String sourcePath = "d:/import/css.pdf";
		String destPath = "d:/import/";
		String fileName = "mxd333.swf";
		String swfToolsPath ="D:/applicaltion/SWFTools/pdf2swf.exe "; //这里如果配置环境变量的话应该会简写
		// 目标路径不存在则建立目标路径
		File dest = new File(destPath);
		if (!dest.exists()) {
			dest.mkdirs();
		}
		// 源文件不存在则返回
		File source = new File(sourcePath);
		if (!source.exists()) {
			System.out.println("no file");
		}
		// 调用pdf2swf命令进行转换
	
		String comm = swfToolsPath + sourcePath + " -o " + destPath + fileName;
		
		Process pro = Runtime.getRuntime().exec(comm);
		
	   //防止线程堵塞 用两个线程来跑
		final InputStream is1 = pro.getInputStream();
		new Thread(new Runnable() {  
			    public void run() {  
			    	System.out.println("进入线程 pro.getInputStream()");
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is1));
			    	try {
						while ( bufferedReader.readLine() != null);
					}
					catch (IOException e) {
					}
			    }  
		}).start();
		final InputStream is2 = pro.getErrorStream();
		 new Thread(new Runnable() {  
			    public void run() {  
			    	System.out.println("进入线程pro.getErrorStream()");
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is2));
			    	try {
						while ( bufferedReader.readLine() != null);
					}
					catch (IOException e) {
					}
			    }  
		}).start();
		
		try {
			pro.waitFor();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		int count = pro.exitValue();
	
		
		
	}
	
	
	@Test
	public void isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		System.out.println("isWindowsOS :" + isWindowsOS);
	}

}
