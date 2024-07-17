package com.samanecorp.secureapp.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PrivateFilter
 */
@WebFilter("/*")
public class PrivateFilter extends HttpFilter implements Filter {
       
	
    /**
	 * @see Filter#init(FilterConfig)
	 */
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		
		String username = (String) session.getAttribute("username");
		String path = req.getServletPath();
		String method = req.getMethod();
		
		if(username != null || path.equals("/") || path.equals("/login") || path.equals("/signup") 
				|| path.equals("/logout") && path.equals("/index.jsp")
				|| path.equals("/login") && method.equalsIgnoreCase("POST")
				|| path.equals("/signup") && method.equalsIgnoreCase("POST") || path.startsWith("/public"))
			
			chain.doFilter(request, response);
		else
		 resp.sendRedirect(req.getContextPath());
	}

	

}
