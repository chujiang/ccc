package com.kingnod.etraining.common.webservices;

import java.util.List;

import com.kingnod.etraining.common.webservices.bean.WSQuestion;
import com.kingnod.etraining.common.webservices.bean.WSQuestionAnswer;
import com.kingnod.etraining.common.webservices.bean.WSResourceFolder;
/**
 * 考试模块提供给异构系统调用的WebService接口。
 * @author Sam
 *
 */
public interface ExaminationServices {
	
	/**
	 * 登录
	 * @param loginName
	 * @param password
	 * @param siteName
	 * @return
	 */
	public String login(String loginName, String password, String siteName);
	/**
	 * 清除缓存中的试题
	 */
	public void clear(String loginName);
	
	/**
	 * 保存一个问题至缓存中
	 * @param question
	 * @return
	 */
	public WSQuestion putQuestion(String loginName, String password, String siteName, int index, WSQuestion question);
	
	/**
	 * 根据ID取得某个目录列表
	 * @param folderId
	 * @return
	 */
	public List<WSResourceFolder> getResourceFolderList(String loginName, String password, String siteName, Long folderId);
	
	
	/**
	 * 保存一个问题答案选项至缓存中
	 * @param questionAnswer
	 * @return
	 */
	public WSQuestionAnswer putQuestionAnswer(String loginName, String password, String siteName, int index, WSQuestionAnswer questionAnswer);
	
	/**
	 * 提交缓存中的试题至数据库
	 * @return
	 */
	public int sumbit(String loginName, String password, String siteName);
	 
}
