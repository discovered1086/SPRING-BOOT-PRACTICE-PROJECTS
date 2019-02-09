package com.kingshuk.springboot.springbeanconfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kingshuk.springboot.springbeanconfiguration.joiningconditionals.CommonConfig;



@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@ComponentScan(basePackages="com.kingshuk.springboot.springbeanconfiguration.joiningconditionals")
public class SpringBeanConfigurationApplicationTests2 {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	@Qualifier("secondCommonConfig")
	private CommonConfig commonConfig;
	
	@Test
	public void testConfigurationVailability() {
		assertNotNull(commonConfig);
	}
	
	@Test
	public void testConfigurationProperty() {
		assertNotNull(environment.getProperty("propertycheck.enabled"));
	}
	
	@Test
	public void testConfigurationProfile() {
		assertEquals("dev", environment.getActiveProfiles()[0]);
	}

}

