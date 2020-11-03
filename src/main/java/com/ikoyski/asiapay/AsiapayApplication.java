package com.ikoyski.asiapay;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({ "com.ikoyski.asiapay" })
public class AsiapayApplication extends SpringBootServletInitializer {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AsiapayApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AsiapayApplication.class, args);
	}

}
