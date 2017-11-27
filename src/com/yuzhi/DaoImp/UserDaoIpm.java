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
	// �ֽ�connection������Ϊȫ�ֱ���
	private static Connection connection;
	private static PreparedStatement preparedStament;
	private static ResultSet resultset;

	// ���ǿ��Խ�connection �Ķ���Ĵ������ڹ��캯����
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
	 *            �ڼ�ҳ
	 * @param Content��
	 *            һҳ ���ٸ�����
	 * 
	 * @return
	 */
	@Override
	public List<User> selectAllUserByPage(int paseSize, int content) {
		List<User> list = null;
		try {
			int sum = 0;
			// ��ȡ���б��е�����
			preparedStament = connection.prepareStatement("select count(*) from user");
			ResultSet executeQuery = preparedStament.executeQuery();
			if (executeQuery.next()) {
				// �������ѽ�������
				sum = executeQuery.getInt(1);

			}
			// ��ҳ��

			int totalPage = (sum % content == 0 ? sum / content : sum / content + 1);
			// �Ե�ǰ��ҳ�Ž��� �ж����������ǰ�����ҳ����ʱ��͵������ҳ�������С��0��͵�0

			preparedStament = connection.prepareStatement("select * from User limit ?,?");
			if (paseSize > totalPage) {
				paseSize = totalPage;

			} else if (paseSize < 0) {
				paseSize = 0;
			}

			// ����ǰ���������

			int count = paseSize * content;
			preparedStament.setInt(1, count);
			preparedStament.setInt(2, content);
			resultset = preparedStament.executeQuery();
			// ����һ������
			list = new ArrayList<>();
			while (resultset.next()) {
				// ����һ���û����������ܷ��صĽ��

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
				// ���뼯����
				list.add(user);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ���ؼ���
		return list;
	}

	@Override
	public User findOneById() {
		// TODO Auto-generated method stub
		return null;
	}

}
