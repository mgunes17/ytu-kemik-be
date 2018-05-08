package org.ytu.kemik.crawler.twitter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ytu.kemik.crawler.exception.ExceptionInfo;
import org.ytu.kemik.crawler.exception.Twitter4jException;
import org.ytu.kemik.crawler.twitter.dao.entity.LabeledMainTweetEntity;
import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;
import org.ytu.kemik.crawler.twitter.dao.repository.LabeledMainTweetRepository;
import org.ytu.kemik.crawler.twitter.dao.repository.MainTweetRepository;
import org.ytu.kemik.crawler.twitter.mapper.TweetMapper;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;
import org.ytu.kemik.crawler.twitter.web.response.TweetCollectingResponse;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;

@Service
@Transactional
public class TweetServiceImpl implements TweetService {

	@Autowired
	private Twitter twitter;

	@Autowired
	private MainTweetRepository mainTweetRepository;

	@Autowired
	private LabeledMainTweetRepository labeledMainTweetRepository;

	public TweetCollectingResponse collectByHashtag(String hashtag, Integer count) throws Twitter4jException {
		try {
			Query query = new Query(hashtag);
			query.count(count);
			QueryResult result = twitter.search(query);
			List<Status> statusList = result.getTweets();

			List<MainTweetEntity> mainTweetEntityList = TweetMapper.toMainTweetEntityList(statusList);

			mainTweetRepository.save(mainTweetEntityList);

			return new TweetCollectingResponse(mainTweetEntityList.size());
		} catch (Exception ex) {
			throw new Twitter4jException(ExceptionInfo.TWITTER_NOT_QUERIED_BY_HASHTAG, ex.getMessage());
		}

	}

	@Override
	public List<MainTweetEntity> getAllMainTweets() {
		Iterable<MainTweetEntity> mainTweetIterableList = mainTweetRepository.findAll();

		List<MainTweetEntity> mainTweetList = new ArrayList<>();

		Iterator<MainTweetEntity> iterator = mainTweetIterableList.iterator();

		while (iterator.hasNext()) {
			mainTweetList.add(iterator.next());
		}

		return mainTweetList;
	}

	@Override
	public List<PlainTweetDTO> getPlaintTweets() {
		List<MainTweetEntity> intactTweetList = getAllMainTweets();

		return TweetMapper.toPlaintTweetDTOList(intactTweetList);
	}

	@Override
	public List<PlainTweetDTO> getTweetsForLabel(String projectName, Integer tweetCount) {
		List<MainTweetEntity> mainTweetList = mainTweetRepository.getForLabels(projectName);

		List<LabeledMainTweetEntity> labeledMainTweetEntityList = new ArrayList<>();
		Date createdDate = new Date();

		for (MainTweetEntity mainTweet : mainTweetList) {
			LabeledMainTweetEntity lmt = new LabeledMainTweetEntity();
			lmt.setMainTweet(mainTweet);
			lmt.setProjectName(projectName);
			lmt.setCreatedDate(createdDate);
			labeledMainTweetEntityList.add(lmt);
		}

		labeledMainTweetRepository.save(labeledMainTweetEntityList);

		return TweetMapper.toPlaintTweetDTOList(mainTweetList);
	}

}
