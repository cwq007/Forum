package cn.jxau.soft.utils;

import java.util.UUID;

public class ActiveCodeGenerator {
	
	/**
	 * 获取激活码
	 * @return 激活码
	 */
	public String generateActionCode() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
