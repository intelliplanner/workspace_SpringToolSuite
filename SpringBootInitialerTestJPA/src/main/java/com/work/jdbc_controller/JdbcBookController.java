package com.work.jdbc_controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JDBC_TEST")
public class JdbcBookController {
	/*
	 * 
	 * @Autowired JdbcTemplate jdbcTemp;
	 * 
	 * @RequestMapping("/insert") public String insertData() { jdbcTemp.
	 * execute("insert into book_details(book_name,book_author) values('vicky','gupta')"
	 * ); // use mysql 5.7 return "Success"; }
	 * 
	 * @RequestMapping("/get") public List<Map<String, Object>> getData() { String
	 * query = "Select id,book_name,book_author from book_details;";
	 * List<Map<String, Object>> employees = jdbcTemp.queryForList(query); return
	 * employees; }
	 * 
	 */
	}
