package com.kingnod.etraining.organization.dao;

import java.util.List;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.organization.entity.UserProperties;


    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
public interface UserPropertiesDAO extends EntityDAO<UserProperties, Long> {
    	
    	/**
         * 获取已经占用的ProPertyNumber的List
         * @param siteId
         * @return
         */
        List<Integer> getNumberListByOrderPropertyNumber(Long siteId);

        /**
         * 根据条件  分别查出 上移  下移  至顶  至尾  的前一条数据或后一条
         * @param userProperties
         * @return
         */
		List<UserProperties> findBySequence(UserProperties userProperties);

		/**
		 * 更新所有满足条件的 sequence
		 * @param userProperties
		 */
		Integer updateSequences(UserProperties userProperties);

		/**
		 * 查询 UserProperties中 最大的 seq
		 * @param userProperties
		 * @return
		 */
		Integer findMaxBySequenceOne(UserProperties userProperties);

}