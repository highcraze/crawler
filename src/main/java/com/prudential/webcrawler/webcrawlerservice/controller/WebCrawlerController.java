package com.prudential.webcrawler.webcrawlerservice.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prudential.webcrawler.webcrawlerservice.service.WebCrawlerService;
import com.prudential.webcrawler.webcrawlerservice.util.Constants;


@RestController
public class WebCrawlerController {
	
	@Autowired
	WebCrawlerService webCrawlerService;
	
	@GetMapping("/web-crawler")
	public Map<String, List<String>> getCrawlerSiteMap() {
		
		return webCrawlerService.getCrawlerRawData(Constants.MAIN_URL);
		
	}
	
}
