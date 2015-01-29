package com.kingnod.etraining.activity.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.TimingTaskDAO;
import com.kingnod.etraining.activity.entity.TimingTask;
import com.kingnod.etraining.activity.service.TimingTaskService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class TimingTaskServiceImpl implements TimingTaskService {

    @Autowired
    protected TimingTaskDAO timingTaskDAO;


    public TimingTask getTimingTask(Long id) {
        return timingTaskDAO.get(id);
    }

    public int saveTimingTask(TimingTask timingTask) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)timingTask;
        if(null != idEntity.getId() && null != timingTaskDAO.get(idEntity.getId())){
            count = timingTaskDAO.update(timingTask);
        }else{
            count = timingTaskDAO.insert(timingTask);
        }
        return count;
    }

    public int deleteTimingTask(TimingTask timingTask) {
        return timingTaskDAO.delete(timingTask);
    }

    public int deleteTimingTaskByIds(Long[] ids) {
        return timingTaskDAO.deleteById(ids);
    }

    public PagingResult<TimingTask> findTimingTask(Criteria criteria) {
        return timingTaskDAO.findPagingResult(criteria);
    }

	public int deleteAllTask() {
		// TODO Auto-generated method stub
		return timingTaskDAO.deleteAllTask();
	}
}