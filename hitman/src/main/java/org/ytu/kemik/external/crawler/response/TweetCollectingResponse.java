package org.ytu.kemik.external.crawler.response;

public class TweetCollectingResponse {

	private int tweetCount;

	public TweetCollectingResponse(int tweetCount) {
		this.tweetCount = tweetCount;
	}

	public int getTweetCount() {
		return tweetCount;
	}
}
