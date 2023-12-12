package com.tutorpets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.tutorpets")
@SpringBootApplication
public class TutorPetsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorPetsApiApplication.class, args);
	}

}
