package com.yuzhi.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuzhi.dao.UserDao;
import com.yuzhi.javabean.User;
import com.yuzhi.util.JDBCPoolUtil;

public class UserDaoIpm implements UserDao {
	// 现将connection对象作为全局变量
	private static Connection connection;
	private static PreparedStatement preparedStament;
	private static ResultSet resultset;

	// 我们可以将connection 的对象的创建放在构造函数里
	public UserDaoIpm() {
		try {
			connection = JDBCPoolUtil.getConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updataUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * @param paseSize:
	 *            第几页
	 * @param Content：
	 *            一页 多少个数据
	 * 
	 * @return
	 */
	@Override
	public List<User> selectAllUserByPage(int paseSize, int content) {
		List<User> list = null;
		try {
			int sum = 0;
			// 获取到列表中的总数
			preparedStament = connection.prepareStatement("select count(*) from user");
			ResultSet executeQuery = preparedStament.executeQuery();
			if (executeQuery.next()) {
				// 总数据已近出来了
				sum = executeQuery.getInt(1);

			}
			// 总页数

			int totalPage = (sum % content == 0 ? sum / content : sum / content + 1);
			// 对当前的页号进行 判断如果超出当前的最大页数的时候就等于最大页数，如果小于0则就等0

			preparedStament = connection.prepareStatement("select * from User limit ?,?");
			if (paseSize > totalPage) {
				paseSize = totalPage;

			} else if (paseSize < 0) {
				paseSize = 0;
			}

			// 在这前面的总数据

			int count = paseSize * content;
			preparedStament.setInt(1, count);
			preparedStament.setInt(2, content);
			resultset = preparedStament.executeQuery();
			// 创建一个集合
			list = new ArrayList<>();
			while (resultset.next()) {
				// 创建一个用户对象来接受反回的结果

				User user = new User();
				user.setId(resultset.getInt(1));
				user.setDate(resultset.getDate(2));
				user.setName(resultset.getString(3));
				user.setJbgz(resultset.getDouble(4));
				user.setGwgz(resultset.getDouble(5));
				user.setYjj(resultset.getDouble(6));
				user.setYlbx(resultset.getDouble(7));
				user.setZfgjj(resultset.getDouble(8));
				user.setYfgz(resultset.getDouble(9));
				// 存入集合中
				list.add(user);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回集合
		return list;
	}

	@Override
	public User findOneById() {
		// TODO Auto-generated method stub
		return null;
	}

}
