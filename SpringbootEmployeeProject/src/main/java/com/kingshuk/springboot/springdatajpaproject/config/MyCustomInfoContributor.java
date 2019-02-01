package com.kingshuk.springboot.springdatajpaproject.config;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.info.InfoContributor;

@Component
public class MyCustomInfoContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("Developed by", "Kingshuk Mukherjee");
	}

}
