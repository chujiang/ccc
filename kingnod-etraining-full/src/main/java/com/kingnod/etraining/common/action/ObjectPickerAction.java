package com.kingnod.etraining.common.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.service.CourseInfoService;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results({ @Result(name = Action.SUCCESS, location = "/WEB-INF/content/cmn/object-picker.jsp") })
public abstract class ObjectPickerAction extends ActionSupport {

	private static final long serialVersionUID = 2020058299430642234L;

	@Autowired
	protected TreeService treeService;
	@Autowired
	protected CourseInfoService courseInfoService;
	/**
	 * 当前选中或展开节点的id
	 */
	protected Long id;
	/**
	 * 当前选中或展开节点的类别
	 */
	protected ObjectType nodeType;
	/**
	 * 单选还是多选
	 */
	protected String mutiSelect;
	/**
	 * 传入action路径和名称
	 */
	protected String actionName;
	/**
	 * 传入选中对象的id
	 */
	protected String objectId;

	/**
	 * 转化为数组
	 */
	protected long[] objId;
    /**
	 * 扩展参数
	 */
	protected String extparams ;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	abstract public String tree() throws Exception;

	abstract public String list() throws Exception;

	abstract public String name() throws Exception;

	public Long getId() {
		return id;
	}

	public ObjectType getNodeType() {
		return nodeType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNodeType(ObjectType nodeType) {
		this.nodeType = nodeType;
	}

	public String getMutiSelect() {
		return mutiSelect;
	}

	public void setMutiSelect(String mutiSelect) {
		this.mutiSelect = mutiSelect;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public long[] getObjId() {
		return initObjId();
	}

	public void setObjId(long[] objId) {
		this.objId = initObjId();
	}

	public long[] initObjId() {
		if (!StringUtils.isEmpty(objectId) && !"undefined".equals(objectId)) {
		
			String s[] = objectId.split(",");
		
			objId = new long[s.length];

			for (int i = 0; i < s.length; i++) {
				objId[i] = Long.valueOf(s[i]);
			}
		}
		return objId;
	}


	public String getExtparams() {
		return extparams;
	}

	public void setExtparams(String extparams) {
		this.extparams = extparams;
	}

}
