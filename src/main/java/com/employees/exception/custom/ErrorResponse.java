package com.employees.exception.custom;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {
	private LocalDateTime timeStamp;
	private int errorResponse;
	private String message;
	private String error;
	public ErrorResponse(LocalDateTime timeStamp, int errorResponse, String message, String error) {
		super();
		this.timeStamp = timeStamp;
		this.errorResponse = errorResponse;
		this.message = message;
		this.error = error;
	}
}
