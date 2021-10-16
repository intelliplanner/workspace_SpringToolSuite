package com.service;

import java.util.List;

import com.bean.EmployeeBean;

public interface EmployeeService {
	public void addEmployee(EmployeeBean p);

	public void updateEmployee(EmployeeBean p);

	public List<EmployeeBean> listEmployees();

	public EmployeeBean getEmployeeById(int id);

	public void removeEmployee(int id);
}
