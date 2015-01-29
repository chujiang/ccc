package com.kingnod.etraining.activity.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.service.ExaminationService;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.NoticeSettings;
import com.kingnod.etraining.common.service.NoticeService;
import com.kingnod.etraining.common.service.NoticeSettingsService;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.TestGroupUtils;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.ExamineeQuestionService;
import com.kingnod.etraining.exam.service.PaperService;
import com.kingnod.etraining.exam.service.QuestionService;
import com.kingnod.etraining.exam.service.TestGroupService;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results
({ 
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "examination", "namespace", "/aty", "folderId", "${folderId}", "siteId", "${siteId}", "publishStatus", "${publishStatus}"}), 
	@Result(name = ActivityConstant.PREVIEW, location = "/WEB-INF/content/exm/previewes.jsp",params = {"actionName", "examination", "namespace", "/aty" }),
	@Result(name = ActivityConstant.PREVIEW_IFRAME, location = "/WEB-INF/content/exm/previewes_iframe.jsp"),
	@Result(name = "relate-act", location = "/WEB-INF/content/exm/paper-relate-act.jsp")
})
@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
@ErrorMapping(method="publish,delete",result=EntityAction.RELOAD)
public class ExaminationAction extends FilterableEntityAction<Examination, Long> {
	
	@Autowired
	private ExamineeQuestionService examineeQuestionService;
	@Autowired
	private ExaminationService examinationService;
	@Autowired
	private PaperService paperService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TestGroupService testGroupService;
	
	
	private static final long serialVersionUID = -5372445321312734329L;
	private long folderId;
	private long siteId;
	private String folderName;
	private Examination examination;
	private String publishStatus;
	private boolean includeSubFolderVal;
	private String type = StringUtils.EMPTY;//考试活动和试卷预览共享同一个页面，用此字段区分
	private List<TestGroup> testGroupList = new ArrayList<TestGroup>();
	private List<Question> quesList = new ArrayList<Question>();
	private Long testGroupId;
	private String paperName;
	/**
	 * 查询文件夹名称
	 */
	@Override
	public String input() throws Exception {
		folderName = examinationService.findFolderNameByFolderId(folderId);
		Long[] ids = this.getIdValues();
		if(null != ids) {
			entity = examinationService.getExamination(ids[0]);
			paperName = paperService.getPaper(entity.getAtyPaperId()).getName();
		}
		//获取通知信息
		getNoticeSettingsMess();
		return INPUT;
	}
	
	/**
	 * 预览试卷
	 * @return String
	 */
	public String preview() {
		Examination examination = examinationService.getExamination(this.getIdValues()[0]);
		examination.setTotalScore(examination.getPaper().getTotalScore());
		examination.setTimes(null);
		testGroupList = examineeQuestionService.previewPaperOrExam(examination, null);
		request.getSession().setAttribute("testGroupList", testGroupList);
		type = ActivityConstant.PREVIEWES_TYPE_E;
		request.setAttribute("examination", examination);
		request.setAttribute("testGroupList", testGroupList);
		return ActivityConstant.PREVIEW;
	}
	
	private String qusetionIds;  // 试题选择预览标示
	private String knowledgeId; // 知识点ID 
	
	/**
	 * @author PiJingwei
	 * 处理  考试活动预览  与  试卷预览
	 * 从session中获取试题  
	 */
	@SuppressWarnings("unchecked")
	public void getTestGroupListBySession() {
		HttpSession session = request.getSession();
		examination.setTimes(null);
		testGroupList = (List<TestGroup>) session.getAttribute("testGroupList");
		if(ListUtils.isEmpty(testGroupList)) {
			testGroupList = examineeQuestionService.previewPaperOrExam(examination, null);
			return;
		}
		session.removeAttribute("testGroupList");
	}
	
