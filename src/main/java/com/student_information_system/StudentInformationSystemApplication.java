package com.student_information_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentInformationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInformationSystemApplication.class, args);
	}
	@Bean
	public PasswordEncoder Encoder() {
		return new BCryptPasswordEncoder();
	}
}
