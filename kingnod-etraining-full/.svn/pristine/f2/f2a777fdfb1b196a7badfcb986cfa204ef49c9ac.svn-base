package com.kingnod.etraining.common.service.impl;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.TemplateUtils;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.dao.NoticeConfigDAO;
import com.kingnod.etraining.common.dao.NoticeDAO;
import com.kingnod.etraining.common.dao.NoticeSettingsDAO;
import com.kingnod.etraining.common.dao.NoticeUsersDAO;
import com.kingnod.etraining.common.entity.Notice;
import com.kingnod.etraining.common.entity.NoticeConfig;
import com.kingnod.etraining.common.entity.NoticeSettings;
import com.kingnod.etraining.common.entity.NoticeUsers;
import com.kingnod.etraining.common.service.NoticeService;
import com.kingnod.etraining.common.service.NoticeUsersService;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.entity.User;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@org.springframework.stereotype.Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	protected NoticeDAO noticeDAO;
	
	@Autowired
	protected UserDAO userDao;

	@Autowired
	protected NoticeUsersDAO noticeUsersDAO;

	@Autowired
	protected NoticeUsersService noticeUsersService;

	@Autowired
	protected NoticeConfigDAO noticeConfigDAO;

	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Autowired
	private NoticeSettingsDAO noticeSettingsDao;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public Notice getNotice(Long id) {
		return noticeDAO.get(id);
	}

	public int saveNotice(Notice notice) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) notice;
		if (null != idEntity.getId() && null != noticeDAO.get(idEntity.getId())) {
			count = noticeDAO.update(notice);
		} else {
			count = noticeDAO.insert(notice);
		}
		return count;
	}

	public int deleteNotice(Notice notice) {
		
		int count = noticeDAO.deleteById(notice.getId());
		 if(count>0) {
			 noticeUsersService.removeUsers(notice.getId());
		 }
		return count;
	}

	public int deleteNoticeByIds(Long[] ids) {
		int count = noticeDAO.deleteById(ids);
		 if(count>0) {
			 noticeUsersService.removeUsers(ids);
		 }
		return count;
	}

	public PagingResult<Notice> findNotice(Criteria criteria) {
		return noticeDAO.findPagingResult(criteria);
	}

	/**
	 * 
	 * @author a 增加系统通知接口
	 */
	public int saveNoticeBySystem(Notice notice, String[] usersId) {
		  logger.debug("** saveNoticeBySystem(Notice notice, String[] usersId)  所以数据准备完成，系统通知发送 主入口  begin **************");
		int count = 0;
		NoticeUsers noticeUser;		
		notice.setCreatorId(CommonConstant.SYS_MAINT_USER_ID);
		notice.setUpdaterId(CommonConstant.SYS_MAINT_USER_ID);
		if (noticeDAO.insert(notice) > 0) {
			List noticeUserList = new ArrayList<NoticeUsers>();
			for (String userid : usersId) {
				noticeUser = new NoticeUsers();
				noticeUser.setUserId(Long.parseLong(userid));
				noticeUser.setNoticeId(notice.getId());
				noticeUser.setStatus("0");
				noticeUser.setCreatorId(CommonConstant.SYS_MAINT_USER_ID);
				noticeUser.setUpdaterId(CommonConstant.SYS_MAINT_USER_ID);
				noticeUserList.add(noticeUser);
			}
			count = noticeUsersDAO.insert(noticeUserList);
		}
		  logger.debug("**saveNoticeBySystem(Notice notice, String[] usersId)   系统通知发送完毕  end **************");
		return count;
	}
	/**
	 * 
	 * @author a 增加系统通知接口
	 */
	public int saveNoticeByUser(Notice notice, String[] usersId) {
		logger.debug("** saveNoticeBySystem(Notice notice, String[] usersId)  所以数据准备完成，系统通知发送 主入口  begin **************");
		int count = 0;
		NoticeUsers noticeUser;
		if (noticeDAO.insert(notice) > 0) {
			List noticeUserList = new ArrayList<NoticeUsers>();
			for (String userid : usersId) {
				noticeUser = new NoticeUsers();
				noticeUser.setUserId(Long.parseLong(userid));
				noticeUser.setNoticeId(notice.getId());
				noticeUser.setStatus("0");
				noticeUserList.add(noticeUser);
			}
			count = noticeUsersDAO.insert(noticeUserList);
		}
		logger.debug("**saveNoticeBySystem(Notice notice, String[] usersId)   系统通知发送完毕  end **************");
		return count;
	}

	/**
	 * 
	 * @author a 增加系统通知接口
	 */

	public int saveNoticeBySystem(Notice notice, String userId) {
		int count = 0;
		NoticeUsers noticeUser;
		if (noticeDAO.insert(notice) > 0) {
			noticeUser = new NoticeUsers();
			noticeUser.setUserId(Long.parseLong(userId));
			noticeUser.setNoticeId(notice.getId());
			noticeUser.setStatus("0");
			count = noticeUsersDAO.insert(noticeUser);
		}
		return count;
	}

	/**
	 * 
	 * @author a 增加系统通知接口
	 */

	public int saveNoticeBySystem(Notice notice, List<NoticeUsers> userList) {
		
		if(notice == null) return 0;
		
		int count = 0;
		NoticeUsers noticeUser;
		
		if (noticeDAO.insert(notice) > 0) {
			count = noticeUsersDAO.insert(userList);
		}
		return count;
	}

	/**
	 * 
	 * @author a 增加系统通知接口 主要完成静态信息发送
	 */

	public int saveNoticeFromConfigBySystem(String NoticeConfigType, String userId, String title, String contnet, Long siteId) {
		
		logger.debug("*****  save Notice From Config BySystem   begin  ***************");
		
		int count = 0;
		CriteriaBuilder cb = Cnd.builder(NoticeConfig.class);
		NoticeConfig noticeConfig = null;
		Notice notice = new Notice();
		cb.andEQ("siteId", siteId);
		cb.andEQ("noticeType", NoticeConfigType);
		if (!StringUtils.isEmpty(title) && !StringUtils.isEmpty(contnet)) {
			notice.setContent(contnet);
			notice.setTitle(title);
		} else {
			List noticeConfigList = noticeConfigDAO.findByCriteria(cb.buildCriteria());
			if (noticeConfigList.size() > 0) {
				noticeConfig = (NoticeConfig) noticeConfigList.get(0);
				notice.setContent(noticeConfig.getContent());
				notice.setTitle(noticeConfig.getTitle());
			}
			if (!StringUtils.isEmpty(title)) {
				notice.setTitle(noticeConfig.getTitle());
			}
			if (!StringUtils.isEmpty(contnet)) {
				notice.setContent(contnet);
			}
		}
		logger.debug("*****saveNoticeFromConfigBySystem   ：    开始保存通知信息***************");
		if (noticeDAO.insert(notice) > 0) {
			NoticeUsers noticeUser;
			noticeUser = new NoticeUsers();
			noticeUser.setUserId(Long.parseLong(userId));
			noticeUser.setNoticeId(notice.getId());
			noticeUser.setStatus("0");
			if (noticeUsersDAO.insert(noticeUser) > 0) {
				count = 1;
			}
		}
		logger.debug("*****saveNoticeFromConfigBySystem   ：  保存信息完毕          ***************");
		logger.debug("*****  save Notice From Config BySystem   end  ***************");
		return count;
	}

	/**
	 * 完成自定义模板发送
	 */
	public int saveNoticeFromConfigBySystem(String NoticeConfigType, String[] userId, String title, Map dataMap, Long siteId) {
		logger.debug("***** saveNoticeFromConfigBySystem(String NoticeConfigType, String[] userId, String title, Map dataMap, Long siteId)   开始执行  ******");
		int count = 0;
		NoticeUsers noticeUser;
		Notice notice = initNoticeByConfig(NoticeConfigType, siteId, dataMap);
		if (notice != null) {
			if (noticeDAO.insert(notice) > 0) {
				List<NoticeUsers> noticeUserList = new ArrayList<NoticeUsers>();
				for (String userid : userId) {
					noticeUser = new NoticeUsers();
					noticeUser.setUserId(Long.parseLong(userid));
					noticeUser.setNoticeId(notice.getId());
					noticeUser.setStatus("0");
					noticeUserList.add(noticeUser);
				}
				count = noticeUsersDAO.insert(noticeUserList);

			}
		}
		 else {
			// 模板未找到异常信息
		    logger.error("*****模板未找，请检查改站点是否由模板信息 ******");
			throw Exceptions.createAppException("send_notice_auto_0011");
			
		}
		logger.debug("*****saveNoticeFromConfigBySystem(String NoticeConfigType, String[] userId, String title, Map dataMap, Long siteId) 执行完毕  ******");
		return count;
	}
	/**
	 * 完成从模板设置发送通知
	 */
	public int saveNoticeFromSettingsBySystem(ObjectType objectType , Long ObjectId, NoticeType  noticeType , Long siteId , List<User> listUser ,Map dataMap) {
	 	
		logger.debug("*****saveNoticeFromSettingsBySystem  List<User> listUser  从通知设置 中发送邮件和通知   ***************");
	 	
		//获得实例通知设置
		NoticeSettings noticeSettings =initNoticeSettings(objectType,ObjectId,noticeType,siteId);
		int count = 0;
		if(noticeSettings != null) {
			
		
		String status ="OUT";     //暂时定义一个状态，以后完善接口，发送通知时可以从 noticesSettings 读取用户， 也可以自己传用户User，也可同时送setting和 user 
		if(!StringUtils.isEmpty(status) && "OUT".equals(status)){
			//暂时保留
		}
		else{
			String receivers = noticeSettings.getReceivers();
		   if(StringUtils.isEmpty(receivers)) return 0;
		}
	  
		//初始化通知设置的发送模板 noticeConfig 信息,并返回要发送的通知信息
		dataMap.put("sendDate", getCurrentDate());  //加入当前时间
		
		Notice notice = initNoticeByConfig(noticeSettings.getNoticeConfigType(), siteId, dataMap);
		
		if (notice != null) {
			if(!StringUtils.isEmpty(noticeSettings.getSendType()) )
				for(String sendType :noticeSettings.getSendType().split(",") ){ //获取通知发送类型
					if("S".equals(sendType.trim()) ) {
						count =   saveNoticeBySystem(notice,constructUserIds(listUser));
						continue;
					} 
					if("E".equals(sendType.trim()) ) {
						 sendNoticeMailBySystem(notice,constructUserEmail(listUser));
					
						}
					
				}
			//目前先返回去一个值吧
		
			
		}
		else {
			  logger.error("*****saveNoticeFromSettingsBySystem  List<User> listUser  未发现通知模板***************");
			// 模板未找到异常信息
			throw Exceptions.createAppException("send_notice_auto_0011");
		}
	}
	 else{
		  logger.debug("*****saveNoticeFromSettingsBySystem  List<User> listUser  未发现通知设置信息***************");
		 }
	return count;
	}
	/**
	 * @author maxudong
	 * @since简单从通知设置中发送邮件和通知
	 * @param ObjectType  objectType
	 * @param Long  ObjectId
	 * @param NoticeType noticeType
	 * @param Long  siteId
	 * @param Map  dataMap
	 */
    public int saveNoticeFromSettingsBySystem(ObjectType objectType,Long ObjectId,NoticeType  noticeType , Long siteId ,Map dataMap) {
    	logger.debug("*****saveNoticeFromSettingsBySystem   从通知设置 中发送邮件和通知  ***************");
		
		//获得实例通知设置
		NoticeSettings noticeSettings =initNoticeSettings(objectType,ObjectId,noticeType,siteId);
		int count = 0;
		if(noticeSettings != null) {
		
		logger.debug("*****saveNoticeFromSettingsBySystem   发现noticeSettings 信息  :"+noticeSettings.getId()+"  ***************");
		
		String receivers = noticeSettings.getReceivers(); //获取通知设置的发送用户
		
		if(StringUtils.isEmpty(receivers)){
			logger.error("*****saveNoticeFromSettingsBySystem   error  未发现接收人员信息   :"+receivers+"  ***************"); 
			throw Exceptions.createAppException("send_notice_auto_0011");
		}
		String users[]  = receivers.split(",");
	  
		//初始化通知设置的发送模板 noticeConfig 信息,并返回要发送的通知信息
		dataMap.put("sendDate", getCurrentDate());  //加入当前时间
		
		Notice notice = initNoticeByConfig(noticeSettings.getNoticeConfigType(), siteId, dataMap);
		
		NoticeUsers noticeUser;
		
		if (notice != null) {
			if(!StringUtils.isEmpty(noticeSettings.getSendType()) )
				for(String sendType :noticeSettings.getSendType().split(",") ){ //获取通知发送类型
					if("E".equals(sendType.trim()) ) {
						sendNoticeMailBySystem(notice,constructUserEmail(users));
							continue;
						}
					if("S".equals(sendType.trim()) ) {
						count =   saveNoticeBySystem(notice,users);
					} 
				}
			//目前先返回去一个值吧
		
			
		}
		else {
			 logger.error("*****saveNoticeFromSettingsBySystem   error  未发现模板信息    ***************"); 
			// 模板未找到异常信息
			throw Exceptions.createAppException("send_notice_auto_0011");
		}
	}else{
		
	}
	 	logger.debug("*****saveNoticeFromSettingsBySystem   从通知设置 中发送邮件和通知   end ***************");
		return count;
	}
	/**
	 * 发送邮件
	 * 群发
	 * @param task
	 */
	public void sendNoticeMailBySystem(String NoticeConfigType, String[] receiver, Long siteId, Map dataMap) {

		// 初始化通知从模板
		Notice notice = initNoticeByConfig(NoticeConfigType, siteId, dataMap);
		if (notice != null) {
		//	String sender = "maxudong@kingnode.com";
			
			MimeMessage msg = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
				helper.setTo(receiver);
				helper.setFrom(mailSender.getUsername());
				helper.setSubject(notice.getTitle());
				helper.setText(notice.getContent(), true);
				mailSender.send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @param task
	 */
	public void sendNoticeMailBySystem(String NoticeConfigType, String receiver, Long siteId, Map dataMap) {
		
		// 初始化通知从模板
		Notice notice = initNoticeByConfig(NoticeConfigType, siteId, dataMap);
		if (notice != null) {
			//String sender = "maxudong@kingnode.com";
			MimeMessage msg = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
				helper.setTo(receiver);
				helper.setFrom(mailSender.getUsername());
				helper.setSubject(notice.getTitle());
				helper.setText(notice.getContent(), true);
				mailSender.send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
 /**
  * 发送邮件，按实体数据发送
  * @author a
  * @param Entity
  * @param NoticeConfigType
  * @param receiver
  * @param receiver
  */
	public void sendNoticeMailBySystem(String NoticeConfigType, String receiver, Long siteId, Object Entity) {
		
		logger.debug("*****sendNoticeMailBySystem(String NoticeConfigType, String receiver, Long siteId, Object Entity) 进入邮件发送主方法    begin ***************");
		Map dataMap =entityToMap(Entity);
	
		// 模板替换参数出现异常信息
		if(dataMap ==null)  {
			throw Exceptions.createAppException("send_notice_auto_0010");
		}
		// 初始化通知从模板
		Notice notice = initNoticeByConfig(NoticeConfigType, siteId, dataMap);
		if (notice != null) {
			//String sender = "maxudong@kingnode.com";
			MimeMessage msg = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
				helper.setTo(receiver);
				helper.setFrom(mailSender.getUsername());
				helper.setSubject(notice.getTitle());
				helper.setText(notice.getContent(), true);
				mailSender.send(msg);
			} catch (Exception e) {
				logger.error("*****sendNoticeMailBySystem 邮件发送主方法 出现错误  :"+e.getMessage()+" ***************");
				logger.error("*****sendNoticeMailBySystem 邮件接收人地址 :"+ receiver.toString()+" ***************");
				logger.error("*****sendNoticeMailBySystem 邮件发送人地址 :"+ mailSender.getUsername()+" ***************");
				e.printStackTrace();
			}
		}
		logger.debug("*****sendNoticeMailBySystem(String NoticeConfigType, String receiver, Long siteId, Object Entity) 邮件发送主方法结束  end ***************");
		
	}
  /**
   * 发送邮件通知重实体发送
   * @param notice
   * @param receiver
   */
	public void sendNoticeMailBySystem(Notice notice,String[] receiver){
		logger.debug("*****sendNoticeMailBySystem(Notice notice,String[] receiver) 进入邮件发送主方法    begin ***************");
		if (notice != null && receiver != null) {
			//String sender = "maxudong@kingnode.com";
			MimeMessage msg = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
				helper.setTo(receiver);
				helper.setFrom(mailSender.getUsername());
				helper.setSubject(notice.getTitle());
				helper.setText(notice.getContent(), true);
				mailSender.send(msg);
			} catch (Exception e) {
				logger.error("*****sendNoticeMailBySystem 邮件发送主方法 出现错误  :"+e.getMessage()+" ***************");
				logger.error("*****sendNoticeMailBySystem 邮件接收人地址 :"+ receiver.toString()+" ***************");
				logger.error("*****sendNoticeMailBySystem 邮件发送人地址 :"+ mailSender.getUsername()+" ***************");
				e.printStackTrace();
			}
		}
		logger.debug("*****sendNoticeMailBySystem(Notice notice,String[] receiver) 邮件发送主方法结束    end ***************");
	}
	/**
	 * 初始化模板数据
	 * 主要方法
	 * @param NoticeConfigType
	 * @param siteId
	 * @param replaceData
	 * @return
	 */
	public Notice initNoticeByConfig(String NoticeConfigType, Long siteId, Map dataMap) {
		logger.debug("*****initNoticeByConfig 进入从模板初始化通知方法    begin ***************");
		
		NoticeConfig noticeConfig = null;
		Notice notice = null;
		CriteriaBuilder cb = Cnd.builder(NoticeConfig.class);
		cb.andEQ("siteId", siteId).andEQ("noticeType", NoticeConfigType).orEQ("siteId", CommonConstant.ROOT_SITE_ID).andEQ("noticeType", NoticeConfigType);

		List<NoticeConfig> noticeConfigList = noticeConfigDAO.findByCriteriaWithdClob(cb.buildCriteria());
		if (noticeConfigList.size() > 0) {
			logger.debug("*****initNoticeByConfig  发现模板并装配        ***************");
			notice = new Notice();
			noticeConfig = (NoticeConfig) noticeConfigList.get(0);
			// 替换模板中内容
			try {
                String content =noticeConfig.getContent().replace("&lt;", "<").replace("&gt;", ">");
				notice.setContent(TemplateUtils.render(content, dataMap));
				if(StringUtils.isEmpty(notice.getContent())){
					logger.error("*****initNoticeByConfig  装配模板时出现异常，请检查模板配置想于dataMap 对应信息        ***************");
					throw Exceptions.createAppException("send_notice_auto_0010");
				}
			} catch (Exception ex) {
			
				// 模板替换参数出现异常信息
				logger.error("*****initNoticeByConfig  装配模板时出现异常，请检查模板配置想于dataMap 对应信息       :"+ex.getMessage() + "***************");
				
				throw Exceptions.createAppException("send_notice_auto_0010");

			}
			notice.setTitle(noticeConfig.getTitle());
		}
		return notice;
	}

	/**
	 * 实体类转换为map 
	 * 
	 * @param obj
	 * @return
	 */
	public Map entityToMap(Object Entity) {
		
		logger.debug("*****entityToMap  将实体转换为 map       begin ***************");
		
		Map map = null;
		if (Entity != null) {
			map = new HashMap<String, Object>();

			Field field[] = Entity.getClass().getDeclaredFields();

			for (Field fd : field) {
				try {
					fd.setAccessible(true);
					map.put(fd.getName(), fd.get(Entity));

				} catch (IllegalArgumentException e) {
					e.printStackTrace();

				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}

		}
		if(!map.isEmpty()) {
		   Date  date= new Date(); 
		  
		   DateFormat d1 = DateFormat.getDateInstance();
		   
		   String de =  d1.format(date);
		   
		   map.put("sendDate",de);
		}
		else {
			map =null ;
		}

		logger.debug("*****entityToMap  将实体转换为 map       end***************");
		return map;
	}
	/**
	 * 获取设置NticeSettings entity
	 */
	public NoticeSettings initNoticeSettings(ObjectType objectType ,Long objectId ,NoticeType noticeType ,Long siteId){
		
		logger.debug("*****initNoticeSettings  初始化  模板设置信息      begin***************");
		
		NoticeSettings noticeSettings = null ;
		
		CriteriaBuilder cb = Cnd.builder(NoticeSettings.class);
		cb.andEQ("siteId", siteId);
		cb.andEQ("objectType", objectType);
		cb.andEQ("noticeConfigType", noticeType);
		cb.andEQ("objectId", objectId);
		cb.andEQ("status","1");

		List noticeSettingsList = noticeSettingsDao.findByCriteria(cb.buildCriteria());
		if (noticeSettingsList.size() > 0) {
			noticeSettings = (NoticeSettings)noticeSettingsList.get(0);
		}
		logger.debug("*****initNoticeSettings  初始化  模板设置信息     end***************");
		return noticeSettings;
		
	}
	
	/**
	 * 查询实例通知设置是否开启
	 */
	
	public int getNoticeSettingsStatus(ObjectType objectType ,NoticeType noticeType,Long objectId ,Long siteId){
		logger.debug("*****getNoticeSettingsStatus 查询实例通知设置是否开启     begin***************");
		int count =0 ;
		CriteriaBuilder cb = Cnd.builder(NoticeSettings.class);
		cb.andEQ("siteId", siteId);
		cb.andEQ("objectType", objectType);
		cb.andEQ("noticeConfigType", noticeType);
		cb.andEQ("objectId", objectId);
		cb.andEQ("status","1");
		count =  noticeSettingsDao.countByCriteria(cb.buildCriteria());
		logger.debug("*****getNoticeSettingsStatus 查询实例通知设置是否开启     end *************** result ： "+count+" ********");
		return count ;
	}
	
	 /**
	 *通过用户id 获得用户邮件信息 
	 */
	public String[] constructUserEmail(String[] userIds){
		logger.debug("*****constructUserEmail(userIds)  获取用户邮件信息     begin***************");
		CriteriaBuilder cb = Cnd.builder(User.class);
		for(String userId :userIds){
			cb.orEQ("id", userId);
		}
		List<User> userList = userDao.findByCriteria(cb.buildCriteria());
		StringBuffer buf = new StringBuffer();
		for(User user : userList){
			if(!StringUtils.isEmpty(user.getEmail())){
				buf.append(user.getEmail());
				buf.append(",");
			}
		  
		}
	    String userEmails = buf.toString();
	    userEmails = userEmails.substring(0,userEmails.length()-1);
		logger.debug("*****constructUserEmail  获取用户邮件信息     end***************");
		return 	userEmails.split(",");
		
	}
	  
	/**
	 *通过传递的List<User> 获取用户的 用户id 获得用户邮件信息 
	 */
	public String[] constructUserEmail(List<User> userList){
		logger.debug("*****constructUserEmail(userList)  获取用户邮件信息     begin***************");
		CriteriaBuilder cb = Cnd.builder(User.class);
		StringBuffer buf = new StringBuffer();
		for(User user : userList){
			if(!StringUtils.isEmpty(user.getEmail())){
				buf.append(user.getEmail());
				buf.append(",");
			}
			
		}
		String  userEmails = buf.toString();
		if(StringUtils.isEmpty(userEmails)) return null;
		userEmails = userEmails.substring(0,userEmails.length()-1);
		logger.debug("*****constructUserEmail  获取用户邮件信息     end***************");
		return 	userEmails.split(",");
		
	}
	
	/**
	 *通过传递的List<User> 获取用户的 用户id 将用户的id封装
	 */
	public String[] constructUserIds(List<User> userList){
		logger.debug("*****constructUserIds  将用户的id封装    begin***************");
		StringBuffer buf = new StringBuffer();
		for(User user : userList){
				buf.append(user.getId());
				buf.append(",");
		}
		String userIds = buf.toString();
		userIds = userIds.substring(0,userIds.length()-1);
		
		logger.debug("*****constructUserIds  将用户的id封装     end***************");
		return 	userIds.split(",");
		
	}
	
	/**
	 
	 * DateUtils
	 * 获得时间
	 * 
	 */
	public String getCurrentDate(){
		   DateFormat d1 = DateFormat.getDateInstance();
		   return d1.format(new Date());
	}

}