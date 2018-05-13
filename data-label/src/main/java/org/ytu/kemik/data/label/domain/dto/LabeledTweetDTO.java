package org.ytu.kemik.data.label.domain.dto;

import javax.validation.constraints.NotNull;

public class LabeledTweetDTO {

	@NotNull
	private Long simpleDataId;

	@NotNull
	private SentimentLabelType labelType;

	public Long getSimpleDataId() {
		return simpleDataId;
	}

	public void setSimpleDataId(Long simpleDataId) {
		this.simpleDataId = simpleDataId;
	}

	public SentimentLabelType getLabelType() {
		return labelType;
	}

	public void setLabelType(SentimentLabelType labelType) {
		this.labelType = labelType;
	}

}
