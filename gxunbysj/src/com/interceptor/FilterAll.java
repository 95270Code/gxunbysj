package com.interceptor;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;

/**
 * ¹ýÂËÆ÷£¬À¹½ØÎ´µÇÂ½µÄÒ³Ãæ
 */
@WebFilter(filterName = "/FilterAll",urlPatterns ="/*",asyncSupported = true)
public class FilterAll implements Filter {
    public FilterAll() {
       
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		String path = req.getContextPath();
		chain.doFilter(request, response);
		/*if(uri.contains("login")){
			chain.doFilter(request, response);
		}else{
			User user = (User) session.getAttribute("user");
			if(user!=null)
				chain.doFilter(request, response);
			else
				resp.sendRedirect(path+"/login.jsp");
		}*/
				
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
