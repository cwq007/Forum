package cn.jxau.soft.dao;

import cn.jxau.soft.domain.User;

public interface UserDao extends CommonDao<User> {
	
	String SERVICENAME = "cn.jxau.soft.dao.impl.UserDaoImpl";
	
	User getUserByLoginUser(String loginUser);
	
	User getUserByNickname(String nickname);
	
}
