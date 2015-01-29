package com.kingnod.etraining.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.action.ExamUtil;
import com.kingnod.etraining.exam.dao.QuestionDAO;
import com.kingnod.etraining.exam.dao.QuestionTestGroupDAO;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import com.kingnod.etraining.exam.entity.QuestionUtils;
import com.kingnod.etraining.exam.service.QuestionTestGroupService;

@org.springframework.stereotype.Service
public class QuestionTestGroupServiceImpl implements QuestionTestGroupService {

	@Autowired
	protected QuestionTestGroupDAO questionTestGroupDAO;
	@Autowired
	protected QuestionDAO questionDAO;

	public QuestionTestGroup getQuestionTestGroup(Long id) {
		return questionTestGroupDAO.get(id);
	}
	
	/**
	 * 处理批量添加
	 * @param ids
	 * @return
	 */
	public int batchAdd(Long[] ids, Long testGroupId, Long examPaperId) {
		// 查询试题顺序
		int count = 0;
		QuestionTestGroup quesTestgroup = new QuestionTestGroup();
		quesTestgroup.setTestGroupId(testGroupId);
		quesTestgroup.setExamPaperId(examPaperId);
		Integer seq = questionTestGroupDAO.findMaxBySequenceOne(quesTestgroup);
		for (int i = 0; i < ids.length; i++) {
			if(ids.length > 1 && i != (ids.length - 1)) {
				if(ids[i+1].equals(ids[i])) {
					i += 1;
				}
			}
			Question ques = questionDAO.get(ids[i]);
			QuestionTestGroup questionTestGroup = new QuestionTestGroup();
			questionTestGroup.setQuestionId(ques.getId());
			questionTestGroup.setTestGroupId(testGroupId);
			questionTestGroup.setExamPaperId(examPaperId);
			questionTestGroup.setScore(ques.getScore());
			questionTestGroup.setDegree(ques.getDegree());
			questionTestGroup.setType(ques.getType());
			if(null == seq) {
				questionTestGroup.setSequence(i);
			} else {
				questionTestGroup.setSequence(seq += 1);
			}
			count += questionTestGroupDAO.insert(questionTestGroup);
		}
		return count;
	}

