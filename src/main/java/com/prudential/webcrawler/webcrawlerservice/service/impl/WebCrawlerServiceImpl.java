package com.prudential.webcrawler.webcrawlerservice.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import com.prudential.webcrawler.webcrawlerservice.service.WebCrawlerService;

@Service
public class WebCrawlerServiceImpl implements WebCrawlerService{
	
	private Set<String> scannedUrl = new HashSet<>();
	private int i = 0;
	private Map<String, List<String>> siteMap = new HashMap<>();
	private List<String> sameDomainUrl = new ArrayList<>();
	private List<String> differentDomainUrl = new ArrayList<>();
	private List<String> staticUrl = new ArrayList<>();
	
	@Override
	public Map<String, List<String>> getCrawlerRawData(String url) {
		
		try {
			
			if(!scannedUrl.contains(url)) {
				scannedUrl.add(url);
				Connection connection = Jsoup.connect(url);
				connection.ignoreContentType(true);
				Response response = connection.execute();
				String contentType=response.contentType();
				
				System.out.println(i+".url : "+url);
				if(contentType.contains("text/html")) {
					//This is a valid html url
					//prudential.co.uk
					if(url.contains("prudential.co.uk")) {
						sameDomainUrl.add(url);
					}
					
					Document document = response.parse();
					//get all links and recursively call the getCrawlerRawData method
					Elements questions = document.select("a[href]");
					for(Element link: questions){
						url = link.absUrl("href");
						if(url.contains("prudential.co.uk")) {
							i++;
							getCrawlerRawData(link.absUrl("href"));
						}else if(url != null && !url.equals("")){
							differentDomainUrl.add(url);
						}
							
					}
				}else if(!url.equals("")){
					staticUrl.add(url);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		siteMap.put("sameDomain", sameDomainUrl);
		siteMap.put("differentDomain", differentDomainUrl);
		siteMap.put("static", staticUrl);
		return siteMap;
		
	}
	
	
	
	public static void main(String args []) {
	//	new WebCrawlerServiceImpl().getCrawlerRawData(url);
	}

}
