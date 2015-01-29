package com.kingnod.etraining.common.ui.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.Lang;
import com.kingnod.core.util.NumberUtils;

/**
 * 表格单元格值计算器,根据指定的数据类型和数据格式计算单元格应该显示的值
 * 
 * @author Sam
 *
 */
public class CellValueCalculator {
	/**
	 * 数据类型,目前只支持num,date,money
	 */
	private String type;
	private String format;
	private Object value;
	public CellValueCalculator(String type, String format, Object value) {
		super();
		this.type = type;
		this.format = format;
		this.value = value;
	}
	
	public Object calculateValue(){
		if (StringUtils.isNotBlank(type)) {
			type = type.toLowerCase();
			if (type.matches("num|number")) {
				if (StringUtils.isNotEmpty(format))
					value = NumberUtils.format(value.toString(), format);
			} else if (type.matches("date|datetime")) {
				if (StringUtils.isNotBlank(format)) {
					if (value instanceof Date) {
						value = DateUtils.format((Date)value, format);
					}else{
						if(null != value){
							value = DateUtils.format(DateUtils.parse(value.toString()), format);
						}
					}
				}
			} else if (type.matches("money")) {
				
			} else if (type.matches("")) {
				
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
//		Lang.println(DateUtils.format(new Date(), "yyyy-MM-dd"));
		Map m = new HashMap();
		Map s  = new HashMap();
		s.put("name", 1111);
		m.put("user", s);
		try {
			Lang.println(BeanUtils.getProperty(m, "user.name"));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
	}
	
}
