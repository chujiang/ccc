package com.kingnod.etraining.report.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.report.dao.ExaminationStatDAO;
import com.kingnod.etraining.report.entity.ExaminationStat;
import com.kingnod.etraining.report.service.ExaminationStatService;
/**
 * 考试统计报表服务接口实现类
 * @author Sam
 *
 */
@Service
public class ExaminationStatServiceImpl implements ExaminationStatService {
	
	@Autowired
	private ExaminationStatDAO examinationStatDAO;

	public PagingResult<ExaminationStat> findExaminationStat(Criteria criteria) { 
		return examinationStatDAO.findPagingResult(criteria);
	}

}
