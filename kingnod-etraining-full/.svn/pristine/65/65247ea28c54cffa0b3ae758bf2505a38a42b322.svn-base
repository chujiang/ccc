package com.kingnod.etraining.activity.entity;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.service.PeriodService;

public class AvailabilityDate {

	public static boolean availability(PeriodService periodService,UserActivitySummary us){

		Period period = periodService.getPeriodByFlagId(us.getActivityId(),
				us.getType());
		if (null == period) {
			us.setPlay(true);
		} else {
			Date currentDate = new Date();// 当前系统日期
			Date startDate = period.getStartDate();
			Date endDate = period.getEndDate();

			Time startTime = period.getStartTime();
			Time endTime = period.getEndTime();
			DateFormat dFormat = DateFormat.getTimeInstance();
			Time currentTime = new Time(currentDate.getTime());
			currentTime  = currentTime.valueOf(currentTime.toString());

			String periodType = period.getPeriodType();
			if (null == endDate && null == startDate) {//表示永久有效

				if (null == startTime && null == endTime) {//没有时间限制，在开发日期中24小时开放
				us.setPlay(true);
			} else if (null != startTime && null == endTime) {//有开始时间限制，时间一到就开放一直到第二天
				
				startTime.getTime();
				currentTime.getTime();
				if (startTime.before(currentTime)) { startTime.valueOf("18:50:56").before(currentTime.valueOf("16:50:56"));
					us.setPlay(true);
				} else {
					us.setPlay(false);
				}
			} else if (null == startTime && null != endTime) {//如果开始时间为空，只有结束时间，那么只要活动还在结束时间之前就可以播放
				 if (endTime.after(currentTime)) {
					us.setPlay(true);
				} else {
					us.setPlay(false);
				}
			}else{//如果有开始时间，也有结束时间，那么在时间段里有效
				if (startTime.before(currentTime)
						&& endTime.after(currentTime)) {
					us.setPlay(true);
				}else{
					us.setPlay(false);
				}
			}
			
			}else if(null != endDate && null == startDate){//在结束日期前有效
				if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_DATE)
						|| StringUtils.equals(periodType,
								ActivityConstant.ACTIVITY_DATETYPE_WEEK)) {
					if (periodService.validateAvailableDays(period,
							currentDate)) {
					if (currentDate.after(endDate)) {
						if (null == startTime && null == endTime) {//没有时间限制，在开发日期中24小时开放
						us.setPlay(true);
					} else if (null != startTime && null == endTime) {//有开始时间限制，时间一到就开放一直到第二天
						if (startTime.before(currentTime)) {
							us.setPlay(true);
						} else {
							us.setPlay(false);
						}
					} else if (null == startTime && null != endTime) {//如果开始时间为空，只有结束时间，那么只要活动还在结束时间之前就可以播放
						 if (endTime.after(currentTime)) {
							us.setPlay(true);
						} else {
							us.setPlay(false);
						}
					}else{//如果有开始时间，也有结束时间，那么在时间段里有效
						if (startTime.before(currentTime)
								&& endTime.after(currentTime)) {
							us.setPlay(true);
						}else{
							us.setPlay(false);
						}
					}
					}
					}
				}else if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_NONE)) {
					if (currentDate.before(startDate)) {
						if (null == startTime && null == endTime) {//没有时间限制，在开发日期中24小时开放
						us.setPlay(true);
					} else if (null != startTime && null == endTime) {//有开始时间限制，时间一到就开放一直到第二天
						if (startTime.before(currentTime)) {
							us.setPlay(true);
						} else {
							us.setPlay(false);
						}
					} else if (null == startTime && null != endTime) {//如果开始时间为空，只有结束时间，那么只要活动还在结束时间之前就可以播放
						 if (endTime.after(currentTime)) {
							us.setPlay(true);
						} else {
							us.setPlay(false);
						}
					}else{//如果有开始时间，也有结束时间，那么在时间段里有效
						if (startTime.before(currentTime)
								&& endTime.after(currentTime)) {
							us.setPlay(true);
						}else{
							us.setPlay(false);
						}
					}
						}
					
				}else if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_SPECIAL)) {//待定
					
				}
			}else if (null != startDate && null == endDate) {//到时间后永久有效
				if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_DATE)
						|| StringUtils.equals(periodType,
								ActivityConstant.ACTIVITY_DATETYPE_WEEK)) {
					if (periodService.validateAvailableDays(period,
							currentDate)) {
					if (currentDate.before(startDate)) {
						if (null == startTime && null == endTime) {//没有时间限制，在开发日期中24小时开放
							us.setPlay(true);
						} else if (null != startTime && null == endTime) {//有开始时间限制，时间一到就开放一直到第二天
							if (startTime.before(currentTime)) {
								us.setPlay(true);
							} else {
								us.setPlay(false);
							}
						} else if (null == startTime && null != endTime) {//如果开始时间为空，只有结束时间，那么只要活动还在结束时间之前就可以播放
							 if (endTime.after(currentTime)) {
								us.setPlay(true);
							} else {
								us.setPlay(false);
							}
						}else{//如果有开始时间，也有结束时间，那么在时间段里有效
							if (startTime.before(currentTime)
									&& endTime.after(currentTime)) {
								us.setPlay(true);
							}else{
								us.setPlay(false);
							}
						}
					}
					}
				}else if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_NONE)) {
					if (currentDate.before(startDate)) {
						if (null == startTime && null == endTime) {
							us.setPlay(true);
						} else if (null != startTime && null == endTime) {
							if (startTime.before(currentTime)) {
								us.setPlay(true);
							} else {
								us.setPlay(false);
							}
						} else if (null == startTime && null != endTime) {
							if (endTime.after(currentTime)) {
								us.setPlay(true);
							} else {
								us.setPlay(false);
							}
						}else{
							if (startTime.before(currentTime)
									&& endTime.after(currentTime)) {
								us.setPlay(true);
							}else{
								us.setPlay(false);
							}
						}
					}
					
				}else if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_SPECIAL)) {//待定
					
				}
			} else {
				if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_DATE)
						|| StringUtils.equals(periodType,
								ActivityConstant.ACTIVITY_DATETYPE_WEEK)) {// 每月或者每周
					if (periodService.validateAvailableDays(period,
							currentDate)) {
						if (periodService.validateDate(startDate, endDate,
								currentDate)) {

							if (null == startTime && null == endTime) {
								us.setPlay(true);
							} else if (null != startTime && null == endTime) {
								if (startTime.before(currentTime)) {
									us.setPlay(true);
								} else {
									us.setPlay(false);
								}
							} else if (null == startTime && null != endTime) {
								if (endTime.after(currentTime)) {
									us.setPlay(true);
								} else {
									us.setPlay(false);
								}
							}else{
								if (startTime.before(currentTime)
										&& endTime.after(currentTime)) {
									us.setPlay(true);
								}else{
									us.setPlay(false);
								}
							}
						}
					}
				} else if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_NONE)) {// 每天
					if (periodService.validateDate(startDate, endDate,
							currentDate)) {

						if (null == startTime && null == endTime) {
							us.setPlay(true);
						} else if (null != startTime && null == endTime) {
							if (startTime.before(currentTime)) {
								us.setPlay(true);
							} else {
								us.setPlay(false);
							}
						} else if (null == startTime && null != endTime) {
							if (endTime.after(currentTime)) {
								us.setPlay(true);
							} else {
								us.setPlay(false);
							}
						}else{
							if (startTime.before(currentTime)
									&& endTime.after(currentTime)) {
								us.setPlay(true);
							}else{
								us.setPlay(false);
							}
						}
					
					}
				} else if (StringUtils.equals(periodType,
						ActivityConstant.ACTIVITY_DATETYPE_SPECIAL)) {// 特定

				}
				
			}
		}
		return us.isPlay();
	}
}
