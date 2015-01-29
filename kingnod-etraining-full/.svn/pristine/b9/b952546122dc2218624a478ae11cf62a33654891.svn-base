package com.kingnod.etraining.exam.service.impl;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.dao.KnowledgeDAO;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.service.KnowledgeService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class KnowledgeServiceImpl implements KnowledgeService {

	@Autowired
	protected KnowledgeDAO knowledgeDAO;

	public Knowledge getKnowledge(Long id) {
		return knowledgeDAO.get(id);
	}

	public int saveKnowledge(Knowledge knowledge) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) knowledge;
		if (null != idEntity.getId()
				&& null != knowledgeDAO.get(idEntity.getId())) {
			count = knowledgeDAO.update(knowledge);
		} else {
			count = knowledgeDAO.insert(knowledge);
		}
		return count;
	}

	public int deleteKnowledge(Knowledge knowledge) {
		return knowledgeDAO.delete(knowledge);
	}

	public int deleteKnowledgeByIds(Long[] ids) {
		return knowledgeDAO.deleteById(ids);
	}

	public PagingResult<Knowledge> findKnowledge(Criteria criteria) {
		return knowledgeDAO.findPagingResult(criteria);
	}

	 /**
	 * 查询出所有与该知识点相关联的试题
	 * 
	 * @return
	 */
	public List<Question> findInteractionQuestion(Long[] ids) {
		if(null != ids && 0 != ids.length) {
			return knowledgeDAO.findQuestion(ids[0]);
		}
		return null;
	}
	
	/**
	 * 查询文件夹名称
	 */
	public String findFolderNameByFolderId(Long folderId) {
		return knowledgeDAO.findFolderName(folderId);
	}
}