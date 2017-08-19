package com.mereking.meretool.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(String id, HttpServletRequest request) {
		Map<String, Object> result = new HashedMap();
		User user = userDao.getByUsername(id);
		if (user != null) {
			result.put("errorNo", 0);
        	result.put("errorInfo", "");
        	request.getSession(true).setAttribute("user", user);
		} else {
	        result.put("errorNo", -1);
	        result.put("errorInfo", "id错误");
		}
		return result;
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public Map<String, Object> logout(HttpServletRequest request) {
		Map<String, Object> result = new HashedMap();
		User user = (User)request.getSession().getAttribute("user");
		if (user != null) {
			request.getSession().removeAttribute("user");
		}
        result.put("errorNo", 0);
        result.put("errorInfo", "成功登出");
		return result;
	}
	/**
	 * 检查登录
	 * @return
	 */
	@RequestMapping("/checkLogin")
	@ResponseBody
	public Map<String, Object> checkLogin(HttpServletRequest request) {
		Map<String, Object> result = new HashedMap();
		User user = (User)request.getSession().getAttribute("user");
		if (user != null) {
			result.put("errorNo", 0);
	        result.put("errorInfo", "已登录");
		} else {
	        result.put("errorNo", -1);
	        result.put("errorInfo", "未登录");
		}

		return result;
	}


}
