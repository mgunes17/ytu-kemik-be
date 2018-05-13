package org.ytu.kemik.data.label.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

	@PostMapping("/tweets")
	public ResponseEntity<List<TweetCandidateResponse>> getTweetsForLabel(
			@RequestBody @Validated TweetCandidateRequest request) throws DataToLabelNotFoundException {

		List<TweetCandidateResponse> responseList = retrievalDataService.getTweetsForLabel(request.getProjectName(),
				request.getTweetCount());

		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}

	@PatchMapping("/tweets")
	public ResponseEntity<?> labelTweets(@RequestBody @Validated List<TweetLabelRequest> request) {
		return null;
	}
}
