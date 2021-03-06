package com.kingnod.etraining.report.service;



import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.report.entity.UserActivityDetailsReport;


public interface UserActivityDetailsReportService {

    PagingResult<UserActivityDetailsReport> findUserActivityDetailsReport(Criteria criteria);
}