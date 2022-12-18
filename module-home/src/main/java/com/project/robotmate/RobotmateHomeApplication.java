package com.project.robotmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.EntityManager;

@EnableAsync
@SpringBootApplication
public class RobotmateHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotmateHomeApplication.class, args);
	}



}
