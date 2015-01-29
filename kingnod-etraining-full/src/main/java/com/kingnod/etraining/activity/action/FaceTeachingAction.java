package com.kingnod.etraining.activity.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.FaceTeaching;
import com.kingnod.etraining.activity.service.FaceTeachingService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = {
		"actionName", "face-teaching", "namespace", "/aty" }) })
@com.kingnod.core.annotation.Generated("2012-03-03 10:48")
public class FaceTeachingAction extends
		FilterableEntityAction<FaceTeaching, Long> {

	private Long folderId;

	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	@Override
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		cb.andEQ("folderId", folderId);
	}

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-03-03 10:48")
	private FaceTeachingService faceTeachingService;

	@com.kingnod.core.annotation.Generated("2012-03-03 10:48")
	public String filterDefines() {
		return "aty.faceTeachingFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-03-03 10:48")
	protected Object getEntityService() {
		return this.faceTeachingService;
	}
}