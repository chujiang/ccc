package com.kingnod.etraining.common.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.common.entity.Attachment;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-05-01 10:08")
public class AttachmentDAOImpl extends MybatisEntityDAO<Attachment, Long> implements AttachmentDAO {

	public Long maxSegmentNo(Criteria criteria) {
		return (Long) getSqlSession().selectOne(sqlId("maxSegmentNo"), criteria);
	}

}