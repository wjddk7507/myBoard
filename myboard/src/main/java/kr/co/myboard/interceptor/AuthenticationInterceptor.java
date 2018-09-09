package kr.co.myboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

	// Controller가 처리하기 전에 호출되는 메소드
	// true이면 Controller로 넘어가고 false를 리턴하면 넘어가지 않는다
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인 확인
		HttpSession session = request.getSession();
		if(session.getAttribute("member")==null) {
			// 사용자의 요청을 session에 dest라는 속성에 저장
			// 로그인이 되면 원래의 요청을 처리하기 위해서
			
			// 클라이언트의 전체 요청 주소
			String requestURI = request.getRequestURI();
			// 서버 주소
			String contextPath = request.getContextPath();
			// 주소 만들기
			String uri = requestURI.substring(contextPath.length()+1);
			// 주소 뒤에 파라미터 가져오기
			String query = request.getQueryString();
			// 실제 주소 만들기
			if(query == null || query.equals("null")) {
				query = "";
			}else {
				query = "?" + query;
			}
			// 세션에 주소 저장
			session.setAttribute("dest", uri+query);
			System.out.println("interceptor session uri : "+uri+query);
			session.setAttribute("msg", "로그인을 하셔야 이용할 수 있는 서비스 입니다.");
			
			// 로그인 페이지로 리다이렉트
			response.sendRedirect(contextPath+"/member/login");
			return false;
		}
		// 로그인이 되어있는 경우 controller로 이동
		return true;
	}

	// Controller가 사용자의 요정을 정상적으로 처리하고 난 후 호출되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}
	// Controller에서 예외 발생 여부에 상관없이 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
