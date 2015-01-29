package com.kingnod.etraining.course;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kingnod.core.extensions.spring.SpringTxTestCase;
import com.kingnod.etraining.course.dao.PerformanceDAO;
import com.kingnod.etraining.course.entity.Performance;
import com.kingnod.etraining.course.entity.SCOPerformance;
import com.kingnod.etraining.course.service.PerformanceService;


@ContextConfiguration(
    locations={"classpath:/applicationContext.xml"}
)
public class PerformanceTest extends SpringTxTestCase  {
  
  @Autowired
  private PerformanceService performanceService;
  
  @Test
  public void insertPerformanceDAO(){
/*    SCOPerformance sco=performanceService.getLaunchSCO(3003l, 0l);
    //System.out.println("s1="+sco.getItemTable().getId());
    System.out.println("s2="+sco.getItemTable().getItemTitle());
    //System.out.println("s3="+sco.getStatus());
    //System.out.println("s4="+sco.getItemTable().getLaunch());
    System.out.println("s5="+sco.getItemTableScoId());
   // System.out.println("s6="+sco.getItemTablelaunch());
*/ 
    performanceService.finishPerformance(6l, 0l, 0l);
  }

}
