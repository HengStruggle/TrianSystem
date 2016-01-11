package com.dbDesign.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

import com.dbDesign.dao.IUserDao;
import com.dbDesign.dataBase.DBHelper;
import com.dbDesign.json.User;
import com.dbDesign.util.SqlUtils;

/**
 * IUserDao接口实现类
 * 
 */
public class UserDaoImpl implements IUserDao {

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	@Override
	public User find(String userName) {

		User user = null;
		try {
			conn = DBHelper.getConnection();
			
			String condition = MessageFormat.format(SqlUtils.WHERE_CONDITION, "username",SqlUtils.addQuot(userName));
			String sql = MessageFormat.format(SqlUtils.SELECT_TABLE, "user "+condition);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				String password = rs.getString("password");
				String userRole = rs.getString("role");

				user = new User();
				user.setUserName(userName);
				user.setPassword(password);
				user.setRole(userRole);
				System.out.println(user.toString());
			}
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return user;
	}

	@Override
	public User find(String userName, String userPwd, String userRole) {

		User user = null;
		try {
			conn = DBHelper.getConnection();
			// String sql = "select * from user where userid = "
			// + SqlUtils.addQuot(userName) + "and password="
			// + SqlUtils.addQuot(userPwd) + "and role=" +
			// SqlUtils.addQuot(userRole);

			String contion = MessageFormat.format(SqlUtils.WHERE_CONDITION,
					"username", SqlUtils.addQuot(userName))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "password",
							SqlUtils.addQuot(userPwd))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "role",
							SqlUtils.addQuot(userRole));
			String sql = MessageFormat.format(SqlUtils.SELECT_TABLE, "user"
					+ contion);

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserName(userName);
				user.setPassword(userPwd);
				user.setRole(userRole);
				System.out.println("登录成功");
			}
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return user;

	}

	@Override
	public boolean add(User user) {

		boolean state = false;

		try {
			conn = DBHelper.getConnection();
			
			String newValue =  SqlUtils.addQuot(user.getUserName())
					+MessageFormat.format(SqlUtils.COMMA_VALUE, SqlUtils.addQuot(user.getPassword()))
					+MessageFormat.format(SqlUtils.COMMA_VALUE, SqlUtils.addQuot(user.getRole()));
			String sql = MessageFormat.format(SqlUtils.INSERT_TABLE, "user",newValue);
			
			int i = conn.prepareStatement(sql).executeUpdate();
			if (i > 0) {
				state = true;
				System.out.println("注册成功");
			}

		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return state;
	};

}
