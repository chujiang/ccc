package com.kingnod.etraining.course.utils;

public class AbbreviateUtil {
  // 缩写工具

  // 缩写状态
  public static String abbreviateStatus(String status) {
    if(status==null){
      status="";
    }
    
    if (status.equals("passed")) {
      return "P";
    } else if (status.equals("completed")) {
      return "C";
    } else if (status.equals("incomplete")) {
      return "I";
    } else if (status.equals("failed")) {
      return "F";
    } else if (status.equals("browsed")) {
      return "B";
    } else if (status.equals("not attempted")) {
      return "N";
    } else {
      return "N";
    }
  }

  // 展开
  public static String expandStatus(String status) {
    if(status==null){
      status="";
    }
    
    if (status.equals("P")) {
      return "passed";
    } else if (status.equals("C")) {
      return "completed";
    } else if (status.equals("I")) {
      return "incomplete";
    } else if (status.equals("F")) {
      return "failed";
    } else if (status.equals("B")) {
      return "browsed";
    } else if (status.equals("N")) {
      return "not attempted";
    } else {
      return "not attempted";
    }
  }

  public static String abbreviateEntry(String entry) {
    if ("ab-initio".equals(entry)) {
      return "I";
    } else if ("resume".equals(entry)) {
      return "R";
    } else {
      return "";
    }
  }

  public static String expandEntry(String entry) {
    if ("I".equals(entry)) {
      return "ab-initio";
    } else if ("R".equals(entry)) {
      return "resume";
    } else {
      return "";
    }
  }

  public static String abbreviateCredit(String credit) {
    if ("credit".equals(credit)) {
      return "Y";
    } else {
      return "N";
    }
  }

  public static String expandCredit(String credit) {
    if ("Y".equals(credit)) {
      return "credit";
    } else {
      return "no-credit";
    }
  }
  
  
//缩写状态
  public static String abbreviateExit(String exit) {
    if (exit.equals("time-out")) {
      return "T";
    } else if (exit.equals("suspend")) {
      return "S";
    } else if (exit.equals("logout")) {
      return "L";
    } else {
      return "";
    }
  }

  // 展开
  public static String expandExit(String exit) {
    if (exit.equals("T")) {
      return "time-out";
    } else if (exit.equals("S")) {
      return "suspend";
    } else if (exit.equals("L")) {
      return "logout";
    } else {
      return "";
    }
  }
  
  
  
//缩写状态
  public static String abbreviateLessonMode(String value) {
    if (value.equals("normal")) {
      return "N";
    } else if (value.equals("browse")) {
      return "B";
    } else if (value.equals("review")) {
      return "R";
    }else{
      return "N";
    }
  }

  // 展开
  public static String expandLessonMode(String value) {
    if (value.equals("N")) {
      return "normal";
    } else if (value.equals("B")) {
      return "browse";
    } else if (value.equals("R")) {
      return "review";
    } else {
      return "normal";
    }
  }

}
