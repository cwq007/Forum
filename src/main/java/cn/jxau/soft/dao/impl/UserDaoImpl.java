package cn.jxau.soft.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jxau.soft.dao.UserDao;
import cn.jxau.soft.domain.User;

@Repository(UserDao.SERVICENAME)
public class UserDaoImpl extends CommDaoHiberate4Impl<User> implements UserDao {

	@Override
	public User getUserByLoginUser(String loginUser) {
		List<User> users = this.findObjectsByConditionWithNoPage("o.loginUser=?", new String[]{loginUser});
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public User getUserByNickname(String nickname) {
		List<User> users = this.findObjectsByConditionWithNoPage("o.nickname=?", new String[]{nickname});
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
}
