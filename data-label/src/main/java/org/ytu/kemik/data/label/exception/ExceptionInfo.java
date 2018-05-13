package org.ytu.kemik.data.label.exception;

public enum ExceptionInfo {

	DATA_NOT_FOUND_FOR_LABEL(401L, "Etiketlenecek veri bulunamadı."),
	FEIGN_CLIENT_NOT_AVAILABLE(402l, "Uzak servisten cevap alınamadı");

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
