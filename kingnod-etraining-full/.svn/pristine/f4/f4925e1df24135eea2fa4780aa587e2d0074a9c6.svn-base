package com.kingnod.etraining.common.service;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.kingnod.etraining.common.entity.Notice;
import com.kingnod.etraining.course.samplerte.server.FtpServer;
public class NoticeMailTest {
	
	@Test 
	public void testEntityToMap()throws Exception{
		Notice notice = new Notice();
		StringBuffer suf= new StringBuffer();
		//通过反射封装ENTITY 为对应Map对象
		Field field[] = notice.getClass().getDeclaredFields() ;
		for(int i=0;i<field.length ;i++){
			suf.append("name :");
			suf.append(field[i].getName());
			suf.append(" ,type :");
			suf.append(field[i].getGenericType().toString());
			suf.append(";----- ");
			field[i].setAccessible(true);
			suf.append(field[i].get(notice));
			suf.append("----- ; ");
			Map map = new HashMap<String, Object>();
			map.put(field[i].getName(),field[i].get(notice));
			

		}
		String str = suf.toString();
		System.out.println(str);
		
	}
	@Test
	public void testProcess() throws Exception{
		String[] command = new String[]{"/bin/sh", "-c", " ls "};
		Process process = Runtime.getRuntime().exec(command); // 调用外部程序  
		final InputStream is1 = process.getInputStream();  
		new Thread(new Runnable() {  
		    public void run() {  
		        BufferedReader br = new BufferedReader(new InputStreamReader(is1));   
		        try {
					while(br.readLine() != null) ;
				}
				catch (IOException e) {
					e.printStackTrace();
				}  
		    }  
		}).start(); // 启动单独的线程来清空process.getInputStream()的缓冲区  
		InputStream is2 = process.getErrorStream();  
		BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));   
		StringBuilder buf = new StringBuilder(); // 保存输出结果流  
		String line = null;  
		while((line = br2.readLine()) != null) buf.append(line); // 循环等待ffmpeg进程结束  
		System.out.println("输出结果为：" + buf);  

		
	}
	@Test
	public void testFtp(){
		 try {
		 FtpServer fu = new FtpServer(new URL("ftp://192.16.8.243:2121/course"), "admin", "admin");
		 fu.connectFTPServer();
//		 fu.uploadFile( new FileInputStream(new File("C:\\Users\\a\\Desktop\\csstt.pdf")),"\\course\\css\\csstt.pdf");
		 fu.uploadAll("C:\\Users\\a\\Desktop\\中文css.pdf", File.separator.concat("css"));
		 fu.closeFTPClient();
		 } catch (Exception e) {
		 System.out.println("异常信息：" + e.getMessage());
		 }finally{
			 
		 }
		 
		
	}

}
