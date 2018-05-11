package org.ytu.kemik.data.label.web.request;

import org.ytu.kemik.data.label.domain.dto.LabelOption;

import io.swagger.annotations.ApiModel;

@ApiModel
public class TweetCandidateRequest {

	private String userToken; // TODO userToken == username from manager --> bff
	private String username;
	private String projectName; // TODO kayıtlı mı kontrolü
	private LabelOption labelOption; // TODO
	private Integer tweetCount;

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

	public LabelOption getLabelOption() {
		return labelOption;
	}

	public void setLabelOption(LabelOption labelOption) {
		this.labelOption = labelOption;
	}

	public Integer getTweetCount() {
		return tweetCount;
	}

	public void setTweetCount(Integer tweetCount) {
		this.tweetCount = tweetCount;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
