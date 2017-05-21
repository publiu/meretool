package com.mereking.meretool.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mereking.meretool.dao.UserDao;
import com.mereking.meretool.entity.User;

@Controller
public class WelcomeAction {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public String welcome() {
		return "redirect:/skill/queryAllSkill";
	}
	
	/**
	 * ID登录
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryUserId")
	@ResponseBody
	public Map<String, Object> queryUserId(String id) {
		Map<String, Object> result = new HashedMap();
		List<User> users = userDao.queryAllUser();
        for (User user : users) {
        	if (id.equals(user.getUsername())) {
            	result.put("errorNo", 0);
            	result.put("errorInfo", "");
            	return result;
            }
        }
        result.put("errorNo", -1);
        result.put("errorInfo", "id错误");
		return result;
	}

}
