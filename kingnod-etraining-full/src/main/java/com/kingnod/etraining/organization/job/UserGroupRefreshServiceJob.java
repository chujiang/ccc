package com.kingnod.etraining.organization.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.organization.service.UserGroupService;
import com.kingnod.etraining.scheduling.quartz.SysParameterInitializingTrigger;

public class UserGroupRefreshServiceJob extends QuartzJobBean {
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
	
	protected void handle(){
		UserGroupService userGroupService = SpringUtils.getBean(UserGroupService.class);
		userGroupService.refreshAllUserGroupMember();
	}

}
