package com.ipssi.ppgcl.daoImpl;

import java.sql.ResultSet;
import java.util.Date;

import org.example.customersalesorder.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ipssi.ppgcl.dao.SapSalesOrderDaoService;

@Repository
public class SapSalesOrderDaoServiceImpl implements SapSalesOrderDaoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SapSalesOrderDaoServiceImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(readOnly = false)
	public int insertOrUpdateSalesOrder(CustomerRequest request) {
		int sapSalesOrderStatus = 1;
		int status = 1;
		int portNodeId = 463;
		String queryStr = "";
		int respStatus = 0;
		CustomerRequest customerRequestData = request;
//		for (int j = 0, js = request.size(); j < js; j++) {
//			CustomerRequest customerRequestData = request.get(j).getSapSalesOrderAndSapSalesOrderCreationDateAndCustomerSapCode();
			int customerId = getCustomerId(customerRequestData.getCustomerSapCode());
			System.out.println("sap_customer_sap_code =" + customerRequestData.getCustomerSapCode()
					+ ", sap_customer_name =" + customerRequestData.getCustomerName() + ", sap_customer_address ="
					+ customerRequestData.getCustomerAddress() + "Customersap_material = "
					+ customerRequestData.getSapMaterial() + ", sap_order_quantity ="
					+ customerRequestData.getSapOrderQuantity() + ", sap_order_unit = "
					+ customerRequestData.getSapOrderUnit() + ",sap_sales_order="
					+ customerRequestData.getSapSalesOrder() + ", sap_line_item="
					+ customerRequestData.getSapLineItem());
			boolean isExist = sapOrderExist(customerRequestData.getSapSalesOrder(),
					customerRequestData.getSapLineItem());
			Date currentDate = new Date();

			if (isExist) {
				queryStr = "UPDATE cgpl_sales_order SET sap_sales_order_creation_date = ?, "
						+ "sap_customer_sap_code = ?, sap_customer_name = ?, sap_customer_address = ?, "
						+ "sap_material = ?, sap_order_quantity = ?, sap_order_unit = ?, "
						+ "sap_sale_order_status = ?, updated_on = ?, status = ?, port_node_id = ?, customer_id=? "
						+ "WHERE sap_sales_order=? AND sap_line_item=?";

				respStatus = jdbcTemplate.update(queryStr, customerRequestData.getSapSalesOrderCreationDate(),
						customerRequestData.getCustomerSapCode(), customerRequestData.getCustomerName(),
						customerRequestData.getCustomerAddress(), customerRequestData.getSapMaterial(),
						customerRequestData.getSapOrderQuantity(), customerRequestData.getSapOrderUnit(),
						customerRequestData, currentDate, status, portNodeId, customerId,
						customerRequestData.getSapSalesOrder(), customerRequestData.getSapLineItem());
			} else {
				queryStr = "INSERT INTO cgpl_sales_order ( sap_sales_order_creation_date, "
						+ "sap_customer_sap_code,  sap_customer_name, sap_customer_address,sap_material, "
						+ "sap_order_quantity,  sap_order_unit,  sap_sale_order_status,created_on, "
						+ "updated_on,status,port_node_id,customer_id,sap_sales_order,sap_line_item) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				respStatus = jdbcTemplate.update(queryStr, customerRequestData.getSapSalesOrderCreationDate(),
						customerRequestData.getCustomerSapCode(), customerRequestData.getCustomerName(),
						customerRequestData.getCustomerAddress(), customerRequestData.getSapMaterial(),
						customerRequestData.getSapOrderQuantity(), customerRequestData.getSapOrderUnit(),
						sapSalesOrderStatus, currentDate, currentDate, status, portNodeId, customerId,
						customerRequestData.getSapSalesOrder(), customerRequestData.getSapLineItem());
			}
//		}
		return respStatus;

	}

	public int getCustomerId(String customerSapCode) {
		System.out.println("getCustomerId()");
		String query = "select id from customer_details  where sap_code = '" + customerSapCode + "'";
		return jdbcTemplate.query(query, (ResultSet rs) -> {
			int customerId = 0;
			while (rs.next()) {
				customerId = rs.getInt("id");
			}
			return customerId;
		});

	}

	@Transactional(readOnly = true)
	private boolean sapOrderExist(String sapSalesOrder, String sapLineItem) {
		String sql = "SELECT count(1) FROM cgpl_sales_order WHERE sap_sales_order=? AND sap_line_item=?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { sapSalesOrder, sapLineItem }, Integer.class);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
