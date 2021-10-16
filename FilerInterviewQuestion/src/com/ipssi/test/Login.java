package com.ipssi.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		String name = req.getParameter("name");
		if(name.equalsIgnoreCase("vicky") && req.getParameter("password").equalsIgnoreCase("vicky")) {
			 out.print("Welcome "+name);  
			 HttpSession session = req.getSession();
			 session.setAttribute("name", name);
			 RequestDispatcher red=req.getRequestDispatcher("index.jsp");
					 red.include(req, res);
			 
		}else {
			out.print("Password Wrong");
			RequestDispatcher reqdis=req.getRequestDispatcher("filter.jsp");
			reqdis.include(req, res);
		}
		out.close();  
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		doGet(req,res);
	}
}
