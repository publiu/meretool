package com.mereking.meretool.service;

import java.util.List;

import com.mereking.meretool.dto.UpdateUserDTO;
import com.mereking.meretool.entity.User;
/**
 * 用户
 * @author mereKing
 *
 */
public interface UserService {
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
	Integer updateUserType(UpdateUserDTO updateUserDTO);

}
