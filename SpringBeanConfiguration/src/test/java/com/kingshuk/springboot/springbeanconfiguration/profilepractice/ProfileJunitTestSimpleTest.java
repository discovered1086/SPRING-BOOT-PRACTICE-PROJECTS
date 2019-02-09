package com.kingshuk.springboot.springbeanconfiguration.profilepractice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.kingshuk.springboot.springbootprofiles.beans.Resource;
import com.kingshuk.springboot.springbootprofiles.configurations.CommonConfigurations;

public class ProfileJunitTestSimpleTest {

	@Test
	public void testResourceProfile() {
		final AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(
				CommonConfigurations.class);

		final ConfigurableEnvironment configurableEnvironment = configApplicationContext.getEnvironment();

		configurableEnvironment.setActiveProfiles("dev");
		configApplicationContext.refresh();

		final Resource resource = configApplicationContext.getBean(Resource.class);

		assertNotNull(resource);

		assertEquals("https://www.kingshuk-prod.com", resource);

		configApplicationContext.close();

	}

}
