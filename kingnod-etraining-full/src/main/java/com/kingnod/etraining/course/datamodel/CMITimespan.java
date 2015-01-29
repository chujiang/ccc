package com.kingnod.etraining.course.datamodel;

import java.util.regex.Pattern;

public class CMITimespan extends CMIDataType {

  @Override
  public boolean checkValid(String value) {
    boolean flag = false;
    String patternStr = "[0-9]{4}:[0-5][0-9]:[0-5][0-9][.]*[0-9]?[0-9]?";// 24hh:MM:SS.ss需要修改，时间格式为HHHH:MM:SS.ss
    boolean result = Pattern.matches(patternStr, value);
    if (result) {
      flag = false;
    }
   // return flag;
    return true;
  }
  
  
  public static void main(String [] args){
    CMITime c =new CMITime();
    System.out.print(c.checkValid("0001:09:19.33"));
  }

}
