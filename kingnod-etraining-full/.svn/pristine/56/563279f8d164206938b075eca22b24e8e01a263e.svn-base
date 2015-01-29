package com.kingnod.etraining.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.action.ExamUtil;
import com.kingnod.etraining.course.dao.CourseInfoDAO;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.dao.GeneratingPaperRuleDAO;
import com.kingnod.etraining.exam.dao.KnowledgeDAO;
import com.kingnod.etraining.exam.dao.QuestionKnowledgeDAO;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.QuestionKnowledge;
import com.kingnod.etraining.exam.service.GeneratingPaperRuleService;

@org.springframework.stereotype.Service
public class GeneratingPaperRuleServiceImpl implements GeneratingPaperRuleService {

    @Autowired
    protected GeneratingPaperRuleDAO generatingPaperRuleDAO;
    
    @Autowired
    private QuestionKnowledgeDAO questionKnowledgeDAO;
    
    @Autowired
    private KnowledgeDAO knowledgeDAO;
    
    @Autowired
    private CourseInfoDAO courseDAO;

    public GeneratingPaperRule getGeneratingPaperRule(Long id) {
        return generatingPaperRuleDAO.get(id);
    }
    
    /**
	 * 处理保存知识类型
	 * @param ques
	 * @return
	 */
	public Integer saveQuestionKnowledge(GeneratingPaperRule rule) {
		Integer cont = 0;
		Long ruleId = rule.getId();
		// 先删除知识点与课程相关的数据  再进行insert操作
		CriteriaBuilder cb = Cnd.builder(QuestionKnowledge.class).andEQ("questionId", ruleId);
		cb.andGroup(Cnd.builder().orEQ("type", ExamConstant.KNOWLEDGE_E).orEQ("type", ExamConstant.KNOWLEDGE_O));
		questionKnowledgeDAO.deleteByCriteria(cb.buildCriteria());
		
		String knowledgeIds = rule.getKnowledgeId();
		String courseIds = rule.getCourseId();
		// 保存知识点
		if(StringUtils.isNotEmpty(knowledgeIds)) {
			String[] knowledgeArray = knowledgeIds.split(",");
			if(null != knowledgeArray && 0 != knowledgeArray.length) {
				for (int i = 0; i < knowledgeArray.length; i++) {
					String id = knowledgeArray[i];
					if(StringUtils.isEmpty(id)) continue;
					Long knowledgeId = Long.parseLong(id);
					Knowledge knowledge = knowledgeDAO.get(knowledgeId);
					QuestionKnowledge knowledgeQues = new QuestionKnowledge();
					knowledgeQues.setKnowledgeName(knowledge.getName());
					knowledgeQues.setKnowledgeId(knowledgeId);
					knowledgeQues.setQuestionId(ruleId);
					knowledgeQues.setType(ExamConstant.KNOWLEDGE_E); // setter 知识类型为 ：K（知识点）
					cont += questionKnowledgeDAO.insert(knowledgeQues);
				}
			}
		}
		//保存课程
		if(StringUtils.isNotEmpty(courseIds)) {
			String[] courseArray = courseIds.split(",");
			if(null != courseArray && 0 != courseArray.length) {
				for (int i = 0; i < courseArray.length; i++) {
					String id = courseArray[i];
					if(StringUtils.isEmpty(id)) continue;
					Long courseId = Long.parseLong(id);
					CourseInfo course = courseDAO.get(courseId);
					QuestionKnowledge knowledgeQues = new QuestionKnowledge();
					knowledgeQues.setKnowledgeName(course.getCourseTitle());
					knowledgeQues.setKnowledgeId(courseId);
					knowledgeQues.setQuestionId(ruleId);
					knowledgeQues.setType(ExamConstant.KNOWLEDGE_O); // setter 知识类型为 ：K（知识点）
					cont += questionKnowledgeDAO.insert(knowledgeQues);
				}
			}
		}
		return cont;
	}

    public int saveGeneratingPaperRule(GeneratingPaperRule generatingPaperRule) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity<Long>) generatingPaperRule;
        if(null != idEntity.getId() && null != generatingPaperRuleDAO.get(idEntity.getId())){
            count = generatingPaperRuleDAO.update(generatingPaperRule);
        } else {
            count = generatingPaperRuleDAO.insert(generatingPaperRule);
        }
        this.saveQuestionKnowledge(generatingPaperRule); // 处理保存 知识点  与   课程
        return count;
    }

    public int deleteGeneratingPaperRule(GeneratingPaperRule generatingPaperRule) {
        return generatingPaperRuleDAO.delete(generatingPaperRule);
    }

    public int deleteGeneratingPaperRuleByIds(Long[] ids) {
        return generatingPaperRuleDAO.deleteById(ids);
    }

    public PagingResult<GeneratingPaperRule> findGeneratingPaperRule(Criteria criteria) {
        PagingResult<GeneratingPaperRule> pagingResult = generatingPaperRuleDAO.findPagingResult(criteria);
        List<GeneratingPaperRule> ruleList = pagingResult.getResult();
        for (GeneratingPaperRule rule : ruleList) {
        	rule.setEveryQuestionScoreStr(ExamUtil.formatNumerical(rule.getEveryQuestionScore()));
		}
        return pagingResult;
    }

    /*
     * (non-Javadoc)
     * @see com.kingnod.etraining.exam.service.GeneratingPaperRuleService#findTotalByPaperIdAndTestGroupId(java.lang.Long)
     */
	public Integer findTotalByPaperIdAndTestGroupId(Long examPaperId) {
		return generatingPaperRuleDAO.findTotalAmountQuestion(examPaperId);
	}

	public int deleteRuleById(Long examPaperId, Long testGroupId) {
		return generatingPaperRuleDAO.deleteByCriteria(Cnd.builder(GeneratingPaperRule.class).andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId).buildCriteria());
	}
   
}