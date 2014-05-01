package sems.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {

		// doFilter()가 호출될 때 넘어오는 파라미터는
		// HttpServletRequest와 HttpServletResponse 이다.
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		// 1) 클라이언트가 요청한 URL 정보를 가져온다.
		String servletPath = httpRequest.getServletPath();
		System.out.println(servletPath);
		
		// 2) 만약 URL이 '/auth/' 문자열을 포함하고 있지 않다면
		//	 로그인 여부 검사한다.
		if (!servletPath.startsWith("/auth/")) {
			HttpSession session = httpRequest.getSession();
			if (session.getAttribute("loginUser") == null) {	// 로그인 유저만 정상 동작하게 함.
				// Context Root 필요
				String contextRoot = httpRequest.getContextPath(); // "/web00"
				System.out.println("contextRoot: " + contextRoot);
				httpResponse.sendRedirect(contextRoot + "/auth/login.bit"); // http://url:9999 자동 붙음
				// "/web01/auth/login.bit"
				return;
			}
		}
		
		next.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
