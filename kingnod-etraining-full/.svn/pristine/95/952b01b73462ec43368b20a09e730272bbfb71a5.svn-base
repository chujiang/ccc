package com.kingnod.etraining.activity.action;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ElearningSituation;
import com.kingnod.etraining.activity.service.ElearningService;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.utils.TimeUtil;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results({
		@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "elearning-situation", "namespace", "/aty", "folderId",
				"${folderId}", "siteId", "${siteId}", "activityId", "${activityId}" })}) 
@com.kingnod.core.annotation.Generated("2012-02-14 11:45")
public class ElearningSituationAction extends FilterableEntityAction<ElearningSituation, Long> {

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-14 11:45")
	private ElearningService elearningService;

	private Long activityId;
	private Long folderId;
	private Long siteId;
	private String dictType;
	private String q_status;

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	
	

	public String getQ_status() {
		return q_status;
	}

	public void setQ_status(String q_status) {
		this.q_status = q_status;
	}

	@com.kingnod.core.annotation.Generated("2012-02-14 11:45")
	public String filterDefines() {
		return "aty.elearningSituation";
	}

	@com.kingnod.core.annotation.Generated("2012-02-14 11:45")
	protected Object getEntityService() {
		return this.elearningService;
	}
	
	@Override
	protected void prepareModel() throws Exception {
		if(null != this.getIdValues()){
			if(this.getIdValues().length == 1){
				entity = elearningService.getElearningSituation(activityId, this.getIdValues()[0]);
			}else{
				entity = new ElearningSituation();
			}
			this.getValueStack().set("ids", this.getIdValues());
		}
	}

	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		cb.addParam("activityId", activityId);
		if(StringUtils.isNotEmpty(q_status)){
		  if(CourseConstant.COURSESTATUS_NOTATTEMPTED.equals(q_status)){//当为未尝试的时候为空
		    cb.andIsNull("C.STATUS");
		  }else{
			   cb.andEQ("C.STATUS", q_status);
		  }
		}
		cb.andEQ("1", "1");
	}
	
	@Override
	protected PagingResult<ElearningSituation> doQuery(Criteria criteria) {
		return elearningService.findBySituation(criteria);
	}

	public String input() throws Exception {
//		entity.getTotalDate();
//		request.setAttribute("totalDate", TimeUtil.secToHHMMSS(Integer.parseInt(entity.getTotalTime().toString())));
		if(null!=entity.getTotalTime()){
			entity.setTotalDate(TimeUtil.secToHHMMSS(entity.getTotalTime()));
		}
		request.setAttribute("folderId", folderId);
		return EntityAction.INPUT;

	}

	public String save() throws Exception {
		Long[] ids = this.getIdValues();
		entity.setTotalTime(TimeUtil.HHMMSSToSec(entity.getTotalDate()));
		if (null == ids) {
			elearningService.updateSituation(entity);
		} else {
			elearningService.updateElearningSituation(ids, activityId, entity);
		}
		return EntityAction.RELOAD;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

}