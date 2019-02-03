package com.kingshuk.springboot.SpringBootWithInitializr;

import com.kingshuk.springboot.business.SpringBootService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWithInitializrApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

	@Test
	public void testSpringBootApplication() {
        SpringBootService springBootService = applicationContext.getBean(SpringBootService.class);

        springBootService.callPrinting();
    }

}
