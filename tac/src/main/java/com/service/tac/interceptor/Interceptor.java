package com.service.tac.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.service.tac.model.vo.Member;

@Component
public class Interceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("[LoginInterceptor] preHandle");
		String URI = request.getRequestURI();
		// 혹시모를 이전 직전 URL
		String URL = request.getRequestURL().toString() + "?" + request.getQueryString();
		
		HttpSession session = request.getSession();
		// 멤버확인
		Member member = (Member) session.getAttribute("member");
		
		System.out.println(URL);
		if ( URI.equals("/analysis") || URI.equals("/compare") 
				|| URI.equals("/logout") || URI.equals("/mypage") || URI.equals("/updateConsume") ) {
			if ( member == null ) {
				response.sendRedirect(request.getContextPath() + "/needlogin");
				return false;
			}
		} else if ( URI.equals("/manage_card") ) {
			if ( member == null ) {
				response.sendRedirect(request.getContextPath() + "/needlogin");
				return false;
			} else if ( member.getGrade() != 1 ) {
				response.sendRedirect(request.getContextPath() + "/notadmin");
				return false;
			}
		}
		
        return true;
    }

	// 예비용
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[LoginInterceptor] postHandle");
	}

	// 예비용
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex)
			throws Exception {
		logger.info("[LoginInterceptor] afterCompletion");
	}
}