	/**
	 * TODO 预览试卷的iframe
	 * @return String
	 */
	public String previewTo() {
		if(StringUtils.equals(ActivityConstant.PREVIEWES_TYPE_E,type)) {//考试活动预览
			examination = examinationService.getExamination(this.getIdValues()[0]);
			examination.setTimes(null);
			this.getTestGroupListBySession();
		}else if(StringUtils.equals(ActivityConstant.PREVIEWES_TYPE_P,type)) {//试卷预览
			this.getTestGroupListBySession();
		}else if(StringUtils.equals(ActivityConstant.PREVIEWES_TYPE_D,type)) {//知识点预览
			if (StringUtils.isNotEmpty(qusetionIds)) {
				testGroupList = questionService.previewQuestion(null, this.constructLonArray(qusetionIds));
			} else if(StringUtils.isNotEmpty(knowledgeId)){
				testGroupList = questionService.previewQuestion(null, this.constructLonArray(knowledgeId));
			}
		}else {// 组卷试题页面预览   组卷新增试题页面的预览
			Long[] ids = this.constructLonArray(qusetionIds);
			if(ids != null && ids.length > 0){
				testGroupList = questionService.previewQuestion(testGroupId, ids);
			} else {
				TestGroup testGroup = testGroupService.getTestGroup(testGroupId);
				testGroupList = TestGroupUtils.buildTestGroup(testGroup.getQuestionList(), new ArrayList<TestGroup>());
			}
		}
		TestGroupUtils.calculateScore(testGroupList);//计算测试区总分
		
		request.setAttribute("testGroupList", testGroupList);
		return ActivityConstant.PREVIEW_IFRAME;
	}
	
	
	/**
	 * 字符串构造long数组
	 * @param constructStr
	 * @return
	 */
	public Long[] constructLonArray(String constructStr) {
		if (StringUtils.isEmpty(constructStr))
			return new Long[0];

		String strArray[] = constructStr.split(",");
		Long longArray[] = new Long[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			longArray[i] = Long.valueOf(strArray[i]);
		}
		return longArray;
	}
	
	/**
	 * 发布
	 * @return
	 * @throws Exception 
	 */
	public String publish() throws Exception {
		examinationService.publish(examination, false);
		if(examination!=null &&examination.getId()!=null ){
			sendNotice(examination.getId() ,siteId);
		}
		return RELOAD;
	}
	
	/**
	 * 取消发布
	 * @return
	 * @throws Exception
	 */
	public String cancelPublish() throws Exception {
		examinationService.publish(examination, true);
		return RELOAD;
	}
	
	@Override
	@ErrorMapping(method = "save")
	public String save() throws Exception {
		
		 super.save();
		//保存通知设置
		saveNoticeSettings();
		return RELOAD;
	}
	/**
	 * 发布时发放通知
	 * @return
	 * @throws Exception
	 */
	public void sendNotice(Long objectId ,Long siteId){
		if (noticeService.getNoticeSettingsStatus(ObjectType.A_XN, NoticeType.A_XN_CHANGE, objectId, siteId) > 0) {
			   //组装数据
			Map<String, Object> noticeData = new HashMap<String, Object>();
			Examination exam = examinationService.getExamination(objectId);
		    Site site = siteService.getSite(siteId);
			noticeData.put("name", exam.getName());
			noticeData.put("atyTime", exam.getAtyTime());
			noticeData.put("reexamTimes", exam.getReexamTimes());
			noticeData.put("scoringType", exam.getScoringType());
			noticeData.put("displayScore", exam.getDisplayScore());
			if(!StringUtils.isEmpty(exam.getRemarks())){
				noticeData.put("remarks", exam.getRemarks());
			}
			else{
				noticeData.put("remarks", "暂无");
			}
			noticeData.put("totalScore", exam.getTotalScore());
			noticeData.put("advanceTime", exam.getAdvanceTime());
			noticeData.put("siteName",site.getName());
				//获取学员用户组
				 CriteriaBuilder noticeUserCb = Cnd.builder(User.class);
				 noticeUserCb.addParam("activityId", objectId);
				 noticeUserCb.addParam("recordStatus", "A");
				 List<User> listUser =userService.findNoSendNoticeEnrollByCriteria(noticeUserCb.buildCriteria());
				
				//调用发送通知接口
			    noticeService.saveNoticeFromSettingsBySystem(ObjectType.A_XN ,Long.valueOf(0),NoticeType.A_XN_NEW,Long.valueOf(0),listUser ,noticeData);
			}
		}
	
