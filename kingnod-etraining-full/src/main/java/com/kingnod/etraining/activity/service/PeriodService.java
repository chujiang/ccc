package com.kingnod.etraining.activity.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.common.ObjectType;


    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
public interface PeriodService {

    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    Period getPeriod(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    int savePeriod(Period period);

    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    int deletePeriod(Period period);

    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    int deletePeriodByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    PagingResult<Period> findPeriod(Criteria criteria);
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    List<Period> countByTime();
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    List<Period> getPeriodByFlagID(Period period);
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    int deletePeriodByFlagId(Long[] flagId,String flagType);
    
	Period getPeriodByFlagId(Long flagId,ObjectType flagType);
	
    boolean availabilityDate(Period period);
    public boolean validateAvailableDays(Period period, Date currentDate) ;
    public boolean validateDate(Date startDate, Date endDate, Date currentDate);
    
    /**
	 * 判断当前日期是否小于等于结束日期
	 * @param date
	 * @param currentDate
	 * @return boolean
	 */
	boolean equalsBefore(Date endDate, Date currentDate);
	
	/**
	 * 判断当前日期是否大于等于开始日期
	 * @param date
	 * @param currentDate
	 * @return boolean
	 */
	boolean equalsAfter(Date startDate, Date currentDate);
	
	/**
	 * 判断当前系统时间Time对象小于结束日期Time对象
	 * @param date
	 * @param currentDate
	 * @return boolean
	 */
	boolean beforeTimes(Date endDate,Date currentDate);
}