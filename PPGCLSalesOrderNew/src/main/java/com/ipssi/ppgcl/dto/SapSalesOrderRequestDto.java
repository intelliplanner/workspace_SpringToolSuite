package com.ipssi.ppgcl.dto;

import java.util.List;

import org.example.customersalesorder.CustomerRequest;

public class SapSalesOrderRequestDto {

	private static String sapCreationDate = "^((?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:(?:0[13578]|1[02])(-)31)|((0[1,3-9]|1[0-2])(-)(29|30))))$|^(?:(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(-)02(-)29)$|^(?:(?:1[6-9]|2[0-9])\\d{2})(-)(?:(?:0[1-9])|(?:1[0-2]))(-)(?:0[1-9]|1\\d|2[0-8])$";
	private static String intVal = "[+-]?[0-9]+";
	
	private static final String CONSTANTSUBSTRING = " AND ";
	
	public static void checkRequestData(CustomerRequest requestData, List<String> customResponse) {
		StringBuilder responseStr = new StringBuilder(" ");
		boolean isNotValidate = false;
		if (customResponse == null)
			return;

		if (!isValidate(sapCreationDate, requestData.getSapSalesOrderCreationDate())) {
			isNotValidate=true;
			responseStr.append("Sap Creation Date format should be yyyy-MM-dd").append(CONSTANTSUBSTRING);
		}
		
		if (!isValidate(intVal, requestData.getSapLineItem())) {
			isNotValidate=true;
			responseStr.append("Sap Line Item should be Integer").append(CONSTANTSUBSTRING);
		}
		if(isNotValidate)
			responseStr.delete(responseStr.lastIndexOf("AND"), responseStr.lastIndexOf("AND") + "AND".length());
		
		if(responseStr.toString().trim().length() > 0)
			customResponse.add(responseStr.toString().trim());
	}

	private static boolean isValidate(String pattern, String str) {
		return str.matches(pattern);
	}

}
