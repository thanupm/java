package ex5;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHello {

	@Test
	public void TestMessage() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		hello h = (hello) appCtx.getBean("hi");
		
		System.out.println("Message:" + h.getMessage());
	}
}
