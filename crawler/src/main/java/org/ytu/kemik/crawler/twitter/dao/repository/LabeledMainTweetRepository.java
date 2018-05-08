package org.ytu.kemik.crawler.twitter.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.ytu.kemik.crawler.twitter.dao.entity.LabeledMainTweetEntity;

public interface LabeledMainTweetRepository extends CrudRepository<LabeledMainTweetEntity, Long> {

	// @Query("SELECT intact_tweet_id FROM labeled_intact_tweet WHERE project_name
	// <> ?0")
	// Set<Long> getNotLabeledIntactTweets(String projectName);
}
