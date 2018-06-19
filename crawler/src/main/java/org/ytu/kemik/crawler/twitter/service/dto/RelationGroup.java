package org.ytu.kemik.crawler.twitter.service.dto;

import java.util.List;

public class RelationGroup {
	private PersonDTO person;
	private List<PersonDTO> followerList;

	public RelationGroup() {
		super();
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	public List<PersonDTO> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(List<PersonDTO> followerList) {
		this.followerList = followerList;
	}
}
