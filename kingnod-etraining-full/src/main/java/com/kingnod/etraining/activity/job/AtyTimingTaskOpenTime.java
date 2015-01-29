package com.kingnod.etraining.activity.job;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.entity.TimingTask;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.activity.service.TimingTaskService;
import com.kingnod.etraining.activity.service.impl.TimingTaskServiceImpl;
import com.kingnod.etraining.scheduling.quartz.SysParameterInitializingTrigger;

public class AtyTimingTaskOpenTime  extends QuartzJobBean  {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	 
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		SimpleTrigger trigger = (SimpleTrigger)context.getTrigger();
		try{
			logger.debug("#######################################################");
			logger.debug("Trigger: group name = " + trigger.getGroup() + " name = " + trigger.getName());
			if(null != trigger.getFinalFireTime()){
				logger.info("Last fire time: " + DateUtils.format(trigger.getFinalFireTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			
			//这里写业务逻辑代码调用
			this.handle();
			
			if(trigger instanceof SysParameterInitializingTrigger){
				SysParameterInitializingTrigger sysParamTrigger = (SysParameterInitializingTrigger)trigger;
				sysParamTrigger.applySysParameterToTrigger(context.getScheduler());
			}

			if(null != trigger.getNextFireTime()){
				logger.info("Next fire time: " + DateUtils.format(trigger.getNextFireTime(), "yyyy-MM-dd HH:mm:ss"));
			}
			logger.debug("#######################################################");
		}catch(Exception e){
			logger.error("系统监督仲裁处理任务出现异常",e);
		}
	}
	
	protected void handle() throws ParseException{
		logger.debug("zxl-timing Task start");
		String startDate;
		String endDate;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateStr = sdf.format(date);
		SimpleDateFormat insertSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		PeriodService periodService = SpringUtils.getBean(PeriodService.class);
		TimingTaskService timingTaskService = SpringUtils.getBean(TimingTaskService.class);
		TimingTask timingTask = new TimingTask();
		int countDel = timingTaskService.deleteAllTask();
		logger.debug("定时任务：清空原有记录" + countDel + "条。");
		List<Period> periodList = periodService.countByTime();
		for(int i = 0; i < periodList.size(); i++)
		{
			timingTask.setId(null);
			timingTask.setFlagType(periodList.get(i).getPeriodFlagType());
			timingTask.setFlagId(periodList.get(i).getPeriodFlagId());
			startDate = dateStr + " " + periodList.get(i).getStartTime();
			timingTask.setStartTime(new Time(insertSdf.parse(startDate).getTime()));
			endDate = dateStr + " " + periodList.get(i).getEndTime();
			timingTask.setEndTime(new Time(insertSdf.parse(endDate).getTime()));
			
			timingTaskService.saveTimingTask(timingTask);
		}
		logger.debug("定时任务：添加记录" + periodList.size() + "条。");
		
		logger.debug("zxl-timing Task end");
		
	}
}
