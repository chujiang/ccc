package com.kingnod.etraining.common.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.SysParameter;

@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
public interface SysParameterService extends com.kingnod.core.extensions.service.SysParameterService {
	
	public static final String SYS_DATE_FORMAT = "sys.date_format";
	public static final String SYS_DATETIME_FORMAT = "sys.datetime_format";
	public static final String SCOPE_SITE = "S";
	public static final String SCOPE_APPLICATION = "A";
	public static final String LIST_COLUMN_CONTENT_LIMIT = "sys.list_column_content_limit";
	public static final String PDF2SWFTOOLS_PATH = "sys.paf2swftools_path";
	
	void setDefaultValue(String code);

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	SysParameter getSysParameter(Long id);

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	int saveSysParameter(SysParameter sysParameter);
	
	int saveSysParameter(SysParameter sysParameter, Long siteId);

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	int deleteSysParameter(SysParameter sysParameter);

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	int deleteSysParameterByIds(Long[] ids);
	
	void refresh();

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	PagingResult<SysParameter> findSysParameter(Criteria criteria);
	
	PagingResult<SysParameter> findListSysParameterBySiteId(Long siteId, Criteria criteria);
	
	String getSystemParameterString(String key, String siteShortName);

	boolean getSystemParameterBoolean(String key, String siteShortName);

	Integer getSystemParameterInteger(String key, String siteShortName);

	Double getSystemParameterDouble(String key, String siteShortName);

	<T> List<T> getSystemParameterList(String key, String siteShortName, Class<T> type);
	
	void httpClientRefresh();
}