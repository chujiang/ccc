package com.kingnod.etraining.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.dao.TypeDAO;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.service.TypeService;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.organization.dao.SiteDAO;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	protected TypeDAO typeDAO;

	@Autowired
	protected SiteDAO siteDao;

	public Type getType(Long id) {
		return typeDAO.get(id);
	}

	public int saveType(Type type) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) type;
		if (null != idEntity.getId() && null != typeDAO.get(idEntity.getId())) {
			count = typeDAO.update(type);
		} else {
			count = typeDAO.insert(type);
		}
		return count;
	}

	/**
	 * 拖拽节点，修改位置
	 * @param typeId
	 * @param targetId
	 */
	public int move2before(Long id, Long targetId){
		Type curType = typeDAO.get(id);
		Type tarType = typeDAO.get(targetId);
		if(curType != null && tarType != null){
			Long cSequence = curType.getSequence();
			Long tSequence = tarType.getSequence();
			curType.setSequence(tSequence);
			tarType.setSequence(cSequence);
			typeDAO.update(curType);
			typeDAO.update(tarType);
			return 1;
		}
		return 0;
	}
	
	public int move2after(Long id, Long targetId){
		return 0;
	}
	
	public int updateType(Long id, String typeName) {
		CriteriaBuilder orgCb2 = Cnd.builder(Type.class);
		orgCb2.andEQ("id", id);
		List<Type> typelist = typeDAO.findByCriteria(orgCb2.buildCriteria());
		if (typelist != null && typelist.size() == 1
				&& StringUtils.isNotEmpty(typeName)) {
			Type type = typelist.get(0);
			type.setName(typeName);
			return saveType(type);
		}
		return 0;
	}

	public int deleteTypes(Long id) {
		deleteTypeByIds(new Long[] { id });// 删除主目录

		CriteriaBuilder orgCb2 = Cnd.builder(Type.class);// 删除子目录
		orgCb2.andEQ("parentId", id);
		List<Type> typelist = typeDAO.findByCriteria(orgCb2.buildCriteria());
		for (Type type : typelist) {
			deleteTypeByIds(new Long[] { type.getId() });
		}
		return 0;
	}

	public int deleteType(Type type) {
		return typeDAO.delete(type);
	}

	public int deleteTypeByIds(Long[] ids) {
		return typeDAO.deleteById(ids);
	}

	public PagingResult<Type> findType(Criteria criteria) {
		return typeDAO.findPagingResult(criteria);
	}

	public List<Type> getTreeNodeList(Long nodeId, String nodeType,Long siteID) {
		List<Type> listTree = new ArrayList<Type>();
			CriteriaBuilder siteCb = Cnd.builder(Type.class);
			siteCb.andEQ("recordStatus", RecordStatus.ACTIVE);
			siteCb.orderBy("sequence", Order.ASC);
			Criteria criteria = siteCb.buildCriteria();
			criteria.addParam("siteId", siteID);
			listTree = typeDAO.findByCriteria(criteria);
		return listTree;
	}
	/*public List<TreeNode> getTreeNodeList(Long nodeId, String nodeType,Long siteID) {
		List<TreeNode> listTree = new ArrayList<TreeNode>();
		if (StringUtils.EMPTY.equals(nodeType)) {
			CriteriaBuilder siteCb = Cnd.builder(Type.class);
			siteCb.andEQ("root", 1).andEQ("recordStatus", RecordStatus.ACTIVE).andEQ("siteId", siteID);
			siteCb.orderBy("sequence", Order.ASC);
			List<Type> typelist = typeDAO.findByCriteria(siteCb.buildCriteria());
			for (Type type : typelist) {
				CriteriaBuilder orgCb2 = Cnd.builder(Type.class);
				orgCb2.andEQ("parentId", type.getId()).andEQ("recordStatus",RecordStatus.ACTIVE);
				int typesize = typeDAO.countByCriteria(orgCb2.buildCriteria());

				TreeNode tn = new TreeNode(type.getId().toString(),String.valueOf(type.getParentId()), type.getName(),typesize > 0 ? true : false);
				
				tn.setRoot(true);//设置根节点不能拖拽
				tn.setChildNode(true);// 设置根节点的可以添加子节点
				tn.setEditable(false);// 设置根节点不可以编辑和删除
				tn.setNodeType(TreeNode.SITE);
				
				tn.setIcon(Struts2Utils.getRequest().getContextPath()+ "/img/tree/site.gif");
				listTree.add(tn);
			}
		} else if (nodeId != 0) {
			CriteriaBuilder siteCb = Cnd.builder(Type.class);
			siteCb.andEQ("parentId", nodeId).andEQ("recordStatus",RecordStatus.ACTIVE);
			siteCb.orderBy("sequence", Order.ASC);
			List<Type> typelist = typeDAO.findByCriteria(siteCb.buildCriteria());
			for (Type type : typelist) {
				CriteriaBuilder orgCb2 = Cnd.builder(Type.class);
				orgCb2.andEQ("parentId", type.getId()).andEQ("recordStatus",RecordStatus.ACTIVE);
				int typesize = typeDAO.countByCriteria(orgCb2.buildCriteria());
				TreeNode tn = new TreeNode(type.getId().toString(),String.valueOf(type.getParentId()), type.getName(),typesize > 0 ? true : false);
				tn.setNodeType(TreeNode.SITE);

				tn.setChildNode(getChildLevel(type));
				tn.setIcon(Struts2Utils.getRequest().getContextPath()+ "/img/tree/site.gif");
				listTree.add(tn);
			}
		}
		return listTree;
	}*/

	public boolean getChildLevel(Type type) {
		boolean childExist = true;
		if(type.getChildLevel() == 0){
			childExist = false;
		}
		return childExist;
	}
}