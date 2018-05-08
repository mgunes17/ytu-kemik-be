package org.ytu.kemik.crawler.twitter.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;

import twitter4j.Status;

public class TweetMapper {

	public static List<MainTweetEntity> toMainTweetEntityList(List<Status> statusList) {
		List<MainTweetEntity> intactTweetList = new ArrayList<MainTweetEntity>();
		MainTweetEntity mainTweet;

		Date crawledDate = new Date();

		for (Status status : statusList) {
			mainTweet = new MainTweetEntity();
			mainTweet.setId(status.getId());
			mainTweet.setScreenName(status.getUser().getScreenName());
			mainTweet.setFavoriteCount(status.getFavoriteCount());
			mainTweet.setTweetedDate(status.getCreatedAt());
			mainTweet.setTweet(status.getText());
			mainTweet.setUserName(status.getUser().getName());
			mainTweet.setRetweetCount(status.getRetweetCount());
			mainTweet.setCreatedDate(crawledDate);

			intactTweetList.add(mainTweet);
		}
		return intactTweetList;
	}

	public static List<PlainTweetDTO> toPlaintTweetDTOList(List<MainTweetEntity> mainTweetList) {
		List<PlainTweetDTO> plainTweetList = new ArrayList<>();

		mainTweetList.forEach(
				main -> plainTweetList.add(new PlainTweetDTO(main.getId(), main.getScreenName(), main.getTweet())));

		return plainTweetList;
	}
}
