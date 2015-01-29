package com.kingnod.etraining.report.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.report.entity.CourseMessage;


@org.springframework.stereotype.Repository
    @com.kingnod.core.annotation.Generated("2012-05-15 12:34")
public class CourseMessageDAOImpl extends MybatisEntityDAO<CourseMessage,Long> implements CourseMessageDAO {

public PagingResult<CourseMessage> findPagingResult(Criteria criteria){
  return pagingQuery(sqlId("countByCriteria"),sqlId("findByCriteria"),criteria);
}

}