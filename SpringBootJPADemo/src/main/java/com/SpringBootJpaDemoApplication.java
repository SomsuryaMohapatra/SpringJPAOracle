package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDemoApplication.class, args);
		System.out.println("Connected !!!");
	}
	
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com")).build();
	}

	//http://localhost:8080/swagger-ui/index.html
}
