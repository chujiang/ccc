package com.kingnod.etraining.exam.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.exam.service.ExamineeQuestionService;
/**
 * 在线考试时，因为特殊原因没有正常交卷，在后台要对没有交卷的试卷进行交卷操作
 * @author Sam
 *
 */
public class OnlineExamTimeoutHandlerJobBean extends QuartzJobBean{
	
	private final static Logger logger = LoggerFactory.getLogger(OnlineExamTimeoutHandlerJobBean.class);
	
	 
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException { 
		if (logger.isDebugEnabled())
			logger.debug("OnlineExamTimeoutHandlerJobBean is handling now~~~");
		ExamineeQuestionService examineeQuestionService = SpringUtils.getBean(ExamineeQuestionService.class);
		examineeQuestionService.systemCarryPaper();
		
		
	}
	
 

}
