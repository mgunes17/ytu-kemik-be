package org.ytu.kemik.data.label.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.data.label.dao.entity.LabeledSimpleData;
import org.ytu.kemik.data.label.dao.repository.LabelInfoRepository;
import org.ytu.kemik.data.label.dao.repository.LabeledSimpleDataRepository;
import org.ytu.kemik.data.label.domain.mapper.LabelTweetMapper;
import org.ytu.kemik.data.label.exception.DataToLabelNotFoundException;
import org.ytu.kemik.data.label.exception.ExceptionInfo;
import org.ytu.kemik.data.label.external.crawler.client.CrawlerFeignService;
import org.ytu.kemik.data.label.external.crawler.response.PlainTweetDTO;
import org.ytu.kemik.data.label.web.response.TweetCandidateResponse;

@Service
public class RetrievalDataServiceImpl implements RetrievalDataService {

	private static final String SOURCE_TYPE = "TWITTER";

	@Autowired
	private CrawlerFeignService crawlerService;

	@Autowired
	private LabeledSimpleDataRepository labeledSimpleDataRepository;
	
	@Autowired
	private LabelInfoRepository labelInfoRepository;

	@Override
	public List<TweetCandidateResponse> getTweetsForLabel(String projectName, Integer count)
			throws DataToLabelNotFoundException {

		List<LabeledSimpleData> simpleDataList = labeledSimpleDataRepository.getNotLabeled(count);

		if (!simpleDataList.isEmpty()) {
			return LabelTweetMapper.toTweetCandidateResponse(simpleDataList);
		} else {
			List<PlainTweetDTO> plainTweetList = crawlerService.getTweetsForLabel(projectName, 100);

			if (!plainTweetList.isEmpty()) {
				List<LabeledSimpleData> newSimpleDataList = LabelTweetMapper.toLabeledSimpleData(plainTweetList,
						SOURCE_TYPE, projectName);
				labeledSimpleDataRepository.saveAll(newSimpleDataList);

				simpleDataList = labeledSimpleDataRepository.getNotLabeled(count);
				return LabelTweetMapper.toTweetCandidateResponse(simpleDataList);
			} else {
				throw new DataToLabelNotFoundException(ExceptionInfo.DATA_NOT_FOUND_FOR_LABEL,
						"Project name: " + projectName);
			}
		}
	}

	@Override
	public Integer getUserLabelCount(String username) {
		return labelInfoRepository.getLabeledCountForUsername(username);
	}
	
}
