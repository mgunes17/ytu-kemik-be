package org.ytu.kemik.crawler.common.service;

import java.util.List;

import org.ytu.kemik.crawler.common.web.response.DataSourceTypeResponse;

public interface DataSourceService {

	List<DataSourceTypeResponse> getDataSources();

}
