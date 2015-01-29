package com.kingnod.etraining.report.service.impl;



import java.math.BigDecimal;
import java.util.List;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.SearchResult;
import com.kingnod.etraining.activity.entity.UserActivitySummary;
import com.kingnod.etraining.course.utils.TimeUtil;

import com.kingnod.etraining.report.dao.UserActivityDetailsReportDAO;
import com.kingnod.etraining.report.entity.UserActivityDetailsReport;
import com.kingnod.etraining.report.service.UserActivityDetailsReportService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class UserActivityDetailsReportServiceImpl implements UserActivityDetailsReportService {

    @Autowired
    protected UserActivityDetailsReportDAO userActivityDetailsReportDAO;


  public PagingResult<UserActivityDetailsReport> findUserActivityDetailsReport(Criteria criteria) {
         PagingResult<UserActivityDetailsReport> userActivityDetailsReportList = userActivityDetailsReportDAO.findPagingResult(criteria);
         
         for(UserActivityDetailsReport report:userActivityDetailsReportList.getResult()){
           
           if(new BigDecimal(-1).equals(report.getScore())){
             report.setScore(null);
           }
          //String courseCategory =  ;
           Long totalTime= report.getTotalTime();
           if(totalTime!=null){
             report.setTotalTimeFomart(TimeUtil.secToHHMMSS(totalTime));
           }else{
             report.setTotalTimeFomart("");
           }
         }
         return userActivityDetailsReportList;
    }
}