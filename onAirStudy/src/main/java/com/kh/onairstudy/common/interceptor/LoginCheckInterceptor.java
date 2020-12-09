package com.kh.onairstudy.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.kh.onairstudy.member.model.vo.Member;



public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null) {
			
			//FlashMap을 통해서 RedirectAttributes구현하기
			FlashMap map = new FlashMap();
			map.put("msg", "로그인 후 이용할 수 있습니다.");
			FlashMapManager manager = RequestContextUtils.getFlashMapManager(request);
			manager.saveOutputFlashMap(map, request, response);
			
			//로그인 성공후 이동페이지 next 세션에 저장
			String next = request.getRequestURL().toString();
			
			if(request.getQueryString() != null)
					next += "?" + request.getQueryString();
			session.setAttribute("next", next);
			
			//다음요청할 주소
			response.sendRedirect(request.getContextPath() + "/member/memberLogin.do");
			
			return false;
		}
		
		
		return super.preHandle(request, response, handler);
	}

	
	
}
