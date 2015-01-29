package com.kingnod.etraining.exam.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.entity.Paper;

@com.kingnod.core.annotation.Generated("2012-03-07 15:00")
public interface PaperService {

	@com.kingnod.core.annotation.Generated("2012-03-07 15:00")
	Paper getPaper(Long id);

	@com.kingnod.core.annotation.Generated("2012-03-07 15:00")
	int savePaper(Paper paper);

	@com.kingnod.core.annotation.Generated("2012-03-07 15:00")
	int deletePaper(Paper paper);

	@com.kingnod.core.annotation.Generated("2012-03-07 15:00")
	int deletePaperByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-03-07 15:00")
	PagingResult<Paper> findPaper(Criteria criteria);

	/**
	 * 处理 -- 发布试卷
	 * @param paper
	 * @param bool
	 * @return
	 */
	Integer publishQuestionByPaper(Paper paper, boolean bool);

	/**
	 * 查询文件夹名称
	 */
	String findFolderNameByFolderId(String folderId);
	
	/**
	 * 能否取消发布，如果当前试卷有考试活动应用不能取消发布
	 * @param paperId
	 * @return boolean
	 */
	boolean findExamByPaperOfCount(Long[] paperId);
}