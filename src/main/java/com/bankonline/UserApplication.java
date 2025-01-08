package com.bankonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserApplication {

  @Bean
  public RestTemplate createRestTemplate(){

    return new RestTemplate();
  }

  public static void main(String[] args) {

    SpringApplication.run(UserApplication.class);
  }
}
