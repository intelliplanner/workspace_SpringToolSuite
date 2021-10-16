package com.ipssi.ppgcl.service;

import java.util.List;

import org.example.customersalesorder.Acknowledgement;
import org.example.customersalesorder.Customer;
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

	public Acknowledgement getSapResult(CustomerRequest requestData) {
		System.out.println("###############  START SAP  REQUEST  ############");
		LOGGER.info("###############  START SAP  REQUEST  ############");
		if (requestData != null) {
			List<Customer> customerRequestList = requestData.getCustomerList();
			for (int j = 0, js = customerRequestList.size(); j < js; j++) {
				Customer customerRequestData = customerRequestList.get(j);
				System.out.println("REQUEST DATA: [sap_customer_sap_code =" + customerRequestData.getCustomerSapCode()
						+ ", sap_customer_name =" + customerRequestData.getCustomerName() + ", sap_customer_address ="
						+ customerRequestData.getCustomerAddress() + "Customersap_material = "
						+ customerRequestData.getSapMaterial() + ", sap_order_quantity ="
						+ customerRequestData.getSapOrderQuantity() + ", sap_order_unit = "
						+ customerRequestData.getSapOrderUnit() + ",sap_sales_order="
						+ customerRequestData.getSapSalesOrder() + ", sap_line_item="
						+ customerRequestData.getSapLineItem() + " ]");
//				LOGGER.info("REQUEST DATA: [sap_customer_sap_code =" + customerRequestData.getCustomerSapCode()
//						+ ", sap_customer_name =" + customerRequestData.getCustomerName() + ", sap_customer_address ="
//						+ customerRequestData.getCustomerAddress() + "Customersap_material = "
//						+ customerRequestData.getSapMaterial() + ", sap_order_quantity ="
//						+ customerRequestData.getSapOrderQuantity() + ", sap_order_unit = "
//						+ customerRequestData.getSapOrderUnit() + ",sap_sales_order="
//						+ customerRequestData.getSapSalesOrder() + ", sap_line_item="
//						+ customerRequestData.getSapLineItem() + " ]");
			}
		}
		Acknowledgement rMessage = new Acknowledgement();
		List<String> customResponse = rMessage.getResult();
		int status = 0;
		SapSalesOrderRequestDto.checkRequestData(requestData, customResponse);
		if (customResponse.size() > 0) {
			rMessage.setResponseType("Error");
			return rMessage;
		} else {
			status = sapSalesOrderDaoService.insertOrUpdateSalesOrder(requestData);
			if (status == 1) {
				rMessage.setResponseType("Message");
				customResponse.add("Success");
				System.out.println("Result: Success");
			} else {
				rMessage.setResponseType("Message");
				customResponse.add("Failed");
				System.out.println("Result: Failed");
			}
			System.out.println("###############  END SAP  REQUEST  ############");
			return rMessage;
		}
	}
}
