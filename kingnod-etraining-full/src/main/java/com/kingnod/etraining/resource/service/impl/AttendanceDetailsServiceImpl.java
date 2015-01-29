package com.kingnod.etraining.resource.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.AttendanceDetailsDAO;
import com.kingnod.etraining.resource.entity.AttendanceDetails;
import com.kingnod.etraining.resource.service.AttendanceDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class AttendanceDetailsServiceImpl implements AttendanceDetailsService {

    @Autowired
    protected AttendanceDetailsDAO attendanceDetailsDAO;


    public AttendanceDetails getAttendanceDetails(Long id) {
        return attendanceDetailsDAO.get(id);
    }

    public int saveAttendanceDetails(AttendanceDetails attendanceDetails) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)attendanceDetails;
        if(null != idEntity.getId() && null != attendanceDetailsDAO.get(idEntity.getId())){
            count = attendanceDetailsDAO.update(attendanceDetails);
        }else{
            count = attendanceDetailsDAO.insert(attendanceDetails);
        }
        return count;
    }

    public int deleteAttendanceDetails(AttendanceDetails attendanceDetails) {
        return attendanceDetailsDAO.delete(attendanceDetails);
    }

    public int deleteAttendanceDetailsByIds(Long[] ids) {
        return attendanceDetailsDAO.deleteById(ids);
    }

    public PagingResult<AttendanceDetails> findAttendanceDetails(Criteria criteria) {
        return attendanceDetailsDAO.findPagingResult(criteria);
    }
}