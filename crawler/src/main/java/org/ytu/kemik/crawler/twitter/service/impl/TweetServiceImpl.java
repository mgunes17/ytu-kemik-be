package org.ytu.kemik.crawler.twitter.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.crawler.exception.ExceptionInfo;
import org.ytu.kemik.crawler.exception.Twitter4jException;
import org.ytu.kemik.crawler.twitter.dao.entity.IntactTweetEntity;
import org.ytu.kemik.crawler.twitter.dao.repository.IntactTweetRepository;
import org.ytu.kemik.crawler.twitter.mapper.TweetMapper;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;
import org.ytu.kemik.crawler.twitter.web.response.TweetCollectingResponse;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private Twitter twitter;

	@Autowired
	private IntactTweetRepository intactTweetRepository;

	public TweetCollectingResponse collectByHashtag(String hashtag, int count) throws Twitter4jException {
		try {
			Query query = new Query(hashtag);
			query.count(count);
			QueryResult result = twitter.search(query);
			List<Status> statusList = result.getTweets();

			List<IntactTweetEntity> intactTweetEntityList = TweetMapper.toIntactTweetEntityList(statusList);

			intactTweetRepository.save(intactTweetEntityList);

			return new TweetCollectingResponse(intactTweetEntityList.size());
		} catch (Exception ex) {
			throw new Twitter4jException(ExceptionInfo.TWITTER_NOT_QUERIED_BY_HASHTAG, ex.getMessage());
		}

	}

	@Override
	public List<IntactTweetEntity> getAllIntactTweets() {
		Iterable<IntactTweetEntity> intactTweetIterableList = intactTweetRepository.findAll();

		List<IntactTweetEntity> intactTweetList = new ArrayList<>();

		Iterator<IntactTweetEntity> iterator = intactTweetIterableList.iterator();

		while (iterator.hasNext()) {
			intactTweetList.add(iterator.next());
		}

		return intactTweetList;
	}

	@Override
	public List<PlainTweetDTO> getPlaintTweets() {
		List<IntactTweetEntity> intactTweetList = getAllIntactTweets();

		return TweetMapper.toPlaintTweetDTOList(intactTweetList);
	}

}
