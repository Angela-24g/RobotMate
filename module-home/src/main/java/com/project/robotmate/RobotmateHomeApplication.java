package com.project.robotmate;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManager;

@EnableAsync
@SpringBootApplication
@EntityScan(basePackages = {"com.project.robotmate.domain"})
@EnableJpaAuditing
public class RobotmateHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotmateHomeApplication.class, args);
	}

	@Bean
	public JPAQueryFactory queryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}

//	@Bean
//
//	public InternalResourceViewResolver setupViewResolver() {
////		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
////		resolver.setPrefix("/WEB-INF/");
////		resolver.setSuffix(".jsp");
//
////		return resolver;
//
//	}

}
