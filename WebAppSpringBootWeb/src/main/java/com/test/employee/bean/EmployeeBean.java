package com.test.employee.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee_details")
public class EmployeeBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;
	@Column(name ="firstName")
	String firstName;
	
	@Column(name ="lastName")
	String lastName;
	
	@Column(name ="salary")
	double salary;
	
	@Column(name ="jobId")
	String jobId;
	
	@Column(name ="departmentId")
	String departmentId;
	
	@Column(name ="email")
	String email;
	
	@Column(name ="phoneNo")
	String phoneNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name ="hireDate")
	Date hireDate;
	
	@Column(name ="managerId")
	String managerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", jobId=" + jobId + ", departmentId=" + departmentId + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", hireDate=" + hireDate + ", managerId=" + managerId + ", address=" + "]";
	}

}