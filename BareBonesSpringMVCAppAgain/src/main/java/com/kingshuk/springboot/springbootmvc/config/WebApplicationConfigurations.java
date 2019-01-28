package com.kingshuk.springboot.springbootmvc.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

import com.kingshuk.springboot.springbootmvc.interceptors.GlobalInterceptors;
import com.kingshuk.springboot.springbootmvc.validator.DateConverter;
import com.kingshuk.springboot.springbootmvc.validator.DateToStringConverter;
import com.kingshuk.springboot.springbootmvc.validator.EmployeeConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebApplicationConfigurations implements WebMvcConfigurer{
	
	@Bean
    public ConversionService getConversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    @SuppressWarnings("rawtypes")
	private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();

        converters.add(new DateConverter());
        converters.add(new DateToStringConverter());
        converters.add(new EmployeeConverter());

        return converters;
    }

	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new GlobalInterceptors()).addPathPatterns("/employee/**");
	}*/

	/*@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}*/
	
	
	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    

}
