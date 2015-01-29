package com.kingnod.etraining.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.reflect.ClassWrapper;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.dao.SysParameterDAO;
import com.kingnod.etraining.common.entity.SysParameter;
import com.kingnod.etraining.common.service.SysParameterService;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Service
@Scope("singleton")
@Lazy(false)
public class SysParameterServiceImpl implements SysParameterService, InitializingBean {

	private static Map<String, SysParameter> sysParamMap = new HashMap<String, SysParameter>();
	
	private final static Logger logger = LoggerFactory.getLogger(SysParameterServiceImpl.class);

	@Autowired
	private SysParameterDAO sysParameterDAO;
	
	@Autowired
	private SiteDAO siteDAO;

	public SysParameter getSysParameter(Long id) {
		return sysParameterDAO.get(id);
	}

	public int saveSysParameter(SysParameter sysParameter) {
		int count = 0;
		String value = sysParameter.getValue();
		sysParameter = getSystemParameter(sysParameter.getCode());
		sysParameter.setValue(value);
		UserAccount userDetails = SecurityUtils.getCurrentUser();
		if (SysParameterService.SCOPE_SITE.equals(sysParameter.getScope()) && null == sysParameter.getSiteId()
				&& null != userDetails && null != userDetails.getSiteId()) {
			sysParameter.setSiteId(userDetails.getSiteId());
			sysParameter.setId(null);
			count = sysParameterDAO.insert(sysParameter);
		} else {
			IdEntity<Long> idEntity = (IdEntity) sysParameter;
			if (null != idEntity.getId() && null != sysParameterDAO.get(idEntity.getId())) {
				count = sysParameterDAO.update(sysParameter);
			} else {
				count = sysParameterDAO.insert(sysParameter);
			}
		}
		cacheSysParameter(sysParameter);
		return count;
	}
	
	public int saveSysParameter(SysParameter sysParameter, Long siteId) {
		int count = 0;
		String value = sysParameter.getValue();
		if(SysParameterService.SCOPE_SITE.equals(sysParameter.getScope())){
			SysParameter siteSysParameter = sysParamMap.get(sysParameter.getCode() + "_" + String.valueOf(siteId));
			if(null == siteSysParameter){
				siteSysParameter = sysParamMap.get(sysParameter.getCode());
				siteSysParameter.setId(null);
			}
			sysParameter = siteSysParameter;
		}else{
			sysParameter = sysParamMap.get(sysParameter.getCode());
		}
		sysParameter.setValue(value);
		if (SysParameterService.SCOPE_SITE.equals(sysParameter.getScope())) {
			sysParameter.setSiteId(siteId);
			IdEntity<Long> idEntity = (IdEntity) sysParameter;
			if (null != idEntity.getId() && null != sysParameterDAO.get(idEntity.getId())) {
				count = sysParameterDAO.update(sysParameter);
			} else {
				count = sysParameterDAO.insert(sysParameter);
			}
		} else {
			IdEntity<Long> idEntity = (IdEntity) sysParameter;
			if (null != idEntity.getId() && null != sysParameterDAO.get(idEntity.getId())) {
				count = sysParameterDAO.update(sysParameter);
			} else {
				count = sysParameterDAO.insert(sysParameter);
			}
		}
		cacheSysParameter(sysParameter);
		return count;
	}
	
	public void refresh(){
		List<SysParameter> list = sysParameterDAO.findAll();
		for (SysParameter sysParameter : list) {
			cacheSysParameter(sysParameter);
		}
		
	}
	
