package edu.neumont.java3;

import java.math.BigInteger;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration(locations = {"beans.xml"})
public class EspionageServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired EspionageService Service;
	@Test
	public void test() throws Exception {
		String response = Service.crack(BigInteger.valueOf(6L), BigInteger.valueOf(5L));
		System.out.println(response);
		Assert.assertEquals("N = 6 D = 1", response);
		Long start = System.currentTimeMillis();
		while(System.currentTimeMillis() - start < 60000){
			Thread.sleep(100);
			Random r = new Random();
			Long val = r.nextLong();
			while(val <0) val = r.nextLong();
			Assert.assertEquals("N = 3233 D = 2753", Service.crack(new BigInteger("3233"),BigInteger.valueOf(17L)));
		}
	}
}
