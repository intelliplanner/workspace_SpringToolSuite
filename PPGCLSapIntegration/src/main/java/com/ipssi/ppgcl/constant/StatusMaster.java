package com.ipssi.ppgcl.constant;

public enum StatusMaster {

	SUCCESS(1, 200, "Success", "Successfully Done"), 
	FAILED(2, 500, "Failed","Fail to Execute"),
	DUPLICATE_BASIC_PROFILE_ID(3, 401, "Udise Code Already Exist", "Udise Code Already Exist"),
	INVALID_REQUEST_INPUT(11, 501, "Invalid Request input","Invalid Request input parameter");
	
	private long responseId;
	private long responseCode;
	private String responseMessage;
	private String responseDescription;

	StatusMaster(long responseId, long responseCode, String responseMessage, String responseDescription) {
		this.responseId = responseId;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.responseDescription = responseDescription;
	}

	public long getResponseId() {
		return responseId;
	}

	public void setResponseId(long responseId) {
		this.responseId = responseId;
	}

	public long getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
}

