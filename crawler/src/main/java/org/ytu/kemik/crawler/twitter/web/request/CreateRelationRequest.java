package org.ytu.kemik.crawler.twitter.web.request;

import javax.validation.constraints.NotNull;

public class CreateRelationRequest {

	@NotNull
	private String screenName;

	@NotNull
	private Integer count;

	public CreateRelationRequest() {
		super();
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
