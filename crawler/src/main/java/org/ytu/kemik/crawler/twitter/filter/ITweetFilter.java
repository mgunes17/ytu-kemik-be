package org.ytu.kemik.crawler.twitter.filter;

import java.util.function.Predicate;

import org.ytu.kemik.crawler.twitter.dao.entity.MainTweetEntity;

public interface ITweetFilter extends Predicate<MainTweetEntity> {

}
