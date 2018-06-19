package org.ytu.kemik.crawler.twitter.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TWITTER_USER_RELATION", schema = "crawler", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "FOLLOWER_ID", "FOLLOWED_ID" }) })
public class RelationEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "FOLLOWER_ID", nullable = false)
	private PersonEntity follower;

	@ManyToOne
	@JoinColumn(name = "FOLLOWED_ID", nullable = false)
	private PersonEntity followed;

	public RelationEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonEntity getFollower() {
		return follower;
	}

	public void setFollower(PersonEntity follower) {
		this.follower = follower;
	}

	public PersonEntity getFollowed() {
		return followed;
	}

	public void setFollowed(PersonEntity followed) {
		this.followed = followed;
	}

}
