package com.ipssi.ppgcl.response;

public class MessageResponse {
	private Object data;
	private Integer status;
	private String message;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public MessageResponse(Object data, Integer status, String message) {
		super();
		this.data = data;
		this.status = status;
		this.message = message;
	}
	
}
