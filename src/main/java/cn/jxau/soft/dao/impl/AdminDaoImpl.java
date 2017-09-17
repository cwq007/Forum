package cn.jxau.soft.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jxau.soft.dao.AdminDao;
import cn.jxau.soft.domain.Admin;

@Repository(AdminDao.SERVICENAME)
public class AdminDaoImpl extends CommDaoHiberate4Impl<Admin> implements AdminDao {

	@Override
	public Admin getAdminByLoginUser(String loginUser) {
		List<Admin> admins = this.findObjectsByConditionWithNoPage("loginUser=?", new String[]{loginUser});
		if (admins != null && admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}
	
}
