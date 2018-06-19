package org.ytu.kemik.crawler.twitter.service.tweet;

import org.ytu.kemik.crawler.exception.Twitter4jException;
import org.ytu.kemik.crawler.twitter.web.response.TweetCollectingResponse;

public interface TweetCollectionService {

	TweetCollectingResponse collectByHashtag(String hashTag, Integer count) throws Twitter4jException;

	TweetCollectingResponse collectByUsername(String username, Integer count) throws Twitter4jException;
}
