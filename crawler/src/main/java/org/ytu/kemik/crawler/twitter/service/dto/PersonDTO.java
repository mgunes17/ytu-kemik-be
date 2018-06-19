package org.ytu.kemik.crawler.twitter.service.dto;

public class PersonDTO {
	private Long twitterId;
	private String name;
	private String screenName;
	private Integer follewersCount;
	private Integer followingCount;

	public PersonDTO() {
		super();
	}

	public Long getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(Long twitterId) {
		this.twitterId = twitterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Integer getFollewersCount() {
		return follewersCount;
	}

	public void setFollewersCount(Integer follewersCount) {
		this.follewersCount = follewersCount;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}
}
