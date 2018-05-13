package org.ytu.kemik.crawler.twitter.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;

public interface MainTweetRepository extends CrudRepository<MainTweetEntity, Long> {

	@Query(value = "SELECT * FROM crawler.main_tweet m WHERE NOT EXISTS (" + "SELECT main_tweet_id FROM "
			+ "crawler.labeled_main_tweet labeled WHERE m.id = labeled.main_tweet_id AND "
			+ "labeled.project_name = :projectName) LIMIT :count", nativeQuery = true)
	List<MainTweetEntity> getForLabels(@Param("projectName")String projectName, @Param("count") Integer count);

}
