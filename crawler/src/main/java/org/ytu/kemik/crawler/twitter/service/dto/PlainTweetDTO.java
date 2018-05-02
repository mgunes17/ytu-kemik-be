package org.ytu.kemik.crawler.twitter.service.dto;

public class PlainTweetDTO {

	private long id;
	private String screenName;
	private String tweetBody;

	public PlainTweetDTO() {
		super();
	}

	public PlainTweetDTO(long id, String screenName, String tweetBody) {
		super();
		this.id = id;
		this.screenName = screenName;
		this.tweetBody = tweetBody;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

}
