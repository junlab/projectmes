package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@SpringBootConfiguration
@ComponentScan("com.example.*")
public class Testmes2Application {

	public static void main(String[] args) {
		SpringApplication.run(Testmes2Application.class, args);
	}

}
