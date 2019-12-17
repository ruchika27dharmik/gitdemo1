package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Ws2UiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ws2UiApplication.class, args);
	}
	
	@Bean
	public RestTemplate rTemp()
	{
		RestTemplate rs=new RestTemplate();
		return rs;
	}

}
