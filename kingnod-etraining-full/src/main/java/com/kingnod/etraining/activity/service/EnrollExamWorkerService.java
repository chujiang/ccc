package com.kingnod.etraining.activity.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.EnrollExamWorker;


    @com.kingnod.core.annotation.Generated("2012-04-06 09:33")
public interface EnrollExamWorkerService {

    
    @com.kingnod.core.annotation.Generated("2012-04-06 09:33")
    EnrollExamWorker getEnrollExamWorker(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-04-06 09:33")
    int saveEnrollExamWorker(EnrollExamWorker enrollExamWorker);

    
    @com.kingnod.core.annotation.Generated("2012-04-06 09:33")
    int deleteEnrollExamWorker(EnrollExamWorker enrollExamWorker);

    
    @com.kingnod.core.annotation.Generated("2012-04-06 09:33")
    int deleteEnrollExamWorkerByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-04-06 09:33")
    PagingResult<EnrollExamWorker> findEnrollExamWorker(Criteria criteria);
    
    void saveEnrollExamWorker(Long activityId, String workType, List<Long> userIds, List<Long> questionIds);
    
    String getIdsByActivityId(String activityId, String workType);
    
    PagingResult<EnrollExamWorker> findByExaminationId(Criteria criteria);
}