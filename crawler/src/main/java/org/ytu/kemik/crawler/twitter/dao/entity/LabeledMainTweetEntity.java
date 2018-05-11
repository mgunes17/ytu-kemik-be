package org.ytu.kemik.crawler.twitter.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "labeled_main_tweet", schema = "crawler", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "project_name", "main_tweet_id" }) })
@SequenceGenerator(name = "common_sequence", sequenceName = "common_sequence", allocationSize = 1)
public class LabeledMainTweetEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "project_name", nullable = false)
	private String projectName;

	@ManyToOne
	@JoinColumn(name = "main_tweet_id", nullable = false)
	private MainTweetEntity mainTweet;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	public LabeledMainTweetEntity() {
		super();
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MainTweetEntity getMainTweet() {
		return mainTweet;
	}

	public void setMainTweet(MainTweetEntity mainTweet) {
		this.mainTweet = mainTweet;
	}

}
