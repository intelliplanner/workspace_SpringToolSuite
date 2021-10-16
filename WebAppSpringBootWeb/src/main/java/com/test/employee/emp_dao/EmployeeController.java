package com.test.employee.emp_dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.test.employee.bean.EmployeeBean;

import io.micrometer.core.ipc.http.HttpSender.Method;

//@CrossOrigin(origins = "http://localhost:4200/*" , allowedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeDaoImpl pDao;

//	@RequestMapping(value="/savenew",method =RequestMethod.POST)
	@PostMapping(value = "/savenew")
	public String saveNew(@RequestBody EmployeeBean employee) {
		pDao.addEmployee(employee);
		return "list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employee") EmployeeBean employee/* @RequestBody EmployeeBean p */) {
		pDao.addEmployee(employee);
		return "list";
	}

	@RequestMapping(value = "/")
	public String get() {
		return "login";
	}

	@RequestMapping("/empForm")
	public String showform(Model m) {
		m.addAttribute("command", new EmployeeBean());
		return "productform";
	}

	@PutMapping("/update")
	public String update(@RequestBody EmployeeBean emp) {
		pDao.addEmployee(emp);
		return "list";
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
//	@JsonProperty("Employee")
	public EmployeeBean loadAll(@PathVariable int id, Model m) {
		EmployeeBean emp = pDao.getEmployee(id);
		// m.addAttribute("emp", emp);
		return emp;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@JsonProperty("Employee")
	public List<EmployeeBean> loadAll(Model m) {
		List<EmployeeBean> list = pDao.getAllEmployees();
		m.addAttribute("list", list);
		return list;
	}

	@RequestMapping(value = "/getNew", method = RequestMethod.GET)
	public String loadAllNew(Model m) throws JsonProcessingException {
		List<EmployeeBean> list = pDao.getAllEmployees();
		m.addAttribute("list", list);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String result = mapper.writeValueAsString(list);
//	result.replaceAll("ArrayList", "Employee");
//	result = master.replace(target, replacement);
		result = result.replace("ArrayList", "ipssi_employees");
		return result;
	}

//@RequestMapping(value="/xml", method = RequestMethod.GET, produces = "text/xml")
	@RequestMapping(value = "/xml", method = RequestMethod.GET, produces = "application/xml")
	public List<EmployeeBean> getAllEmployees() {
		List<EmployeeBean> data = pDao.getAllEmployees();
		return data;
	}

}
