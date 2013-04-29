package edu.neumont.java3;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration(locations = {"beans.xml"})
public class EspionageServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired EspionageService Service;
	@Test
	public void test() {
		String response = Service.crack((long) 5);
		System.out.println(response);
		Assert.assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><container><id>5</id><yourlist>5</yourlist></container>", response);
	}
}
