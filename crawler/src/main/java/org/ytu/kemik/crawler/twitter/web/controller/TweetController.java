package org.ytu.kemik.crawler.twitter.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ytu.kemik.crawler.exception.Twitter4jException;
import org.ytu.kemik.crawler.twitter.dao.entity.IntactTweetEntity;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;
import org.ytu.kemik.crawler.twitter.service.impl.TweetService;
import org.ytu.kemik.crawler.twitter.web.response.TweetCollectingResponse;

@RestController
@RequestMapping("/tweets")
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@PostMapping("/hashtags/{hashtag}")
	public TweetCollectingResponse getTweetsByHashTag(@PathVariable String hashtag, @RequestParam("count") int count)
			throws Twitter4jException {

		return tweetService.collectByHashtag(hashtag, count);
	}

	@GetMapping("/intact-tweets")
	public List<IntactTweetEntity> getIntactTweets() {
		return tweetService.getAllIntactTweets();
	}

	@GetMapping("/plain-tweets")
	public List<PlainTweetDTO> getPlainTweets() {
		return tweetService.getPlaintTweets();
	}
}
