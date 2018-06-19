package org.ytu.kemik.crawler.twitter.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ytu.kemik.crawler.twitter.dao.entity.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

	PersonEntity findByScreenName(String screenName);

	@Query("SELECT p.name From PersonEntity p WHERE p.twitterId = :id")
	String findByTwitterId(@Param("id") Long twitterId);
}