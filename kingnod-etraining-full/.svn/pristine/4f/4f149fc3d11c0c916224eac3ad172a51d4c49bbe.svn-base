package com.kingnod.etraining.course.datamodel;

import java.util.regex.Pattern;

public class CMIDecimal extends CMIDataType {

  @Override
  public boolean checkValid(String value) {
    boolean flag = false;
    String patternStr = "^[-\\+]?[.\\d]+$";// 判断是否是浮点数
    boolean result = Pattern.matches(patternStr, value);
    if (result) {
      flag = false;
    }
    return flag;
  }

}
