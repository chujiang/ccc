package com.kingnod.etraining.course.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class TimeUtil {

  
  //时间转换为秒  HHHH:MM::SS.SS 00:09:19.33
/*  public static Long transSecond(String time) {
    
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date d =null;
    try {
      d = sdf.parse(time);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return d.getTime();
  }*/
  
  public static String secToHHMMSS(Long seconds)
  {
      long hours = seconds / 3600;
      long mins = (seconds - hours * 3600) / 60;
      seconds = seconds - hours * 3600 - mins * 60;
      String hourString;
      if(hours > 9)
          hourString = new String("" + hours);
      else
      if(hours > 0)
          hourString = new String("0" + hours);
      else
          hourString = "00";
      String minuteString;
      if(mins > 9)
          minuteString = new String("" + mins);
      else
      if(mins > 0)
          minuteString = new String("0" + mins);
      else
          minuteString = "00";
      String secondString;
      if(seconds > 9)
          secondString = new String("" + seconds);
      else
      if(seconds > 0)
          secondString = new String("0" + seconds);
      else
          secondString = "00";
      return hourString + ":" + minuteString + ":" + secondString;
  }

  public static Long HHMMSSToSec(String hhmmss)
  {
    Long sec=0l;
      StringTokenizer ct = new StringTokenizer(hhmmss, ":");
      int hours;
      int minutes;
      float seconds;
      
      Long secondL;
      try{
      hours = Integer.parseInt(ct.nextToken());
      minutes = Integer.parseInt(ct.nextToken());
      seconds = Float.parseFloat(ct.nextToken());
      
      
      
      float secTotal =seconds + (float)(60 * minutes) + (float)(3600 * hours);
      Float  d=new Float(secTotal);
      
      sec =d.longValue();
      
      }catch(Exception e){
        e.printStackTrace();
      }
      return sec;
  
  }

  
  
  public static void main(String [] args){
    System.out.print("r="+HHMMSSToSec("00:09:19.09"));
  }
  
}
