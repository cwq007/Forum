package cn.jxau.soft.service;

import cn.jxau.soft.domain.User;

public interface UserService {

	String SERVICENAME = "cn.jxau.soft.service.impl.UserServiceImpl";
	
	User getUserByLoginUser(String loginUser);
	
	void saveUser(User user);

	User getUserByNickname(String nickname);

	void updateUser(User user);
	
}
