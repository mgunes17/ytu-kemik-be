package org.ytu.kemik.crawler.twitter.dao.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("intact_tweet")
public class IntactTweetEntity {

	@PrimaryKey
	@Column("id")
	private Long id;

	@Column("tweet")
	private String tweet;

	@Column("screen_name")
	private String screenName;

	@Column("username")
	private String userName;

	@Column("favorite_count")
	private int favoriteCount;

	@Column("retweet_count")
	private int retweetCount;

	@Column("created_date")
	private LocalDateTime createdDate;

	@Column("is_favorited")
	private boolean isFavorited;

	@Column("is_retweeted")
	private boolean isRetweeted;

	@Column("is_retweet")
	private boolean isRetweet;

	@Column("lang")
	private String lang;

	@Column("crawled_date")
	private LocalDateTime crawledDate;

	@Column("labeled_project_name")
	private Set<String> projectNameSet;

	public IntactTweetEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public int getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isFavorited() {
		return isFavorited;
	}

	public void setFavorited(boolean isFavorited) {
		this.isFavorited = isFavorited;
	}

	public boolean isRetweeted() {
		return isRetweeted;
	}

	public void setRetweeted(boolean isRetweeted) {
		this.isRetweeted = isRetweeted;
	}

	public boolean isRetweet() {
		return isRetweet;
	}

	public void setRetweet(boolean isRetweet) {
		this.isRetweet = isRetweet;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public LocalDateTime getCrawledDate() {
		return crawledDate;
	}

	public void setCrawledDate(LocalDateTime crawledDate) {
		this.crawledDate = crawledDate;
	}

	public Set<String> getProjectNameSet() {
		return projectNameSet;
	}

	public void setProjectNameSet(Set<String> projectNameSet) {
		this.projectNameSet = projectNameSet;
	}
}
