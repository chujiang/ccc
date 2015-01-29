package com.kingnod.etraining.common.util;

import java.lang.reflect.Member;
import java.sql.Time;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;
import net.sf.json.processors.PropertyNameProcessor;
import net.sf.json.util.JSONUtils;

import org.apache.struts2.util.StrutsTypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.common.entity.ObjectRelation;


public class PeriodConverter extends StrutsTypeConverter {

	JsonConfig config = new JsonConfig();

	protected Logger logger = LoggerFactory.getLogger(getClass());

	
	public PeriodConverter() {
		config.registerJavaPropertyNameProcessor(ObjectRelation.class, new PropertyNameProcessor() {
			public String processPropertyName(Class beanClass, String name) {
				return null;
			}
		});
		config.registerPropertyExclusions(ObjectRelation.class, new String[] { "id", "object1Type", "object1Id",
				"recordStatus", "updateCount", "creatorId", "createDate", "updaterId", "updateDate" });
	}

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		return null;
	}

	@Override
	public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName,
			Object value, Class toType) {
		if (null == value) {
			return null;
		}
		if (value instanceof com.kingnod.etraining.activity.entity.Period) {
			JsonConfig jsonconfig = new JsonConfig();
	     	jsonconfig.registerJsonBeanProcessor(Period.class, new JsonBeanProcessor(){
				public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
					Period period = (Period)bean;
					JSONObject jsonObj = new JSONObject();
					jsonObj.element("id", period.getId());
					jsonObj.element("periodFlagId", period.getPeriodFlagId());
					jsonObj.element("periodType", period.getPeriodType());
					jsonObj.element("startTime", null!=period.getStartTime()?period.getStartTime().toString():"");
					jsonObj.element("endTime", null!=period.getEndTime()?period.getEndTime().toString():"");
					jsonObj.element("availableDays", period.getAvailableDays());
					jsonObj.element("startDate", com.kingnod.core.util.DateUtils.format(period.getStartDate(), "yyyy-MM-dd"));
					jsonObj.element("endDate", com.kingnod.core.util.DateUtils.format(period.getEndDate(), "yyyy-MM-dd"));
					return jsonObj;
				}});
	     	JSONObject jsonObj = JSONObject.fromObject(value, jsonconfig);
	     	return jsonObj.toString();
		}else if(Period.class.equals(toType)){
			if(null != value && value instanceof String[] && ((String[])value).length > 0 && !("".equals(((String[])value)[0]))){
				JSONUtils.getMorpherRegistry().registerMorpher(new TimeMorpher()); 
				JSONUtils.getMorpherRegistry().registerMorpher(new LongMorpher()); 
				JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd"})); 
				JSONObject jsonObj = JSONObject.fromObject(((String[])value)[0]);
				
				logger.debug("jsonObj_Test-----------" + ((String[])value)[0]);
				
				Period period = new Period();
				if(!StringUtils.isBlank(jsonObj.getString("id")))
				{
					period.setId(jsonObj.getLong("id"));
				}
				if(!StringUtils.isBlank(jsonObj.getString("periodFlagId")))
				{
					period.setPeriodFlagId(Long.parseLong(jsonObj.getString("periodFlagId")));
				}
				period.setPeriodType(jsonObj.getString("periodType"));
				if(!StringUtils.isBlank(jsonObj.getString("startDate")))
				{
					period.setStartDate(com.kingnod.core.util.DateUtils.parse(jsonObj.getString("startDate")));
				}
				if(!StringUtils.isBlank(jsonObj.getString("endDate")))
				{
					period.setEndDate(com.kingnod.core.util.DateUtils.parse(jsonObj.getString("endDate")));
				}
				period.setAvailableDays(jsonObj.getString("availableDays"));
				if(!StringUtils.isBlank(jsonObj.getString("startTime")))
				{
					period.setStartTime(Time.valueOf(jsonObj.getString("startTime")));
				}
				if(!StringUtils.isBlank(jsonObj.getString("endTime")))
				{
					period.setEndTime(Time.valueOf(jsonObj.getString("endTime")));
				}
				
				
				return period;
				//jsonObj.toBean(jsonObj, Period.class);
			}
		}

		return super.convertValue(context, target, member, propertyName, value, toType);		
	}

	@Override
	public String convertToString(Map context, Object o) {
		JSONArray jsonArray = JSONArray.fromObject(o, config);
		return jsonArray.toString();
	}

}
