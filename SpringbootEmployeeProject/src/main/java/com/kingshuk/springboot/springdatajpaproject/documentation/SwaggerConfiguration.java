package com.kingshuk.springboot.springdatajpaproject.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket getSwaggerDocket() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.kingshuk.springboot.springdatajpaproject"))
				// .paths(path-> path.contains("/"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot Employee REST API")
				.description("This is a spring boot REST API practice project")
				.termsOfServiceUrl("Open source practice project")
				.contact(new Contact("Kingshuk Mukherjee",
						"http://localhost:9090/SpringBootEmployeeProject/swagger-ui.html", "sly.mania42@gmail.com"))
				.version("1.5").build();
	}

}
