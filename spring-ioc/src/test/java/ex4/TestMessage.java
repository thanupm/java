package ex4;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMessage {

	@Test
	public void TestSend()
	{
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("ex4ctx.xml");
		
		MessageProcessor mp = (MessageProcessor) appCtx.getBean("mp");
		
		mp.process("sms", "23456898", "Hello good morning");
		mp.process("email", "thanupm1998@gmail.com", "Hello welcome to Spring");
		
	}
}
