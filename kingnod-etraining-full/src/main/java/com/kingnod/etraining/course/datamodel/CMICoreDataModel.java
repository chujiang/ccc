package com.kingnod.etraining.course.datamodel;

import com.kingnod.etraining.course.annotation.HandlerMethod;
import com.kingnod.etraining.course.exception.LMSException;


public enum CMICoreDataModel {
  
  CORE_CHILDREN("cmi.core._children", true, false, new CMIString255()),
  CORE_STUDENT_ID("cmi.core.student_id", true, false, new CMIIdentifier()),
  CORE_STUDENT_NAME("cmi.core.student_name", true, false, new CMIString255()),
  CORE_LESSON_LOCATION("cmi.core.lesson_location", true, true, new CMIString255()),
  CORE_CREDIT("cmi.core.credit", true, false, new CMIVocabulary(new String[]{"credit", "no-credit"})),
  CORE_LESSON_STATUS("cmi.core.lesson_status", true, true, new CMIVocabulary(new String[]{"passed", "failed", "completed", "incomplete", "browsed", "not attempted"})),
  CORE_ENTRY("cmi.core.entry", true, false,  new CMIVocabulary(new String[]{"", "ab-initio", "resume"})),
  CORE_SCORE_CHILDREN("cmi.core.score._children", true, false,  new CMIString255()),
  CORE_SCORE_RAW("cmi.core.score.raw", true, true, new CMIDecimalOrBlank()),
  CORE_SCORE_MAX("cmi.core.score.max", true, true, new CMIDecimalOrBlank()),
  CORE_SCORE_MIN("cmi.core.score.min", true, true, new CMIDecimal()),
  CORE_TOTAL_TIME("cmi.core.total_time", true, false, new CMIDecimalOrBlank()),
  CORE_LESSON_MODE("cmi.core.lesson_mode", true, false, new CMIVocabulary(new String[]{"normal", "browse", "review"})),
  CORE_EXIT("cmi.core.exit", false, true, new CMIVocabulary(new String[]{"", "time-out", "suspend", "logout"})),
  CORE_SESSION_TIME("cmi.core.session_time", false, true, new CMITimespan()),
  SUSPEND_DATA("cmi.suspend_data", true, true, new CMIString4096()),
  LAUNCH_DATA("cmi.launch_data", true, false, new CMIString4096()),
  MASTERY_SCORE("cmi.student_data.mastery_score", true, false, new CMIDecimal());
  
  private CMICoreDataModel(String dataModelName, boolean readEnable, boolean writeEnable, CMIDataType dataType){
    this.dataModelName = dataModelName;
    this.readEnable = readEnable;
    this.writeEnable = writeEnable;
    this.dataType = dataType;
  }
  
  public static CMICoreDataModel getCMICoreDataModel(String name) throws LMSException {
    if("cmi.core._children".equals(name)){
      return CORE_CHILDREN;
    }else if("cmi.core.student_id".equals(name)){
      return CORE_STUDENT_ID;
    }else if("cmi.core.student_name".equals(name)){
      return CORE_STUDENT_NAME;
    }else if("cmi.core.lesson_location".equals(name)){
      return CORE_LESSON_LOCATION;
    }else if("cmi.core.credit".equals(name)){
      return CORE_CREDIT;
    }else if("cmi.core.lesson_status".equals(name)){
      return CORE_LESSON_STATUS;
    }else if("cmi.core.entry".equals(name)){
      return CORE_ENTRY;
    }else if("cmi.core.score._children".equals(name)){
      return CORE_SCORE_CHILDREN;
    }else if("cmi.core.score.raw".equals(name)){
      return CORE_SCORE_RAW;
    }else if("cmi.core.score.max".equals(name)){
      return CORE_SCORE_MAX;
    }else if("cmi.core.score.min".equals(name)){
      return CORE_SCORE_MIN;
    }else if("cmi.core.total_time".equals(name)){
      return CORE_TOTAL_TIME;
    }else if("cmi.core.lesson_mode".equals(name)){
      return CORE_LESSON_MODE;
    }else if("cmi.core.exit".equals(name)){
      return CORE_EXIT;
    }else if("cmi.core.session_time".equals(name)){
      return CORE_SESSION_TIME;
    }else if("cmi.suspend_data".equals(name)){
      return SUSPEND_DATA;
    }else if("cmi.launch_data".equals(name)){
      return LAUNCH_DATA;
    }else if("cmi.student_data.mastery_score".equals(name)){
      return MASTERY_SCORE;
    }else{
      throw new LMSException("201");
    }
  }
  public final String dataModelName;
  public final boolean readEnable;
  public final boolean writeEnable;
  public final CMIDataType dataType;
}