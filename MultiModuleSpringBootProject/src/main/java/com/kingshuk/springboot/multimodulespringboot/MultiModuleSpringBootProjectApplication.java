package com.kingshuk.springboot.multimodulespringboot;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kingshuk.springboot.multimodulespringboot.dtos.AccountDto;
import com.kingshuk.springboot.multimodulespringboot.dtos.CreditCardAccountDto;
import com.kingshuk.springboot.multimodulespringboot.entities.Account;
import com.kingshuk.springboot.multimodulespringboot.entities.CreditCardAccount;

@SpringBootApplication
public class MultiModuleSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiModuleSpringBootProjectApplication.class, args);
	}
	
	/*@Bean(name= "beanMappingBuilder")
	public BeanMappingBuilder beanMappingBuilder() {
		return new BeanMappingBuilder() {
						
			@Override
			protected void configure() {
				
				mapping(AccountDto.class, Account.class)
					.fields("accId", "accountId")
					.fields("accNumber", "accountNumber")
					.fields("accTitle", "accountDesc")
					.fields("accHolder", "accountHolder");
				
				mapping(CreditCardAccountDto.class, CreditCardAccount.class)
				.fields("cardNumber", "creditCardNumber")
				.fields("cardNetWork", "netWork");
			}
		};
		
	}*/
	
	@Bean(name="dozerBeanMapper")
	public DozerBeanMapper dozerBeanMapper() {
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		
		//dozerBeanMapper.addMapping(beanMappingBuilder());
		
		return dozerBeanMapper;
	}

}

