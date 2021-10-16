package com.ipssi.ppgcl.dto;

import java.util.List;

import org.example.customersalesorder.Customer;
import org.example.customersalesorder.CustomerRequest;

public class SapSalesOrderRequestDto {

	private static String sapCreationDate = "^((?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:(?:0[13578]|1[02])(-)31)|((0[1,3-9]|1[0-2])(-)(29|30))))$|^(?:(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(-)02(-)29)$|^(?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:0[1-9])|(?:1[0-2]))(-)(?:0[1-9]|1\\d|2[0-8])$";
	private static String intVal = "[+-]?[0-9]+";

	private static final String CONSTANTSUBSTRING = " AND ";

	public static void checkRequestData(CustomerRequest requestData, List<String> customResponse) {
		StringBuilder responseStr = new StringBuilder(" ");
		StringBuilder error = null;
		boolean isNotValidate = false;
		if (customResponse == null)
			return;

		List<Customer> customerRequestList = requestData.getCustomerList();
		for (int j = 0, js = customerRequestList.size(); j < js; j++) {
			Customer customerRequestData = customerRequestList.get(j);
			isNotValidate = false;
			error = new StringBuilder(" ");
			if (!isValidate(sapCreationDate, customerRequestData.getSapSalesOrderCreationDate())) {
				isNotValidate = true;
				error.append("Sap Creation Date format should be yyyy-MM-dd").append(CONSTANTSUBSTRING);
			}

			if (!isValidate(intVal, customerRequestData.getSapLineItem())) {
				isNotValidate = true;
				error.append("Sap Line Item should be Integer").append(CONSTANTSUBSTRING);
			}
			if(isNotValidate) {
				responseStr.append("Sales Order:"+customerRequestData.getSapSalesOrder()).append(",").append(error).append("\n");
				responseStr.delete(responseStr.lastIndexOf("AND"), responseStr.lastIndexOf("AND") + "AND".length());
			}
		}

		if (responseStr.toString().trim().length() > 0)
			customResponse.add(responseStr.toString().trim());
		
		System.out.println("ResponseStr: "+responseStr);
	}

	private static boolean isValidate(String pattern, String str) {
		return str.matches(pattern);
	}

}
