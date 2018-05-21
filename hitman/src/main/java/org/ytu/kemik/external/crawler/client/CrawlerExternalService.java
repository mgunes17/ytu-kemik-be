package org.ytu.kemik.external.crawler.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.external.crawler.response.TweetCollectingResponse;

@Service
public class CrawlerExternalService {

	@Autowired
	private CrawlerFeignClient crawlerFeignClient;

	public TweetCollectingResponse getTweetsByHashTag(String hashtag, Integer tweetCount) {
		return crawlerFeignClient.getTweetsByHashTag(hashtag, tweetCount).getBody();
	}
}
