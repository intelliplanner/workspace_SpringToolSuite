package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.EmployeeBean;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addEmployee(EmployeeBean p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("EmployeeBean saved successfully, Person Details=" + p);
	}

	public void updateEmployee(EmployeeBean p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(p);
		logger.info("EmployeeBean update successfully, Person Details=" + p);
	}

	public List<EmployeeBean> listEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<EmployeeBean> list = session.createQuery("from EmployeeBean").list();
		for (EmployeeBean p : list) {
			logger.info("Employee List::" + p);
		}
		return list;
	}

	public EmployeeBean getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		EmployeeBean st = (EmployeeBean) session.load(EmployeeBean.class, new Integer(id));
		logger.info("Person loaded successfully, Person details= " + st);
		return st;
	}

	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		EmployeeBean st = (EmployeeBean) session.load(EmployeeBean.class, new Integer(id));
		if (st != null)
			session.delete(st);
		logger.info("Person deleted successfully, person details= " + st);
	}
}
