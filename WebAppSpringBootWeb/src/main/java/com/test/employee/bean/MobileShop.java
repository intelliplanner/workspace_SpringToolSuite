package com.test.employee.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "MobileShop")
@Inheritance(strategy = InheritanceType.JOINED)
public class MobileShop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;

	
	@Column(name = "mobile_shop_name")
	String mobileShopName;
	
	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)  
	@JoinColumn(name="mobile_shop_id")  
	@OrderColumn(name="type")  
	private List<Mobile> mobile;  
	
}
