package com.kingnod.etraining.course.datamodel;

import org.apache.commons.lang.StringUtils;

public class CMIVocabulary extends CMIDataType {

  private String[] vocabularies;

  public CMIVocabulary(String[] vocabularies) {
    this.vocabularies = vocabularies;
  }

  @Override
  public boolean checkValid(String value) {

    if (null != value) {
      for (int j = 0; j < vocabularies.length; j++) {
        if (value.equals(vocabularies[j]))
          return true;
      }
    }
    return false;
  }

}
