package org.ytu.kemik.crawler.twitter.filter;

import java.io.IOException;

import org.ytu.kemik.crawler.common.filter.LanguageFilter;
import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;

public class TweetLanguageFilter implements ITweetFilter {

	LanguageFilter lf;
	
	public TweetLanguageFilter() throws IOException {
		lf = new LanguageFilter("tr");
	}
	
	public boolean test(MainTweetEntity t) {
		return !lf.test(t.getTweet());
	}

}
