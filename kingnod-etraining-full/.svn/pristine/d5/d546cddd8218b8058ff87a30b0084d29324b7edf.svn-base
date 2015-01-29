package com.kingnod.etraining.course.datamodel;

import org.apache.commons.lang.StringUtils;

public class CMIIdentifier extends CMIDataType {

  @Override
  public boolean checkValid(String value) {
    boolean flag = false;
    
    //长度不能为0
    if (StringUtils.isNotBlank(value)&&value.length() < 255) {
      flag = true;
    }
    return flag;
  }

}
