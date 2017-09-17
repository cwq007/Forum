package cn.jxau.soft.utils;

import java.lang.reflect.ParameterizedType;

public class GerenicClassUtils {
	
	/**
	 * 获取父类上的泛型类型
	 * @param clazz
	 * @return
	 */
	public static Class<?> getSuperGerenicArg(Class<?> clazz) {
		ParameterizedType genericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();
		Class<?> c = (Class<?>) genericSuperclass.getActualTypeArguments()[0];
		return c;
	}

}