	public int saveQuestionTestGroup(QuestionTestGroup questionTestGroup) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) questionTestGroup;
		if (null != idEntity.getId() && null != questionTestGroupDAO.get(idEntity.getId())) {
			count = questionTestGroupDAO.update(questionTestGroup);
		} else {
			Integer sequence = questionTestGroupDAO.findMaxBySequenceOne(questionTestGroup);
			if(null == sequence) {
				sequence = 0;
			} else 
				sequence += 1;
			 CriteriaBuilder cb = Cnd.builder(QuestionTestGroup.class);
			 cb.andEQ("questionId", questionTestGroup.getQuestionId()).andEQ("examPaperId", questionTestGroup.getExamPaperId()).andEQ("testGroupId", questionTestGroup.getTestGroupId());
			 List<QuestionTestGroup> qtgList = questionTestGroupDAO.findByCriteria(cb.buildCriteria());
			 if(null != qtgList && 0 != qtgList.size()) {
				 return 0;
			 }
			questionTestGroup.setSequence(sequence);
			count = questionTestGroupDAO.insert(questionTestGroup);
		}
		return count;
	}

	public int deleteQuestionTestGroup(QuestionTestGroup questionTestGroup) {
		return questionTestGroupDAO.delete(questionTestGroup);
	}

	public int deleteQuestionTestGroupByIds(Long[] ids) {
		if(null == ids) return 0;
		CriteriaBuilder cb = Cnd.builder(QuestionTestGroup.class);
		CriteriaBuilder cb2 = Cnd.builder();
		cb2.andEQ("id", ids[0]);
		cb.andGroup(cb2);
		List<QuestionTestGroup> qtgList = questionTestGroupDAO.findByCriteria(cb.buildCriteria());
		QuestionTestGroup quesTestGroup = qtgList.get(0);
		long paperId = quesTestGroup.getExamPaperId();
		long testGroupId = quesTestGroup.getTestGroupId();
		int cont = questionTestGroupDAO.deleteById(ids);
		CriteriaBuilder cb3 = Cnd.builder(QuestionTestGroup.class);
		CriteriaBuilder cb4 = Cnd.builder();
		cb4.andEQ("examPaperId", paperId).andEQ("testGroupId", testGroupId);
		cb3.andGroup(cb4);
		cb3.orderBy("sequence", Order.ASC);
		List<QuestionTestGroup> questgList = questionTestGroupDAO.findByCriteria(cb3.buildCriteria());
		for (int i = 0; i < questgList.size(); i++) {
			QuestionTestGroup questg = questgList.get(i);
			int sequence = questg.getSequence();
			if(sequence != i) {
				sequence = i;
				questg.setSequence(sequence);
				questionTestGroupDAO.update(questg);
			}
		}
		return cont;
	}

	public PagingResult<QuestionTestGroup> findQuestionTestGroup(Criteria criteria) {
		PagingResult<QuestionTestGroup> pagingResult = questionTestGroupDAO.findPagingResult(criteria);
		List<QuestionTestGroup> qtgList = pagingResult.getResult();
		this.parseContent(qtgList, true);
		return pagingResult;
	}
	
	/**
	 * 将字符串转成NodeList类型
	 * @param content
	 * @return NodeList
	 */
	protected NodeList createParser(String content) {
		Parser parser = Parser.createParser(content, "utf-8");
		NodeList list = null;
		try {
			list = parser.parse(null);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 处理  将填空题的input标签  通过解析 用 ___下划线代替
	 * @param questionList
	 * @return
	 */
	protected List<QuestionTestGroup> parseContent(List<QuestionTestGroup> qtgList, Boolean bool) {
		List<QuestionTestGroup> quesTestGroupList = new ArrayList<QuestionTestGroup>();
		for (int i = 0; i < qtgList.size(); i++) {
			QuestionTestGroup quesTestGroup = qtgList.get(i);
			quesTestGroup.setScoreStr(ExamUtil.formatNumerical(quesTestGroup.getScore()));
			if(!"T".equals(quesTestGroup.getType())) {
				String questionContent = quesTestGroup.getQuestionContent();
				quesTestGroup.setQuestionContent(QuestionUtils.replacQuestionContent(questionContent)); // 去除content中html
				quesTestGroupList.add(quesTestGroup);
				continue;
			}
			NodeList fatherList = this.createParser(quesTestGroup.getQuestionContent());
			String content = "";
			int index = 0;
			for (int j = 0; j < fatherList.size(); j++) {
				Node node = fatherList.elementAt(j);
				NodeList childList = node.getChildren();
				if(null != childList && 0 != childList.size() && 1 == fatherList.size()) {
					for (int k = 0; k < childList.size(); k++) {
						Node childNode = childList.elementAt(k);
						try {
							Tag childTag = (Tag) childNode;
							content += "_____";
							childTag.toHtml();
						} catch (Exception e) {
							content += childNode.toHtml();
						}
					}
				} else {
					try {
						Tag txtTag = (Tag) node;
						txtTag.toHtml();
						content += "_____";
						index += 1;
					} catch (Exception e) {
						content += node.toHtml();
					}
				}
				
			}
			quesTestGroup.setQuestionContent(content);
			String questionContent = quesTestGroup.getQuestionContent();
			quesTestGroup.setQuestionContent(QuestionUtils.replacQuestionContent(questionContent)); // 去除content中html
			quesTestGroupList.add(quesTestGroup);
		}
		return quesTestGroupList;
	}

	/*
	 *  0 -- 上移+  1 -- 下移-   2 -- 至顶   3 -- 至尾
	 */
	public void movebleQuestionTestGroup(QuestionTestGroup questionTestGroup) {
		String upOrDown = questionTestGroup.getUpOrDown();
		Integer seq = questionTestGroup.getSequence();
		QuestionTestGroup quesGroup = null;
		List<QuestionTestGroup> qtgList = questionTestGroupDAO.findBySequence(questionTestGroup);
		if(null == qtgList || 0 == qtgList.size()) {
			return;
		}
		quesGroup = qtgList.get(0);
		questionTestGroup.setSequence(quesGroup.getSequence());
		//至顶
		if("2".equals(upOrDown)) {
			questionTestGroupDAO.update(questionTestGroup);
			questionTestGroup.setSequence(1);
			questionTestGroup.setNewGroupSeq(seq);
			questionTestGroupDAO.updateSequences(questionTestGroup);
			return;
		}
		//至尾
		if("3".equals(upOrDown)) {
			questionTestGroupDAO.update(questionTestGroup);
			questionTestGroup.setSequence(1);
			questionTestGroup.setNewGroupSeq(seq);
			questionTestGroupDAO.updateSequences(questionTestGroup);
			return;
		}
		quesGroup.setSequence(seq);
		questionTestGroupDAO.update(quesGroup);
		questionTestGroupDAO.update(questionTestGroup);
	}

	//根据questionId删除试题与测试区的关联数据
	public Integer deletequestionTestGroupByPaperId(Long testGroupId, Long... examPaperId) {
		CriteriaBuilder cb = Cnd.builder(QuestionTestGroup.class);
		CriteriaBuilder cb2 = Cnd.builder();
		if(null == testGroupId) {
			for (int i = 0; i < examPaperId.length; i++) {
				cb2.orEQ("examPaperId", examPaperId[i]);
			}
		} else {
			for (int i = 0; i < examPaperId.length; i++) {
				cb2.andEQ("examPaperId", examPaperId[i]).andEQ("testGroupId", testGroupId);
			}
		}
		return questionTestGroupDAO.deleteByCriteria(cb.andGroup(cb2).buildCriteria());
	}

	public String findFolderNameById(long folderId, String type) {
		return questionTestGroupDAO.findFolderName(folderId, type);
	}
}