package com.kingnod.etraining.exam.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;

@com.kingnod.core.annotation.Generated("2012-04-15 12:12")
public interface QuestionService {
	
	/**
	 * 保存试题
	 * @param questionList
	 * @return
	 */
	Integer saveQuestion(List<Question> questionList);
	
	/**
	 * 处理填空题
	 * @param questionList
	 * @param questionContent
	 * @return
	 */
	Question parseStringT(List<Question> questionList, String questionContent);
	/**
	 * 根据parent id获取题库文件夹
	 * 
	 * @param id
	 * @return
	 */
	List<TreeNode> getQuestionFolderList(Long id, String nodeType);

	/**
	 * 根据id查询所有的question  
	 * @param testGroupId 
	 * @param ids
	 * @return
	 */
	List<TestGroup> previewQuestion(Long testGroupId, Long... idsList);

	/**
	 * 处理添加试题时，已经添加的试题不再显示 只显示未添加的试题 根据相关条件查询 并进行过滤
	 * 
	 * @param question
	 * @param pager
	 * @return
	 */
	PagingResult<Question> searchQuestion(Question question, Pager<Question> pager);
	
	@com.kingnod.core.annotation.Generated("2012-04-15 12:12")
	Question getQuestion(Long id);

	@com.kingnod.core.annotation.Generated("2012-04-15 12:12")
	int saveQuestion(Question question);

	@com.kingnod.core.annotation.Generated("2012-04-15 12:12")
	int deleteQuestion(Question question);

	@com.kingnod.core.annotation.Generated("2012-04-15 12:12")
	int deleteQuestionByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-04-15 12:12")
	PagingResult<Question> findQuestion(Criteria criteria);

	/**
	 * 根据parentId去查询该组合题下面所有的试题与答案
	 * @param parentId
	 * @return
	 */
	List<Question> findListByParentId(Long parentId);
	
	/**
	 * @author maxudong
	 * 知识库中题库
	 */
	public PagingResult<Question> findListByKnowlegeId(Criteria criteria);
	
	
	/**
	 * 获取组合题下的子题目
	 */
	List<Question> findQuestionListByParentId(Long parentId);
	
	/**
	 * 查询是否可以修改试题类型 , 知识点,  课程
	 * @param ques
	 * @return
	 */
	Question isUpdate(Question ques);
}