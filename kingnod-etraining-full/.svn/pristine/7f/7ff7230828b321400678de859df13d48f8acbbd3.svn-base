package com.kingnod.etraining.common.action;

import java.util.HashMap;
import java.util.Map;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.etraining.common.entity.NoticeConfig;
import com.kingnod.etraining.common.service.NoticeConfigService;
import com.kingnod.etraining.common.service.NoticeService;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "notice-config", "namespace", "/cmn","siteId", "${siteId}"})
}
)

@com.kingnod.core.annotation.Generated("2012-04-24 10:44")
@ErrorMapping(method="save")
public class NoticeConfigAction extends FilterableEntityAction<NoticeConfig, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:44")
    private NoticeConfigService noticeConfigService;
    
    @Autowired
    private NoticeService noticeService;
    
    private long siteId;
    
    private String q_noticeType ;//自定义查询条件
    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:44")
    public String filterDefines() {
        return "cmn.noticeConfigFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:44")
    protected Object getEntityService() {
        return this.noticeConfigService;
    }
     /**
	 * 过滤只能查看当前站点创建的通知
	 */
    @Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		cb.andEQ("siteId", siteId);
		if(!StringUtils.isEmpty(q_noticeType)){
			cb.andEQ("noticeType", q_noticeType);
		}
	}

	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}


	public String getQ_noticeType() {
		return q_noticeType;
	}


	public void setQ_noticeType(String q_noticeType) {
		this.q_noticeType = q_noticeType;
	}
     
}