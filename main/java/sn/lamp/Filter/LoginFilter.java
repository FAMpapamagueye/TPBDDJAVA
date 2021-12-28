package sn.lamp.Filter;

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

public class LoginFilter implements Filter {

	public static final String ATT_SES="session";
	public static final String ATT_PUB="/login";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stu
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		HttpSession session=request.getSession();
		if(session.getAttribute(ATT_SES)==null) {
			request.getRequestDispatcher(ATT_PUB).forward(request,response);
			}else {
			
					chain.doFilter(request, response);
					
				}
				
			
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
	

}
