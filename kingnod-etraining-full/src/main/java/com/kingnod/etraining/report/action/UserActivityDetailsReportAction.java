package com.kingnod.etraining.report.action;



import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.export.util.Exporters;
import com.kingnod.etraining.course.utils.TimeUtil;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.report.entity.UserActivityDetailsReport;
import com.kingnod.etraining.report.service.UserActivityDetailsReportService;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Controller
@Namespace("/rpt")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "user-activity-details-report", "namespace", "/aty"})
}
)


public class UserActivityDetailsReportAction extends FilterableEntityAction<UserActivityDetailsReport, Long> {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5032540096499579629L;

	@Autowired
    private UserActivityDetailsReportService userActivityDetailsReportService;
    
    @Autowired
    private SiteService siteService;
    
    @Autowired
    private ResourceFolderService resourceFolderService;
    
    @Autowired
    private OrganizationService organizationService;
    

    private Long activityid;
    private Long courseid;
    private String ativityname;
    private String ativitytypte;
    
    private Long coursetypeId;
    private String coursetype;
    
    private Long userid;
    private String username;
    private Long orgId;//组织id
    private String orgname;
    private Long usergroupId;//用户组Id
    private String usergroup;
    private String enrollstatus;
    private String studystatus;
    private int  scoreCompOper;
    private Float score;
    private int  totalTimeCompOper;
    private Long totalTime;
    private String totalTimeStr;
    private Date completedDateStart_Time;
    private Date completedDateEnd_Time;
    
    private Date end_Time;
    private Date start_Time;
    
    private Long siteId;
    
    @Override
    public String execute() throws Exception {
    	request.setAttribute("page", pager);
    	return SUCCESS;
    }

    @Override
    public String list() throws Exception {
      
    CriteriaBuilder builder = Cnd.builder(UserActivityDetailsReport.class);
    
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    
    //通过siteId获得推荐课程的性息
    Long siteId = userDetails.getSiteId();
    
    if(!StringUtils.isEmpty(ativityname)){
      builder.andLike("a.name", ativityname);
    }
    if(!StringUtils.isEmpty(ativitytypte)){
      builder.andLike("a.type", "%" + ativitytypte + "%");
    }
    
    if(null!=coursetypeId){
       List<Long> list = resourceFolderService.findAllChildsCrsCategoryById(coursetypeId);
       builder.andIn("g.object2_id", list);
    }
    
    
    if(!StringUtils.isEmpty(username)){
      builder.andLike("c.full_name", username);
    }
    
    if(null!=orgId){
      List<Long> list = organizationService.finAllChildsOrgById(orgId); 
      builder.andIn("c.organization_id", list);
    }
    
    if(null!=usergroupId){
     
      builder.andEQ("h.user_group_id", usergroupId);
    }
    
    if(!StringUtils.isEmpty(usergroup)){
      builder.andLike("a.name", usergroup);
    }
    
    if(!StringUtils.isEmpty(enrollstatus)){
      builder.andLike("e.stauts", enrollstatus);
    }
    
    if(!StringUtils.isEmpty(studystatus)){
      builder.andLike("b.status", studystatus);
    }
    
    //if(!StringUtils.isEmpty(score)){
      //builder.andLike("a.name", score);
    //}
    
    if(null != score)
    {
         switch (scoreCompOper) {
       case 1:
         builder.andGE("b.score",score);
         break;
       case -1:
         builder.andLT("b.score",score);
         break;
       case 0:
         builder.andEQ("b.score",score);
         break;
    
       default:
         break;
       }
    }
    
    
    if(!StringUtils.isEmpty(totalTimeStr)){ 
      totalTime = TimeUtil.HHMMSSToSec(totalTimeStr);
    if(null != totalTime)
    {
         switch (totalTimeCompOper) {
       case 1:
         builder.andGE("b.total_time",totalTime);
         break;
       case -1:
         builder.andLE("b.total_time",totalTime);
         break;
       case 0:
         builder.andEQ("b.total_time",totalTime);
         break;
    
       default:
         break;
       }
    }
    }

    //if(!StringUtils.isEmpty(completedDate)){
      //builder.andLike("a.name", completedDate);
    //}
    
    
    if(null != completedDateStart_Time)
    {
      builder.andGE("b.completed_date", completedDateStart_Time);
    }
    
    if(null != completedDateEnd_Time)
    {
      builder.andLE("b.completed_date", completedDateEnd_Time);
    }
    
    
    if(null != start_Time)
    {
      builder.andGE("B.CREATE_DATE", start_Time);
    }
    
    if(null != end_Time)
    {
      builder.andLE("B.CREATE_DATE", end_Time);
    }
    
    builder.andEQ("f.record_status", "A");
    
  
    
    Criteria limitCriter = builder.buildCriteria().limit(new Long(pager.getFirst()), new Long(pager.getLast()));
    
    PagingResult<UserActivityDetailsReport> findUserActivitiesByCriteria = userActivityDetailsReportService.findUserActivityDetailsReport(limitCriter);
    pager.setTotalCount(findUserActivitiesByCriteria.getTotalRows());
    pager.setResult(findUserActivitiesByCriteria.getResult());
    request.setAttribute("page", pager);
    return SUCCESS;
    }
    
    
    
