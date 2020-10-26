package com.kingshuk.webservices.rest;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RangaRestWebservicesCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RangaRestWebservicesCourseApplication.class, args);
	}

	@Bean
	public Docket apiDocumentation() { // @formatter:off
		HashSet<String> formats = new HashSet<>(Arrays.asList(MediaType.APPLICATION_JSON.toString(), 
					MediaType.APPLICATION_XML.toString()));
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.produces(formats)
				.consumes(formats);
	// @formatter:on

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Microservices course with Ranga Karanam")
				.description("This is a spring boot REST API practice project")
				.termsOfServiceUrl("Open source practice project").contact(new Contact("Kingshuk Mukherjee",
						"http://localhost:8080/swagger-ui/index.html", "sly.mania42@gmail.com"))
				.version("1.0").build();
	}

//	@Bean
//	public LocaleResolver getLocaleResolver() {
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//		localeResolver.setDefaultLocale(Locale.US);
//		return localeResolver;
//	}

//	@Bean
//	public LocaleResolver getLocaleResolver() {
//		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
//		localeResolver.setDefaultLocale(Locale.US);
//		return localeResolver;
//	}

//	@Bean(name = "messageSource")
//	public ResourceBundleMessageSource getMyMessageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}

}
