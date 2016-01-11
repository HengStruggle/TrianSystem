package com.dbDesign.dataBase;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	static {
		try {
			// 读取db.properties文件中的数据库连接信息
			InputStream in = DBHelper.class.getClassLoader()
					.getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(in);

			// 获取数据库连接驱动
			driver = prop.getProperty("driver");
			// 获取数据库连接URL地址
			url = prop.getProperty("url");
			// 获取数据库连接用户名
			username = prop.getProperty("username");
			// 获取数据库连接密码
			password = prop.getProperty("password");

			// 加载数据库驱动
			Class.forName(driver);
			System.out.println("加载驱动成功");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static void release(Connection conn, PreparedStatement ps,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				System.out.println("关闭rs");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
				System.out.println("关闭ps");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				System.out.println("关闭conn");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
