package org.ytu.kemik.crawler.twitter.service.tweet;

import java.util.List;

import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;

public interface TweetQueryService {

	List<MainTweetEntity> getAllMainTweets();

	List<PlainTweetDTO> getPlaintTweets();

	List<PlainTweetDTO> getTweetsForLabel(String projectName, Integer tweetCount);
}
