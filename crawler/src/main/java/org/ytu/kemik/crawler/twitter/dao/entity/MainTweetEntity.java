package org.ytu.kemik.crawler.twitter.dao.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "main_tweet", schema = "crawler")
public class MainTweetEntity {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "tweet", nullable = false)
	private String tweet;

	@Column(name = "screen_name", nullable = false)
	private String screenName;

	@Column(name = "username", nullable = false)
	private String userName;

	@Column(name = "favorite_count")
	private int favoriteCount;

	@Column(name = "retweet_count")
	private int retweetCount;

	@Column(name = "tweeted_date")
	private Date tweetedDate;

	@Column(name = "is_favorited")
	private boolean isFavorited;

	@Column(name = "is_retweeted")
	private boolean isRetweeted;

	@Column(name = "is_retweet")
	private boolean isRetweet;

	@Column(name = "lang")
	private String lang;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@OneToMany(cascade = CascadeType.REMOVE)
	private Set<LabeledMainTweetEntity> labeledMainEntitySet;

	public MainTweetEntity() {
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
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

	public Date getTweetedDate() {
		return tweetedDate;
	}

	public void setTweetedDate(Date tweetedDate) {
		this.tweetedDate = tweetedDate;
	}

}
