package com.kingnod.etraining.course.datamodel;


public class CMIString255 extends CMIDataType {

  @Override
  public boolean checkValid(String value) {
    boolean flag = false;
    
    if (null != value && value.length() < 255) {
      flag = true;
    }
    return flag;
  }

}
