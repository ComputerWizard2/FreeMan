package com.yuzhi.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCPoolUtil {
	// 1.声明DataSource对象
	private static BasicDataSource datasource = null;

	static {
		// 创建Properties对象
		Properties properties = new Properties();
		try {
			// JDBCPoolUtil.class.getClassLoader() 类加载器就会定位到 项目的 根目录
			// System.out.println(JDBCPoolUtil.class.getClassLoader().getResource("jdbc.properties"));
			properties.load(JDBCPoolUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			// 创建
			datasource = new BasicDataSource();

			String driver = properties.getProperty("driver");
			// System.out.println(driver);
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String initSize = properties.getProperty("initSize");
			String maxIdle = properties.getProperty("maxIdle");
			String minIdle = properties.getProperty("minIdle");
			String maxActive = properties.getProperty("maxActive");
			String maxWait = properties.getProperty("maxWait");
			// System.out.println(maxWait);

			if (driver != null && !"".equals(driver)) {
				datasource.setDriverClassName(driver);
			}
			if (url != null && !"".equals(url)) {
				datasource.setUrl(url);
			}
			if (username != null && !"".equals(username)) {
				datasource.setUsername(username);
			}
			if (password != null && !"".equals(password)) {
				datasource.setPassword(password);
			}
			if (initSize != null && !"".equals(initSize)) {
				datasource.setInitialSize(Integer.parseInt(initSize));
			}
			if (maxIdle != null && !"".equals(maxIdle)) {
				datasource.setMaxIdle(Integer.parseInt(maxIdle));
			}
			if (minIdle != null && !"".equals(minIdle)) {
				datasource.setMinIdle(Integer.parseInt(minIdle));
			}
			if (maxActive != null && !"".equals(maxActive)) {
				datasource.setMaxActive(Integer.parseInt(maxActive));
			}
			if (maxWait != null && !"".equals(maxWait)) {
				datasource.setMaxWait(Long.parseLong(maxWait));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取
	public static Connection getConn() throws SQLException {
		return datasource.getConnection();
	}

	// 关闭资源
	public static void closeResource(Connection conn, Statement stat, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getConn());
	}
}
