package com.example.zipkinorderserver.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // RestTemplateBuilder automatically adds Micrometer tracing interceptors
        return builder.build();
	}

}
