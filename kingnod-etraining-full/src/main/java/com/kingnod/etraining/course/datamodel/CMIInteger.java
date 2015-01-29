package com.kingnod.etraining.course.datamodel;

import java.util.regex.Pattern;

public class CMIInteger extends CMIDataType {

  @Override
  public boolean checkValid(String value) {
    boolean flag = false;
    try {
      int i = Integer.valueOf(value);
      if (i >= 0 && i <= 65536) {
        flag = true;
      }
    } catch (NumberFormatException nfe) {
      return flag;
    }
    return flag;
  }
}
