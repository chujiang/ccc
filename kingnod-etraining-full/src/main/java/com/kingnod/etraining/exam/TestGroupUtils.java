package com.kingnod.etraining.exam;

import java.util.ArrayList;
import java.util.List;

import com.kingnod.core.util.NumberUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.action.ExamUtil;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;

/**
 * @author liuxiaobin
 * 测试区的帮助类
 */
public final class TestGroupUtils {
	
	private TestGroupUtils(){}
	
	/**
	 * 将试题放置到对应的测试区下
	 * 
	 * @param quesList
	 * @param testGroupList
	 * @return List<TestGroup>
	 */
	public static List<TestGroup> saveQuesToTestGroup(List<Question> quesList,List<TestGroup> testGroupList){
		int questionZ = 1;
		for(TestGroup testGroup : testGroupList){
			for(int i=0;i<quesList.size();i++){
				Question question = quesList.get(i);
				if(ExamConstant.QUESTION_TYPE_U.equals(testGroup.getQuestionType())){
					question.setType("U");
					testGroup.getQuestionList().add(question);
				}else if(StringUtils.equals(testGroup.getQuestionType(), quesList.get(i).getType())){
					if(ExamConstant.QUESTION_TYPE_Z.equals(testGroup.getQuestionType())){
						String chinaNumber = NumberUtils.chineseNumber(questionZ);//输入阿拉伯数字转中文数字
						question.setContent(chinaNumber + "、" + question.getContent());
						questionZ+=1;
					}
					question.setQuestionType(testGroup.getQuestionType());
					testGroup.getQuestionList().add(question);
				}
			}
		}
		return testGroupList;
	}
	
	/**
	 * 测试区分组
	 * 
	 * @param quesList
	 * @param testGroupList
	 * @return List<TestGroup>
	 */
	public static List<TestGroup> buildTestGroup(List<Question> quesList,List<TestGroup> testGroupList){
		for (Question question : quesList) {
			exitTestGroup(testGroupList,question);
		}
		return testGroupList;
	}
	
	/**
	 * 判断当前试题类型的测试区是否存在，如果 不存在，就创建测试区
	 * 
	 * @param question
	 */
	public static void exitTestGroup(List<TestGroup> testGroupList,Question question){
		if(testGroupList != null && testGroupList.size() <= 0){
			createTestGroup(testGroupList,question);
		}else{
			for(TestGroup testGroup : testGroupList){
				if(StringUtils.equals(testGroup.getQuestionType(), question.getType())){
					testGroup.getQuestionList().add(question);
					return;
				}
			}
			createTestGroup(testGroupList,question);
		}
	}
	
	/**
	 * 创建测试区
	 * 
	 * @param question
	 */
	public static void createTestGroup(List<TestGroup> testGroupList,Question question){
		TestGroup testGroup = new TestGroup();
		testGroup.setId(question.getId());
		testGroup.setName(getTestGroupType(question.getType()));
		testGroup.setQuestionType(question.getType());
		testGroup.getQuestionList().add(question);
		testGroupList.add(testGroup);
	}
	
	/**
	 * 获取测试区类型
	 * 
	 * @param type
	 * @return String
	 */
	public static String getTestGroupType(String type){
		type = StringUtils.isNotEmpty(type) ? type : ExamConstant.QUESTION_TYPE_U;
		if(StringUtils.equals(ExamConstant.QUESTION_TYPE_R, type)){
			return "单选题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_C, type)){
			return "多选题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_B, type)){
			return "判断题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_T, type)){
			return "填空题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_A, type)){
			return "简答题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_U, type)){
			return "无限制";
		}
		return "无限制";
	}
	
	/**
	 * 获取测试区固定顺序
	 * @return List<String>
	 */
	public static List<String> getTestGroupSeq(){
		List<String> testGroupSeq = new ArrayList<String>();//保存测试区顺序
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_R);//单选
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_C);//多选
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_B);//判断
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_T);//填空
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_A);//简答
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_U);//无限制
		return testGroupSeq;
	}
	

	/**
	 * 给试题列表构造测试区排序
	 * 
	 * @param testGroupList
	 * @return List<TestGroup>
	 */
	public static List<TestGroup> testGroupSort(List<TestGroup> testGroupList){
		List<String> testGroupSeq = ExamUtil.getTestGroupSeq();//给测试区中的试题标识排序
		
		//给测试区排序
		List<TestGroup> listTestGroup = new ArrayList<TestGroup>();
		for(String seq : testGroupSeq){
			for(TestGroup testGroup : testGroupList){
				if(StringUtils.equals(testGroup.getQuestionType(), seq)){
					String chinaNumber = NumberUtils.chineseNumber(listTestGroup.size()+1);//输入阿拉伯数字转中文数字
					Float toalScore = getTotalScore(testGroup);
					String sroceStr = toalScore != null ? "、总计"+toalScore+"分" : "";
					testGroup.setContent(chinaNumber+"、"+testGroup.getName()+"（共"+testGroup.getQuestionList().size()+"题"+sroceStr+"）");
					
					//根据Id排序
					SortList<Question> sortList = new SortList<Question>();
					sortList.Sort(testGroup.getQuestionList(), "getId");
					listTestGroup.add(testGroup);
				}
			}
		}
		testGroupList.clear();
		return listTestGroup;
	}
	
	/**
	 * 计算测试区总分
	 * @param list
	 */
	public static Integer getTestGroupTotalScore(List<TestGroup> list){
		Integer totalScore = 0;
		if(list != null && list.size() > 0){
			for (TestGroup testGroup : list) {
				totalScore += testGroup.getScore() != null ? testGroup.getScore() : 0;
			}
		}
		return totalScore;
	}
	
	/**
	 * 计算测试区总分
	 * @param list
	 */
	public static void calculateScore(List<TestGroup> list){
		if(list != null && list.size() > 0){
			for (TestGroup testGroup : list) {
				testGroup.setScore(getTotalScore(testGroup).intValue());
			}
		}
	}
	
	/**
	 * 获取某个测试区下的总分
	 * @param testGroup
	 * @return
	 */
	public static Float getTotalScore(TestGroup testGroup){
		Float totalScore = 0F;
		if(testGroup != null && testGroup.getScore() != null){
			return testGroup.getScore().floatValue();
		}
		for (Question question : testGroup.getQuestionList()) {
			if(question != null){
				totalScore = totalScore + question.getScore();
			}
		}
		return totalScore;
	}
	
	/**
	 * 试题顺序对应测试区里的试题顺序
	 * 
	 * @param quesList
	 * @return List<Question>
	 */
	public static List<Question> questionSort(List<Question> quesList){
		List<Question> list = new ArrayList<Question>();
		for (String string : getTestGroupSeq()) {
			for (Question question : quesList) {
				if(StringUtils.equals(string, question.getType())){
					list.add(question);
				}
			}
		}
		return list;
	}
}
