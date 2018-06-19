package org.ytu.kemik.crawler.twitter.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ytu.kemik.crawler.twitter.service.dto.PersonDTO;
import org.ytu.kemik.crawler.twitter.service.dto.RelationGroup;
import org.ytu.kemik.crawler.twitter.service.person.PersonService;
import org.ytu.kemik.crawler.twitter.web.request.CreateRelationRequest;

@RestController
@RequestMapping("/relations")
public class RelationController {

	private final PersonService personService;

	@Autowired
	public RelationController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<RelationGroup>> setRelations(@RequestBody @Validated CreateRelationRequest request) {
		List<RelationGroup> response = personService.createRelationship(request);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/users/{username}/follewers", method = RequestMethod.GET)
	public ResponseEntity<List<PersonDTO>> getFollowerList(@PathVariable String username) {
		return new ResponseEntity<>(personService.getFollowerList(username), HttpStatus.OK);
	}
}
