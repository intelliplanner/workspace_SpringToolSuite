package com;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ipssi_employees")
public class JdbcController {

	@Autowired
	JdbcTemplate jdbcTemp;

	
@RequestMapping("/insert")
public String insertData() {
	jdbcTemp.execute("insert into employee_details(firstName,lastName,address) values('vicky','gupta','182 ews')");
	// use mysql 5.7
	return "Success";
}

@RequestMapping("/get")
public List<Map<String, Object>> getData() {
	String query = "Select id,address,departmentId,email,firstName,hireDate,jobId,lastName,managerId,phoneNo,salary from employee_details;";
	List<Map<String, Object>> employees = jdbcTemp.queryForList(query);
    return employees;
}


}
