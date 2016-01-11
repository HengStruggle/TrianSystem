package com.dbDesign.service;

import com.dbDesign.Exception.UserExistException;
import com.dbDesign.json.User;

public interface IUserService {

	/**
	 * 提供注册服务
	 * 
	 * @param user
	 * @throws UserExistException
	 */
	boolean registerUser(User user) throws UserExistException;

	/**
	 * 提供登录服务
	 * 
	 * @param userName
	 * @param userPwd
	 * @param userRole
	 * @return
	 */
	User loginUser(String userName, String userPwd, String userRole);

	/**
	 * 提供修改密码功能
	 * 
	 * @param user
	 * @return
	 */
	boolean updateUserPassword(User user);
}
