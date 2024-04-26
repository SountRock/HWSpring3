package com.example.HWSpring3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.example.HWSpring3.domain")
public class HwSpring3Application {

	public static void main(String[] args) {
		SpringApplication.run(HwSpring3Application.class, args);
	}

}
