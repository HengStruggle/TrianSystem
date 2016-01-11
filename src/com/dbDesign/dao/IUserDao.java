package com.dbDesign.dao;

import com.dbDesign.json.User;

public interface IUserDao {

	/**
	 * 根据用户名和密码和角色来查找用户
	 * 
	 * @param userName
	 * @param userPwd
	 * @param userRole
	 * @return 查找到的用户
	 */
	User find(String userName, String userPwd, String userRole);

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	boolean add(User user);

	/**
	 * 根据用户名来查找用户
	 * 
	 * @param userName
	 * @return 查找到的用户
	 */
	User find(String userName);

}