	public void httpClientRefresh(){
		HttpClient httpClient = new DefaultHttpClient();
		String url = SysParameterUtils.getString("sys.learner-web_url");
		if(url.indexOf("http:")<0){
			url=Struts2Utils.getRequest().getScheme() + "://" + Struts2Utils.getRequest().getServerName() + ":" + Struts2Utils.getRequest().getServerPort() +"/"+url+CommonConstant.SYS_PARAMETER_REFRESH;
		}else{
			url=url+CommonConstant.SYS_PARAMETER_REFRESH;
		}
//		String path = Struts2Utils.getRequest().getScheme() + "://" + Struts2Utils.getRequest().getServerName() + ":" + Struts2Utils.getRequest().getServerPort() + CommonConstant.SYS_PARAMETER_REFRESH;
		HttpGet httpget = new HttpGet(url);
		//执行getMethod
		//int statusCode;
		try {
			HttpResponse response = httpClient.execute(httpget);

			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.error("Method failed: " + response.getStatusLine());
			}
		} catch (Exception e) {
			logger.error("刷新失败!");
		} 
	}

	public PagingResult<SysParameter> findSysParameter(Criteria criteria) {
		return sysParameterDAO.findPagingResult(criteria);
	}

	public SysParameter getSystemParameter(String key) {
		if (!sysParamMap.containsKey(key)) {
			return null;
		}
		SysParameter sysParameter = sysParamMap.get(key);
		if (SysParameterService.SCOPE_SITE.equals(sysParameter.getScope())) {
			UserAccount userDetails = SecurityUtils.getCurrentUser();
			if (null != userDetails && null != userDetails.getSiteId()) {
				SysParameter sitesysParameter = sysParamMap.get(key + "_" + userDetails.getSiteId());
				if (null != sitesysParameter) {
					sysParameter = sitesysParameter;
				}
			}
		}
		return sysParameter;
	}
	
	/**
	 * 根据key和站点短名称取系统参数
	 * @param key
	 * @param siteShortName
	 * @return
	 */
	public SysParameter getSystemParameter(String key, String siteShortName) {
		if (!sysParamMap.containsKey(key)) {
			return null;
		}
		SysParameter sysParameter = sysParamMap.get(key);
		if (SysParameterService.SCOPE_SITE.equals(sysParameter.getScope())) {
			CriteriaBuilder cb = Cnd.builder(Site.class);
			cb.andEQ("shortName", siteShortName).andEQ("recordStatus", RecordStatus.ACTIVE);
			List<Site> siteList = siteDAO.findByCriteria(cb.buildCriteria());
			Long siteId = null;
			if(!ListUtils.isEmpty(siteList)){
				siteId = siteList.get(0).getId();
			}
			if (null != siteId) {
				SysParameter sitesysParameter = sysParamMap.get(key + "_" + siteId);
				if (null != sitesysParameter) {
					sysParameter = sitesysParameter;
				}
			}
		}
		return sysParameter;
	}

	public String getSystemParameterString(String key) {
		SysParameter sysParam = getSystemParameter(key);
		if (null == sysParam) {
			return "";
		}
		return sysParam.getValue();
	}
	
	public String getSystemParameterString(String key, String siteShortName) {
		SysParameter sysParam = getSystemParameter(key, siteShortName);
		if (null == sysParam) {
			return "";
		}
		return sysParam.getValue();
	}

	public boolean getSystemParameterBoolean(String key) {
		SysParameter sysParam = getSystemParameter(key);
		if (null == sysParam || "true".equals(sysParam.getValue()) || "false".equals(sysParam.getValue())) {
			return false;
		}
		return new Boolean(sysParam.getValue());
	}
	
	public boolean getSystemParameterBoolean(String key, String siteShortName) {
		SysParameter sysParam = getSystemParameter(key, siteShortName);
		if (null == sysParam || "true".equals(sysParam.getValue()) || "false".equals(sysParam.getValue())) {
			return false;
		}
		return new Boolean(sysParam.getValue());
	}

	public Integer getSystemParameterInteger(String key) {
		SysParameter sysParam = getSystemParameter(key);
		if (null == sysParam || StringUtils.isEmpty(sysParam.getValue()) || !StringUtils.isNumeric(sysParam.getValue())) {
			return -1;
		}
		return new Integer(sysParam.getValue());
	}
	
	public Integer getSystemParameterInteger(String key, String siteShortName) {
		SysParameter sysParam = getSystemParameter(key, siteShortName);
		if (null == sysParam || StringUtils.isEmpty(sysParam.getValue()) || !StringUtils.isNumeric(sysParam.getValue())) {
			return -1;
		}
		return new Integer(sysParam.getValue());
	}

	public Double getSystemParameterDouble(String key) {
		SysParameter sysParam = getSystemParameter(key);
		if (StringUtils.isEmpty(sysParam.getValue())) {
			return new Double(-1);
		}
		return new Double(sysParam.getValue());
	}
	
	public Double getSystemParameterDouble(String key, String siteShortName) {
		SysParameter sysParam = getSystemParameter(key, siteShortName);
		if (StringUtils.isEmpty(sysParam.getValue())) {
			return new Double(-1);
		}
		return new Double(sysParam.getValue());
	}

	public <T> List<T> getSystemParameterList(String key, Class<T> type) {
		SysParameter sysParam = getSystemParameter(key);
		if (StringUtils.isEmpty(sysParam.getValue())) {
			return new ArrayList<T>();
		}
		List<T> result = new ArrayList<T>();
		StringTokenizer tokenizer = new StringTokenizer(sysParam.getValue(), ",");
		while (tokenizer.hasMoreTokens()) {
			String tokenVal = tokenizer.nextToken();
			result.add(ClassWrapper.wrap(type).newOne(tokenVal));
		}
		return result;
	}
	
	public <T> List<T> getSystemParameterList(String key, String siteShortName, Class<T> type) {
		SysParameter sysParam = getSystemParameter(key, siteShortName);
		if (StringUtils.isEmpty(sysParam.getValue())) {
			return new ArrayList<T>();
		}
		List<T> result = new ArrayList<T>();
		StringTokenizer tokenizer = new StringTokenizer(sysParam.getValue(), ",");
		while (tokenizer.hasMoreTokens()) {
			String tokenVal = tokenizer.nextToken();
			result.add(ClassWrapper.wrap(type).newOne(tokenVal));
		}
		return result;
	}

	private void cacheSysParameter(SysParameter sysParameter) {
		
		if (SysParameterService.SCOPE_SITE.equals(sysParameter.getScope())) {
			if (null != sysParameter.getSiteId()) {
				sysParamMap.put(sysParameter.getCode() + "_" + sysParameter.getSiteId(), sysParameter);
			} else {
				sysParamMap.put(sysParameter.getCode(), sysParameter);
			}
		} else if (SysParameterService.SCOPE_APPLICATION.equals(sysParameter.getScope())) {
			sysParamMap.put(sysParameter.getCode(), sysParameter);
		}
	}

	//初始化
	public void afterPropertiesSet() throws Exception {
		List<SysParameter> list = sysParameterDAO.findAll();
		for (SysParameter sysParameter : list) {
			cacheSysParameter(sysParameter);
		}
	}

	public void setDefaultValue(String code) {
		SysParameter sysParameter = getSystemParameter(code);
		if (null != sysParameter) {
			sysParameter.setValue(sysParameter.getDefaultValue());
			sysParameterDAO.update(sysParameter);
			cacheSysParameter(sysParameter);
		}
	}

	public int deleteSysParameter(SysParameter sysParameter) {
		return 0;
	}

	public int deleteSysParameterByIds(Long[] ids) {
		return 0;
	}

	public PagingResult<SysParameter> findListSysParameterBySiteId(Long siteId, Criteria criteria) {
		return sysParameterDAO.findListSysParameterBySiteId(siteId, criteria);
	}

}
