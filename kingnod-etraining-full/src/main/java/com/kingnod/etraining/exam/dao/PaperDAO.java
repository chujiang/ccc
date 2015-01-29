package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.entity.Question;

@com.kingnod.core.annotation.Generated("2012-03-07 15:00")
public interface PaperDAO extends EntityDAO<Paper, Long> {

	/**
	 * 查询预览试卷的试题
	 */
	List<Question> preview(Criteria criteria);

	/**
	 * 查询文件夹名称
	 */
	String findFolderName(String folderId);
	
	/**
	 * 能否取消发布，如果当前试卷有考试活动应用不能取消发布
	 * @param paperId
	 * @return boolean
	 */
	boolean findExamByPaperOfCount(Long[] paperId);
	
	/**
	 * 更新试卷的总分数
	 * @param paper
	 * @return
	 */
	int updatePaperTotalScore(Paper paper);
}