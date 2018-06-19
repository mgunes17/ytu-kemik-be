package org.ytu.kemik.crawler.twitter.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ytu.kemik.crawler.exception.Twitter4jException;
import org.ytu.kemik.crawler.twitter.constant.TwitterConstant;
import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;
import org.ytu.kemik.crawler.twitter.service.dto.PlainTweetDTO;
import org.ytu.kemik.crawler.twitter.service.tweet.TweetCollectionService;
import org.ytu.kemik.crawler.twitter.service.tweet.TweetQueryService;
import org.ytu.kemik.crawler.twitter.web.response.TweetCollectingResponse;

import io.swagger.annotations.ApiModelProperty;

@RestController
@RequestMapping("/tweets")
public class TweetController {

	@Autowired
	private TweetCollectionService tweetCollectionService;

	@Autowired
	private TweetQueryService tweetQueryService;

	@ApiModelProperty("max 100")
	@PostMapping("/hashtags/{hashtag}")
	public ResponseEntity<TweetCollectingResponse> getTweetsByHashTag(@PathVariable String hashtag,
			@RequestParam(name = "count", required = false) Integer count) throws Twitter4jException {

		if (count == null || count < 1)
			count = TwitterConstant.DEFAULT_COUNT_FOR_HASHTAG;

		return new ResponseEntity<>(tweetCollectionService.collectByHashtag(hashtag, count), HttpStatus.CREATED);
	}

	@ApiModelProperty("")
	@PostMapping("/users/{username}")
	public ResponseEntity<TweetCollectingResponse> getTweetsByUsername(@PathVariable String username,
			@RequestParam(name = "count", required = false) Integer count) throws Twitter4jException {

		if (count == null || count < 1)
			count = TwitterConstant.DEFAULT_COUNT_FOR_HASHTAG;

		return new ResponseEntity<>(tweetCollectionService.collectByUsername(username, count), HttpStatus.CREATED);
	}

	@GetMapping("/main-tweets")
	public List<MainTweetEntity> getMainTweets() {
		return tweetQueryService.getAllMainTweets();
	}

	@GetMapping("/plain-tweets")
	public List<PlainTweetDTO> getPlainTweets() {
		return tweetQueryService.getPlaintTweets();
	}

	@ApiModelProperty("max 100")
	@GetMapping("/labels")
	public ResponseEntity<List<PlainTweetDTO>> getTweetsForLabel(@RequestParam(required = true) String projectName,
			@RequestParam(required = true) Integer tweetCount) {
		if (tweetCount < 0 || tweetCount > TwitterConstant.MAX_COUNT_FOR_LABEL)
			tweetCount = TwitterConstant.DEFAULT_COUNT_FOR_LABEL;

		return new ResponseEntity<>(tweetQueryService.getTweetsForLabel(projectName, tweetCount), HttpStatus.OK);
	}
}