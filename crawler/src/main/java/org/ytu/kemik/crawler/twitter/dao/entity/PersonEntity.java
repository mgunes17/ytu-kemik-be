package org.ytu.kemik.crawler.twitter.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TWITTER_USER", schema = "crawler")
public class PersonEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "TWITTER_ID", nullable = false, unique = true)
	private Long twitterId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SCREEN_NAME", nullable = false, unique = true)
	private String screenName;

	@Column(name = "FOLLOWERS_COUNT")
	private Integer follewersCount;

	@Column(name = "FOLLOWING_COUNT")
	private Integer followingCount;

	@OneToMany(mappedBy = "follower", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<RelationEntity> followingList;

	@OneToMany(mappedBy = "followed", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<RelationEntity> followedList;

	public PersonEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(Long twitterId) {
		this.twitterId = twitterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Integer getFollewersCount() {
		return follewersCount;
	}

	public void setFollewersCount(Integer follewersCount) {
		this.follewersCount = follewersCount;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public List<RelationEntity> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(List<RelationEntity> followingList) {
		this.followingList = followingList;
	}

	public List<RelationEntity> getFollowedList() {
		return followedList;
	}

	public void setFollowedList(List<RelationEntity> followedList) {
		this.followedList = followedList;
	}

}
