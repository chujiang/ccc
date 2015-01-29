package com.kingnod.etraining.activity.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.action.ObjectPickerAction;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.service.PaperService;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@org.springframework.stereotype.Controller
@Namespace("/aty")
public class PaperPickerAction extends ObjectPickerAction {

	/**
	 * 选择试卷
	 */
	private static final long serialVersionUID = 9205602268865897105L;
	@Autowired
	private PaperService paperService;
	
	private String keyword;
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String tree() throws Exception {
		List childs =null;
		if(null!=keyword){
			if(StringUtils.isNotEmpty(keyword.trim())){
				childs = treeService.getResourceTreeViewChilds(id, keyword.trim(),ObjectType.R_PF.toString(), ObjectType.R_OS, ObjectType.R_PF, ObjectType.R_PF);
			}else{
				childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_PF);
			}
			
		}else{
			childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_PF);
		}
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.basicSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.basicResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	public String list() throws Exception {
		CriteriaBuilder cb = Cnd.builder(Paper.class);
		cb.andEQ("folderId", id).andEQ("status", ExamConstant.STATUS_R);
		PagingResult<Paper> result = paperService.findPaper(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Paper.class, TreeViewUtils.basicPaperProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	/**
	 * 获取试卷名称 @update PiJingwei 
	 */
	@Override
	public String name() throws Exception {
		String objectId = this.getObjectId();
		if(objectId == null) {
	    	return "jsonResult";
		}
		PagingResult<Paper> result = paperService.findPaper(Cnd.builder(Paper.class).andEQ("id", objectId).buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Paper.class, TreeViewUtils.basicPaperProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
}
