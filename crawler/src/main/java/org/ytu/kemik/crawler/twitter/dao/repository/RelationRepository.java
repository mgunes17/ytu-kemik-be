package org.ytu.kemik.crawler.twitter.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ytu.kemik.crawler.twitter.dao.entity.RelationEntity;

public interface RelationRepository extends CrudRepository<RelationEntity, Long> {

	@Query("SELECT r FROM RelationEntity r WHERE r.follower.id = :follower AND r.followed.id = :followed")
	RelationEntity findByFollowerAndFollowed(@Param("follower") Long follower, @Param("followed") Long followed);
}
