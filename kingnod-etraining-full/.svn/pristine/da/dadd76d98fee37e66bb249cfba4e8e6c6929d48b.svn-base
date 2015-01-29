package com.kingnod.etraining.course.service;

import com.kingnod.etraining.course.annotation.DataModelHandler;
import com.kingnod.etraining.course.annotation.HandlerMethod;
import com.kingnod.etraining.course.exception.LMSException;

/**
 * SCORM core data model服务类， 主要处理LMS API Adapter的LMSGetValue和LMSSetValue针对于cmi.core的具体实现
 * @author Chujiang
 *
 */
@DataModelHandler({ 
    @HandlerMethod(name = "cmi.core._children", type = "get", method = "getChildren"),
    @HandlerMethod(name = "cmi.core.student_id", type = "get", method = "getStudentId"),
    @HandlerMethod(name = "cmi.core.student_name", type = "get", method = "getStudentName"),
    @HandlerMethod(name = "cmi.core.lesson_location", type = "set", method = "setLessonLocation"),
    @HandlerMethod(name = "cmi.core.lesson_location", type = "get", method = "getLessonLocation"),
    @HandlerMethod(name = "cmi.core.credit", type = "get", method = "getCredit"),
    @HandlerMethod(name = "cmi.core.lesson_status", type = "set", method = "setLessonStatus"),
    @HandlerMethod(name = "cmi.core.lesson_status", type = "get", method = "getLessonStatus"),
    @HandlerMethod(name = "cmi.core.entry", type = "get", method = "getEntry"),
    @HandlerMethod(name = "cmi.core.total_time", type = "get", method = "getTotalTime"),
    @HandlerMethod(name = "cmi.core.lesson_mode", type = "get", method = "getLessonMode"),
    @HandlerMethod(name = "cmi.core.exit", type = "set", method = "setExit"),
    @HandlerMethod(name = "cmi.core.session_time", type = "set", method = "setSessionTime"),
    @HandlerMethod(name = "cmi.suspend_data", type = "set", method = "setSuspendData"),
    @HandlerMethod(name = "cmi.suspend_data", type = "get", method = "getSuspendData"),
    @HandlerMethod(name = "cmi.launch_data", type = "get", method = "getLaunch_Data"),
    @HandlerMethod(name = "cmi.student_data.mastery_score", type = "get", method = "getMasteryScore")
    })
public interface LMSCmiCoreService {
  
  public String getChildren(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getStudentId(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getStudentName(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public void setLessonLocation(Long courseId, Long scoId,Long userId, String value) throws LMSException;
  
  public String getLessonLocation(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getCredit(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public void setLessonStatus(Long courseId, Long scoId,Long userId, String value) throws LMSException;
  
  public String getLessonStatus(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getEntry(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getTotalTime(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getLessonMode(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public void setExit(Long courseId, Long scoId,Long userId, String value) throws LMSException;
  
  public void setSessionTime(Long courseId, Long scoId,Long userId, String value) throws LMSException;
  
  public void setSuspendData(Long courseId, Long scoId,Long userId, String value) throws LMSException;
  
  public String getSuspendData(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getLaunch_Data(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getMasteryScore(Long courseId, Long scoId,Long userId) throws LMSException;
  
}
