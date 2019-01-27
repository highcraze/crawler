Web Crawler -

How to Run -
This is a simple Spring boot Application. I have created a service that returns the sitemap as a JSON.
1. Clone the github project on IDE - https://github.com/highcraze/crawler
2. Run the Main class of the project - com.prudential.webcrawler.webcrawlerservice.WebCrawlerServiceApplication
3. Open browser and enter URL - http://localhost:8000/web-crawler

Testing -
I'm not sure how long it takes to crawl prudential portal as there are too many links and static content, but i carried out manual testing with other smaller portals and the code works perfectly fine as per the requirements.

Scope for improvement provided more time -
1. I find the application is tightly coupled with the filters provided in the requirement are hard coded into the method. The reason is recursive loop becomes complicated if filters are to be injected into the crawler.
2. Since crawling an enormous task load balancers like Ribbon, Eureka Naming Servers and Zuul API gateway can be used to create multiple instances of this service.
3. I have created a local variable to store already scanned urls, a database would be ideal to store them. However some websites like wikipedia often change their content thus there should be some configuartion to rescan these urls. 