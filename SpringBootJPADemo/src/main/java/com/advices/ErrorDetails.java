package com.advices;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime ldt;
	private String msg;
	private String details;
	public ErrorDetails(LocalDateTime ldt, String msg, String details) {
		super();
		this.ldt = ldt;
		this.msg = msg;
		this.details = details;
	}
	public LocalDateTime getLdt() {
		return ldt;
	}
	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
