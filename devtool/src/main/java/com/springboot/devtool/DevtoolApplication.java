package com.springboot.devtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DevtoolApplication {

	@RequestMapping("/test")
	public String test() {
		int a = 10;
		int b = 10;
		int c = 10;

		// return "The sum of " + a + " and " + b + "is " + (a + b);
		return "The sum of " + a + " " + b + " and " + c + " is " + (a + b + c);
	}

	public static void main(String[] args) {
		SpringApplication.run(DevtoolApplication.class, args);
	}

}
