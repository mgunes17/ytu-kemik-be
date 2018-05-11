package org.ytu.kemik.data.label.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import org.ytu.kemik.data.label.external.crawler.response.PlainTweetDTO;
import org.ytu.kemik.data.label.web.response.TweetCandidateResponse;

public class LabelTweetMapper {

	public static List<TweetCandidateResponse> toTweetCandidateResponse(List<PlainTweetDTO> plainTweetList) {
		List<TweetCandidateResponse> candidateList = new ArrayList<>();

		plainTweetList.forEach(plainTweet -> candidateList
				.add(new TweetCandidateResponse(plainTweet.getId(), plainTweet.getTweetBody())));

		return candidateList;
	}

}
