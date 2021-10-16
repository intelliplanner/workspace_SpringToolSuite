package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EmployeeBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.service.EmployeeService;

@RestController
//@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping("/ipssi_employees")
public class EmployeeRestController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/")
	public String showForm(Model m) {
		m.addAttribute("employee", new EmployeeBean());
		return "addEmployee";
	}
	
	@ModelAttribute
	public void addingCommonObject(Model m) {
		m.addAttribute("headerMsg", "Employee Details");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("employee") EmployeeBean employee, BindingResult b) {
		if(b.hasErrors()) {
			return  "/addEmployee";
		}
		employeeService.addEmployee(employee);
		return "redirect:/employee/show";
	}

	@RequestMapping(value = "/deleteEmployee/{id}")
	public String delete(@PathVariable int id) {
		employeeService.removeEmployee(id);
		return "/redirect:/employee/show";
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public ModelAndView findById(@PathVariable int id) {
		ModelAndView m = new ModelAndView("addEmployee");
		EmployeeBean employeeData = employeeService.getEmployeeById(id);
		m.addObject("employee", employeeData);
		return m;
	}

	//@RequestMapping("/show")
	@GetMapping("/show")
	public List<EmployeeBean> findAll() {
		List<EmployeeBean> employeeList = employeeService.listEmployees();
		//ModelAndView m = new ModelAndView("showEmployees","list",employeeList);
		//m.addObject("list", employeeList);
		return employeeList;
	}
	
	
	@RequestMapping(value="/getNew" ,method = RequestMethod.GET)
	public String loadAllNew(Model m) throws JsonProcessingException {
		List<EmployeeBean> employeeList = employeeService.listEmployees();
		m.addAttribute("list", employeeList );
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String result = mapper.writeValueAsString(employeeList);
//		result.replaceAll("ArrayList", "Product");
//		result = master.replace(target, replacement);
		result = result.replace("ArrayList", "Product");
		return result;
	}
}
