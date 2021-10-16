package com.ipssi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SapSalesOrderDto {
	@NotBlank
	String sapSalesOrder;
	@NotBlank
	String sapSalesOrderCreationDate;
	@NotBlank
	String sapCustomerSapCode;
	@NotBlank
	String saCustomerName;
	@NotBlank
	String sapCustomerAddress;
	@NotBlank
	String sapLineItem;
	@NotBlank
	String sapMaterial;
	@NotBlank
	String transporterSapCode;
	@NotBlank
	String sapOrderQuantity;
	@NotBlank
	String sapOrderUnit;
	@NotBlank
	String sapSaleOrderStatus;

}
