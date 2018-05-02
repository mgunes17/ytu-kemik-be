package org.ytu.kemik.crawler.common.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ytu.kemik.crawler.common.service.DataSourceService;
import org.ytu.kemik.crawler.common.web.response.DataSourceTypeResponse;

@RestController
@RequestMapping("/data-sources")
public class DataSourceController {

	@Autowired
	private DataSourceService dataSourceService;

	@GetMapping
	public List<DataSourceTypeResponse> getDataSourceTypes() {
		return dataSourceService.getDataSources();
	}
}
