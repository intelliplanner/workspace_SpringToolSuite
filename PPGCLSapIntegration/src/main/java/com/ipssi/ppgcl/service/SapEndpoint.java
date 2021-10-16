package com.ipssi.ppgcl.service;

import org.example.customersalesorder.Acknowledgement;
import org.example.customersalesorder.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SapEndpoint {
	private static final String NAMESPACE_URI = "http://www.example.org/CustomerSalesOrder";

	@Autowired
	private SapIntegrationService sapIntegrationService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "customerRequest")
	@ResponsePayload
	public Acknowledgement getStatus(@RequestPayload CustomerRequest request) {
		return sapIntegrationService.getSapResult(request);
	}
}
