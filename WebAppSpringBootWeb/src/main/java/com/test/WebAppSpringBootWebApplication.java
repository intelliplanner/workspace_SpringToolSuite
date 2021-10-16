package com.test;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableWebSecurity
//@EnableOAuth2Sso

public class WebAppSpringBootWebApplication {

	Logger logger = LoggerFactory.getLogger(WebAppSpringBootWebApplication.class);

	
//	@GetMapping("")
//	public String welcomeUser(Principal prpl) {
//		return "Welcome:"+prpl.getName();
//	}
	
	public static void main(String[] args) {
//		SpringApplication.run(WebAppSpringBootWebApplication.class, args);
		ConfigurableApplicationContext conf = SpringApplication.run(WebAppSpringBootWebApplication.class, args);
//		ProductionDaoImpl p= conf.getBean("productionDaoImpl",ProductionDaoImpl.class);
//		Product pro = new Product();
//		pro.setMadein("DKSK");
//		pro.setName("GPS");
//		pro.setBrand("BASD");
//		pro.setPrice(2000);
//		p.addProduct(pro);
//		ProductionDaoImpl p= conf.getBean("productionDaoImpl",Empl.class);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println("Virendra Hello:" + beanName);
//				logger.info("Virendra Beans Name:"+beanName);
			}
		};
	}

}
