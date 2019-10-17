package com.weblabs.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebLab1Application extends SpringBootServletInitializer{

	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebLab1Application.class);
    }
	
	public static void main(String[] args) {
	       SpringApplication.run(WebLab1Application.class, args);
	}

}
