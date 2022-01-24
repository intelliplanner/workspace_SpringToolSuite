package com.javatechie.asynOrNonBlock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.asynOrNonBlock.dao.CustomeDao;
import com.javatechie.asynOrNonBlock.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	CustomeDao customeDao;
	
	public List<Customer> getCustomerList(){
		return customeDao.getCustomerList();
	}

	public Flux<Customer> getCustomerListByStream() {
		// TODO Auto-generated method stub
		return customeDao.getCustomerListByStream();
	}
}
