package com.yuzhi.dao;

import com.yuzhi.javabean.Person;

public interface LoginDao {
	// ����id��ѯ�û�ְԱ���������ʲôҳ��
	public boolean findOneById(Person person);

}
