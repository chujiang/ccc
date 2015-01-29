package com.kingnod.etraining.course.service.impl;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.reflect.ReflectionUtils;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.annotation.DataModelHandler;
import com.kingnod.etraining.course.annotation.HandlerMethod;
import com.kingnod.etraining.course.datamodel.CMICoreDataModel;
import com.kingnod.etraining.course.exception.LMSException;
import com.kingnod.etraining.course.service.AttempService;
import com.kingnod.etraining.course.service.LMSAdapterApiService;
import com.kingnod.etraining.course.service.LMSCmiCoreScoreService;
import com.kingnod.etraining.course.service.LMSCmiCoreService;
import com.kingnod.etraining.course.service.PerformanceService;
import com.kingnod.etraining.course.service.SCOPerformanceService;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@org.springframework.stereotype.Service
public class LMSAdapterApiServiceImpl implements LMSAdapterApiService {
  
  protected static Logger log = LoggerFactory.getLogger(LMSAdapterApiServiceImpl.class);

  private static HashMap<String, String> errorStringMap = new HashMap<String, String>();
  private static HashMap<String, String> errorDiagnosticMap = new HashMap<String, String>();
  
  @Autowired
  private LMSCmiCoreService cmiCoreService;
  
  @Autowired
  private LMSCmiCoreScoreService cmiCoreScoreService;
  
  
  
  @Autowired
  private AttempService attempService;
  
  @Autowired
  private SCOPerformanceService scoPerformanceService;
  
  @Autowired
  private PerformanceService performanceService;
  

  static {
    errorStringMap.put("0", "No error");
    errorStringMap.put("101", "General exception");
    errorStringMap.put("201", "Invalid argument error");
    errorStringMap.put("202", "Element cannot have children");
    errorStringMap.put("203", "Element is not an array");
    errorStringMap.put("301", "Not initialized");
    errorStringMap.put("401", "Not implemented error");
    errorStringMap.put("402", "Invalid set value");
    errorStringMap.put("403", "Element is read only");
    errorStringMap.put("404", "Element is write only.");
    errorStringMap.put("405", "Incorrect Data Type");

    errorDiagnosticMap.put("0", "No error. No errors were encountered. Successful API call.");
    errorDiagnosticMap.put("101", "General exception. An unexpected error was encountered.");
    errorDiagnosticMap.put("201", "Invalid argument error. A call was made to a DataModel element that does not exist.");
    errorDiagnosticMap.put("202", "Element cannot have children. A call was made to an Element that does not support _children");
    errorDiagnosticMap.put("203", "Element is not an array.  Cannot have count. A call was made to an Element that does not support _count.");
    errorDiagnosticMap.put("301", "Not initialized. The SCO has not yet been initialized.  It needs to call LMSInitialize() first.");
    errorDiagnosticMap.put("401", "Not implemented error.  A call was made to a DataModel element that is not supported.");
    errorDiagnosticMap.put("402", "Invalid set value, element is a keyword.  Keyword values cannot be changed");
    errorDiagnosticMap.put("403", "Element is read only.  A call was made to set the value of a read-only element.");
    errorDiagnosticMap.put("404", "Element is write only.  A call was made to get the value of a write-only element.");
    errorDiagnosticMap.put("405", "Incorrect Data Type.  The syntax of a call to change an element was incorrect.");
  }
  
  /**i
   * 
   */
  public String LMSInitilize(Long acivityId,Long courseId, Long scoId, String parameter) {
    String result=CourseConstant.FALSE;
    boolean isLMSIntialized =false;
    //先清除变量
    ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("isLMSIntialized", "false");//是否初始化
    ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("courseId", null);
    ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("scoId",  null);
    ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("attempId", null);
    
    try {
        log.debug("LMSInitilizing");

       UserAccount userDetails = SecurityUtils.getCurrentUser();
       
       Long userId = null!=userDetails.getId()?userDetails.getId():0L;
       
       String isLMSIntialized_ = (String)userDetails.getAttribute("isLMSIntialized");
        if (StringUtils.isNotEmpty(parameter)) {
          isLMSIntialized = Boolean.parseBoolean(isLMSIntialized_);
        }
      
    
      // 如果不为空异常
      if (StringUtils.isNotEmpty(parameter)) {
        result = CourseConstant.FALSE;
        throw new LMSException("201");
      }
      
      //如果已经初始化就异常否则进行初始化
      if(isLMSIntialized)
      {
        result = CourseConstant.FALSE;
        throw new LMSException("101");
      }
      else
      {
        attempService.initAttemp(courseId, scoId, userId);
        scoPerformanceService.initSCOPerformance(courseId, scoId, userId);
        performanceService.initPerformance(acivityId,courseId, userId);
        

        
        //保存变量信息
        ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("isLMSIntialized", "true");//是否初始化
        ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("courseId", courseId);
        ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("scoId", scoId);
     
        isLMSIntialized=true;
        result =  CourseConstant.TRUE;
      }
      log.debug("LMSInitilized");
    } catch (LMSException le) {
      exceptionHandler(le);
      result = CourseConstant.FALSE;
    }catch (Exception e) {
      exceptionHandler(e);
      result = CourseConstant.FALSE;
    }
    return result;
  }

