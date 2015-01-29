package com.kingnod.etraining.activity;

public final class ActivityConstant {
  
  private ActivityConstant() {
  }
  
  //常量名需要大写，词与词之间用“_”分隔， 例如：public static final String RECORD_STATUS_ACTIVE = "A";
  public static final String WORK_FLOW_TYPE="TrainingPlan";
  public static final String PREVIEW = "preview"; // 预览
  public static final String PREVIEW_IFRAME = "preview_iframe"; // 预览
  
  public static final String ENROLL_MOLEL_F = "F"; // 注册类型-强制注册
  
  public static final String ENROLL_MOLEL_S = "S"; // 注册类型-自行注册
  
  public static final String ENROLL_MOLEL_C = "C"; // 注册类型-审核课程

  public static final String ENROLL_STATUS_N = "N";  //课程注册状态 未注册
  
  public static final String ENROLL_STATUS_R = "R";  //课程注册状态 已注册
  
  public static final String ENROLL_STATUS_O = "O";  //课程注册状态 已注消
  //D：每天， W: 工作日， N：无限制， S：特定
  public static final String ACTIVITY_DATETYPE_DATE = "D";
  public static final String ACTIVITY_DATETYPE_WEEK = "W";
  public static final String ACTIVITY_DATETYPE_NONE = "N";
  public static final String ACTIVITY_DATETYPE_SPECIAL = "S";
  
  public static final String EXAM_AVAILABILITY_RECORD = "availability";//有效
  
  public static final String EXAM_INEFFICACY_RECORD = "inefficacy";//无效
  
  
  public static final String RELEASESTAUTS_R="R";
  
  public static final String RELEASESTAUTS_C="C";
  
  public static final String RELEASESTAUTS_P="P";
  //允许注销Y
  public static final String ALLOW_LOGOUT_Y = "Y";
  public static final String ALLOW_LOGOUT_N = "N";
  
  public static final String PREVIEWES_TYPE_E = "E";//预览标识，考试活动预览
  public static final String PREVIEWES_TYPE_P = "P";//预览标识，试卷预览
  public static final String PREVIEWES_TYPE_D = "D";//预览标识，知识点预览
  public static final String PREVIEWES_TYPE_Q = "Q";//预览标识，组卷预览
  public static final String PREVIEWES_TYPE_N = "N";//预览标识，组卷新建试题页面的预览
}
