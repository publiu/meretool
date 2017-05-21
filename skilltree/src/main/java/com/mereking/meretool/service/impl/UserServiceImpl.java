package com.mereking.meretool.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mereking.meretool.dao.SkillDao;
import com.mereking.meretool.dao.UserDao;
import com.mereking.meretool.dto.InsertSkillDTO;
import com.mereking.meretool.dto.QuerySkillLinkDTO;
import com.mereking.meretool.dto.QuerySkillLinkResultDTO;
import com.mereking.meretool.dto.UpdateSkillDTO;
import com.mereking.meretool.dto.UpdateUserDTO;
import com.mereking.meretool.entity.Skill;
import com.mereking.meretool.entity.User;
import com.mereking.meretool.service.UserService;

/**
 * 用户服务
 * @author mereKing
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	@Override
	public List<User> queryAllUser() {
		return userDao.queryAllUser();
	}

	@Override
	public Integer updateUserType(UpdateUserDTO updateUserDTO) {
		User user = userDao.getByUsername(updateUserDTO.getUsername());
		user.setLastSkillID(updateUserDTO.getLastSkillID());
		user.setLastSkillLayer(updateUserDTO.getLastSkillLayer());
		user.setLastSkillLayerNum(updateUserDTO.getLastSkillLayerNum());
		return userDao.updateUserType(user);
	}
	
	
	
	

}
