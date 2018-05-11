package org.ytu.kemik.data.label.web.response;

public class TweetCandidateResponse {

	private Long simpleDataId;
	private String content;

	public TweetCandidateResponse() {
		super();
	}

	public TweetCandidateResponse(Long simpleDataId, String content) {
		super();
		this.simpleDataId = simpleDataId;
		this.content = content;
	}

	public Long getSimpleDataId() {
		return simpleDataId;
	}

	public void setSimpleDataId(Long simpleDataId) {
		this.simpleDataId = simpleDataId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
