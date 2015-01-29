package com.kingnod.etraining.report.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.report.dao.CourseMessageDAO;
import com.kingnod.etraining.report.entity.CourseMessage;
import com.kingnod.etraining.report.service.CourseMessageService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class CourseMessageServiceImpl implements CourseMessageService {

    @Autowired
    protected CourseMessageDAO courseMessageDAO;


    public PagingResult<CourseMessage> findCourseMessage(Criteria criteria) {
        return courseMessageDAO.findPagingResult(criteria);
    }


	public CourseMessage getCourseMessage() {
		// TODO Auto-generated method stub
		return null;
	}


	public int saveCourseMessage(CourseMessage courseMessage) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteCourseMessage(CourseMessage courseMessage) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteCourseMessageByIds() {
		// TODO Auto-generated method stub
		return 0;
	}
}