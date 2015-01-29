package com.kingnod.etraining.report.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.report.entity.ReportFolderHierarchy;


    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
public interface ReportFolderHierarchyService {

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    ReportFolderHierarchy getReportFolderHierarchy(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    int saveReportFolderHierarchy(ReportFolderHierarchy reportFolderHierarchy);

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    int deleteReportFolderHierarchy(ReportFolderHierarchy reportFolderHierarchy);

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    int deleteReportFolderHierarchyByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    PagingResult<ReportFolderHierarchy> findReportFolderHierarchy(Criteria criteria);
}