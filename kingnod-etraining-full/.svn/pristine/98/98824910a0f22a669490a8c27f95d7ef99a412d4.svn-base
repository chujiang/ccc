package com.kingnod.etraining.exam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
public class KnowledgeDAOImpl extends MybatisEntityDAO<Knowledge, Long> implements KnowledgeDAO {
	
	@Autowired
	protected ResourceFolderDAO resourceFolderDAO;
	
	@Override
	protected void afterInsert(Knowledge entity) {
		CriteriaBuilder cb = Cnd.builder(Knowledge.class);
		cb.andEQ("id", entity.getId());
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "EXM_KNOWLEDGE");
		resourceFolderDAO.updateObjectCount(criteria);
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		CriteriaBuilder cb = Cnd.builder(Knowledge.class);
		cb.andIn("id", ListUtils.of(ids));
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "EXM_KNOWLEDGE");
		resourceFolderDAO.updateObjectCount(criteria);
	}

	/**
	 * 查询出所有与该知识点相关联的试题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Question> findQuestion(Long id) {
		return getSqlSession().selectList(ExamConstant.FINDQUESTION, id);
	}

	public String findFolderName(Long folderId) {
		return (String) getSqlSession().selectOne(ExamConstant.FINDFOLDERNAME_KNOWLEDGE, folderId);
	}

}