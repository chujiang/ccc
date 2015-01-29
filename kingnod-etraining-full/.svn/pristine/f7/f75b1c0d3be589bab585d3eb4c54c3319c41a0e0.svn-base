package com.kingnod.etraining.exam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.ConditionRule;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-04-15 12:12")
public class QuestionDAOImpl extends MybatisEntityDAO<Question, Long> implements QuestionDAO {
	
	@Autowired
	protected ResourceFolderDAO resourceFolderDAO;
	
	@Override
	protected void afterInsert(Question entity) {
		CriteriaBuilder cb = Cnd.builder(Question.class);
		cb.andEQ("id", entity.getId());
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "EXM_QUESTION");
		resourceFolderDAO.updateObjectCount(criteria);
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		CriteriaBuilder cb = Cnd.builder(CourseInfo.class);
		cb.andIn("id", ListUtils.of(ids));
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "EXM_QUESTION");
		resourceFolderDAO.updateObjectCount(criteria);
	}

	/**
	 * 根据criteria条件查询出Question 为批量预览做准备
	 * 
	 * @param criteria
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Question> findCriteriaByQuestion(Criteria criteria) {
		return getSqlSession().selectList(ExamConstant.FINDCRITERIABYQUESTION, criteria);
	}

	/**
	 * 查询与知识点关联试题
	 */
	public PagingResult<Question> findListByKnowlegeId(Criteria criteria){
		return super.pagingQuery(ExamConstant.PAGECOUNTKNOWLEGGEQUEST,ExamConstant.PAGEKNOWLEGGEQUEST, criteria) ;
	}

	/**
	 * 根据ConditionRule条件  查询试题
	 */
	@SuppressWarnings("unchecked")
	public List<Question> randomQuestion(ConditionRule comdition) {
		return getSqlSession().selectList("findListByConditionRule", comdition);
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> findListByAutoGeneratingQuestion(ExamineeQuestion examinee) {
		return getSqlSession().selectList("findAllByAutoGeneratingQuestion", examinee);
	}

	/**
	 * 获取组合题下的子题目
	 */
	@SuppressWarnings("unchecked")
	public List<Question> findQuestionListByParentId(Long parentId) {
		return getSqlSession().selectList(ExamConstant.FINDLISTBYPARENTID, parentId);
	}

	@SuppressWarnings("unchecked")
	public List<Question> randomPreviewQuestion(ConditionRule comdition) {
		return getSqlSession().selectList("findListByConditionRulePreview", comdition);
	}

	/*
	 * 处理添加试题时，已经添加的试题不再显示 只显示未添加的试题 根据相关条件查询 并进行过滤
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.QuestionDAO#searchByPagingResult(com.kingnod.core.criteria.Criteria)
	 */
	public PagingResult<Question> searchByPagingResult(Criteria criteria) {
		return pagingQuery(sqlId("countBySearchQuestion"), sqlId("findListBySearchQuestion"), criteria);
	}

	@SuppressWarnings("unchecked")
	public List<Question> preview(Criteria buildCriteria) {
		return getSqlSession().selectList("previewQuestionTestGroup", buildCriteria);
	}
}