package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "student")
public class Student  implements java.io.Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@NotBlank(message = "name not null")
	String firstName;
	@Column(name = "lastName")
	String lastName;

	@Column(name = "email")
	@Email
	String email;
	@Column(name = "phoneNo")
	String phoneNo;
	@Column(name = "address")
	String address;

	@Transient
	String base64Image;
	
	String image1_name;
	
	public String getImage1_name() {
		return image1_name;
	}

	public void setImage1_name(String image1_name) {
		this.image1_name = image1_name;
	}

	@Lob
	@Column(name = "image_1", nullable=false, columnDefinition="mediumblob")
	byte[] image_1;


	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@Lob
	SerialBlob image_2;
	
	public SerialBlob getImage_2() {
		return image_2;
	}

	public void setImage_2(SerialBlob serialBlob) {
		this.image_2 = serialBlob;
	}

	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}

	public byte[] getImage_1() {
		return image_1;
	}

	public void setImage_1(byte[] image_1) {
		this.image_1 = image_1;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
