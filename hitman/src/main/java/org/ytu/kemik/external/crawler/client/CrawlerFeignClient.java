package org.ytu.kemik.external.crawler.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ytu.kemik.external.crawler.response.TweetCollectingResponse;

@FeignClient(value = "crawler")
public interface CrawlerFeignClient {

	@PostMapping("/tweets/hashtags/{hashtag}")
	ResponseEntity<TweetCollectingResponse> getTweetsByHashTag(@PathVariable("hashtag") String hashtag,
			@RequestParam("count") Integer count);
}
