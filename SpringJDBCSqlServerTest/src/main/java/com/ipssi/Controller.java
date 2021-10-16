package com.ipssi;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping({ "/login" })
	public String firstPage() {

		String query = "INSERT  INTO  customer_details (  name , sap_code , address , status , created_on , updated_on , "
				+ "updated_by , port_node_id , created_by ) VALUES ('Maithon power ltd','MPL','JHARKHAND',1,NULL,'2016-11-30 19:09:23',NULL,NULL,NULL);";
//		int i = jdbcTemplate.query(query, (ResultSet rs) -> {
//			int customerId=0;
//			while (rs.next()) {
//				customerId = rs.getInt("id");
//			}
//			return customerId;
//		});
		jdbcTemplate.update(query);
		System.out.println("Jdbc Connection Test");
		return "succes";

	}

}