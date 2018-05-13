package org.ytu.kemik.data.label.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ytu.kemik.data.label.dao.entity.LabeledSimpleData;

public interface LabeledSimpleDataRepository extends JpaRepository<LabeledSimpleData, Long> {

	@Query(value = "SELECT * FROM label.labeled_simple_data WHERE label is NULL ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
	List<LabeledSimpleData> getNotLabeled(@Param("count") Integer count);

}
