package org.ytu.kemik.data.label.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ytu.kemik.data.label.domain.service.LabelParameterService;
import org.ytu.kemik.data.label.domain.service.LabelTweetService;
import org.ytu.kemik.data.label.domain.service.RetrievalDataService;
import org.ytu.kemik.data.label.exception.DataToLabelNotFoundException;
import org.ytu.kemik.data.label.web.request.TweetCandidateRequest;
import org.ytu.kemik.data.label.web.request.TweetLabelRequest;
import org.ytu.kemik.data.label.web.response.TweetCandidateResponse;

@RestController
@RequestMapping("/data")
@CrossOrigin
public class RetrievalDataController {

	@Autowired
	private RetrievalDataService retrievalDataService;

	@Autowired
	private LabelTweetService labelTweetService;

	@Autowired
	private LabelParameterService labelParameterService;

	@PostMapping("/tweets/simple-data")
	public ResponseEntity<List<TweetCandidateResponse>> getTweetsForLabel(
			@RequestBody @Validated TweetCandidateRequest request) throws DataToLabelNotFoundException {

		List<TweetCandidateResponse> responseList = retrievalDataService.getTweetsForLabel(request.getProjectName(),
				request.getTweetCount());

		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}

	@PostMapping("/tweets/label-informations")
	public ResponseEntity<?> labelTweets(@RequestBody @Validated TweetLabelRequest request) {
		labelTweetService.labelTweets(request);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/data/labels")
	public ResponseEntity<List<String>> getLabelOptions(@RequestParam("labelCode") String labelCode) {
		return new ResponseEntity<>(labelParameterService.getLabelList(labelCode), HttpStatus.OK);
	}
	
	@GetMapping("/data/userLabelCount")
	public ResponseEntity<Integer> getUserLabelCount(@RequestParam("username") String username) {
		return new ResponseEntity<>(retrievalDataService.getUserLabelCount(username), HttpStatus.OK);
	}
}
