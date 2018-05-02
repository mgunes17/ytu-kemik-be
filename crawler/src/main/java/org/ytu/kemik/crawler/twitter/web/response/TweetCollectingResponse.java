package org.ytu.kemik.crawler.twitter.web.response;

public class TweetCollectingResponse {

	private int tweetCount;

	public TweetCollectingResponse(int tweetCount) {
		this.tweetCount = tweetCount;
	}

	public int getTweetCount() {
		return tweetCount;
	}
}
