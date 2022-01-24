package com.javatechie.asynOrNonBlock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class Customer /* implements Serializable */ {

	/**
	 * Virendra Gupta
	 */
//	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
