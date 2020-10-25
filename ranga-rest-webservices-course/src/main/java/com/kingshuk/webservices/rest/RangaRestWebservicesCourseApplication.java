package com.kingshuk.webservices.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public Docket apiDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2);
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
