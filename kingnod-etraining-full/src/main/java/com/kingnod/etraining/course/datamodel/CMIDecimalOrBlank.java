package com.kingnod.etraining.course.datamodel;

import java.util.regex.Pattern;

public class CMIDecimalOrBlank extends CMIDataType {

  @Override
  public boolean checkValid(String value) {
    boolean flag = false;
    String patternStr = "^[-\\+]?[.\\d]*$";// 判断是否是浮点数或者为空
    boolean result = Pattern.matches(patternStr, value);
    if (result) {
      flag = false;
    }
    //return flag;  //后面完善
    return true;
  }

  public static void main(String [] args){
    CMITime c =new CMITime();
    System.out.print(c.checkValid("90"));
  }
}
