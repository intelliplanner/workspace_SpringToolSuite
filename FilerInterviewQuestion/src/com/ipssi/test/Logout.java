package com.ipssi.test;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
			public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
				HttpSession session= req.getSession();
				if(session!=null) {
					session.invalidate();
				}
				RequestDispatcher red = req.getRequestDispatcher("index.jsp");
				red.forward(req, res);
			
			}
			public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
				doGet(req,res);
			}
}
