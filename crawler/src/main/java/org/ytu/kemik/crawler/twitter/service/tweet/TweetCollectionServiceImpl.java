package org.ytu.kemik.crawler.twitter.service.tweet;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.crawler.common.filter.LanguageFilter;
import org.ytu.kemik.crawler.exception.ExceptionInfo;
import org.ytu.kemik.crawler.exception.Twitter4jException;
import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;
import org.ytu.kemik.crawler.twitter.dao.repository.MainTweetRepository;
import org.ytu.kemik.crawler.twitter.mapper.TweetMapper;
import org.ytu.kemik.crawler.twitter.web.response.TweetCollectingResponse;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;

@Service
@Transactional
public class TweetCollectionServiceImpl implements TweetCollectionService {

	@Autowired
	private Twitter twitter;

	@Autowired
	private MainTweetRepository mainTweetRepository;

	public TweetCollectingResponse collectByHashtag(String hashtag, Integer count) throws Twitter4jException {
		try {
			Query query = new Query(hashtag);
			query.count(count);
			QueryResult result = twitter.search(query);
			List<Status> statusList = result.getTweets();

			List<MainTweetEntity> mainTweetEntityList = TweetMapper.toMainTweetEntityList(statusList);
			
			LanguageFilter isLangTR = new LanguageFilter("tr");
			mainTweetEntityList.removeIf(tweet -> !isLangTR.test(tweet.getTweet()));
			
			mainTweetRepository.saveAll(mainTweetEntityList);

			return new TweetCollectingResponse(mainTweetEntityList.size());
		} catch (Exception ex) {
			throw new Twitter4jException(ExceptionInfo.TWITTER_NOT_QUERIED_BY_HASHTAG, ex.getMessage());
		}

	}

	@Override
	public TweetCollectingResponse collectByUsername(String username, Integer count) throws Twitter4jException {
		try {
			Paging paging = new Paging(1, count);
			List<Status> statusList = twitter.getUserTimeline(username, paging);
			List<MainTweetEntity> mainTweetEntityList = TweetMapper.toMainTweetEntityList(statusList);

			mainTweetRepository.saveAll(mainTweetEntityList);

			return new TweetCollectingResponse(mainTweetEntityList.size());
		} catch (Exception ex) {
			throw new Twitter4jException(ExceptionInfo.TWITTER_NOT_QUERIED_BY_HASHTAG, ex.getMessage());
		}
	}

}
