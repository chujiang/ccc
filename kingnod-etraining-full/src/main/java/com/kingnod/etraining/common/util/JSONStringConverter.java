package com.kingnod.etraining.common.util;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.PropertyNameProcessor;
import net.sf.json.util.JSONUtils;

import org.apache.struts2.util.StrutsTypeConverter;

import com.kingnod.etraining.common.entity.ObjectRelation;

public class JSONStringConverter extends StrutsTypeConverter {

	JsonConfig config = new JsonConfig();

	public JSONStringConverter() {
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
		if (value instanceof String[]) {
			if (((String[]) value).length == 0) {
				return null;
			}
			String value0 = ((String[]) value)[0];
			if (JSONUtils.mayBeJSON(value0)) {//只有符合json格式的字符串才处理
				JSONArray jsonArray = JSONArray.fromObject(((String[]) value)[0]);
				Class objectClass = null;
				if (member instanceof Method) {
					Method method = (Method) member;
					Type[] types = method.getGenericParameterTypes();
					if (null != types && types.length > 0 && types[0] instanceof ParameterizedType) {
						ParameterizedType pType = (ParameterizedType) types[0];
						objectClass = (Class) (pType.getActualTypeArguments()[0]);
					}
				}
				Object result = null;
				if (null != objectClass) {
					result = JSONArray.toCollection(jsonArray, objectClass);
				} else {
					result = JSONArray.toCollection(jsonArray);
				}
				return result;
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
