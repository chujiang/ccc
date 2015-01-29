package com.kingnod.etraining.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class WorkflowConstant {
  
  private WorkflowConstant() {
  }
  
  //通过
  public static final String FLOW_STATUS_APPROVE = "approve";
  
  //拒绝
  public static final String FLOW_STATUS_REJECT = "reject";
  
  //驳回
  public static final String FLOW_STATUS_ADJUST = "adjust";
  
  public static final String YES = "yes";
  
  public static final String NO = "no";
  
  public static final Map<String,ArrayList<String>> taskIds = new HashMap<String,ArrayList<String>>();

}
