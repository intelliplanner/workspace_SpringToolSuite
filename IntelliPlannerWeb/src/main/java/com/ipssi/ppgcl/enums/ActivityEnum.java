package com.ipssi.ppgcl.enums;

public enum ActivityEnum {
	SAVE(1, "Save"), UPDATE(2, "UPDATE"), DELETE(2, "DELETE");

	private String name;

	private Integer id;

	ActivityEnum(Integer id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}
}
