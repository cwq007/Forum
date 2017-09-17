package cn.jxau.soft.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxau.soft.dao.AdminDao;
import cn.jxau.soft.domain.Admin;
import cn.jxau.soft.service.AdminService;

@Service(AdminService.SERVICENAME)
public class AdminServiceImpl implements AdminService {
	@Resource(name=AdminDao.SERVICENAME)
	private AdminDao adminDao;
	
	@Override
	public Admin getAdminByLoginUser(String loginUser) {
		return adminDao.getAdminByLoginUser(loginUser);
	}
	
}
