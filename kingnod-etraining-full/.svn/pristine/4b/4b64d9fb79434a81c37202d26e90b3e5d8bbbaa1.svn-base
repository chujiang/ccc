package com.kingnod.etraining.common.ui.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.components.Component;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.kingnod.etraining.common.ui.components.Questions;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.opensymphony.xwork2.util.ValueStack;

public class QuestionsTag extends BaseUITag {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2154950640215144864L;

	protected List<Question> questions = new ArrayList<Question>();
	
	protected String showAnswer;//是否显示考生答案和正确答案
	
	protected List<TestGroup> testGroupList = new ArrayList<TestGroup>(); 

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new Questions(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();
		Questions que = ((Questions) component);
		que.setShowAnswer(getDisplayAnswer());
		
		//设置填空题出发事件，保存填空题答案
		if(testGroupList != null && testGroupList.size() > 0){
			processCompletion();
		}
		que.setTestGroupList(testGroupList);
	}
	
	/**
	 * 判断是否显示正确答案
	 * @return String
	 */
	public String getDisplayAnswer(){
		return StringUtils.isNotEmpty(showAnswer) ? showAnswer : ExamConstant.STATUS_CONSULT;
	}
	
	/**
	 * 处理填空题
	 * @return
	 */
	protected void processCompletion() {
		for (TestGroup testGroup : testGroupList) {
			List<Question> questList = testGroup.getQuestionList();
			for (int i = 0; i < questList.size(); i++) {
				Question question = questList.get(i);
				if(ExamConstant.QUESTION_TYPE_T.equals(question.getType())) {
					question = this.parseContent(question);
					questList.set(i, question);
				}
			}
		}
	}
	
	/**
	 * 在线考试时，获取考生填写的答案
	 * 
	 * @param index
	 * @param list
	 * @return String
	 */
	public String getExamAnswer(int index ,List<String> list){
		if(list != null && list.size() > 0 && list.size()-1 >= index){
			return list.get(index);
		}
		return StringUtils.EMPTY;
	}
	
	/**
	 * 处理填空题  将填空题的input加上onChange事件
	 * @param question
	 * @return Question
	 */
	protected Question parseContent(Question question) {
		// 将字符串转成NodeList类型
		Parser parser = Parser.createParser(question.getContent(), "utf-8");
		NodeList fatherList = null;
		try {
			fatherList = parser.parse(null);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		String newContent = "";
		int index = 0;
		if(1 == fatherList.size()) {
			NodeList childList = fatherList.elementAt(0).getChildren();
			for (int i = 0; i < childList.size(); i++) {
				Node childNode = childList.elementAt(i);
				try {
					Tag txtTag = (Tag) childNode;
					txtTag.toHtml();
					if("Online".equals(showAnswer)) {//在线考试
						String content = getExamAnswer(index,question.getExamAnswer());
						String itemContent = StringUtils.isNotEmpty(content) ? content : " ";
						newContent += "<input type='text' onChange='saveTAnswers(this);' value='" + itemContent + "' class='textBorder' name='question_" + question.getId() + "' />";
						index += 1;
					}else if("PreviewAnswer".equals(showAnswer) || "ConsultAnswer".equals(showAnswer) || "Consult".equals(showAnswer) || "Admin".equals(showAnswer)) {
						String itemContent = StringUtils.EMPTY;
						if("PreviewAnswer".equals(showAnswer)) {
							String content = question.getQuestionAnswers().get(index).getItemContent();
							itemContent = StringUtils.isNotEmpty(content) ? content : " ";
						}else if("ConsultAnswer".equals(showAnswer) || "Consult".equals(showAnswer) || "Admin".equals(showAnswer)) {
							String content = StringUtils.EMPTY;
							if(question.getExamAnswer().size() > index) {
								content = question.getExamAnswer().get(index);
							}
							content = addNumberCode(index,content);
							itemContent = StringUtils.isNotEmpty(content) ? content : " ";
						}
						newContent += "<input type='text' readonly onChange='saveTAnswers(this);'  value='" + itemContent + "' class='textBorder' name='question_" + question.getId() + "' />";
						index += 1;
					} else {
						newContent += "<input type='text' onChange='saveTAnswers(this);' class='textBorder' name='question_" + question.getId() + "' />";
						index += 1;
					}
				} catch (Exception e) {
					newContent += childNode.toHtml();
				}
			}
			
		} else {
			for (int j = 0; j < fatherList.size(); j++) {
				Node node = fatherList.elementAt(j);
				try {
					Tag txtTag = (Tag) node;
					txtTag.toHtml();
					if("Online".equals(showAnswer)) {//在线考试
						String content = getExamAnswer(index,question.getExamAnswer());
						String itemContent = StringUtils.isNotEmpty(content) ? content : " ";
						newContent += "<input type='text' onChange='saveTAnswers(this);' value='" + itemContent + "' class='textBorder' name='question_" + question.getId() + "' />";
						index += 1;
					}else if("PreviewAnswer".equals(showAnswer)) {
						String content = question.getQuestionAnswers().get(index).getItemContent();
						String itemContent = StringUtils.isNotEmpty(content) ? content : " ";
						newContent += "<input type='text' readonly value='" + itemContent + "' class='textBorder' name='question_" + question.getId() + "' />";
						index += 1;
					}else if("ConsultAnswer".equals(showAnswer) || "Consult".equals(showAnswer) || "Admin".equals(showAnswer)){
						String content = getExamAnswer(index,question.getExamAnswer());
						content = addNumberCode(index,content);
						String itemContent = StringUtils.isNotEmpty(content) ? content : " ";
						newContent += "<input type='text' readonly value='" + itemContent + "' class='textBorder' name='question_" + question.getId() + "' />";
						index += 1;
					}else{
						newContent += "<input type='text' onChange='saveTAnswers(this);' class='textBorder' name='question_" + question.getId() + "' />";
						index += 1;
					}
				} catch (Exception e) {
					newContent += node.toHtml();
				}
			}
		}
		question.setContent(newContent);
		return question;
	}
	
	/**
	 * 给填空题每个填空项添加特殊编号
	 * @param index
	 * @param content
	 * @return String
	 */
	public String addNumberCode(int index,String content){
		String newContent = content;
		if(("ConsultAnswer".equals(showAnswer) || "Admin".equals(showAnswer)) && index >= 0){
			if(index == 0)
				newContent = "①" + newContent;
			else if(index == 1)
				newContent = "②" + newContent;
			else if(index == 2)
				newContent = "③" + newContent;
			else if(index == 3)
				newContent = "④" + newContent;
			else if(index == 4)
				newContent = "⑤" + newContent;
			else if(index == 5)
				newContent = "⑥" + newContent;
			else if(index == 6)
				newContent = "⑦" + newContent;
			else if(index == 7)
				newContent = "⑧" + newContent;
			else if(index == 8)
				newContent = "⑨" + newContent;
			else if(index == 9)
				newContent = "⑩" + newContent;
		}
		return newContent;
	}
	
	@Override
	public void release() {
		questions = null;
		name = null;
		testGroupList = null;
		super.release();
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getShowAnswer() {
		return showAnswer;
	}

	public void setShowAnswer(String showAnswer) {
		this.showAnswer = showAnswer;
	}

	public List<TestGroup> getTestGroupList() {
		return testGroupList;
	}

	public void setTestGroupList(List<TestGroup> testGroupList) {
		this.testGroupList = testGroupList;
	}

}
