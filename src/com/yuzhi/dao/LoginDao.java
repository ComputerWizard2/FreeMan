package com.yuzhi.dao;

import com.yuzhi.javabean.Person;

public interface LoginDao {
	// 根据id查询用户职员表决定进入什么页面
	public boolean findOneById(Person person);

}
