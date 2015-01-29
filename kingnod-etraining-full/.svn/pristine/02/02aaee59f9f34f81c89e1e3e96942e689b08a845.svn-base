package com.kingnod.etraining.scheduling.quartz;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerBean;

import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.SysParameterUtils;

public class SysParameterSimpleTriggerBean extends SimpleTriggerBean implements SysParameterInitializingTrigger {
	
private static final long serialVersionUID = -1607171198550818934L;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private String currentSysParameterValue;
	private String sysParameterCode;

	public String getSysParameterCode() {
		return sysParameterCode;
	}

	public void setSysParameterCode(String sysParameterCode) {
		this.sysParameterCode = sysParameterCode;
	}
	
	public void applySysParameterToTrigger(Scheduler scheduler) throws SchedulerException {
		String newValue = SysParameterUtils.getString(this.sysParameterCode);
		if(!StringUtils.isEmpty(newValue) && newValue.equals(currentSysParameterValue)){
			return;
		}
		
		currentSysParameterValue = newValue;
		logger.debug("Trigger: group name = " + this.getGroup() + " name = " + this.getName());
		logger.debug("Sys Parameter: code = " + this.sysParameterCode + " value = " + newValue);
		String[] values = null;
		if(!StringUtils.isEmpty(newValue)){
			values = newValue.split(",");
			if(values.length > 0){
				Date timeValue = DateUtils.parse(values[0], "HH:mm");
				Date startTime = new Date();
				startTime.setHours(timeValue.getHours());
				startTime.setMinutes(timeValue.getMinutes());
				startTime.setSeconds(0);
				this.setStartTime(startTime);
			}
			if(values.length > 1){
				long repeatInterval = NumberUtils.toLong(values[1])*60000;
				this.setRepeatInterval(repeatInterval);
			}else{
				this.setRepeatInterval(24 * 60 * 60 * 1000);
			}
			if(null != scheduler){
				//先暂停任务调度器
				if (!scheduler.isInStandbyMode()) {   
					scheduler.standby();   
				}

				scheduler.rescheduleJob(this.getName(), this.getGroup(), this);
				//重新运行
				scheduler.start();
			}
		}
	}
	
	@Override
	public void afterPropertiesSet() throws ParseException {
		try {
			applySysParameterToTrigger(null);
		} catch (SchedulerException e) {
			logger.error(e.getMessage(), e);
		}
		super.afterPropertiesSet();
	}

}
