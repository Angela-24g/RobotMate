package com.project.robotmate;

import com.project.robotmate.admin.global.aop.AuthAop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class RobotmateAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotmateAdminApplication.class, args);
	}


}
