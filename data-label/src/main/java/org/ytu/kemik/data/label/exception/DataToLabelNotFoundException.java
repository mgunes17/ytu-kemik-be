package org.ytu.kemik.data.label.exception;

public class DataToLabelNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private ExceptionInfo exceptionInfo;
	private String message;

	public DataToLabelNotFoundException(ExceptionInfo exceptionInfo, String message) {
		this.exceptionInfo = exceptionInfo;
		this.message = message;
	}

	public ExceptionInfo getExceptionInfo() {
		return exceptionInfo;
	}

	public String getMessage() {
		return message;
	}
}
