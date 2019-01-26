package com.prudential.webcrawler.webcrawlerservice.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface WebCrawlerService {
	
	public Map<String, List<String>> getCrawlerRawData(String url);
	
}
