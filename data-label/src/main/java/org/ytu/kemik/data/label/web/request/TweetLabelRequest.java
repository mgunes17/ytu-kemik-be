package org.ytu.kemik.data.label.web.request;

import java.util.List;

import org.ytu.kemik.data.label.domain.dto.LabeledTweetDTO;

public class TweetLabelRequest {

	private String userToken;
	private String username;
	private List<LabeledTweetDTO> labeledTweetDTOList;

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LabeledTweetDTO> getLabeledTweetDTOList() {
		return labeledTweetDTOList;
	}

	public void setLabeledTweetDTOList(List<LabeledTweetDTO> labeledTweetDTOList) {
		this.labeledTweetDTOList = labeledTweetDTOList;
	}

}
