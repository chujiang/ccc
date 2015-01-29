package com.kingnod.etraining.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.Tag;
import org.htmlparser.util.NodeList;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.action.ExamUtil;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.course.dao.CourseInfoDAO;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.TestGroupUtils;
import com.kingnod.etraining.exam.dao.ExamineeQuestionDAO;
import com.kingnod.etraining.exam.dao.GeneratingPaperScopeDAO;
import com.kingnod.etraining.exam.dao.KnowledgeDAO;
import com.kingnod.etraining.exam.dao.QuestionAnswerDAO;
import com.kingnod.etraining.exam.dao.QuestionDAO;
import com.kingnod.etraining.exam.dao.QuestionKnowledgeDAO;
import com.kingnod.etraining.exam.dao.QuestionTestGroupDAO;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.exam.entity.QuestionKnowledge;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import com.kingnod.etraining.exam.entity.QuestionUtils;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.QuestionAnswerService;
import com.kingnod.etraining.exam.service.QuestionService;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@org.springframework.stereotype.Service
/**
 * @author piJingwei
 */
public class QuestionServiceImpl implements QuestionService, QuestionAnswerService {

	@Autowired
	protected QuestionDAO questionDAO;
	
	@Autowired
	protected QuestionAnswerDAO questionAnswerDAO;
	
	@Autowired
	protected SiteDAO siteDAO;
	
	@Autowired
	protected ResourceFolderDAO resFolderDAO;
	
	@Autowired
	private QuestionKnowledgeDAO questionKnowledgeDAO;
	
	@Autowired
	private QuestionTestGroupDAO questionTestGroupDAO;
	
	@Autowired
	private KnowledgeDAO knowledgeDAO;
	
	@Autowired
	private CourseInfoDAO courseDAO;
	
	@Autowired
	private GeneratingPaperScopeDAO scopeDAO;
	
	@Autowired
	private ExamineeQuestionDAO examDAO;
	
	public Question getQuestion(Long id) {
		Question question = questionDAO.get(id);
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		question = QuestionUtils.parseContent(questionList, false).get(0);
		List<QuestionAnswer> answerList = question.getQuestionAnswers();
		for (int i = 0; i < answerList.size(); i++) {
			QuestionAnswer questionAnswer = answerList.get(i);
			String itemContent2 = questionAnswer.getItemContent2();
			if(null != itemContent2 && "".equals(itemContent2)) {
				String itemContent = questionAnswer.getItemContent();
				itemContent += itemContent2;
				questionAnswer.setItemContent(itemContent);
				answerList.set(i, questionAnswer);
			}
		}
		question.setQuestionAnswers(answerList);
		question = this.setCourseIds(question);
		question = this.setKnowledgeIds(question);
		return question;
	}

	/**
	 * 处理在编辑填空题时，将填空题的  “ input ” 的 name 改为：questionList[0].questionAnswers[0].itemContent
	 * 方便在保存试题的时候 直接保存  而无需做任何赋值操作
	 */
	public Question parseStringT(List<Question> questionList, String questionContent) {
		NodeList fatherList = QuestionUtils.createParser(questionContent);
		String content = "";
		int index = 0;
		List<QuestionAnswer> answerList = new ArrayList<QuestionAnswer>();
		Question quesion = new Question();
		for (int i = 0; i < fatherList.size(); i++) {
			Node node = fatherList.elementAt(i);
			try {
				Tag txtTag = (Tag) node;
				txtTag.removeAttribute("name");
				txtTag.setAttribute("name", "questionList[" + questionList.size() + "].questionAnswers[" + index + "].itemContent");
				content += txtTag.toHtml();
				QuestionAnswer questionAnswer = new QuestionAnswer();
				questionAnswer.setType("T");
				answerList.add(questionAnswer);
				index += 1;
			} catch (Exception e) {
				content += node.toHtml();
			}
		}
		quesion.setContent(content);
		quesion.setQuestionAnswers(answerList);
		return quesion;
	}
	
