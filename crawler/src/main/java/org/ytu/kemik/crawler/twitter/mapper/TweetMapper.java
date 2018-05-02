package org.ytu.kemik.crawler.twitter.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.ytu.kemik.crawler.twitter.dao.entity.IntactTweetEntity;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;

import twitter4j.Status;

public class TweetMapper {

	public static List<IntactTweetEntity> toIntactTweetEntityList(List<Status> statusList) {
		List<IntactTweetEntity> intactTweetList = new ArrayList<IntactTweetEntity>();
		IntactTweetEntity intactTweet;

		LocalDateTime crawledDate = LocalDateTime.now();

		for (Status status : statusList) {
			intactTweet = new IntactTweetEntity();
			intactTweet.setId(status.getId());
			intactTweet.setScreenName(status.getUser().getScreenName());
			intactTweet.setFavoriteCount(status.getFavoriteCount());
			intactTweet
					.setCreatedDate(LocalDateTime.ofInstant(status.getCreatedAt().toInstant(), ZoneId.systemDefault()));
			intactTweet.setTweet(status.getText());
			intactTweet.setUserName(status.getUser().getName());
			intactTweet.setRetweetCount(status.getRetweetCount());
			intactTweet.setCrawledDate(crawledDate);

			intactTweetList.add(intactTweet);
		}
		return intactTweetList;
	}

	public static List<PlainTweetDTO> toPlaintTweetDTOList(List<IntactTweetEntity> intactTweetList) {
		List<PlainTweetDTO> plainTweetList = new ArrayList<>();

		intactTweetList.forEach(intact -> plainTweetList
				.add(new PlainTweetDTO(intact.getId(), intact.getScreenName(), intact.getTweet())));

		return plainTweetList;
	}
}
