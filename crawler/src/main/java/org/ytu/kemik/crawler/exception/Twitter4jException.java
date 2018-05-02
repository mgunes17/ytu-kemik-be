package org.ytu.kemik.crawler.exception;

public class Twitter4jException extends Exception {

	private static final long serialVersionUID = 1L;

	private ExceptionInfo exceptionInfo;
	private String message;

	public Twitter4jException(ExceptionInfo exceptionInfo, String message) {
		this.exceptionInfo = exceptionInfo;
	}

	public ExceptionInfo getExceptionInfo() {
		return exceptionInfo;
	}
	
	public String getMessage() {
		return message;
	}
}
