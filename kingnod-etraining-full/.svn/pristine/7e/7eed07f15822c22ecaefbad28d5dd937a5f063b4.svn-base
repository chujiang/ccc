package com.kingnod.etraining.activity.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.ElearningSituation;


    @com.kingnod.core.annotation.Generated("2012-03-13 18:54")
public interface ElearningService {
int saveTrainingPlanActivity(Elearning elearning,Long processId);

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:54")
    Elearning getElearning(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:54")
    int saveElearning(Elearning elearning);

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:54")
    int deleteElearning(Elearning elearning);

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:54")
    int deleteElearningByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:54")
    PagingResult<Elearning> findElearning(Criteria criteria);
    
    PagingResult<Elearning> findElearningByCourseId(Long courseId,Pager<Elearning> pager);
    /**
     * 学习情况
     * @param criteria
     * @return
     */
    PagingResult<ElearningSituation> findBySituation(Criteria criteria);
    
    ElearningSituation getElearningSituation(Long activityId,Long userId);
    
    int updateSituation(ElearningSituation elearningSituation);
    
    int updateElearningSituation(Long[] ids,Long activityId,ElearningSituation elearningSituation);
    
    /**
     * 发布考试
     * @param exam
     * @param isPublish
     * @return
     */
    int publish(Elearning elearning, boolean isPublish);
    
}