package com.kingnod.etraining.course.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.entity.SCOPerformance;
import com.kingnod.etraining.course.service.PerformanceService;
import com.kingnod.etraining.course.service.SCOPerformanceService;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.ActionSupport;

@org.springframework.stereotype.Controller
@org.apache.struts2.convention.annotation.Namespace("/crs")
@Results({ @Result(name = "player-courser", location = "/WEB-INF/content/crs/course-player.jsp", type = "dispatcher") ,
		   @Result(name = "paper-courser", location = "/WEB-INF/content/crs/course-paper.jsp", type = "dispatcher"), 
		   @Result(name = "upk-courser", location = "/WEB-INF/content/crs/course-upk.jsp", type = "dispatcher"), 
           @Result(name = "other-courser", location = "/WEB-INF/content/crs/course-other.jsp", type = "dispatcher") }
         )
public class PlayerAction extends ActionSupport {

	@Autowired
	private SCOPerformanceService	scoPerformanceService;

	@Autowired
	private PerformanceService		performanceService;

	private String					courseName	= "";

	private String					courseId;

	private String					scoId;

	private String					acivityId;

	private String					lessonMode;

	private String					initSCOUrl;

	private String					showOutlineModel;
	
	private String         windowWidth;
	
	private String         windowHeight;

	// 是否打开调试窗口 Y打开 N关闭
	private String					debug		= "N";

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public String getShowOutlineModel() {
		return showOutlineModel;
	}

	public void setShowOutlineModel(String showOutlineModel) {
		this.showOutlineModel = showOutlineModel;
	}

	public String getInitSCOUrl() {
		return initSCOUrl;
	}

