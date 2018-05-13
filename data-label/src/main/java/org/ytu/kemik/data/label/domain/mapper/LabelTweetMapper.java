package org.ytu.kemik.data.label.domain.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ytu.kemik.data.label.dao.entity.LabeledSimpleData;
import org.ytu.kemik.data.label.external.crawler.response.PlainTweetDTO;
import org.ytu.kemik.data.label.web.response.TweetCandidateResponse;

public class LabelTweetMapper {

	public static List<TweetCandidateResponse> toTweetCandidateResponse(List<LabeledSimpleData> simpleDataList) {
		List<TweetCandidateResponse> candidateList = new ArrayList<>();

		simpleDataList.forEach(simpleData -> candidateList
				.add(new TweetCandidateResponse(simpleData.getId(), simpleData.getContent())));

		return candidateList;
	}

	public static List<LabeledSimpleData> toLabeledSimpleData(List<PlainTweetDTO> plainTweetList, String sourceType,
			String projectName) {

		List<LabeledSimpleData> simpleDataList = new ArrayList<>();
		Date createdDate = new Date();

		for (PlainTweetDTO plainTweet : plainTweetList) {
			LabeledSimpleData labeledSimpleData = new LabeledSimpleData();

			labeledSimpleData.setIdFromSource(String.valueOf(plainTweet.getId()));
			labeledSimpleData.setContent(plainTweet.getTweetBody());
			labeledSimpleData.setSourceType(sourceType);
			labeledSimpleData.setProjectName(projectName);
			labeledSimpleData.setDataCreatedDate(createdDate);

			simpleDataList.add(labeledSimpleData);
		}

		return simpleDataList;
	}

}
