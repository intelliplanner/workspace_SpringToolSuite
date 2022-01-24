package com.ipssi.ppgcl.constant;

public enum StatusMaster {

	SUCCESS(1, 200, "Success", "Successfully Done"), FAILED(2, 500, "Failed", "Fail to Execute"),
	DUPLICATE_BASIC_PROFILE_ID(3, 401, "Udise Code Already Exist", "Udise Code Already Exist"),
	DUPLICATE_EXCEPTION(4, 500, "Duplicate Value", "Please Check Duplicate Value Given"),
	EXCEED_FILE_SIZE(5, 500, "Image Error", "File Size More Then 100Kb"),
	IMAGE_EXTENSTION(6, 500, "Image Error", "JPG/JPEG Format Allowed"),
	INVALID_BASIC_PROFILE_ID(7, 401, "Udise Code Invalid", "Udise Code Must Be Eleven Character"),
	DUPLICATE_EMAIL(8, 401, "Email Id Already Exist", "Email Id Already Exist"),
	DUPLICATE_MOBILE(9, 401, "Mobile Number Already Exist", "Mobile Number Already Exist"),
	EXCEL_FILE_ERROR(10, 500, "Excel File Error", "Please Fill Proper Data in Excel File."),
	PDF_FILE_ERROR(10, 500, "PDF File Error", "PDF File Error"),
	INVALID_REQUEST_INPUT(11, 501, "Invalid Request input", "Invalid Request input parameter"),
	TOKEN_EXPIRED_ERROR(12, 500, "Token Expired Error", "Token Expired"),
	BLOCKED_USER(4, 500, "Unauthorised User", "Blocked User" + ""),
	INVALID_USER_NAME_PASSWORD(5, 401, "Bad Credentials", "Invalid Username or Password"),
	USER_CREATION_SUCCESS(6, 200, "Success", "User Created Successfully and Username & Password Sent in Email"),
	USER_CREATION_FAILED(7, 500, "Bad Request", "Failed to Create User"),
	USER_PASSWORD_CHANGED_SUCCESS(8, 200, "Success", "Password changed Successfully"),
	USER_PASSWORD_CHANGED_FAILED(9, 500, "Bad Request", "Failed to Create User"),
	CHANGED_STATUS_SUCCESS(10, 200, "Success", "Status changed Successfully"),
	CHANGED_STATUS_FAILED(11, 500, "Bad Request", "Failed to Change Status"),
	USER_PROFILE_UPDATE_SUCCESS(12, 200, "Success", "User Profile Update Successfully"),
	USER_PROFILE_UPDATE_FAILED(13, 500, "Bad Request", "Failed to Update User Profile"),
	DEACTIVATE_USER(14, 401, "Unauthorized User", "Deactivate User"),
	INVALID_MOBILE_NUMBER(15, 500, "Bad Request", "Enter Correct Mobile Number"),
	INVALID_EMAIL(16, 500, "Bad Request", "Invalid Email ID"),
	PASSWORD_CHANGED_FAILED(17, 500, "Bad Request", "Enter Wrong Current Password"),
	INVALID_NAME(17, 500, "Bad Request", "Invalid Name Input"),
	LEVEL_CONFIG(18, 500, "Invalid", "Already Configured Level"),
	ASSIGN_NULL(19, 500, "Atleast", "Please Select Atleast One"),
	SAME_PASSWORD_FAILED(20, 500, "Bad Request", "Enter Same Password current And Old "),
	ASSIGN_USER(21, 401, "Unauthorized User", "First Assign Permission To User."),
	EMAIL_SEND_SUCCESSFULLY(22, 200, "Email Send Successfully",	"Email sent. Follow instructions in email to verify your email id" + ""),
	INVALID_EMAIL_ID(23, 500, "Bad Input", "Invalid Email Address"),
	USER_DOES_NOT_EXIST(24, 500, "Bad Request", "Invalid Details"),
	INVALID_LEVEL_ID(25, 500, "Bad Request", "Invalid Level Input"),
	INVALID_ROLE_ID(26, 500, "Bad Request", "Invalid Role Input"),
	INVALID_ROLE_TYPE(27, 500, "Bad Request", "Invalid Role Type"),
	INVALID_ASSIGNED_RIGHT_VALUE(28, 500, "Bad Request", "Invalid Assigned Right Value"),
	INVALID_CREATED_BY(29, 500, "Bad Request", "Invalid Created By Input"),
	INVALID_UPDATED_BY(30, 500, "Bad Request", "Invalid Updated By Input"),
	INVALID_STATE(31, 500, "Bad Request", "Invalid State Input"),
	INVALID_DISTRICT(32, 500, "Bad Request", "Invalid District Id Input"),
	INVALID_BLOCK(33, 500, "Bad Request", "Invalid Block Id Input"),
	INVALID_CLUSTER(34, 500, "Bad Request", "Invalid Cluster Id Input"),
	INVALID_SCHOOL(35, 500, "Bad Request", "Invalid School Id Input"),
	MAX_ATTEMPT(36, 402, "Blocked User", "User attempts maximum login, blocked for next 24 hours"),
	INVALID_PASSWORD_FORMAT(37, 500, "Bad Request", "Invalid Password Format");

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
