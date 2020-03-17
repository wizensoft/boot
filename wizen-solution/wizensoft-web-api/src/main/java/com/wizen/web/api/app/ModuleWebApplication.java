package com.wizen.web.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.example")
//@ComponentScan(basePackages = {"org.bitbucket.tek.nik.simplifiedswagger", "eg.sample"})
//@ComponentScan(basePackages = {"com.wizen.web.api.pages"})
//@ComponentScan("com.wizen.web.api.pages")
public class ModuleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleWebApplication.class, args);
	}

}