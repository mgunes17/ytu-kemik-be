package org.ytu.kemik.data.label.domain.dto;

import javax.validation.constraints.NotNull;

public class LabeledTweetDTO {

	@NotNull
	private String username;

	@NotNull
	private String userToken;

	@NotNull
	private Long simpleDataId;

	@NotNull
	private LabelType labelType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Long getSimpleDataId() {
		return simpleDataId;
	}

	public void setSimpleDataId(Long simpleDataId) {
		this.simpleDataId = simpleDataId;
	}

	public LabelType getLabelType() {
		return labelType;
	}

	public void setLabelType(LabelType labelType) {
		this.labelType = labelType;
	}

}
