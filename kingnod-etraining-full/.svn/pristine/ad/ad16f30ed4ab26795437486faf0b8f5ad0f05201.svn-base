package com.kingnod.etraining.activity.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.service.ElearningService;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.NoticeSettings;
import com.kingnod.etraining.common.service.NoticeService;
import com.kingnod.etraining.common.service.NoticeSettingsService;
import com.kingnod.etraining.course.server.models.AtyCourseInfo;
import com.kingnod.etraining.course.server.models.FindAtyCourse;
import com.kingnod.etraining.course.service.CourseInfoService;
import com.kingnod.etraining.course.service.impl.CourseInfoServiceImpl;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results({
		@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "elearning", "namespace", "/aty", "folderId", "${folderId}", "siteId", "${siteId}" }),
		@Result(name = "initial", type = "redirectAction", params = { "actionName", "training-plan-activity", "namespace", "/aty", "processId", "${processId}", "siteId",
				"${siteId}" }), @Result(name = "initial", location = "/WEB-INF/content/aty/elearning-situation.jsp"),
		@Result(name = "about_aty", location = "/WEB-INF/content/crs/about-aty-elearning.jsp") })
@com.kingnod.core.annotation.Generated("2012-02-14 11:45")
@ErrorMapping(method = "save")
public class ElearningAction extends FilterableEntityAction<Elearning, Long> {

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-14 11:45")
	private ElearningService elearningService;

	@Autowired
	private PeriodService periodService;

	@Autowired
	CourseInfoService courseInfoService;

	/*************** 通知区域引入的文件****************************************/
	@Autowired
	private NoticeSettingsService noticeSettingsService;
	@Autowired 
	private NoticeService noticeService ;
	@Autowired
	private SiteService siteService ;
	@Autowired
	FindAtyCourse findAtyCourse;
	private NoticeSettings noticeSettings;
	@Autowired
	private UserService userService;
	/******************   end       *************************************/
	
	private Long folderId;
	private Long processId;
	private Long siteId;
	private String dictType;

	private String releaseStauts; // 查询发布状态

	public String getReleaseStauts() {
		return releaseStauts;
	}

	public void setReleaseStauts(String releaseStauts) {
		this.releaseStauts = releaseStauts;
	}

	private boolean includeSubFolderVal;

	Elearning elearning;

	public Elearning getElearning() {
		return elearning;
	}

	public void setElearning(Elearning elearning) {
		this.elearning = elearning;
	}

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

	@com.kingnod.core.annotation.Generated("2012-02-14 11:45")
	public String filterDefines() {
		return "aty.elearningFilterItems";
	}

	@Override
	public String input() throws Exception {

		if (null == entity.getId()) {
			entity.setAllowLogout("Y");
		}
		getNoticeSettingsMess();
		return super.input();
	}

	@com.kingnod.core.annotation.Generated("2012-02-14 11:45")
	protected Object getEntityService() {
		return this.elearningService;
	}

