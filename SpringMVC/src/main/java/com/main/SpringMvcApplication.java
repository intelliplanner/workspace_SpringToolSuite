package com.main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.EmployeeBean;
import com.controller.EmployeeController;

public class SpringMvcApplication {
	private static final Logger logger = Logger.getLogger(SpringMvcApplication.class);
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		EmployeeBean emp = (EmployeeBean) ctx.getBean("empBean",EmployeeBean.class);
	//	emp.printEmployee();
	}

}
