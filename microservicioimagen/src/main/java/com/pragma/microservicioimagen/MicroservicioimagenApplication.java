package com.pragma.microservicioimagen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableEurekaClient
@SpringBootApplication
public class MicroservicioimagenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioimagenApplication.class, args);
	}

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}

}
