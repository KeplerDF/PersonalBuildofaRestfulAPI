package com.example.ResfulAPIdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DemoApplication{
	
	
//	This acts as the executable and the Springbootapplication annotation finds all the controllers as well as setting the default configuration.
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
