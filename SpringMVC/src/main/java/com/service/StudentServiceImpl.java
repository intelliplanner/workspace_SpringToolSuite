package com.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Student;
import com.dao.StudentDao;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	@Transactional
	public void addStudent(Student p) {
		studentDao.addStudent(p);
	}

	@Transactional
	public void updateStudent(Student p) {
		studentDao.updateStudent(p);
	}
	@Transactional
	public List<Student> listStudents() {
		return studentDao.listStudents();
	}
	@Transactional
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}
	@Transactional
	public void removeStudent(int id) {
		studentDao.removeStudent(id);
	}
	@Transactional
	public List<Student> searchStudentById(Student st) {
		return studentDao.searchStudentById(st);
	}
	@Override
	public Blob getPhotoById(int id) {
		return studentDao.getPhotoById(id);
	}

}
