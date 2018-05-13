package org.ytu.kemik.data.label.external.crawler.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ytu.kemik.data.label.external.crawler.response.PlainTweetDTO;

@org.springframework.cloud.openfeign.FeignClient(value = "crawler")
public interface CrawlerClient {

	@GetMapping("/tweets/labels")
	ResponseEntity<List<PlainTweetDTO>> getTweetsForLabel(@RequestParam("projectName") String projectName,
			@RequestParam("tweetCount") Integer tweetCount);

}
