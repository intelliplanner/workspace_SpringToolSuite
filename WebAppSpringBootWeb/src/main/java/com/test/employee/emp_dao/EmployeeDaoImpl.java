package com.test.employee.emp_dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.employee.bean.EmployeeBean;


@Service
public class EmployeeDaoImpl {

@Autowired
EmployeeRepository employeeRepository;


public List<EmployeeBean>  getAllEmployees() {
	List<EmployeeBean> listEmployee = new ArrayList<EmployeeBean>();
	employeeRepository.findAll().forEach(listEmployee::add);
	return listEmployee;
}
public EmployeeBean getEmployee(int id) {
	EmployeeBean employee = new EmployeeBean();
	employee = employeeRepository.findById(id).get();
	return employee;
} 

public void addEmployee(EmployeeBean employee) {
	employeeRepository.save(employee);
	System.out.println("Save Data");
}

public void delete(int id) {
	employeeRepository.deleteById(id);
	System.out.println("delete Employee id:"+id);
}


}