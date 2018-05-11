package org.ytu.kemik.data.label.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.data.label.domain.mapper.LabelTweetMapper;
import org.ytu.kemik.data.label.external.crawler.client.CrawlerService;
import org.ytu.kemik.data.label.external.crawler.response.PlainTweetDTO;
import org.ytu.kemik.data.label.web.response.TweetCandidateResponse;

@Service
public class RetrievalDataServiceImpl implements RetrievalDataService {

	@Autowired
	private CrawlerService crawlerService;

	@Override
	public List<TweetCandidateResponse> getTweetsForLabel(String projectName, Integer count) {
		List<PlainTweetDTO> plainTweetList = crawlerService.getTweetsForLabel(projectName, count);

		return LabelTweetMapper.toTweetCandidateResponse(plainTweetList);
	}

}
