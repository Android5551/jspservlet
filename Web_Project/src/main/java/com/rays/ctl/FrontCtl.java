package com.rays.ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.util.ServletUtility;

@WebFilter(urlPatterns = "*.do")
public class FrontCtl implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		
		HttpSession s = req.getSession();
		
		if(s.getAttribute("user")==null) {
			req.setAttribute("ermsg", "your session has been expired please login again :(");
			ServletUtility.forward("LoginView.jsp", req, res);
		}
		else {
			arg2.doFilter(req, res);  // call next config filter or controller in the chain
			
		}
		
		
		
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
}
