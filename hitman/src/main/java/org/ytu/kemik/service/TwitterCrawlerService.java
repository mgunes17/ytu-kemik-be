package org.ytu.kemik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ytu.kemik.external.crawler.client.CrawlerExternalService;
import org.ytu.kemik.external.crawler.response.TweetCollectingResponse;

import com.netflix.client.ClientException;

@Service
public class TwitterCrawlerService {

	@Autowired
	private CrawlerExternalService crawlerExternalService;

	public void triggerForTwitter() {
		String[] hashtagArr = { "kalem", "defter", "okul" };

		while (true) {
			for (String hashtag : hashtagArr) {
				try {
					Thread.sleep(5000);
					TweetCollectingResponse response = crawlerExternalService.getTweetsByHashTag(hashtag, 20);
					System.out.println("-----------------------------------------");
					System.out.println(hashtag + " için " + response.getTweetCount() + " adet tweet kaydedildi");
					System.out.println("-----------------------------------------");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception ex) {
					System.out.println("-----------------------------------------");
					System.out.println("Bir hata meydana geldi." + ex.getMessage());
					System.out.println("-----------------------------------------");
				}
			}
		}

	}

}
