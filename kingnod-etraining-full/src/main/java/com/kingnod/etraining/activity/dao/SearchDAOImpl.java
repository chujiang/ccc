package com.kingnod.etraining.activity.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.SearchResult;
import com.kingnod.etraining.activity.entity.UserActivity;

@org.springframework.stereotype.Repository


public class SearchDAOImpl extends MybatisEntityDAO<UserActivity, Long> implements SearchDAO {

	
  /**
   * <p>
   * 搜索活动
   * </p>
   * 
   * @param criteria
   *            查询条件构造.
   */
   public PagingResult<SearchResult>  findActivitiesByCriteria(Criteria criteria){
     PagingResult<SearchResult> allResult =  pagingQuery(sqlId("findActivitiesByCriteriaCount"),sqlId("findActivitiesByCriteria"),criteria);
     return allResult;
  }

   
   public PagingResult<SearchResult> searchByCriteria(Criteria criteria){
	   PagingResult<SearchResult> allResult =  pagingQuery(sqlId("searchByCriteriaCount"),sqlId("searchByCriteria"),criteria);
	   return allResult;
   }
}