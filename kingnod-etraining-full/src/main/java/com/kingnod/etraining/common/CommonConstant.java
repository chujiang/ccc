package com.kingnod.etraining.common;

public final class CommonConstant {

	private CommonConstant() {
	}

	// 常量名需要大写，词与词之间用“_”分隔， 例如：public static final String RECORD_STATUS_ACTIVE =
	// "A";
	
	public static final Long ROOT_SITE_ID = -1L;
	
	public static final Long ADMIN_USER_ID = -1L;
	
	/**
	 * 系统维护帐号
	 */
	public static final Long SYS_MAINT_USER_ID = 2L;
	
	public static final String SYS_PARAMETER_SYS_ADMIN_HOME_PAGE_TIME_FORMAT = "sys.admin.home.page.time.format";

	public static final String USER_DETAILS_ATRRIBUTE_SITE_ID = "SITE_ID";

	public static final String LIST_FILTER_NAME = "filterName";

	public static final String LIST_FILTER_KEYWORD = "filterKeyword";

	public static final String WINDOW_OPEN_MODE_SELF = "self";

	public static final String WINDOW_OPEN_MODE_POPUP = "popup";

	public static final String WINDOW_OPEN_MODE_DIALOG = "dialog";

	public static final String WINDOW_OPEN_MODE_TARGET = "target";
	
	public static final String WINDOW_OPEN_MODE_SCRIPT = "script";

	public static final String SITE_OPTION_URL = "/org/site-option.action?siteId=";
	
	public static final String SITE_INPUT_URL = "/org/site!input.action?ids=";
	
	public static final String SITE_INPUT_NEW_URL = "/org/site!input.action?parentId=";
	
	public static final String SITE_DELETE_URL = "/org/site!delete.action?ids=";
	
	public static final String URSR_URL = "/org/user.action?organizationId=";
	
	public static final String ORGANIZATION_INPUT_URL = "/org/organization!input.action?ids=";
	
	public static final String ORGANIZATION_INPUT_NEW_URL = "/org/organization!input.action?siteId=";
	
	public static final String ORGANIZATION_DELETE_URL = "/org/organization!delete.action?ids=";
	
	public static final String ATYFOLDER_INPUT_URL = "/aty/activity-folder!input.action?ids=";
	
	public static final String ATYFOLDER_INPUT_NEW_URL = "/aty/activity-folder!input.action?siteId=";
	
	public static final String ATYFOLDER_DELETE_URL = "/aty/activity-folder!delete.action?ids=";
	
	public static final String RESOURCEFOLDER_INPUT_URL = "/res/resource-folder!input.action?ids=";
	
	public static final String RESOURCEFOLDER_INPUT_NEW_URL = "/res/resource-folder!input.action?siteId=";
	
	public static final String RESOURCEFOLDER_DELETE_URL = "/res/resource-folder!delete.action?ids=";
	
	public static final String USER_GROUP_URL = "/org/user-group.action?siteId=";
	
	public static final String LOCATION_URL = "/res/location.action?folderId=";
	
	public static final String QUESTION_URL = "/exm/question.action?folderId=";

	public static final String TYPE_INPUT_URL = "/cmn/type!input.action?parentId=";
	
	public static final String TYPE_DELETE_URL = "/cmn/type!delete.action?ids=";
	
	public static final String TYPE_UPDATE_URL = "/cmn/type!update.action?ids=";
	
	/**
	 * 组织树的标识
	 */
	public static final String TREE_TYPE_ORGANIZATION = "organization_tree";
	
	/**
	 * 活动树的标识
	 */
	public static final String TREE_TYPE_ACTIVITY = "activity_tree";
	
	/**
	 * 资源树的标识
	 */
	public static final String TREE_TYPE_RESOURCE = "resource_tree";
	/**
	 * 公告默认查询数量
	 */
	public static final String BULLETIN_SELECT_NUMBERS = "sys.bulletin_select_size";
	
	/**
	 * 更新学员系统参数
	 */
	public static final String SYS_PARAMETER_REFRESH = "/home!refresh.action";
}
