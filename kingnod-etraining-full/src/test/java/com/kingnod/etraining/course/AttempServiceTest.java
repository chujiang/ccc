package com.kingnod.etraining.course;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kingnod.core.extensions.spring.SpringTxTestCase;
import com.kingnod.etraining.course.service.AttempService;

@ContextConfiguration(
    locations={"classpath:/applicationContext.xml"}
)
public class AttempServiceTest  extends SpringTxTestCase{

  @Autowired
  private AttempService attempService;
  
  
  @Test
  public void initAttempServiceTest(){
    attempService.initAttemp(3232l, 20001l, 30001l);
  }
}