    public void export() throws Exception {
      
      CriteriaBuilder builder = Cnd.builder(UserActivityDetailsReport.class);
      
      UserAccount userDetails = SecurityUtils.getCurrentUser();
      
      //通过siteId获得推荐课程的性息
      Long siteId = userDetails.getSiteId();
      
      if(!StringUtils.isEmpty(ativityname)){
        builder.andLike("a.name", ativityname);
      }
      if(!StringUtils.isEmpty(ativitytypte)){
        builder.andLike("a.type", "%" + ativitytypte + "%");
      }
      
      if(null!=coursetypeId){
         List<Long> list = resourceFolderService.findAllChildsCrsCategoryById(coursetypeId);
         builder.andIn("g.object2_id", list);
      }
      
      
      if(!StringUtils.isEmpty(username)){
        builder.andLike("c.full_name", username);
      }
      
      if(null!=orgId){
        List<Long> list = organizationService.finAllChildsOrgById(orgId); 
        builder.andIn("c.organization_id", list);
      }
      
      if(null!=usergroupId){
       
        builder.andEQ("h.user_group_id", usergroupId);
      }
      
      if(!StringUtils.isEmpty(usergroup)){
        builder.andLike("a.name", usergroup);
      }
      
      if(!StringUtils.isEmpty(enrollstatus)){
        builder.andLike("e.stauts", enrollstatus);
      }
      
      if(!StringUtils.isEmpty(studystatus)){
        builder.andLike("b.status", studystatus);
      }
      
      //if(!StringUtils.isEmpty(score)){
        //builder.andLike("a.name", score);
      //}
      
      if(null != score)
      {
           switch (scoreCompOper) {
         case 1:
           builder.andGE("b.score",score);
           break;
         case -1:
           builder.andLT("b.score",score);
           break;
         case 0:
           builder.andEQ("b.score",score);
           break;
      
         default:
           break;
         }
      }
      
      
      if(!StringUtils.isEmpty(totalTimeStr)){ 
        totalTime = TimeUtil.HHMMSSToSec(totalTimeStr);
      if(null != totalTime)
      {
           switch (totalTimeCompOper) {
         case 1:
           builder.andGE("b.total_time",totalTime);
           break;
         case -1:
           builder.andLE("b.total_time",totalTime);
           break;
         case 0:
           builder.andEQ("b.total_time",totalTime);
           break;
      
         default:
           break;
         }
      }
      }

      //if(!StringUtils.isEmpty(completedDate)){
        //builder.andLike("a.name", completedDate);
      //}
      
      
      if(null != completedDateStart_Time)
      {
        builder.andGE("b.completed_date", completedDateStart_Time);
      }
      
      if(null != completedDateEnd_Time)
      {
        builder.andLE("b.completed_date", completedDateEnd_Time);
      }
      
      
      if(null != start_Time)
      {
        builder.andGE("B.CREATE_DATE", start_Time);
      }
      
      if(null != end_Time)
      {
        builder.andLE("B.CREATE_DATE", end_Time);
      }
      
      builder.andEQ("f.record_status", "A");
      
    
      Criteria limitCriter = builder.buildCriteria();
      //Criteria limitCriter = builder.buildCriteria().limit(new Long(pager.getFirst()), new Long(pager.getLast()));
      
      PagingResult<UserActivityDetailsReport> findUserActivitiesByCriteria = userActivityDetailsReportService.findUserActivityDetailsReport(limitCriter);
      
      List<UserActivityDetailsReport> list = findUserActivitiesByCriteria.getResult();
      
//     XMLPublisher<UserActivityDetailsReport> xmlPublisher= new XMLPublisher<UserActivityDetailsReport>();
//     HttpServletResponse response = ServletActionContext.getResponse(); 
//     xmlPublisher.executeDisplaKndXLS("userActivityDetailsReport",list,UserActivityDetailsReport.class, response);
//      
      Site site = siteService.getSite(siteId);
      Exporters.toXLSByXmlPublisherWithDownload(
  			"userActivityDetailsReport",
  			ListUtils.of("ativityname","ativitytypte","coursetype","username","orgname","usergroup","enrollstatus","studystatus","score","totalTimeFomart","completedDate"), 
  			list,
  			SpringUtils.getMessage("rpt.reportFolder_user_courseInfo") + String.format("(%s)",site.getName()));
      

   
      
     
       
      }
    
    

    

    
 
