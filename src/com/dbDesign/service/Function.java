package com.dbDesign.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbDesign.dataBase.DBHelper;

public class Function {

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	/**
	 * 注册
	 * 
	 * @param userid
	 *            注册游客的用户名
	 * @param password
	 *            注册游客的密码
	 * @return true:注册成功。 false:注册失败，用户重复
	 */
	public boolean logon(String userid, String password) {
		boolean state = true;

		String sql = "select * from user where userid LIKE "
				+ addQuot(userid.trim());
		try {
			conn = DBHelper.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("当前用户名已被注册");
				state = false;
			} else {
				sql = "insert into user values(" + addQuot(userid.trim()) + ","
						+ addQuot(password.trim()) + "," + addQuot("quest")
						+ ")";
				conn.prepareStatement(sql).executeUpdate();
				System.out.println("注册成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return state;
	}

	/**
	 * 登录
	 * 
	 * @param userid
	 *            登录的用户名
	 * @param password
	 *            登陆的密码
	 * @param role
	 *            登录用户的角色：admin：管理员 guest: 游客
	 * @return 错误码 0：登录成功；1：用户不存在；2：密码错误
	 */
	public short login(String userid, String password, String role) {
		short state = 0;

		String sql = "select * from user where userid = " + addQuot(userid)
				+ "and role=" + addQuot(role);
		try {
			conn = DBHelper.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				sql = "select * from user where userid = " + addQuot(userid)
						+ "and password=" + addQuot(password) + "and role="
						+ addQuot(role);
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("登录成功");
				} else {
					state = 2;
					System.out.println("密码错误，请重新输入");
				}
			} else {
				state = 1;
				System.out.println("系统无当前用户");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return state;
	}

	public String addQuot(String str) {
		return "\"" + str + "\"";
	}
}
