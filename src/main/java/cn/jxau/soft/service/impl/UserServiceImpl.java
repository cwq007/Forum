package cn.jxau.soft.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jxau.soft.dao.UserDao;
import cn.jxau.soft.domain.User;
import cn.jxau.soft.service.UserService;

@Service(UserService.SERVICENAME)
public class UserServiceImpl implements UserService {

	@Resource(name=UserDao.SERVICENAME)
	private UserDao userDao;
	
	@Override
	public User getUserByLoginUser(String loginUser) {
		return userDao.getUserByLoginUser(loginUser);
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public User getUserByNickname(String nickname) {
		return userDao.getUserByNickname(nickname);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}
	
}
