package org.ytu.kemik.data.label.external.crawler.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.data.label.external.crawler.response.PlainTweetDTO;

@Service
public class CrawlerFeignService {

	@Autowired
	private CrawlerClient crawlerClient;

//	@HystrixCommand(fallbackMethod = "timeoutHandler")
	public List<PlainTweetDTO> getTweetsForLabel(String projectName, Integer count) {
		return crawlerClient.getTweetsForLabel(projectName, count).getBody();
	}

//	private void timeoutHandler() throws FeignClientException {
//		throw new FeignClientException(ExceptionInfo.FEIGN_CLIENT_NOT_AVAILABLE, "Feign client: crawler");
//	}
}
