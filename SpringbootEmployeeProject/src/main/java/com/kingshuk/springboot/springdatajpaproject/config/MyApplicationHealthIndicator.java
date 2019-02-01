package com.kingshuk.springboot.springdatajpaproject.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return Health.up().withDetail("UP", "My application is up and running").build();
	}

}
