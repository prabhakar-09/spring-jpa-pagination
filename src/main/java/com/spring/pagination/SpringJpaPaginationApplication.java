package com.spring.pagination;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

@SpringBootApplication
public class SpringJpaPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPaginationApplication.class, args);
	}
	
//	@Bean // Since this class in the end is a configuration class it will scan for the beans first inside of this one 
//	CommandLineRunner commandLineRunner() {
//		   // Define a CommandLineRunner bean to execute tasks at application startup
//        return args -> {
//            // This code block will be executed on application startup
//            System.out.println("Running command line runner on start");
//        };
//	}
	
	@Bean
	Faker faker() {
		return new Faker();
	}

}
