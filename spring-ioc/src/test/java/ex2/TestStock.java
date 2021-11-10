package ex2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ex1.hello;

public class TestStock {

	@Test
	public static void TestStock()
	{
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ex2ctx.xml");
		stock s1 = (stock) appCtx.getBean("stk");
		
		stock s2 = appCtx.getBean(stock.class,"stk");
		
		System.out.println(s1==s2);
		
	}
}
