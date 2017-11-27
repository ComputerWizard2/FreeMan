package com.yuzhi.dao;

import java.util.List;

import com.yuzhi.javabean.User;

public interface UserDao {
	// 根据用户的id删除用户的的数据
	public boolean deleteUser(int id);

	// 根据用户的情况更新用户的工资
	public boolean updataUser(User user);

	// 分页查询所有的工资,并返回一个集合
	public List<User> selectAllUserByPage(int paseSize, int Content);

	// 根据id号查询用户并且返回用户的对象
	public User findOneById();

}
