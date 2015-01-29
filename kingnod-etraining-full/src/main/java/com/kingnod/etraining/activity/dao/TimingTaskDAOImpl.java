package com.kingnod.etraining.activity.dao;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.activity.entity.TimingTask;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-14 19:04")
public class TimingTaskDAOImpl extends MybatisEntityDAO<TimingTask, Long> implements TimingTaskDAO {

	public int deleteAllTask() {
		return getSqlSession().delete("deleteAll");
	}


}