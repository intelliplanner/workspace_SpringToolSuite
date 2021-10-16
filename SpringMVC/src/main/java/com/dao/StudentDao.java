package com.dao;

import java.sql.Blob;
import java.util.List;

import com.bean.Student;

public interface StudentDao {
	public void addStudent(Student p);

	public void updateStudent(Student p);

	public List<Student> listStudents();

	public Student getStudentById(int id);

	public void removeStudent(int id);

	public List<Student> searchStudentById(Student st);

	public Blob getPhotoById(int id);
}
