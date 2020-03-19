package com.wizen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.example")
public class ModuleWebApplication {

	public static void main(String[] args) {
		
		System.out.println("ModuleWebApplication ##");
		
		SpringApplication.run(ModuleWebApplication.class, args);
	}

}