package com.kingnod.etraining.resource.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.AttendanceDAO;
import com.kingnod.etraining.resource.entity.Attendance;
import com.kingnod.etraining.resource.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    protected AttendanceDAO attendanceDAO;


    public Attendance getAttendance(Long id) {
        return attendanceDAO.get(id);
    }

    public int saveAttendance(Attendance attendance) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)attendance;
        if(null != idEntity.getId() && null != attendanceDAO.get(idEntity.getId())){
            count = attendanceDAO.update(attendance);
        }else{
            count = attendanceDAO.insert(attendance);
        }
        return count;
    }

    public int deleteAttendance(Attendance attendance) {
        return attendanceDAO.delete(attendance);
    }

    public int deleteAttendanceByIds(Long[] ids) {
        return attendanceDAO.deleteById(ids);
    }

    public PagingResult<Attendance> findAttendance(Criteria criteria) {
        return attendanceDAO.findPagingResult(criteria);
    }
}