  public String LMSFinish(Long acivityId,Long courseId, Long scoId,String parameter) {
    String result=CourseConstant.FALSE;
    
    try {
      log.debug("LMSFinish start");
      UserAccount userDetails = SecurityUtils.getCurrentUser();
      //Long userId = userDetails.getId();
      Long userId = null!=userDetails.getId()?userDetails.getId():0L;
      boolean isLMSIntialized =Boolean.parseBoolean((String)userDetails.getAttribute("isLMSIntialized"));
    
      // 如果不为空异常
      if (StringUtils.isNotEmpty(parameter)) {
        result = CourseConstant.FALSE;
        throw new LMSException("201");
      }
      
      if (!isLMSIntialized)
      {
        result = CourseConstant.FALSE;
        throw new LMSException("301");
      }
      else
      {
        //更新数据
        attempService.finishAttemp(courseId, scoId, userId);
        scoPerformanceService.finishSCOPerformance(courseId, scoId, userId);
        performanceService.finishPerformance(acivityId,courseId, userId);
        
        //isLMSIntialized =false;
        result =  CourseConstant.TRUE;
      }
      
    
    //清空变量信息
    ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("isLMSIntialized", "false");//是否初始化
    ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("courseId", null);
    ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("scoId",  null);
    ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("attempId", null);
    
    } catch (LMSException e){
      exceptionHandler(e);
    }catch (Exception e) {
      exceptionHandler(e);
      result = CourseConstant.FALSE;
    }
    
    return result;
  }

  public String LMSGetValue(Long courseId, Long scoId, String element) {
    
    String result="";
    try{
      UserAccount userDetails = SecurityUtils.getCurrentUser();
      //Long userId = userDetails.getId();//目前取不到
      Long userId = null!=userDetails.getId()?userDetails.getId():0L;
      boolean isLMSIntialized =Boolean.parseBoolean((String)userDetails.getAttribute("isLMSIntialized"));
      
      if (!isLMSIntialized)
      {
        //result = CourseConstant.FALSE;
        throw new LMSException("301");
      }
      
      CMICoreDataModel cmiCoreDataModel = CMICoreDataModel.getCMICoreDataModel(element);
      if(!cmiCoreDataModel.readEnable && cmiCoreDataModel.writeEnable){
        throw new LMSException("404");
      }
      
      if(LMSCmiCoreService.class.isAnnotationPresent(DataModelHandler.class)){
        DataModelHandler dataModelHandler = LMSCmiCoreService.class.getAnnotation(DataModelHandler.class);
        for(HandlerMethod handlerMethod:dataModelHandler.value()){
          if(handlerMethod.name().equals(element) && handlerMethod.type().equals("get")){
            result =(String)  ReflectionUtils.invokeMethod(this.cmiCoreService, handlerMethod.method(), new Class[]{Long.class, Long.class, Long.class}, new Object[]{courseId, scoId,userId});
          }
        }
      }
      
      if(LMSCmiCoreScoreService.class.isAnnotationPresent(DataModelHandler.class)){
        DataModelHandler dataModelHandler = LMSCmiCoreScoreService.class.getAnnotation(DataModelHandler.class);
        for(HandlerMethod handlerMethod:dataModelHandler.value()){
          if(handlerMethod.name().equals(element) && handlerMethod.type().equals("get")){
            result =(String)  ReflectionUtils.invokeMethod(this.cmiCoreScoreService, handlerMethod.method(), new Class[]{Long.class, Long.class, Long.class}, new Object[]{courseId, scoId,userId});
          }
        }
      }
      
      //LoggedUserDetails userDetails = SecurityUtils.getCurrentUser();
      userDetails.setAttribute("lms.scorm12.last_error_code", "0");
      
    } catch (LMSException e){
      exceptionHandler(e);
    }catch (Exception e) {
      exceptionHandler(e);
      result = CourseConstant.FALSE;
    }
    if(null==result){
      result="";
    }
   
    return result;
  }

