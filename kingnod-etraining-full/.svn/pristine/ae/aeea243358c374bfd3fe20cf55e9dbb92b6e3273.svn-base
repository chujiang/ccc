package com.kingnod.etraining.exam.entity;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.action.ExamUtil;

/**
 * 抽取出一些在试题中公用的方法
 * @author PiJingwei
 *
 */
public class QuestionUtils {
	/**
	 * 通过正则表达式 来替换question.getContent()中的标签
	 * @param question
	 * @return
	 */
	public static String replacQuestionContent(Question question) {
		String content = question.getContent();
		String replacContent = content.replaceAll("<.*?>", ""); // 通过正则表达式 来替换content中的标签
		return replacContent;
	}
	
	/**
	 * 将试题Id字符串强转成Long类型数据
	 * @param ids
	 * @return Long[]
	 */
	public static Long[] parseIntValue(String ids){
		if(StringUtils.isNotEmpty(ids)){
			String[] idsStr = ids.split(",");
			Long[] idsLong = new Long[idsStr.length];
			for (int i=0;i<idsStr.length;i++) {
				try{
					idsLong[i] = Long.parseLong(idsStr[i]);
				}catch (Exception e){}
			}
			return idsLong;
		}
		return new Long[0];
	}
	
	/**
	 * 通过正则表达式 来替换字符串中的html标签
	 * @param question
	 * @return
	 */
	public static String replacQuestionContent(String str) {
		String replacContent = str.replaceAll("<.*?>", ""); // 通过正则表达式 来替换content中的标签
		return replacContent;
	}
	
	/**
	 * 将字符串转成NodeList类型
	 * @param content
	 * @return NodeList
	 */
	public static NodeList createParser(String content) {
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
	 * @param bool 是否替换将 input标签   通过解析 用 ___下划线代替
	 * @return
	 */
	public static List<Question> parseContent(List<Question> questionList, Boolean bool) {
		List<Question> questions = new ArrayList<Question>();
		for (int i = 0; i < questionList.size(); i++) {
			Question question = questionList.get(i);
			// 处理分数    如果没有小数  则以小数显示
			question.setScoreStr(ExamUtil.formatNumerical(question.getScore()));
			
			if(!"T".equals(question.getType())) {
				if(bool) question.setContent(QuestionUtils.replacQuestionContent(question)); // 去除content中 html
				questions.add(question);
				continue;
			}
			NodeList fatherList = QuestionUtils.createParser(question.getContent());
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
							if(bool) {
								content += "_____";
								childTag.toHtml();
							} else {
								childTag.setAttribute("value", question.getQuestionAnswers().get(index).getItemContent());
								content += childTag.toHtml();
							}
						} catch (Exception e) {
							content += childNode.toHtml();
						}
					}
				} else {
					try {
						Tag txtTag = (Tag) node;
						if(bool) {
							content += "_____";
						} else {
							txtTag.setAttribute("value", question.getQuestionAnswers().get(index).getItemContent());
							content += txtTag.toHtml();
						}
						index += 1;
					} catch (Exception e) {
						content += node.toHtml();
					}
				}
				
			}
			question.setContent(content);
			if(bool) question.setContent(QuestionUtils.replacQuestionContent(question)); // 去除content中 html
			questions.add(question);
		}
		return questions;
	}
}
