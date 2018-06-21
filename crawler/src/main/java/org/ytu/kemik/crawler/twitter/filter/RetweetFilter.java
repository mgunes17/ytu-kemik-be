package org.ytu.kemik.crawler.twitter.filter;

import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;

public class RetweetFilter implements ITweetFilter {

	public boolean test(MainTweetEntity t) {
		return t.getTweet().startsWith("RT");
	}

}
