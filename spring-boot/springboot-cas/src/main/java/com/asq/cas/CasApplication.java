package com.asq.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasApplication.class, args);
	}
}
