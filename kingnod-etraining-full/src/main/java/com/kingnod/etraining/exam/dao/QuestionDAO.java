package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.entity.ConditionRule;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.entity.Question;

@com.kingnod.core.annotation.Generated("2012-04-15 12:12")
public interface QuestionDAO extends EntityDAO<Question, Long> {
	/**
	 * 根据criteria条件查询出Question 为批量预览做准备
	 * 
	 * @param criteria
	 * @return
	 */
	List<Question> findCriteriaByQuestion(Criteria criteria);

	/**
	 * 获取组合题下的子题目
	 */
	List<Question> findQuestionListByParentId(Long parentId);
	
	
	/**
	 * 知识题库分页
	 * @author maxudong
	 * @param knowledgeId
	 * @return
	 */
	public PagingResult<Question> findListByKnowlegeId(Criteria criteria);

	/**
	 * 根据ConditionRule条件  查询试题
	 * @param comdition
	 * @return
	 */
	List<Question> randomQuestion(ConditionRule comdition);

	/**
	 * 查询自动生成的考生试题
	 * @param examination
	 * @return
	 */
	List<Question> findListByAutoGeneratingQuestion(ExamineeQuestion examinee);

	/**
	 * 据题纲的规则与范围  随机抽取试题
	 * @param comdition
	 * @return
	 */
	List<Question> randomPreviewQuestion(ConditionRule comdition);

	/**
	 * 处理添加试题时，已经添加的试题不再显示 只显示未添加的试题 根据相关条件查询 并进行过滤
	 * 搜索查询的分页方法
	 * @param criteria
	 * @return
	 */
	PagingResult<Question> searchByPagingResult(Criteria criteria);

	/**
	 * 处理专门预览  题纲下 所有手工添加的试题
	 * @param buildCriteria
	 * @return
	 */
	List<Question> preview(Criteria buildCriteria);
}