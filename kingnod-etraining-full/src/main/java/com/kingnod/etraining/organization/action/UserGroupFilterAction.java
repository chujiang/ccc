package com.kingnod.etraining.organization.action;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.entity.UserGroupFilter;
import com.kingnod.etraining.organization.entity.UserProperties;
import com.kingnod.etraining.organization.entity.UserPropertyOption;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserGroupFilterService;
import com.kingnod.etraining.organization.service.UserGroupService;
import com.kingnod.etraining.organization.service.UserPropertiesService;
import com.kingnod.etraining.organization.service.UserPropertyOptionService;
import com.kingnod.etraining.organization.service.UserService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "user-group-filter", "namespace", "/org", "userGroupId", "${userGroupId}", "siteId", "${siteId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
public class UserGroupFilterAction extends FilterableEntityAction<UserGroupFilter, Long> {

    @Autowired
    private UserGroupFilterService userGroupFilterService;
	@Autowired
	private UserPropertiesService userPropertiesService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserGroupService userGroupService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private UserPropertyOptionService userPropertyOptionService;
	@Autowired
	private UserGroupFilterService userGroupFilgerService;

	
	private Long userGroupId;
	private Long siteId;
	private String propertyType;
	private UserProperties userProperty;
	private String flag;
	private ObjectType type;
	private String filterTypes;


	@com.kingnod.core.annotation.Generated("2012-02-09 18:44")
    public String filterDefines() {
        return "org.userGroupFilterFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
    protected Object getEntityService() {
        return this.userGroupFilterService;
    }
	
    
	/**
	 * 保存
	 * @return
	 * @throws Exception
	 */
	@Override
    public String save() throws Exception {
		String batchIds = request.getParameter("batchIds");	//批量用户、用户组、站点、组织Id
		String id = request.getParameter("id");
		if (null == id || "".equals(id) || "undefined".equals(id)) {
			if(ObjectType.O_UP == type) {	//新增属性
				Long groupNumber = userGroupService.getGroupNumber();
				entity.setGroupNumber(NumberUtils.toInt(groupNumber.toString()));
				super.save();
			} else {						//新增用户、用户组、站点、组织
				userGroupFilterService.saveUserGroupFilter(entity, batchIds);
			}
		} else {
			super.save();					//修改
		}
    	this.entity.setFilterName("");
    	String isProperty = (String) request.getParameter("isProperty");
    	if(!StringUtils.isEmpty(isProperty)&& "true".equals(isProperty)) {
            request.setAttribute("flag", "success");
    		return "user-property";
    	}
    	this.getValueStack().set("jsonRoot", new HashMap());
	    return "jsonResult";
    }
	
	
	/**
	 * 新增属性
	 * @return
	 * @throws Exception
	 */
	@ErrorMapping(result="user-property")
	public String getPropType()  {
		String idParam = (String)request.getParameter("id");
		if(null == idParam || "".equals(idParam)) {
			String filterName = (String) request.getAttribute("filterName");
			if(null == filterName) {
				List<UserProperties> props = userPropertiesService.findListBySiteId(siteId);
				if (ListUtils.isEmpty(props))
					throw Exceptions.createAppException("org001002");
				filterName = props.get(0).getId().toString();
			}
			userProperty = userPropertiesService.getUserProperties(Long.valueOf(filterName));
			this.propertyType = userProperty.getType();
			if("T".equals(userProperty.getType()) || "D".equals(userProperty.getType())) {
				entity.setFilterValue("");
			}
			this.flag = "doAdd";
		} else {
			entity = userGroupFilterService.getUserGroupFilter(Long.valueOf(idParam));
			userProperty = userPropertiesService.getUserProperties(Long.valueOf(entity.getFilterName()));
			this.propertyType = userProperty.getType();
			this.flag = "doModify";
		}
		return "user-property";
	}
	
	/**
	 * 用户自定义属性是否未配置
	 * @return
	 * @throws Exception
	 */
	@ErrorMapping(result="user-property")
	public String checkUserProperty()  {
		List<UserProperties> props = userPropertiesService.findListBySiteId(siteId);
		if (ListUtils.isEmpty(props))
			throw Exceptions.createAppException("org001002");
		return "jsonResult";
	}
	
	
	/**
	 * 新增用户、用户组、站点、组织
	 * @return
	 * @throws Exception
	 */
	@Override
	public String input() throws Exception {
		if(ObjectType.O_OU == type) {
			filterTypes = "O_OS;O_OO;O_OU";
		} else if (ObjectType.O_OG == type) {
			filterTypes = "O_OS;O_OG";
		} else if (ObjectType.O_OO == type) {
			filterTypes = "O_OS;O_OO";
		} else if (ObjectType.O_OS == type) {
			filterTypes = "O_OS";
		}
		return super.input();
	}
	
	/**
	 * 合并条件
	 * @return
	 * @throws Exception
	 */
	public String mergeCondition() throws Exception {
		Long[] ids = getIdValues();
		
		if (null != ids && ids.length > 0) {
			userGroupFilterService.mergeCondition(ListUtils.of(ids));
		}
		return RELOAD;
	}
	
	/**
	 * 取消合并
	 * @return
	 * @throws Exception
	 */
	public String cancelMerge() throws Exception {
		Long[] ids = getIdValues();
		
		for (int i=0; i<ids.length; i++) {
			Long groupNumber = userGroupService.getGroupNumber();
			entity = userGroupFilgerService.getUserGroupFilter(ids[i]);
			entity.setGroupNumber(NumberUtils.toInt(groupNumber.toString()));
			userGroupFilterService.saveUserGroupFilter(entity);
		}
		return RELOAD;
	}
	
	/**
	 * 默认按照group_number（条件区标识）进行排序
	 */
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		cb.andEQ("userGroupId", request.getParameter("userGroupId"));
		cb.orderBy("groupNumber", Order.DESC);
	}
	
