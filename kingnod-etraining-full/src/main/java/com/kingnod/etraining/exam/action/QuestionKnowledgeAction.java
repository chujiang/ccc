package com.kingnod.etraining.exam.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.exam.entity.QuestionKnowledge;
import com.kingnod.etraining.exam.service.QuestionKnowledgeService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "question-knowledge", "namespace", "/exm" }) })
@com.kingnod.core.annotation.Generated("2012-04-11 15:22")
public class QuestionKnowledgeAction extends FilterableEntityAction<QuestionKnowledge, Long> {
	private static final long serialVersionUID = -4445387362588075814L;
	@Autowired
	@com.kingnod.core.annotation.Generated("2012-04-11 15:22")
	private QuestionKnowledgeService questionKnowledgeService;

	@com.kingnod.core.annotation.Generated("2012-04-11 15:22")
	public String filterDefines() {
		return "exm.questionKnowledgeFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-04-11 15:22")
	protected Object getEntityService() {
		return this.questionKnowledgeService;
	}
}