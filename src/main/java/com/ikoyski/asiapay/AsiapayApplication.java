package com.ikoyski.asiapay;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({ "com.ikoyski.asiapay" })
public class AsiapayApplication {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
  
  public static void main(String[] args) {
    SpringApplication.run(AsiapayApplication.class, args);
  }

}
