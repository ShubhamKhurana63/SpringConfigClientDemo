package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

import com.mongodb.MongoClient;

@Configuration
public class BeanConfig {
	
	
	/*@Value("${host}")
	private String host;*/
	/*@Value("${name}")
	private String name;
	@Value("${port}")
	private String port;*/

	@Autowired
	Environment environment;
	
	
	
	@Bean(name = "mongoTemplate")
	public MongoTemplate getMongoTemplate() {
	//	System.out.println("===============" + host);
//		System.out.println("===============" + name);
	//	System.out.println("===============" + port);
		MongoTemplate mongoTemplate = null;
			mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"), environment.getProperty("name"));
		
		return mongoTemplate;
	}

	

	@Bean(name="restTemplate")
	public RestTemplate getRestTemplate()
	{
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate;
	}
	
	
	
	
	
	
	
	
}