	/**
	 * 判断当前试卷是否存在相关联的考试活动
	 * 
	 * @return String
	 */
	public String ifExistExamination(){
		if(examination != null && examination.getAtyPaperId() != null){
			PagingResult<Examination> pagingResult = examinationService.findExaminationByPageId(examination.getAtyPaperId());
			List<Examination> list = pagingResult.getResult();
			if(list != null && list.size() > 0){
				ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, true);
			}else{
				ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, "没有相关的考试活动");
			}
		}
		return "jsonResult";
	}
	
	/**
	 * TODO 试卷关联考试活动
	 * 
	 * @return String
	 */
	public String pageRelateExamination(){
		if(examination != null && examination.getAtyPaperId() != null && examination.getFolderId() != null){
			PagingResult<Examination> pagingResult = examinationService.findExaminationByPageId(examination.getAtyPaperId());
			pager.setTotalCount(pagingResult.getTotalRows());
			pager.setResult(pagingResult.getResult());
			request.setAttribute("page", pager);
			
			Long paperId = 0L;
			String paperName = "";
			List<Examination> list = pagingResult.getResult();
			if(list != null && list.size() > 0){
				Paper cPaper = list.get(0).getPaper();
				if(cPaper != null){
					paperId = cPaper.getId();
					paperName = cPaper.getName();
				}
				
			}
			request.setAttribute("paperId",  paperId);
			request.setAttribute("paperName", paperName);
			request.setAttribute("folderId", examination.getFolderId());
		}
		return "relate-act";
	}
	
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if(includeSubFolderVal){
			cb.addParam("folderId", folderId);
		}else if( 0 != folderId) {
			cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
		}
	}

	
	
	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	public String filterDefines() {
		return "aty.examinationFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	protected Object getEntityService() {
		return this.examinationService;
	}

	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public Examination getExamination() {
		return examination;
	}


	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public String getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	public boolean isIncludeSubFolderVal() {
		return includeSubFolderVal;
	}

	public void setIncludeSubFolderVal(boolean includeSubFolderVal) {
		this.includeSubFolderVal = includeSubFolderVal;
	}


	public List<TestGroup> getTestGroupList() {
		return testGroupList;
	}


	public void setTestGroupList(List<TestGroup> testGroupList) {
		this.testGroupList = testGroupList;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	public String getQusetionIds() {
		return qusetionIds;
	}


	public void setQusetionIds(String qusetionIds) {
		this.qusetionIds = qusetionIds;
	}


	public String getKnowledgeId() {
		return knowledgeId;
	}


	public void setKnowledgeId(String knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public List<Question> getQuesList() {
		return quesList;
	}


	public void setQuesList(List<Question> quesList) {
		this.quesList = quesList;
	}

	/*************** 通知区域引入的文件****************************************/
	@Autowired
	private NoticeSettingsService noticeSettingsService;
	@Autowired 
	private NoticeService noticeService ;
	
	private NoticeSettings noticeSettings;
	@Autowired
	private UserService userService;
	
	@Autowired
	private SiteService siteService ;
	
	public NoticeSettings getNoticeSettings() {
		return noticeSettings;
	}


	public void setNoticeSettings(NoticeSettings noticeSettings) {
		this.noticeSettings = noticeSettings;
	}	
	
	/**
	    * 保存通知设置
	    */
		public void saveNoticeSettings() {
			
			// id为空时为首次设置通知区域
			if(noticeSettings!=null){
			if (noticeSettings.getId() == null) {
				noticeSettings.setObjectType(ObjectType.A_XN);
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
			if(this.entity.getId()!=null )
			//暂时屏蔽此方法,日后在调用
			//noticeSettings = noticeSettingsService.getNoticeSettings(ObjectType.A_XN,NoticeType.A_XN_CHANGE, this.entity.getId(), siteId);
			
			noticeSettings = noticeSettingsService.getNoticeSettings(ObjectType.A_XN, this.entity.getId(), siteId);
		}

	public Long getTestGroupId() {
		return testGroupId;
	}

	public void setTestGroupId(Long testGroupId) {
		this.testGroupId = testGroupId;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
		
	/******************   end       *************************************/
}