  public String LMSSetValue(Long courseId, Long scoId, String element, String value) {
    String result = "";
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    //Long userId = userDetails.getId();
    Long userId = null!=userDetails.getId()?userDetails.getId():0L;
    boolean isLMSIntialized =Boolean.parseBoolean((String)userDetails.getAttribute("isLMSIntialized"));
    
    try{
      if (!isLMSIntialized)
      {
        result = CourseConstant.FALSE;
        throw new LMSException("301");
      }
      
      
      CMICoreDataModel cmiCoreDataModel = CMICoreDataModel.getCMICoreDataModel(element);
      if(!cmiCoreDataModel.writeEnable){
        result = CourseConstant.FALSE;
        throw new LMSException("403");
      }
      if(!cmiCoreDataModel.dataType.checkValid(value)){
        result = CourseConstant.FALSE;
        throw new LMSException("405");
      }
      if(LMSCmiCoreService.class.isAnnotationPresent(DataModelHandler.class)){
        DataModelHandler dataModelHandler = LMSCmiCoreService.class.getAnnotation(DataModelHandler.class);
        for(HandlerMethod handlerMethod:dataModelHandler.value()){
          if(handlerMethod.name().equals(element) && handlerMethod.type().equals("set")){
            ReflectionUtils.invokeMethod(this.cmiCoreService, handlerMethod.method(), new Class[]{Long.class, Long.class, Long.class, String.class}, new Object[]{courseId, scoId, userId,value});
          }
        }
      }
      
      
      
      if(LMSCmiCoreScoreService.class.isAnnotationPresent(DataModelHandler.class)){
        DataModelHandler dataModelHandler = LMSCmiCoreScoreService.class.getAnnotation(DataModelHandler.class);
        for(HandlerMethod handlerMethod:dataModelHandler.value()){
          if(handlerMethod.name().equals(element) && handlerMethod.type().equals("set")){
             ReflectionUtils.invokeMethod(this.cmiCoreScoreService, handlerMethod.method(), new Class[]{Long.class, Long.class, Long.class, String.class}, new Object[]{courseId, scoId,userId,value});
          }
        }
      }
      result = CourseConstant.TRUE;
    } catch (LMSException e){
      result = CourseConstant.FALSE;
      exceptionHandler(e);
    }catch (Exception e) {
      exceptionHandler(e);
      result = CourseConstant.FALSE;
    }
    
    return result;
  }

  public String LMSCommit(Long acivityId,Long courseId, Long scoId,String parameter) {
    //log.debug("LMSCommit start");
    String result=CourseConstant.FALSE;
    try {
      UserAccount userDetails = SecurityUtils.getCurrentUser();
      Long userId = userDetails.getId();
      boolean isLMSIntialized =Boolean.parseBoolean((String)userDetails.getAttribute("isLMSIntialized"));
      
    // 如果不为空异常
    if (StringUtils.isNotEmpty(parameter)) {
      result = CourseConstant.FALSE;
      throw new LMSException("201");
    }
    
    if (!isLMSIntialized)
    {
      result = CourseConstant.FALSE;
      throw new LMSException("301");
    }
    
    //更新数据
    attempService.finishAttemp(courseId, scoId, userId);
    scoPerformanceService.finishSCOPerformance(courseId, scoId, userId);
    performanceService.finishPerformance(acivityId,courseId, userId);
    
    result = CourseConstant.TRUE;
    } catch (LMSException le) {
      exceptionHandler(le);
      result = CourseConstant.FALSE;
    }catch (Exception e) {
      exceptionHandler(e);
      result = CourseConstant.FALSE;
    }
    return result;
  }

  public String LMSGetLastError(Long courseId, Long scoId) {
   UserAccount userDetails = SecurityUtils.getCurrentUser();
   //System.out.println("laixiao"+userDetails.getUsername());
    String errorCode = (String)userDetails.getAttribute("lms.scorm12.last_error_code");
    if(StringUtils.isEmpty(errorCode)){
      return "0";
    }
    
    return errorCode;
    //return "";
  }

  public String LMSGetErrorString(String errorCode) {
    String errorString = errorStringMap.get(errorCode);
    return errorString;
  }

  public String LMSGetDiagnostic(String errorCode) {
    String errorDiagnostic = errorDiagnosticMap.get(errorCode);
    return errorDiagnostic;
  }

  private void exceptionHandler(Exception exception) {
    String errorCode = "0";
    if (exception instanceof LMSException) {
      errorCode = ((LMSException) exception).getErrorCode();
    } else {
      errorCode = "101";
    }
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    userDetails.setAttribute("lms.scorm12.last_error_code", errorCode);
  }

}
