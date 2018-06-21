package org.ytu.kemik.crawler.configuration;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ytu.kemik.crawler.twitter.filter.ITweetFilter;
import org.ytu.kemik.crawler.twitter.filter.RetweetFilter;
import org.ytu.kemik.crawler.twitter.filter.TweetLanguageFilter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class Twitter4JConfiguration {
	private Twitter twitter;

	@Value("${consumer.key}")
	private String consumerKey;

	@Value("${consumer.secret")
	private String consumerSecret;

	@Value("${access.token}")
	private String accessToken;

	@Value("${access.tokenSecret}")
	private String tokenSecret;

	private Twitter buildTwitter() {

		try {

			ConfigurationBuilder cfb = new ConfigurationBuilder();

			cfb.setDebugEnabled(true).setOAuthConsumerKey("3d0rr1LRdAFnP3UhDr2B6ot99")
					.setOAuthConsumerSecret("FqFFaqXS0qnuJnvxKq4qE4BN5tkdqyrqqwcAJ2wtpKMl4gpdef")
					.setOAuthAccessToken("2587971211-jZTTWV4vAinpcAc51eC4nlZFRR4Tw4rudT4BUpm")
					.setOAuthAccessTokenSecret("QuGRTAHW5mE0xaNXIZ6nU6bPXfOeSb0ALe40uasiXMuo8")
					.setTweetModeExtended(true)
					.setIncludeMyRetweetEnabled(false);
			TwitterFactory tf = new TwitterFactory(cfb.build());

			return tf.getInstance();
		} catch (Throwable ex) {
			System.err.println("Could not create:" + ex.getMessage());
			ex.getCause().printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Bean
	public Twitter getInstance() {
		if (twitter == null)
			twitter = buildTwitter();

		return twitter;
	}
	
	@Bean
	public ArrayList<ITweetFilter> getFilters() throws IOException {
		ArrayList<ITweetFilter> filters = new ArrayList<>();
		filters.add(new RetweetFilter());
		filters.add(new TweetLanguageFilter());
		return filters;
	}
}