	/**
	 * 查询页面
	 */
	@Override
	public String list() throws Exception {
		Criteria criteria = createCriteria();
		PagingResult<UserGroupFilter> pagingResult = serviceInvoker.findPagingResult(getEntityService(), criteria);
		List result = pagingResult.getResult();
		for (int i = 0; i < result.size(); i++) {
			UserGroupFilter userGroupFilter = (UserGroupFilter) result.get(i);
			ObjectType type = userGroupFilter.getType();
			String filterValue = userGroupFilter.getFilterValue();
			String tmpName = "";
			if(ObjectType.O_OU.equals(type)) {			//用户
				User user = userService.getUser(NumberUtils.toLong(filterValue));
				tmpName = user==null ? "" : user.getFullName();
				userGroupFilter.setFilterValue(tmpName);
			} else if(ObjectType.O_OG.equals(type)) {	//用户组
				UserGroup userGroup = userGroupService.getUserGroup(NumberUtils.toLong(filterValue));
				tmpName = userGroup==null ? "" : userGroup.getName();
				userGroupFilter.setFilterValue(tmpName);
			} else if(ObjectType.O_OS.equals(type)) {	//站点
				Site site = siteService.getSite(NumberUtils.toLong(filterValue));
				tmpName = site==null ? "" : site.getName();
				userGroupFilter.setFilterValue(tmpName);
			} else if(ObjectType.O_OO.equals(type)) {	//组织
				Organization organization = organizationService.getOrganization(NumberUtils.toLong(filterValue));
				if(null == organization) {
					Site site = siteService.getSite(NumberUtils.toLong(filterValue));
					userGroupFilter.setFilterValue(site.getName());
				} else {
					userGroupFilter.setFilterValue(organization.getName());
				}
			} else if(ObjectType.O_UP.equals(type)) {	//属性
				UserProperties userProperties = userPropertiesService.getUserProperties(NumberUtils.toLong(userGroupFilter.getFilterName()));
				if(null != userProperties) {
					if("C".equals(userProperties.getType())) {			//复选框
						String tempStr = "";
						String[] checkboxList = filterValue.split(",");
						for(String checkboxId : checkboxList) {
							UserPropertyOption userPropertyOption = userPropertyOptionService.getUserPropertyOption(NumberUtils.toLong(checkboxId.trim()));
							tempStr = tempStr + "," + userPropertyOption.getName();
						}
						tempStr = "".equals(tempStr) ? "" : tempStr.substring(1);
						userGroupFilter.setFilterValue(tempStr);
					} else if("U".equals(userProperties.getType())) {	//用户
						User user = userService.getUser(NumberUtils.toLong(filterValue));
						if(null != user)
							userGroupFilter.setFilterValue(user.getFullName());
					} else if ("S".equals(userProperties.getType()) || "R".equals(userProperties.getType())) { // 下拉框、单选框
						UserPropertyOption userPropertyOption = userPropertyOptionService.getUserPropertyOption(NumberUtils.toLong(filterValue));
						if (null != userPropertyOption) {
							userGroupFilter.setFilterValue(userPropertyOption.getName());
						}
					}
				}
			}
		}
		pager.setTotalCount(pagingResult.getTotalRows());
		pager.setResult(result);
		request.setAttribute("page", pager);
		return SUCCESS;
	}


	public ObjectType getType() {
		return type;
	}


	public void setType(ObjectType type) {
		this.type = type;
	}


	public String getFilterTypes() {
		return filterTypes;
	}


	public void setFilterTypes(String filterTypes) {
		this.filterTypes = filterTypes;
	}


    
    public Long getUserGroupId() {
		return userGroupId;
	}


	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}


	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public UserProperties getUserProperty() {
		return userProperty;
	}


	public void setUserProperty(UserProperties userProperty) {
		this.userProperty = userProperty;
	}


	public UserGroupFilter getUserGroupFilter() {
		return entity;
	}


	public void setUserGroupFilter(UserGroupFilter userGroupFilter) {
		this.entity = userGroupFilter;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}
	

    public String getPropertyType() {
		return propertyType;
	}


	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
}