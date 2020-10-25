package com.kingshuk.webservices.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RangaRestWebservicesCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RangaRestWebservicesCourseApplication.class, args);
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
