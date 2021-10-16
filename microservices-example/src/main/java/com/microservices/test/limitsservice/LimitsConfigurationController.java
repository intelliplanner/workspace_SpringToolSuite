package com.microservices.test.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.test.limitsservice.bean.Configuration;
import com.microservices.test.limitsservice.bean.LimitConfiguration;

@RestController  
public class LimitsConfigurationController {
	
//	@Autowired
//	Configuration limitConfig;
	
	@Value("${limits-service.minimum}")
	String v1;
	@Value("${limits-service.maximum}")
	String v2;
	@GetMapping("/limit")
	public LimitConfiguration retriveLimitsFromConfigurations() {
		return new LimitConfiguration(Integer.valueOf(v2), Integer.valueOf(v1));
	}
}
