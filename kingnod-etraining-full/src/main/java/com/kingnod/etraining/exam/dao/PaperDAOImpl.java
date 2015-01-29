package com.kingnod.etraining.exam.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-07 15:00")
public class PaperDAOImpl extends MybatisEntityDAO<Paper, Long> implements PaperDAO {
	
	@Autowired
	protected ResourceFolderDAO resourceFolderDAO;

	/**
	 * 查询预览试卷的试题
	 */
	@SuppressWarnings("unchecked")
	public List<Question> preview(Criteria criteria) {
		return getSqlSession().selectList(ExamConstant.PREVIE, criteria);
	}

	public String findFolderName(String folderId) {
		return (String) getSqlSession().selectOne(ExamConstant.FINDFOLDERNAME_PAPER, folderId);
	}
	
	@Override
	protected void afterInsert(Paper entity) {
		CriteriaBuilder cb = Cnd.builder(Paper.class);
		cb.andEQ("id", entity.getId());
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "EXM_EXAM_PAPER");
		resourceFolderDAO.updateObjectCount(criteria);
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		CriteriaBuilder cb = Cnd.builder(Paper.class);
		cb.andIn("id", ListUtils.of(ids));
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "EXM_EXAM_PAPER");
		resourceFolderDAO.updateObjectCount(criteria);
	}

	public int updatePaperTotalScore(Paper paper) {
		return getSqlSession().update("updatePaperTotalScoreByTestGroup", paper);
	}
	
	/**
	 * 能否取消发布，如果当前试卷有考试活动应用不能取消发布
	 * @param paperId
	 * @return boolean
	 */
	public boolean findExamByPaperOfCount(Long[] paperId){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("paperId", Arrays.asList(paperId));
		Object obj = getSqlSession().selectOne("findExamByPaperOfCount",map);
		if(obj != null && obj instanceof Long){
			if(((Long)obj) > 0){
				return false;
			}
		}
		return true;
	}
}