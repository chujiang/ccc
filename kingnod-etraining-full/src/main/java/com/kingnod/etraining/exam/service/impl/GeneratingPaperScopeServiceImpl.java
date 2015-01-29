package com.kingnod.etraining.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.dao.GeneratingPaperRuleDAO;
import com.kingnod.etraining.exam.dao.GeneratingPaperScopeDAO;
import com.kingnod.etraining.exam.dao.TestGroupDAO;
import com.kingnod.etraining.exam.entity.ConditionRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.GeneratingPaperScopeService;

@org.springframework.stereotype.Service
public class GeneratingPaperScopeServiceImpl implements GeneratingPaperScopeService {

    @Autowired
    protected GeneratingPaperScopeDAO generatingPaperScopeDAO;
    
    @Autowired
    private GeneratingPaperRuleDAO ruleDAO;
    
    @Autowired
    private TestGroupDAO testGroupDAO;
    
    public GeneratingPaperScope getGeneratingPaperScope(Long id) {
        return generatingPaperScopeDAO.get(id);
    }

    public int saveGeneratingPaperScope(GeneratingPaperScope generatingPaperScope) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity<Long>) generatingPaperScope;
        if(null != idEntity.getId() && null != generatingPaperScopeDAO.get(idEntity.getId())){
            count = generatingPaperScopeDAO.update(generatingPaperScope);
        }else{
        	String questionFolderId =  generatingPaperScope.getQuestionFolderId();
            String[] folderIdArray = questionFolderId.split(",");
            if(null != folderIdArray) {
               List<GeneratingPaperScope> scopeList = new ArrayList<GeneratingPaperScope>();
         	   for (String folder : folderIdArray) {
         		   GeneratingPaperScope scope = new GeneratingPaperScope();
         		   scope.setQuestionFolderId(folder);
         		   scope.setExamPaperId(generatingPaperScope.getExamPaperId());
         		   scope.setTestGroupId(generatingPaperScope.getTestGroupId());
         		   scopeList.add(scope);
         		}
         	  count = generatingPaperScopeDAO.insert(scopeList);
            }
        }
        return count;
    }

    public int deleteGeneratingPaperScope(GeneratingPaperScope generatingPaperScope) {
        return generatingPaperScopeDAO.delete(generatingPaperScope);
    }

    public int deleteGeneratingPaperScopeByIds(Long[] ids) {
        return generatingPaperScopeDAO.deleteById(ids);
    }

    public PagingResult<GeneratingPaperScope> findGeneratingPaperScope(Criteria criteria) {
        return generatingPaperScopeDAO.findPagingResult(criteria);
    }

    //根据 folderId  查询题库试题总数
	public List<GeneratingPaperRule> setQuantityQuestion(List<GeneratingPaperScope> scopeList,  List<GeneratingPaperRule> ruleList) {
		if(ListUtils.isNotEmpty(scopeList) && ListUtils.isNotEmpty(ruleList)) {
			for (GeneratingPaperRule rule : ruleList) {
				Integer questionNumber = this.findQuestionNumberSize(scopeList, rule);
				if(null != questionNumber) {
					rule.setQuantityQuestion(questionNumber);
				}
			}
		}
		return ruleList;
	}
	
	public Integer findQuestionNumberSize(List<GeneratingPaperScope> scopeList, GeneratingPaperRule rule) {
		String[] folderIdArray = new String[scopeList.size()];
		if(null != scopeList && 0 != scopeList.size()) {
			for (int i = 0; i < scopeList.size(); i++) {
				folderIdArray[i] = scopeList.get(i).getQuestionFolderId();
			}
		} else {
			return -1;
		}
		ConditionRule conditionRule = new ConditionRule();
		// setter folderId
		conditionRule.setFolderIdArray(folderIdArray);
		String knowledgeIds = rule.getKnowledgeId();
		String courseIds = rule.getCourseId();
		String questionType = rule.getQuestionType();
		Short degree = rule.getDegree();
		Long examPaperId = rule.getExamPaperId(); // 试卷ID
		// 查询   手工组卷的题纲
		List<TestGroup> testGroupList = testGroupDAO.findByCriteria(Cnd.builder(TestGroup.class).andEQ("examPaperId", examPaperId).andEQ("generatorPaperPattern", ExamConstant.GENERATOR_PAPER_M).buildCriteria());
		// 查询自动组卷的题纲
		List<TestGroup> autoTestList = testGroupDAO.findByCriteria(Cnd.builder(TestGroup.class).andEQ("examPaperId", examPaperId).andEQ("generatorPaperPattern", ExamConstant.GENERATOR_PAPER_A).andNotEQ("id", rule.getTestGroupId()).buildCriteria());
		List<Long> questionIdList = new ArrayList<Long>();
		if(ListUtils.isNotEmpty(testGroupList)) {
			for (TestGroup testGroup : testGroupList) {
				List<Long> Questionids = testGroupDAO.findQuestionId(testGroup);
				questionIdList.addAll(Questionids);
			}
		}
		// setter 知识点ID
		if(StringUtils.isNotEmpty(knowledgeIds)) {
			String[] knowledgeIdArray = knowledgeIds.split(",");
			conditionRule.setKnowledgeIdArray(knowledgeIdArray);
		}
		// setter 课程ID
		if(StringUtils.isNotEmpty(courseIds)) {
			String[] courseIdArray = courseIds.split(",");
			conditionRule.setCourseIdArray(courseIdArray);
		}
		if(StringUtils.isNotEmpty(questionType)) {
			conditionRule.setConditionType(questionType);
		}
		// setter 试题难度
		if(null != degree && 0 != degree) {
			conditionRule.setDegree(degree);
		}
		// setter 已经被手工添加过的试题ID
		if(ListUtils.isNotEmpty(questionIdList)) {
			conditionRule.setNotInIdsList(questionIdList);
		}
		int totalQuestionNumber = generatingPaperScopeDAO.totalQuestionNumber(conditionRule);
		for (TestGroup autoTest : autoTestList) {
			List<GeneratingPaperRule> ruleList = ruleDAO.findRule(autoTest);
			for (GeneratingPaperRule paperRule : ruleList) {
				Long ruleId = rule.getId();
				if(ruleId == null || ruleId == 0 || ruleId > paperRule.getId()) {
					String type = paperRule.getQuestionType();
					if(null != questionType && questionType.equals(type)) {
						totalQuestionNumber -= paperRule.getAmountQuestion();
					}
				}
			}
		}
		if(totalQuestionNumber < 0) return 0;
		return totalQuestionNumber;
	}

	public int deleteScopeById(Long examPaperId, Long testGroupId) {
		return generatingPaperScopeDAO.deleteByCriteria(Cnd.builder(GeneratingPaperScope.class).andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId).buildCriteria());
	}

}