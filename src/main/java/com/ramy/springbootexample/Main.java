package com.ramy.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Main {
	//we are using the N-Tier design pattern in this project
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
