package com.kingnod.etraining.course.service;

/**
 * SCORM运行时环境Adapter API服务类
 * @author Chujiang
 *
 */
public interface LMSAdapterApiService {
  
  public String LMSInitilize(Long acivityId,Long courseId, Long scoId,String parameter);
  
  public String LMSFinish(Long acivityId,Long courseId, Long scoId,String parameter);
  
  public String LMSGetValue(Long courseId, Long scoId, String element);
  
  public String LMSSetValue(Long courseId, Long scoId, String element, String value);
  
  public String LMSCommit(Long acivityId,Long courseId, Long scoId,String parameter);
  
  public String LMSGetLastError(Long courseId, Long scoId);
  
  public String LMSGetErrorString(String errorCode);
  
  public String LMSGetDiagnostic(String errorCode);

}
