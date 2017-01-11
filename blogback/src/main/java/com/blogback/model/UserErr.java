package com.blogback.model;

public class UserErr {
	private int code;
	private String message;
	public UserErr(int code, String message) {
		// TODO Auto-generated constructor stub
		super();
		this.code=code;
		this.message=message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
