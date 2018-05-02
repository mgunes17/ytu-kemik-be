package org.ytu.kemik.crawler.exception;

public enum ExceptionInfo {
	
	TWITTER_NOT_QUERIED_BY_HASHTAG(300L, "Twitter'dan hashtag ile sorgulama yapýlýrken hata oluþtu.");

	private Long id;
	private String message;

	private ExceptionInfo(Long id, String message) {
		this.id = id;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
}