	public void setInitSCOUrl(String initSCOUrl) {
		this.initSCOUrl = initSCOUrl;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getScoId() {
		return scoId;
	}

	public void setScoId(String scoId) {
		this.scoId = scoId;
	}

	public String getAcivityId() {
		return acivityId;
	}

	public void setAcivityId(String acivityId) {
		this.acivityId = acivityId;
	}

	public String getLessonMode() {
		return lessonMode;
	}

	public void setLessonMode(String lessonMode) {
		this.lessonMode = lessonMode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String execute() {

		Long courseIdL = null;
		Long acivityIdL = null;
		String scoLaunch = "";
		CourseInfo courseInfo =null ;
		if (StringUtils.isNotBlank(courseId)) {
			courseIdL = Long.valueOf(courseId);
			courseInfo = performanceService.getCourseInfoById(courseIdL);
		}/*
		 * else{ //根据acivityId查询courseId
		 * 
		 * 
		 * courseIdL = courseInfoService.findCourseIdByAcivityId(acivityIdL); }
		 */
		if (StringUtils.isNotBlank(acivityId)) {
			acivityIdL = Long.valueOf(acivityId);
		}

		if (scoId != null && !"".equals(scoId) && courseInfo!=null && StringUtils.isNotEmpty(courseInfo.getType()) && !"F".equals(courseInfo.getType())) {// 如果不为空查询此scourl

			Long scoIdL = null;

			if (StringUtils.isNotBlank(scoId)) {
				scoIdL = Long.valueOf(scoId);
			}

			// 调用item模块查询
			scoLaunch = scoPerformanceService.getOneSCOLaunch(courseIdL, scoIdL);
			setInitSCOUrl(scoLaunch);

		}
		else {
			// 得到启动的章节和地址
			UserAccount userDetails = SecurityUtils.getCurrentUser();
			Long userId = null != userDetails.getId() ? userDetails.getId() : 0L;

			ItemInfo itemInfo = performanceService.getLaunchSCO(courseIdL, userId);
			
             
			Long scoId = 0l;
			if (itemInfo != null) {
				scoLaunch = itemInfo.getLaunch();
				scoId = itemInfo.getId();
				setScoId(scoId + "");
				
				/* update by maxudong 根据数据库存储信息判定，ScoType为空时为标准课件，反之为非标准课件 */
				//为非标准课件时处理
				
				  //if(!StringUtils.isEmpty(itemInfo.getScoType()) &&!"sco".equals(itemInfo.getScoType())){
					if(courseInfo!=null && StringUtils.isNotEmpty(courseInfo.getType()) && "F".equals(courseInfo.getType())){
					 boolean flagType =true ;
					 
					 if(itemInfo.getScoType()!= null && !"".equals(itemInfo.getScoType())){
							if(".flv".equalsIgnoreCase(itemInfo.getScoType()) || ".f4v".equalsIgnoreCase(itemInfo.getScoType()) ){
								scoLaunch = ServletActionContext.getRequest().getContextPath()+"/crs/player!videoPlay.action?courseId="+courseId+"&scoId="+scoId; 
								flagType =false;
							}		
							if(".swf".equalsIgnoreCase(itemInfo.getScoType()) || ".pdf".equalsIgnoreCase(itemInfo.getScoType()) ){
								scoLaunch = ServletActionContext.getRequest().getContextPath()+"/crs/player!paperPlay.action?courseId="+courseId+"&scoId="+scoId;
								flagType =false;
							}
							if(flagType){
								scoLaunch = ServletActionContext.getRequest().getContextPath()+"/crs/player!otherPlay.action?courseId="+courseId+"&scoId="+scoId; 
							}
					 }
					 else{
							scoLaunch = ServletActionContext.getRequest().getContextPath()+"/crs/player!upkPlay.action?courseId="+courseId+"&scoId="+scoId;
					 
					 }
				
				}
				//标准课件时处理
				else{
					if (StringUtils.isNotBlank(scoLaunch)) {
						scoLaunch = scoPerformanceService.getScoFullURL(courseIdL, scoLaunch);
					}
				}
					
			}
		}

		String height="";
		String width="";
		if (courseInfo != null) {
			setShowOutlineModel(courseInfo.getControl() + "");
			setCourseName(courseInfo.getCourseTitle());
			if(null!=courseInfo.getWindowHeight()){
			  width = courseInfo.getWindowHeight()+"";
			}
			if(null!=courseInfo.getWindowWidth()){
			  height = courseInfo.getWindowWidth()+"";
			}
		}
	   setWindowHeight(height);
       setWindowWidth(width);
	   setInitSCOUrl(scoLaunch);

		// 增加在线人数
		performanceService.addOnlineCount(acivityIdL);

		return SUCCESS;
	}
	
	//视频类相关播放
	public String upkPlay() {
		Long scoIdL;
		Long courseIdL;
		if (StringUtils.isNotBlank(scoId) && StringUtils.isNotBlank(courseId)) {
			scoIdL = Long.valueOf(scoId);
			courseIdL = Long.valueOf(courseId);
			upkUrl = scoPerformanceService.getOneSCOLaunch(courseIdL, scoIdL);
		}
		return "upk-courser";
	}
	//视频类相关播放
	public String videoPlay() {
		Long scoIdL;
		Long courseIdL;
		if (StringUtils.isNotBlank(scoId) && StringUtils.isNotBlank(courseId)) {
			scoIdL = Long.valueOf(scoId);
			courseIdL = Long.valueOf(courseId);
			flvUrl = scoPerformanceService.getOneSCOLaunch(courseIdL, scoIdL);
		}
		return "player-courser";
	}
   /**
    * @author maxudong
    * 文本类相关播放
    * @return
    */
	public String paperPlay() {
		Long scoIdL;
		Long courseIdL;
		if (StringUtils.isNotBlank(scoId) && StringUtils.isNotBlank(courseId)) {
			scoIdL = Long.valueOf(scoId);
			courseIdL = Long.valueOf(courseId);
			flvUrl = scoPerformanceService.getOneSCOLaunch(courseIdL, scoIdL);
			if(flvUrl !=null&&flvUrl.endsWith(".pdf") ){
				flvUrl = flvUrl.replace(".pdf", ".swf");
			}
		}
		return "paper-courser";
	}
	
   /**
    * 	@author maxudong
    *   word/excel/txt/zip等文件播放
    * 
    */
	public String otherPlay(){
		
		Long scoIdL;
		Long courseIdL;
		if (StringUtils.isNotBlank(scoId) && StringUtils.isNotBlank(courseId)) {
			scoIdL = Long.valueOf(scoId);
			courseIdL = Long.valueOf(courseId);
		}
		//getResources();
		return "other-courser";
		
	}
	/**
	 * 读取文件主要入口
	 * 
	 * @param response
	 * @param outoutFile
	 *  返回非标准课件,非标准课件临时处理
	 */
	public String  getResources() {
		Long scoIdL;
		Long courseIdL;
		String flieName="";
		if (StringUtils.isNotBlank(scoId) && StringUtils.isNotBlank(courseId)) {
			scoIdL = Long.valueOf(scoId);
			courseIdL = Long.valueOf(courseId);
			flvUrl = scoPerformanceService.getOneSCOLaunch(courseIdL, scoIdL);
			if(!StringUtils.isEmpty(flvUrl)){
				flieName = flvUrl.substring(flvUrl.lastIndexOf("/")+1);
			}
		}
		try {
			
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			OutputStream fos = null;
			InputStream fis = null;
			HttpServletResponse response = ServletActionContext.getResponse();
			try {
				// 设置文件头缓存信息
				response.setContentType("; charset=UTF-8");
		        response.setHeader("Content-disposition","attachment;filename="+flieName);

				// 通过文件路径获取文件流
				URL   url   =   new   URL(flvUrl); 
				fis   =   url.openStream(); 
				if (fis == null)
					return "";
				bis = new BufferedInputStream(fis);
				fos = response.getOutputStream();
				bos = new BufferedOutputStream(fos);
				
				int bytesRead = 0;
				byte[] buffer = new byte[5 * 1024];
				while ((bytesRead = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
				}
				bos.close();
				bis.close();
				fos.close();
				fis.close();

			} catch (IOException e) {
				response.reset();
			} finally {
				try {
					if (fos != null) {
						fos.close();
						fos = null;
					}
					if (bos != null) {
						bos.close();
						bos = null;
					}
					if (fis != null) {
						fis.close();
						fis = null;
					}
					if (bis != null) {
						bis.close();
						bis = null;
					}
				} catch (IOException e) {

					System.err.print(e);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
            return null;
	}

	
	
	private String	flvUrl;
	private String	upkUrl;

	public String getFlvUrl() {
		return flvUrl;
	}

	public void setFlvUrl(String flvUrl) {
		this.flvUrl = flvUrl;
	}

	
  public String getUpkUrl() {
		return upkUrl;
	}

	public void setUpkUrl(String upkUrl) {
		this.upkUrl = upkUrl;
	}

public String getWindowWidth() {
    return windowWidth;
  }

  public void setWindowWidth(String windowWidth) {
    this.windowWidth = windowWidth;
  }

  public String getWindowHeight() {
    return windowHeight;
  }

  public void setWindowHeight(String windowHeight) {
    this.windowHeight = windowHeight;
  }

	
}
