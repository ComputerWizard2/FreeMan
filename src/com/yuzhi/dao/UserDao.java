package com.yuzhi.dao;

import java.util.List;

import com.yuzhi.javabean.User;

public interface UserDao {
	// �����û���idɾ���û��ĵ�����
	public boolean deleteUser(int id);

	// �����û�����������û��Ĺ���
	public boolean updataUser(User user);

	// ��ҳ��ѯ���еĹ���,������һ������
	public List<User> selectAllUserByPage(int paseSize, int Content);

	// ����id�Ų�ѯ�û����ҷ����û��Ķ���
	public User findOneById();

}
