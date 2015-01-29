package com.kingnod.etraining.exam.action;

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
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.service.KnowledgeService;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@org.springframework.stereotype.Controller
@Namespace("/exm")
public class KnowledgePickerAction extends ObjectPickerAction {

	/**
	 * 选择知识点
	 */
	private static final long serialVersionUID = -6830890258080935596L;
	
	@Autowired
	private KnowledgeService knowledgeService;
	
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String tree() throws Exception {
		List<?> childs =null;
		if(null!=keyword){
			if(StringUtils.isNotEmpty(keyword.trim())){
				childs = treeService.getResourceTreeViewChilds(id, keyword.trim(),ObjectType.R_ZF.toString(), ObjectType.R_OS, ObjectType.R_ZF, ObjectType.R_ZF);
			}else{
				childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_ZF);
			}
			
		}else{
			childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_ZF);
		}
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Site.class, TreeViewUtils.basicSiteProcessor);
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.pickerResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	public String list() throws Exception {
		CriteriaBuilder cb = Cnd.builder(Knowledge.class);
		cb.andEQ("folderId", id);
		PagingResult<Knowledge> result = knowledgeService.findKnowledge(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Knowledge.class, TreeViewUtils.basicKnowledgeProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String name() throws Exception {
		long objids[] = this.getObjId();
	    if(objids == null) {
	    	return "jsonResult";
		}
		CriteriaBuilder cb = Cnd.builder(Knowledge.class);
		for(long objid: objids){
			cb.orEQ("id",objid );
		}
		PagingResult<Knowledge> result = knowledgeService.findKnowledge(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Knowledge.class, TreeViewUtils.basicKnowledgeProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
}

