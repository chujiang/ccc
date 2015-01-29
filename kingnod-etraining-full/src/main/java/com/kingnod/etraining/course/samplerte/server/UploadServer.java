package com.kingnod.etraining.course.samplerte.server;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aspectj.util.FileUtil;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.control.ControlStation;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.server.models.FolderNode;
import com.kingnod.etraining.course.service.CourseInfoService;
import com.kingnod.etraining.course.service.ItemInfoService;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class UploadServer {

	public static boolean openContentPackage(File file, File theFolder,String folder,Long folderId,Long contentServerId)
			throws Exception {
		Logger log = LoggerFactory.getLogger(UploadServer.class);
		boolean parseManifest = false;
		if (!ControlStation.getSharedInstance()
				.isValidManifest(file, theFolder)) {
			log.error("************************[请确定文件"+file.getName()+"是不是标准的Scorm课件]**********************************");
			throw Exceptions.createAppException("crs001015",new String[]{file.getName()});
		} else {
			
			if (ControlStation.getSharedInstance().isZip(file)) {
				// Unzip to project folder...
				ControlStation.getSharedInstance().unpackZip(file, theFolder);
				File maniFile = new File(
						theFolder,
						com.kingnod.etraining.course.contentpackage.CP_Core.MANIFEST_NAME);
				if (!maniFile.exists()) {
					throw Exceptions.createAppException("crs001004");
				}
				/*用xsd验证xml有问题，暂时不用，待解决。*/
//				ControlStation.getSharedInstance().setupValidateAgainstSchema(maniFile, xsdFiles);
				parseManifest = ControlStation.getSharedInstance()
						.parseManifest(file,maniFile,folder,folderId,contentServerId);

			} else {
				log.error("************************[请确定文件  "+ file.getName() +"  是标准的Scorm课件]**********************************");
				throw Exceptions.createAppException("crs001015",new String[]{file.getName()});
			}
		}

		return parseManifest;
	}

	public static boolean saveItem(Long courseId,String itemName,String scoType,
			String launch, ItemInfoService itemService) throws Exception {
		ItemInfo itemInfo = new ItemInfo();
		itemInfo.setCourseId(courseId);
		itemInfo.setChildLevel(1L);
		itemInfo.setItemTitle(itemName);
		itemInfo.setLaunch(launch);
		itemInfo.setScoType(scoType);
		itemService.saveItemInfo(itemInfo);
		return true;

	}
	
	public static boolean findItemByNoScorm(File srcDir,Long courseId,ItemInfoService itemService){
		boolean isSave = false;
		if(srcDir.exists() && srcDir.isDirectory()){
			String[] listFiles = FileUtil.listFiles(srcDir);
			for(String fileName : listFiles){
				ItemInfo itemInfo = new ItemInfo();
				itemInfo.setCourseId(courseId);
				itemInfo.setChildLevel(1L);
				itemInfo.setItemTitle(new File(fileName).getName().substring(0, 
						new File(fileName).getName().lastIndexOf(".")>0?new File(fileName).getName().lastIndexOf("."):new File(fileName).getName().length()));
				itemInfo.setLaunch(fileName);
				itemInfo.setScoType(fileName.substring(fileName.lastIndexOf(".")+1, fileName.length())==""?fileName:fileName.substring(fileName.lastIndexOf("."), fileName.length()));
				itemService.saveItemInfo(itemInfo);
				isSave = true;
			}
		}
		return isSave;
	}
	
	public static CourseInfo saveCourseInfo(File destFile,String ftpZipPath,Long folderId,Long coutentId,CourseInfoService courseInfoService){
		CourseInfo courseInfo = new CourseInfo();
		courseInfo.setCourseTitle(destFile.getName()==null?"":destFile.getName().substring(
				0,
				destFile.getName().lastIndexOf(
						CourseConstant.COURSE_SEPARATOR)));
		courseInfo.setType(CourseConstant.COURSE_TYPE_NOSCORM);
		courseInfo.setCostType(CourseConstant.COURSE_COST_PERSONAL);
		courseInfo.setLocation(ftpZipPath==null?"":ftpZipPath);
		courseInfo.setFolderId(folderId);
		courseInfo.setControl(0L);
		courseInfo.setContentServerId(coutentId);
		courseInfoService.saveCourseInfo(courseInfo);
		return courseInfo;
	}
	
//	public static boolean chinaToUnicode(String str){  
//		
//	     boolean result=false;  
//	     for (int i = 0; i < str.length(); i++){  
//	          int chr1 = (char) str.charAt(i);  
//	          if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)  
//	        	  result = true;
//	        	  break;
//	          }
//	     }  
//	     return result;
//	} 


	public static boolean checkChinese(String str){
		Pattern p = Pattern.compile("[\u4E00-\u9FA5\uF900-\uFA2D\uFF00-\uFFEF]");
		Matcher m = p.matcher(str);
		return m.find();
	}

	
	public static List<FolderNode> getDirectoriesNameList(List<FolderNode> folderNodeList, File file, String pNode,int id) throws Exception {
		boolean isParent = false;
		boolean isCourseFolder = false;
		int maxNodeID = id+1;
		for (File ftpFile : file.listFiles()) {
			if(ftpFile.isDirectory()){
				FolderNode node = new FolderNode(String.valueOf(maxNodeID), String.valueOf(id), new String(
						ftpFile.getName().getBytes("UTF-8"), "UTF-8"), isParent);
				for(File temp : ftpFile.listFiles()){
					 if(temp.isFile()&(temp.getName().equals("imsmanifest.xml") || temp.getName().equals("isCourse.txt"))){
						  isCourseFolder = true;
						  break;
						}
				}
				node.setPath(pNode.concat("/").concat(ftpFile.getName()));
				if(isCourseFolder){
					node.setIcon(Struts2Utils.getRequest().getContextPath() + "/img/tree/course.png");
				}else{
					node.setIcon(Struts2Utils.getRequest().getContextPath() + "/img/tree/folder_Open.png");
				}
				node.setRoot(true);// 设置根节点不能拖拽
				node.setChildNode(true);// 设置根节点的可以添加子节点
				node.setEditable(false);// 设置根节点不可以编辑和删除
				node.setNodeType(isCourseFolder?FolderNode.COURSEWARE:FolderNode.COURSE_FOLDER);
				node.setClick(isCourseFolder?false:true);
				node.setParent(isCourseFolder?false:true);
				folderNodeList.add(node);
				maxNodeID++;
				isCourseFolder = false;
			}
			
		}
		return folderNodeList;
	}

}
