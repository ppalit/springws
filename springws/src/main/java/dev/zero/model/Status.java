package dev.zero.model;

public class Status {

	private String statusCode;
	private String message;

	
	public Status(String statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Status [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
}
