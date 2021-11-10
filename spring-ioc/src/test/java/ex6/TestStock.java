package ex6;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestStock {

	@Test
	public void TestStock()
	{
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		stock s1 = (stock) appCtx.getBean("stk");
		
		stock s2 = appCtx.getBean(stock.class,"stk");
		
		System.out.println(s1==s2);
		
	}
}
