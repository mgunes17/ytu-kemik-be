package org.ytu.kemik.data.label.domain.dto;

import javax.validation.constraints.NotNull;

public class LabeledTweetDTO {

	@NotNull
	private Long simpleDataId;

	@NotNull
	private LabelType labelType;

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
