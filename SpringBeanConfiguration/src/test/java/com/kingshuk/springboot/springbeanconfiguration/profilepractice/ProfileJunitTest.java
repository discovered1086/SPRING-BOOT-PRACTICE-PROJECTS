package com.kingshuk.springboot.springbeanconfiguration.profilepractice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.kingshuk.springboot.springbootprofiles.beans.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ProfileJunitTest {
	
	
	@Autowired
	private Resource resource;

	@Test
	public void testResourceProfile() {
		assertNotNull(resource);
	}
	
	@Test
	public void testResourceProfileData() {
		assertEquals("https://www.kingshuk-dev.com", resource.getResourceUrl());
	}

}
