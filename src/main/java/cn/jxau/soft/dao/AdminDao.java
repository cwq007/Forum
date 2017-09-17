package cn.jxau.soft.dao;

import cn.jxau.soft.domain.Admin;

public interface AdminDao extends CommonDao<Admin> {
	String SERVICENAME = "cn.jxau.soft.dao.impl.AdminDaoImpl";
	
	Admin getAdminByLoginUser(String loginUser);
	
}
