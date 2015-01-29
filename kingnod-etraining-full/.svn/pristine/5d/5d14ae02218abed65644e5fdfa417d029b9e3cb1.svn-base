package com.kingnod.etraining.common.webservices.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.kingnod.core.exception.WebApplicationException;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.web.WebContextHolder;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.common.webservices.ExaminationServices;
import com.kingnod.etraining.common.webservices.bean.WSQuestion;
import com.kingnod.etraining.common.webservices.bean.WSQuestionAnswer;
import com.kingnod.etraining.common.webservices.bean.WSResourceFolder;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.exam.service.QuestionService;
import com.kingnod.etraining.resource.entity.ResourceFolder;

public class ExaminationServicesImpl implements ExaminationServices {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private static List<WSQuestion> questions = new ArrayList<WSQuestion>();

	public WSQuestion putQuestion(String loginName, String password, String siteName, int index, WSQuestion question) {
		if (question != null) {
			questions.add(index, question);
			return question;
		}
		return null;
	}
	
	public WSQuestionAnswer putQuestionAnswer(String loginName, String password, String siteName, int index, WSQuestionAnswer questionAnswer) {
		if (questionAnswer != null) {
			List<WSQuestionAnswer> questionAnswers = questions.get(index).getWSQuestionAnswers();
			if(null == questionAnswers){
				questionAnswers = new ArrayList<WSQuestionAnswer>();
				questions.get(index).setWSQuestionAnswers(questionAnswers);
			}
			questionAnswers.add(questionAnswer);
			return questionAnswer;
		}
		return null;
	}

	public List<WSResourceFolder> getResourceFolderList(String loginName, String password, String siteName, Long folderId) {
		try{
			authenticateIfRequired(loginName,password,siteName);
			TreeService treeService = SpringUtils.getBean(TreeService.class);
			List<ResourceFolder> folderList = treeService.getResourceViewChilds(folderId, ObjectType.R_OS, ObjectType.R_QF);
			List<WSResourceFolder> result = new ArrayList<WSResourceFolder>();
			for(ResourceFolder resFolder:folderList){
				WSResourceFolder wsResFolder = new WSResourceFolder();
				wsResFolder.setId(resFolder.getId());
				wsResFolder.setName(resFolder.getName());
				wsResFolder.setDescription(resFolder.getDescription());
				wsResFolder.setType(resFolder.getType().name());
				result.add(wsResFolder);
			}
			return result;
		}catch(WebApplicationException e){
			logger.error(e.getMessage(), e);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	
	private void authenticateIfRequired(String loginName, String password, String siteName) {
		if(null != SecurityUtils.getCurrentUser()){
			return;
		}
		AuthenticationManager authenticationManager = SpringUtils.getBean(AuthenticationManager.class);
		HttpServletRequest request =  WebContextHolder.getWebContext().getRequest();
		request.setAttribute("sitename", siteName);
		UsernamePasswordAuthenticationToken authToker = new UsernamePasswordAuthenticationToken(loginName, password);
		Authentication authentication =  authenticationManager.authenticate(authToker);
        
        SecurityContextHolder.getContext().setAuthentication(authentication);

           

    }

	public void clear(String loginName) {
		questions.clear();
	}

	public int sumbit(String loginName, String password, String siteName) {
		try{
			authenticateIfRequired(loginName,password,siteName);
			QuestionService questionService = SpringUtils.getBean(QuestionService.class);
			int result = 0;
			for(WSQuestion wsquestion:questions){
				
				Question question = new Question();
				List<QuestionAnswer> questionAnswers = new ArrayList<QuestionAnswer>();
				question.setFolderId(wsquestion.getFolderId());
				question.setContent(wsquestion.getContent());
				question.setType(wsquestion.getType());
				question.setScore(wsquestion.getScore());
				question.setDegree(wsquestion.getDegree());
				
				if(null != wsquestion.getWSQuestionAnswers()){
					for(WSQuestionAnswer wsquestionAnswer:wsquestion.getWSQuestionAnswers()){
						QuestionAnswer answer = new QuestionAnswer();
						answer.setItemContent(wsquestionAnswer.getItemContent());
						answer.setAnswerIndex(wsquestionAnswer.getAnswerIndex());
						answer.setType(wsquestionAnswer.getType());
						answer.setScore(wsquestion.getScore());
						answer.setCorrect(wsquestionAnswer.getCorrect());
						answer.setItemSeq(wsquestionAnswer.getItemSeq());
						questionAnswers.add(answer);
					}
					question.setQuestionAnswers(questionAnswers);
				}
				
				int count = questionService.saveQuestion(question);
				result = result + count;
			}
		}catch(WebApplicationException e){
			logger.error(e.getMessage(), e);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return 0;
	}

	public String login(String loginName, String password, String siteName) {
		try{
			authenticateIfRequired(loginName,password,siteName);
		}catch(WebApplicationException e){
			String errorMsg = SpringUtils.getMessage(e.getErrorCode(), new Object[]{});
			logger.error(e.getMessage(), e);
			return errorMsg;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return "未知异常";
		}
		return "success";
	}
 

}
