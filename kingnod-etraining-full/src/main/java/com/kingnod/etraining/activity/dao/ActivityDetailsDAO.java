package com.kingnod.etraining.activity.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.common.ObjectType;


    @com.kingnod.core.annotation.Generated("2012-03-18 11:30")
public interface ActivityDetailsDAO {

    	
    	/**
         * 新增一个实体
         * 
         * @param entity
         */
        public int insert(ActivityDetails entity);
        
        /**
         * 新增多个实体
         * @param entities
         * @return
         */
        public int insert(List<ActivityDetails> entities);
        
        /**
         * 更新一个实体
         * 
         * @param entity
         */
        public int update(ActivityDetails entity);
        
        /**
         * 根据自定义条件更新多个实体， 值为null的属性不会更新。
         * @param entity
         * @param criteria
         * @return
         */
        public int updateByCriteria(ActivityDetails entity, Criteria criteria);
        
        /**
         * 删除一个或多个实体
         * 
         * @param entities
         */
        public int delete(ActivityDetails... entities);
        
        /**
         * 删除一个或多个实体
         * 
         * @param ids 实体ID集
         */
        public int deleteById(String activityType, Long... activityId);
        
        /**
         * 根据自定义条件删除实体
         * @param criteria
         * @return
         */
        public int deleteByCriteria(Criteria criteria) ;
        
        /**
         * 根据实体ID查找实体
         * 
         * @param id
         * @return
         */
        public ActivityDetails get(ObjectType activityType, Long activityId);
        
        
        /**
         * 查找所有实体
         * 
         * @return
         */
        public List<ActivityDetails> findAll();
        
        /**
         * 根据criteria查询实体集
         * 
         * @param criteria 查询条件集
         * @return
         */
        public List<ActivityDetails> findByCriteria(Criteria criteria);
        
        /**
         * 统计所有的实体数
         */
        public int countAll();
        
        /**
         * 根据criteria统计实体数
         * @param criteria
         * @return
         */
        public int countByCriteria(Criteria criteria);
        
        /**
         * 分页查询
         * @param criteria 查询条件集
         * @return
         */
        public PagingResult<ActivityDetails> findPagingResult(Criteria criteria);
        
        /**
         * 根据Map参数查询实体
         * 
         * @param parameter
         * @return
         */
        public List<ActivityDetails> findByMap(Map<?, ?> parameter);
        
}