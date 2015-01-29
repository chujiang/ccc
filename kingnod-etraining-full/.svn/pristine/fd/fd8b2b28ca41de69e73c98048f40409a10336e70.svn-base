/**
 * 
 */
package com.kingnod.etraining.exam;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuxiaobin 
 * 集合分组的帮助类
 */
public class SortList<E> {
	
	@SuppressWarnings("unchecked")
	public void Sort(List<E> list, final String method) {
		// 排序
		Collections.sort(list, new Comparator<Object>() {
			public int compare(Object a, Object b) {
				int ret = 0;
				try {
					Method m1 = ((E) a).getClass().getMethod(method, null);
					Method m2 = ((E) b).getClass().getMethod(method, null);
					ret = m1.invoke(((E) a), null).toString()
							.compareTo(m2.invoke(((E) b), null).toString());
				} catch (NoSuchMethodException ne) {
					System.out.println(ne);
				} catch (IllegalAccessException ie) {
					System.out.println(ie);
				} catch (InvocationTargetException it) {
					System.out.println(it);
				}
				return ret;
			}
		});
	}
	
	//按userId排序      
	//SortList<UserInfo> sortList = new SortList<UserInfo>();
	//sortList.Sort(list, "getUserId");
}
