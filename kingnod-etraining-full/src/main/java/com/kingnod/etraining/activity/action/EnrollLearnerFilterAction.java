package com.kingnod.etraining.activity.action;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.entity.EnrollLearnerFilter;
import com.kingnod.etraining.activity.service.EnrollLearnerFilterService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.entity.UserProperties;
import com.kingnod.etraining.organization.entity.UserPropertyOption;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserGroupService;
import com.kingnod.etraining.organization.service.UserPropertiesService;
import com.kingnod.etraining.organization.service.UserPropertyOptionService;
import com.kingnod.etraining.organization.service.UserService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "enroll-learner-filter", "namespace", "/aty", "siteId", "${siteId}", "folderId", "${folderId}", "activityId", "${activityId}", "activityType", "${activityType}", "folderType", "${folderType}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
public class EnrollLearnerFilterAction extends FilterableEntityAction<EnrollLearnerFilter, Long> {

    @Autowired
    private EnrollLearnerFilterService enrollLearnerFilterService;
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
	private UserPropertiesService userPropertiesService;
	

    private Long activityId;
	private Long siteId;
	private Long folderId;
	private String folderType;
    private String filterTypes;
    private ObjectType type;
	private String propertyType;
	private UserProperties userProperty;
	private String flag;
	private String activityType;
    
    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    public String filterDefines() {
        return "aty.enrollLearnerFilterFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
    protected Object getEntityService() {
        return this.enrollLearnerFilterService;
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
		if(null == id || "".equals(id) || "undefined".equals(id)) {
			if(ObjectType.O_UP == type) {	//新增属性
				Long groupNumber = enrollLearnerFilterService.getGroupNumber();
				entity.setGroupNumber(NumberUtils.toInt(groupNumber.toString()));
				super.save();
			} else {						//新增用户、用户组、站点、组织
				enrollLearnerFilterService.saveEnrollLearnerFilter(entity, batchIds);
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
	public String getPropType() throws Exception {
		String idParam = (String)request.getParameter("id");
		if(null == idParam || "".equals(idParam)) {
			String filterName = (String) request.getAttribute("filterName");
			if(null == filterName) {
				filterName = userPropertiesService.findListBySiteId(siteId).get(0).getId().toString();
			}
			userProperty = userPropertiesService.getUserProperties(Long.valueOf(filterName));
			if("T".equals(userProperty.getType()) || "D".equals(userProperty.getType())) {
				entity.setFilterValue("");
			}
			this.propertyType = userProperty.getType();
			this.flag = "doAdd";
		} else {
			entity = enrollLearnerFilterService.getEnrollLearnerFilter(Long.valueOf(idParam));
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
			enrollLearnerFilterService.mergeCondition(ListUtils.of(ids));
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
			Long groupNumber = enrollLearnerFilterService.getGroupNumber();
			entity = enrollLearnerFilterService.getEnrollLearnerFilter(ids[i]);
			entity.setGroupNumber(NumberUtils.toInt(groupNumber.toString()));
			enrollLearnerFilterService.saveEnrollLearnerFilter(entity);
		}
		return RELOAD;
	}
    
    
	/**
	 * 默认按照group_number（条件区标识）进行排序
	 */
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		cb.andEQ("activityId", activityId);
		cb.orderBy("groupNumber", Order.DESC);
	}
	
	
	/**
	 * 查询页面
	 */
	@Override
	public String list() throws Exception {
		CriteriaBuilder cb = Cnd.builder(EnrollLearnerFilter.class).andEQ("activityType", activityType).andEQ("activityId", activityId);
		PagingResult<EnrollLearnerFilter> pagingResult = serviceInvoker.findPagingResult(getEntityService(), cb.buildCriteria());
		List result = pagingResult.getResult();
		for (int i = 0; i < result.size(); i++) {
			EnrollLearnerFilter enrollLearnerFilter = (EnrollLearnerFilter) result.get(i);
			ObjectType type = enrollLearnerFilter.getType();
			String filterValue = enrollLearnerFilter.getFilterValue();
			String tmpName = "";
			if(ObjectType.O_OU == type) {			//用户
				User user = userService.getUser(NumberUtils.toLong(filterValue));
				tmpName = user==null ? "" : user.getFullName();
				enrollLearnerFilter.setFilterValue(tmpName);
			} else if(ObjectType.O_OG == type) {	//用户组
				UserGroup userGroup = userGroupService.getUserGroup(NumberUtils.toLong(filterValue));
				tmpName = userGroup==null ? "" : userGroup.getName();
				enrollLearnerFilter.setFilterValue(tmpName);
			} else if(ObjectType.O_OS == type) {	//站点
				Site site = siteService.getSite(NumberUtils.toLong(filterValue));
				tmpName = site==null ? "" : site.getName();
				enrollLearnerFilter.setFilterValue(tmpName);
			} else if(ObjectType.O_OO == type) {	//组织
				Organization organization = organizationService.getOrganization(NumberUtils.toLong(filterValue));
				if(null == organization) {
					Site site = siteService.getSite(NumberUtils.toLong(filterValue));
					enrollLearnerFilter.setFilterValue(site.getName());
				} else {
					enrollLearnerFilter.setFilterValue(organization.getName());
				}
			} else if(ObjectType.O_UP == type) {	//属性
				UserProperties userProperties = userPropertiesService.getUserProperties(NumberUtils.toLong(enrollLearnerFilter.getFilterName()));
				if(null != userProperties) {
					if("C".equals(userProperties.getType())) {	//复选框
						String tempStr = "";
						String[] checkboxList = filterValue.split(",");
						for(String checkboxId : checkboxList) {
							UserPropertyOption userPropertyOption = userPropertyOptionService.getUserPropertyOption(NumberUtils.toLong(checkboxId.trim()));
							tempStr = tempStr + "," + userPropertyOption.getName();
						}
						tempStr = "".equals(tempStr) ? "" : tempStr.substring(1);
						enrollLearnerFilter.setFilterValue(tempStr);
					} else if("U".equals(userProperties.getType())) {
						User user = userService.getUser(NumberUtils.toLong(filterValue));
						tmpName = user==null ? "" : user.getFullName();
						enrollLearnerFilter.setFilterValue(tmpName);
					} else {
						UserPropertyOption userPropertyOption = userPropertyOptionService.getUserPropertyOption(NumberUtils.toLong(filterValue));
						if(null != userPropertyOption) {
							enrollLearnerFilter.setFilterValue(userPropertyOption.getName());
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
	
	/**
	 * 设置登记方式
	 * @return
	 * @throws Exception
	 */
	public String enrollModeModify() throws Exception {
		Long[] ids = getIdValues();
		String enrollMode = request.getParameter("enrollMode");
		if (null != ids && ids.length > 0) {
			enrollLearnerFilterService.enrollModeModify(ListUtils.of(ids), enrollMode, false);
		}
		return RELOAD;
	}
    


	public Long getActivityId() {
		return activityId;
	}


	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}


	public String getFilterTypes() {
		return filterTypes;
	}


	public void setFilterTypes(String filterTypes) {
		this.filterTypes = filterTypes;
	}


	public ObjectType getType() {
		return type;
	}


	public void setType(ObjectType type) {
		this.type = type;
	}


	public String getPropertyType() {
		return propertyType;
	}


	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}


	public UserProperties getUserProperty() {
		return userProperty;
	}


	public void setUserProperty(UserProperties userProperty) {
		this.userProperty = userProperty;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public EnrollLearnerFilter getEnrollLearnerFilter() {
		return entity;
	}


	public void setEnrollLearnerFilter(EnrollLearnerFilter enrollLearnerFilter) {
		this.entity = enrollLearnerFilter;
	}


	public Long getFolderId() {
		return folderId;
	}


	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}


	public String getActivityType() {
		return activityType;
	}


	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}


	public String getFolderType() {
		return folderType;
	}

	public void setFolderType(String folderType) {
		this.folderType = folderType;
	}

}