    public String filterDefines() {
        return "aty.userActivityDetailsReportFilterItems";
    }

    

    protected Object getEntityService() {
        return this.userActivityDetailsReportService;
    }





    public Long getActivityid() {
      return activityid;
    }





    public void setActivityid(Long activityid) {
      this.activityid = activityid;
    }





    public Long getCourseid() {
      return courseid;
    }





    public void setCourseid(Long courseid) {
      this.courseid = courseid;
    }





    public String getAtivityname() {
      return ativityname;
    }





    public void setAtivityname(String ativityname) {
      this.ativityname = ativityname;
    }





    public String getAtivitytypte() {
      return ativitytypte;
    }





    public void setAtivitytypte(String ativitytypte) {
      this.ativitytypte = ativitytypte;
    }





    public String getCoursetype() {
      return coursetype;
    }





    public void setCoursetype(String coursetype) {
      this.coursetype = coursetype;
    }





    public Long getUserid() {
      return userid;
    }





    public void setUserid(Long userid) {
      this.userid = userid;
    }





    public String getUsername() {
      return username;
    }





    public void setUsername(String username) {
      this.username = username;
    }





    public String getOrgname() {
      return orgname;
    }





    public void setOrgname(String orgname) {
      this.orgname = orgname;
    }





    public String getUsergroup() {
      return usergroup;
    }





    public void setUsergroup(String usergroup) {
      this.usergroup = usergroup;
    }





    public String getEnrollstatus() {
      return enrollstatus;
    }





    public void setEnrollstatus(String enrollstatus) {
      this.enrollstatus = enrollstatus;
    }





    public String getStudystatus() {
      return studystatus;
    }





    public void setStudystatus(String studystatus) {
      this.studystatus = studystatus;
    }










    public Float getScore() {
      return score;
    }





    public void setScore(Float score) {
      this.score = score;
    }





    public Long getTotalTime() {
      return totalTime;
    }





    public void setTotalTime(Long totalTime) {
      this.totalTime = totalTime;
    }





    public Long getOrgId() {
      return orgId;
    }





    public void setOrgId(Long orgId) {
      this.orgId = orgId;
    }









    public Long getUsergroupId() {
      return usergroupId;
    }





    public void setUsergroupId(Long usergroupId) {
      this.usergroupId = usergroupId;
    }





    public Long getCoursetypeId() {
      return coursetypeId;
    }





    public void setCoursetypeId(Long coursetypeId) {
      this.coursetypeId = coursetypeId;
    }





    public int getScoreCompOper() {
      return scoreCompOper;
    }





    public void setScoreCompOper(int scoreCompOper) {
      this.scoreCompOper = scoreCompOper;
    }





    public int getTotalTimeCompOper() {
      return totalTimeCompOper;
    }





    public void setTotalTimeCompOper(int totalTimeCompOper) {
      this.totalTimeCompOper = totalTimeCompOper;
    }





    public Date getCompletedDateStart_Time() {
      return completedDateStart_Time;
    }





    public void setCompletedDateStart_Time(Date completedDateStart_Time) {
      this.completedDateStart_Time = completedDateStart_Time;
    }





    public Date getCompletedDateEnd_Time() {
      return completedDateEnd_Time;
    }





    public void setCompletedDateEnd_Time(Date completedDateEnd_Time) {
      this.completedDateEnd_Time = completedDateEnd_Time;
    }





    public Date getEnd_Time() {
      return end_Time;
    }





    public void setEnd_Time(Date end_Time) {
      this.end_Time = end_Time;
    }





    public Date getStart_Time() {
      return start_Time;
    }





    public void setStart_Time(Date start_Time) {
      this.start_Time = start_Time;
    }





    public String getTotalTimeStr() {
      return totalTimeStr;
    }





    public void setTotalTimeStr(String totalTimeStr) {
      this.totalTimeStr = totalTimeStr;
    }



	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}



	public Long getSiteId() {
		return siteId;
	}




    
}