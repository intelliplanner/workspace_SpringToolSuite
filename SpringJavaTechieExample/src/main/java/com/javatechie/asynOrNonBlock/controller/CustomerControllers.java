package com.javatechie.asynOrNonBlock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.asynOrNonBlock.dto.Customer;
import com.javatechie.asynOrNonBlock.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerControllers {

	@Autowired
	CustomerService customerService;
	
	@GetMapping(value="/custList")
	public List<Customer> getCustomerList(){
		return customerService.getCustomerList();
	}
	
	@GetMapping(value="/custAll",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public List<Customer> getAllCustomer(){
		return customerService.getCustomerList();
	}
	
	@GetMapping(value="/custListByStream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getCustomerListByStream(){
		return customerService.getCustomerListByStream();
	}
}
