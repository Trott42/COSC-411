package com.secure.TestSoftwareSolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@ComponentScan(basePackages = "com.secure.TestSoftwareSolutions") // Adjust the package name accordingly

public class TestSoftwareSolutionsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSoftwareSolutionsBackendApplication.class, args);
	}

}
