package com.kingnod.etraining.report.action;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kingnod.core.annotation.Generated;
import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Logic;
import com.kingnod.core.criteria.Operator;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.HttpParameter;
import com.kingnod.etraining.common.export.util.Exporters;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.report.entity.ExaminationStat;
import com.kingnod.etraining.report.service.ExaminationStatService;
/**
 * 考试统计信息Action类
 * 
 * @author Sam
 *
 */
@Generated("2012-05-22 20:17")
@Controller
@Namespace("/rpt")
@Results( {
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "examination-stat", "namespace", "/rpt"})
})
public class ExaminationStatAction extends FilterableEntityAction<ExaminationStat,Long> {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 225379616177899197L;

	   
    @Generated("2012-05-22 20:17")
    @Autowired 
    private ExaminationStatService examinationStatService;
    
    @Autowired
    private SiteService siteService;
    
    private Long siteId;

    @Override
    public String execute() throws Exception {
    	request.setAttribute("page", pager);
    	return SUCCESS;
    }
    
    /**
     * 导出EXCEL报表
     */
    public void export() {
    	PagingResult<ExaminationStat> exportDataset = doQuery(createCriteria());
    	Site site = siteService.getSite(siteId);
    	Exporters.toXLSByXmlPublisherWithDownload(
    			"examinationStatReport",
    			ListUtils.of("examinationName","paperTotalScore","atyTime","scrollingTypeString","passScore","formattedStartDateString","allRegisters","examedCount","passCount","avgScore"), 
    			exportDataset.getResult(),
    			SpringUtils.getMessage("rpt.examinationStat_title") + String.format("(%s)",site.getName()));
    }
    
    protected void preparedCriteriaBuilder(CriteriaBuilder cb) { 
    	HttpParameter param = HttpParameter.create(request);
    	ExaminationStat e = entity; 
    	if (e.getSiteId() != null)
    		cb.andEQ("siteId", e.getSiteId());
    	
    	if (StringUtils.isNotBlank(e.getExaminationName())) 
    		cb.andLike("examinationName", e.getExaminationName());
    	
    	if (e.getPaperTotalScore() != null)
    		cb.add(Cnd.createCriterion(Logic.AND, "paperTotalScore", Operator.valueOf(param.getString("paperTotalScoreOperators")), e.getPaperTotalScore()));
    	
    	if (e.getAtyTime() != null)
    		cb.add(Cnd.createCriterion(Logic.AND, "atyTime", Operator.valueOf(param.getString("atyTimeOperators")), e.getAtyTime()));
    	
    	if (StringUtils.isNotBlank(e.getScoringType())) 
    		cb.andEQ("scoringType", e.getScoringType());
    	
    	if (e.getPassScore() != null) 
    		cb.add(Cnd.createCriterion(Logic.AND, "passScore", Operator.valueOf(param.getString("atyTimeOperators")), e.getPassScore()));
    	
    	if (e.getStartDate() != null) { 
    		cb.andGroup(
    				Cnd.builder().add(
    						Cnd.createCriterion(Logic.NONE, "startDate", Operator.valueOf(param.getString("startDateOperators")), e.getStartDate())
    						).add(
    						Cnd.createCriterion(Logic.OR, "startDate", Operator.IS_NULL, null)		
    						));
    	}
    	
    	if (e.getAllRegisters() != null)
    		cb.add(Cnd.createCriterion(Logic.AND, "allRegisters", Operator.valueOf(param.getString("allRegistersOperators")), e.getAllRegisters()));
    	
    	if (e.getExamedCount() != null)
    		cb.add(Cnd.createCriterion(Logic.AND, "examedCount", Operator.valueOf(param.getString("examedCountOperators")), e.getExamedCount()));
    	
    	if (e.getPassCount() != null)
    		cb.add(Cnd.createCriterion(Logic.AND, "passCount", Operator.valueOf(param.getString("passCountOperators")), e.getPassCount()));
    	
    	if (e.getAvgScore() != null)
    		cb.add(Cnd.createCriterion(Logic.AND, "avgScore", Operator.valueOf(param.getString("avgScoreOperators")), e.getAvgScore()));
    }
    
    
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    protected Object getEntityService() {
        return this.examinationStatService;
    }


	public String filterDefines() {
		return null;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getSiteId() {
		return siteId;
	}
 
}