package com.xuzz.study.eurekaclientdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientDemo1Application.class, args);
	}
}
