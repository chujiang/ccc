package com.kingnod.etraining.course.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.course.entity.Attemp;


    @com.kingnod.core.annotation.Generated("2012-02-07 10:17")
public interface AttempService {

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:17")
    Attemp getAttemp(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:17")
    int saveAttemp(Attemp attemp);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:17")
    int deleteAttemp(Attemp attemp);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:17")
    int deleteAttempByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:17")
    PagingResult<Attemp> findAttemp(Criteria criteria);
    
    //初始化一条记录
    int initAttemp(Long courseId, Long scoId,Long userId);
    
    //完成时调用
    int finishAttemp(Long courseId, Long scoId,Long userId);

}