package org.ytu.kemik.crawler.twitter.service.person;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.crawler.twitter.service.dto.PersonDTO;
import org.ytu.kemik.crawler.twitter.service.dto.RelationGroup;
import org.ytu.kemik.crawler.twitter.web.request.CreateRelationRequest;

import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.User;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private RelationService relationService;

	@Autowired
	private Twitter twitter;

	public List<PersonDTO> getFollowerList(String username) {
		List<PersonDTO> followerList = new ArrayList<>();

		long cursor = -1;
		PagableResponseList<User> responseList;

		try {
			do {
				responseList = twitter.getFollowersList(username, cursor);

				for (User user : responseList) {
					PersonDTO person = new PersonDTO();
					person.setTwitterId(user.getId());
					person.setName(user.getName());
					person.setScreenName(user.getScreenName());
					person.setFollewersCount(user.getFollowersCount());
					person.setFollowingCount(user.getFriendsCount());

					followerList.add(person);
				}
			} while ((cursor = responseList.getNextCursor()) != 0);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return followerList;
	}

	public List<RelationGroup> createRelationship(CreateRelationRequest request) {
		Queue<String> crawlerQueue = new PriorityQueue<>();
		crawlerQueue.offer(request.getScreenName());
		List<RelationGroup> relationGroupList = new ArrayList<>();

		for (int index = 0; index < request.getCount(); index++) {
			try {
				String screenName = crawlerQueue.poll();
				List<PersonDTO> followerList = new ArrayList<>();
				long cursor = -1;
				PagableResponseList<User> responseList;

				User selectedUser = twitter.showUser(screenName);
				PersonDTO selectedPerson = preparePersonDTO(selectedUser);

				do {
					responseList = twitter.getFollowersList(screenName, cursor);

					for (User user : responseList) {
						PersonDTO person = preparePersonDTO(user);

						followerList.add(person);
						crawlerQueue.offer(person.getScreenName());
					}
				} while ((cursor = responseList.getNextCursor()) != 0);

				RelationGroup relationGroup = new RelationGroup();
				relationGroup.setPerson(selectedPerson);
				relationGroup.setFollowerList(followerList);

				relationGroupList.add(relationGroup);

				relationService.createRelation(relationGroupList);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				relationService.createRelation(relationGroupList);
			}
		}

		return relationGroupList;
	}

	public PersonDTO preparePersonDTO(User user) {
		PersonDTO person = new PersonDTO();
		person.setTwitterId(user.getId());
		person.setName(user.getName());
		person.setScreenName(user.getScreenName());
		person.setFollewersCount(user.getFollowersCount());
		person.setFollowingCount(user.getFriendsCount());

		return person;
	}
}
