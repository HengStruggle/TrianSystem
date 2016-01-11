package com.dbDesign.service.impl;

import com.dbDesign.Exception.UserExistException;
import com.dbDesign.dao.IUserDao;
import com.dbDesign.dao.impl.UserDaoImpl;
import com.dbDesign.json.User;
import com.dbDesign.service.IUserService;

public class UserService implements IUserService {

	private IUserDao userDao = new UserDaoImpl();

	@Override
	public boolean registerUser(User user) throws UserExistException {
		if (userDao.find(user.getUserName()) != null) {
			throw new UserExistException("注册的用户名已存在！");
		}
		return userDao.add(user);
	}

	@Override
	public User loginUser(String userName, String userPwd, String userRole) {
		// TODO Auto-generated method stub
		return userDao.find(userName, userPwd, userRole);
	}

	@Override
	public boolean updateUserPassword(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
