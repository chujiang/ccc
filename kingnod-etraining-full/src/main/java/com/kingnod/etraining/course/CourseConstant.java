package com.kingnod.etraining.course;

import java.math.BigDecimal;

public class CourseConstant {
  
  private CourseConstant() {
  }
  
  public static String FALSE="false";
  public static String TRUE="true";
  //常量名需要大写，词与词之间用“_”分隔， 例如：public static final String RECORD_STATUS_ACTIVE = "A";
  /**
   * 标准的SCORM课程
   */
  public static final String COURSE_TYPE_SCORM = "S";
  /**
   * 非标准课程
   */
  public static final String COURSE_TYPE_NOSCORM = "F";
  /**
   * 课程费用类型：个人
   */
  public static final String COURSE_COST_PERSONAL = "P";
  /**
   * 课程费用类型：公司
   */
  public static final String COURSE_COST_COMPANY = "C";
  /**
   * 课程学习导航：系统导航
   */
  public static final String COURSE_NAVIGATE_SYSTEM = "S";
  /**
   * 课程学习导航：课程导航
   */
  public static final String COURSE_NAVIGATE_COURSE = "C";
  
  public static final String COURSE_SEPARATOR = ".";
  public static final Long  DEFAULT_TIME=-1l;
  public static final BigDecimal  DEFAULT_SCORE=  new BigDecimal(-1);
  public static final String  DEFAULT_COMPLETEDPERCENTAGE="0";
  
  
  /**
   * 通过
   */
  public static final String COURSESTATUS_PASSED = "P";
  
  /**
   * 完成
   */
  public static final String COURSESTATUS_COMPLETED = "C";
  
  
  /**
   * 未完成
   */
  public static final String COURSESTATUS_INCOMPLETE = "I";
  
  /**
   * 失败
   */
  public static final String COURSESTATUS_FAILED = "F";
  
  /**
   * 浏览
   */
  public static final String COURSESTATUS_BROWSED = "B";
  
  /**
   * 未尝试
   */
  public static final String COURSESTATUS_NOTATTEMPTED = "N";
  
  /**
   * 评论类别父节点
   */
  public static final int EVALUATION_TYPE_PARENT = -1;
  
  
  /**
   * 搜索类型_课程 即活动
   */
  public static final String SEARCHTYPE_ACTIVITY="activity";
  
  /**
   * 搜索类型_资讯
   */
  public static final String SEARCHTYPE_INFO = "info";
  
  
  /**
   * 搜索类型_所有
   */
  //public static final String SEARCHTYPE_ALL ="all";
  
  /**
   * 搜索类型_在线学习
   */
  //public static final String SEARCHTYPE_ELEARNING ="elearning";
  
  /**
   * 搜索类型_面授培训
   */
  //public static final String SEARCHTYPE_TRAINS ="trains";
  /**
   * 课件发布状态
   * P：未发布， C: 审核中， R：已发布';
   */
  public static final String RELEASE_STATUS_P = "P";
  public static final String RELEASE_STATUS_C = "C";
  public static final String RELEASE_STATUS_R = "R";
 
  
}
