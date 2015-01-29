package com.kingnod.etraining.common.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.SysParameter;
import com.kingnod.etraining.common.service.SysParameterService;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = {
		"actionName", "sys-parameter", "namespace", "/cmn", "curSiteId", "${curSiteId}" }) })
@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
public class SysParameterAction extends
		FilterableEntityAction<SysParameter, Long> {

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private SysParameterService sysParameterService;
	private Long curSiteId;

	/**
	 * 只能更新已有的记录
	 */
	public String save() throws Exception {
		int count = sysParameterService.saveSysParameter(this.entity, curSiteId);
		if(count>0){
			sysParameterService.httpClientRefresh();
		}
		return EntityAction.RELOAD;
	}
	
	

	/**
	 * 不允许删除
	 */
	public String delete() throws Exception {
		return EntityAction.RELOAD;
	}

	public String setDefaultValue() {
		String code = request.getParameter("code");
		sysParameterService.setDefaultValue(code);
		return EntityAction.RELOAD;
	}

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String filterDefines() {
		return "cmn.sysParameterFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	protected Object getEntityService() {
		return this.sysParameterService;
	}
	
	@Override
	public String list() throws Exception {
		Criteria criteria = createCriteria();
		criteria.addParam("siteId", curSiteId);
		PagingResult<SysParameter> pagingResult = sysParameterService.findListSysParameterBySiteId(entity.getSiteId(), criteria);
		pager.setTotalCount(pagingResult.getTotalRows());
		pager.setResult(pagingResult.getResult());
		request.setAttribute("page", pager);
		return SUCCESS;
	}
	
	public String refresh(){
		sysParameterService.refresh();
		return null;
	}

	public Long getCurSiteId() {
		return curSiteId;
	}

	public void setCurSiteId(Long curSiteId) {
		this.curSiteId = curSiteId;
	}
	
}