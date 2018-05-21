package org.ytu.kemik.crawler.twitter.web.response;

public class TweetCollectingResponse {

	private Integer tweetCount;

	public TweetCollectingResponse(Integer tweetCount) {
		this.tweetCount = tweetCount;
	}

	public Integer getTweetCount() {
		return tweetCount;
	}
}
