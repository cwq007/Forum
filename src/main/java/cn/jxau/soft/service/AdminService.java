package cn.jxau.soft.service;

import cn.jxau.soft.domain.Admin;

public interface AdminService {
	
	String SERVICENAME = "cn.jxau.soft.service.impl.AdminServiceImpl";
	
	Admin getAdminByLoginUser(String loginUser);
	
}
