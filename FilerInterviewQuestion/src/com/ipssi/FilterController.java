package com.ipssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterController implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		if(req.getParameter("name").equalsIgnoreCase("vicky") && req.getParameter("password").equalsIgnoreCase("vicky")) {
			 out.print("welcome ADMIN");  
			chain.doFilter(req, res);
		}else {
			out.print("password wrong");
			RequestDispatcher reqe=req.getRequestDispatcher("filter.jsp");
			reqe.include(req, res);
		}
		out.close();  
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
