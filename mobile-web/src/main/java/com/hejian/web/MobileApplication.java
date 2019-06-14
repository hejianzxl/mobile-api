package com.hejian.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.hejian.mobile.client.mapper")
public class MobileApplication {
	public static void main(String[] args) {
		SpringApplication.run(MobileApplication.class, args);
		System.out.println("application server is run success!");
	}
}
