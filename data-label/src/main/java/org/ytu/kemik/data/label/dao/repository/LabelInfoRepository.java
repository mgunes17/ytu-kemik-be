package org.ytu.kemik.data.label.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ytu.kemik.data.label.dao.entity.LabelInfo;

public interface LabelInfoRepository extends JpaRepository<LabelInfo, Long> {
	
	@Query(value = "SELECT count(id) FROM label.label_info WHERE username = :username", nativeQuery = true)
	Integer getLabeledCountForUsername(@Param("username") String username);
	
	
	
}
