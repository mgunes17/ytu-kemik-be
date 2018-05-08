package org.ytu.kemik.crawler.twitter.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;

public interface MainTweetRepository extends CrudRepository<MainTweetEntity, Long> {

	// TODO LIMIT
	@Query("SELECT t FROM MainTweetEntity t WHERE NOT EXISTS ("
			+ "SELECT labeled.mainTweet FROM "
			+ "LabeledMainTweetEntity labeled WHERE t.id = labeled.mainTweet.id AND labeled.projectName = :projectName) ")
	List<MainTweetEntity> getForLabels(@Param("projectName") String projectName);

}
