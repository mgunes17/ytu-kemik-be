package org.ytu.kemik.crawler.twitter.service.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ytu.kemik.crawler.twitter.dao.entity.PersonEntity;
import org.ytu.kemik.crawler.twitter.dao.entity.RelationEntity;
import org.ytu.kemik.crawler.twitter.dao.repository.PersonRepository;
import org.ytu.kemik.crawler.twitter.dao.repository.RelationRepository;
import org.ytu.kemik.crawler.twitter.service.dto.PersonDTO;
import org.ytu.kemik.crawler.twitter.service.dto.RelationGroup;

@Service
@Transactional
public class RelationServiceImpl implements RelationService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private RelationRepository relationRepository;

	public Boolean createRelation(List<RelationGroup> relationGroupList) {
		for (RelationGroup group : relationGroupList) {
			PersonDTO selectedPerson = group.getPerson();

			PersonEntity entity = personRepository.findByScreenName(selectedPerson.getScreenName());

			if (entity == null) {
				savePerson(selectedPerson);
				entity = personRepository.findByScreenName(selectedPerson.getScreenName());
			}

			for (PersonDTO personDTO : group.getFollowerList()) {
				PersonEntity followerEntity = personRepository.findByScreenName(personDTO.getScreenName());

				if (followerEntity == null) {
					savePerson(personDTO);
					followerEntity = personRepository.findByScreenName(personDTO.getScreenName());
				}

				RelationEntity relationEntity = relationRepository.findByFollowerAndFollowed(followerEntity.getId(),
						entity.getId());

				if (relationEntity == null) {
					relationEntity = new RelationEntity();
					relationEntity.setFollower(followerEntity);
					relationEntity.setFollowed(entity);

					relationRepository.save(relationEntity);
				}
			}
		}

		return true;
	}

	public Boolean savePerson(PersonDTO personDTO) {
		PersonEntity entity = new PersonEntity();
		entity.setFollewersCount(personDTO.getFollewersCount());
		entity.setFollowingCount(personDTO.getFollowingCount());
		entity.setName(personDTO.getName());
		entity.setScreenName(personDTO.getScreenName());
		entity.setTwitterId(personDTO.getTwitterId());

		personRepository.save(entity);

		return true;
	}
}
