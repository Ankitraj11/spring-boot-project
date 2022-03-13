package com.te.springbootsecuritycrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.te.springbootsecuritycrud")

public class SpringsecuritycrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritycrudApplication.class, args);
	}

}
