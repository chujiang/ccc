package com.kingnod.etraining.common.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.Notice;
import com.kingnod.etraining.common.entity.NoticeUsers;
import com.kingnod.etraining.organization.entity.User;

import java.util.List;
import java.util.Map;

@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
public interface NoticeService {

	final static String NOTICE_TYPE_A_EM = "A_EM";
	final static String NOTICE_TYPE_A_PM = "A_PM";
	final static String NOTICE_TYPE_A_XM = "A_XM";
	final static String NOTICE_TYPE_A_REG = "SYS_REGISTER";
	final static String NOTICE_TYPE_A_USER_GROUP = "O_UG_CHANGE";

	/**
	 * @author a 增加系统通知接口
	 */
	int saveNoticeBySystem(Notice notice, String[] users);

	/**
	 * @author a 增加系统通知接口
	 */
	int saveNoticeBySystem(Notice notice, String userId);
	/**
	 * @author a 增加用户发送通知接口
	 */
	public int saveNoticeByUser(Notice notice, String[] usersId) ;

	/**
	 * @author a 增加系统通知接口
	 */
	int saveNoticeBySystem(Notice notice, List<NoticeUsers> userList);

	/**
	 * @author a
	 * @param NoticeConfigType 模板类型（学习、考试等）
	 * @param userId 通知接收人
	 * @param title 通知标题
	 * @param replaceData 模板内容动态替换数据
	 * @since 增加系统通知接口，调用自定义模板
	 */
	int saveNoticeFromConfigBySystem(String NoticeConfigType, String[] userId,
			String title, Map replaceData,Long siteId);
	/**
	 * 发送邮件通知，自定义数据
	 * @param id
	 * @return
	 */
	void sendNoticeMailBySystem(String NoticeConfigType, String[] receiver ,Long siteId ,Map replaceData);
	/**
	 * 发送邮件通知，选用实体类为数据
	 * @param NoticeConfigType
	 * @param receiver
	 * @param siteId
	 * @param Entity
	 */
	 void sendNoticeMailBySystem(String NoticeConfigType, String receiver, Long siteId, Object Entity);
	
	/**
	 * 发送系统通知从通知设置中保存
	 * @param objectType //对应功能模板
	 * @param ObjectId   //对应实例id
	 * @param siteId     //siteId
	 * @param dataMap   //数据Map
	 * 
	 * @return
	 */
	 public int saveNoticeFromSettingsBySystem(ObjectType objectType , Long ObjectId,NoticeType  noticeType,  Long siteId ,Map dataMap);
	 /**
	  * 发送系统通知从通知设置中保存
	  * @param objectType //对应功能模板
	  * @param ObjectId   //对应实例id
	  * @param siteId     //siteId
	  * @param dataMap   //数据Map
	  * 
	  * @return
	  */
	 public int saveNoticeFromSettingsBySystem(ObjectType objectType , Long ObjectId,NoticeType  noticeType,Long siteId ,List<User> listUser ,Map dataMap);
	 
	 /**
	  * 查看noticeSettings 状态 是否启用
	  * @param id
	  * @return
	  */
	public int getNoticeSettingsStatus(ObjectType objectType ,NoticeType noticeType,Long objectId ,Long siteId);
	 
	@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	Notice getNotice(Long id);

	@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	int saveNotice(Notice notice);

	@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	int deleteNotice(Notice notice);

	@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	int deleteNoticeByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	PagingResult<Notice> findNotice(Criteria criteria);
}