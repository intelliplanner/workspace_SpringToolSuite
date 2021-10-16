package com.ipssi;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Init  implements ServletContextListener  {
	 	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Init class Initialize");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
