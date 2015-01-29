package com.kingnod.etraining.course.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.dao.AttempDAO;
import com.kingnod.etraining.course.dao.ContentServerDAO;
import com.kingnod.etraining.course.dao.CourseInfoDAO;
import com.kingnod.etraining.course.dao.ItemInfoDAO;
import com.kingnod.etraining.course.dao.SCOPerformanceDAO;
import com.kingnod.etraining.course.entity.Attemp;
import com.kingnod.etraining.course.entity.ContentServer;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.entity.SCOPerformance;
import com.kingnod.etraining.course.server.models.AtyCourseInfo;
import com.kingnod.etraining.course.server.models.FindAtyCourse;
import com.kingnod.etraining.course.service.ItemInfoService;
import com.kingnod.etraining.course.service.PerformanceService;
import com.kingnod.etraining.course.service.SCOPerformanceService;
import com.kingnod.etraining.course.utils.AbbreviateUtil;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.security.entity.UserAccount;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class SCOPerformanceServiceImpl implements SCOPerformanceService {

    @Autowired
    protected SCOPerformanceDAO sCOPerformanceDAO;

    @Autowired
    protected AttempDAO  attempDAO;
    
    @Autowired
    protected CourseInfoDAO courseInfoDAO;
    
    @Autowired
    protected ContentServerDAO contentServerDAO;
    
    @Autowired
    protected ItemInfoService itemInfoService;
    
    @Autowired
    PerformanceService performanceService;
    
    @Autowired
	FindAtyCourse findAtyCourse;

    public SCOPerformance getSCOPerformance(Long id) {
        return sCOPerformanceDAO.get(id);
    }

    public int saveSCOPerformance(SCOPerformance sCOPerformance) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)sCOPerformance;
        if(null != idEntity.getId() && null != sCOPerformanceDAO.get(idEntity.getId())){
            count = sCOPerformanceDAO.update(sCOPerformance);
        }else{
            count = sCOPerformanceDAO.insert(sCOPerformance);
        }
        return count;
    }

    public int deleteSCOPerformance(SCOPerformance sCOPerformance) {
        return sCOPerformanceDAO.delete(sCOPerformance);
    }

    public int deleteSCOPerformanceByIds(Long[] ids) {
        return sCOPerformanceDAO.deleteById(ids);
    }

    public PagingResult<SCOPerformance> findSCOPerformance(Criteria criteria) {
        return sCOPerformanceDAO.findPagingResult(criteria);
    }
    
  //初始化时调用
    public int initSCOPerformance(Long courseId, Long scoId,Long userId){
      
      int count = 0;
      SCOPerformance scoPerformance =new SCOPerformance();
      scoPerformance.setUserId(userId);
      scoPerformance.setCourseId(courseId);
      scoPerformance.setScoId(scoId);
     
       scoPerformance.setStatus(AbbreviateUtil.abbreviateStatus("incomplete"));
       scoPerformance.setCompletedTotalTime(CourseConstant.DEFAULT_TIME);
      scoPerformance.setExitMode("");
      scoPerformance.setEntryStatus(AbbreviateUtil.abbreviateEntry("ab-initio"));
      scoPerformance.setScore(CourseConstant.DEFAULT_SCORE);
      scoPerformance.setTotalTime(CourseConstant.DEFAULT_TIME);
      scoPerformance.setCredit(AbbreviateUtil.abbreviateCredit("credit"));
      scoPerformance.setLessonLocation("");
      
      
      CriteriaBuilder cb = Cnd.builder(Site.class);
      cb.andEQ("A.COURSE_ID",courseId).andEQ("A.SCO_ID",scoId).andEQ("A.USER_ID",userId);
      
      List<SCOPerformance> sCOPList = sCOPerformanceDAO.findByCriteria(cb.buildCriteria());
      
      if(sCOPList.size()<1){
        count = sCOPerformanceDAO.insert(scoPerformance);
      }
       
     return count;
     
    }
    
    
  //完成时调用
    public int finishSCOPerformance(Long courseId, Long scoId,Long userId){
      int count = 0;
      Long totalTimeLong=0l;
      
      BigDecimal  masteryScore=null;
      String status="";
      String latestStatus ="";
      
      
      CriteriaBuilder cb=Cnd.builder();
      cb.andEQ("A.USER_ID",userId);
      cb.andEQ("A.COURSE_ID",courseId);
      cb.andEQ("A.SCO_ID",scoId);
      
     
      

       //String totalTime = "1212";//sCOPerformanceDAO.queryTotalTime(courseId,scoId,userId);
      // Long totalTimeLong = Long.parseLong(totalTime);

       SCOPerformance scoPerformance =new SCOPerformance();
       scoPerformance.setUserId(userId);
       scoPerformance.setCourseId(courseId);
       scoPerformance.setScoId(scoId);
       
       UserAccount userDetails = SecurityUtils.getCurrentUser();
       Long attempId = (Long)userDetails.getAttribute("attempId");
       Attemp attemp =   attempDAO.get(attempId);
       
       scoPerformance.setExitMode(attemp.getExitMode());
       scoPerformance.setEntryStatus(attemp.getEntryStatus());
       scoPerformance.setScore(attemp.getRawScore());//遗留 去最高分还是最新的
       scoPerformance.setLessonLocation(attemp.getLessonLocation());
       
       List<SCOPerformance> scoPerformanceList = sCOPerformanceDAO.findByCriteria(cb.buildCriteria());
       
       if(scoPerformanceList.size()>0){
         SCOPerformance scoPerformanceLast =scoPerformanceList.get(0);
         latestStatus =scoPerformanceLast.getStatus();
         totalTimeLong = scoPerformanceLast.getTotalTime();
         scoPerformance.setId(scoPerformanceLast.getId());

         ItemInfo itemInfo = itemInfoService.getItemInfo(scoPerformanceLast.getId());
         if(itemInfo!=null){
           masteryScore = itemInfo.getMasteryScore();
         }
       }
       
       if(CourseConstant.DEFAULT_TIME==totalTimeLong){
         totalTimeLong=0l;
       }
       
       scoPerformance.setTotalTime(attemp.getSessionTime()+totalTimeLong);
       
      
      
        //根据条件计算Status是否为pass
       
       //1.获取sco的credit的值，由于目前不记录browsed状态，所以这个默认都是credit
       
       
       //2.1获取sco的mastery score的值
       
       
       
       //3获取score的值
       //如果是通过或者完成就不更改
       if(!"P".equals(latestStatus)&&!"C".equals(latestStatus)){
       status =attemp.getRawStatus();
         
       BigDecimal score = attemp.getRawScore();
       if(masteryScore!=null&&score!=null){
          if(score.doubleValue()>masteryScore.doubleValue()){
            status="P";
          }else{
            status="F";
          }
       }
       
       //改变状态
       scoPerformance.setStatus(status);
       }
       
       //2.2获取lesson modl的值,暂不处理
       
       
       count = sCOPerformanceDAO.update(scoPerformance);
     
      return count;
    }
    
    public List<TreeNode> getSCOTreeList(Long courseId, Long scoId,Long userId){
      
      List<TreeNode> scoTreeList = new ArrayList<TreeNode>(); 
     
      List<SCOPerformance> sCOPList = null;
      List<ItemInfo> itemList = null;
      /*  
      CriteriaBuilder cbSco=Cnd.builder();
      cbSco.andEQ("B.COURSE_ID",courseId);
      cbSco.andGroup(Cnd.builder().andEQ("A.USER_ID", userId));
      cbSco.orderBy("B.ID", Order.ASC);*///以后改为按排序字段排
      CriteriaBuilder cbSco = Cnd.builder(SCOPerformance.class);
      cbSco.andEQ("courseId",courseId);
      cbSco.andEQ("userId",userId);
      
      sCOPList = sCOPerformanceDAO.findByCriteria(cbSco.buildCriteria());
      itemList = itemInfoService.getItemInfoList(courseId);
       for(ItemInfo item:itemList){
         Long scoIdL = item.getId();
         SCOPerformance performance = getCurrentSCOPerformance(sCOPList,scoIdL);
         String status = "N";
         if(performance!=null){
          status = performance.getStatus(); //sco.getStatus();
         }
         String launch = item.getLaunch();
         String title = item.getItemTitle();
         
         TreeNode treeNode= new TreeNode(scoIdL+"",title,false);
         treeNode.setParentId(item.getItemParent()+"");
         if(StringUtils.isNotEmpty(launch)){//目前判断父节点也是根据这个来判断,有问题后面再优化
            treeNode.setSrc(getScoFullURL(courseId,launch,item.getScoType(),scoIdL));
            treeNode.setOpenMode(CommonConstant.WINDOW_OPEN_MODE_TARGET);
            treeNode.setTarget("LMSSCO");
            treeNode.setClick(true);
         }else{
           treeNode.setClick(false);
           //获取父节点状态
           CriteriaBuilder cbTot = Cnd.builder(ItemInfo.class);
           cbTot.andEQ("courseId",courseId);
           cbTot.andIsNotNull("launch");
           int scoTotalCount= itemInfoService.countByCriteria(cbTot.buildCriteria());
           
           CriteriaBuilder cb = Cnd.builder(SCOPerformance.class);
           cb.andEQ("courseId",courseId).andEQ("userId",userId);
           cb.andGroup(Cnd.builder().andEQ("status", AbbreviateUtil.abbreviateStatus("completed")).orEQ("A.STATUS", AbbreviateUtil.abbreviateStatus("passed")));
           int finshedSCO = sCOPerformanceDAO.countByCriteria(cb.buildCriteria());
           
           if(finshedSCO==0){
             status="N";
           }else if(finshedSCO==scoTotalCount){
             status="C";
           }else{
             status="I";
           }
         }
         
         treeNode.setIcon("../img/scorm/"+getIconByStatus(AbbreviateUtil.expandStatus(status)));
         treeNode.setOpen(true);
         scoTreeList.add(treeNode);
       }
     
      
      return scoTreeList;
    }
    
    private SCOPerformance getCurrentSCOPerformance(List<SCOPerformance> scoPList,Long scoId){
      SCOPerformance  scoPerformance=null;
      for(SCOPerformance  performance:scoPList){
        if(performance.getScoId().equals(scoId)){
          scoPerformance =performance;
        }
        }
      return scoPerformance;
    }
    
    public String getScoFullURL(Long courseId,String scoUrl){
      String fullURL="";
      
      Long  contentServerId=0l;
      String rootPath="";
      String location="";
      
      
      if(courseId!=null&&courseId!=0){
        CourseInfo courseInfo = courseInfoDAO.get(courseId);
         location= courseInfo.getLocation();
         location =location.replace("\\", "/");
        
        contentServerId = courseInfo.getContentServerId();
      }
      
      if(courseId!=null&&courseId!=0){
        ContentServer contentServer = contentServerDAO.get(contentServerId);
         rootPath = contentServer.getRootPath();
      }
      return rootPath + location+"/"+scoUrl;
    }
    /**
     * 
     * @param courseId
     * @param scoUrl
     * @param scoType
     * @return
     * 增加冲在 getScoFullURL方法，主要为了实现非标准可见路径问题
     */
    public String getScoFullURL(Long courseId,String scoUrl,String scoType,Long scoIdL){
    	
    	String fullURL="";
    	
    	Long  contentServerId=0l;
    	String rootPath="";
    	String location="";
    	if(courseId!=null&&courseId!=0){
    		CourseInfo courseInfo = courseInfoDAO.get(courseId);
    		location= courseInfo.getLocation();
    		location =location.replace("\\", "/");
    		contentServerId = courseInfo.getContentServerId();
    		
    		if(courseInfo!=null && "F".equals(courseInfo.getType())){
    			 if(scoType!= null && !"".equals(scoType)){
				    if(".flv".equalsIgnoreCase(scoType) || ".f4v".equalsIgnoreCase(scoType) ){
	    	    		
	    	    		return fullURL = ServletActionContext.getRequest().getContextPath()+"/crs/player!videoPlay.action?courseId="+courseId+"&scoId="+scoIdL; 
	    	    	}
	    	    	if(".pdf".equalsIgnoreCase(scoType) || ".swf".equalsIgnoreCase(scoType) ){
	    	    		
	    	    		return fullURL = ServletActionContext.getRequest().getContextPath()+"/crs/player!paperPlay.action?courseId="+courseId+"&scoId="+scoIdL; 
	    	    	}
	    	    	return fullURL = ServletActionContext.getRequest().getContextPath()+"/crs/player!otherPlay.action?courseId="+courseId+"&scoId="+scoIdL;
	    			
    			 }
    			 else{
    				return fullURL = ServletActionContext.getRequest().getContextPath()+"/crs/player!upkPlay.action?courseId="+courseId+"&scoId="+scoIdL;
						
    			 }
        	}
    	}
    	
    	if(courseId!=null&&courseId!=0){
    		ContentServer contentServer = contentServerDAO.get(contentServerId);
    		rootPath = contentServer.getRootPath();
    	}
    	return rootPath + location+"/"+scoUrl;
    }
    private String getIconByStatus(String status){
      if ("passed".equals(status)) {
        return "player_status_p.png";
      } else if ("completed".equals(status)) {
        return "player_status_c.png";
      } else if ("incomplete".equals(status)) {
        return "player_status_i.png";
      } else if ("failed".equals(status)) {
        return "player_status_f.png";
      } else if ("browsed".equals(status)) {
        return "player_status_c.png"; //浏览也是完成
      } else if ("not attempted".equals(status)) {
        return "player_status_n.png";
      } else {
        return "player_status_n.png";
      }
      
    }
    
  //获取一个章节SCO
    public String getOneSCOLaunch(Long courseId,Long scoId){
      String scoLaunch="";
      ItemInfo itemInfo =itemInfoService.getItemInfo(scoId);
      String launch =itemInfo.getLaunch();
      if(StringUtils.isNotBlank(launch)){
        scoLaunch = getScoFullURL(courseId,launch);
      }
      
      return scoLaunch;
    }
    
    
    //前台显示SCO的树结构
    public List<TreeNode> getItemTreeList(Long acivityId,Long courseId,Long userId){
        List<TreeNode> scoTreeList = new ArrayList<TreeNode>(); 
        List<SCOPerformance> sCOPList = null;
        List<ItemInfo> itemList = null;
        sCOPList = getSCOPerformanceList(courseId,userId);
        ItemInfo launchSCO = performanceService.getLaunchSCO(courseId,userId);
         itemList = itemInfoService.getItemInfoList(courseId);
         for(ItemInfo item:itemList){
           Long scoIdL = item.getId();
           SCOPerformance performance = getCurrentSCOPerformance(sCOPList,scoIdL);
           String status ="";
           Long seconds = -1L;
           if(performance!=null){
            status = performance.getStatus(); //sco.getStatus();
            seconds = performance.getTotalTime();
           }else{
        	   getItemStatus(status, seconds, item, itemList, sCOPList);
           }
           if(status.equals("")){
        	   status = CourseConstant.COURSESTATUS_NOTATTEMPTED;
           }
           String statusMsg =getStatusMsg(status);
           String launch = item.getLaunch();
           
           
           boolean isObligatory = false;
     	  boolean isStatus = false;
     	  boolean isLook =false;
     	 boolean availabilityDate = true;
     	  AtyCourseInfo atyCourseInfo = new AtyCourseInfo();
     	  EnrollLearner enrollLearner = findAtyCourse.getEnrollLearner(acivityId,(UserAccount)SecurityUtils.getCurrentUser());
     	  if(null != enrollLearner){
          isLook =true;
     	  isObligatory = enrollLearner.getEnrollMode().equals(ActivityConstant.ENROLL_MOLEL_F);
     	  isStatus = enrollLearner.getStauts().equals(ActivityConstant.ENROLL_STATUS_R);
     	 Period period =  SpringUtils.getBean(PeriodService.class).getPeriodByFlagId(enrollLearner.getActivityId(),enrollLearner.getActivityType());
     	 availabilityDate = SpringUtils.getBean(PeriodService.class).availabilityDate(period);
     	  }
           String title = "";
           if(isLook&&(isObligatory||isStatus)&&availabilityDate){
           //String onclickStr="javascript:window.open(&quot;/learner-web/learns/../crs/player.action?acivityId=238&amp;courseId=159&quot;,&quot;newwindow&quot; , &quot;toolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=notoolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=no&quot;);return false;";
           String onclickStr="javascript:window.open('../crs/player.action?acivityId="+acivityId+"&courseId="+courseId+"&scoId="+scoIdL+"','newwindow','toolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=notoolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=no');return false;";
           if(null != launchSCO && item.getId() == launchSCO.getId()){
           title = "<div bgcolor='#6988AA'><a href=\"###\" onclick=\""+onclickStr+"\"><img src=\"../images/Broadcast-Yes.png\"></a>".concat(item.getItemTitle()==null?"":item.getItemTitle())
           				  .concat("<font color=\"#00B366\">[").concat(statusMsg).concat(" | ")
           				  .concat(com.kingnod.etraining.course.utils.TimeUtil.secToHHMMSS(seconds))
           				  .concat("]</font></div>");
           }else{
        	   title = "<a href=\"###\" onclick=\""+onclickStr+"\"><img src='../images/Broadcast-Yes.png'></a>".concat(item.getItemTitle()==null?"":item.getItemTitle())
				  .concat("<font color=\"#836FFF\">[").concat(statusMsg).concat(" | ")
				  .concat(com.kingnod.etraining.course.utils.TimeUtil.secToHHMMSS(seconds))
				  .concat("]</font>");
           }
           }else{
        	   title = "<a href=\"###\"><img src='../images/Broadcast-No.png'></a>".concat(item.getItemTitle()==null?"":item.getItemTitle())
				  .concat("<font color=\"#836FFF\">[").concat(statusMsg).concat(" | ")
				  .concat(com.kingnod.etraining.course.utils.TimeUtil.secToHHMMSS(seconds))
				  .concat("]</font>");
           }
           TreeNode treeNode= new TreeNode(scoIdL+"",title,false);
           treeNode.setParentId(item.getItemParent()+"");
           if(StringUtils.isNotEmpty(launch)){//目前判断父节点也是根据这个来判断,有问题后面再优化
//              treeNode.setSrc(getScoFullURL(courseId,launch));
//              treeNode.setOpenMode(CommonConstant.WINDOW_OPEN_MODE_TARGET);
              treeNode.setTarget("LMSSCO");
              treeNode.setClick(false);
           }else{
             treeNode.setClick(false);
             //获取父节点状态
             CriteriaBuilder cbTot = Cnd.builder(ItemInfo.class);
             cbTot.andEQ("courseId",courseId);
             cbTot.andIsNotNull("launch");
             int scoTotalCount= itemInfoService.countByCriteria(cbTot.buildCriteria());
             CriteriaBuilder cb = Cnd.builder(SCOPerformance.class);
             cb.andEQ("courseId",courseId).andEQ("userId",userId);
             cb.andGroup(Cnd.builder().andEQ("status", AbbreviateUtil.abbreviateStatus("completed")).orEQ("A.STATUS", AbbreviateUtil.abbreviateStatus("passed")));
             int finshedSCO = sCOPerformanceDAO.countByCriteria(cb.buildCriteria());
             
             if(finshedSCO==0){
               status=CourseConstant.COURSESTATUS_NOTATTEMPTED;
             }else if(finshedSCO==scoTotalCount){
               status=CourseConstant.COURSESTATUS_COMPLETED;
             }else{
               status=CourseConstant.COURSESTATUS_INCOMPLETE;
             }
           }
           
           treeNode.setIcon("../img/scorm/"+getIconByStatus(AbbreviateUtil.expandStatus(status)));
           treeNode.setOpen(true);
           scoTreeList.add(treeNode);
         }
 
         
        return scoTreeList;
      }
    
    public List<SCOPerformance> getSCOPerformanceList(Long courseId,Long userId){
	    CriteriaBuilder cbSco = Cnd.builder(SCOPerformance.class);
	    cbSco.andEQ("courseId",courseId);
	    cbSco.andEQ("userId",userId);
	    return sCOPerformanceDAO.findByCriteria(cbSco.buildCriteria());
    }
    
    public void getItemStatus(String status,Long seconds,ItemInfo item,List<ItemInfo> itemList,List<SCOPerformance> sCOPList){

 	   for(ItemInfo iteminfo : itemList){
 		   if(iteminfo.getItemParent() != null && iteminfo.getItemParent().equals(item.getId())){
 			   SCOPerformance itemPerformance = getCurrentSCOPerformance(sCOPList,iteminfo.getId());
 			   if(null != itemPerformance){
 			   if((itemPerformance.getStatus().equals(CourseConstant.COURSESTATUS_COMPLETED)
 					   || itemPerformance.getStatus().equals(CourseConstant.COURSESTATUS_PASSED))
 				   &&(status.equals("") 
 						   ||  status.equals(CourseConstant.COURSESTATUS_COMPLETED))){
 				   status = CourseConstant.COURSESTATUS_COMPLETED;
 			   }else if((itemPerformance.getStatus().equals(CourseConstant.COURSESTATUS_INCOMPLETE)
 					   ||itemPerformance.getStatus().equals(CourseConstant.COURSESTATUS_FAILED)) && status == ""){
 				   status = CourseConstant.COURSESTATUS_INCOMPLETE;
 			   }else if(itemPerformance.getStatus().equals(CourseConstant.COURSESTATUS_NOTATTEMPTED)
 					   && (status.equals("") || status.equals(CourseConstant.COURSESTATUS_NOTATTEMPTED))){
 				   status = CourseConstant.COURSESTATUS_NOTATTEMPTED;
 			   }else{
 				   status = CourseConstant.COURSESTATUS_INCOMPLETE;
 			   }
 			   seconds +=  itemPerformance.getTotalTime();
 			   }else{
 				   status = CourseConstant.COURSESTATUS_INCOMPLETE;
 			   }
 			  
 		   }
 	   }
    
    }
    
    public String getStatusMsg(String status){
    	String statusMsg = "";
        if(status.equals(CourseConstant.COURSESTATUS_NOTATTEMPTED)){
     	   statusMsg = SpringUtils.getMessage("crs.courseStatus_notAttempted", null);
        } else if(status.equals(CourseConstant.COURSESTATUS_COMPLETED)){
     	   statusMsg = SpringUtils.getMessage("crs.courseStatus_completed", null);
        }else if(status.equals(CourseConstant.COURSESTATUS_INCOMPLETE)){
     	   statusMsg = SpringUtils.getMessage("crs.courseStatus_incomplete", null);
        } else if(status.equals(CourseConstant.COURSESTATUS_PASSED)){
     	   statusMsg = SpringUtils.getMessage("crs.courseStatus_passed", null);
        } else if(status.equals(CourseConstant.COURSESTATUS_FAILED)){
     	   statusMsg = SpringUtils.getMessage("crs.courseStatus_failed", null);
        }else if(status.equals(CourseConstant.COURSESTATUS_BROWSED)){
     	   statusMsg = SpringUtils.getMessage("crs.courseStatus_browsed", null);
        }
        return statusMsg;
    }
}