package com.employee.customexception;

public class ControllerException extends RuntimeException {

	String status;
	String message;
	
	public ControllerException() {
		// TODO Auto-generated constructor stub
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ControllerException(String status, String message) {
		this.status = status;
		this.message = message;
	}
	
}
