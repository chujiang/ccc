package com.kingnod.etraining.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.dao.ExamineesHistoryDAO;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.report.dao.UserExaminationReportDAO;
import com.kingnod.etraining.report.entity.UserExaminationReport;
import com.kingnod.etraining.report.service.UserExaminationReportService;

@org.springframework.stereotype.Service
public class UserExaminationReportServiceImpl implements UserExaminationReportService {

    @Autowired
    protected UserExaminationReportDAO userExaminationReportDAO;
    @Autowired
    protected ExamineesHistoryDAO examineesHistoryDAO;

    public PagingResult<UserExaminationReport> findUserExaminationReport(Criteria criteria) {
    	PagingResult pagingResult = userExaminationReportDAO.findPagingResult(criteria);
    	//重新组装考试用时
    	List<UserExaminationReport> result = pagingResult.getResult();
    	if(ListUtils.isNotEmpty(result)) {
    		for(UserExaminationReport report: result) {
    			String answerTimeLength = "";	//考试用时
    			String examStatus = report.getExamStatus(); 
    			if(examStatus != null && !examStatus.equals("0")) {
    				int examTime = report.getExamTime();
					for (int i = 1; i <= examTime; i++) {
						List<ExamineesHistory> historyList = examineesHistoryDAO
								.findByCriteria(Cnd
										.builder(ExamineesHistory.class)
										.andEQ("examinationId",
												report.getExamId())
										.andEQ("userId", report.getUserId())
										.andEQ("times", i).buildCriteria());
						if (ListUtils.isNotEmpty(historyList)) {
							ExamineesHistory history = historyList.get(0);
							answerTimeLength += DateUtils.format(history.getStartTime(),"HH:mm:ss") + "--" + DateUtils.format(history.getEndTime(),"HH:mm:ss") + "<br>";
						}
					}
    			}
    			report.setAnswerTimeLength(answerTimeLength);
    		}
    	}
        return pagingResult;
    }
}