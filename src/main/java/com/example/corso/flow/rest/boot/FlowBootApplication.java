package com.example.corso.flow.rest.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.corso.flow.config.back",
		"com.example.corso.flow.rest.controller" })
public class FlowBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowBootApplication.class, args);
	}
}
