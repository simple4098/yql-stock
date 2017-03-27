package com.yql.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class YqlStockSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(YqlStockSystemApplication.class, args);
	}
}
