package com.kingnod.etraining.activity.service.impl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.dao.PeriodDAO;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.common.ObjectType;

@org.springframework.stereotype.Service
public class PeriodServiceImpl implements PeriodService {

	@Autowired
	protected PeriodDAO periodDAO;

	public Period getPeriod(Long id) {
		return periodDAO.get(id);
	}

	public int savePeriod(Period period) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) period;
		if (null != idEntity.getId() && null != periodDAO.get(idEntity.getId())) {
			count = periodDAO.update(period);
		} else {
			count = periodDAO.insert(period);
		}
		return count;
	}

	public int deletePeriod(Period period) {
		return periodDAO.delete(period);
	}

	public int deletePeriodByIds(Long[] ids) {
		return periodDAO.deleteById(ids);
	}

	public PagingResult<Period> findPeriod(Criteria criteria) {
		return periodDAO.findPagingResult(criteria);
	}

	public List<Period> countByTime() {
		// TODO Auto-generated method stub
		return periodDAO.countByTime();
	}

	public List<Period> getPeriodByFlagID(Period period) {
		// TODO Auto-generated method stub
		return periodDAO.getPeriodByFlagID(period);
	}

	public int deletePeriodByFlagId(Long[] periodFlagId, String periodFlagType) {
		// TODO Auto-generated method stub
		return periodDAO.deletePeriodByFlagId(periodFlagId, periodFlagType);
	}

	/**
	 * 根据FlagId获取Period
	 * 
	 * @param flagId
	 * @return Period
	 */
	public Period getPeriodByFlagId(Long flagId, ObjectType flagType) {
		if (flagId != null) {
			CriteriaBuilder cb = Cnd.builder(Period.class);
			cb.andEQ("periodFlagId", flagId).andEQ("periodFlagType", flagType.name());
			List<Period> list = periodDAO.findByCriteria(cb.buildCriteria());
			if (list != null && list.size() == 1) {
				return list.get(0);
			}
		}
		return null;
	}

	/**
	 * 判断当前时间是否在有效日期内
	 * 
	 * @param flagId
	 * @return boolean
	 */
	public boolean availabilityDate(Period period) {
		boolean isOk = true;
		if(period != null){
			Date currentDate = new Date();// 当前系统日期
			
			Date startDate = period.getStartDate();
			Date endDate = period.getEndDate();
	
			Time startTime = period.getStartTime();
			Time endTime = period.getEndTime();
			
			Time currentTime = new Time(currentDate.getTime());
			currentTime = Time.valueOf(currentTime.toString());
			String periodType = period.getPeriodType();
	
			// 如果当前日期在结束日期之前，在开始日期之后，就是有效日期
			if (StringUtils.equals(periodType, ActivityConstant.ACTIVITY_DATETYPE_DATE) || StringUtils.equals(periodType, ActivityConstant.ACTIVITY_DATETYPE_WEEK)) {// 每月或者每周
				if (validateAvailableDays(period, currentDate)) {
					return validateDate(startDate, endDate, currentDate) && validateDate(startTime, endTime, currentTime);
				}
			} else if (StringUtils.equals(periodType, ActivityConstant.ACTIVITY_DATETYPE_NONE)) {// 每天
				return validateDate(startDate, endDate, currentDate) && validateDate(startTime, endTime, currentTime);
			} else if (StringUtils.equals(periodType, ActivityConstant.ACTIVITY_DATETYPE_SPECIAL)) {// 特定
	
			}
			isOk = true;
		}
		return isOk;
	}

	/**
	 * 判断当前日期是否在有效日期内
	 * 
	 * @param startDate
	 * @param endDate
	 * @param currentDate
	 * @return boolean
	 */
	public boolean validateDate(Date startDate, Date endDate, Date currentDate) {
		if(startDate == null && endDate == null){
			return true;
		}else if (startDate != null && endDate != null && currentDate != null) {
			return equalsBefore(endDate,currentDate) && equalsAfter(startDate,currentDate);
		}else if(startDate != null && currentDate != null){
			return equalsAfter(startDate,currentDate);
		}else if(endDate != null && currentDate != null){
			return equalsBefore(endDate,currentDate);
		}
		return false;
	}

	/**
	 * 判断当前每月的这几天，每周的这几天，是否在有效期内
	 * 
	 * @param period
	 * @param currentDate
	 * @return boolean
	 */
	public boolean validateAvailableDays(Period period, Date currentDate) {
		String availableDays = period.getAvailableDays();
		String[] weeks = availableDays.split("-");
		
		String curWeek = getDayOfWeek(currentDate,period.getPeriodType());
		for (String week : weeks) {
			if (StringUtils.equals(week, curWeek)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据日期对象获取星期
	 * @param date
	 * @return String
	 */
	public String getDayOfWeek(Date date,String perpoidType) {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = -1;
		if(StringUtils.equals(ActivityConstant.ACTIVITY_DATETYPE_WEEK, perpoidType)){
			calendar.setTime(date);
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
			if (dayOfWeek < 0) {
				dayOfWeek = 0;
			}
		}else{
			dayOfWeek = calendar.get(Calendar.DATE);
		}
		return String.valueOf(dayOfWeek);
	}
	
	/**
	 * 判断当前日期是否大于等于开始日期
	 * @param date
	 * @param currentDate
	 * @return boolean
	 */
	public boolean equalsAfter(Date startDate, Date currentDate){
		return equalsDate(startDate, currentDate) || currentDate.after(startDate);
	}
	
	/**
	 * 判断当前日期是否小于等于结束日期
	 * @param date
	 * @param currentDate
	 * @return boolean
	 */
	public boolean equalsBefore(Date endDate, Date currentDate){
		return equalsDate(endDate, currentDate) || currentDate.before(endDate);
	}
	
	/**
	 * 判断两个日期是否相等
	 * @param date
	 * @param currentDate
	 * @return boolean
	 */
	public boolean equalsDate(Date date, Date currentDate){
		if(date != null && currentDate != null){
			String dateStr = StringUtils.EMPTY;
			String dateCurStr = StringUtils.EMPTY;
			
			if(date instanceof Time){
				dateCurStr = currentDate.toString();
				dateStr = date.toString();
			}else if(date instanceof Date){
				DateFormat df = DateFormat.getDateInstance(); 
				dateCurStr = df.format(currentDate);
				dateStr = df.format(date);
			} 
			return StringUtils.equals(dateCurStr, dateStr);
		}
		return false;
	}
	
	/**
	 * 判断当前系统时间Time对象小于结束日期对象
	 * @param date
	 * @param currentDate
	 * @return boolean
	 */
	public boolean beforeTimes(Date endDate,Date currentDate){
		if(endDate != null && currentDate != null){
			return currentDate.before(endDate);
		}
		return false;
	}
	
	public static void main(String[] args) throws ParseException {
		String a ="a-b-d-e";
		System.out.println(a.replaceAll("-", ","));
	}
}