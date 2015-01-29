package com.kingnod.etraining.course.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.exception.ApplicationException;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.service.ItemInfoService;

//@ParentPackage("json-default")
@Namespace("/crs")
@Results({
@Result(name="itemInfo-input",location="/WEB-INF/content/crs/itemInfo-input.jsp"),
@Result(name="update",location="/WEB-INF/content/crs/itemInfo-update-success.jsp")
})
public class CourseInfoItemsAction extends FilterableEntityAction<ItemInfo, Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5006189401399858545L;
	private String nodeType = StringUtils.EMPTY;
	private Long id = 0L;
	private Long courseId = 0L;
	private Long typeId = 0L;
	private Long parentId = 0L;
	private String itemName = StringUtils.EMPTY;
	private List<TreeNode> result = null;
	private TreeNode newTreeNode = null;
	private Long targetId;// 拖拽节点时，父节点的Id
	private ItemInfo itemInfo = null;
	private String folderId;
	private String category;
	private String treeId;

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-13 09:20")
	private ItemInfoService itemInfoService;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 加载树节点信息
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getTreeNodeList() throws Exception {
		List<ItemInfo> listItemInfo = itemInfoService.getItemInfoList(courseId);
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ItemInfo.class, TreeViewUtils.viewListCourseScoProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", listItemInfo);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}

	/**
	 * 根据Id查询
	 * 
	 * @return String
	 */
	public String findItemInfo() {
		itemInfo = itemInfoService.getItemInfo(id);
		return "itemInfo-input";
	}

	public String addItemInfo(){
		return "itemInfo-input";
	}
	/**
	 * 新建节点
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String saveItemInfo() throws Exception {
		super.save();
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ItemInfo.class, TreeViewUtils.viewCourseScoProcessor);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", entity);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}

	/**
	 * 删除
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String deleteItemInfo() throws Exception {
		itemInfoService.deleteItemInfo(id);
		return StringUtils.EMPTY;
	}

	/**
	 * 修改名称
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String updateItemInfoName() throws Exception {
		if (StringUtils.isEmpty(entity.getItemTitle())) {
			throw Exceptions.createAppException("crs001020");
		}
		CriteriaBuilder builder = Cnd.builder(ItemInfo.class);
		builder.andEQ("itemTitle", entity.getItemTitle()).andEQ("itemParent", entity.getItemParent());
		List<ItemInfo> result2 = itemInfoService.findItemInfo(builder.buildCriteria()).getResult();
		if(result2.size()>0){
			throw Exceptions.createAppException("crs001021");
		}
		//save
		super.save();
		List<ItemInfo> itemInfos = itemInfoService.findItemInfo(builder.buildCriteria()).getResult();
		ItemInfo itemInfo = itemInfos.get(0);
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ItemInfo.class, TreeViewUtils.viewCourseScoProcessor);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", itemInfo);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}

	/**
	 * 修改当前选中节点的信息
	 * 
	 * @return String
	 * @throws ApplicationException
	 * @throws UnsupportedEncodingException
	 */
	public String updateItemInfo() {
		ItemInfo curItemInfo = itemInfoService.getItemInfo(itemInfo.getId());
		curItemInfo.setItemTitle(itemInfo.getItemTitle());
		curItemInfo.setLaunch(itemInfo.getLaunch());
		curItemInfo.setMasteryScore(itemInfo.getMasteryScore());
		curItemInfo.setPrerequisites(itemInfo.getPrerequisites());
		curItemInfo.setItemDescription(itemInfo.getItemDescription());
		itemInfoService.updateItemInfo(curItemInfo);
		return "update";
	}

	/**
	 * 拖拽节点，保存sequence
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String updateSequence() throws Exception {
		itemInfoService.updateSequence(typeId, targetId);
		return StringUtils.EMPTY;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public ItemInfo getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public TreeNode getNewTreeNode() {
		return newTreeNode;
	}

	public void setNewTreeNode(TreeNode newTreeNode) {
		this.newTreeNode = newTreeNode;
	}

	public List<TreeNode> getResult() {
		return result;
	}

	public void setResult(List<TreeNode> result) {
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public ItemInfoService getItemInfoService() {
		return itemInfoService;
	}

	public void setItemInfoService(ItemInfoService itemInfoService) {
		this.itemInfoService = itemInfoService;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeId() {
		return treeId;
	}

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String filterDefines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getEntityService() {
		// TODO Auto-generated method stub
		return itemInfoService;
	}
	
}