package com.kingnod.etraining.common.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.NoticeUsers;


    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
	public interface NoticeUsersService {
	/** 
	 * @param noticeUsers批量增加用戶
	 */
	int batchSaveNoticeUsers(String noticeUsers,long noticeId);
	/** 
	 * @param noticeUsers批量增加用戶
	 */
	int batchSaveNoticeUsers(List<NoticeUsers> noticeUsers);
	/** 
	 * 获取当前用户的通知信息
	 * @param Pager
	 * @return
	 */
	PagingResult<NoticeUsers> getCurrentUserNotices(Pager<NoticeUsers> pager);
	
	/**
	 * 获取当前用户通知信息
	 * @return
	 */
	List<NoticeUsers> getCurrentUserNotices();
	
	/**
	 * 收藏通知信息
	 * @param ids
	 * @return
	 */
	int collection(Long ids[]);
    
    /**
     * 修改已读未读状态
     *       
     */
    int updateStatus(Long id);
    
    int removeUsers(Long noticeId);
    
    int removeUsers(Long[] noticeIds);
    
    /**
     * 构造long型数组
     */
    public Long[] construct(String str);
    
    /**
     * 构造对象数组
     * @param id
     * @return
     */
    public Object[] construct(String str,Object entity);
    
    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
    NoticeUsers getNoticeUsers(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
    int saveNoticeUsers(NoticeUsers noticeUsers);

    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
    int deleteNoticeUsers(NoticeUsers noticeUsers);

    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
    int deleteNoticeUsersByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-04-24 10:32")
    PagingResult<NoticeUsers> findNoticeUsers(Criteria criteria);
}