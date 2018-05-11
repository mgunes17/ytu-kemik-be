package org.ytu.kemik.data.label.external.crawler.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.data.label.external.crawler.response.PlainTweetDTO;

@Service
public class CrawlerService {

	@Autowired
	private CrawlerClient crawlerClient;

	public List<PlainTweetDTO> getTweetsForLabel(String projectName, Integer count) {
		return crawlerClient.getTweetsForLabel(projectName, count).getBody();
	}

}
