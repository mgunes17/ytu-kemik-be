package org.ytu.kemik.crawler.twitter.service.person;

import java.util.List;

import org.ytu.kemik.crawler.twitter.service.dto.PersonDTO;
import org.ytu.kemik.crawler.twitter.service.dto.RelationGroup;
import org.ytu.kemik.crawler.twitter.web.request.CreateRelationRequest;

public interface PersonService {

	List<RelationGroup> createRelationship(CreateRelationRequest request);

	List<PersonDTO> getFollowerList(String username);
}
