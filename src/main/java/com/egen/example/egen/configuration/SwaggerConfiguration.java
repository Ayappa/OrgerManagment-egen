package com.egen.example.egen.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Log4j2
public class SwaggerConfiguration {
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiDetails())
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.egen.example.egen.controller"))
				.build();
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				" admin API",
				"Represents CRUD operations",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Ayppa", "", ""),
				"API License",
				"http://google.com",
				Collections.emptyList());
	}
}
