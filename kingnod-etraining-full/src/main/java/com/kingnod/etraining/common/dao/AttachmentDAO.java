package com.kingnod.etraining.common.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.common.entity.Attachment;


    @com.kingnod.core.annotation.Generated("2012-05-01 10:08")
public interface AttachmentDAO extends EntityDAO<Attachment, Long> {
    	
    	public Long maxSegmentNo(Criteria criteria);

}