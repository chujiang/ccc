package com.kingnod.etraining.course.datamodel;

import java.util.regex.Pattern;

public class CMITime extends CMIDataType {

  @Override
  public boolean checkValid(String value) {
    boolean flag = false;
    String patternStr = "(([0-1][0-9])|2[0-3]):[0-5][0-9]:[0-5][0-9][.]?[0-9]?";// 24hh:MM:SS.ss
    boolean result = Pattern.matches(patternStr, value);
    if (result) {
      flag = false;
    }
    return flag;
    
  }

  
  public static void main(String [] args){
    CMITime c =new CMITime();
    System.out.print(c.checkValid("12:09:19.33"));
  }
}
