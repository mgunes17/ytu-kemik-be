package org.ytu.kemik.crawler.twitter.service.impl;

import java.util.List;

import org.ytu.kemik.crawler.exception.Twitter4jException;
import org.ytu.kemik.crawler.twitter.dao.entity.IntactTweetEntity;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;
import org.ytu.kemik.crawler.twitter.web.response.TweetCollectingResponse;

public interface TweetService {

	TweetCollectingResponse collectByHashtag(String hashTag, int count) throws Twitter4jException;

	List<IntactTweetEntity> getAllIntactTweets();

	List<PlainTweetDTO> getPlaintTweets();
}
