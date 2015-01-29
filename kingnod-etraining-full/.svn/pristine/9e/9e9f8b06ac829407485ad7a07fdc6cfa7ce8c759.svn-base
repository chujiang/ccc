package com.kingnod.etraining.activity.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;


    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
public interface EnrollLearnerService {

    
    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
    EnrollLearner getEnrollLearner(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
    int saveEnrollLearner(EnrollLearner enrollLearner);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
    int deleteEnrollLearner(EnrollLearner enrollLearner);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
    int deleteEnrollLearnerByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
    PagingResult<EnrollLearner> findEnrollLearner(Criteria criteria);

    void refreshMember(Long activityId, ObjectType activityType) ;
    
    void refreshAllEnrollLearnerMember() ;

    void enrollModeModify(List<Long>ids, String enrollMode, boolean isEnrollLearner);
    
    String getIdsByActivityId(String activityId);
    
    void sendNoticeEnrollGroupChange(Long activityId, ObjectType activityType, NoticeType noticeType, Long siteId);
}