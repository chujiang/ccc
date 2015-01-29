package com.kingnod.etraining.course.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.course.entity.SCOPerformance;


    @com.kingnod.core.annotation.Generated("2012-02-07 16:20")
public interface SCOPerformanceService {

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:20")
    SCOPerformance getSCOPerformance(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:20")
    int saveSCOPerformance(SCOPerformance sCOPerformance);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:20")
    int deleteSCOPerformance(SCOPerformance sCOPerformance);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:20")
    int deleteSCOPerformanceByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:20")
    PagingResult<SCOPerformance> findSCOPerformance(Criteria criteria);
    
    //初始化时调用
    int initSCOPerformance(Long courseId, Long scoId,Long userId);
    
    //完成时调用
    int finishSCOPerformance(Long courseId, Long scoId,Long userId);
    
    List<TreeNode> getSCOTreeList(Long courseId, Long scoId,Long userId);
    
    List<TreeNode> getItemTreeList(Long acivityId,Long courseId,Long userId);
    
    //获取一个章节SCO
    String getOneSCOLaunch(Long courseId,Long scoId);
    
    String getScoFullURL(Long courseId,String scoUrl);
    
    List<SCOPerformance> getSCOPerformanceList(Long courseId,Long userId);
    
    String getStatusMsg(String status);
}