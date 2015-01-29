package com.kingnod.etraining.common.util;

import org.apache.commons.lang.xwork.StringUtils;

public class StrUtil {
	
  //截取字符串 超过长度用点代替
	public static String getShortSize(String s,int strLong)
	{
	  String rs="";
	  if(StringUtils.isNotEmpty(s)){
		 if(s.length()>strLong){
		   rs = s.substring(0, strLong)+"...";
		 }
	  }
		
		return rs;
	}
	
/*	public static void main(String[] args) {
		System.out.print(getShortSize("dddfddddfddddfd",10));
	}
	*/

}
