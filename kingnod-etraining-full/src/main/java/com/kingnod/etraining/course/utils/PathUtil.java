package com.kingnod.etraining.course.utils;

import java.io.File;

public class PathUtil {

	public static String getLocalPath(String fileName){		
		StringBuffer bf = new StringBuffer(fileName);
		bf.reverse();
		int index = new String(bf).indexOf('\\');
		String temp = new String(bf).substring(index,bf.length());
		bf = new StringBuffer(temp);
		bf.reverse();
		return new String(bf);
	}
	// \\test\\long\\tudou\\   \\tudou\\long\\test\\
	public static String getRemotePath(String fileName){
		StringBuffer bf = new StringBuffer();
		if(fileName.indexOf(File.separator)>=0){
		rePlace(fileName);
		bf = new StringBuffer(fileName);
		bf.reverse();
		int index = new String(bf).indexOf(File.separator);
		String temp = new String(bf).substring(index,bf.length());
		bf = new StringBuffer(temp);
		bf.reverse();
		}else{
			return fileName;
		}
			
			
		return new String(bf);
	}
	
	public static String rePlace(String src){
		return src.replace('\\', '/');
	}
	
	public static String getFolderName(String src){
		src = rePlace(src);
		String[] s = src.split("/");
		return s[s.length-1];
	}
	
	public static String getFirstName(String src){
		src = rePlace(src);
		String[] s = src.split("/");
		for(String name : s){
			if(null != name.trim() && !name.trim().equals("")){
				return name;
			}
		}
		return s[0];
	}
}
