package com.ipssi.ppgcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PpgclSapIntegrationApplication {
	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder){ return
	 * builder.sources(PpgclSapIntegrationApplication.class); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(PpgclSapIntegrationApplication.class, args);
	}

}