	@Override
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		if (!includeSubFolderVal) {
			cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
		}

	}

	@SuppressWarnings("rawtypes")
	protected Map preparedCriteriaParams() {
		Map params = null;
		if (includeSubFolderVal) {
			params = MapUtils.mapByAarray("folderId", folderId);
		}
		return params;
	}

	public String initial() {//1.0-RELEASE先注释
		//elearningService.saveTrainingPlanActivity(this.getModel(), this.getProcessId());
		return "initial";
	}

	/**
	 * 发布
	 * 
	 * @return
	 * @throws Exception
	 */
	public String publish() throws Exception {

		elearningService.publish(elearning, true);
		if(elearning!=null &&elearning.getId()!=null)
		sendNotice(elearning.getId(),siteId);
		return RELOAD;
	}

	/**
	 * 发布时发放通知
	 * @return
	 * @throws Exception
	 */
	public void sendNotice(Long objectId ,Long siteId){
		 if (noticeService.getNoticeSettingsStatus(ObjectType.A_EL, NoticeType.A_EL_CHANGE, objectId, siteId) > 0) {
		   //组装数据
		    Site site = siteService.getSite(siteId);
		    AtyCourseInfo atyCourseInfo = findAtyCourse.findAtyCourseByAtyIdNoUser(elearning.getId(), ObjectType.A_EL);
		    Map<String, Object> noticeData = new HashMap<String, Object>();
			noticeData.put("courseName", atyCourseInfo.getCourseName());
			noticeData.put("sortName",atyCourseInfo.getSortName());
			noticeData.put("hour",atyCourseInfo.getHour());
			noticeData.put("description",atyCourseInfo.getDescription());
			noticeData.put("sortName",atyCourseInfo.getSortName());
			noticeData.put("siteName",site.getName());
			//获取学员用户组
			CriteriaBuilder noticeUserCb = Cnd.builder(User.class);
			 noticeUserCb.addParam("activityId", objectId);
			 noticeUserCb.addParam("recordStatus", "A");
			List<User> listUser =userService.findNoSendNoticeEnrollByCriteria(noticeUserCb.buildCriteria());
			
			//调用发送通知接口
		    noticeService.saveNoticeFromSettingsBySystem(ObjectType.A_EL ,Long.valueOf(0),NoticeType.A_EL_NEW,Long.valueOf(0),listUser ,noticeData);
		 }
	} 
	
	public String byCourseList() throws Exception {
		PagingResult<Elearning> pagingResult = elearningService.findElearningByCourseId(Long.valueOf(request.getParameter("courseId")), pager);
		pager.setTotalCount(pagingResult.getTotalRows());
		pager.setResult(pagingResult.getResult());
		request.setAttribute("page", pager);
		request.setAttribute("folderId", request.getParameter("folderId"));
		request.setAttribute("courseId", request.getParameter("courseId"));
		this.entity.setCourseName(courseInfoService.getCourseInfo(Long.valueOf(request.getParameter("courseId"))).getCourseTitle());
		return "about_aty";
	}

	/**
	 * 取消发布
	 * 
	 * @return
	 * @throws Exception
	 */
	public String cancelPublish() throws Exception {
		elearningService.publish(elearning, false);
		return RELOAD;
	}

	/**
	 * 学习情况
	 * 
	 * @return
	 */
	public String situation() throws Exception {

		return "situation";

	}

	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public boolean isIncludeSubFolderVal() {
		return includeSubFolderVal;
	}

	public void setIncludeSubFolderVal(boolean includeSubFolderVal) {
		this.includeSubFolderVal = includeSubFolderVal;
	}

	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if (includeSubFolderVal) {
			cb.addParam("folderId", folderId);
		} else if (null != folderId && !"".equals(folderId)) {
			cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
		}
		if (!StringUtils.isEmpty(releaseStauts)) {
			cb.andEQ("releaseStauts", releaseStauts);
		}
	}
	/**
	 * 重新父类方法主要是为了保存通知设置
	 */
    @Override
    public String save() throws Exception{
			super.save();
			saveNoticeSettings();
    	return RELOAD;
    }
	
   /**
    * 保存通知设置
    */
	public void saveNoticeSettings() {
		// id为空时为首次设置通知区域
		if(noticeSettings!=null){
		if ( noticeSettings.getId() == null) {//在线学习保存时saveNoticeSettings 方法报空指针错误。
			noticeSettings.setObjectType(ObjectType.A_EL);
			noticeSettings.setObjectId(this.entity.getId());
			noticeSettings.setSiteId(siteId);
		}
		noticeSettingsService.saveNoticeSettings(noticeSettings);
		}
	}
   /**
    * 获取通知信息
    */
	public void getNoticeSettingsMess() {
		if(this.entity.getId()!=null &&siteId != null)
		noticeSettings = noticeSettingsService.getNoticeSettings(ObjectType.A_EL, this.entity.getId(), siteId);
	}

	public NoticeSettingsService getNoticeSettingsService(){
		return noticeSettingsService;
	}

	public void setNoticeSettingsService(NoticeSettingsService noticeSettingsService) {
		this.noticeSettingsService = noticeSettingsService;
	}

	public void setNoticeSettings(NoticeSettings noticeSettings) {
		this.noticeSettings = noticeSettings;
	}

	public NoticeSettings getNoticeSettings() {
		return noticeSettings;
	}

}