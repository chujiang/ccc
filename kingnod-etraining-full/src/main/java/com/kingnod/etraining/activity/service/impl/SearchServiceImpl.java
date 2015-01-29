package com.kingnod.etraining.activity.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.SearchDAO;
import com.kingnod.etraining.activity.entity.SearchResult;
import com.kingnod.etraining.activity.service.SearchService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.AttachmentService;
import com.kingnod.etraining.common.util.StrUtil;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
    protected SearchDAO searchDAO;


  @Autowired
  protected AttachmentService attachmentService;
	
  /**
   * <p>
   * 搜索活动
   * </p>
   * 
   * @param criteria
   */
	 public PagingResult<SearchResult> findActivities(Criteria criteria,String type){
	    PagingResult<SearchResult>  result = searchDAO.findActivitiesByCriteria(criteria);
	    if(StringUtils.isEmpty(type)||type.equals(ObjectType.A_EL.name())){
		    for(SearchResult searchResult : result.getResult())
			    {
		        searchResult.setDesc(StrUtil.getShortSize(searchResult.getDesc(), 140));
			      searchResult.setImagePath(attachmentService.getAttachmentUrl(searchResult.getAttachmentId()));
			    }
	    }
    return result;
  }
	 public PagingResult<SearchResult> searchByCriteria(Criteria criteria){
		 PagingResult<SearchResult>  result = searchDAO.searchByCriteria(criteria);
		 return result;
	 }

}
