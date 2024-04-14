package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestMicroservicesApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestMicroservicesApplication.class);

	@Value("${quoters_base_url}")
	private String quotersBaseUrl;

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestMicroservicesApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			// Fetch and log quotes from the RESTful service
			log.info(restTemplate.getForObject(quotersBaseUrl + "/api/random", Quote.class).toString());
			log.info(restTemplate.getForObject(quotersBaseUrl + "/api/1", Quote.class).toString());
			log.info(restTemplate.getForObject(quotersBaseUrl + "/api/2", Quote.class).toString());
			log.info(restTemplate.getForObject(quotersBaseUrl + "/api/3", Quote.class).toString());
		};
	}
}