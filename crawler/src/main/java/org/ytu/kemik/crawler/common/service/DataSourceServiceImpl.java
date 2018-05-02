package org.ytu.kemik.crawler.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.ytu.kemik.crawler.common.constant.DataSourceType;
import org.ytu.kemik.crawler.common.web.response.DataSourceTypeResponse;

@Service
public class DataSourceServiceImpl implements DataSourceService {

	@Override
	public List<DataSourceTypeResponse> getDataSources() {
		DataSourceTypeResponse source1 = new DataSourceTypeResponse(DataSourceType.TWITTER.toString());
		List<DataSourceTypeResponse> sourceList = new ArrayList<>();
		sourceList.add(source1);
		return sourceList;
	}

}
