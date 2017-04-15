package com.mereking.meretool.intercepter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CookieValidate implements HandlerInterceptor{

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
		// TODO Auto-generated method stub
		String requestUri = request.getRequestURI();
		if (!requestUri.contains("queryAllSkill")) {
			Cookie[] cookies = request.getCookies();  
	        if(null!=cookies){    
	            for(Cookie cookie : cookies){    
	                String cookieValue = cookie.getValue();
	                System.out.println(cookieValue);
	                if (cookieValue.equals("sm-g9350")) {
	                	return true;
	                }
	            }
	        }
	        return false;
		}
		return true;
		
	}

}
