package com.ipssi.ppgcl.service;

import java.util.List;

import org.example.customersalesorder.Acknowledgement;
import org.example.customersalesorder.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipssi.ppgcl.dao.SapSalesOrderDaoService;
import com.ipssi.ppgcl.dto.SapSalesOrderRequestDto;

@Service
public class SapIntegrationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SapIntegrationService.class);
	
	@Autowired
	SapSalesOrderDaoService sapSalesOrderDaoService;
	
	
	
	public  Acknowledgement getSapResult(CustomerRequest requestData) {
		Acknowledgement rMessage = new Acknowledgement();
		List<String> customResponse = rMessage.getResult();
		int status = 0;
		SapSalesOrderRequestDto.checkRequestData(requestData,customResponse);
		if(customResponse.size()>0) {
			return rMessage;
		} else {
		    status = sapSalesOrderDaoService.insertOrUpdateSalesOrder(requestData);
		    if(status==1){
		    	rMessage.setResponseType("Message");
		    	customResponse.add("Success");
		    }else {
		    	rMessage.setResponseType("Message");
		    	customResponse.add("Failed");
		    }
		}
		LOGGER.info("###### SapResult: "+ rMessage.getResult().get(0) +"#######");
		return rMessage;
	}

}

