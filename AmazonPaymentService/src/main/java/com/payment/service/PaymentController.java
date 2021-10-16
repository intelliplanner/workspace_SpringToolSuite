package com.payment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-provider")
public class PaymentController {

	@Value("${server.port}")
	private int port;
	
	@GetMapping("/payNow/{price}")
	public String payNow(@PathVariable int price) {
		return "payment with " + price + " is successfully, localhost: "+port;
	}

	@GetMapping("/test")
	public String getValueTest() {
		return "Hello";
	}
}
