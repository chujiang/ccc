package com.kingnod.etraining.common.service;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kingnod.core.extensions.spring.SpringTxTestCase;
import com.kingnod.etraining.common.dao.NoticeDAO;
import com.kingnod.etraining.common.dao.NoticeDAOImpl;
import com.kingnod.etraining.common.entity.Notice;
import com.kingnod.etraining.common.service.impl.NoticeServiceImpl;

public class NoticeServiceTest extends SpringTxTestCase{

	@Autowired
	protected NoticeDAO noticeDAO;
	
	@Autowired
	private NoticeService noticeService;
	
	@Test
	public void testSaveNotice() {
	 Notice notice = new Notice();
	 notice.setId(Long.parseLong("999"));
	 notice.setContent("sss");
	 NoticeDAOImpl noticeDAO = new NoticeDAOImpl();
	 if(noticeDAO!=null){
		 noticeDAO.findAll();
	 }
	
	 }
	@Test
	public void  testSaveNoticeFromConfigBySystem(){
		Map replaceData = new HashMap();
    	replaceData.put("course", "oracle课程");
    	replaceData.put("user", "马旭东");
    	replaceData.put("s_date", "2012-12-12");
    	replaceData.put("e_date", "2015-15-15");
    	String s[]= new String[]{"182"};
        noticeService.saveNoticeFromConfigBySystem(noticeService.NOTICE_TYPE_A_EM, s , "", replaceData,Long.parseLong("77"));
	}
    /**
     * @author maxudong 
     * @param obj
     */
	@Test 
	public void testEntityToMap()throws Exception{
		 Notice notice = new Notice();
		StringBuffer suf= new StringBuffer();
		//通过反射封装ENTITY 为对应Map对象
		Field field[] = notice.getClass().getDeclaredFields() ;
		for(int i=0;i<field.length ;i++){
			suf.append("name :");
			suf.append(field[i].getName());
			suf.append(" ;");
		}
		String str = suf.toString();
		System.out.println(str);
		
	}
}
