package com.mereking.meretool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mereking.meretool.entity.User;

public interface UserDao {
	
	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	User getByUsername(String username);
	

	/**
	 * 获取所有用户
	 * @return
	 */
	List<User> queryAllUser();
	
	/**
	 * 更新用户状态
	 * @param user
	 * @return
	 */
	Integer updateUserType(@Param("user") User user);
	
}
