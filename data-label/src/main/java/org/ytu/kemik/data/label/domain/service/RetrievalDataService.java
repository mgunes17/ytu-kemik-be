package org.ytu.kemik.data.label.domain.service;

import java.util.List;

import org.ytu.kemik.data.label.exception.DataToLabelNotFoundException;
import org.ytu.kemik.data.label.web.response.TweetCandidateResponse;

public interface RetrievalDataService {

	List<TweetCandidateResponse> getTweetsForLabel(String projectName, Integer count)
			throws DataToLabelNotFoundException;
}
