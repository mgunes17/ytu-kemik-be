package org.ytu.kemik.crawler.twitter.service.person;

import java.util.List;

import org.ytu.kemik.crawler.twitter.service.dto.RelationGroup;

public interface RelationService {

	Boolean createRelation(List<RelationGroup> relationGroupList);

}
