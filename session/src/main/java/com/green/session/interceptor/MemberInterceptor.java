package com.green.session.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor implements HandlerInterceptor{

	//controller가 작동하기 전에 일어난다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		
		    // 기존 session이 있으면 기존 session을, 없으면 null 반환
		    HttpSession session = request.getSession(false);
		    
		    if (session == null || session.getAttribute("member") == null) {
	            // 로그인폼으로 redirect
	            response.sendRedirect(request.getContextPath() + "/" + "member/loginForm");
	            return false;
	        }
		    
	        return true;
		    
//		    if(session != null) {
//		    	Object obj = session.getAttribute("member");
//		    	if(obj != null) {
//		    		 return true;
//		    	}
//		    }
//		    
//		    response.sendRedirect(request.getContextPath() + "/");
//		    
//		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
   
	
	
}
