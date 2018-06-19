package org.ytu.kemik.crawler.twitter.service.tweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ytu.kemik.crawler.twitter.dao.entity.LabeledMainTweetEntity;
import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;
import org.ytu.kemik.crawler.twitter.dao.repository.LabeledMainTweetRepository;
import org.ytu.kemik.crawler.twitter.dao.repository.MainTweetRepository;
import org.ytu.kemik.crawler.twitter.mapper.TweetMapper;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;

@Service
@Transactional
public class TweetQueryServivceImpl implements TweetQueryService {

	@Autowired
	private LabeledMainTweetRepository labeledMainTweetRepository;

	@Autowired
	private MainTweetRepository mainTweetRepository;

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
		List<MainTweetEntity> mainTweetList = mainTweetRepository.getForLabels(projectName, tweetCount);

		List<LabeledMainTweetEntity> labeledMainTweetEntityList = new ArrayList<>();
		Date createdDate = new Date();

		for (MainTweetEntity mainTweet : mainTweetList) {
			LabeledMainTweetEntity lmt = new LabeledMainTweetEntity();
			lmt.setMainTweet(mainTweet);
			lmt.setProjectName(projectName);
			lmt.setCreatedDate(createdDate);
			labeledMainTweetEntityList.add(lmt);
		}

		labeledMainTweetRepository.saveAll(labeledMainTweetEntityList);

		return TweetMapper.toPlaintTweetDTOList(mainTweetList);
	}

}
