package org.ytu.kemik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.ytu.kemik.service.TwitterCrawlerService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class HitmanApplication implements CommandLineRunner {

	@Autowired
	private TwitterCrawlerService twitterCrawlerService;

	public static void main(String[] args) {
		SpringApplication.run(HitmanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		twitterCrawlerService.triggerForTwitter();
	}

}
