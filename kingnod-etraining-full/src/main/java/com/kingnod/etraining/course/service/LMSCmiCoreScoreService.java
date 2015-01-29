package com.kingnod.etraining.course.service;

import com.kingnod.etraining.course.annotation.DataModelHandler;
import com.kingnod.etraining.course.annotation.HandlerMethod;
import com.kingnod.etraining.course.exception.LMSException;

@DataModelHandler({ 
  @HandlerMethod(name = "cmi.core.score._children", type = "get", method = "getChildren"),
  @HandlerMethod(name = "cmi.core.score.raw", type = "get", method = "getRaw"),
  @HandlerMethod(name = "cmi.core.score.raw", type = "set", method = "setRaw"),
  @HandlerMethod(name = "cmi.core.score.max", type = "get", method = "getMax"),
  @HandlerMethod(name = "cmi.core.score.max", type = "set", method = "setMax"),
  @HandlerMethod(name = "cmi.core.score.min", type = "get", method = "getMin"),
  @HandlerMethod(name = "cmi.core.score.min", type = "set", method = "setMin")
})
public interface LMSCmiCoreScoreService {
  
  public String getChildren(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public String getRaw(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public void setRaw(Long courseId, Long scoId,Long userId, String value) throws LMSException;
  
  public String getMax(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public void setMax(Long courseId, Long scoId,Long userId, String value) throws LMSException;
  
  public String getMin(Long courseId, Long scoId,Long userId) throws LMSException;
  
  public void setMin(Long courseId, Long scoId,Long userId, String value) throws LMSException;
  
}
