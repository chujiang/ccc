package com.kingnod.etraining.course.adapter;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.spring.SpringCreator;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.course.service.LMSAdapterApiService;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@RemoteProxy(name="Scorm12APIAdapter", creator=SpringCreator.class)
public class Scorm12APIAdapter {
  
  protected static Logger log = LoggerFactory.getLogger(Scorm12APIAdapter.class);
  
  @Autowired
  private LMSAdapterApiService adapterApiService;
  
 
  @RemoteMethod
  public String LMSInitilize(Long acivityId,Long courseId, Long scoId,String parameter){
    String result="";
    if(log.isDebugEnabled()){
      log.debug("**********[Scorm12Log LMSInitilize: acivityId = " + acivityId + ",courseId = " + courseId + ", scoId = " + scoId+"]**********");
      logDetalsInfo();
    }
    final WebContext wctx = WebContextFactory.get();
    HttpServletRequest request = wctx.getHttpServletRequest();
    result = adapterApiService.LMSInitilize(acivityId,courseId, scoId,parameter);
    if(log.isDebugEnabled()){
       log.debug("Scorm12Log LMSInitilize: result = " + result);
       logDetalsInfo();
    }
    return result;
  }
  
  @RemoteMethod
  public String LMSFinish(Long acivityId,Long courseId, Long scoId, String parameter){
    String result="";
    if(log.isDebugEnabled()){
      log.debug("**********[Scorm12Log LMSFinish: acivityId = " + acivityId + ",courseId = " + courseId + ", scoId = " + scoId+ ", parameter = " + parameter+"]**********");
      logDetalsInfo();
    }
    final WebContext wctx = WebContextFactory.get();
    HttpServletRequest request = wctx.getHttpServletRequest();
    result =  adapterApiService.LMSFinish(acivityId,courseId, scoId,parameter);
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSFinish: result = " + result);
      logDetalsInfo();
   }
   return result;
  }
  
  @RemoteMethod
  public String LMSGetValue(Long courseId, Long scoId, String element){
    String result="";
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSGetValue: courseId = " + courseId + ", scoId = " + scoId+", element = "+element);
      logDetalsInfo();
    }
    final WebContext wctx = WebContextFactory.get();
    HttpServletRequest request = wctx.getHttpServletRequest();
    result = adapterApiService.LMSGetValue(courseId, scoId, element);
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSGetValue: result = " + result);
      logDetalsInfo();
   }
   return result;
  }
  
  @RemoteMethod
  public String LMSSetValue(Long courseId, Long scoId, String element, String value){
    String result="";
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSSetValue: courseId = " + courseId + ", scoId = " + scoId+", element = " + element + ", value = " + value);
      logDetalsInfo();
    }
    final WebContext wctx = WebContextFactory.get();
    HttpServletRequest request = wctx.getHttpServletRequest();
    result = adapterApiService.LMSSetValue(courseId, scoId, element, value);
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSSetValue: result = " + result);
      logDetalsInfo();
   }
   return result;
  }
  
  @RemoteMethod
  public String LMSCommit(Long acivityId,Long courseId, Long scoId, String parameter){
    String result="";
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSCommit:acivityId = " + acivityId + ",courseId = " + courseId + ", scoId = " + scoId+",  parameter = " + parameter);
      logDetalsInfo();
    }
    final WebContext wctx = WebContextFactory.get();
    HttpServletRequest request = wctx.getHttpServletRequest();
    result = adapterApiService.LMSCommit(acivityId,courseId, scoId,parameter);
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSCommit: result = " + result);
      logDetalsInfo();
   }
   return result;
  }
  
  @RemoteMethod
  public String LMSGetLastError(Long courseId, Long scoId){
    String result="";
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSGetLastError: courseId = " + courseId + ", scoId = " + scoId);
      logDetalsInfo();
    }
    final WebContext wctx = WebContextFactory.get();
    HttpServletRequest request = wctx.getHttpServletRequest();
    result = adapterApiService.LMSGetLastError(courseId, scoId);
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSGetLastError: result = " + result);
      logDetalsInfo();
   }
   return result;
  }
  
  @RemoteMethod
  public String LMSGetErrorString(String errorCode){
    String result="";
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSGetErrorString: errorCode = " + errorCode);
      logDetalsInfo();
    }
    final WebContext wctx = WebContextFactory.get();
    HttpServletRequest request = wctx.getHttpServletRequest();
    result = adapterApiService.LMSGetErrorString(errorCode);
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSGetErrorString: result = " + result);
      logDetalsInfo();
   }
   return result;
  }
  
  @RemoteMethod
  public String LMSGetDiagnostic(String errorCode){
    String result="";
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSGetDiagnostic: errorCode = ", errorCode);
      logDetalsInfo();
    }
    result = adapterApiService.LMSGetDiagnostic(errorCode);
    if(log.isDebugEnabled()){
      log.debug("Scorm12Log LMSGetDiagnostic: result = " + result);
      logDetalsInfo();
   }
   return result;
  }
  
  private void logDetalsInfo(){
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    
   /* String isLMSIntialized = (String) userDetails.getAttribute("isLMSIntialized");
    Long courseId =  null!=userDetails.getAttribute("courseId")?(Long)userDetails.getAttribute("courseId"):0L;
    Long scoId = null!=userDetails.getAttribute("courseId")?(Long)userDetails.getAttribute("scoId"):0L;
    Long attempId = null!=userDetails.getAttribute("courseId")?(Long)userDetails.getAttribute("attempId"):0L; 
    String last_error_code = (String) userDetails.getAttribute("lms.scorm12.last_error_code");
    
    log.debug("Scorm12Log Details: isLMSIntialized= " + isLMSIntialized+
                           ", courseId="+courseId+
                           ", scoId="+scoId+
                          ", last_error_code="+last_error_code+
                          ", attempId="+attempId);*/
  }

}
