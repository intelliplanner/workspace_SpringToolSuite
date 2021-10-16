package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EmployeeBean;
import com.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	
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
			return  "addEmployee";
		}
		if(employee.getId() != 0) {
			employeeService.updateEmployee(employee);
		}else {
			employeeService.addEmployee(employee);
		}
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

	@RequestMapping("/show")
	public ModelAndView findAll() {
		
		List<EmployeeBean> employeeList = employeeService.listEmployees();
		ModelAndView m = new ModelAndView("showEmployees","list",employeeList);
		m.addObject("list", employeeList);
		return m;
	}
}
