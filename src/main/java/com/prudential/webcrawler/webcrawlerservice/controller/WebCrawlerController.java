package com.prudential.webcrawler.webcrawlerservice.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prudential.webcrawler.webcrawlerservice.service.impl.WebCrawlerServiceImpl;

@RestController
public class WebCrawlerController {
	
	@Autowired
	WebCrawlerServiceImpl webCrawlerService;
	
	@GetMapping("/web-crawler")
	public Map<String, List<String>> getCrawlerSiteMap() {
		
		return webCrawlerService.getCrawlerRawData("https://www.prudential.co.uk/");
		
	}
	
}
