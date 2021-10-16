package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Transactional
	public void addEmployee(EmployeeBean p) {
		employeeDao.addEmployee(p);
	}
	@Transactional
	public void updateEmployee(EmployeeBean p) {
		employeeDao.updateEmployee(p);
	}
	@Transactional
	public List<EmployeeBean> listEmployees() {
		return this.employeeDao.listEmployees();
	}
	@Transactional
	public EmployeeBean getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}
	@Transactional
	public void removeEmployee(int id) {
		employeeDao.removeEmployee(id);
	}

}
