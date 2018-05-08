package org.ytu.kemik.crawler.twitter.service.impl;

import java.util.List;

import org.ytu.kemik.crawler.exception.Twitter4jException;
import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;
import org.ytu.kemik.crawler.twitter.web.response.TweetCollectingResponse;

public interface TweetService {

	TweetCollectingResponse collectByHashtag(String hashTag, Integer count) throws Twitter4jException;

	List<MainTweetEntity> getAllMainTweets();

	List<PlainTweetDTO> getPlaintTweets();

	List<PlainTweetDTO> getTweetsForLabel(String projectName, Integer tweetCount);
}