	/**
	 * 处理保存知识点
	 * @param ques
	 * @return
	 */
	public Integer saveQuestionKnowledge(Question ques) {
		Integer cont = 0;
		Long questionId = ques.getId();
		// 先删除知识点与课程相关的数据  再进行insert操作
		CriteriaBuilder cb = Cnd.builder(QuestionKnowledge.class).andEQ("questionId", questionId);
		cb.andGroup(Cnd.builder().orEQ("type", ExamConstant.KNOWLEDGE_K).orEQ("type", ExamConstant.KNOWLEDGE_C));
		questionKnowledgeDAO.deleteByCriteria(cb.buildCriteria());
		
		String knowledgeIds = ques.getKnowledgeId();
		String courseIds = ques.getCourseId();
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
					knowledgeQues.setQuestionId(questionId);
					knowledgeQues.setType(ExamConstant.KNOWLEDGE_K); // setter 知识类型为 ：K（知识点）
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
					knowledgeQues.setQuestionId(questionId);
					knowledgeQues.setType(ExamConstant.KNOWLEDGE_C); // setter 知识类型为 ：K（知识点）
					cont += questionKnowledgeDAO.insert(knowledgeQues);
				}
			}
		}
		return cont;
	}
	
	public int saveQuestion(Question question) {
		int count = 0;
		String content = question.getContent();
		List<QuestionAnswer> questionAnswerList = question.getQuestionAnswers();
		if(null == content || "".equals(content)) {
			throw Exceptions.createAppException("exm001001");
		}
		if(ListUtils.isEmpty(questionAnswerList)) {
			throw Exceptions.createAppException("exm001002");
		} else {
			for (QuestionAnswer questionAnswer : questionAnswerList) {
				if(StringUtils.isEmpty(questionAnswer.getItemContent())) {
					throw Exceptions.createAppException("exm001002");
				}
			}
		}
		
		
		IdEntity<Long> idEntity = (IdEntity<Long>) question;
		if (null != idEntity.getId() && null != questionDAO.get(idEntity.getId())) {
			saveQuestionKnowledge(question); // 保存试题与之相关联知识点，课程
			question.setCourseId(null);
			question.setKnowledgeId(null);
			count = questionDAO.update(question);
			//delete该试题下面的所有答案 
			questionAnswerDAO.deleteByCriteria(Cnd.builder(QuestionAnswer.class).andEQ("questionId", question.getId()).buildCriteria());
			List<QuestionAnswer> answerList = question.getQuestionAnswers();
			Integer right = answerList.get(0).getRight();
			for (int i = 0; i < answerList.size(); i++) {
				QuestionAnswer quesAnswer = answerList.get(i);
				if(null != right && i == right) {
					quesAnswer.setCorrect(true);
				}
				// 再进行insert
				quesAnswer.setQuestionId(question.getId());
				String itemContent = quesAnswer.getItemContent();
				if(itemContent.length() > 1336) {
					String newItemContent = itemContent.substring(0, 1336);
					quesAnswer.setItemContent(newItemContent);
					if(itemContent.length() > 2670) {
						quesAnswer.setItemContent2(itemContent.substring(1337, 2670));
					} else {
						quesAnswer.setItemContent2(itemContent.substring(1337, itemContent.length()));
					}
				}
				questionAnswerDAO.insert(quesAnswer);// 更新试题答案
			}
		} else {
			String courseId = question.getCourseId();
			String knowledgeId = question.getKnowledgeId();
			question.setCourseId(null);
			question.setKnowledgeId(null);
			count = questionDAO.insert(question);
			List<QuestionAnswer> answerList = question.getQuestionAnswers();
			Integer right = answerList.get(0).getRight();
			for (int i = 0; i < answerList.size(); i++) {
				QuestionAnswer quesAnswer = answerList.get(i);
				if(null != right && i == right) {
					quesAnswer.setCorrect(true);
				}
				quesAnswer.setQuestionId(question.getId());
				quesAnswer.setScore(question.getScore());
				String itemContent = quesAnswer.getItemContent();
				if(itemContent.length() > 4000) {
					quesAnswer.setItemContent2(itemContent.substring(40001, itemContent.length() - 1));
				}
				questionAnswerDAO.insert(quesAnswer); // 保存试题答案
			}
			question.setCourseId(courseId);
			question.setKnowledgeId(knowledgeId);
			saveQuestionKnowledge(question); // 保存试题与之相关联知识点，课程
		}
		
		return count;
	}

	public int deleteQuestion(Question question) {
		Long id = question.getId();
		this.isInQuestionTestGroup(id);// 验证试题是否被题纲引用
		this.isInGeneratingPaperScope(id);// 验证该试题是否被组卷规则中引用
		this.isInExamineeQuestion(id);// 验证试题是否被考生试题表中引用
		questionDAO.delete(question);
		questionAnswerDAO.deleteByCriteria(Cnd.builder(Question.class).andEQ("parentId", question.getId()).buildCriteria()); // 删除组合题下面的小题目
		CriteriaBuilder cb = Cnd.builder().andEQ("question_id", question.getId());
		return questionAnswerDAO.deleteByCriteria(cb.buildCriteria());
	}

	public int deleteQuestionByIds(Long[] ids) {
		for (int i = 0; i < ids.length; i++) {
			Long id = ids[i];
			this.isInQuestionTestGroup(id); // 验证该试题是否被手动添加到题纲中
			this.isInGeneratingPaperScope(id); // 验证该试题是否被抽题范围中引用
			this.isInExamineeQuestion(id); // 验证该试题是否在考生试题表中被引用
			CriteriaBuilder cb = Cnd.builder();
			cb.andEQ("question_id", id);
			questionAnswerDAO.deleteByCriteria(cb.buildCriteria());
			questionDAO.deleteByCriteria(Cnd.builder(Question.class).andEQ("parentId", id).buildCriteria()); // 删除组合题下面的小题目
		}
		return questionDAO.deleteById(ids);
	}

	public PagingResult<Question> findQuestion(Criteria criteria) {
		PagingResult<Question> pagingResult = questionDAO.findPagingResult(criteria);
		List<Question> questionList = pagingResult.getResult();
		QuestionUtils.parseContent(questionList, true);
		return pagingResult;
	}
	
	

	public QuestionAnswer getQuestionAnswer(Long id) {
		return questionAnswerDAO.get(id);
	}

	public int saveQuestionAnswer(QuestionAnswer questionAnswer) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) questionAnswer;
		if (null != idEntity.getId() && null != questionAnswerDAO.get(idEntity.getId())) {
			count = questionAnswerDAO.update(questionAnswer);
		} else {
			String itemContent = questionAnswer.getItemContent();
			if(itemContent.length() > 4000) {
				questionAnswer.setItemContent2(itemContent.substring(40001, itemContent.length()));
			}
			count = questionAnswerDAO.insert(questionAnswer);
		}
		return count;
	}

	public int deleteQuestionAnswer(QuestionAnswer questionAnswer) {
		return questionAnswerDAO.delete(questionAnswer);
	}

	public int deleteQuestionAnswerByIds(Long[] ids) {
		return questionAnswerDAO.deleteById(ids);
	}

	public PagingResult<QuestionAnswer> findQuestionAnswer(Criteria criteria) {
		return questionAnswerDAO.findPagingResult(criteria);
	}
	
	public List<TreeNode> getQuestionFolderList(Long id, String nodeType) {
		List<TreeNode> listTree = new ArrayList<TreeNode>();
		if ("".equals(nodeType)) {
			CriteriaBuilder siteCb = Cnd.builder(Site.class);
			siteCb.andIsNull("parentId").andEQ("recordStatus", RecordStatus.ACTIVE);
			List<Site> sitelist = siteDAO.findByCriteria(siteCb.buildCriteria());
			for (Site site : sitelist) {
				TreeNode tn;
				CriteriaBuilder orgCb2 = Cnd.builder(Site.class);
				orgCb2.andEQ("parentId",site.getId() ).andEQ("recordStatus", RecordStatus.ACTIVE);
				int sitesize = siteDAO.countByCriteria(orgCb2.buildCriteria());
				CriteriaBuilder orgCb3 = Cnd.builder(ActivityFolder.class);
				orgCb3.andEQ("siteId",site.getId() ).andEQ("recordStatus", RecordStatus.ACTIVE);
				int atysize = resFolderDAO.countByCriteria(orgCb3.buildCriteria());
				if(sitesize>0){
					 tn = new TreeNode(site.getId().toString(),
								String.valueOf(site.getParentId()), site.getName(), true);
				}else{
					if(atysize>0){
						 tn = new TreeNode(site.getId().toString(),
									String.valueOf(site.getParentId()), site.getName(), true);
						}else{
							tn = new TreeNode(site.getId().toString(),
									String.valueOf(site.getParentId()), site.getName(), false);
						}
				}
				tn.setNodeType(TreeNode.SITE);

				tn.setIcon(Struts2Utils.getRequest().getContextPath()+"/img/tree/site.gif");
				listTree.add(tn);
			}
		} else if (TreeNode.SITE.equals(nodeType)) {
//			子站点
			CriteriaBuilder siteCb = Cnd.builder(Site.class);
			siteCb.andEQ("parentId", id).andEQ("recordStatus", RecordStatus.ACTIVE);
			List<Site> sitelist = siteDAO.findByCriteria(siteCb.buildCriteria());
			for (Site site : sitelist) {
				TreeNode tn;
				CriteriaBuilder orgCb2 = Cnd.builder(Site.class);
				orgCb2.andEQ("parentId",site.getId() ).andEQ("recordStatus", RecordStatus.ACTIVE);
				int sitesize = siteDAO.countByCriteria(orgCb2 .buildCriteria());
				CriteriaBuilder orgCb3 = Cnd.builder(ActivityFolder.class);
				orgCb3.andEQ("siteId",site.getId() ).andEQ("recordStatus", RecordStatus.ACTIVE);
				int atysize = resFolderDAO.countByCriteria(orgCb3.buildCriteria());
				if(sitesize>0){
					 tn = new TreeNode(site.getId().toString(), String.valueOf(site.getParentId()), site.getName(), true);
				}else{
					if(atysize>0){
						tn = new TreeNode(site.getId().toString(),
								String.valueOf(site.getParentId()), site.getName(), true);
						}else{
							tn = new TreeNode(site.getId().toString(),
									String.valueOf(site.getParentId()), site.getName(), false);
						}
						
				}
				tn.setNodeType(TreeNode.SITE);
				tn.setIcon(Struts2Utils.getRequest().getContextPath()+"/img/tree/site.gif");
				listTree.add(tn);
			}
//			父活动文件夹
			CriteriaBuilder orgCb = Cnd.builder(ActivityFolder.class);
			orgCb.andEQ("siteId", id).andIsNull("parentId").andEQ("recordStatus",
					RecordStatus.ACTIVE).andEQ("type", "E");
			 List<ResourceFolder> resourceFolderlist = resFolderDAO.findByCriteria(orgCb.buildCriteria());
			for (ResourceFolder res : resourceFolderlist) {
				TreeNode tn;
				CriteriaBuilder orgCb2 = Cnd.builder(ActivityFolder.class);
				orgCb2.andEQ("parentId",res.getId() ).andEQ("recordStatus",
						RecordStatus.ACTIVE);
				int atysize = resFolderDAO.countByCriteria(orgCb2
						.buildCriteria());
				if(atysize>0){
					 tn = new TreeNode(res.getId().toString(),
							 res.getName(), true);
				}else{
				tn = new TreeNode(res.getId().toString(),
						res.getName(), false);
				}
				tn.setNodeType(TreeNode.RESOURCE_FOLDER);
				tn.setIcon(Struts2Utils.getRequest().getContextPath()+"/img/tree/contentGroup.gif");
				listTree.add(tn);
			}
		} else if (TreeNode.RESOURCE_FOLDER.equals(nodeType)) {
//			子活动文件夹
			CriteriaBuilder orgCb = Cnd.builder(ActivityFolder.class);
			orgCb.andEQ("parentId",id ).andEQ("recordStatus",
					RecordStatus.ACTIVE);
			List<ResourceFolder> resourceFolderlist = resFolderDAO.findByCriteria(orgCb.buildCriteria());
			for (ResourceFolder res : resourceFolderlist) {
				TreeNode tn;
				CriteriaBuilder orgCb2 = Cnd.builder(ActivityFolder.class);
				orgCb2.andEQ("parentId",res.getId() ).andEQ("recordStatus",RecordStatus.ACTIVE);
				int atysize = resFolderDAO.countByCriteria(orgCb2.buildCriteria());
				if(atysize>0){
					 tn = new TreeNode(res.getId().toString(),
							 res.getName(), true);
				}else{
				tn = new TreeNode(res.getId().toString(),
						res.getName(), false);
				}
				tn.setNodeType(TreeNode.ACTIVITY_FOLDER);
				tn.setIcon(Struts2Utils.getRequest().getContextPath()+"/img/tree/contentGroup.gif");
				listTree.add(tn);
			}
		}
		return listTree;
	}
	
	/**
	 * 处理  预览试题
	 * @param questionId
	 * @return
	 */
	public List<TestGroup> previewQuestion(Long testGroupId, Long... idsList) {
		List<Long> testGroupIdList = new ArrayList<Long>();
		List<Question> questionList = new ArrayList<Question>();
		if(null == idsList) {
			return new ArrayList<TestGroup>();
		}
		for (Long id : idsList) {
			testGroupIdList.add(id);
		}
		if(null != testGroupId) {
			questionList = questionDAO.preview(Cnd.builder(Question.class).andIn("id", testGroupIdList).andEQ("B.TEST_GROUP_ID", testGroupId).andEQ("B.RECORD_STATUS", "A").buildCriteria());
		}
		if(ListUtils.isEmpty(questionList) || testGroupIdList.size() != questionList.size()) {
			questionList = questionDAO.findByCriteria(Cnd.builder(Question.class).andIn("id", testGroupIdList).buildCriteria());
		}
		return TestGroupUtils.buildTestGroup(questionList, new ArrayList<TestGroup>());
	}
	
	

	/**
	 * 处理添加试题时，已经添加的试题不再显示   只显示未添加的试题     根据相关条件查询   并进行过滤
	 */
	public PagingResult<Question> searchQuestion(Question question, Pager<Question> pager) {
		String type = question.getType();
		
		CriteriaBuilder quesTestGroupCb = Cnd.builder(QuestionTestGroup.class);
		quesTestGroupCb.andEQ("examPaperId", question.getExamPaperId());
		// 查询在当前试卷中   已经被添加过的题目
		List<QuestionTestGroup> qtgList = questionTestGroupDAO.findByCriteria(quesTestGroupCb.buildCriteria());
		List<Long> questionIds = new ArrayList<Long>();
		for (QuestionTestGroup questionTestGroup : qtgList) {
			questionIds.add(questionTestGroup.getQuestionId());
		}
		
		// 开始setter 搜索条件
		if (null == pager)
			return null;
		// 设置分页信息
		CriteriaBuilder cb = Cnd.builder(Question.class);
		if (StringUtils.isNotBlank(pager.getOrderBy()) && StringUtils.isNotBlank(pager.getOrder())) {
			cb.orderBy(pager.getOrderBy(),Order.of( pager.getOrder()));
		}
		
		String knowledgeIds = question.getKnowledgeId();
		String courseIds = question.getCourseId();
		String questionFolderId = question.getQuestionFolderId();
		String[] questionDegre = question.getQuestionDegree();
		// setter 知识点
		if(!StringUtils.isEmpty(knowledgeIds)) {
			String[] knowledgeIdArray = knowledgeIds.split(",");
			List<Long> knowledgeIdList = new ArrayList<Long>();
			for (String knowledgeId : knowledgeIdArray) {
				knowledgeIdList.add(Long.parseLong(knowledgeId));
			}
			cb.addParam("knowledgeId", knowledgeIds);
			cb.andIn("C.KNOWLEDGE_ID", knowledgeIdList);
		}
		// setter 类型
		if(!StringUtils.isEmpty(type) && !ExamConstant.QUESTION_TYPE_U.equals(type)) {
			cb.andEQ("type", type);
		}
		// setter 课程
		if(!StringUtils.isEmpty(courseIds)) {
			String[] courseIdArray = courseIds.split(",");
			List<Long> courseIdList = new ArrayList<Long>();
			for (String courseId : courseIdArray) {
				courseIdList.add(Long.parseLong(courseId));
			}
			cb.addParam("courseId", courseIds);
			cb.andIn("B.KNOWLEDGE_ID", courseIdList);
		}
		// setter 题库
		if(!StringUtils.isEmpty(questionFolderId)) {
			String[] folderIds = questionFolderId.split(",");
			List<String> listFolderIds = new ArrayList<String>();
			for (int i = 0; i < folderIds.length; i++) {
				listFolderIds.add(folderIds[i]);
			}
			cb.andGroup(Cnd.builder().andIn("folderId", listFolderIds));
		}
		// setter 难度系数
		if(null != questionDegre && 0 != questionDegre.length) {
			List<String> listDegrees = new ArrayList<String>();
			for (int i = 0; i < questionDegre.length; i++) {
				listDegrees.add(questionDegre[i]);
			}
			cb.andGroup(Cnd.builder().andIn("degree", listDegrees));
		}
		// setter 已经被添加过了的试题ID
		if(!ListUtils.isEmpty(questionIds)) {
			cb.andGroup(Cnd.builder().andNotIn("id", questionIds));
		}
		cb.andEQ("recordStatus", "A");
		Criteria criteria = cb.buildCriteria().limit(new Long(pager.getFirst()),(new Long(pager.getLast())));
		PagingResult<Question> pagingResult = questionDAO.searchByPagingResult(criteria);
		List<Question> quesList = pagingResult.getResult();
		for (Question ques : quesList) {
			ques.setScoreStr(ExamUtil.formatNumerical(ques.getScore())); // 修复   分数显示的问题
			ques.setContent(QuestionUtils.replacQuestionContent(ques)); // 修复   试题内容显示问题 去除html
			
		}
		return pagingResult;
	}

	public Integer saveQuestion(List<Question> questionList) {
		Question question = questionList.get(0);
		String content = question.getContent();
		if(null == content || "".equals(content)) {
			throw Exceptions.createAppException("exm001001");
		}
		IdEntity<Long> idEntity = (IdEntity<Long>) question;
		if (null != idEntity.getId() && null != questionDAO.get(idEntity.getId())) {
			questionDAO.update(question);
		} else {
			questionDAO.insert(question);
		}
		Integer cont = 0;
		for (int i = 1; i < questionList.size(); i++) {
			Question ques = questionList.get(i);
			List<QuestionAnswer> answerList = ques.getQuestionAnswers();
			if(null == answerList || 0 == answerList.size()) {
				throw Exceptions.createAppException("exm001002");
			}
			ques.setParentId(question.getId());
			Long quesId = ques.getId();
			if(null != quesId && 0 != quesId) {
				questionDAO.deleteById(quesId); //删除试题
				questionAnswerDAO.deleteByCriteria(Cnd.builder(QuestionAnswer.class).andEQ("questionId", quesId).buildCriteria()); // 删除该试题下面的所有答案
			}
			cont += questionDAO.insert(ques);
			Integer right = null;
			if(null != answerList && 0 != answerList.size()) {
				right = answerList.get(0).getRight();
			}
			for (int j = 0; j < answerList.size(); j++) {
				QuestionAnswer questionAnswer = answerList.get(j);
				questionAnswer.setQuestionId(ques.getId());
				if(("R".equals(questionAnswer.getType()) || "B".equals(questionAnswer.getType())) && j == right) {
					questionAnswer.setCorrect(true);
				}
				String itemContent = questionAnswer.getItemContent();
				if(itemContent.length() > 4000) {
					questionAnswer.setItemContent2(itemContent.substring(40001, itemContent.length()));
				}
				questionAnswerDAO.insert(questionAnswer);
			}
		}
		return cont;
	}

	/**
	 * 根据parentId去查询该组合题下面所有的试题与答案
	 */
	public List<Question> findListByParentId(Long parentId) {
		List<Question> questionList = questionDAO.findByCriteria(Cnd.builder(Question.class).andEQ("parentId", parentId).orderBy("id", Order.ASC).buildCriteria());
		return QuestionUtils.parseContent(questionList, false);
	}
	
	/**
	 * @author maxudong
	 * 知识库中题库 
	 */
	    public PagingResult<Question> findListByKnowlegeId(Criteria criteria){
		PagingResult<Question> pagingResult = questionDAO.findListByKnowlegeId(criteria);
		List<Question> questionList = pagingResult.getResult();
		QuestionUtils.parseContent(questionList, true);
		return pagingResult;
	}
	
	/**
	 * 获取组合题下的子题目
	 */
	public List<Question> findQuestionListByParentId(Long parentId) {
		return questionDAO.findQuestionListByParentId(parentId);
	}
	
	public String setCourseName(Question question) {
		String courseIds = question.getCourseId();
		String courseName = "";
		if(StringUtils.isNotEmpty(courseIds)) {
			String[] courseIdArray = courseIds.split(",");
			List<Long> courseIdList = new ArrayList<Long>();
			for (String courseId : courseIdArray) {
				courseIdList.add(Long.parseLong(courseId));
			}
			List<CourseInfo> courseList = courseDAO.findByCriteria(Cnd.builder(CourseInfo.class).andIn("id", courseIdList).buildCriteria());
			for (int i = 0; i < courseList.size(); i++) {
				String CourseTitle = courseList.get(i).getCourseTitle();
				if(i == courseList.size() - 1) {
					courseName += CourseTitle;
				} else {
					courseName += CourseTitle + ",";
				}
			}
		}
		return courseName;
	}
	
	public String setKnowledgeName(Question question) {
		String knowledgeIds = question.getKnowledgeId();
		String knowledgeName = "";
		if(StringUtils.isNotEmpty(knowledgeIds)) {
			String[] knowledgeIdArray = knowledgeIds.split(",");
			List<Long> knowledgeIdList = new ArrayList<Long>();
			for (String knowledgeId : knowledgeIdArray) {
				knowledgeIdList.add(Long.parseLong(knowledgeId));
			}
			List<Knowledge> knowledgeList = knowledgeDAO.findByCriteria(Cnd.builder(Knowledge.class).andIn("id", knowledgeIdList).buildCriteria());
			for (int i = 0; i < knowledgeList.size(); i++) {
				String name = knowledgeList.get(i).getName();
				if(i == knowledgeList.size() - 1) {
					knowledgeName += name;
				} else {
					knowledgeName += name + ",";
				}
			}
		}
		return knowledgeName;
	}
	
	/**
	 * 验证该试题是否被抽题范围中引用
	 * @param id
	 */
	private void isInGeneratingPaperScope(Long id) {
		Question question = questionDAO.get(id);
		List<GeneratingPaperScope> scopeList = scopeDAO.findByCriteria(Cnd.builder(GeneratingPaperScope.class).andEQ("questionFolderId", question.getFolderId()).buildCriteria());
		if(ListUtils.isNotEmpty(scopeList)) {
			throw Exceptions.createAppException("exm001004");
		}
		return;
	}
	
	/**
	 * 验证该试题是否在考生试题表中被引用
	 * @param id
	 */
	private void isInExamineeQuestion(Long id) {
		List<ExamineeQuestion> examQuestionList = examDAO.findByCriteria(Cnd.builder(ExamineeQuestion.class).andEQ("questionId", id).buildCriteria());
		if(ListUtils.isNotEmpty(examQuestionList)) {
			throw Exceptions.createAppException("exm001005");
		}
		return;
	}

	/**
	 * 验证该试题是否被手动添加到题纲中
	 * @param id
	 */
	private void isInQuestionTestGroup(Long id) {
		List<QuestionTestGroup> QTGList = questionTestGroupDAO.findByCriteria(Cnd.builder(QuestionTestGroup.class).andEQ("questionId", id).buildCriteria());
		if(ListUtils.isNotEmpty(QTGList)) {
			throw Exceptions.createAppException("exm001003");
		}
		return;
	}
	
	/**
	 * 查询知识点是否可以修改
	 * @param question
	 * @return
	 */
	private boolean isUpdateKnowledge(Question question) {
		String knowledgeIds = question.getKnowledgeId();
		List<Long> knowledgeIdList = null;
		if(StringUtils.isNotEmpty(knowledgeIds)) {
			String[] knowledgeIdArray = knowledgeIds.split(",");
			knowledgeIdList = new ArrayList<Long>();
			for (String knowledgeId : knowledgeIdArray) {
				knowledgeIdList.add(Long.parseLong(knowledgeId));
			}
			CriteriaBuilder knowledgeCriteria = Cnd.builder(QuestionKnowledge.class).andIn("knowledgeId", knowledgeIdList).andEQ("type", ExamConstant.KNOWLEDGE_E);
			List<QuestionKnowledge> knowlegeList = questionKnowledgeDAO.findByCriteria(knowledgeCriteria.buildCriteria());
			if(ListUtils.isNotEmpty(knowlegeList)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 查询课程是否可以修改
	 * @param question
	 * @return
	 */
	private boolean isUpdateCourse(Question question) {
		String courseIds = question.getCourseId();
		List<Long> courseIdList = null;
		if(StringUtils.isNotEmpty(courseIds)) {
			String[] courseIdArray = courseIds.split(",");
			courseIdList = new ArrayList<Long>();
			for (String courseId : courseIdArray) {
				courseIdList.add(Long.parseLong(courseId));
			}
			CriteriaBuilder courseCriteria = Cnd.builder(QuestionKnowledge.class).andIn("knowledgeId", courseIdList).andEQ("type", ExamConstant.KNOWLEDGE_O);
			List<QuestionKnowledge> courseList = questionKnowledgeDAO.findByCriteria(courseCriteria.buildCriteria());
			if(ListUtils.isNotEmpty(courseList)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 是否可以修改试题类型
	 * @param question
	 * @return
	 */
	private boolean isUpdateType(Question question) {
		int count = scopeDAO.countByCriteria(Cnd.builder(GeneratingPaperScope.class).andEQ("questionFolderId", question.getFolderId()).buildCriteria());
		if(0 < count) {
			return false;
		}
		return true;
	}

	public Question isUpdate(Question question) {
		boolean updateCourse = this.isUpdateCourse(question);
		boolean updateKnowledge = this.isUpdateKnowledge(question);
		question.setUpdateCourse(updateCourse);
		question.setUpdateKnowledge(updateKnowledge);
		boolean updateType = true;
		String msg = "提示：该试题所在题库被试卷组卷策略引用，禁止删除及改动";
		if(!updateCourse) {
			question.setCourseName(this.setCourseName(question));
			updateType = false;
			msg = "课程、";
		}
		if(!updateKnowledge) {
			question.setKnowledgeName(this.setKnowledgeName(question));
			updateType = false;
			msg += "知识点、";
		}
		if(updateType) {
			updateType = this.isUpdateType(question);
		}
		if(!updateType) {
			msg += "试题类型";
		}
		question.setUpdateType(updateType);
		if(updateType && updateKnowledge && updateCourse) {
			question.setMsg(null);
		} else {
			msg += "!";
			question.setMsg(msg);
		}
		return question;
	}
	
	private Question setKnowledgeIds(Question question) {
		List<QuestionKnowledge> knowledgeList = question.getKnowledgeList();
		String knowledgeIds = "";
		if(ListUtils.isNotEmpty(knowledgeList)) {
			for (int i = 0; i < knowledgeList.size(); i++) {
				if(i == knowledgeList.size() - 1) {
					knowledgeIds += knowledgeList.get(i).getKnowledgeId();
				} else 
					knowledgeIds += knowledgeList.get(i).getKnowledgeId() + ",";
			}
		}
		question.setKnowledgeId(knowledgeIds);
		return question;
	}

	private Question setCourseIds(Question question) {
		List<QuestionKnowledge> coureseList = question.getCourseList();
		String coureseIds = "";
		if(ListUtils.isNotEmpty(coureseList)) {
			for (int i = 0; i < coureseList.size(); i++) {
				if(i == coureseList.size() - 1) {
					coureseIds += coureseList.get(i).getKnowledgeId();
				} else 
					coureseIds += coureseList.get(i).getKnowledgeId() + ",";
			}
		}
		question.setCourseId(coureseIds);
		return question;
	}
}