package com.kingnod.etraining.activity.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.activity.entity.Period;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
public class PeriodDAOImpl extends MybatisEntityDAO<Period, Long> implements PeriodDAO {


	private Period period = new Period();
	
	@SuppressWarnings("unchecked")
	public List<Period> countByTime() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("countByTime");
	}

	public List<Period> getPeriodByFlagID(Period period) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("findByFlagID",period);
	}
	
	public int deletePeriodByFlagId(Long[] flagIds, String flagType)
	{
		int count=0;
		for (int i = 0; i < flagIds.length; i++) 
		{
			period.setPeriodFlagType(flagType);
			period.setPeriodFlagId(flagIds[i]);
			count += getSqlSession().delete("deletePeriodByFlagId", period);
		}
		return count;
	}

}