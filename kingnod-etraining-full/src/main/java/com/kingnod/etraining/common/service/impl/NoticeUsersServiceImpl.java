package com.kingnod.etraining.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.extensions.struts2.util.ServiceInvoker;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.ArrayUtils;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.StringUtils;

import com.kingnod.etraining.common.dao.NoticeUsersDAO;
import com.kingnod.etraining.common.entity.NoticeUsers;
import com.kingnod.etraining.common.service.NoticeUsersService;
import com.kingnod.etraining.security.entity.UserAccount;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class NoticeUsersServiceImpl implements NoticeUsersService {

	@Autowired
	protected NoticeUsersDAO noticeUsersDAO;
	
	protected Pager<NoticeUsers> pager ;

	public NoticeUsers getNoticeUsers(Long id) {
		return noticeUsersDAO.get(id);
	}

	public int saveNoticeUsers(NoticeUsers noticeUsers) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) noticeUsers;
		if (null != idEntity.getId()
				&& null != noticeUsersDAO.get(idEntity.getId())) {
			count = noticeUsersDAO.update(noticeUsers);
		} else {
			count = noticeUsersDAO.insert(noticeUsers);
		}
		return count;
	}

	public int deleteNoticeUsers(NoticeUsers noticeUsers) {
		return noticeUsersDAO.delete(noticeUsers);
	}

	public int deleteNoticeUsersByIds(Long[] ids) {
		return noticeUsersDAO.deleteById(ids);
	}

	public PagingResult<NoticeUsers> findNoticeUsers(Criteria criteria) {
		return noticeUsersDAO.findPagingResult(criteria);
	}

	/**
	 * @author a
	 * @param list
	 *            <E> 完成批量插入工作
	 */
	public int batchSaveNoticeUsers(String noticeUsers, long noticeId) {
		String usersIds[] = noticeUsers.split(",");
		NoticeUsers noticeUser;
		int count = 0;
		List noticeUserList = new ArrayList<NoticeUsers>();
		for (String userid : usersIds) {
			noticeUser = new NoticeUsers();
			noticeUser.setUserId(Long.parseLong(userid));
			noticeUser.setNoticeId(noticeId);
			noticeUser.setStatus("0");
			noticeUserList.add(noticeUser);
		}
		count = noticeUsersDAO.insert(noticeUserList);
		return count;
	}

	/**
	 * @author a
	 * @param list
	 *            <E> 完成批量插入工作
	 */
	public int batchSaveNoticeUsers(List<NoticeUsers> noticeUsers) {
		int count = 0;
		count = noticeUsersDAO.insert(noticeUsers);
		return count;
	}
	/**
	 * @获取当前用户所有通知信息
	 * @param Pager
	 * 
	 */
	public PagingResult<NoticeUsers> getCurrentUserNotices(Pager<NoticeUsers> pager) {
		UserAccount userAccount = (UserAccount) SecurityUtils.getCurrentUser();
		CriteriaBuilder cb = Cnd.builder(NoticeUsers.class);
		cb.andEQ("userId", userAccount.getId());
		cb.orderBy("updateDate", Order.DESC);
		cb.orderBy("status", Order.DESC);
		
		if (StringUtils.isNotBlank(pager.getOrderBy()) && StringUtils.isNotBlank(pager.getOrder()))
			cb.orderBy(pager.getOrderBy(),Order.of( pager.getOrder()));
		Criteria criteria = 
			cb.buildCriteria()
				.limit(new Long(pager.getFirst()),(new Long(pager.getLast())));
		
		return noticeUsersDAO.findPagingResult(criteria);
	}
	/**
	 * @获取当前用户所有通知信息 @author maxudong
	 * 
	 */
	public List<NoticeUsers> getCurrentUserNotices() {
	
		pager = new Pager();
		int pageSize = 5;
		pager.setPageSize(pageSize);
		ServiceInvoker	serviceInvoker = new ServiceInvoker(NoticeUsers.class, Long.class);
		UserAccount userAccount = (UserAccount) SecurityUtils.getCurrentUser();
		CriteriaBuilder cb = Cnd.builder(NoticeUsers.class);
		cb.andEQ("userId", userAccount.getId());
		cb.andEQ("recordStatus","A");
		cb.orderBy("status", Order.NONE);
		cb.orderBy("updateDate", Order.DESC);
		if (StringUtils.isNotBlank(pager.getOrderBy()) && StringUtils.isNotBlank(pager.getOrder()))
			cb.orderBy(pager.getOrderBy(),Order.of( pager.getOrder()));
		Criteria criteria = cb.buildCriteria().limit(new Long(pager.getFirst()),(new Long(pager.getLast())));
		List list= noticeUsersDAO.findPagingResult(criteria).getResult();
		return list;
	}
	/**
	 * @author a
	 * @改变用户已读未读状态
	 * 
	 */
	public int updateStatus(Long id){
		int count=0;
		NoticeUsers noticeUser =new NoticeUsers();
		noticeUser.setId(id);
		noticeUser.setStatus("1");
		noticeUsersDAO.update(noticeUser);
		return count;
	}
	/**
	 * @author a
	 * @删除用户通知
	 * 
	 */
	public int removeUsers(Long noticeId){
		int count=0;
		NoticeUsers noticeUser =new NoticeUsers();
		noticeUser.setRecordStatus("I");
		CriteriaBuilder cb = Cnd.builder(NoticeUsers.class);
		cb.andEQ("noticeId", noticeId);
		count =	noticeUsersDAO.updateByCriteria(noticeUser, cb.buildCriteria());
		return count;
	}
	/**
	 * @author a
	 * @删除用户通知
	 * 
	 */
	public int removeUsers(Long[] noticeIds){
		int count=0;
		if(!ArrayUtils.isEmpty(noticeIds)){
		
		NoticeUsers noticeUser =new NoticeUsers();
		noticeUser.setRecordStatus("I");
		CriteriaBuilder cb = Cnd.builder(NoticeUsers.class);
		for(long noticeId: noticeIds){
			cb.orEQ("noticeId",noticeId );
		}
		count =	noticeUsersDAO.updateByCriteria(noticeUser, cb.buildCriteria());   
		}
		return count;
	}
	/**
	 * @author a
	 * @收藏信息
	 * 
	 */
	public int collection(Long ids[]){
		int count=0;
		if(ids!=null&&ids.length>0){
			List list = new ArrayList();
			for (Long id: ids){
				list.add(id);
			}
			NoticeUsers noticeUser =new NoticeUsers();
			noticeUser.setStatus("2");
			CriteriaBuilder cb = Cnd.builder(NoticeUsers.class);
			cb.andIn("id", list);
			count =	noticeUsersDAO.updateByCriteria(noticeUser, cb.buildCriteria());
		}
		return count;
	}
	/**
	 * 逗号字符串转long型数组
	 */
	public Long[] construct(String str){
		String s[] =str.split(",");
		Long longs[] = new Long[s.length];
		for (int i = 0; i < s.length; i++) {
			longs[i] = Long.valueOf(s[i]);
		}
		return longs ;
	}
	/**
	 * 逗号字符串转 对象数组
	 */
	public Object[] construct(String str,Object entity){
	
		String s[] =str.split(",");
		Long longs[] = new Long[s.length];
		for (int i = 0; i < s.length; i++) {
			longs[i] = Long.valueOf(s[i]);
		}
		return null ;
	}
}