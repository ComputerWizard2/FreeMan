package com.yuzhi.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuzhi.dao.LoginDao;
import com.yuzhi.javabean.Person;
import com.yuzhi.util.JDBCPoolUtil;

public class LoginDaoImp implements LoginDao {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	@Override
	public boolean findOneById(Person person) {
		try {
			connection = JDBCPoolUtil.getConn();
			preparedStatement = connection.prepareStatement("select * from login where  aname=? and pwd=? and type=?");

			System.out.println(person.getId());
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getPwd());
			preparedStatement.setString(3, person.getType());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCPoolUtil.closeResource(connection, preparedStatement, resultSet);
		}
		return false;
	}

}
