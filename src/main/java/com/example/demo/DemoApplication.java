package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
@RestController
@RefreshScope
public class DemoApplication {
	@Value("${message}")
	private String message;

	@Value("${host}")
	private String host;
	@Value("${name}")
	private String name;
	@Value("${port}")
	private String port;

	@Autowired
	Environment environment;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	MongoTemplate mongoTemplate;

	/*
	 * @PostConstruct public void schedule() {
	 * 
	 * mongoTemplate = new MongoTemplate(new
	 * MongoClient(environment.getProperty("host")),
	 * environment.getProperty(""));
	 * 
	 * }
	 */

	//
	// @Resource
	// MongoTemplate mongoTemplate;

	@RequestMapping(value = "/collection")
	String hello() {
		/*
		 * Set<String> collectionsSet = mongoTemplate.getCollectionNames();
		 * List<String> l1 = new ArrayList<>(collectionsSet);
		 * System.out.println(l1.size()); for (String str1 : l1) {
		 * System.out.println("============>>>>>>>>>>>>" + str1); }
		 */
		// MongoTemplate mongoTemplate = null;
		// mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"),
		// name);
		// return mongoTemplate.getDb().getName();

		// return
		// environment.getProperty("message")+environment.getProperty("name");
		String url = environment.getProperty("node");
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	 * @Override public void onApplicationEvent(EnvironmentChangeEvent arg0) {
	 * // TODO Auto-generated method stub
	 * 
	 * //schedule(); }
	 */
}
