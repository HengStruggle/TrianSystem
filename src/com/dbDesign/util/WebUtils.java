package com.dbDesign.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 把request对象中的请求参数封装到bean中
 * 
 */
public class WebUtils {

	/**
	 * 将request对象封装成T对象
	 * 
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T requestToBean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			Enumeration<String> e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
