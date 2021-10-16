package com.test.employee.emp_dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.employee.bean.EmployeeBean;


@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeBean, Integer> {

}
