package com.mereking.meretool.intercepter;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mereking.meretool.dao.UserDao;
import com.mereking.meretool.entity.User;

public class CookieValidate implements HandlerInterceptor{
	@Autowired
	private UserDao userDao;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2) throws Exception {
		String requestUri = request.getRequestURI();
		if (!requestUri.contains("queryAllSkill") && !requestUri.contains("login") && !requestUri.contains("checkLogin")) {
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				return true;
			}
	        return false;
		}
		return true;
		
	}

}
