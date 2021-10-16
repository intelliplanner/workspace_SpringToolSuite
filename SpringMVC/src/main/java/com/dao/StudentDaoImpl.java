package com.dao;

import java.sql.Blob;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Student saved successfully, Person Details=" + p);
	}

	public void updateStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(p);
		logger.info("Student update successfully, Person Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> list = session.createQuery(" from Student").list();
		for (Student p : list) {
			logger.info("Student List::" + p);
		}
		return list;
	}

	public Student getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student st = (Student) session.load(Student.class, new Integer(id));
		logger.info("Person loaded successfully, Person details= " + st);
		return st;
	}

	public List<Student> searchStudentById(Student st) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Student where id=:student_id");
		query.setParameter("student_id", st.getId());
		List<Student> list = query.list();
		return list;
	}

	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student st = (Student) session.load(Student.class, new Integer(id));
		if (st != null)
			session.delete(st);
		logger.info("Person deleted successfully, person details= " + st);
	}

	@Override
	public Blob getPhotoById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("select image_1 from Student where id=:student_id");
		//int intValue = Integer.parseInt(id);
		query.setInteger("student_id", id);
		//byte[] photo =(byte[]) query.uniqueResult();
		//currentSession.createBlob(photo);
		return null;
	}

}
