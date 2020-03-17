package com.wizen.web.api.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.Collections;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration 
//@SpringBootApplication
@EnableSwagger2
public class SwaggerDemoApplication 
{
	
	
	/*
   public static void main(String[] args) {
      SpringApplication.run(SwaggerDemoApplication.class, args);
   }
   */
   @Bean
   public Docket api() {
	   /*
      return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("com.wizen.web.api.pages")).build();
         */
	   return new Docket(DocumentationType.SWAGGER_2).select()
		         .apis(RequestHandlerSelectors.basePackage("com.wizen.web.api.pages")).paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());//.enable(true);
		
	   /*return new Docket(DocumentationType.SWAGGER_2)
               .select()
               .apis(RequestHandlerSelectors.any())
               .paths(PathSelectors.ant("/api**"))
               .build();
               */
	   /*
	   return new Docket(DocumentationType.SWAGGER_2)
               .select()
               .apis(RequestHandlerSelectors.any())
               .paths(PathSelectors.any())
               .build().apiInfo(apiEndPointsInfo());
               */
               
   }
   
   private ApiInfo apiEndPointsInfo() {
       return new ApiInfoBuilder().title("aabbcc1 Spring Boot REST API")
           .description("aabbcc2 Employee Management REST API")
           .contact(new Contact("aabbcc3 Ramesh Fadatare", "www.javaguides.net", "ramesh24fadatare@gmail.com"))
           .license("aabbcc4 Apache 2.0")
           .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
           .version("1.0.0")
           .build();
   }
   

   
   
   
   

}