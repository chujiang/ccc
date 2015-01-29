package com.kingnod.etraining.resource.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.AttendanceProjectDAO;
import com.kingnod.etraining.resource.entity.AttendanceProject;
import org.springframework.beans.factory.annotation.Autowired;
import com.kingnod.etraining.resource.service.AttendanceProjectService;

@org.springframework.stereotype.Service
public class AttendanceProjectServiceImpl implements AttendanceProjectService {

    @Autowired
    protected AttendanceProjectDAO attendanceProjectDAO;


    public AttendanceProject getAttendanceProject(Long id) {
        return attendanceProjectDAO.get(id);
    }

    public int saveAttendanceProject(AttendanceProject attendanceProject) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)attendanceProject;
        if(null != idEntity.getId() && null != attendanceProjectDAO.get(idEntity.getId())){
            count = attendanceProjectDAO.update(attendanceProject);
        }else{
            count = attendanceProjectDAO.insert(attendanceProject);
        }
        return count;
    }

    public int deleteAttendanceProject(AttendanceProject attendanceProject) {
        return attendanceProjectDAO.delete(attendanceProject);
    }

    public int deleteAttendanceProjectByIds(Long[] ids) {
        return attendanceProjectDAO.deleteById(ids);
    }

    public PagingResult<AttendanceProject> findAttendanceProject(Criteria criteria) {
        return attendanceProjectDAO.findPagingResult(criteria);
    }
}