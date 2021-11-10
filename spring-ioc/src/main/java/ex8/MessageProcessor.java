package ex8;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor{
	
	
	
	public MessageProcessor() {
		System.out.println("Meaage Processor Constructor");
	}
	@Autowired
	private ApplicationContext ctx;

	
	public void process(String type,String to, String msg)
	{
		Message m = (Message) ctx.getBean(type);
		m.send(to, msg);
	}
	

}
