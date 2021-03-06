package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.order")
@Configuration
public class OrderSystemApplication extends SpringBootServletInitializer {

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(OrderSystemApplication.class);
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(OrderSystemApplication.class, args);
	}
}
