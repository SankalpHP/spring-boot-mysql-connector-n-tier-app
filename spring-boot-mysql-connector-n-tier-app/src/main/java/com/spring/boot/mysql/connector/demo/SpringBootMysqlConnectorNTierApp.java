package com.spring.boot.mysql.connector.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMysqlConnectorNTierApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlConnectorNTierApp.class, args);
		System.out.println("Spring boot n-tier app with JDBC connectivity and MySQL works!");
	}

}
