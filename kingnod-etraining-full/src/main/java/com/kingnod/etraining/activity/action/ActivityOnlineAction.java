package com.kingnod.etraining.activity.action;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.course.service.PerformanceService;
import com.kingnod.etraining.security.entity.UserAccount;

/*
 * 在线活动在线人数统计
 */
@Namespace("/aty")
public class ActivityOnlineAction {

  @Autowired
  private PerformanceService  performanceService;
  
  private Long activityId;
 

  public String execute() throws Exception {
    if(activityId!=null){
       // 标识退出学习
      ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("isStudying", "false");
       performanceService.minusOnlineCount(activityId);
    }
    ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", null);
    return "jsonResult";
  }

  //是否有一门课程正在学习状态
  public String isStudyingStatus() throws Exception {
    String isStudying = (String)((UserAccount)SecurityUtils.getCurrentUser()).getAttribute("isStudying");
    ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", isStudying);
    return "jsonResult";
  }

  public Long getActivityId() {
    return activityId;
  }


  public void setActivityId(Long activityId) {
    this.activityId = activityId;
  }
  
  
}
